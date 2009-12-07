\name{KEGGContinuousGeneSetAnalysisParameters-class}
\docType{class}
\alias{KEGGContinuousGeneSetAnalysisParameters-class}

\title{Class "KEGGContinuousGeneSetAnalysisParameters"}
\description{
  KEGGContinuousGeneSetAnalysisParameters represents the parameters needed
  to run a gene set enrichment analysis with the KEGG category using methods
  supplied by the 'GSEABase' package.
}
\section{Objects from the Class}{

  Objects can be created by calls to the constructor
  \code{\link{KEGGContinuousGeneSetAnalysisParameters}}.

  Elements can be accessed with \code{\link{annotation}} and \code{\link{minimumGenesPerGeneSet}}.

}
\section{Slots}{
  \describe{

    \item{\code{annotation}:}{Object of class \code{"character"} containing the
        name of an annotation package.}

    \item{\code{minimumGenesPerGeneSet}:}{Object of class \code{"numeric"} containing the
        minimum required size of a gene set.}

  }
}
\section{Methods}{

  See \code{\link{KEGGContinuousGeneSetAnalysisParameters}}

}

\author{Tom Milac \url{tmilac@fhcrc.org}}

\seealso{

  \code{\link{KEGGContinuousGeneSetAnalysisParameters}} for object construction, accessors
  \code{\link{annotation}} and \code{\link{minimumGenesPerGeneSet}}

}

\examples{
showClass("KEGGContinuousGeneSetAnalysisParameters")
KEGGContinuousGeneSetAnalysisParameters()
}
\keyword{classes}
