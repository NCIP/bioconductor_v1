#
# KNearestNeighborsMachineLearningParameters
#

setMethod(.supervised,
    signature( oneChannelExpressionData = "OneChannelExpressionData",
               parameters               = "KNearestNeighborsMachineLearningParameters" ),
    function(oneChannelExpressionData, parameters)
    {
        # Unpack data.

        eData             <- expressionMatrix( channelOne(oneChannelExpressionData) )
        sampleName        <- sampleName(parameters)
        isTrainingSample  <- isTrainingSample(parameters)
        type              <- type(parameters)
        numberOfNeighbors <- numberOfNeighbors(parameters)
        minimumVote       <- minimumVote(parameters)

        # Check. The sample names of supplied with the parameters must
        # coincide with those of the data.

        if ( !( length(setdiff(sampleName, colnames(eData))) == 0 ) )
            stop("The sample names supplied with the 'parameters' object must coincide with those of the oneChannelExpressionData'.")

        # Check. The length of 'type' must equal the number of samples,
        # that is, the second dimension of the expression data.

        if ( !(length(type) == dim(eData)[2]) )
            stop("'type' information must be supplied for every sample.")

        # Augment the expression data with the 'type' information, then
        # transpose the data so that the samples correspond to the rows.

        df          <- data.frame( t(unclass(eData)) )  # unclass allows the NumericMatrix to be seen as a matrix
        df[,"type"] <- type

        # Construct a numeric vector of indices of data to be used for
        # training from 'isTrainingSample'.

        trainingSamples <- which(isTrainingSample)

        # Develop a classifier for 'type' based on all other data.

        formula <- as.formula( paste("type", "~", ".", sep="") )

        classifierOutput <- MLearn(formula=formula, data=df,
                               knnI(k=numberOfNeighbors, l=minimumVote),
                               trainingSamples)

        # Construct SupervisedMachineLearningResult to return.

        # Construct the observed and predicted classifications.  Sort
        # them into 'sampleName' order, then replace the numerical
        # codes by the corresponding factor level from 'type'.

        observedClassification <- c( classifierOutput@testOutcomes,
                                     classifierOutput@trainOutcomes )
        observedClassification <- observedClassification[ sampleName ]
        observedClassification <- levels(type)[ observedClassification ]

        predictedClassification <- c( testPredictions(classifierOutput),
                                      trainPredictions(classifierOutput) )
        predictedClassification <- predictedClassification[ sampleName ]
        predictedClassification <- levels(type)[ predictedClassification ]

        supervisedMachineLearningResult <- new("SupervisedMachineLearningResult",
                                               sampleName=sampleName,
                                               isTrainingSample=isTrainingSample,
                                               observedClassification=as.factor(observedClassification),
                                               predictedClassification=as.factor(predictedClassification),
                                               parameters=parameters
                                              )

        # Return.

        supervisedMachineLearningResult
    }
)

#
# SupportVectorMachineMachineLearningParameters
#

setMethod(.supervised,
    signature( oneChannelExpressionData = "OneChannelExpressionData",
               parameters               = "SupportVectorMachineMachineLearningParameters" ),
    function(oneChannelExpressionData, parameters)
    {
        # Unpack data.

        eData            <- expressionMatrix( channelOne(oneChannelExpressionData) )
        sampleName       <- sampleName(parameters)
        isTrainingSample <- isTrainingSample(parameters)
        type             <- type(parameters)

        # Check. The sample names of supplied with the parameters must
        # coincide with those of the data.

        if ( !( length(setdiff(sampleName, colnames(eData))) == 0 ) )
            stop("The sample names supplied with the 'parameters' object must coincide with those of the oneChannelExpressionData'.")

        # Check. The length of 'type' must equal the number of samples,
        # that is, the second dimension of the expression data.

        if ( !(length(type) == dim(eData)[2]) )
            stop("'type' information must be supplied for every sample.")

        # Augment the expression data with the 'type' information, then
        # transpose the data so that the samples correspond to the rows.

        df          <- data.frame( t(unclass(eData)) )  # unclass allows the NumericMatrix to be seen as a matrix
        df[,"type"] <- type

        # Construct a numeric vector of indices of data to be used for
        # training from 'isTrainingSample'.

        trainingSamples <- which(isTrainingSample)

        # Develop a classifier for 'type' based on all other data.

        formula <- as.formula( paste("type", "~", ".", sep="") )

        classifierOutput <- MLearn(formula=formula, data=df,
                               svmI,
                               trainingSamples)

        # Construct SupervisedMachineLearningResult to return.

        # Construct the observed and predicted classifications.  Sort
        # them into 'sampleName' order, then replace the numerical
        # codes by the corresponding factor level from 'type'.

        observedClassification <- c( classifierOutput@testOutcomes,
                                     classifierOutput@trainOutcomes )
        observedClassification <- observedClassification[ sampleName ]
        observedClassification <- levels(type)[ observedClassification ]

        predictedClassification <- c( testPredictions(classifierOutput),
                                      trainPredictions(classifierOutput) )
        predictedClassification <- predictedClassification[ sampleName ]
        predictedClassification <- levels(type)[ predictedClassification ]

        supervisedMachineLearningResult <- new("SupervisedMachineLearningResult",
                                               sampleName=sampleName,
                                               isTrainingSample=isTrainingSample,
                                               observedClassification=as.factor(observedClassification),
                                               predictedClassification=as.factor(predictedClassification),
                                               parameters=parameters
                                              )

        # Return.

        supervisedMachineLearningResult
    }
)

#
# LinearDiscriminantAnalysisMachineLearningParameters (LDA)
#

setMethod(.supervised,
    signature( oneChannelExpressionData = "OneChannelExpressionData",
               parameters               = "LinearDiscriminantAnalysisMachineLearningParameters" ),
    function(oneChannelExpressionData, parameters)
    {
        # Unpack data.

        eData            <- expressionMatrix( channelOne(oneChannelExpressionData) )
        sampleName       <- sampleName(parameters)
        isTrainingSample <- isTrainingSample(parameters)
        type             <- type(parameters)

        # Check. The sample names supplied with the parameters must
        # coincide with those of the data.

        if ( !( length(setdiff(sampleName, colnames(eData))) == 0 ) )
            stop("The sample names supplied with the 'parameters' object must coincide with those of the oneChannelExpressionData'.")

        # Check. The length of 'type' must equal the number of samples,
        # that is, the second dimension of the expression data.

        if ( !(length(type) == dim(eData)[2]) )
            stop("'type' information must be supplied for every sample.")

        # Augment the expression data with the 'type' information, then
        # transpose the data so that the samples correspond to the rows.

        df          <- data.frame( t(unclass(eData)) )  # unclass allows the NumericMatrix to be seen as a matrix
        df[,"type"] <- type

        # Construct a numeric vector of indices of data to be used for
        # training from 'isTrainingSample'.

        trainingSamples <- which(isTrainingSample)

        # Develop a classifier for 'type' based on all other data.

        formula <- as.formula( paste("type", "~", ".", sep="") )

        classifierOutput <- MLearn(formula=formula, data=df,
                               ldaI,
                               trainingSamples)

        # Construct SupervisedMachineLearningResult to return.

        # Construct the observed and predicted classifications.  Sort
        # them into 'sampleName' order, then replace the numerical
        # codes by the corresponding factor level from 'type'.

        observedClassification <- c( classifierOutput@testOutcomes,
                                     classifierOutput@trainOutcomes )
        observedClassification <- observedClassification[ sampleName ]
        observedClassification <- levels(type)[ observedClassification ]

        predictedClassification <- c( testPredictions(classifierOutput),
                                      trainPredictions(classifierOutput) )
        predictedClassification <- predictedClassification[ sampleName ]
        predictedClassification <- levels(type)[ predictedClassification ]

        supervisedMachineLearningResult <- new("SupervisedMachineLearningResult",
                                               sampleName=sampleName,
                                               isTrainingSample=isTrainingSample,
                                               observedClassification=as.factor(observedClassification),
                                               predictedClassification=as.factor(predictedClassification),
                                               parameters=parameters
                                              )

        # Return.

        supervisedMachineLearningResult
    }
)

#
# DiagonalLinearDiscriminantAnalysisMachineLearningParameters (DLDA)
#

setMethod(.supervised,
    signature( oneChannelExpressionData = "OneChannelExpressionData",
               parameters               = "DiagonalLinearDiscriminantAnalysisMachineLearningParameters" ),
    function(oneChannelExpressionData, parameters)
    {
        # Unpack data.

        eData            <- expressionMatrix( channelOne(oneChannelExpressionData) )
        sampleName       <- sampleName(parameters)
        isTrainingSample <- isTrainingSample(parameters)
        type             <- type(parameters)

	print(is.factor(type))
	print(type)

        # Check. The sample names of supplied with the parameters must
        # coincide with those of the data.

        if ( !( length(setdiff(sampleName, colnames(eData))) == 0 ) )
            stop("The sample names supplied with the 'parameters' object must coincide with those of the oneChannelExpressionData'.")

        # Check. The length of 'type' must equal the number of samples,
        # that is, the second dimension of the expression data.

        if ( !(length(type) == dim(eData)[2]) )
            stop("'type' information must be supplied for every sample.")

        # Augment the expression data with the 'type' information, then
        # transpose the data so that the samples correspond to the rows.

        df          <- data.frame( t(unclass(eData)) )  # unclass allows the NumericMatrix to be seen as a matrix
        df[,"type"] <- type

        # Construct a numeric vector of indices of data to be used for
        # training from 'isTrainingSample'.

        trainingSamples <- which(isTrainingSample)

        # Develop a classifier for 'type' based on all other data.

        formula <- as.formula( paste("type", "~", ".", sep="") )

        classifierOutput <- MLearn(formula=formula, data=df,
                               dldaI,
                               trainingSamples)

        # Construct SupervisedMachineLearningResult to return.

        # Construct the observed and predicted classifications.  Sort
        # them into 'sampleName' order, then replace the numerical
        # codes by the corresponding factor level from 'type'.

        observedClassification <- c( classifierOutput@testOutcomes,
                                     classifierOutput@trainOutcomes )
        observedClassification <- observedClassification[ sampleName ]
        observedClassification <- levels(type)[ observedClassification ]

        predictedClassification <- c( testPredictions(classifierOutput),
                                      trainPredictions(classifierOutput) )
        predictedClassification <- predictedClassification[ sampleName ]
        predictedClassification <- levels(type)[ predictedClassification ]

        supervisedMachineLearningResult <- new("SupervisedMachineLearningResult",
                                               sampleName=sampleName,
                                               isTrainingSample=isTrainingSample,
                                               observedClassification=as.factor(observedClassification),
                                               predictedClassification=as.factor(predictedClassification),
                                               parameters=parameters
                                              )

        # Return.

        supervisedMachineLearningResult
    }
)

#
# NaiveBayesMachineLearningParameters
#

setMethod(.supervised,
    signature( oneChannelExpressionData = "OneChannelExpressionData",
               parameters               = "NaiveBayesMachineLearningParameters" ),
    function(oneChannelExpressionData, parameters)
    {
        # Unpack data.

        eData            <- expressionMatrix( channelOne(oneChannelExpressionData) )
        sampleName       <- sampleName(parameters)
        isTrainingSample <- isTrainingSample(parameters)
        type             <- type(parameters)

        # Check. The sample names of supplied with the parameters must
        # coincide with those of the data.

        if ( !( length(setdiff(sampleName, colnames(eData))) == 0 ) )
            stop("The sample names supplied with the 'parameters' object must coincide with those of the oneChannelExpressionData'.")

        # Check. The length of 'type' must equal the number of samples,
        # that is, the second dimension of the expression data.

        if ( !(length(type) == dim(eData)[2]) )
            stop("'type' information must be supplied for every sample.")

        # Augment the expression data with the 'type' information, then
        # transpose the data so that the samples correspond to the rows.

        df          <- data.frame( t(unclass(eData)) )  # unclass allows the NumericMatrix to be seen as a matrix
        df[,"type"] <- type

        # Construct a numeric vector of indices of data to be used for
        # training from 'isTrainingSample'.

        trainingSamples <- which(isTrainingSample)

        # Develop a classifier for 'type' based on all other data.

        formula <- as.formula( paste("type", "~", ".", sep="") )

        classifierOutput <- MLearn(formula=formula, data=df,
                               naiveBayesI,
                               trainingSamples)

        # Construct SupervisedMachineLearningResult to return.

        # Construct the observed and predicted classifications.  Sort
        # them into 'sampleName' order, then replace the numerical
        # codes by the corresponding factor level from 'type'.

        observedClassification <- c( classifierOutput@testOutcomes,
                                     classifierOutput@trainOutcomes )
        observedClassification <- observedClassification[ sampleName ]
        observedClassification <- levels(type)[ observedClassification ]

        predictedClassification <- c( testPredictions(classifierOutput),
                                      trainPredictions(classifierOutput) )
        predictedClassification <- predictedClassification[ sampleName ]
        predictedClassification <- levels(type)[ predictedClassification ]

        supervisedMachineLearningResult <- new("SupervisedMachineLearningResult",
                                               sampleName=sampleName,
                                               isTrainingSample=isTrainingSample,
                                               observedClassification=as.factor(observedClassification),
                                               predictedClassification=as.factor(predictedClassification),
                                               parameters=parameters
                                              )

        # Return.

        supervisedMachineLearningResult
    }
)

#
# HierarchicalClusteringMachineLearningParameters
#

setMethod(.unsupervised,
    signature( oneChannelExpressionData = "OneChannelExpressionData",
               parameters               = "HierarchicalClusteringMachineLearningParameters" ),
    function(oneChannelExpressionData, parameters)
    {
        # Unpack data.

        eData            <- expressionMatrix( channelOne(oneChannelExpressionData) )
        linkage          <- tolower( linkage(parameters) )
        distanceMetric   <- tolower( distanceMetric(parameters) )
        numberOfClusters <- numberOfClusters(parameters)

        # Check.

        if ( !(linkage %in% c("complete", "single", "average", "median", "ward")) )
            stop("'clusteringMethod' must be one of 'complete', 'single', 'average', 'median', 'ward'")

        if ( !(distanceMetric %in% c("euclidean", "manhattan", "maximum", "minkowski")) )
            stop("'distanceMetric' must be one of 'euclidean', 'manhattan', 'maximum', 'minkowski'")

        if ( !(numberOfClusters > 1 && numberOfClusters < dim(eData)[2]) )
            stop("'numberOfClusters must be greater than 1 and less than the number of samples")

        # Execute the test. Transpose the data so that the samples correspond
        # to the rows.

        df <- data.frame( t(unclass(eData)) )  # unclass allows the NumericMatrix to be seen as a matrix

        distFun <- .distFuncFactory(distanceMetric)
        clusteringOutput <- MLearn(formula=formula("~."), data=df, 
                              hclustI( distFun=distFun, cutParm=list(k=numberOfClusters) ), method=linkage)

        # Construct UnsupervisedMachineLearningResult to return.

        silhouette           <- clusteringOutput@silhouette

        sampleName           <- colnames( eData )
        predictedPartition   <- as.integer( silhouette[,"cluster"] )
        neighboringPartition <- as.integer( silhouette[,"neighbor"] )
        silhouetteWidth      <- silhouette[,"sil_width"]

        unsupervisedMachineLearningResult <- new("UnsupervisedMachineLearningResult",
                                                 sampleName=sampleName,
                                                 predictedPartition=predictedPartition,
                                                 neighboringPartition=neighboringPartition,
                                                 silhouetteWidth=silhouetteWidth,
                                                 parameters=parameters
                                                )

        # Return.

        unsupervisedMachineLearningResult
    }
)

#
# KMeansMachineLearningParameters
#

setMethod(.unsupervised,
    signature( oneChannelExpressionData = "OneChannelExpressionData",
               parameters               = "KMeansMachineLearningParameters" ),
    function(oneChannelExpressionData, parameters)
    {
        # Unpack data.

        eData            <- expressionMatrix( channelOne(oneChannelExpressionData) )
        numberOfClusters <- numberOfClusters(parameters)
        algorithm        <- algorithm(parameters)
		randomNumberSeed <- randomNumberSeed(parameters)
		
        # Check.

        if ( numberOfClusters <= 0 || numberOfClusters > ncol(eData) )
            stop("'numberOfClusters' must be >0 and <= the number of samples.")

        if ( !(algorithm %in% c("Hartigan-Wong", "Lloyd", "Forgy", "MacQueen")) )
            stop("'algorithm' must be one of 'Hartigan-Wong', 'Lloyd', 'Forgy', 'MacQueen'")

        # Execute the test. Transpose the data so that the samples correspond
        # to the rows.

        df <- data.frame( t(unclass(eData)) )  # unclass allows the NumericMatrix to be seen as a matrix

        clusteringOutput <- MLearn(formula=formula("~."), data=df,
                               kmeansI, centers=numberOfClusters, algorithm=algorithm)

        # Construct UnsupervisedMachineLearningResult to return.

        silhouette <- clusteringOutput@silhouette

        sampleName           <- colnames( eData )
        predictedPartition   <- as.integer( silhouette[,"cluster"] )
        neighboringPartition <- as.integer( silhouette[,"neighbor"] )
        silhouetteWidth      <- silhouette[,"sil_width"]

        unsupervisedMachineLearningResult <- new("UnsupervisedMachineLearningResult",
                                                 sampleName=sampleName,
                                                 predictedPartition=predictedPartition,
                                                 neighboringPartition=neighboringPartition,
                                                 silhouetteWidth=silhouetteWidth,
                                                 parameters=parameters
                                                )

        # Return.

        unsupervisedMachineLearningResult
    }
)

#
# Utility functions
#

.distFuncFactory <- function(method) {
    function(x) {
        dist(x, method=method)
    }
}

#
# supervised.
#

supervised <- function(oneChannelExpressionData, parameters) {
    .supervised(oneChannelExpressionData, parameters)
}

typeInfo(supervised) <-
  SimultaneousTypeSpecification(
    TypedSignature( oneChannelExpressionData = "OneChannelExpressionData",
                    parameters               = "SupervisedMachineLearningParameters" ),
    returnType = "SupervisedMachineLearningResult")

#
# unsupervised.
#

unsupervised <- function(oneChannelExpressionData, parameters) {
    .unsupervised(oneChannelExpressionData, parameters)
}

typeInfo(unsupervised) <-
  SimultaneousTypeSpecification(
    TypedSignature( oneChannelExpressionData = "OneChannelExpressionData",
                    parameters               = "UnsupervisedMachineLearningParameters" ),
    returnType = "UnsupervisedMachineLearningResult")
