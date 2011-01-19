
ontology       <- "BP"
discretePValue <- 0.05
testDirection  <- "over-represented"
annotation     <- "hgu95av2"

geneOntologyDiscreteGeneSetAnalysisParameters <- try( GeneOntologyDiscreteGeneSetAnalysisParameters(
                                                      ontology=ontology,
                                                      discretePValue=discretePValue,
                                                      testDirection=testDirection,
                                                      annotation=annotation ),
                                                     silent=TRUE )

if(is(geneOntologyDiscreteGeneSetAnalysisParameters, "try-error"))
	geneOntologyDiscreteGeneSetAnalysisParameters <- NULL
