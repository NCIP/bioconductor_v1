\name{PFAMDiscreteGeneSetAnalysisParameters}
\alias{PFAMDiscreteGeneSetAnalysisParameters}

\title{PFAMDiscreteGeneSetAnalysisParameters constructor and accessors}

\description{
  Functions for creating and manipulating PFAMDiscreteGeneSetAnalysisParameters-class objects.
}

\usage{
PFAMDiscreteGeneSetAnalysisParameters( annotation=character(0), discretePValue=0.05,
                                       testDirection="over-represented" )
}

\arguments{

  \item{annotation}{A character vector of length one specifying an
	annotation package.}

  \item{discretePValue}{A numeric vector of length one specifying a
	threshold p-value.}

  \item{testDirection}{A character vector of length one specifying one
	of "over-represented" or "under-represented".}

}

\value{

  \item{PFAMDiscreteGeneSetAnalysisParameters}{Object of class
    \code{\linkS4class{PFAMDiscreteGeneSetAnalysisParameters}}.}

}

\author{Tom Milac \url{tmilac@fhcrc.org}}

\seealso{\code{\linkS4class{PFAMDiscreteGeneSetAnalysisParameters}-class},
  \code{\link{annotation}}, \code{\link{discretePValue}},
  \code{\link{testDirection}}.}

\examples{
obj <- PFAMDiscreteGeneSetAnalysisParameters(
                annotation="hgu95av2", discretePValue=0.05,
                testDirection="over-represented" )
annotation(obj)
discretePValue(obj)
testDirection(obj)
}

\keyword{manip}
