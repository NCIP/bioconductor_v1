\name{KNearestNeighborsMachineLearningParameters}
\alias{KNearestNeighborsMachineLearningParameters}
\alias{numberOfNeighbors}
\alias{minimumVote}

\title{KNearestNeighborsMachineLearningParameters constructor and accessors}

\description{
  Functions for creating and manipulating KNearestNeighborsMachineLearningParameters-class objects.
}

\usage{
KNearestNeighborsMachineLearningParameters(sampleName=character(0), isTrainingSample=logical(0), type=factor(),
                                           numberOfNeighbors=integer(0), minimumVote=integer(0))
numberOfNeighbors(object, ...)
minimumVote(object, ...)
}

\arguments{

  \item{sampleName}{A character vector specifying the sample names.}

  \item{isTrainingSample}{A logical vector specifying whether the
    corresponding sample is a training samplem.}

  \item{type}{A logical vector specifying the group or type of the corresponding
    sample.}

  \item{numberOfNeighbors}{An integer vector specifying the number of neighbors
    to consider.}

  \item{minimumVote}{An integer vector specifying the minimum number of neighbors
    required to reach a decision.}

  \item{object}{An object of class
    \code{KNearestNeighborsMachineLearningParameters}, from which a
    sampleName, isTrainingSample, type, numberOfNeighbors, or
    minimumVote are to be extracted.}

  \item{\dots}{Additional arguments, passed to the class initialization
    method or (currently) ignored by the accessors.}

}

\value{

  \item{KNearestNeighborsMachineLearningParameters}{Object of class
    \code{\linkS4class{KNearestNeighborsMachineLearningParameters}}.}

  \item{numberOfNeighbors}{integer vector of length one containing the number
    of neighbors to consider.}

  \item{minimumVote}{integer vector of length one containing the minimum
	vote required.}

}

\author{Tom Milac \url{tmilac@fhcrc.org}}

\seealso{\code{\linkS4class{KNearestNeighborsMachineLearningParameters}-class},
  \code{\link{sampleName}}, \code{\link{isTrainingSample}},
  \code{\link{type}}.}

\examples{
obj <- KNearestNeighborsMachineLearningParameters(sampleName=character(0), isTrainingSample=logical(0), type=factor(),
                                                  numberOfNeighbors=integer(0), minimumVote=integer(0))
sampleName(obj)
isTrainingSample(obj)
type(obj)
numberOfNeighbors(obj)
minimumVote(obj)
}

\keyword{manip}
