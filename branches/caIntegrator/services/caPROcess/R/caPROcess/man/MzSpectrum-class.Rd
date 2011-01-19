\name{MzSpectrum-class}
\docType{class}
\alias{MzSpectrum-class}

\title{Class "MzSpectrum"}
\description{Representation of Ciphergen SELDI-TOF spectrometry intensity data.}
\section{Objects from the Class}{
Objects can be created by calls of the form \code{new("MzSpectrum", ...)}.
}
\section{Slots}{
	 \describe{
    \item{\code{spectrumName}:}{Name identifying the spectrum. R object of class \code{"character"}.  }
    \item{\code{mzRatio}:}{Vector of M/Z values. R object of class \code{"numeric"}. } 
    \item{\code{intensity}:}{Vector of intensities corresponding to M/Z values. R object of class \code{"numeric"}. }
  }
}
\section{Methods}{
  No methods defined with class "MzSpectrum" in the signature.
}
\author{Martin Morgan <mtmorgan@fhcrc.org>}
\seealso{\code{\link{MzAssays-class}}}
\examples{
load(system.file(file.path("data","mzAssays.rda"), package="caPROcess"))
str(mzAssays[[1]])
}
\keyword{classes}
