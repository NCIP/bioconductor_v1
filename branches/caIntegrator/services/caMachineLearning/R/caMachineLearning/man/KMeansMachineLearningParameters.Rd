\name{KMeansMachineLearningParameters}
\alias{KMeansMachineLearningParameters}
\alias{algorithm}
\alias{randomNumberSeed}

\title{KMeansMachineLearningParameters constructor and accessors}

\description{
  Functions for creating and manipulating KMeansMachineLearningParameters-class objects.
}

\usage{
KMeansMachineLearningParameters(numberOfClusters=2L, algorithm=character(0))
algorithm(object, ...)
randomNumberSeed(object, ...)
}

\arguments{

  \item{numberOfClusters}{An integer vector specifying the number of
	clusters sought.}

  \item{algorithm}{A character vector specifying whether the k-means
    algorithm to use; one of "Hartigan-Wong", "Lloyd", "Forgy" or
    "MacQueen"}

  \item{object}{An object of class
    \code{KMeansMachineLearningParameters}, from which a
    numberOfClusters, linkage or distanceMetric are to be extracted.}

  \item{\dots}{Additional arguments, passed to the class initialization
    method or (currently) ignored by the accessors.}

}

\value{

  \item{KMeansMachineLearningParameters}{Object of class
    \code{\linkS4class{KMeansMachineLearningParameters}}.}

  \item{algorithm}{character vector of length one containing a the
	k-means algorithm to use.}

  \item{randomNumberSeed}{integer vector of length one containing the
	random number seed.}

}

\author{Tom Milac \url{tmilac@fhcrc.org}}

\seealso{\code{\linkS4class{KMeansMachineLearningParameters}-class},
  \code{\link{numberOfClusters}}.}

\examples{
obj <- KMeansMachineLearningParameters(numberOfClusters=integer(0),
                                       algorithm=character(0))
numberOfClusters(obj)
algorithm(obj)
}

\keyword{manip}
