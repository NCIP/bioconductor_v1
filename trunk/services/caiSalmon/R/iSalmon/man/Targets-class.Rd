\name{Targets-class}
\Rdversion{1.1}
\docType{class}
\alias{Targets-class}

\title{Class "Targets"}
\description{
  A class containing the file names (urls) and conditions associated
  with each miRNA array to be analysed.
}
\section{Objects from the Class}{
  Objects can be created by calls of the form \code{new("Targets", ...)}.
}
\section{Slots}{
  \describe{

    \item{\code{FileName}:}{Object of class \code{"character"}
      containing the url of the Agilent miRNA file.}

    \item{\code{Condition}:}{The condition associated with the sample.}

  }
}
\section{Methods}{
  No methods defined with class "Targets" in the signature.
}
\author{
  Martin Morgan \url{mtmorgan@fhcrc.org}
}
\examples{
showClass("Targets")
}
\keyword{classes}
