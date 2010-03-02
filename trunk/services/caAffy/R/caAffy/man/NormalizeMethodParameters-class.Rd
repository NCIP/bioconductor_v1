\name{NormalizeMethodParameter-class}
\docType{class}
\alias{NormalizeMethodParameter-class}
\alias{NormalizeInvariantSetParameter-class}
\alias{NormalizeQuantilesRobustParameter-class}

\title{Class "NormalizeMethodParameter" influencing "caExpresso" evaluation}
\description{These classes influences evaluation of \code{\link{caExpresso}}.}
\section{Objects from the Class}{
  Objects are created with \code{new("NormalizeMethodParameter", ...)}; use
  slot names in \ldots. The intention is that these objects are created
  in Java as part of web service invocation.
}
\section{Slots}{
  All classes derived from \code{NormalizeMethodParameter} share the
  following slot:
  \describe{
    \item{\code{type}:}{Object of class \code{"character"},
      indicating which probes are used in  normamlization. Valid options
      are one of "together", "pmonly", "mmonly", "separate".}
  }
  \code{NormalizeInvariantSetParameter-class} contsins slot:
  \describe{
    \item{\code{baselineType}:}{Object of class \code{"character"},
      indicating how baseline removal occurs. Valid options are one of
      "mean", "median", "psuedoMean", "psuedoMedian".}
  }
  \code{NormalizeQuantilesRobustParameter-class} contains slot:
  \describe{
    \item{\code{removeExtreme}:}{Object of \code{"character"},
      indicating how to identify extreme values for removal. Valid
      options are one of "variance", "mean", "both"}
    }
}
\section{Methods}{
  No methods defined with class "CaExpressoParameters" in the signature.
}
\author{Martin T. Morgan <mtmorgan@fhcrc.org>}
\note{See \code{\link{caAffy-package}} for intended useage}
\seealso{
  \code{\link{ExpressoParameter-class}},
  \code{\link{caExpresso}},
  \code{affy}}
}
\examples{
new("NormalizeInvariantSetParameter",
    probeType="together", baselineType="median")
}
\keyword{classes}
