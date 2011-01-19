
sampleName       <- c("Jim", "Kyle", "George", "Amy", "Kathy")
isTrainingSample <- c(TRUE, FALSE, TRUE, FALSE, FALSE)
type             <- as.factor( c("a", "a", "b", "c", "c") )

quadraticDiscriminantAnalysisMachineLearningParameters <- try( QuadraticDiscriminantAnalysisMachineLearningParameters(
                                                               sampleName=sampleName,
                                                               isTrainingSample=isTrainingSample,
                                                               type=type ),
                                                          silent=TRUE )

if(is(quadraticDiscriminantAnalysisMachineLearningParameters, "try-error"))
	quadraticDiscriminantAnalysisMachineLearningParameters <- NULL
