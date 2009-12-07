\name{SupervisedMachineLearningResult-class}
\docType{class}
\alias{SupervisedMachineLearningResult-class}

\title{Class "SupervisedMachineLearningResult"}
\description{
  SupervisedMachineLearningResult encapsulates the data returned
  from a supervised machine learning analysis.
}
\section{Objects from the Class}{

  Objects can be created by calls to the constructor
  \code{\link{SupervisedMachineLearningResult}}.

  Elements can be accessed with \code{\link{sampleName}},
  \code{\link{isTrainingSample}}, \code{\link{observedClassification}},
  \code{\link{predictedClassification}} and \code{\link{parameters}}.

}
\section{Slots}{
  \describe{

    \item{\code{sampleName}:}{Object of class \code{"character"} containing the
        sample names.}

    \item{\code{isTrainingSample}:}{Object of class \code{"logical"} indicating
        whether the corresponding sample is a training sample.}

    \item{\code{observedClassification}:}{Object of class \code{"factor"} containing
        the observed classification of the sample.}

    \item{\code{predictedClassification}:}{Object of class \code{"factor"} containing
        the predicted classification of the sample.}

    \item{\code{parameters}:}{Object of class \code{"SupervisedMachineLearningParameters"}
        containing the SupervisedMachineLearningParameters class which directed the
        analysis.}

  }
}
\section{Methods}{

  See \code{\link{SupervisedMachineLearningResult}}

}

\author{Tom Milac \url{tmilac@fhcrc.org}}

\seealso{

  \code{\link{SupervisedMachineLearningResult}} for object construction, accessors
  \code{\link{sampleName}}
  \code{\link{isTrainingSample}}
  \code{\link{observedClassification}}
  \code{\link{predictedClassification}}
  \code{\link{parameters}}

}

\examples{
showClass("SupervisedMachineLearningResult")
obj <- SupervisedMachineLearningResult(
            sampleName=character(0), isTrainingSample=logical(0),
            observedClassification=factor(), predictedClassification=factor(),
            parameters=new("SupervisedMachineLearningParameters"))
sampleName(obj)
isTrainingSample(obj)
observedClassification(obj)
predictedClassification(obj)
parameters(obj)
}
\keyword{classes}
