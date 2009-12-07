\name{KEGGContinuousGeneSetAnalysisParameters}
\alias{KEGGContinuousGeneSetAnalysisParameters}

\title{KEGGContinuousGeneSetAnalysisParameters constructor and accessors}

\description{
  Functions for creating and manipulating KEGGContinuousGeneSetAnalysisParameters-class objects.
}

\usage{
KEGGContinuousGeneSetAnalysisParameters( annotation=character(0), minimumGenesPerGeneSet=10L)
}

\arguments{

  \item{annotation}{A character vector of length one specifying an
	annotation package.}

  \item{minimumGenesPerGeneSet}{A numeric vector of length one
	specifying the required minimum size of a gene set.}

}

\value{

  \item{KEGGContinuousGeneSetAnalysisParameters}{Object of class
    \code{\linkS4class{KEGGContinuousGeneSetAnalysisParameters}}.}

}

\author{Tom Milac \url{tmilac@fhcrc.org}}

\seealso{\code{\linkS4class{KEGGContinuousGeneSetAnalysisParameters}-class},
  \code{\link{annotation}}, \code{\link{minimumGenesPerGeneSet}}.}

\examples{
obj <- KEGGContinuousGeneSetAnalysisParameters(
                annotation="hgu95av2", minimumGenesPerGeneSet=10L )
annotation(obj)
minimumGenesPerGeneSet(obj)
}

\keyword{manip}
