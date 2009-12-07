\name{PFAMContinuousGeneSetAnalysisParameters}
\alias{PFAMContinuousGeneSetAnalysisParameters}

\title{PFAMContinuousGeneSetAnalysisParameters constructor and accessors}

\description{
  Functions for creating and manipulating PFAMContinuousGeneSetAnalysisParameters-class objects.
}

\usage{
PFAMContinuousGeneSetAnalysisParameters( annotation=character(0), minimumGenesPerGeneSet=10L)
}

\arguments{

  \item{annotation}{A character vector of length one specifying an annotation package.}

  \item{minimumGenesPerGeneSet}{A numeric vector of length one specifying the required minimum size of a gene set.}

}

\value{

  \item{PFAMContinuousGeneSetAnalysisParameters}{Object of class
    \code{\linkS4class{PFAMContinuousGeneSetAnalysisParameters}}.}

}

\author{Tom Milac \url{tmilac@fhcrc.org}}

\seealso{\code{\linkS4class{PFAMContinuousGeneSetAnalysisParameters}-class},
  \code{\link{annotation}}, \code{\link{minimumGenesPerGeneSet}}.}

\examples{
obj <- PFAMContinuousGeneSetAnalysisParameters(
                annotation="hgu95av2", minimumGenesPerGeneSet=10L )
annotation(obj)
minimumGenesPerGeneSet(obj)
}

\keyword{manip}
