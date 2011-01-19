\name{QaReport-class}
\docType{class}
\alias{QaReport}
\alias{QaReport-class}

\title{Class "QaReport" summarizing quality assurance report infomration}
\description{This class encapsulates returned by
  \code{\link[affyQCReport]{affyQAReport}} as invoked by \code{\link{caQAReport}}.}
\section{Objects from the Class}{
  Objects can be created as a result of calls to \code{\link{caQAReport}}.
}
\section{Slots}{
	 \describe{
    \item{\code{qualityControlStatistics}:}{Object of class
      \code{"QualityControlStatistics"}.}
    \item{\code{probeLevelLinearModel}:}{Object of class \code{"ProbeLevelLinearModel"}.}
    \item{\code{madsMatrix}:}{Object of class \code{"NumericMatrix"},
      representing the MADS matrix returned by \code{\link[affyQCReport]{affyQAReport}} }
    \item{\code{pdfFile}:}{Object of class \code{"raw"}, representing
      the PDF file created by \code{\link[affyQCReport]{affyQAReport}}
      as a raw (binary) vector.}
  }
}
\section{Methods}{
  No methods defined with class "QaReport" in the signature.
}
\author{Martin Morgan <mtmorgan@fhcrc.org>}
\seealso{\code{\link{caQAReport}}}
\examples{
example(caQAReport)
}
\keyword{classes}
