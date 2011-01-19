\name{GeneSetAnalysisParameters-class}
\docType{class}
\alias{GeneSetAnalysisParameters-class}

\title{Class "GeneSetAnalysisParameters"}
\description{
  GeneSetAnalysisParameters is the base class for all classes which represent
  the parameters needed to run a gene set enrichment analysis.
}
\section{Objects from the Class}{

  Objects can be created by calls to the constructor
  \code{\link{GeneSetAnalysisParameters}}.

  Elements can be accessed with \code{\link{annotation}}.

}
\section{Slots}{
  \describe{

    \item{\code{annotation}:}{Object of class \code{"character"} containing the
        name of an annotation package.}

  }
}
\section{Methods}{

  See \code{\link{GeneSetAnalysisParameters}}

}

\author{Tom Milac \url{tmilac@fhcrc.org}}

\seealso{

  \code{\link{GeneSetAnalysisParameters}} for object construction, accessors
  \code{\link{annotation}}

}

\examples{
showClass("GeneSetAnalysisParameters")
GeneSetAnalysisParameters()
}
\keyword{classes}
