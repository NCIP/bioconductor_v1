\name{ContinuousGeneSetAnalysisParameters-class}
\docType{class}
\alias{ContinuousGeneSetAnalysisParameters-class}

\title{Class "ContinuousGeneSetAnalysisParameters"}
\description{
  ContinuousGeneSetAnalysisParameters is the base class for all classes
  which represent the parameters needed to run a gene set enrichment analysis
  using the methods provided by the 'GSEABase' package.
}
\section{Objects from the Class}{

  Objects can be created by calls to the constructor
  \code{\link{ContinuousGeneSetAnalysisParameters}}.

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

  See \code{\link{ContinuousGeneSetAnalysisParameters}}

}

\author{Tom Milac \url{tmilac@fhcrc.org}}

\seealso{

  \code{\link{ContinuousGeneSetAnalysisParameters}} for object construction, accessors
  \code{\link{annotation}} and \code{\link{minimumGenesPerGeneSet}}

}

\examples{
showClass("ContinuousGeneSetAnalysisParameters")
ContinuousGeneSetAnalysisParameters()
}
\keyword{classes}
