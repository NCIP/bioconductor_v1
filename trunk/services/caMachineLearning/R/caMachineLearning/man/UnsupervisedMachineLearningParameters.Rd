\name{UnsupervisedMachineLearningParameters}
\alias{UnsupervisedMachineLearningParameters}

\title{UnsupervisedMachineLearningParameters constructor and accessors}

\description{
  Functions for creating and manipulating UnsupervisedMachineLearningParameters-class objects.
}

\usage{
UnsupervisedMachineLearningParameters(numberOfClusters=2L)
}

\arguments{

  \item{numberOfClusters}{An integer vector specifying the number of
	clusters sought.}

}

\value{

  \item{UnsupervisedMachineLearningParameters}{Object of class
    \code{\linkS4class{UnsupervisedMachineLearningParameters}}.}

}

\author{Tom Milac \url{tmilac@fhcrc.org}}

\seealso{\code{\linkS4class{UnsupervisedMachineLearningParameters}-class},
  \code{\link{numberOfClusters}}.}

\examples{
obj <- UnsupervisedMachineLearningParameters(numberOfClusters=2L)
numberOfClusters(obj)
}

\keyword{manip}
