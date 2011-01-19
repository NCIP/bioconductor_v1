\name{DerivedBioAssayMatrix-class}
\docType{class}
\alias{DerivedBioAssayMatrix-class}

\title{Class "DerivedBioAssayMatrix"}
\description{A class representing a collection of derived expression
  values, with expression values stored as a matrix with rows
  corresponding to reporters and columns to samples.}
\section{Objects from the Class}{
Objects can be created by calls of the form \code{new("DerivedBioAssayMatrix", ...)}.
}
\section{Slots}{
  \describe{
    \item{\code{bioAssayData}:}{Numeric matrix with rows corresponding
      to reporters and columns to samples. Object of class \code{"NumericMatrix"}}
  }
}
\section{Extends}{
  Class \code{"DerivedBioAssayDataCollection"}, directly.
  Class \code{"BioAssayDataCollection"}, by class "DerivedBioAssayDataCollection", distance 2.
}
\section{Methods}{
  No methods defined with class "DerivedBioAssayMatrix" in the signature.
}
\author{Martin Morgan <mtmorgan@fhcrc.org>}
\seealso{}
\keyword{classes}
