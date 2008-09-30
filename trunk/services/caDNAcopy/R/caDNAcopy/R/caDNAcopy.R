setClass("DNAcopyAssays",
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

setAs("DNAcopyAssays", "matrix",
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
          signature=signature(x="DNAcopyAssays"),
          function(x) slot(x, "sampleNames"))

setClass("DNAcopyParameter",
         representation=representation(
           randomNumberSeed = "integer",
           changePointSignificanceLevel = "numeric", # alpha; significance level to accept change-points           smoothCNAParameters = "SmoothCNAParameters",
           permutationReplicates = "integer",
           earlyStoppingCriterion = "numeric"),
         prototype=prototype(
           changePointSignificanceLevel=0.01,
           permutationReplicates=as.integer(1000),
           earlyStoppingCriterion=0.05))

setValidity("DNAcopyParameter", function(object) {
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
    if (is.null(msg)) TRUE else msg
})

setClass("DerivedDNAcopySegment",
         representation=representation(
           sampleId="character",
           chromosomeIndex="character",
           startMapPosition="integer",
           endMapPosition="integer",
           markersPerSegment="integer",
           averageSegmentValue="numeric"
           ),
         validity=function(object) {
             if (!all(sapply(names(getSlots("DerivedDNAcopySegment")),
                             function(elt) length(slot(object, elt)))==length(slot(object, "sampleId"))))
               "all slots must have same length"
             else TRUE
         })

caDNAcopy <- function(dnacopyAssays, dnacopyParameter) {
    logratioValues <- slot(dnacopyAssays, "logratioValues")
    if (all(dim(logratioValues) == c(0,0)))
      return(new("DerivedDNAcopySegment"))
    seed <- slot(dnacopyParameter, "randomNumberSeed")
    if (length(seed)>0)
      set.seed(seed)
    cna <- CNA(as(dnacopyAssays, "matrix"),
               slot(dnacopyAssays, "chromosomeId"),
               slot(dnacopyAssays, "mapLocation"),
               data.type="logratio",
               sampleid=names(dnacopyAssays))
    obj <- smooth.CNA(cna)
    res <- segment(obj,
                   alpha=slot(dnacopyParameter, "changePointSignificanceLevel"),
                   nperm=slot(dnacopyParameter, "permutationReplicates"),
                   eta=slot(dnacopyParameter, "earlyStoppingCriterion"))
    derivedDNAcopySegment <- new("DerivedDNAcopySegment",
                                 sampleId=res$output$ID,
                                 chromosomeIndex=as.character(res$output$chrom),
                                 startMapPosition=res$output$loc.start,
                                 endMapPosition=res$output$loc.end,
                                 markersPerSegment=as.integer(res$output$num.mark),
                                 averageSegmentValue=res$output$seg.mean)
    return(derivedDNAcopySegment)
}

typeInfo(caDNAcopy) <-
  SimultaneousTypeSpecification(
    TypedSignature(dnacopyAssays= "DNAcopyAssays",
                   dnacopyParameter="DNAcopyParameter"),
    returnType="DerivedDNAcopySegment")
	
tempFunc <- function(x) { return(x)}

typeInfo(tempFunc) <-
  SimultaneousTypeSpecification(
    TypedSignature(x="numeric"),
	returnType="DNAcopyAssays")
