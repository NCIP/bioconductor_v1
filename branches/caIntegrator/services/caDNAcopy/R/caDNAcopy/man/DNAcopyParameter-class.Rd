\name{DNAcopyParameter-class}
\docType{class}
\alias{DNAcopyParameter-class}

\title{Class "DNAcopyParameter"}
\description{A class encapsulating parameter values used by the
  \code{\link{caDNAcopy}} algorithm}
\section{Objects from the Class}{
  Objects can be created by calls of the form \code{new("DNAcopyParameter", ...)}.
}
\section{Slots}{
  \describe{
    \item{\code{randomNumberSeed}:}{A single integer value to seed the
      random number generator, using R's \code{\link[base]{set.seed}}.}
    \item{\code{changePointSignificanceLevel}:}{The \code{alpha}
      parameter of \code{\link[DNAcopy]{segment}}. Object of class \code{"numeric"}}
    \item{\code{permutationReplicates}:}{The \code{nperm} parameter of
      \code{\link[DNAcopy]{segment}}. Object of class \code{"integer"}.}
    \item{\code{earlyStoppingCriterion}:}{The \code{eta} parameter of
      \code{\link[DNAcopy]{segment}}. Object of class \code{"numeric"}.}
  }
}
\author{Martin Morgan <mtmorgan@fhcrc.org>}
\seealso{\code{\link[DNAcopy]{segment}}, \code{\link{caDNAcopy}}}
\examples{\dontrun{example(caDNAcopy)}}
\keyword{classes}
