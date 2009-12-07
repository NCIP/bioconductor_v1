
linkage          <- "Complete"
distanceMetric   <- "Euclidean"
numberOfClusters <- 2L

hierarchicalClusteringMachineLearningParameters <- try( HierarchicalClusteringMachineLearningParameters(
                                                        linkage=linkage,
                                                        distanceMetric=distanceMetric,
                                                        numberOfClusters=numberOfClusters ),
                                                   silent=TRUE )

if(is(hierarchicalClusteringMachineLearningParameters, "try-error"))
	hierarchicalClusteringMachineLearningParameters <- NULL
