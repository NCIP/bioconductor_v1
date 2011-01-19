\name{DNAcopyAssays-class}
\docType{class}
\alias{DNAcopyAssays-class}

\title{Class "DNAcopyAssays"}
\description{Encapsulates DNA copy number data used for copy number
  estimation by \code{\link{caDNAcopy}}}
\section{Objects from the Class}{
  Objects can be created by calls of the form \code{new("DNAcopyAssays", ...)}.
}
\section{Slots}{
	 \describe{
    \item{\code{logratioValues}:}{A
      \code{\link[RWebServices]{NumericMatrix}} of log-ratio expression
      values, with rows corresponding to features and columns to
      samples}
    \item{\code{sampleNames}:}{A character vector of length equal to the
      number of columns in \code{logratioValues}, providing sample names.}
    \item{\code{chromosomeId}:}{Chromosome on which each feature occurs,
      coordinated in with rows of \code{logratioValues}.}
    \item{\code{mapLocation}:}{Base pair position at which each feature
      occurs, coordinated with rows of \code{logratioValues}.}
  }
}
\section{Methods}{
  No methods defined with class "DNAcopyAssays" in the signature.
}
\author{Martin Morgan <mtmorgan@fhcrc.org>}
\seealso{\code{\link[DNAcopy]{segment}}, \code{\link{caDNAcopy}}}
\examples{\dontrun{example(caDNAcopy)}}
\keyword{classes}
