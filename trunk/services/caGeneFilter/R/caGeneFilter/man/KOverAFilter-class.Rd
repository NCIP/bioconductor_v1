\name{KOverAFilter-class}
\docType{class}
\alias{KOverAFilter-class}

\title{Class "KOverAFilter"}
\description{
  KOverAFilter encapsulates the parameters needed to run a gene filter analysis
  which returns genes for which the number of samples with value exceeding
  'minimumValue' equals or exceeds 'minimumElementNumber'.
}
\section{Objects from the Class}{

  Objects can be created by calls to the constructor
  \code{\link{KOverAFilter}}.

  Elements can be accessed with \code{\link{minimumValue}} and \code{\link{minimumElementNumber}}.

}
\section{Slots}{
  \describe{

    \item{\code{minimumValue}:}{Object of class \code{"numeric"} containing the
        minimum value.}

    \item{\code{minimumElementNumber}:}{Object of class \code{"integer"} containing
        the minimum number of samples that must exceed 'minimumValue' in order for
        the gene being tested to pass the filter.}

  }
}
\section{Methods}{

  See \code{\link{KOverAFilter}}

}

\author{Tom Milac \url{tmilac@fhcrc.org}}

\seealso{

  \code{\link{KOverAFilter}} for object construction, accessors
  \code{\link{minimumValue}}
  \code{\link{minimumElementNumber}}

}

\examples{
showClass("KOverAFilter")
obj <- KOverAFilter(minimumValue=-50.0, minimumElementNumber=5L)
minimumValue(obj)
minimumElementNumber(obj)
}
\keyword{classes}
