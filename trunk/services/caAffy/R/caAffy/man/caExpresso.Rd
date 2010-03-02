\name{caExpresso}
\alias{caExpresso}
\title{Transform probe intensities to gene expression values}
\description{
  Transform a MAGE BioAssay collection representing `raw' probe values
  to a DerivedBioAssay collection through background
  correction, normalization, PM corrections, and probe
  summarization. Each step is optional, as described below.

  The function is designed for use in a web services environment,
  requires the \code{SJava} and \code{RWebServices} packages, and will
  usually be invoked from within Java.
}
\usage{
caExpresso(bioAssays, cdfName, expressoParameter)
}
\arguments{
  \item{bioAssays}{A
    \code{\link{DerivedBioAssays-class}} object containing
    raw expression values.}
  \item{cdfName}{A character string identifying the name of the cdf
	environment from which the BioAssay expression data are derived from.}
  \item{expressoParameter}{A \code{\link{ExpressoParameter-class}}
    object containing parameter values influencing function evaluation.}
}
\details{
  \code{caExpresso} is a pipeline of four
  transformations (background correction, normalization, PM correction,
  and probe summary). A summary of available transformation is below,
  details are in the\code{affy} package. 

  Background correction algorithms: none; rma; rma2; and mas5.

  Normalization algorithms: none; contrasts, invariant set,
  loess, qspline, quantiles, and quantiles.robust.

  PM correction algorithms: none; mas; pmonly; and subtractmm.

  Probe summary methods: avgdiff, liwon, mas, medianpolis, and playerout.
}
\value{
  \code{\link{DerivedBioAssays-class}} object
  representing the transformed expression values.}
}
\author{Martin T. Morgan <mtmorgan@fhcrc.org>}
\seealso{
  \code{\link{DerivedBioAssays-class}},
  \code{\link{ExpressoParameter-class}},
  \code{affy}}
\examples{}
\keyword{manip}
