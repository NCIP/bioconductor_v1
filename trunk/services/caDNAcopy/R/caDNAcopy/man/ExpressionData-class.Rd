\name{ExpressionData-class}
\docType{class}
\alias{ExpressionData-class}
\alias{length,ExpressionData-method}

\title{Class "ExpressionData"}
\description{Encapsulates expression data used for copy number
  estimation by \code{\link{caDNAcopy}}}
\section{Objects from the Class}{
  Objects can be created by calls of the form \code{new("ExpressionData", ...)}.
}
\section{Slots}{
	 \describe{
    \item{\code{sampleId}:}{Samle identification string. Object of class \code{"character"}.}
    \item{\code{logratioValues}:}{Vector of log ratio expression values
      (see \code{\link[DNAcopy]{CNA}}). Object of class \code{"numeric"}.}
  }
}
\section{Methods}{
  \describe{
    \item{\code{length}}{The number of expression values in this
      sample.}
  }
}
\author{Martin Morgan <mtmorgan@fhcrc.org>}
\seealso{\code{\link[DNAcopy]{segment}}, \code{\link{caDNAcopy}}}
\examples{\dontrun{example(caDNAcopy)}}
\keyword{classes}
