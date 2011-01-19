\name{caPROcess}
\alias{caPROcess}
\title{Baseline removal, smoothing, and peak identification}
\description{
  Provide a web services wrapper to a workflow inolving baseline
  removal, renormalization and peak detection in the PROcess package.
}
\usage{
caPROcess(mzAssays, proCessParameter)
}
\arguments{
  \item{mzAssays}{An object of class \code{MzSpectrum},
    containing data to be analyzed.}
  \item{proCessParameter}{An object of class \code{ProCessParameter},
    containing parameters influencing the workflow.}
}
\details{
  See \code{\link[PROcess]{bslnoff}}, \code{\link[PROcess]{renorm}} and
  \code{\link[PROcess]{isPeak}} for a description of each step in the workflow.
}
\value{
  \code{\link{PeakLocation-class}}
}
\author{Martin Morgan <mtmorgan@fhcrc.org>}
\examples{
data(mzAssays)
res = caPROcess(mzAssays, new("PROcessParameter"))
str(res)
}
\keyword{manip}% at least one, from doc/KEYWORDS
