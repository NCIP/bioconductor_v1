\name{GeneOntologyDiscreteGeneSetAnalysisParameters-class}
\docType{class}
\alias{GeneOntologyDiscreteGeneSetAnalysisParameters-class}

\title{Class "GeneOntologyDiscreteGeneSetAnalysisParameters"}
\description{
  GeneOntologyDiscreteGeneSetAnalysisParameters represents the parameters needed
  to run a gene set enrichment analysis using the 'hyperGTest' method of the 'Category'
  package with one of the GO ontologies.
}
\section{Objects from the Class}{

  Objects can be created by calls to the constructor
  \code{\link{GeneOntologyDiscreteGeneSetAnalysisParameters}}.

  Elements can be accessed with \code{\link{annotation}}, \code{\link{discretePValue}},
  \code{\link{testDirection}}, and \code{\link{ontology}}.

}
\section{Slots}{
  \describe{

    \item{\code{annotation}:}{Object of class \code{"character"} containing the
        name of an annotation package.}

    \item{\code{discretePValue}:}{Object of class \code{"numeric"} containing a
        threshold p-value.}

    \item{\code{testDirection}:}{Object of class \code{"character"} containing
        one of the values "over-represented" or "under-represented".}

    \item{\code{ontology}:}{Object of class \code{"character"} containing one
        of the values "BP", "CC" or "MF".}

  }
}
\section{Methods}{

  See \code{\link{GeneOntologyDiscreteGeneSetAnalysisParameters}}

}

\author{Tom Milac \url{tmilac@fhcrc.org}}

\seealso{

  \code{\link{GeneOntologyDiscreteGeneSetAnalysisParameters}} for object construction, accessors
  \code{\link{annotation}}, \code{\link{discretePValue}}, \code{\link{testDirection}}, and \code{\link{ontology}}

}

\examples{
showClass("GeneOntologyDiscreteGeneSetAnalysisParameters")
GeneOntologyDiscreteGeneSetAnalysisParameters()
}
\keyword{classes}
