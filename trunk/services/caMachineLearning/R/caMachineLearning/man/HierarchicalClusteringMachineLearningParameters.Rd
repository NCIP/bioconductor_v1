\name{HierarchicalClusteringMachineLearningParameters}
\alias{HierarchicalClusteringMachineLearningParameters}
\alias{linkage}
\alias{distanceMetric}

\title{HierarchicalClusteringMachineLearningParameters constructor and accessors}

\description{
  Functions for creating and manipulating HierarchicalClusteringMachineLearningParameters-class objects.
}

\usage{
HierarchicalClusteringMachineLearningParameters(numberOfClusters=2L, linkage=character(0), distanceMetric=character(0))
linkage(object, ...)
distanceMetric(object, ...)
}

\arguments{

  \item{numberOfClusters}{An integer vector specifying the number of
	clusters sought.}

  \item{linkage}{A character vector specifying whether the linkage to
    use; one of "Complete", "Single", "Average", "Median" or "Ward".}

  \item{distanceMetric}{A character vector specifying the distance
    metric to use; one of "Euclidean", "Manhattan", "Maximum" or
    "Minkowski"}

  \item{object}{An object of class
    \code{HierarchicalClusteringMachineLearningParameters}, from which a
    numberOfClusters, linkage or distanceMetric are to be extracted.}

  \item{\dots}{Additional arguments, passed to the class initialization
    method or (currently) ignored by the accessors.}

}

\value{

  \item{HierarchicalClusteringMachineLearningParameters}{Object of class
    \code{\linkS4class{HierarchicalClusteringMachineLearningParameters}}.}

  \item{linkage}{character vector of length one containing a linkage.}

  \item{distanceMetric}{character vector of length one containing a distance metric.}

}

\author{Tom Milac \url{tmilac@fhcrc.org}}

\seealso{\code{\linkS4class{HierarchicalClusteringMachineLearningParameters}-class},
  \code{\link{numberOfClusters}}.}

\examples{
obj <- HierarchicalClusteringMachineLearningParameters(numberOfClusters=integer(0), linkage=character(0), distanceMetric=character(0))
numberOfClusters(obj)
linkage(obj)
distanceMetric(obj)
}

\keyword{manip}
