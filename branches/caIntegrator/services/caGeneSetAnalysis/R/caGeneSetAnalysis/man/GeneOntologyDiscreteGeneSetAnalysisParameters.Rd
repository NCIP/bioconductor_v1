\name{GeneOntologyDiscreteGeneSetAnalysisParameters}
\alias{GeneOntologyDiscreteGeneSetAnalysisParameters}

\title{GeneOntologyDiscreteGeneSetAnalysisParameters constructor and accessors}

\description{
  Functions for creating and manipulating GeneOntologyDiscreteGeneSetAnalysisParameters-class objects.
}

\usage{
GeneOntologyDiscreteGeneSetAnalysisParameters( annotation=character(0), discretePValue=0.05,
                                               testDirection="over-represented", ontology="BP" )
}

\arguments{

  \item{annotation}{A character vector of length one specifying an
	annotation package.}

  \item{discretePValue}{A numeric vector of length one specifying a
	threshold p-value.}

  \item{testDirection}{A character vector of length one specifying one
	of "over-represented" or "under-represented".}

  \item{ontology}{A character vector of length one specifying a GO
    ontology, i.e., one of "BP", "CC", or "MF".}

}

\value{

  \item{GeneOntologyDiscreteGeneSetAnalysisParameters}{Object of class
    \code{\linkS4class{GeneOntologyDiscreteGeneSetAnalysisParameters}}.}

}

\author{Tom Milac \url{tmilac@fhcrc.org}}

\seealso{\code{\linkS4class{GeneOntologyDiscreteGeneSetAnalysisParameters}-class},
  \code{\link{annotation}}, \code{\link{discretePValue}},
  \code{\link{testDirection}}, \code{\link{ontology}}.}

\examples{
obj <- GeneOntologyDiscreteGeneSetAnalysisParameters( 
                annotation="hgu95av2",            discretePValue=0.05,
                testDirection="over-represented", ontology="BP" )
annotation(obj)
discretePValue(obj)
testDirection(obj)
ontology(obj)
}

\keyword{manip}
