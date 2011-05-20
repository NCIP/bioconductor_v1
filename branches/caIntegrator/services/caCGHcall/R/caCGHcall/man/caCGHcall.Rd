\name{caCGHcall}
\alias{caCGHcall}
\title{Perform copy number smoothing and segmentation}
\description{
  Transform an object of \code{\link{CGHcallAssays-class}}
  specifying copy number variation through smoothing and segmentation
  to a \code{\link{DerivedCGHcallSegment-class}} identifying chromosomal
  regions of constant copy number.  
}
\usage{
caCGHcall(dnacopyAssays, dnacopyParameter)
}
\arguments{
  \item{dnacopyAssays}{Collection of
    \code{\link{ExpressionData-class}} objects representing
    samples from known chromosomal locations, and their expression values.}
  \item{dnacopyParameter}{An object of
    \code{\link{CGHcallParameter-class}} encapsulating parameters influencing
    evaluation of \code{caCGHcall}.} 
}
\details{
  This function exposes the smoothing
  (\code{\link[CGHcall]{smooth.CNA}})  and chromosome segmentation
  (\code{\link[CGHcall]{segment}}) functionality of the CGHcall
  package. Not all parameters of \code{smooth.CNA} or \code{segment} are
  available through this interface.
}
\value{
  \code{\link{DerivedCGHcallSegment-class}}
}
\author{Martin Morgan <mtmorgan@fhcrc.org>}
\seealso{\code{\link[CGHcall]{CGHcall}}}
\examples{
data(dnacopyAssays)
dnacopyParameter <- new("CGHcallParameter")
res <- caCGHcall(dnacopyAssays, dnacopyParameter)
}
\keyword{manip}
