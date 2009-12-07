
annotation             <- "hgu95av2"
minimumGenesPerGeneSet <- 10L

keggContinuousGeneSetAnalysisParameters <- try( KEGGContinuousGeneSetAnalysisParameters(
                                                annotation=annotation,
                                                minimumGenesPerGeneSet=minimumGenesPerGeneSet),
                                               silent=TRUE )

if(is(keggContinuousGeneSetAnalysisParameters, "try-error"))
	keggContinuousGeneSetAnalysisParameters <- NULL
