## PROcess -- baseline removal, renormalization, peak identification

## setClass("MzAssays",
##          representation=representation(
##            spectrumName="character",
##            mzRatio="NumericMatrix",
##            intensity="NumericMatrix"),
##          validity=function(object) {
##              len <- length(slot(object, "spectrumName"))
##              if (len != ncol(slot(object, "mzRatio")) ||
##                  len != ncol(slot(object, "intensity")))
##                "spectrumName length must eqal number of columns in mzRatio, intensity"
##              else TRUE
##          })

## setMethod("[[",
##           signature(x="MzAssays"),
##           function(x, i, j, ...) {
##               new("MzAssays",
##                   spectrumName=slot(x, "spectrumName")[[i]],
##                   mzRatio=slot(x, "mzRatio")[,i]
##                   intensity=slot(x, "intensity")[,i])
##           })

setClass("MzSpectrum",
         representation=representation(
           spectrumName="character",
           mzRatio="numeric",
           intensity="numeric"
           ))

setClass("MzAssays",
         contains=c("list"),
         representation=representation(
           listTemplate="MzSpectrum"))

setAs("MzSpectrum", "matrix",
      function(from) matrix(c(slot(from, "mzRatio"), slot(from, "intensity")), ncol=2))

setClass("PROcessParameter",
         representation=representation(
           renormalizationCutoff="numeric", # renorm: cutoff; required; default 1500
           peakSignalToNoiseCutoff="numeric", # isPeak: SoN; default 2
           peakVarianceDetectionSpan="numeric",    # isPeak: span; default 81
           peakSmoothingSpan="numeric", # isPeak: sm.span; default 11
           peakZeroCutoff="numeric", # isPeak: zerothrsh; default 2
           peakAreaNeighborhood="numeric", # isPeak: area.w; default .003
           peakAreaRetention="numeric" # isPeak: ratio; default .2
           ),
         prototype=prototype(
           renormalizationCutoff=1500
           ))

setClass("PeakLocation",
         representation=representation(
           spectrumName="character",
           spectrumId="integer",
           peakNumberInSpectrum="integer",
           relativeIntensity="numeric",
           substanceMassAtIntensity="numeric"
           ))

caPROcess <- function(mzAssays, proCessParameter) {
    ## rmBaseline reads data from disk then calls bslnoff, 1 spectrum
    ## at a time we'll do it in memory
    rmBaselineImpl <- function(mzAssays, method="loess") {
        for (j in seq(along=mzAssays)) {
            bseoff <- bslnoff(as(mzAssays[[j]], "matrix"), method="loess")
            if (j>1)
              bseoffM <- cbind(bseoffM, bseoff[,2])
            else bseoffM <- bseoff[,2]
        }
        dimnames(bseoffM) <- list(signif(bseoff[, 1], 6),
                                  sapply(mzAssays, slot, "spectrumName"))
        bseoffM
    }
    cat("starting caPROcess\n")
    ## rmBaseline & renorm
    mz <- renorm(rmBaselineImpl(mzAssays),
                 cutoff=slot(proCessParameter, "renormalizationCutoff"))
    ## getPeaks
    getPeaksFields <- c("peakSignalToNoiseCutoff", "peakVarianceDetectionSpan",
                        "peakSmoothingSpan", "peakZeroCutoff", "peakAreaNeighborhood",
                        "peakAreaRetention")
    present <- sapply(getPeaksFields,
                      function(fld, obj) length(slot(obj, fld))==1,
                      proCessParameter)
    params <- sapply(getPeaksFields[present],
                     function(fld, obj) slot(obj, fld),
                     proCessParameter)
    peakinfofile=tempfile()             # getPeaks writes data to file; we'll do this too
    params <- list(bseoffM=mz, c(peakinfofile=peakinfofile, unlist(params)))
    do.call("getPeaks", params)
    ## read peakinfofile into PeakLocation
    peaks <- read.table(peakinfofile,
                        header=TRUE, sep=",", 
                        colClasses=c("character", "integer", "integer", "numeric", "numeric"))
    cat("ending caPROcess\n")
    new("PeakLocation",
        spectrumName = peaks[["Spectrum.Tag"]],
        spectrumId = peaks[["Spectrum."]],
        peakNumberInSpectrum = peaks[["Peak."]],
        relativeIntensity = peaks[["Intensity"]],
        substanceMassAtIntensity = peaks[["Substance.Mass"]])
}
    
typeInfo(caPROcess) <-
  SimultaneousTypeSpecification(
    TypedSignature(mzAssays = "MzAssays",
                   proCessParameter = "PROcessParameter"),
    returnType="PeakLocation")
