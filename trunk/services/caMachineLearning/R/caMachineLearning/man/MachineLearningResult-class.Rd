\name{MachineLearningResult-class}
\docType{class}
\alias{MachineLearningResult-class}

\title{Class "MachineLearningResult"}
\description{
  MachineLearningResult is the base class for all unsupervised
  machine learning results classes.
}
\section{Objects from the Class}{

  Objects can be created by calls to the constructor
  \code{\link{MachineLearningResult}}.

  Elements can be accessed with \code{\link{sampleName}}.

}
\section{Slots}{
  \describe{

    \item{\code{sampleName}:}{Object of class \code{"character"} containing the
        sample names.}

  }
}
\section{Methods}{

  See \code{\link{MachineLearningResult}}

}

\author{Tom Milac \url{tmilac@fhcrc.org}}

\seealso{

  \code{\link{MachineLearningResult}} for object construction, accessors
  \code{\link{sampleName}}

}

\examples{
showClass("MachineLearningResult")
obj <- MachineLearningResult(sampleName=character(0))
sampleName(obj)
}
\keyword{classes}
