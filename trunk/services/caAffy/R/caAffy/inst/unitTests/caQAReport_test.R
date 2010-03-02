

testCaQAReport <- function() {
    library(affydata)
    data(Dilution)
    affyBatch <- Dilution
    dbads <- new("DerivedBioAssays",
                 bioAssays=new("NumericMatrix", exprs(affyBatch)))
    cdfName <- cdfName(affyBatch)
    chipDimensions=as.integer(rep(sqrt(dim(exprs(affyBatch))[[1]]), 2))
    res <- caQAReport(dbads,
                      cdfName(affyBatch),
                      chipDimensions)
    ## minimal size expectations :(
    checkTrue(750000 < length(res@pdfFile))
    checkTrue(45000000 < sum(as.integer(res@pdfFile)))
}
