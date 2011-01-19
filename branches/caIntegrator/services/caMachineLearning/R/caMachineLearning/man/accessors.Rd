\name{accessors}
\alias{isTrainingSample}
\alias{numberOfClusters}
\alias{parameters}
\alias{sampleName}
\alias{type}

\title{Accessor functions shared across several classes}

\description{
  Functions for accessing contents of class instances.
}

\usage{
isTrainingSample(object, ...)
numberOfClusters(object, ...)
parameters(object, ...)
sampleName(object, ...)
type(object, ...)
}

\arguments{

  \item{object}{An object from which an information can be
    extracted. Relevant objects include:

	isTrainingSample
	\linkS4class{DiagonalLinearDiscriminantAnalysisMachineLearningParameters}
	\linkS4class{KNearestNeighborsMachineLearningParameters}
	\linkS4class{LinearDiscriminantAnalysisMachineLearningParameters}
	\linkS4class{NaiveBayesMachineLearningParameters}
	\linkS4class{SupervisedMachineLearningParameters}
	\linkS4class{SupervisedMachineLearningResult}
	\linkS4class{SupportVectorMachineMachineLearningParameters}

	numberOfClusters
	\linkS4class{HierarchicalClusteringMachineLearningParameters}
	\linkS4class{KMeansMachineLearningParameters}
	\linkS4class{UnsupervisedMachineLearningParameters}

	parameters
	\linkS4class{SupervisedMachineLearningResult}
	\linkS4class{UnsupervisedMachineLearningResult}

	sampleName
	\linkS4class{DiagonalLinearDiscriminantAnalysisMachineLearningParameters}
	\linkS4class{KNearestNeighborsMachineLearningParameters}
	\linkS4class{LinearDiscriminantAnalysisMachineLearningParameters}
	\linkS4class{MachineLearningResult.Rd NaiveBayesMachineLearningParameters}
	\linkS4class{SupervisedMachineLearningParameters}
	\linkS4class{SupervisedMachineLearningResult}
	\linkS4class{SupportVectorMachineMachineLearningParameters}
	\linkS4class{UnsupervisedMachineLearningResult}

	type
	\linkS4class{DiagonalLinearDiscriminantAnalysisMachineLearningParameters}
	\linkS4class{KNearestNeighborsMachineLearningParameters}
	\linkS4class{LinearDiscriminantAnalysisMachineLearningParameters}
	\linkS4class{NaiveBayesMachineLearningParameters}
	\linkS4class{SupervisedMachineLearningParameters}
	\linkS4class{SupportVectorMachineMachineLearningParameters}

  }

  \item{\dots}{Additional arguments, (currently) ignored.}

}

\value{
  
  
  \item{sampleName}{character vector containing the sample names.}

  \item{isTrainingSample}{logical vector indicating whether the
    corresponding sample is a training sample.}

  \item{numberOfClusters}{integer vector of length one containing the
	number of clusters sought.}

  \item{type}{character vector containing the group or type of the
    corresponding sample.}
  
}

\author{Tom Milac \url{tmilac@fhcrc.org}}

\keyword{manip}
