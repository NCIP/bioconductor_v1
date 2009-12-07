\name{ContinuousGeneSetAnalysisParameters}
\alias{ContinuousGeneSetAnalysisParameters}

\title{ContinuousGeneSetAnalysisParameters constructor and accessors}

\description{
  Functions for creating and manipulating ContinuousGeneSetAnalysisParameters-class objects.
}

\usage{
ContinuousGeneSetAnalysisParameters( annotation=character(0), minimumGenesPerGeneSet=10L )
}

\arguments{

  \item{annotation}{A character vector of length one specifying an
	annotation package.}

  \item{minimumGenesPerGeneSet}{A numeric vector of length one
	specifying the required minimum size of a gene set.}

}

\value{

  \item{ContinuousGeneSetAnalysisParameters}{Object of class
    \code{\linkS4class{ContinuousGeneSetAnalysisParameters}}.}

}

\author{Tom Milac \url{tmilac@fhcrc.org}}

\seealso{\code{\linkS4class{ContinuousGeneSetAnalysisParameters}-class}
  \code{\link{annotation}}, \code{\link{minimumGenesPerGeneSet}}.}

\examples{
obj <- ContinuousGeneSetAnalysisParameters(
                annotation="hgu95av2", minimumGenesPerGeneSet=10L )
annotation(obj)
minimumGenesPerGeneSet(obj)
}

\keyword{manip}
