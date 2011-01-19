\name{SupervisedMachineLearningResult}
\alias{SupervisedMachineLearningResult}
\alias{observedClassification}
\alias{predictedClassification}

\title{SupervisedMachineLearningResult constructor and accessors}

\description{
  Functions for creating and manipulating SupervisedMachineLearningResult-class objects.
}

\usage{
SupervisedMachineLearningResult(sampleName=character(0),
    isTrainingSample=logical(0),
    observedClassification=factor(), predictedClassification=factor(),
    parameters=new("SupervisedMachineLearningParameters"))
observedClassification(object, ...)
predictedClassification(object, ...)
}

\arguments{

  \item{sampleName}{A character vector specifying the sample names.}

  \item{isTrainingSample}{A logical vector specifying whether the
    corresponding sample is a training samplem.}

  \item{observedClassification}{A factor specifying the observed
    classifications of the corresponding sample.}

  \item{predictedClassification}{A factor specifying the predicted
    classification of the corresponding sample.}

  \item{parameters}{The SupervisedMachineLearningParameters used to
  direct the analysis}

  \item{object}{An object of class
    \code{SupervisedMachineLearningResult}, from which a sampleName,
    isTrainingSample, observedClassification or predictedClassification
    are to be extracted.}

  \item{\dots}{Additional arguments, passed to the class initialization
    method or (currently) ignored by the accessors.}

}

\value{

  \item{SupervisedMachineLearningResult}{Object of class
    \code{\linkS4class{SupervisedMachineLearningResult}}.}

  \item{observedClassification}{factor containing the observed
    classification of the sample.}

  \item{predictedClassification}{factor containing the predicted
    classification of the sample.}

}

\author{Tom Milac \url{tmilac@fhcrc.org}}

\seealso{\code{\linkS4class{SupervisedMachineLearningResult}-class},
  \code{\link{sampleName}}, \code{\link{isTrainingSample}},
  \code{\link{parameters}}.}

\examples{
obj <- SupervisedMachineLearningResult(sampleName=character(0), isTrainingSample=logical(0),
                                       observedClassification=factor(), predictedClassification=factor(),
                                       parameters=new("SupervisedMachineLearningParameters"))
sampleName(obj)
isTrainingSample(obj)
observedClassification(obj)
predictedClassification(obj)
parameters(obj)
}

\keyword{manip}
