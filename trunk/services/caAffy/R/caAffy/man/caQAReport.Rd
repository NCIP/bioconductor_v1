\name{caQAReport}
\alias{caQAReport}
\title{Produce a quality assessment report (as PDF) of an affymetrix experiment}
\description{
  This encapsulates the function
  \code{\link[affyQCReport]{affyQAReport}} for exposure as a web or
  caGrid service.
}
\usage{
caQAReport(bioAssays, cdfName, chipDimensions)
}
\arguments{
  \item{bioAssays}{A
    \code{\link{DerivedBioAssays-class}} object containing
    raw expression values.}
  \item{cdfName}{A character string identifying the name of the cdf
    environment from which the BioAssay expression data are derived
    from.}
  \item{chipDimensions}{Number of rows and columns on the chips of
    \code{cdfName}.}
}
\details{
  See \code{\link[affyQCReport]{affyQAReport}} and the value returned by
  this function for additional information.
}
\value{
  This returns an object of \code{\link{QaReport-class}}; only the PDF
  file protion of this object is returned in response to a grid service request.
}
\author{Martin Morgan <mtmorgan@fhcrc.org>}
\seealso{\code{\link[affyQCReport]{affyQAReport}}, \code{\link{QaReport-class}}}
\examples{
\dontrun{    
library(affydata)
data(Dilution)
bioAssays <- new("DerivedBioAssays",
                 bioAssays=new("NumericMatrix", exprs(affyBatch)))
cdfName <- cdfName(affyBatch)
chipDimensions=as.integer(rep(sqrt(dim(exprs(affyBatch))[[1]]), 2))
res <- caQAReport(dbads,
                  cdfName(affyBatch),
                  chipDimensions)
tmp <- tempfile()
writeBin(res@pdfFile, tmp)
system(paste("acroread", tmp))
}
}
\keyword{ manip }
