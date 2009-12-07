
numberOfClusters <- 1L
algorithm        <- "Hartigan-Wong"

kMeansMachineLearningParameters <- try( KMeansMachineLearningParameters(
                                        numberOfClusters=numberOfClusters,
                                        algorithm=algorithm ),
                                   silent=TRUE )

if(is(kMeansMachineLearningParameters, "try-error"))
        kMeansMachineLearningParameters <- NULL
