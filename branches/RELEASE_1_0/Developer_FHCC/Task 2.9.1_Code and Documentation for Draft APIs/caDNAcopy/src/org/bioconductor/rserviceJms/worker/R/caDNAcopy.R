
#####################
# Matcher and Converter for R Object DerivedDNAcopySegment.
#####################

#  Function Matches R Object DerivedDNAcopySegment.
match_caDNAcopy.DerivedDNAcopySegment_ToJava <- function(x, ...){
	inherits(x, "DerivedDNAcopySegment")
}

# Function Converts R Object DerivedDNAcopySegment
# to Java Class org.bioconductor.packages.caDNAcopy.DerivedDNAcopySegment.
cvt_caDNAcopy.DerivedDNAcopySegment_ToJava <- function(x, ...){
	thisClass <- .JNew("org.bioconductor.packages.caDNAcopy.DerivedDNAcopySegment", .convert=FALSE)
	input_sampleId <- cvtCharacterToJava2( x@sampleId )
	.Java(thisClass, "setSampleId", input_sampleId, .convert=FALSE)
	input_chromosomeIndex <- cvtCharacterToJava2( x@chromosomeIndex )
	.Java(thisClass, "setChromosomeIndex", input_chromosomeIndex, .convert=FALSE)
	input_startMapPosition <- cvtIntegerToJava2( x@startMapPosition )
	.Java(thisClass, "setStartMapPosition", input_startMapPosition, .convert=FALSE)
	input_endMapPosition <- cvtIntegerToJava2( x@endMapPosition )
	.Java(thisClass, "setEndMapPosition", input_endMapPosition, .convert=FALSE)
	input_markersPerSegment <- cvtIntegerToJava2( x@markersPerSegment )
	.Java(thisClass, "setMarkersPerSegment", input_markersPerSegment, .convert=FALSE)
	input_averageSegmentValue <- cvtNumericToJava2( x@averageSegmentValue )
	.Java(thisClass, "setAverageSegmentValue", input_averageSegmentValue, .convert=FALSE)
	thisClass
}

# Register matcher and converter
setJavaFunctionConverter( 
	cvt_caDNAcopy.DerivedDNAcopySegment_ToJava,
	match_caDNAcopy.DerivedDNAcopySegment_ToJava,
	description="R DerivedDNAcopySegment to Java org.bioconductor.packages.caDNAcopy.DerivedDNAcopySegment",
	fromJava=F, position=1)

#####################
# Matcher and Converter for Java Class org.bioconductor.packages.caDNAcopy.DNAcopyAssays.
#####################

#  Function Matches Java Class org.bioconductor.packages.caDNAcopy.DNAcopyAssays.
match_caDNAcopy.DNAcopyAssays_FromJava <- function(x, thisClassName){
	thisClassName == "org.bioconductor.packages.caDNAcopy.DNAcopyAssays"
}

# Function Converts Java Class org.bioconductor.packages.caDNAcopy.DNAcopyAssays
# to R Object DNAcopyAssays.
cvt_caDNAcopy.DNAcopyAssays_FromJava <- function(x, thisClassName){
	ans <- new("DNAcopyAssays")
	input_logratioValues <- .Java(x, "getLogratioValues", .convert=FALSE)
	if (!is.null(input_logratioValues))
		ans@logratioValues <- cvtNumericMatrixFromJava2(input_logratioValues, NULL)
	ans@sampleNames <- .Java(x, "getSampleNames")
	ans@chromosomeId <- .Java(x, "getChromosomeId")
	ans@mapLocation <- .Java(x, "getMapLocation")
	ans
}

# Register matcher and converter
setJavaFunctionConverter( 
	cvt_caDNAcopy.DNAcopyAssays_FromJava,
	match_caDNAcopy.DNAcopyAssays_FromJava,
	description="Java org.bioconductor.packages.caDNAcopy.DNAcopyAssays to R DNAcopyAssays",
	fromJava=T, position=1)

#####################
# Matcher and Converter for Java Class org.bioconductor.packages.caDNAcopy.DNAcopyParameter.
#####################

#  Function Matches Java Class org.bioconductor.packages.caDNAcopy.DNAcopyParameter.
match_caDNAcopy.DNAcopyParameter_FromJava <- function(x, thisClassName){
	thisClassName == "org.bioconductor.packages.caDNAcopy.DNAcopyParameter"
}

# Function Converts Java Class org.bioconductor.packages.caDNAcopy.DNAcopyParameter
# to R Object DNAcopyParameter.
cvt_caDNAcopy.DNAcopyParameter_FromJava <- function(x, thisClassName){
	ans <- new("DNAcopyParameter")
	ans@randomNumberSeed <- .Java(x, "getRandomNumberSeed")
	ans@changePointSignificanceLevel <- .Java(x, "getChangePointSignificanceLevel")
	ans@permutationReplicates <- .Java(x, "getPermutationReplicates")
	ans@earlyStoppingCriterion <- .Java(x, "getEarlyStoppingCriterion")
	ans
}

# Register matcher and converter
setJavaFunctionConverter( 
	cvt_caDNAcopy.DNAcopyParameter_FromJava,
	match_caDNAcopy.DNAcopyParameter_FromJava,
	description="Java org.bioconductor.packages.caDNAcopy.DNAcopyParameter to R DNAcopyParameter",
	fromJava=T, position=1)
