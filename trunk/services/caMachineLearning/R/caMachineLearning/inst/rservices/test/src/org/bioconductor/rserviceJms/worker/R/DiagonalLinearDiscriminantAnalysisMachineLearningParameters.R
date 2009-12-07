
sampleName       <- c("Jim", "Kyle", "George", "Amy", "Kathy")
isTrainingSample <- c(TRUE, FALSE, TRUE, FALSE, FALSE)
type             <- as.factor( c("a", "a", "b", "c", "c") )

diagonalLinearDiscriminantAnalysisMachineLearningParameters <- try( DiagonalLinearDiscriminantAnalysisMachineLearningParameters(
                                                                    sampleName=sampleName,
                                                                    isTrainingSample=isTrainingSample,
                                                                    type=type ),
                                                               silent=TRUE )

if(is(diagonalLinearDiscriminantAnalysisMachineLearningParameters, "try-error"))
	diagonalLinearDiscriminantAnalysisMachineLearningParameters <- NULL
