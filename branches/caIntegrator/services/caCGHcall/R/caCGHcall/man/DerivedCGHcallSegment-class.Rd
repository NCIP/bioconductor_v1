\name{DerivedCGHcallSegment-class}
\docType{class}
\alias{DerivedCGHcallSegment-class}
\alias{DerivedCGHcallSegment}

\title{Class "DerivedCGHcallSegment" }
\description{Class encapsulating DNA segments identified based on copy
  number, using algorithms in the \code{\link[CGHcall]{CGHcall-package}} package.}
\section{Objects from the Class}{
  Objects are created by the \code{\link{caCGHcall}} method.
}
\section{Slots}{
  This class encapsulates results from
  \code{\link[CGHcall]{segment}}. Results are ordered as vectors, with
  identically indexed entries corresponding to identical chromsome segments.  
	 \describe{
    \item{\code{sampleId}:}{Sample identifier, derived from input data. Object of class \code{"character"}.}
    \item{\code{chromosomeIndex}:}{Vector of numerical chromosome
      identifiers of each segment. Object of class \code{"character"}.}
    \item{\code{startMapPosition}:}{Vector of chromosomal map start
      positions for each segment. Object of class \code{"integer"}.}
    \item{\code{endMapPosition}:}{Vector fo chromosomal map end
      positions of each segment. Object of class \code{"integer"}.}
    \item{\code{markersPerSegment}:}{Vector of number of markers
      used to identify each segment. Object of class \code{"integer"}.}
    \item{\code{averageSegmentValue}:}{Vector of numbers of average copy
      number values in each segment. Object of class \code{"numeric"}.}
  }
}
\section{Methods}{
  No methods defined with class "DerivedCGHcallSegment" in the signature.
}
\author{Martin Morgan <mtmorgan@fhcrc.org>}
\seealso{\code{\link[CGHcall]{segment}}, \code{\link{caCGHcall}}}
\examples{\dontrun{example(caCGHcall)}}
\keyword{classes}
