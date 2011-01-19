#
# MachineLearningParameters
#

setClass("MachineLearningParameters",
         representation=representation(),
         prototype=prototype()
        )

MachineLearningParameters <- function()
{
    new ("MachineLearningParameters")
}

#
# SupervisedMachineLearningParameters
#

setClass("SupervisedMachineLearningParameters",
         contains="MachineLearningParameters",
         representation=representation(
            sampleName="character",
            isTrainingSample="logical",
            type="factor"                     # Learn classifier for 'type'
                                              # based on all other variables.
         ),
         prototype=prototype(
            sampleName=character(0),
            isTrainingSample=logical(0),
            type=factor()
         )
        )

SupervisedMachineLearningParameters <- function(sampleName=character(0),
                                                isTrainingSample=logical(0),
                                                type=factor())
{
    new ( "SupervisedMachineLearningParameters",
             sampleName=sampleName,
             isTrainingSample=isTrainingSample,
             type=as.factor(type)
        )
}

setValidity("SupervisedMachineLearningParameters",
            function(object) {
                msg <- NULL

                sampleName <- sampleName(object)
                isTrainingSample <- isTrainingSample(object)
                type <- type(object)
                if ( !(length(unique(c( length(sampleName), length(isTrainingSample), length(type) ))) == 1) )
                    msg <- c(msg, "The lengths of 'sampleName', 'isTrainingSample' and 'type' must be the same.")

                if (is.null(msg)) TRUE
                    else msg
            }
           )

sampleName <- function(object, ...) {
    slot(object, "sampleName")
}

isTrainingSample <- function(object, ...) {
    slot(object, "isTrainingSample")
}

type <- function(object, ...) {
    slot(object, "type")
}

#
# KNearestNeighborsMachineLearningParameters (KNN)
#

setClass("KNearestNeighborsMachineLearningParameters",
         contains="SupervisedMachineLearningParameters",
         representation=representation(
            numberOfNeighbors="integer",     # Number of neighbors considered
            minimumVote="integer"            # Minimum vote for definite decision
         ),
         prototype=prototype(
            numberOfNeighbors=1L,
            minimumVote=0L
         )
        )

KNearestNeighborsMachineLearningParameters <- function( sampleName=character(0),
                                                        isTrainingSample=logical(0),
                                                        type=factor(),
                                                        numberOfNeighbors=integer(0),
                                                        minimumVote=integer(0)
                                                      )
{
    new ( "KNearestNeighborsMachineLearningParameters",
              sampleName=sampleName,
              isTrainingSample=isTrainingSample,
              type=as.factor(type),
              numberOfNeighbors=numberOfNeighbors,
              minimumVote=minimumVote
        )
}

numberOfNeighbors <- function(object, ...) {
    slot(object, "numberOfNeighbors")
}

minimumVote <- function(object, ...) {
    slot(object, "minimumVote")
}

# SupportVectorMachineMachineLearningParameters (SVM)

setClass("SupportVectorMachineMachineLearningParameters",
         contains="SupervisedMachineLearningParameters",
         representation=representation(
         ),
         prototype=prototype(
         )
        )

SupportVectorMachineMachineLearningParameters <- function( sampleName=character(0),
                                                           isTrainingSample=logical(0),
                                                           type=factor() )
{
    new( "SupportVectorMachineMachineLearningParameters",
              sampleName=sampleName,
              isTrainingSample=isTrainingSample,
              type=as.factor(type)
       )
}

# LinearDiscriminantAnalysisMachineLearningParameters (LDA)

setClass("LinearDiscriminantAnalysisMachineLearningParameters",
         contains="SupervisedMachineLearningParameters",
         representation=representation(
         ),
         prototype=prototype(
         )
        )

LinearDiscriminantAnalysisMachineLearningParameters <- function( sampleName=character(0),
                                                                 isTrainingSample=logical(0),
                                                                 type=factor() )
{
    new( "LinearDiscriminantAnalysisMachineLearningParameters",
              sampleName=sampleName,
              isTrainingSample=isTrainingSample,
              type=as.factor(type)
       )
}

# DiagonalLinearDiscriminantAnalysisMachineLearningParameters (DLDA)

setClass("DiagonalLinearDiscriminantAnalysisMachineLearningParameters",
         contains="SupervisedMachineLearningParameters",
         representation=representation(
         ),
         prototype=prototype(
         )
        )

DiagonalLinearDiscriminantAnalysisMachineLearningParameters <- function( sampleName=character(0),
                                                                         isTrainingSample=logical(0),
                                                                         type=factor() )
{
    new( "DiagonalLinearDiscriminantAnalysisMachineLearningParameters",
              sampleName=sampleName,
              isTrainingSample=isTrainingSample,
              type=as.factor(type)
       )
}

# QuadraticDiscriminantAnalysisMachineLearningParameters (QDA)

#setClass("QuadraticDiscriminantAnalysisMachineLearningParameters",
#         contains="SupervisedMachineLearningParameters",
#         representation=representation(
#        ),
#        prototype=prototype(
#         )
#        )
#
#QuadraticDiscriminantAnalysisMachineLearningParameters <- function( sampleName=character(0),
#                                                                    isTrainingSample=logical(0),
#                                                                    type=factor() )
#{
#    new( "QuadraticDiscriminantAnalysisMachineLearningParameters",
#              sampleName=sampleName,
#              isTrainingSample=isTrainingSample,
#              type=as.factor(type)
#       )
#}

# NaiveBayesMachineLearningParameters

setClass("NaiveBayesMachineLearningParameters",
         contains="SupervisedMachineLearningParameters",
         representation=representation(
         ),
         prototype=prototype(
         )
        )

NaiveBayesMachineLearningParameters <- function( sampleName=character(0),
                                                 isTrainingSample=logical(0),
                                                 type=factor() )
{
    new( "NaiveBayesMachineLearningParameters",
              sampleName=sampleName,
              isTrainingSample=isTrainingSample,
              type=as.factor(type)
       )
}

#
# UnsupervisedMachineLearningParameters
#

setClass("UnsupervisedMachineLearningParameters",
         contains="MachineLearningParameters",
         representation=representation(
            numberOfClusters="integer"
         ),
         prototype=prototype(
            numberOfClusters=2L
         )
        )

UnsupervisedMachineLearningParameters <- function(numberOfClusters=2L)
{
    new ( "UnsupervisedMachineLearningParameters",
                numberOfClusters=numberOfClusters
        )
}

numberOfClusters <- function(object, ...) {
    slot(object, "numberOfClusters")
}

#
# HierarchicalClusteringMachineLearningParameters
#

setClass("HierarchicalClusteringMachineLearningParameters",
         contains="UnsupervisedMachineLearningParameters",
         representation=representation(
            linkage="character",          # One of "Complete", "Single", "Average", "Median", "Ward"
            distanceMetric="character"    # One of "Euclidean", "Manhattan", "Maximum" or "Minkowski"
         ),
         prototype=prototype(
            linkage="Complete",
            distanceMetric="Euclidean"
         )
        )

HierarchicalClusteringMachineLearningParameters <- function( numberOfClusters=2L,
                                                             linkage=character(0),
                                                             distanceMetric=character(0)
                                                           )
{
    new( "HierarchicalClusteringMachineLearningParameters",
              numberOfClusters=numberOfClusters,
              linkage=linkage,
              distanceMetric=distanceMetric
       )
}

linkage <- function(object, ...) {
    slot(object, "linkage")
}

distanceMetric <- function(object, ...) {
    slot(object, "distanceMetric")
}
    
#
# KMeansMachineLearningParameters
#

setClass("KMeansMachineLearningParameters",
         contains="UnsupervisedMachineLearningParameters",
         representation=representation(
            algorithm="character",        # One of "Hartigan-Wong", "Lloyd", "Forgy", "MacQueen"
			randomNumberSeed="integer"
         ),
         prototype=prototype(
            algorithm="Hartigan-Wong", 
			randomNumberSeed=0L
         )
        )

KMeansMachineLearningParameters <- function(numberOfClusters=2L, algorithm=character(0))
{
    new( "KMeansMachineLearningParameters",
              numberOfClusters=numberOfClusters,
              algorithm=algorithm
       )
}

algorithm <- function(object, ...) {
    slot(object, "algorithm")
}

#
# MachineLearningResult
#

setClass("MachineLearningResult",
         representation=representation(
            sampleName="character"
         ),
         prototype=prototype(
            sampleName=character(0)
         )
        )

MachineLearningResult <- function(sampleName=character(0))
{
    new( "SupervisedMachineLearningResult",
         sampleName=sampleName
       )
}

#
# SupervisedMachineLearningResult
#

setClass("SupervisedMachineLearningResult",
         contains="MachineLearningResult",
         representation=representation(
            isTrainingSample="logical",
            observedClassification="factor",
            predictedClassification="factor",
            parameters="SupervisedMachineLearningParameters"
         ),
         prototype=prototype(
            isTrainingSample=logical(0),
            observedClassification=factor(),
            predictedClassification=factor(),
            parameters=new("SupervisedMachineLearningParameters")
         )
        )

SupervisedMachineLearningResult <- function( sampleName=character(0),
                                             isTrainingSample=logical(0),
                                             observedClassification=factor(),
                                             predictedClassification=factor(),
                                             parameters=new("SupervisedMachineLearningParameters"))
{
    new( "SupervisedMachineLearningResult",
           sampleName=sampleName,
           isTrainingSample=isTrainingSample,
           observedClassification=as.factor(observedClassification),
           predictedClassification=as.factor(predictedClassification),
           parameters=parameters
       )
}

observedClassification <- function(object, ...) {
    slot(object, "observedClassification")
}

predictedClassification <- function(object, ...) {
    slot(object, "predictedClassification")
}

parameters <- function(object, ...) {
    slot(object, "parameters")
}

setValidity("SupervisedMachineLearningResult",
            function(object) {
                msg <- NULL

                sampleName              <- sampleName(object)
                isTrainingSample        <- isTrainingSample(object)
                observedClassification  <- observedClassification(object)
                predictedClassification <- predictedClassification(object)
                if ( !(length(unique(c( length(sampleName), length(isTrainingSample),
                       length(observedClassification), length(predictedClassification) ))) == 1) )
                    msg <- c(msg, "The lengths of 'sampleName', 'isTrainingSample', 'observedClassification' and 'predictedClassification' must be the same.")

                if (is.null(msg)) TRUE
                    else msg
            }
           )

#
# UnsupervisedMachineLearningResult
#

setClass("UnsupervisedMachineLearningResult",
         contains="MachineLearningResult",
         representation=representation(
            predictedPartition="integer",   # predictedPartition(i) is the cluster to which
                                            # sample i belongs
            neighboringPartition="integer", # neighboringPartition(i) is the neighbor cluster of
                                            # sample i
            silhouetteWidth="numeric",      # silhouetteWidth(i) is the silhouette
                                            # width of sample i, i.e., the avg
                                            # dissimilarity between i and all other
                                            # points of the cluster to which i belongs
            parameters="UnsupervisedMachineLearningParameters"
         ),
         prototype=prototype(
            predictedPartition=integer(0),
            neighborPartition=integer(0),
            silhouetteWidth=numeric(0),
            parameters=new("UnsupervisedMachineLearningParameters")
         )
        )

UnsupervisedMachineLearningResult <- function( sampleName=character(0),
                                               predictedPartition=integer(0),
                                               neighboringPartition=integer(0),
                                               silhouetteWidth=numeric(0),
                                               parameters=new("UnsupervisedMachineLearningParameters"))
{
    new ( "UnsupervisedMachineLearningResult",
            sampleName=sampleName,
            predictedPartition=predictedPartition,
            neighboringPartition=neighboringPartition,
            silhouetteWidth=silhouetteWidth,
            parameters=parameters
        )
}

predictedPartition <- function(object, ...) {
    slot(object, "predictedPartition")
}

neighboringPartition <- function(object, ...) {
    slot(object, "neighboringPartition")
}

silhouetteWidth <- function(object, ...) {
    slot(object, "silhouetteWidth")
}

randomNumberSeed <- function(object, ...) {
	slot(object, "randomNumberSeed")
}

setValidity("UnsupervisedMachineLearningResult",
            function(object) {
                msg <- NULL

                sampleName           <- sampleName(object)
                predictedPartition   <- predictedPartition(object)
                neighboringPartition <- neighboringPartition(object)
                silouhetteWidth <- silhouetteWidth(object)
                if ( !(length(unique(c( length(sampleName), length(predictedPartition),
                       length(neighboringPartition), length(silouhetteWidth) ))) == 1) )
                    msg <- c(msg, "The lengths of 'sampleName', 'predictedPartition', 'neighboringPartition' and 'silhouetteWidth' must be the same.")

                if (is.null(msg)) TRUE
                    else msg
            }
           )
