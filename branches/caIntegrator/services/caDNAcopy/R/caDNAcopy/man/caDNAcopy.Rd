\name{caDNAcopy}
\alias{caDNAcopy}
\title{Perform copy number smoothing and segmentation}
\description{
  Transform an object of \code{\link{DNAcopyAssays-class}}
  specifying copy number variation through smoothing and segmentation
  to a \code{\link{DerivedDNAcopySegment-class}} identifying chromosomal
  regions of constant copy number.  
}
\usage{
caDNAcopy(dnacopyAssays, dnacopyParameter)
}
\arguments{
  \item{dnacopyAssays}{Collection of
    \code{\link{ExpressionData-class}} objects representing
    samples from known chromosomal locations, and their expression values.}
  \item{dnacopyParameter}{An object of
    \code{\link{DNAcopyParameter-class}} encapsulating parameters influencing
    evaluation of \code{caDNAcopy}.} 
}
\details{
  This function exposes the smoothing
  (\code{\link[DNAcopy]{smooth.CNA}})  and chromosome segmentation
  (\code{\link[DNAcopy]{segment}}) functionality of the DNAcopy
  package. Not all parameters of \code{smooth.CNA} or \code{segment} are
  available through this interface.
}
\value{
  \code{\link{DerivedDNAcopySegment-class}}
}
\author{Martin Morgan <mtmorgan@fhcrc.org>}
\seealso{\code{\link[DNAcopy]{DNAcopy}}}
\examples{
data(dnacopyAssays)
dnacopyParameter <- new("DNAcopyParameter")
res <- caDNAcopy(dnacopyAssays, dnacopyParameter)
}
\keyword{manip}
