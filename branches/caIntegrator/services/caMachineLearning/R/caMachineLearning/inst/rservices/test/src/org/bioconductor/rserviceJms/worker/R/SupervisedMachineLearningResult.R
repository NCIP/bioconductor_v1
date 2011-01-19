
sampleName              <- c("Jim", "Kyle", "George", "Amy", "Kathy")
isTrainingSample        <- c(TRUE, FALSE, TRUE, FALSE, FALSE)
observedClassification  <- c("A", "B", "A", "A", "B")
predictedClassification <- c("B", "A", "A", "A", "B")
parameters              <- SupervisedMachineLearningParameters()

supervisedMachineLearningResult <- try( SupervisedMachineLearningResult(
                                        sampleName=sampleName,
                                        isTrainingSample=isTrainingSample,
                                        observedClassification=observedClassification,
                                        predictedClassification=predictedClassification ),
                                   silent=TRUE )

if(is(supervisedMachineLearningResult, "try-error"))
	supervisedMachineLearningResult <- NULL
