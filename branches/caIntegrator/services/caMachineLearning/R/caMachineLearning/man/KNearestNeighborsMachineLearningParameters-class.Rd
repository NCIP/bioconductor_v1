\name{KNearestNeighborsMachineLearningParameters-class}
\docType{class}
\alias{KNearestNeighborsMachineLearningParameters-class}

\title{Class "KNearestNeighborsMachineLearningParameters"}
\description{
  KNearestNeighborsMachineLearningParameters encapsulates the parameters 
  required for executing a k-nearest neighbors analysis.
}
\section{Objects from the Class}{

  Objects can be created by calls to the constructor
  \code{\link{KNearestNeighborsMachineLearningParameters}}.

  Elements can be accessed with \code{\link{sampleName}}, \code{\link{isTrainingSample}},
  \code{\link{type}}, \code{\link{numberOfNeighbors}} and \code{\link{minimumVote}}.

}
\section{Slots}{
  \describe{

    \item{\code{sampleName}:}{Object of class \code{"character"} containing the
        sample names.}

    \item{\code{isTrainingSample}:}{Object of class \code{"logical"} indicating
        whether the corresponding sample is a training sample.}

    \item{\code{type}:}{Object of class \code{"factor"} containing
        an indicator of what group or type the corresponding sample belongs to.}

    \item{\code{numberOfNeighbors}:}{Object of class \code{"integer"} containing
        the number of neighbors to consider.}

    \item{\code{minimumVote}:}{Object of class \code{"integer"} containing
        the minimum number of neighbors required for a decision.}

  }
}
\section{Methods}{

  See \code{\link{KNearestNeighborsMachineLearningParameters}}

}

\author{Tom Milac \url{tmilac@fhcrc.org}}

\seealso{

  \code{\link{KNearestNeighborsMachineLearningParameters}} for object construction, accessors
  \code{\link{sampleName}}
  \code{\link{isTrainingSample}}
  \code{\link{type}}
  \code{\link{numberOfNeighbors}}
  \code{\link{minimumVote}}

}

\examples{
showClass("KNearestNeighborsMachineLearningParameters")
obj <- KNearestNeighborsMachineLearningParameters(
            sampleName=character(0), isTrainingSample=logical(), type=factor(),
            numberOfNeighbors=integer(0), minimumVote=integer(0))
sampleName(obj)
isTrainingSample(obj)
type(obj)
numberOfNeighbors(obj)
minimumVote(obj)
}
\keyword{classes}
