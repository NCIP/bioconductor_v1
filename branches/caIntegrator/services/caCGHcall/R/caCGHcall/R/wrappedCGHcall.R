# Creates a cghRaw object from CGHcallAssays
# 
# Accepts as input:
#   caCGHcall CGHcallAssays class
# 
# Returns cghRaw object
#
assay2cghRaw <- function(cghCallAssays) {
    # cghCallAssays have no end positions, so fake it always
    # This uses the same algorithm (start+60) that the CGHcall example uses
    enddfraw <- data.frame(bpend=as.integer(slot(cghCallAssays, "mapLocation")+60))

    copynumber  <- as(cghCallAssays, "matrix")
    #if clone names contain missings/errors then try this
    rowNames <- sapply(1:nrow(copynumber),function(x){paste("clone",x,sep="")})
    rownames(copynumber) <- rowNames
    colnames(copynumber) <- names(cghCallAssays)
    annotation  <- data.frame(Chromosome=slot(cghCallAssays, "chromosomeId"), Start=slot(cghCallAssays, "mapLocation"), End=enddfraw[,1], row.names=rowNames)
    metadata    <- data.frame(labelDescription=c("Chromosomal position", "Basepair position start", "Basepair position end"), row.names=c("Chromosome", "Start", "End"))
    dimLabels   <- c("featureNames", "featureColumns")
    annotation  <- new("AnnotatedDataFrame", data=annotation, dimLabels=dimLabels, varMetadata=metadata)
   return(new("cghRaw", copynumber=copynumber, featureData=annotation))
}

# Creates a DerivedCGHcallSegment object from CGHcall
# 
# Accepts as input:
#   CGHcall class (from CGHcall)
# 
# Returns DerivedCGHcallSegment object (from caCGHcall)
#
cghCall2DCCS <- function(cghCallObj,numlevels) {
    seg <- segmented(cghCallObj)
    segids <-  Biobase:::assayDataElement(cghCallObj, "segnumber")
    segids <- segids[,1]
    allstarts <- bpstart(cghCallObj)
    allchroms <- chromosomes(cghCallObj)
    allcalls <- calls(cghCallObj)
    allprobloss <- probloss(cghCallObj)
    allprobgain <- probgain(cghCallObj)
    allprobnorm <- probnorm(cghCallObj)
    allprobamp <- probamp(cghCallObj)

    # This is the only tricky part.
    # cghCall (and cghSeg/cghRaw) objects contain arrays that have one
    #   element per probe.  DerivedCGHcallSegment needs one element per
    #   segment.
    # Use segids array (which segment id for each probe) to walk the
    #   probe-based arrays and copy into a matrix with one row per segment.
    cghCallData = matrix(ncol=10,nrow=max(segids))
    lastsegid <- 0
    for(i in 1:length(segids)) {
      if (segids[i] > lastsegid) {
        # chrom id, start pos, end pos, marker count, segment mean,
        # call, probloss, probgain, probnorm, probamp
        if (numlevels == 3) cghCallData[segids[i],] <- c(allchroms[i], allstarts[i], 0, 0, seg[i], allcalls[i], allprobloss[i], allprobgain[i], allprobnorm[i], 0)
        if (numlevels == 4) cghCallData[segids[i],] <- c(allchroms[i], allstarts[i], 0, 0, seg[i], allcalls[i], allprobloss[i], allprobgain[i], allprobnorm[i], allprobamp[i])
        lastsegid <- segids[i]
      }
      cghCallData[segids[i],3] <- allstarts[i]
      cghCallData[segids[i],4] <- cghCallData[segids[i],4] + 1
    }

    derivedCGHcallSegment <- new("DerivedCGHcallSegment",
                                 sampleId=rep(colnames(copynumber(cghCallObj))[1],nrow(cghCallData)),
                                 chromosomeIndex=as.character(cghCallData[,1]),
                                 startMapPosition=as.integer(cghCallData[,2]),
                                 endMapPosition=as.integer(cghCallData[,3]),
                                 markersPerSegment=as.integer(cghCallData[,4]),
                                 averageSegmentValue=cghCallData[,5],
                                 calls=as.integer(cghCallData[,6]),
                                 probLoss=cghCallData[,7],
                                 probGain=cghCallData[,8],
                                 probNorm=cghCallData[,9],
                                 probAmp=cghCallData[,10])
    return(derivedCGHcallSegment)
}

# Execute the CGHcall algorithm after some initial preprocessing
#   Preprocessing includes segmentation using DNAcopy
# 
# Accepts as input:
#   caCGHcall CGHcallAssays class
#   caCGHcall CGHcallParameters class
# 
# Returns DerivedCGHcallSegment object
#
doCaCghCall <- function(cghCallAssays, cghCallParameter) {

# Set random number seed
seed <- slot(cghCallParameter, "randomNumberSeed")
if (length(seed)>0)
  set.seed(seed)

# Get un-normalized cghRaw object from cghCallAssays
raw <- assay2cghRaw(cghCallAssays)

# CAP - Preprocess and nromalize the way that Use_CGHcallPackage.R does it
prep <- preprocess(raw, maxmiss = 30, nchrom = 23)
rm(raw);gc();

# CAP - normalize the data
nor <-  normalize(prep,method = "median", cellularity = 1, smoothOutliers = TRUE)
rm(prep);gc();      
    

#For noisy profiles undo.SD may be increased to enforce less segments. 
#Advise is to consider the segment-plots before calling  
# Note that this call was changed from the CGHcall examples to use
#   parameters that were passed in the CGHcallParameters rather than the
#   ones hard-coded in the CGHcall examples
seg <-  segmentData(nor, method = "DNAcopyNumberedSegments", nperm=slot(cghCallParameter,"permutationReplicates"), alpha=slot(cghCallParameter,"changePointSignificanceLevel"), eta=slot(cghCallParameter,"earlyStoppingCriterion"))
rm(nor);gc();

# Normalization algorithm from CGHcall
segnorm <- postsegnormalize(seg,inter=c(-0.1,0.1))

# This is the CGHcall algorithm itself.  Returns a list rather than a
#   cghCall object though.  The ExpandCGHcall function call makes the
#   actual cghCall object.
numlevels <- as.integer(slot(cghCallParameter,"numberLevels"))
listcalls <- CGHcall(segnorm,nclass=numlevels,robustsig="yes")

calls <- ExpandCGHcall(listcalls,segnorm, divide=5, memeff=FALSE)
#IN CASE OF R MEMORY PROBLEMS USE (see also ?ExpandCGHcall); possibly increase divide.  Results can be combined using 'combine'.
#calls <- ExpandCGHcall(listcalls,segnorm, divide=5, memeff=TRUE)

rm(segnorm);gc();

# Convert cghCall object back to DCCS and return it
return(cghCall2DCCS(calls,numlevels))
}

# Inline test code
#
#	DF <- data.frame(a=c(0.0,0.0,0.0))
#        testDCA <- new("CGHcallAssays",
#            logratioValues=new("NumericMatrix",data.matrix(DF)),
#            sampleNames=c("X1"),
#            chromosomeId=as.integer(c(1,2,3)),
#            mapLocation=as.integer(c(10,70,130)))
#
#	testDCP <- new("CGHcallParameter")
#
#        res <- caCghCall(testDCA, testDCP)
