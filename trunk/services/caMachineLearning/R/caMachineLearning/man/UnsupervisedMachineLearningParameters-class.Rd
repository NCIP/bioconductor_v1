\name{UnsupervisedMachineLearningParameters-class}
\docType{class}
\alias{UnsupervisedMachineLearningParameters-class}

\title{Class "UnsupervisedMachineLearningParameters"}
\description{
  UnsupervisedMachineLearningParameters is the base class for all unsupervised
  machine learning parameters classes and encapsulates the parameters required
  for all unsupervised machine learning analyses.
}
\section{Objects from the Class}{

  Objects can be created by calls to the constructor
  \code{\link{UnsupervisedMachineLearningParameters}}.

  Elements can be accessed with \code{\link{numberOfClusters}}.

}
\section{Slots}{
  \describe{

    \item{\code{numberOfClusters}:}{Object of class \code{"integer"} containing the
        number of clusters sought.}

  }
}
\section{Methods}{

  See \code{\link{UnsupervisedMachineLearningParameters}}

}

\author{Tom Milac \url{tmilac@fhcrc.org}}

\seealso{

  \code{\link{UnsupervisedMachineLearningParameters}} for object construction, accessors
  \code{\link{numberOfClusters}}

}

\examples{
showClass("UnsupervisedMachineLearningParameters")
obj <- UnsupervisedMachineLearningParameters(numberOfClusters=2L)
numberOfClusters(obj)
}
\keyword{classes}
