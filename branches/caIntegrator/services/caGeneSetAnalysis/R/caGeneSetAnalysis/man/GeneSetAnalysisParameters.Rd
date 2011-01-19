\name{GeneSetAnalysisParameters}
\alias{GeneSetAnalysisParameters}

\title{GeneSetAnalysisParameters constructor and accessors}

\description{
  Functions for creating and manipulating GeneSetAnalysisParameters-class objects.
}

\usage{
GeneSetAnalysisParameters( annotation=character(0) )
}

\arguments{

  \item{annotation}{A character vector of length one specifying an
	annotation package.}

}

\value{

  \item{GeneSetAnalysisParameters}{Object of class
    \code{\linkS4class{GeneSetAnalysisParameters}}.}

}

\author{Tom Milac \url{tmilac@fhcrc.org}}

\seealso{\code{\linkS4class{GeneSetAnalysisParameters}-class},
  \code{\link{annotation}}.}

\examples{
obj <- GeneSetAnalysisParameters( 
                annotation="hgu95av2" )
annotation(obj)
}

\keyword{manip}
