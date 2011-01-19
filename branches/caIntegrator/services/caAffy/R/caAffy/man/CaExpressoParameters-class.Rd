\name{ExpressoParameter-class}
\docType{class}
\alias{ExpressoParameter-class}

\title{Class "ExpressoParameter" influencing "caExpresso" evaluation}
\description{This and related classes influences evaluation of \code{\link{caExpresso}}.}
\section{Objects from the Class}{
  Objects are created with \code{new("ExpressoParameters", ...)}; use
  slot names in \ldots. The intention is that these objects are created
  in Java as part of web service invocation.
}
\section{Slots}{
  \describe{
    \item{\code{backgroundCorrectMethod}:}{Object of class \code{"character"},
      indicating the backaground correct method for evaluation. Valid options
      are one of "none", "rma", "rma2", "mas".}
    \item{\code{normalizeMethodParameter}:}{Object of 
      \code{\link{NormalizeMethodParameter-class}} indicating the normalization
      method (and optional parameters) for evaluation.}
    \item{\code{pmCorrectMethod}:}{Object of class \code{"character"},
      indicating the PM correction method for evaluation. Valid options
      are one of "mas", "pmonly", "subtractmm"}
    \item{\code{probeSummaryMethod}:}{Object of class \code{"character"},
      indicating the probe summary method for evaluation. Valid options
      are one of "avgdiff", "liwong", "mas", "medianpolish", "playerout"}
  }
}
\section{Methods}{
  No methods defined with class "ExpressoParameter" in the signature.
}
\author{Martin T. Morgan <mtmorgan@fhcrc.org>}
\note{See \code{\link{caAffy-package}} for intended useage}
\seealso{
  \code{\link{NormalizeMethodParameter-class}},
  \code{\link{caExpresso}},
  \code{affy}}
\examples{
new("ExpressoParameter",
    backgroundCorrectMethod="mas",
    normalizeMethodParameter=new("NormalizeQuantilesRobustParameter"),
    pmCorrectMethod="mas",
    probeSummaryMethod="avgdiff")
}
\keyword{classes}
