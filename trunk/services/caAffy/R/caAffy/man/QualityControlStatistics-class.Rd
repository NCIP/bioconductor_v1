\name{QualityControlStatistics-class}
\docType{class}
\alias{QualityControlStatistics-class}

\title{Class "QualityControlStatistics"}
\description{This class encapsulates and structures selected results from
  \code{\link[affyQCReport]{QCStats-class}}, as invoked by \code{\link{caQAReport}}}
\section{Objects from the Class}{
Objects are created by a call to \code{\link{caQAReport}}}
\section{Slots}{
  Slots correspond to their equivalent in \code{\link[affyQCReport]{QCStats-class}};
  slots present in \code{QCStats-class} and absent here are not relevant or not
  easily exposed through web services. Slots do not have accessors, and
  are available using \code{@}.
	 \describe{
    \item{\code{scale.factors}:}{Object of class \code{"numeric"}}
    \item{\code{target}:}{Object of class \code{"numeric"}}
    \item{\code{percent.present}:}{Object of class \code{"numeric"}}
    \item{\code{average.background}:}{Object of class \code{"numeric"}}
    \item{\code{minimum.background}:}{Object of class \code{"numeric"}}
    \item{\code{maximum.background}:}{Object of class \code{"numeric"}}
    \item{\code{spikes}:}{Object of class \code{"NumericMatrix"}}
    \item{\code{qc.probes}:}{Object of class \code{"NumericMatrix"}}
    \item{\code{bioBCalls}:}{Object of class \code{"character"}}
  }
}
\section{Methods}{
No methods defined with class "QualityControlStatistics" in the signature.
}
\author{Martin Morgan <mtmorgan@fhcrc.org>}
\seealso{\code{\link{caQAReport}}, \code{\link[affyQCReport]{QCStats-class}}}
\examples{
example(caQAReport)
}
\keyword{classes}
