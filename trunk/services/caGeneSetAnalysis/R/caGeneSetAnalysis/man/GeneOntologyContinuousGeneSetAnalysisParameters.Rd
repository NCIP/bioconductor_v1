\name{GeneOntologyContinuousGeneSetAnalysisParameters}
\alias{GeneOntologyContinuousGeneSetAnalysisParameters}

\title{GeneOntologyContinuousGeneSetAnalysisParameters constructor and accessors}

\description{
  Functions for creating and manipulating GeneOntologyContinuousGeneSetAnalysisParameters-class objects.
}

\usage{
GeneOntologyContinuousGeneSetAnalysisParameters( annotation=character(0), minimumGenesPerGeneSet=10L,
                                                 ontology="BP" )
}

\arguments{

  \item{annotation}{A character vector of length one specifying an
	annotation package.}

  \item{minimumGenesPerGeneSet}{A numeric vector of length one
	specifying the required minimum size of a gene set.}

  \item{ontology}{A character vector of length one specifying a GO
    ontology, i.e., one of "BP", "CC", or "MF".}

}

\value{

  \item{GeneOntologyContinuousGeneSetAnalysisParameters}{Object of class
    \code{\linkS4class{GeneOntologyContinuousGeneSetAnalysisParameters}}.}

}

\author{Tom Milac \url{tmilac@fhcrc.org}}

\seealso{\code{\linkS4class{GeneOntologyContinuousGeneSetAnalysisParameters}-class},
  \code{\link{annotation}}, \code{\link{minimumGenesPerGeneSet}},
  \code{\link{ontology}}.}

\examples{
obj <- GeneOntologyContinuousGeneSetAnalysisParameters(
                annotation="hgu95av2", minimumGenesPerGeneSet=10L,
                ontology="BP" )
annotation(obj)
minimumGenesPerGeneSet(obj)
ontology(obj)
}

\keyword{manip}
