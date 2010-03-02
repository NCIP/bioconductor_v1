\name{MeasuredBioAssayMatrix-class}
\docType{class}
\alias{MeasuredBioAssayMatrix-class}

\title{Class "MeasuredBioAssayMatrix"}
\description{A class representing a collection of measured expression
  values, with expression values stored as a matrix with rows
  corresponding to features and columns to samples.}
\section{Objects from the Class}{
Objects can be created by calls of the form \code{new("MeasuredBioAssayMatrix", ...)}.
}
\section{Slots}{
  \describe{
    \item{\code{bioAssayData}:}{Numeric matrix with rows corresponding
      to features and columns to samples. Object of class \code{"NumericMatrix"}}
  }
}
\section{Extends}{
  Class \code{"MeasuredBioAssayDataCollection"}, directly.
  Class \code{"BioAssayDataCollection"}, by class "MeasuredBioAssayDataCollection", distance 2.
}
\section{Methods}{
  No methods defined with class "MeasuredBioAssayMatrix" in the signature.
}
\author{Martin Morgan <mtmorgan@fhcrc.org>}
\seealso{}
\keyword{classes}
