
sampleName       <- c("Jim", "Kyle", "George", "Amy", "Kathy")
isTrainingSample <- c(TRUE, FALSE, TRUE, FALSE, FALSE)
type             <- as.factor( c("a", "a", "b", "c", "c") )

linearDiscriminantAnalysisMachineLearningParameters <- try( LinearDiscriminantAnalysisMachineLearningParameters(
                                                            sampleName=sampleName,
                                                            isTrainingSample=isTrainingSample,
                                                            type=type ),
                                                       silent=TRUE )

if(is(linearDiscriminantAnalysisMachineLearningParameters, "try-error"))
	linearDiscriminantAnalysisMachineLearningParameters <- NULL
