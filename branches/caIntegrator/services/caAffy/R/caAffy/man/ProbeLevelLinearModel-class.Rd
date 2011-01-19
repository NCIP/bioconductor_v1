\name{ProbeLevelLinearModel-class}
\docType{class}
\alias{ProbeLevelLinearModel-class}
\alias{ProbeLevelLinearModel}

\title{Class "ProbeLevelLinearModel", encapsulating results from "affyPLM"}
\description{This class encapsulates and structures selected results from
  \code{\link[affyPLM]{fitPLM}}, as invoked by \code{\link{caQAReport}}}
\section{Objects from the Class}{
Objects are created by a call to \code{\link{caQAReport}}}
\section{Slots}{
  Slots correspond to their equivalent in \code{\link[affyPLM]{PLMset}};
  slots present in \code{PLMset} and absent here are not relevant or not
  easily exposed through web services. Slots do not have accessors, and
  are available using \code{@}.
	 \describe{
    \item{\code{cdfName}:}{Object of class \code{"character"}}
    \item{\code{nrow}:}{Object of class \code{"numeric"}}
    \item{\code{ncol}:}{Object of class \code{"numeric"}}
    \item{\code{weights}:}{Object of class \code{"list"}}
    \item{\code{residuals}:}{Object of class \code{"list"}}
    \item{\code{residualSE}:}{Object of class \code{"NumericMatrix"}}
    \item{\code{normVec}:}{Object of class \code{"NumericMatrix"}}
    \item{\code{varcov}:}{Object of class \code{"list"}}
    \item{\code{annotation}:}{Object of class \code{"character"}}
    \item{\code{notes}:}{Object of class \code{"character"}}
  }
}
\section{Methods}{
  No methods defined with class "ProbeLevelLinearModel" in the signature.
}
\author{Martin Morgan <mtmorgan@fhcrc.org>}
\seealso{\code{\link{caQAReport}}, \code{\link[affyPLM]{PLMset}}}
\examples{
example(caQAReport)
}
\keyword{classes}
