\name{caPROcess-package}
\alias{caPROcess-package}
\docType{package}
\title{Expose PROcess functionality as web service}
\description{
This packages wraps core functionality of the PROcess
	package in R functions, and provides TypeInfo for the argument
	and return types. This facilitates use of the package in
	RWebServices.
}
\details{
\tabular{ll}{
Package: \tab caPROcess\cr
Type: \tab Package\cr
Version: \tab 0.0.1\cr
Date: \tab 2006-08-14\cr
License: \tab What license is it under?\cr
}
~~ An overview of how to use the package, including the most important functions ~~
}
\author{
  Author: Martin Morgan <mtmorgan@fhcrc.org>

  Maintainer: Biocore Team <biocpkgs@lists.fhcrc.org>
}
\keyword{ package }
\examples{
load(system.file(file.path("data","mzAssays.rda"), package="caPROcess"))
str(caPROcess(mzAssays, new("PROcessParameter")))
}
