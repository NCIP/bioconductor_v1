\name{PeakLocation-class}
\docType{class}
\alias{PeakLocation-class}

\title{Class "PeakLocation"}
\description{Class encapsulating peak locations and intensities from SELDI-TOF processing.}
\section{Objects from the Class}{
Objects can be created by calls of the form \code{new("PeakLocation",
  ...)}, but are usually created during \code{\link{caPROcess}} evaluation.
}
\section{Slots}{
	 \describe{
    \item{\code{spectrumName}:}{Spectrum name of each peak identified after
      baseline removal and re-normalization; see \code{\link{MzSpectrum-class}}. R object of class
      \code{"character"}.}
    \item{\code{spectrumId}:}{Specturm identifiers for peaks detected
      after baseline removal and re-normalization. R object of class \code{"integer"}.  }
    \item{\code{peakNumberInSpectrum}:}{Peak sequential index after
      baseline removal, re-norming, and peak identification. R object of class \code{"integer"}. }
    \item{\code{relativeIntensity}:}{Peak intensities following baseline
      removal, re-norming, and peak identification. R object of class \code{"numeric"}.}
    \item{\code{substanceMassAtIntensity}:}{The m/z ratio at the
      relative intensity peak, after background removal, re-norming, and
      peak identification. R object of class \code{"numeric"}.}
  }
}
\section{Methods}{
No methods defined with class "PeakLocation" in the signature.
}
\author{Martin Morgan <mtmorgan@fhcrc.org>}
\seealso{\code{\link{MzAssays-class}}, \code{\link{caPROcess}}}
\examples{
load(system.file(file.path("data","mzAssays.rda"), package="caPROcess"))
str(caPROcess(mzAssays, new("PROcessParameter")))
}
\keyword{classes}
