
#####################
# Matcher and Converter for R Object QualityControlStatistics.
#####################

#  Function Matches R Object QualityControlStatistics.
match_caAffy.QualityControlStatistics_ToJava <- function(x, ...){
	inherits(x, "QualityControlStatistics")
}

# Function Converts R Object QualityControlStatistics
# to Java Class org.bioconductor.packages.caAffy.QualityControlStatistics.
cvt_caAffy.QualityControlStatistics_ToJava <- function(x, ...){
	thisClass <- .JNew("org.bioconductor.packages.caAffy.QualityControlStatistics", .convert=FALSE)
	input_scale.factors <- cvtNumericToJava2( x@scale.factors )
	.Java(thisClass, "setScalerfactors", input_scale.factors, .convert=FALSE)
	input_target <- cvtNumericToJava2( x@target )
	.Java(thisClass, "setTarget", input_target, .convert=FALSE)
	input_percent.present <- cvtNumericToJava2( x@percent.present )
	.Java(thisClass, "setPercentrpresent", input_percent.present, .convert=FALSE)
	input_average.background <- cvtNumericToJava2( x@average.background )
	.Java(thisClass, "setAveragerbackground", input_average.background, .convert=FALSE)
	input_minimum.background <- cvtNumericToJava2( x@minimum.background )
	.Java(thisClass, "setMinimumrbackground", input_minimum.background, .convert=FALSE)
	input_maximum.background <- cvtNumericToJava2( x@maximum.background )
	.Java(thisClass, "setMaximumrbackground", input_maximum.background, .convert=FALSE)
	input_spikes <- cvtNumericMatrixToJava2( x@spikes )
	.Java(thisClass, "setSpikes", input_spikes, .convert=FALSE)
	input_qc.probes <- cvtNumericMatrixToJava2( x@qc.probes )
	.Java(thisClass, "setQcrprobes", input_qc.probes, .convert=FALSE)
	input_bioBCalls <- cvtCharacterToJava2( x@bioBCalls )
	.Java(thisClass, "setBioBCalls", input_bioBCalls, .convert=FALSE)
	thisClass
}

# Register matcher and converter
setJavaFunctionConverter( 
	cvt_caAffy.QualityControlStatistics_ToJava,
	match_caAffy.QualityControlStatistics_ToJava,
	description="R QualityControlStatistics to Java org.bioconductor.packages.caAffy.QualityControlStatistics",
	fromJava=F, position=1)

#####################
# Matcher and Converter for R Object ProbeLevelLinearModel.
#####################

#  Function Matches R Object ProbeLevelLinearModel.
match_caAffy.ProbeLevelLinearModel_ToJava <- function(x, ...){
	inherits(x, "ProbeLevelLinearModel")
}

# Function Converts R Object ProbeLevelLinearModel
# to Java Class org.bioconductor.packages.caAffy.ProbeLevelLinearModel.
cvt_caAffy.ProbeLevelLinearModel_ToJava <- function(x, ...){
	thisClass <- .JNew("org.bioconductor.packages.caAffy.ProbeLevelLinearModel", .convert=FALSE)
	input_const.coefs <- cvtNumericMatrixToJava2( x@const.coefs )
	.Java(thisClass, "setConstrcoefs", input_const.coefs, .convert=FALSE)
	input_se.const.coefs <- cvtNumericMatrixToJava2( x@se.const.coefs )
	.Java(thisClass, "setSerconstrcoefs", input_se.const.coefs, .convert=FALSE)
	input_cdfName <- cvtCharacterToJava2( x@cdfName )
	.Java(thisClass, "setCdfName", input_cdfName, .convert=FALSE)
	input_nrow <- cvtNumericToJava2( x@nrow )
	.Java(thisClass, "setNrow", input_nrow, .convert=FALSE)
	input_ncol <- cvtNumericToJava2( x@ncol )
	.Java(thisClass, "setNcol", input_ncol, .convert=FALSE)
	input_weights <- cvtListToJava2( x@weights )
	.Java(thisClass, "setWeights", input_weights, .convert=FALSE)
	input_residuals <- cvtListToJava2( x@residuals )
	.Java(thisClass, "setResiduals", input_residuals, .convert=FALSE)
	input_residualSE <- cvtNumericMatrixToJava2( x@residualSE )
	.Java(thisClass, "setResidualSE", input_residualSE, .convert=FALSE)
	input_normVec <- cvtNumericMatrixToJava2( x@normVec )
	.Java(thisClass, "setNormVec", input_normVec, .convert=FALSE)
	input_varcov <- cvtListToJava2( x@varcov )
	.Java(thisClass, "setVarcov", input_varcov, .convert=FALSE)
	input_experimentData <- cvt_Biobase.MIAME_ToJava( x@experimentData )
	.Java(thisClass, "setExperimentData", input_experimentData, .convert=FALSE)
	input_annotation <- cvtCharacterToJava2( x@annotation )
	.Java(thisClass, "setAnnotation", input_annotation, .convert=FALSE)
	thisClass
}

# Register matcher and converter
setJavaFunctionConverter( 
	cvt_caAffy.ProbeLevelLinearModel_ToJava,
	match_caAffy.ProbeLevelLinearModel_ToJava,
	description="R ProbeLevelLinearModel to Java org.bioconductor.packages.caAffy.ProbeLevelLinearModel",
	fromJava=F, position=1)

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
	input_qualityControlStatistics <- cvt_caAffy.QualityControlStatistics_ToJava( x@qualityControlStatistics )
	.Java(thisClass, "setQualityControlStatistics", input_qualityControlStatistics, .convert=FALSE)
	input_probeLevelLinearModel <- cvt_caAffy.ProbeLevelLinearModel_ToJava( x@probeLevelLinearModel )
	.Java(thisClass, "setProbeLevelLinearModel", input_probeLevelLinearModel, .convert=FALSE)
	input_madsMatrix <- cvtNumericMatrixToJava2( x@madsMatrix )
	.Java(thisClass, "setMadsMatrix", input_madsMatrix, .convert=FALSE)
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
# Matcher and Converter for Java Class org.bioconductor.packages.caAffy.MeasuredBioAssayMatrix.
#####################

#  Function Matches Java Class org.bioconductor.packages.caAffy.MeasuredBioAssayMatrix.
match_caAffy.MeasuredBioAssayMatrix_FromJava <- function(x, thisClassName){
	thisClassName == "org.bioconductor.packages.caAffy.MeasuredBioAssayMatrix"
}

# Function Converts Java Class org.bioconductor.packages.caAffy.MeasuredBioAssayMatrix
# to R Object MeasuredBioAssayMatrix.
cvt_caAffy.MeasuredBioAssayMatrix_FromJava <- function(x, thisClassName){
	ans <- new("MeasuredBioAssayMatrix")
	input_bioAssayData <- .Java(x, "getBioAssayData", .convert=FALSE)
	if (!is.null(input_bioAssayData))
		ans@bioAssayData <- cvtNumericMatrixFromJava2(input_bioAssayData, NULL)
	ans
}

# Register matcher and converter
setJavaFunctionConverter( 
	cvt_caAffy.MeasuredBioAssayMatrix_FromJava,
	match_caAffy.MeasuredBioAssayMatrix_FromJava,
	description="Java org.bioconductor.packages.caAffy.MeasuredBioAssayMatrix to R MeasuredBioAssayMatrix",
	fromJava=T, position=1)

#####################
# Matcher and Converter for R Object DerivedBioAssayMatrix.
#####################

#  Function Matches R Object DerivedBioAssayMatrix.
match_caAffy.DerivedBioAssayMatrix_ToJava <- function(x, ...){
	inherits(x, "DerivedBioAssayMatrix")
}

# Function Converts R Object DerivedBioAssayMatrix
# to Java Class org.bioconductor.packages.caAffy.DerivedBioAssayMatrix.
cvt_caAffy.DerivedBioAssayMatrix_ToJava <- function(x, ...){
	thisClass <- .JNew("org.bioconductor.packages.caAffy.DerivedBioAssayMatrix", .convert=FALSE)
	input_bioAssayData <- cvtNumericMatrixToJava2( x@bioAssayData )
	.Java(thisClass, "setBioAssayData", input_bioAssayData, .convert=FALSE)
	thisClass
}

# Register matcher and converter
setJavaFunctionConverter( 
	cvt_caAffy.DerivedBioAssayMatrix_ToJava,
	match_caAffy.DerivedBioAssayMatrix_ToJava,
	description="R DerivedBioAssayMatrix to Java org.bioconductor.packages.caAffy.DerivedBioAssayMatrix",
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
