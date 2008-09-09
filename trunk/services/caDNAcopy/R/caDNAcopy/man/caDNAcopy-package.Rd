\name{caDNAcopy-package}
\alias{caDNAcopy-package}
\docType{package}
\title{Expose 'DNAcopy' functionality as web service}
\description{
This packages wraps core functionality of the DNAcopy
package into a single R workflow, and provides TypeInfo for
the argument and return types. This facilitates use of the
package in RWebServices.
}
\details{
  This package exposes functionality of
  \code{\link[DNAcopy]{smooth.CNA}} and \code{\link[DNAcopy]{segment}} in the
  \code{DNAcopy} package, acting on \code{\link{DNAcopyAssays-class}}
  objects. This collection is transformed to a
  \code{\link{DerivedDNAcopySegment-class}} through smoothing and segmentaiton.

  The package is desiged for use in a web services environment,
  requires the \code{SJava} and \code{RWebServices} packages, and will
  usually be invoked from within Java.
}
\author{
Author: Martin Morgan <mtmorgan@fhcrc.org>
Maintainer: Biocore Team <biocpkgs@lists.fhcrc.org>
}
\keyword{ package }
\seealso{\code{\link[DNAcopy]{DNAcopy}}}
\examples{}
