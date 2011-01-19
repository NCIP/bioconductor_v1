\name{DiscreteGeneSetAnalysisParameters}
\alias{DiscreteGeneSetAnalysisParameters}

\title{DiscreteGeneSetAnalysisParameters constructor and accessors}

\description{
  Functions for creating and manipulating DiscreteGeneSetAnalysisParameters-class objects.
}

\usage{
DiscreteGeneSetAnalysisParameters( annotation=character(0), discretePValue=0.05,
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

  \item{DiscreteGeneSetAnalysisParameters}{Object of class
    \code{\linkS4class{DiscreteGeneSetAnalysisParameters}}.}

}

\author{Tom Milac \url{tmilac@fhcrc.org}}

\seealso{\code{\linkS4class{DiscreteGeneSetAnalysisParameters}-class},
  \code{\link{annotation}}, \code{\link{discretePValue}},
  \code{\link{testDirection}}.}

\examples{
obj <- DiscreteGeneSetAnalysisParameters( 
                annotation="hgu95av2",            discretePValue=0.05,
                testDirection="over-represented" )
annotation(obj)
discretePValue(obj)
testDirection(obj)
}

\keyword{manip}
