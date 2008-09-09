\name{PROcessParameter-class}
\docType{class}
\alias{PROcessParameter-class}

\title{Class "PROcessParameter"}
\description{Class encapsulating parameter values for the caPROcess analytic service.}
\section{Objects from the Class}{
Objects can be created by calls of the form \code{new("PROcessParameter", ...)}.
}
\section{Slots}{
	 \describe{
    \item{\code{renormalizationCutoff}:}{Portion of a spectrum below which values will be ignored. See \code{\link[PROcess]{renorm}}. R
      object of class \code{"numeric"}}
    \item{\code{peakSignalToNoiseCutoff}:}{Signal to noise ratio criterion for peak detection. See
      \code{\link[PROcess]{isPeak}}. Object of class \code{"numeric"}}
    \item{\code{peakVarianceDetectionSpan}:}{Parameter for estimating local variance before peak detection; default is 81 points, that is, 40 points to the left and right of a point of which the variance is being estimated. See \code{\link[PROcess]{isPeak}}. Object of class
      \code{"numeric"}}
    \item{\code{peakSmoothingSpan}:}{Parameter for smoothing the spectrum before peak detection; default is 11 points, that is, 5 points to the left and right of a point being smoothed. See
      \code{\link[PROcess]{isPeak}}. Object of class \code{"numeric"}}
    \item{\code{peakZeroCutoff}:}{Ignore peaks whose intensity values are below this value. See \code{\link[PROcess]{isPeak}},
      zerothrsh. Object of class \code{"numeric"}}
    \item{\code{peakAreaNeighborhood}:}{The neighbourhood used to calculate the area of an m/z peak, mz*(1-peakAreaNeighborhood, 1+peakAreaNeighborhood). See \code{\link[PROcess]{isPeak}},
      area. Object of class \code{"numeric"}}
    \item{\code{peakAreaRetention}:}{If area/max(area) > ratio, the peak
      is retained. See \code{\link[PROcess]{isPeak}}. Object of class \code{"numeric"}}
  }
}
\author{Martin Morgan <mtmorgan@fhcrc.org>}
\seealso{\code{\link{MzAssays-class}}, \code{\link{caPROcess}}}
\examples{
new("PROcessParameter")
}
\keyword{classes}
