\name{PFAMContinuousGeneSetAnalysisParameters-class}
\docType{class}
\alias{PFAMContinuousGeneSetAnalysisParameters-class}

\title{Class "PFAMContinuousGeneSetAnalysisParameters"}
\description{
  PFAMContinuousGeneSetAnalysisParameters represents the parameters needed
  to run a gene set enrichment analysis with the PFAM category using methods
  supplied by the 'GSEABase' package .
}
\section{Objects from the Class}{

  Objects can be created by calls to the constructor
  \code{\link{PFAMContinuousGeneSetAnalysisParameters}}.

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

  See \code{\link{PFAMContinuousGeneSetAnalysisParameters}}

}

\author{Tom Milac \url{tmilac@fhcrc.org}}

\seealso{

  \code{\link{PFAMContinuousGeneSetAnalysisParameters}} for object construction, accessors
  \code{\link{annotation}} and \code{\link{minimumGenesPerGeneSet}}

}

\examples{
showClass("PFAMContinuousGeneSetAnalysisParameters")
PFAMContinuousGeneSetAnalysisParameters()
}
\keyword{classes}
