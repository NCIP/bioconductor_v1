\name{SupervisedMachineLearningParameters}
\alias{SupervisedMachineLearningParameters}

\title{SupervisedMachineLearningParameters constructor and accessors}

\description{
  Functions for creating and manipulating SupervisedMachineLearningParameters-class objects.
}

\usage{
SupervisedMachineLearningParameters(sampleName=character(0), isTrainingSample=logical(0), type=factor())
}

\arguments{

  \item{sampleName}{A character vector specifying the sample names.}

  \item{isTrainingSample}{A logical vector specifying whether the
    corresponding sample is a training samplem.}

  \item{type}{A logical vector specifying the group or type of the
    corresponding sample.}

}

\value{

  \item{SupervisedMachineLearningParameters}{Object of class
    \code{\linkS4class{SupervisedMachineLearningParameters}}.}

}

\author{Tom Milac \url{tmilac@fhcrc.org}}

\seealso{\code{\linkS4class{SupervisedMachineLearningParameters}-class},
  \code{\link{sampleName}}, \code{\link{isTrainingSample}},
  \code{\link{type}}.}

\examples{
obj <- SupervisedMachineLearningParameters(sampleName=character(0), isTrainingSample=logical(0), type=factor())
sampleName(obj)
isTrainingSample(obj)
type(obj)
}

\keyword{manip}
