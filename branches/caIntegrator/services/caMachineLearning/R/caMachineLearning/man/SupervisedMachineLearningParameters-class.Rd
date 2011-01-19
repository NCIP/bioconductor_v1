\name{SupervisedMachineLearningParameters-class}
\docType{class}
\alias{SupervisedMachineLearningParameters-class}

\title{Class "SupervisedMachineLearningParameters"}
\description{
  SupervisedMachineLearningParameters is the base class for all supervised
  machine learning parameters classes and encapsulates the parameters required
  for all supervised machine learning analyses.
}
\section{Objects from the Class}{

  Objects can be created by calls to the constructor
  \code{\link{SupervisedMachineLearningParameters}}.

  Elements can be accessed with \code{\link{sampleName}}, \code{\link{isTrainingSample}}
  and \code{\link{type}}.

}
\section{Slots}{
  \describe{

    \item{\code{sampleName}:}{Object of class \code{"character"} containing the
        sample names.}

    \item{\code{isTrainingSample}:}{Object of class \code{"logical"} indicating
        whether the corresponding sample is a training sample.}

    \item{\code{type}:}{Object of class \code{"factor"} containing
        an indicator of what group or type the corresponding sample belongs to.}

  }
}
\section{Methods}{

  See \code{\link{SupervisedMachineLearningParameters}}

}

\author{Tom Milac \url{tmilac@fhcrc.org}}

\seealso{

  \code{\link{SupervisedMachineLearningParameters}} for object construction, accessors
  \code{\link{sampleName}}
  \code{\link{isTrainingSample}}
  \code{\link{type}}

}

\examples{
showClass("SupervisedMachineLearningParameters")
obj <- SupervisedMachineLearningParameters(sampleName=character(0), isTrainingSample=logical(0), type=factor())
sampleName(obj)
isTrainingSample(obj)
type(obj)
}
\keyword{classes}
