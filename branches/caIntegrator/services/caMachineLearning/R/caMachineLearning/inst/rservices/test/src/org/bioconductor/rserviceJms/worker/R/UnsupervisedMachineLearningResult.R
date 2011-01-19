
sampleName           <- c("Jim", "Kyle", "George")
predictedPartition   <- c(1L, 2L, 3L)
neighboringPartition <- c(2L, 1L, 3L)
silhouetteWidth      <- c(0.1, 0.3, 0.5)
parameters           <- UnsupervisedMachineLearningParameters()

unsupervisedMachineLearningResult <- try( UnsupervisedMachineLearningResult(
                                          sampleName=sampleName,
                                          predictedPartition=predictedPartition,
                                          neighboringPartition=neighboringPartition,
                                          silhouetteWidth=silhouetteWidth,
                                          parameters=parameters ),
                                     silent=TRUE )

if(is(unsupervisedMachineLearningResult, "try-error"))
        unsupervisedMachineLearningResult <- NULL
