\name{SupportVectorMachineMachineLearningParameters-class}
\docType{class}
\alias{SupportVectorMachineMachineLearningParameters-class}

\title{Class "SupportVectorMachineMachineLearningParameters"}
\description{
  SupportVectorMachineMachineLearningParameters encapsulates the parameters required
  to execute a support vector machine machine learning analysis.
}
\section{Objects from the Class}{

  Objects can be created by calls to the constructor
  \code{\link{SupportVectorMachineMachineLearningParameters}}.

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

  See \code{\link{SupportVectorMachineMachineLearningParameters}}

}

\author{Tom Milac \url{tmilac@fhcrc.org}}

\seealso{

  \code{\link{SupportVectorMachineMachineLearningParameters}} for object construction, accessors
  \code{\link{sampleName}}
  \code{\link{isTrainingSample}}
  \code{\link{type}}

}

\examples{
showClass("SupportVectorMachineMachineLearningParameters")
obj <- SupportVectorMachineMachineLearningParameters(sampleName=character(0), isTrainingSample=logical(0), type=factor())
sampleName(obj)
isTrainingSample(obj)
type(obj)
}
\keyword{classes}
