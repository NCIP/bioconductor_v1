
annotation     <- "hgu95av2"
discretePValue <- 0.05
testDirection  <- "over-represented"

keggDiscreteGeneSetAnalysisParameters <- try( KEGGDiscreteGeneSetAnalysisParameters(
                                              annotation=annotation,
                                              discretePValue=discretePValue,
                                              testDirection=testDirection ),
                                             silent=TRUE )

if(is(keggDiscreteGeneSetAnalysisParameters, "try-error"))
	keggDiscreteGeneSetAnalysisParameters <- NULL
