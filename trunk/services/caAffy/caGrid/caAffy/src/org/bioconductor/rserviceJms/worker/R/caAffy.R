
#####################
# Matcher and Converter for R Object QaReport.
#####################

#  Function Matches R Object QaReport.
match_caAffy.QaReport_ToJava <- function(x, ...){
	inherits(x, "QaReport")
}

# Function Converts R Object QaReport
# to Java Class org.bioconductor.packages.caAffy.QaReport.
cvt_caAffy.QaReport_ToJava <- function(x, ...){
	thisClass <- .JNew("org.bioconductor.packages.caAffy.QaReport", .convert=FALSE)
	input_pdfFile <- cvtRawToJava2( x@pdfFile )
	.Java(thisClass, "setPdfFile", input_pdfFile, .convert=FALSE)
	thisClass
}

# Register matcher and converter
setJavaFunctionConverter( 
	cvt_caAffy.QaReport_ToJava,
	match_caAffy.QaReport_ToJava,
	description="R QaReport to Java org.bioconductor.packages.caAffy.QaReport",
	fromJava=F, position=1)

#####################
# Matcher and Converter for Java Class org.bioconductor.packages.caAffy.DerivedBioAssays.
#####################

#  Function Matches Java Class org.bioconductor.packages.caAffy.DerivedBioAssays.
match_caAffy.DerivedBioAssays_FromJava <- function(x, thisClassName){
	thisClassName == "org.bioconductor.packages.caAffy.DerivedBioAssays"
}

# Function Converts Java Class org.bioconductor.packages.caAffy.DerivedBioAssays
# to R Object DerivedBioAssays.
cvt_caAffy.DerivedBioAssays_FromJava <- function(x, thisClassName){
	ans <- new("DerivedBioAssays")
	input_bioAssays <- .Java(x, "rgetBioAssays", .convert=FALSE)
	if (!is.null(input_bioAssays))
		ans@bioAssays <- cvtNumericMatrixFromJava2(input_bioAssays, NULL)
	ans
}

# Register matcher and converter
setJavaFunctionConverter( 
	cvt_caAffy.DerivedBioAssays_FromJava,
	match_caAffy.DerivedBioAssays_FromJava,
	description="Java org.bioconductor.packages.caAffy.DerivedBioAssays to R DerivedBioAssays",
	fromJava=T, position=1)

#####################
# Matcher and Converter for R Object DerivedBioAssays.
#####################

#  Function Matches R Object DerivedBioAssays.
match_caAffy.DerivedBioAssays_ToJava <- function(x, ...){
	inherits(x, "DerivedBioAssays")
}

# Function Converts R Object DerivedBioAssays
# to Java Class org.bioconductor.packages.caAffy.DerivedBioAssays.
cvt_caAffy.DerivedBioAssays_ToJava <- function(x, ...){
	thisClass <- .JNew("org.bioconductor.packages.caAffy.DerivedBioAssays", .convert=FALSE)
	input_bioAssays <- cvtNumericMatrixToJava2( x@bioAssays )
	.Java(thisClass, "rsetBioAssays", input_bioAssays, .convert=FALSE)
	thisClass
}

# Register matcher and converter
setJavaFunctionConverter( 
	cvt_caAffy.DerivedBioAssays_ToJava,
	match_caAffy.DerivedBioAssays_ToJava,
	description="R DerivedBioAssays to Java org.bioconductor.packages.caAffy.DerivedBioAssays",
	fromJava=F, position=1)

#####################
# Matcher and Converter for Java Class org.bioconductor.packages.caAffy.NormalizeMethodParameter.
#####################

#  Function Matches Java Class org.bioconductor.packages.caAffy.NormalizeMethodParameter.
match_caAffy.NormalizeMethodParameter_FromJava <- function(x, thisClassName){
	thisClassName == "org.bioconductor.packages.caAffy.NormalizeMethodParameter"
}

# Function Converts Java Class org.bioconductor.packages.caAffy.NormalizeMethodParameter
# to R Object NormalizeMethodParameter.
cvt_caAffy.NormalizeMethodParameter_FromJava <- function(x, thisClassName){
	ans <- new("NormalizeMethodParameter")
	ans@probeType <- .Java(x, "getProbeType")
	ans@method <- .Java(x, "getMethod")
	ans
}

# Register matcher and converter
setJavaFunctionConverter( 
	cvt_caAffy.NormalizeMethodParameter_FromJava,
	match_caAffy.NormalizeMethodParameter_FromJava,
	description="Java org.bioconductor.packages.caAffy.NormalizeMethodParameter to R NormalizeMethodParameter",
	fromJava=T, position=1)

#####################
# Matcher and Converter for Java Class org.bioconductor.packages.caAffy.ExpressoParameter.
#####################

#  Function Matches Java Class org.bioconductor.packages.caAffy.ExpressoParameter.
match_caAffy.ExpressoParameter_FromJava <- function(x, thisClassName){
	thisClassName == "org.bioconductor.packages.caAffy.ExpressoParameter"
}

# Function Converts Java Class org.bioconductor.packages.caAffy.ExpressoParameter
# to R Object ExpressoParameter.
cvt_caAffy.ExpressoParameter_FromJava <- function(x, thisClassName){
	ans <- new("ExpressoParameter")
	ans@backgroundCorrectMethod <- .Java(x, "getBackgroundCorrectMethod")
	input_normalizeMethodParameter <- .Java(x, "getNormalizeMethodParameter", .convert=FALSE)
	if (!is.null(input_normalizeMethodParameter))
		ans@normalizeMethodParameter <- cvt_caAffy.NormalizeMethodParameter_FromJava(input_normalizeMethodParameter, NULL)
	ans@pmCorrectMethod <- .Java(x, "getPmCorrectMethod")
	ans@probeSummaryMethod <- .Java(x, "getProbeSummaryMethod")
	ans
}

# Register matcher and converter
setJavaFunctionConverter( 
	cvt_caAffy.ExpressoParameter_FromJava,
	match_caAffy.ExpressoParameter_FromJava,
	description="Java org.bioconductor.packages.caAffy.ExpressoParameter to R ExpressoParameter",
	fromJava=T, position=1)
