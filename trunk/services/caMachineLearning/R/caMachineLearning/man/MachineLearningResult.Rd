\name{MachineLearningResult}
\alias{MachineLearningResult}

\title{MachineLearningResult constructor and accessors}

\description{
  Functions for creating and manipulating MachineLearningResult-class objects.
}

\usage{
MachineLearningResult(sampleName=character(0))
}

\arguments{

  \item{sampleName}{A character vector of the sample names.}

}

\value{

  \item{MachineLearningResult}{Object of class
    \code{\linkS4class{MachineLearningResult}}.}

}

\author{Tom Milac \url{tmilac@fhcrc.org}}

\seealso{\code{\linkS4class{MachineLearningResult}-class},
  \code{\link{sampleName}}.}

\examples{
obj <- MachineLearningResult(sampleName=character(0))
sampleName(obj)
}

\keyword{manip}
