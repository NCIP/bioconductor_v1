
annotation             <- "hgu95av2"
minimumGenesPerGeneSet <- 10L
ontology               <- "BP"

geneOntologyContinuousGeneSetAnalysisParameters <- try( GeneOntologyContinuousGeneSetAnalysisParameters(
                                                        ontology=ontology,
                                                        minimumGenesPerGeneSet=minimumGenesPerGeneSet,
                                                        annotation=annotation ),
                                                       silent=TRUE )

if(is(geneOntologyContinuousGeneSetAnalysisParameters, "try-error"))
	geneOntologyContinuousGeneSetAnalysisParameters <- NULL
