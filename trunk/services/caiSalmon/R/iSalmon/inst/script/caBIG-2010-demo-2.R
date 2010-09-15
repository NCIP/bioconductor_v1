library(Rlabkey)
library(iSalmon)

url <- "https://isalmon.fhcrc.org/labkey"
## Discover: getSession(url)
folder <- "/home/SpliceVariation/Junctions"
session <- getSession(url, folder)
## Discover: names(session)
schema <- getSchema(session, "splicevar")

## Columns to retrieve
## Disover: names(schema)
dataset <- schema[["solexajunctionscount"]]
## Discover: names(dataset)
cols <- c("chromosomename", "seg_st", "seg_end", "casesum", "controlsum")
df <- getRows(session, dataset, maxRows=10000, colSelect=cols)

## Plot Case - Control vs. (Case + Control) / 2
library(lattice)
df <- within(df, {
    M <- asinh(casesum) - asinh(controlsum)
    A <- (asinh(casesum) + asinh(controlsum)) / 2
})
## Simple
xyplot(M ~ A, df)
## Fancier
xyplot(M ~ A, df,
       main = "Novel Junction Counts (asinh transformed)",
       xlab = "1/2 (Case + Control)",
       ylab = "Case - Control",
       panel = function(...) {
           panel.smoothScatter(...)
           panel.abline(h=0, col="red")
       },
       pch = 20, cex = .2)
