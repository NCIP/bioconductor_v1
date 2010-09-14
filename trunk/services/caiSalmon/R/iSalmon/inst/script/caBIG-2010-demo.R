library(iSalmon)
base <- "http://isalmon.fhcrc.org/labkey/files/home/SharedData/"
end <- "?fileSet=GBM%20miRNA%20Level%201"

fls <- c("US14702406_251643612132_S01_miRNA-v1_95_May07_1_1.txt",
         "US14702406_251643612132_S01_miRNA-v1_95_May07_1_2.txt",
         "US14702406_251643612132_S01_miRNA-v1_95_May07_1_4.txt",
         "US14702406_251643612132_S01_miRNA-v1_95_May07_2_1.txt")

targets <- data.frame(FileName=paste(base, fls, end, sep=""),
                      Condition=c("A","A","B","B"))
topTable <-
    miRNATwoGroupDifferentialExpression(targets)

head(topTable)
