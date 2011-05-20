\name{caCGHcall-package}
\alias{caCGHcall-package}
\docType{package}
\title{Expose 'CGHcall' functionality as web service}
\description{
This packages wraps core functionality of the CGHcall
package into a single R workflow, and provides TypeInfo for
the argument and return types. This facilitates use of the
package in RWebServices.
}
\details{
  This package exposes functionality of
  \code{\link[CGHcall]{smooth.CNA}} and \code{\link[CGHcall]{segment}} in the
  \code{CGHcall} package, acting on \code{\link{CGHcallAssays-class}}
  objects. This collection is transformed to a
  \code{\link{DerivedCGHcallSegment-class}} through smoothing and segmentaiton.

  The package is desiged for use in a web services environment,
  requires the \code{SJava} and \code{RWebServices} packages, and will
  usually be invoked from within Java.
}
\author{
Author: Chris Piepenbring <piepenbringc@mail.nih.gov>
Maintainer: Chris Piepenbring <piepenbringc@mail.nih.gov>
}
\keyword{ package }
\seealso{\code{\link[CGHcall]{CGHcall}}}
