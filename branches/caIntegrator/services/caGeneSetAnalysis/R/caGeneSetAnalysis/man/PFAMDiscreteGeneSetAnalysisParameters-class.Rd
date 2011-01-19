\name{PFAMDiscreteGeneSetAnalysisParameters-class}
\docType{class}
\alias{PFAMDiscreteGeneSetAnalysisParameters-class}

\title{Class "PFAMDiscreteGeneSetAnalysisParameters"}
\description{
  PFAMDiscreteGeneSetAnalysisParameters represents the parameters needed
  to run a gene set enrichment analysis using the 'hyperGTest' method of 
  the 'Category' package with PFAM as the category.
}
\section{Objects from the Class}{

  Objects can be created by calls to the constructor
  \code{\link{PFAMDiscreteGeneSetAnalysisParameters}}.

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

  See \code{\link{PFAMDiscreteGeneSetAnalysisParameters}}

}

\author{Tom Milac \url{tmilac@fhcrc.org}}

\seealso{

  \code{\link{PFAMDiscreteGeneSetAnalysisParameters}} for object construction, accessors
  \code{\link{annotation}}, \code{\link{discretePValue}}, and \code{\link{testDirection}}

}

\examples{
showClass("PFAMDiscreteGeneSetAnalysisParameters")
PFAMDiscreteGeneSetAnalysisParameters()
}
\keyword{classes}
