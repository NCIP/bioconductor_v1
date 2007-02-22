
#####################
# Matcher and Converter for R Object PeakLocation.
#####################

#  Function Matches R Object PeakLocation.
match_caPROcess.PeakLocation_ToJava <- function(x, ...){
	inherits(x, "PeakLocation")
}

# Function Converts R Object PeakLocation
# to Java Class org.bioconductor.packages.caPROcess.PeakLocation.
cvt_caPROcess.PeakLocation_ToJava <- function(x, ...){
	thisClass <- .JNew("org.bioconductor.packages.caPROcess.PeakLocation", .convert=FALSE)
	input_spectrumName <- cvtCharacterToJava2( x@spectrumName )
	.Java(thisClass, "setSpectrumName", input_spectrumName, .convert=FALSE)
	input_spectrumId <- cvtIntegerToJava2( x@spectrumId )
	.Java(thisClass, "setSpectrumId", input_spectrumId, .convert=FALSE)
	input_peakNumberInSpectrum <- cvtIntegerToJava2( x@peakNumberInSpectrum )
	.Java(thisClass, "setPeakNumberInSpectrum", input_peakNumberInSpectrum, .convert=FALSE)
	input_relativeIntensity <- cvtNumericToJava2( x@relativeIntensity )
	.Java(thisClass, "setRelativeIntensity", input_relativeIntensity, .convert=FALSE)
	input_substanceMassAtIntensity <- cvtNumericToJava2( x@substanceMassAtIntensity )
	.Java(thisClass, "setSubstanceMassAtIntensity", input_substanceMassAtIntensity, .convert=FALSE)
	thisClass
}

# Register matcher and converter
setJavaFunctionConverter( 
	cvt_caPROcess.PeakLocation_ToJava,
	match_caPROcess.PeakLocation_ToJava,
	description="R PeakLocation to Java org.bioconductor.packages.caPROcess.PeakLocation",
	fromJava=F, position=1)

#####################
# Matcher and Converter for Java Class org.bioconductor.packages.caPROcess.MzSpectrum.
#####################

#  Function Matches Java Class org.bioconductor.packages.caPROcess.MzSpectrum.
match_caPROcess.MzSpectrum_FromJava <- function(x, thisClassName){
	thisClassName == "org.bioconductor.packages.caPROcess.MzSpectrum"
}

# Function Converts Java Class org.bioconductor.packages.caPROcess.MzSpectrum
# to R Object MzSpectrum.
cvt_caPROcess.MzSpectrum_FromJava <- function(x, thisClassName){
	ans <- new("MzSpectrum")
	ans@spectrumName <- .Java(x, "getSpectrumName")
	ans@mzRatio <- .Java(x, "getMzRatio")
	ans@intensity <- .Java(x, "getIntensity")
	ans
}

# Register matcher and converter
setJavaFunctionConverter( 
	cvt_caPROcess.MzSpectrum_FromJava,
	match_caPROcess.MzSpectrum_FromJava,
	description="Java org.bioconductor.packages.caPROcess.MzSpectrum to R MzSpectrum",
	fromJava=T, position=1)

#####################
# Matcher and Converter for Java Class org.bioconductor.packages.caPROcess.MzAssays.
#####################

#  Function Matches Java Class org.bioconductor.packages.caPROcess.MzAssays.
match_caPROcess.MzAssays_FromJava <- function(x, thisClassName){
	thisClassName == "org.bioconductor.packages.caPROcess.MzAssays"
}

# Function Converts Java Class org.bioconductor.packages.caPROcess.MzAssays
# to R Object MzAssays.
cvt_caPROcess.MzAssays_FromJava <- function(x, thisClassName){
	ans <- new("MzAssays")
	ans@.Data <- .Java(x, "getRData")
	input_listTemplate <- .Java(x, "getListTemplate", .convert=FALSE)
	if (!is.null(input_listTemplate))
		ans@listTemplate <- cvt_caPROcess.MzSpectrum_FromJava(input_listTemplate, NULL)
	ans
}

# Register matcher and converter
setJavaFunctionConverter( 
	cvt_caPROcess.MzAssays_FromJava,
	match_caPROcess.MzAssays_FromJava,
	description="Java org.bioconductor.packages.caPROcess.MzAssays to R MzAssays",
	fromJava=T, position=1)

#####################
# Matcher and Converter for Java Class org.bioconductor.packages.caPROcess.PROcessParameter.
#####################

#  Function Matches Java Class org.bioconductor.packages.caPROcess.PROcessParameter.
match_caPROcess.PROcessParameter_FromJava <- function(x, thisClassName){
	thisClassName == "org.bioconductor.packages.caPROcess.PROcessParameter"
}

# Function Converts Java Class org.bioconductor.packages.caPROcess.PROcessParameter
# to R Object PROcessParameter.
cvt_caPROcess.PROcessParameter_FromJava <- function(x, thisClassName){
	ans <- new("PROcessParameter")
	ans@renormalizationCutoff <- .Java(x, "getRenormalizationCutoff")
	ans@peakSignalToNoiseCutoff <- .Java(x, "getPeakSignalToNoiseCutoff")
	ans@peakVarianceDetectionSpan <- .Java(x, "getPeakVarianceDetectionSpan")
	ans@peakSmoothingSpan <- .Java(x, "getPeakSmoothingSpan")
	ans@peakZeroCutoff <- .Java(x, "getPeakZeroCutoff")
	ans@peakAreaNeighborhood <- .Java(x, "getPeakAreaNeighborhood")
	ans@peakAreaRetention <- .Java(x, "getPeakAreaRetention")
	ans
}

# Register matcher and converter
setJavaFunctionConverter( 
	cvt_caPROcess.PROcessParameter_FromJava,
	match_caPROcess.PROcessParameter_FromJava,
	description="Java org.bioconductor.packages.caPROcess.PROcessParameter to R PROcessParameter",
	fromJava=T, position=1)
