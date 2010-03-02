setClass("NormalizeMethodParameter",
         representation=representation(
           probeType="character", # enum { together, pmonly, mmonly, separate }
           method="character" # constant, contrasts, invariantset, loess, qspline, quantiles, quantiles.robust
           ),
         prototype=prototype(
           probeType="separate",
           method="constant"
           ))

setClass("NormalizeInvariantSetParameter",
         representation=representation(
           baselineType="character"),
         contains="NormalizeMethodParameter",
         prototype=prototype(
           method="invariantSet"
           ))

setClass("NormalizeQuantilesRobustParameter",
         representation=representation(
           removeExtreme="character"),  # mean, variance, both
         contains="NormalizeMethodParameter",
         prototype=prototype(
           method="quantilesRobust"
           ))

setClass("ExpressoParameter",
         representation=representation(
           backgroundCorrectMethod = "character", # none, rma, rma2, mas
           normalizeMethodParameter = "NormalizeMethodParameter",
           pmCorrectMethod = "character", # mas, pmonly, subtractmm
           probeSummaryMethod = "character"), # avgdiff, liwong, mas, medianpolish, playerout
         prototype=prototype(
           backgroundCorrectMethod = "rma",
           normalizeMethodParameter = new("NormalizeMethodParameter",
             method="constant"),
           pmCorrectMethod="pmonly",
           probeSummaryMethod="avgdiff"))

caExpresso <- function(bioAssays, cdfName, expressoParameter) {
    args <- as.list(formals(expresso))
    bgcorrectMethod <- slot(expressoParameter, "backgroundCorrectMethod")
    args[["bg.correct"]] <- bgcorrectMethod!="none"
    if (args[["bg.correct"]])
      args[["bgcorrect.method"]] <- bgcorrectMethod
    normalizeMethodParameter <- slot(expressoParameter, "normalizeMethodParameter")
    normalizeMethodName <- slot(normalizeMethodParameter, "method")
    args[["normalize"]] <- normalizeMethodName!="constant"
    if (args[["normalize"]]) {
        args[["normalize.method"]] <-
          switch(class(normalizeMethodParameter),
                 NormalizeInvariantSetParameter={
                     args[["normalize.param"]] <-
                       list(baseline.type=slot(normalizeMethodParameter, "baselineType"))
                     "invariantset"
                 },
                 NormalizeQuantilesRobustParameter={
                     args[["normalize.param"]] <-
                       list(remove.extreme=slot(normalizeMethodParameter, "removeExtreme"))
                     "quantiles.robust"
                 },
                 slot(normalizeMethodParameter, "method") # loess, contrasts, qspline, quantiles
                 )
        args[["normalize.param"]] <- c(list(type=slot(normalizeMethodParameter, "probeType")),
                                      args[["normalize.param"]])
    }
    args[["pmcorrect.method"]] <- slot(expressoParameter, "pmCorrectMethod")
    args[["summary.method"]] <- slot(expressoParameter, "probeSummaryMethod")

    args[["afbatch"]] <- new("AffyBatch", exprs=as(bioAssays, "matrix"), cdfName=cdfName)
    cat("caExpresso", paste(dim(args[["afbatch"]]), collapse=" x "), "\n")
    exprSet <- do.call("expresso", args)
    as(exprSet, "DerivedBioAssays")
}

typeInfo(caExpresso) <- 
    SimultaneousTypeSpecification(
        TypedSignature(bioAssays = "DerivedBioAssays",
                       cdfName = "character",
                       expressoParameter = "ExpressoParameter"),
        returnType = "DerivedBioAssays")
