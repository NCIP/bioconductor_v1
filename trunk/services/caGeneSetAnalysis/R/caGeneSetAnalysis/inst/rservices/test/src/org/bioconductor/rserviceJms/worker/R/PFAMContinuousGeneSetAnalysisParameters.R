
annotation             <- "hgu95av2"
minimumGenesPerGeneSet <- 10L

pfamContinuousGeneSetAnalysisParameters <- try( PFAMContinuousGeneSetAnalysisParameters(
                                                annotation=annotation,
                                                minimumGenesPerGeneSet=minimumGenesPerGeneSet),
                                               silent=TRUE )

if(is(pfamContinuousGeneSetAnalysisParameters, "try-error"))
	pfamContinuousGeneSetAnalysisParameters <- NULL
