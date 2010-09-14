library(Rlabkey)
library(iSalmon)

s <- getSession(baseUrl="https://isalmon.fhcrc.org/labkey",
                folderPath="/home/RestrictedData")

## discover schema and joins
schema <- getSchema(s, "lists")
sample <- schema[["clinical_sample_all_OV"]]
head(names(sample))
lkups <- getLookups(s, sample[["BCRPATIENTBARCODE"]])
head(names(lkups))

## Columns to retrieve, including look-ups
cols <- c(names(sample)[c(1, 11)], names(lkups)[26])
cols

df <- getRows(s, sample, colSelect=cols)
names(df)
head(df[[1]])
xtabs(~df[[3]] + is.na(df[[2]]))

## subset: two disease outcomes, with miRNA files
idx0 <-  df[[3]] %in% c("PROGRESSIVE DISEASE", "STABLE DISEASE" )
idx1 <- !is.na(df[[2]])
withMeasuredOutcome <- df[ idx0 & idx1 , ]
table(withMeasuredOutcome[[3]])

## tidy -- rename for miRNATwoGroupDifferentialExpression
names(withMeasuredOutcome)[2:3] <- c("FileName", "Condition")

## So a fresh start?:

s <- getSession(baseUrl="https://isalmon.fhcrc.org/labkey",
                folderPath="/home/SharedData")
schema <- getSchema(s, "lists")
sample <- schema[["GBM_miRNA_Level1_FilesNamesAndSampleIds"]]
head(names(sample))
#lkups <- getLookups(s, sample[["BCRPATIENTBARCODE"]])#none of the fields for these are connected to anything???
#head(names(lkups))

cols <- c(names(sample)[c(3, 5)])
cols

df <- getRows(s, sample, colSelect=cols)
## So lets compare 1As vs 1Bs?
dfa <- df[grep("1A$", df[,1]),]
dfa[,1] <- rep("A",dim(dfa)[1])
dfb <- df[grep("1B$", df[,1]),]
dfb[,1] <- rep("B",dim(dfb)[1])
df <- rbind(dfa,dfb)
names(df)[2:3] <- c("Condition","FileName")

## I need to pass in a targets object here
targs <- new("Targets", FileName=as.character(df[,2]),
             Condition=as.character(df[,1]))

topTable <-
    miRNATwoGroupDifferentialExpression(targs)


##############################################################################

library(iSalmon)
base <- "http://isalmon.fhcrc.org/labkey/files/home/SharedData/"
fls <- c("US14702406_251643612132_S01_miRNA-v1_95_May07_1_1.txt",
         "US14702406_251643612132_S01_miRNA-v1_95_May07_1_2.txt",
         "US14702406_251643612132_S01_miRNA-v1_95_May07_1_4.txt",
         "US14702406_251643612132_S01_miRNA-v1_95_May07_2_1.txt")
end <- "?fileSet=GBM%20miRNA%20Level%201"
targets <- data.frame(FileName=paste(base, fls, end, sep=""),
                      Condition=c("A","A","B","B"))
topTable <-
    miRNATwoGroupDifferentialExpression(targets)

head(topTable)









## Write out the results to the FS so that we can use the GUI to configure for
## storing assays of this type.

write.table(topTable, "limmaResults.txt", sep="\t", na="", quote=FALSE,
            row.names=FALSE)

## Then follow the GUI instructions (1st time only) on pages 4-8 of the
## Rlabkey users guide

RlabkeyUsersGuide()

## Now save the topTable results to the labkey server as assay
## results.

s <- getSession(baseUrl="https://isalmon.fhcrc.org/labkey",
                folderPath="/home/miRNA Analysis")

ipdf <- data.frame(installed.packages(), stringsAsFactors=FALSE)
bprops <- list(LimmaVersion=ipdf["limma", "Version"],
               RlabkeyVersion=ipdf["Rlabkey", "Version"])
bpl <- list(name=paste("Batch ", as.character(date())),
            properties = bprops)

saveResults(s, assayName="LimmaTopTable",
            resultDataFrame=topTable[topTable$B>0, ],
            batchPropertyList= bpl)

