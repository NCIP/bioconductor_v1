local({
    plmSlots <- getSlots("PLMset")
    plmSlots <- plmSlots[!names(plmSlots) %in%
                         c(".__classVersion__", # not externally relevant
                           "model.call",# cannot be represented
                           "exprs", "se.exprs", # could/should be MAGE
                           "description", # MIAME -- ?unsatisfactory
                           "reporterInfo", "phenoData", # too complicated
                           "probe.coefs", "se.probe.coefs", "chip.coefs", "se.chip.coefs", # probably ok to expose
                           "model.description" # not strictly typed; some elements not representable (env, call)
                           ) ]
    plmSlots <- sub("matrix", "NumericMatrix", plmSlots)
    
    setClass("ProbeLevelLinearModel",
             representation=do.call("representation", as.list(plmSlots)))

    setAs("PLMset",
          "ProbeLevelLinearModel",
          function(from) {
              obj <- lapply(names(plmSlots),
                            function(elt) as(slot(from, elt), plmSlots[[elt]]))
              names(obj) <- names(plmSlots)
              do.call("new", c("ProbeLevelLinearModel", obj))
          })
})

local({
    qcSlots <- getSlots("QCStats")
    qcSlots <- sub("matrix", "NumericMatrix", qcSlots)
    setClass("QualityControlStatistics",
             representation=do.call("representation", as.list(qcSlots)))

    setAs("QCStats",
          "QualityControlStatistics",
          function(from) {
              obj <- lapply(names(qcSlots),
                            function(elt) as(slot(from, elt), qcSlots[[elt]]))
              names(obj) <- names(qcSlots)
              do.call("new", c("QualityControlStatistics", obj))
          })
})

## setClass("QaReport",
##          representation=representation(
##            qualityControlStatistics = "QualityControlStatistics",
##            probeLevelLinearModel = "ProbeLevelLinearModel",
##            madsMatrix = "NumericMatrix",
##            pdfFile = "raw"))

setClass("QaReport",
         representation=representation(
           pdfFile="raw"))

caQAReport <- function(bioAssays, cdfName, chipDimensions)  {
    outdir <- tempfile()
    repName <- "caQAReport"
    output <- "pdf"
    fl <- file.path(outdir, repName, paste(repName, output, sep="."))
    affyBatch <- new("AffyBatch",
                     nrow=chipDimensions[[1]],
                     ncol=chipDimensions[[2]],
                     exprs=as(bioAssays, "matrix"),
                     cdfName=cdfName)
    qcInfo <- affyQAReport(affyBatch,
                           output=output, outdir=outdir, overwrite=TRUE,
                           repName=repName)
##     qaReport <- new("QaReport",
##                     qualityControlStatistics=as(qcInfo$qcStats, "QualityControlStatistics"),
##                     probeLevelLinearModel=as(qcInfo$affyPLM, "ProbeLevelLinearModel"),
##                     madsMatrix=as(qcInfo$MADS, "NumericMatrix"),
##                     pdfFile=readBin(file(fl, "rb"), what="raw", n=file.info(fl)$size))
    qaReport <- new("QaReport",
                    pdfFile=readBin(file(fl, "rb"), what="raw",
                      n=file.info(fl)$size))
    rmQAReport(qcInfo)
    return(qaReport)
}

typeInfo(caQAReport) <- 
    SimultaneousTypeSpecification(
        TypedSignature(bioAssays = "DerivedBioAssays",
                       cdfName = "character",
                       chipDimensions="integer"),
        returnType = "QaReport")
