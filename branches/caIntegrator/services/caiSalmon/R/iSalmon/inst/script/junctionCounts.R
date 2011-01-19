## setup
setwd("../extdata")
nbinomFile <- sprintf("solexa-junctions-negative-binomial-%s.csv",
                      format(Sys.time(), "%Y-%b-%d-%I:%m%p"))
source("../../R/junctionMAPlot.R")

## input
conn <- file("solexa-junctions-counts-100120.tsv")
head <- readLines("solexa-junctions-counts-100120.tsv", 1)
head <- strsplit(head, "\t")[[1]]
meta <- read.csv("solexa-junctions-counts-100120.tsv", nrows=2, sep="\t")
tbl <- read.csv("solexa-junctions-counts-100120.tsv",
                skip=2, sep="\t", col.names=head)

pData <- as.data.frame(t(meta[,-(1:8)]))
names(pData) <- meta[,1]
pData[["Status"]] <- factor(c(rep("Control", 7), rep("Case", 26)))

isub <- function(...) as.integer(sub(...))
fData <- with(tbl, {
    cbind(tbl[,1,drop=FALSE],
          data.frame(space=sub(":.*", "", junction),
                     start=isub(".*:([[:digit:]]+).*", "\\1", junction),
                     end=isub(".*-([[:digit:]]+)", "\\1", junction)),
          tbl[,3:8])
})

cnt <- as.matrix(tbl[,-(1:8)])

library(DESeq)
phenoData <- new("AnnotatedDataFrame", data=pData)
featureData <- new("AnnotatedDataFrame", data=fData)
cds0 <- newCountDataSet(cnt, conditions=phenoData$Status,
                        phenoData=phenoData, featureData=featureData)
cds0[["Count", labelDescription="Non-zero hits"]] <-
    colSums(counts(cds0) != 0)
cds0[["Sum", labelDescription="Reads spanning splice junctions"]] <-
    colSums(counts(cds0))

## QA
library(lattice)
xyplot(Count~AlignedReads, group=Status, pData(cds0), pch=20, cex=2)

## drop two lanes
idx <- tail(order(cds0[["AlignedReads"]]), 2)
pData(cds0)[idx,]
cds1 <- cds0[,-idx]
fData(cds1)[["caseCount"]] <-
    rowSums(counts(cds1[,cds1[["Status"]]=="Case"]) > 0)
fData(cds1)[["caseSum"]] <-
    rowSums(counts(cds1[,cds1[["Status"]]=="Case"]))
fData(cds1)[["controlCount"]] <-
    rowSums(counts(cds1[,cds1[["Status"]]=="Control"]) > 0)
fData(cds1)[["controlSum"]] <-
    rowSums(counts(cds1[,cds1[["Status"]]=="Control"]))
head(table(with(fData(cds1), caseSum+controlSum)))
cds2 <- cds1[rowSums(counts(cds1)) != 0,]

xyplot(Count~AlignedReads, group=Status, pData(cds1), pch=20, cex=2,
       type=c("p", "r"), lty=2)
xyplot(Sum~AlignedReads, group=Status, pData(cds1), pch=20, cex=2,
       type=c("p", "r"), lty=2)

xyplot(asinh(caseSum)-asinh(controlSum)~
       (asinh(caseSum)+asinh(controlSum))/2, fData(cds1),
       panel=function(x, y, ...) {
           panel.smoothScatter(x, y, ...)
           panel.abline(h=0, lty=3, col="black")
           i <- sample(seq_along(x), 10000)
           panel.loess(x[i], y[i], ..., col="red")
       }, pch=20)
local({
    df <- with(fData(cds1), {
        idx <- caseSum != 0 & controlSum != 0
        data.frame(Sum=c(caseSum, controlSum),
                   Group=rep(c("Case", "Control"), each=nrow(cds1)))[idx,]
    })
    print(with(fData(cds1), xtabs(~(caseSum==0) + (controlSum == 0))))
    histogram(~asinh(Sum)|Group, df,
              strip=FALSE, strip.left=TRUE, layout=c(1,2),
              xlab="Reads per junction",
              main="Non-zero (case and control) splice junctions")
})
    

hist(asinh(rowSums(counts(cds2))))
local({
    t <- table(rowSums(counts(cds0)))
    JunctionReads <- as.vector(t)
    Occurrences <- as.integer(names(t))
    xyplot(asinh(JunctionReads) ~ asinh(Occurrences))
})

## DESeq
library(DESeq)
cds <- cds2
cds <- estimateSizeFactors(cds)
cds <- estimateVarianceFunctions(cds)
res0 <- nbinomTest(cds, "Control", "Case")
res <- res0[is.finite(res0$log2FoldChange),]

with(res, hist(pval[pval!=1], 100))
junctionMAPlot(log2FoldChange~log2(baseMean), res, res[["padj"]],
               0.01, main="Padj < 0.01")
table((res[["log2FoldChange"]] > 0)[res[["padj"]] < .01])

if (!file.exists(nbinomFile)) {
    idx <- res[["id"]]
    write.csv(cbind(fData(cds)[idx,], res[,-1]), nbinomFile)
}
