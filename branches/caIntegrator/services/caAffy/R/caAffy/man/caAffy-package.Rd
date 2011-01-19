\name{caAffy-package}
\alias{caAffy-package}
\alias{caAffy}
\docType{package}
\title{Transform probe intensities to gene expression values}
\description{
  This package exposes functionality of \code{\link[affy]{expresso}} in the
  \code{affy} package, acting on MAGE objects. A BioAssay collection
  is transformed to a DerivedBioAssay collection through background
  correction, normalization, PM corrections, and probe
  summarization. Each step is optional; see \code{\link{caExpresso}} 
  help for more details.

  The package is desiged for use in a web services environment,
  requires the \code{SJava} and \code{RWebServices} packages, and will
  usually be invoked from within Java.
}
\details{
\tabular{ll}{
Package: \tab CaAffy\cr
Type: \tab Package\cr
Version: \tab 1.0\cr
Date: \tab 2006-08-14\cr
License: \tab caBIG\cr
}
}
\author{
Author: Martin T. Morgan

Maintainer: Robert Gentleman <rgentlem@fhcrc.org>
}
\references{}
\keyword{package}
\seealso{\code{affy} package, \code{\link{caExpresso}}}
% \examples{}
