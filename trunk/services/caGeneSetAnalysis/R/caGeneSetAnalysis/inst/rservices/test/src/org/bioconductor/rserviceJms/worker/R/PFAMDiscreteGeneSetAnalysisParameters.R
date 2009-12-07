
annotation     <- "hgu95av2"
discretePValue <- 0.05
testDirection  <- "over-represented"

pfamDiscreteGeneSetAnalysisParameters <- try( PFAMDiscreteGeneSetAnalysisParameters(
                                              annotation=annotation,
                                              discretePValue=discretePValue,
                                              testDirection=testDirection ),
                                             silent=TRUE )

if(is(pfamDiscreteGeneSetAnalysisParameters, "try-error"))
	pfamDiscreteGeneSetAnalysisParameters <- NULL
