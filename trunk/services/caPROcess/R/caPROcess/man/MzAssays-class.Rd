\name{MzAssays-class}
\docType{class}
\alias{MzAssays-class}

\title{Class "MzAssays"}
\description{A list of \code{\link{MzSpectrum-class}} objects.}
\section{Objects from the Class}{
Objects can be created by calls of the form \code{new("MzAssays", ...)}.
}
\section{Slots}{
  \describe{
    \item{\code{.Data}:}{List of \code{\link{MzSpectrum-class}} objects. R object of class \code{"list"}. }
    \item{\code{listTemplate}:}{Provides a template to generate Java classes corresponding to the contents of \code{.Data}; contents ignored.}
  }
}
\section{Extends}{
Class \code{"list"}, from data part.
Class \code{"vector"}, by class "list", distance 2.
}
\section{Methods}{
No methods defined with class "MzAssays" in the signature.
}
\author{Martin Morgan <mtmorgan@fhcrc.org>}
\seealso{\code{\link{MzSpectrum-class}}}
\examples{
load(system.file(file.path("data","mzAssays.rda"), package="caPROcess"))
str(mzAssays)
}
\keyword{classes}
