\name{HierarchicalClusteringMachineLearningParameters-class}
\docType{class}
\alias{HierarchicalClusteringMachineLearningParameters-class}

\title{Class "HierarchicalClusteringMachineLearningParameters"}
\description{
  HierarchicalClusteringMachineLearningParameters encapsulates the parameters required
  for to execute a hierarchical clustering machine learning analyses.
}
\section{Objects from the Class}{

  Objects can be created by calls to the constructor
  \code{\link{HierarchicalClusteringMachineLearningParameters}}.

  Elements can be accessed with \code{\link{numberOfClusters}}, \code{\link{linkage}}
  and \code{\link{distanceMetric}}.

}
\section{Slots}{
  \describe{

    \item{\code{numberOfClusters}:}{Object of class \code{"integer"} containing the
        number of clusters sought.}

    \item{\code{linkage}:}{Object of class \code{"character"} indicating
        the linkage method to use; one of "Complete", "Single", "Average", "Median", or "Ward".}

    \item{\code{distanceMetric}:}{Object of class \code{"character"} containing
        the distance metric to use; one of "Euclidean", "Manhattan", "Maximum" or "Minkowski".}

  }
}
\section{Methods}{

  See \code{\link{HierarchicalClusteringMachineLearningParameters}}

}

\author{Tom Milac \url{tmilac@fhcrc.org}}

\seealso{

  \code{\link{HierarchicalClusteringMachineLearningParameters}} for object construction, accessors
  \code{\link{numberOfClusters}}
  \code{\link{linkage}}
  \code{\link{distanceMetric}}

}

\examples{
showClass("HierarchicalClusteringMachineLearningParameters")
obj <- HierarchicalClusteringMachineLearningParameters(numberOfClusters=2L, linkage=character(0), distanceMetric=character(0))
numberOfClusters(obj)
linkage(obj)
distanceMetric(obj)
}
\keyword{classes}
