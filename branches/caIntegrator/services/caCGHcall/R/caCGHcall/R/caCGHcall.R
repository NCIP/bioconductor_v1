setClass("CGHcallAssays",
         representation=representation(
           logratioValues="NumericMatrix",
           sampleNames="character",
           chromosomeId="integer",
           mapLocation="integer"),
         validity=function(object) {
             if (length(slot(object, "chromosomeId"))!=length(slot(object, "mapLocation")) ||
                 length(slot(object, "chromosomeId"))!=nrow(slot(object, "logratioValues")))
               "chromosomeId, mapLocation, and rows of logratioValues be the same"
             else if (length(slot(object, "sampleNames")) != ncol(slot(object, "logratioValues")))
               "number of sampleNames must equal number of columns in logratioValues"
             else TRUE
         })

setAs("CGHcallAssays", "matrix",
      function(from) {
          ncol <- ncol(slot(from, "logratioValues"))
          m <- matrix(slot(from, "logratioValues"), ncol=ncol)
          tryCatch(colnames(m) <- slot(from, "sampleNames"),
                   error=function(err) {
                       message(ncol(m), " logratioValues, ",
                               length(slot(from, "sampleNames")),
                               " sampleNames\n",
                               conditionMessage(err))
                   })
          m
      })

setMethod("names",
          signature=signature(x="CGHcallAssays"),
          function(x) slot(x, "sampleNames"))

setClass("CGHcallParameter",
         representation=representation(
           randomNumberSeed = "integer",
           changePointSignificanceLevel = "numeric", # alpha; significance level to accept change-points
           numberLevels = "integer",
           permutationReplicates = "integer",
           earlyStoppingCriterion = "numeric"),
         prototype=prototype(
           changePointSignificanceLevel=0.01,
           permutationReplicates=as.integer(1000),
           numberLevels=as.integer(4),
           earlyStoppingCriterion=0.05))

setValidity("CGHcallParameter", function(object) {
    .num2str <- function(num) {
        if (length(num)==0)
          paste(class(num), "(0)", sep="")
        else
          paste(as.character(num), collapse=" ")
    }
    msg <- NULL
    slt <- slot(object, "earlyStoppingCriterion")
    if (length(slt) != 1 || slt < 0 || slt >= 1.0) {
        err <- sprintf("'%s' out of bounds,\nmust be %s\nwas %s",
                       "earlyStoppingCriterion",
                       "length(1), >=0, <1", .num2str(slt))
        msg <- c(msg, err)
    }
    slt <- slot(object, "changePointSignificanceLevel")
    if (length(slt) != 1 || slt < 0 || slt > 1) {
        err <- sprintf("'%s' out of bounds\nmust be %s\nwas %s",
                       "changePointSignificanceLevel",
                       "length(1), >= 0, <=1", .num2str(slt))
        msg <- c(msg, err)
    }
    slt <- slot(object, "permutationReplicates")
    if (length(slt) != 1 || slt < 0) {
        err <- sprintf("'%s' out of bounds\nmust be %s\nwas %s",
                       "permutationReplicates",
                       "length(1), >= 0", .num2str(slt))
        msg <- c(msg, err)
    }
    slt <- slot(object, "numberLevels")
    if (length(slt) != 1 || slt < 3 || slt > 4) {
        err <- sprintf("'%s' out of bounds\nmust be %s\nwas %s",
                       "numberLevels",
                       "3 or 4", .num2str(slt))
        msg <- c(msg, err)
    }
    if (is.null(msg)) TRUE else msg
})

setClass("DerivedCGHcallSegment",
         representation=representation(
           sampleId="character",
           chromosomeIndex="character",
           startMapPosition="integer",
           endMapPosition="integer",
           markersPerSegment="integer",
           averageSegmentValue="numeric",
           calls="integer",
           probLoss="numeric",
           probNorm="numeric",
           probGain="numeric",
           probAmp="numeric"
           ),
         validity=function(object) {
             if (!all(sapply(names(getSlots("DerivedCGHcallSegment")),
                             function(elt) length(slot(object, elt)))==length(slot(object, "sampleId"))))
               "all slots must have same length"
             else TRUE
         })

caCGHcall <- function(cghcallAssays, cghcallParameter) {
    derivedCGHcallSegment <- doCaCghCall(cghcallAssays, cghcallParameter)
    return(derivedCGHcallSegment)
}

typeInfo(caCGHcall) <-
  SimultaneousTypeSpecification(
    TypedSignature(cghcallAssays= "CGHcallAssays",
                   cghcallParameter="CGHcallParameter"),
    returnType="DerivedCGHcallSegment")
	
tempFunc <- function(x) { return(x)}

typeInfo(tempFunc) <-
  SimultaneousTypeSpecification(
    TypedSignature(x="numeric"),
	returnType="CGHcallAssays")
