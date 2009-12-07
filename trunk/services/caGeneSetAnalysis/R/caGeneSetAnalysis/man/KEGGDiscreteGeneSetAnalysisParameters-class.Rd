\name{KEGGDiscreteGeneSetAnalysisParameters-class}
\docType{class}
\alias{KEGGDiscreteGeneSetAnalysisParameters-class}

\title{Class "KEGGDiscreteGeneSetAnalysisParameters"}
\description{
  KEGGDiscreteGeneSetAnalysisParameters represents the parameters needed
  to run a gene set enrichment analysis using the 'hyperGTest' method of the 
  'Category' package with KEGG as the category.
}
\section{Objects from the Class}{

  Objects can be created by calls to the constructor
  \code{\link{KEGGDiscreteGeneSetAnalysisParameters}}.

  Elements can be accessed with \code{\link{annotation}}, \code{\link{discretePValue}},
  and \code{\link{testDirection}}.

}
\section{Slots}{
  \describe{

    \item{\code{annotation}:}{Object of class \code{"character"} containing the
        name of an annotation package.}

    \item{\code{discretePValue}:}{Object of class \code{"numeric"} containing a
        threshold p-value.}

    \item{\code{testDirection}:}{Object of class \code{"character"} containing
        one of the values "over-represented" or "under-represented".}

  }
}
\section{Methods}{

  See \code{\link{KEGGDiscreteGeneSetAnalysisParameters}}

}

\author{Tom Milac \url{tmilac@fhcrc.org}}

\seealso{

  \code{\link{KEGGDiscreteGeneSetAnalysisParameters}} for object construction, accessors
  \code{\link{annotation}}, \code{\link{discretePValue}} and \code{\link{testDirection}}

}

\examples{
showClass("KEGGDiscreteGeneSetAnalysisParameters")
KEGGDiscreteGeneSetAnalysisParameters()
}
\keyword{classes}
