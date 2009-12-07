\name{KMeansMachineLearningParameters-class}
\docType{class}
\alias{KMeansMachineLearningParameters-class}

\title{Class "KMeansMachineLearningParameters"}
\description{
  KMeansMachineLearningParameters encapsulates the parameters required
  for to execute a k-means machine learning analyses.
}
\section{Objects from the Class}{

  Objects can be created by calls to the constructor
  \code{\link{KMeansMachineLearningParameters}}.

  Elements can be accessed with \code{\link{numberOfClusters}},
  \code{\link{algorithm}}, and \code{\link{randomNumberSeed}}.

}
\section{Slots}{
  \describe{

    \item{\code{numberOfClusters}:}{Object of class \code{"integer"}
      containing the number of clusters sought.}

    \item{\code{algorithm}:}{Object of class \code{"character"}
      indicating the k-means algorithm to use; one of "Hartigan-Wong",
      "Lloyd", "Forgy" or "MacQueen".}

	\item{\code{randomNumberSeed}:}{Object of class \code{"integer"}
	  used to seed the random number generator.}

  }
}
\section{Methods}{

  See \code{\link{KMeansMachineLearningParameters}}

}

\author{Tom Milac \url{tmilac@fhcrc.org}}

\seealso{

  \code{\link{KMeansMachineLearningParameters}} for object construction, accessors
  \code{\link{numberOfClusters}}
  \code{\link{algorithm}}
  \code{\link{randomNumberSeed}}.

}

\examples{
showClass("KMeansMachineLearningParameters")
obj <- KMeansMachineLearningParameters(numberOfClusters=2L, algorithm=character(0))
numberOfClusters(obj)
algorithm(obj)
}
\keyword{classes}
