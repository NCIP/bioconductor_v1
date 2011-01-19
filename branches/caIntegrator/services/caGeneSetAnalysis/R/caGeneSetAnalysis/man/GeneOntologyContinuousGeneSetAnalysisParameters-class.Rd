\name{GeneOntologyContinuousGeneSetAnalysisParameters-class}
\docType{class}
\alias{GeneOntologyContinuousGeneSetAnalysisParameters-class}

\title{Class "GeneOntologyContinuousGeneSetAnalysisParameters"}
\description{
  GeneOntologyContinuousGeneSetAnalysisParameters represents the parameters needed
  to run a gene set enrichment analysis with one of the GO ontologies using methods
  supplied by the 'GSEABase' package .
}
\section{Objects from the Class}{

  Objects can be created by calls to the constructor
  \code{\link{GeneOntologyContinuousGeneSetAnalysisParameters}}.

  Elements can be accessed with \code{\link{annotation}}, \code{\link{minimumGenesPerGeneSet}},
  and \code{\link{ontology}}.

}
\section{Slots}{
  \describe{

    \item{\code{annotation}:}{Object of class \code{"character"} containing the
        name of an annotation package.}

    \item{\code{minimumGenesPerGeneSet}:}{Object of class \code{"numeric"} containing the
        minimum required size of a gene set.}

    \item{\code{ontology}:}{Object of class \code{"character"} containing one
        of the values "BP", "CC" or "MF".}

  }
}
\section{Methods}{

  See \code{\link{GeneOntologyContinuousGeneSetAnalysisParameters}}

}

\author{Tom Milac \url{tmilac@fhcrc.org}}

\seealso{

  \code{\link{GeneOntologyContinuousGeneSetAnalysisParameters}} for object construction, accessors
  \code{\link{annotation}}, \code{\link{minimumGenesPerGeneSet}}, and \code{\link{ontology}}

}

\examples{
showClass("GeneOntologyContinuousGeneSetAnalysisParameters")
GeneOntologyContinuousGeneSetAnalysisParameters()
}
\keyword{classes}
