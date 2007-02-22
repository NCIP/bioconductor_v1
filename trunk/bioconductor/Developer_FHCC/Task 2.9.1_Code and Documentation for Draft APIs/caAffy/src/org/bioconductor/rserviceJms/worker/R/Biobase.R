
#####################
# Matcher and Converter for R Object Versions.
#####################

#  Function Matches R Object Versions.
match_Biobase.Versions_ToJava <- function(x, ...){
	inherits(x, "Versions")
}

# Function Converts R Object Versions
# to Java Class org.bioconductor.packages.biobase.Versions.
cvt_Biobase.Versions_ToJava <- function(x, ...){
	thisClass <- .JNew("org.bioconductor.packages.biobase.Versions", .convert=FALSE)
	input_.Data <- cvtListToJava2( x@.Data )
	.Java(thisClass, "setRData", input_.Data, .convert=FALSE)
	thisClass
}

# Register matcher and converter
setJavaFunctionConverter( 
	cvt_Biobase.Versions_ToJava,
	match_Biobase.Versions_ToJava,
	description="R Versions to Java org.bioconductor.packages.biobase.Versions",
	fromJava=F, position=1)

#####################
# Matcher and Converter for R Object MIAME.
#####################

#  Function Matches R Object MIAME.
match_Biobase.MIAME_ToJava <- function(x, ...){
	inherits(x, "MIAME")
}

# Function Converts R Object MIAME
# to Java Class org.bioconductor.packages.biobase.MIAME.
cvt_Biobase.MIAME_ToJava <- function(x, ...){
	thisClass <- .JNew("org.bioconductor.packages.biobase.MIAME", .convert=FALSE)
	input_name <- cvtCharacterToJava2( x@name )
	.Java(thisClass, "setName", input_name, .convert=FALSE)
	input_lab <- cvtCharacterToJava2( x@lab )
	.Java(thisClass, "setLab", input_lab, .convert=FALSE)
	input_contact <- cvtCharacterToJava2( x@contact )
	.Java(thisClass, "setContact", input_contact, .convert=FALSE)
	input_title <- cvtCharacterToJava2( x@title )
	.Java(thisClass, "setTitle", input_title, .convert=FALSE)
	input_abstract <- cvtCharacterToJava2( x@abstract )
	.Java(thisClass, "setAabstract", input_abstract, .convert=FALSE)
	input_url <- cvtCharacterToJava2( x@url )
	.Java(thisClass, "setUrl", input_url, .convert=FALSE)
	input_pubMedIds <- cvtCharacterToJava2( x@pubMedIds )
	.Java(thisClass, "setPubMedIds", input_pubMedIds, .convert=FALSE)
	input_samples <- cvtListToJava2( x@samples )
	.Java(thisClass, "setSamples", input_samples, .convert=FALSE)
	input_hybridizations <- cvtListToJava2( x@hybridizations )
	.Java(thisClass, "setHybridizations", input_hybridizations, .convert=FALSE)
	input_normControls <- cvtListToJava2( x@normControls )
	.Java(thisClass, "setNormControls", input_normControls, .convert=FALSE)
	input_preprocessing <- cvtListToJava2( x@preprocessing )
	.Java(thisClass, "setPreprocessing", input_preprocessing, .convert=FALSE)
	input_other <- cvtListToJava2( x@other )
	.Java(thisClass, "setOther", input_other, .convert=FALSE)
	input_.__classVersion__ <- cvt_Biobase.Versions_ToJava( x@.__classVersion__ )
	.Java(thisClass, "setR__classVersion__", input_.__classVersion__, .convert=FALSE)
	thisClass
}

# Register matcher and converter
setJavaFunctionConverter( 
	cvt_Biobase.MIAME_ToJava,
	match_Biobase.MIAME_ToJava,
	description="R MIAME to Java org.bioconductor.packages.biobase.MIAME",
	fromJava=F, position=1)
