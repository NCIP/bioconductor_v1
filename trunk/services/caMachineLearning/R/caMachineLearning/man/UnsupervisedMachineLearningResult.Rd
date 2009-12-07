\name{UnsupervisedMachineLearningResult}
\alias{UnsupervisedMachineLearningResult}
\alias{predictedPartition}
\alias{neighboringPartition}
\alias{silhouetteWidth}

\title{UnsupervisedMachineLearningResult constructor and accessors}

\description{
  Functions for creating and manipulating UnsupervisedMachineLearningResult-class objects.
}

\usage{
UnsupervisedMachineLearningResult(sampleName=character(0), predictedPartition=integer(0),
                                  neighboringPartition=integer(0), silhouetteWidth=numeric(0),
                                  parameters=new("UnsupervisedMachineLearningParameters"))
predictedPartition(object, ...)
neighboringPartition(object, ...)
silhouetteWidth(object, ...)
}

\arguments{

  \item{sampleName}{A character vector specifying the sample names.}

  \item{predictedPartition}{An integer vector specifying the cluster to which
    the corresponding sample belongs.}

  \item{neighboringPartition}{An integer vector specifying the neighbor
    cluster of the cluster to which the corresponding sample belongs.}

  \item{silhouetteWidth}{A numeric vector specifying the average dissimilarity
    between the corresponding sample and all other points of the cluster to
    which the corresponding sample belongs.}

  \item{parameters}{The UnsupervisedMachineLearningParameters used to
	direct the analysis}

  \item{object}{An object of class
    \code{UnsupervisedMachineLearningResult}, from which a sampleName,
    predictedPartition, neighboringPartition, silhouetteWidth or
    parameters are to be extracted.}

  \item{\dots}{Additional arguments, passed to the class initialization
    method or (currently) ignored by the accessors.}

}

\value{

  \item{UnsupervisedMachineLearningResult}{Object of class
    \code{\linkS4class{UnsupervisedMachineLearningResult}}.}

  \item{predictedPartition}{integer vector containing the cluster to which
    the corresponding sample belongs.}

  \item{neighboringPartition}{integer vector containing the neighbor
    cluster of the cluster to which the corresponding sample belongs.}

  \item{silhouetteWidth}{numeric vector containing the average dissimilarity
    between the corresponding sample and all other points of the cluster to
    which the corresponding sample belongs.}

}

\author{Tom Milac \url{tmilac@fhcrc.org}}

\seealso{\code{\linkS4class{UnsupervisedMachineLearningResult}-class},
  \code{\link{sampleName}}, \code{\link{parameters}}.}

\examples{
obj <- UnsupervisedMachineLearningResult(sampleName=character(0), predictedPartition=integer(0),
                                         neighboringPartition=factor(), silhouetteWidth=numeric(0),
                                         parameters=new("UnsupervisedMachineLearningParameters"))
sampleName(obj)
predictedPartition(obj)
neighboringPartition(obj)
silhouetteWidth(obj)
parameters(obj)
}

\keyword{manip}
