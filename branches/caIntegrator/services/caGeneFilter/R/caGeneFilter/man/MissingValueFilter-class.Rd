\name{MissingValueFilter-class}
\docType{class}
\alias{MissingValueFilter-class}

\title{Class "MissingValueFilter"}
\description{
  MissingValueFilter encapsulates the parameters needed to run a gene filter analysis
  which returns genes for which 'minimumElementNumber' of samples are not missing,
  that is, whose values do not equal 'missingValue'.
}
\section{Objects from the Class}{

  Objects can be created by calls to the constructor
  \code{\link{MissingValueFilter}}.

  Elements can be accessed with \code{\link{missingValue}} and \code{\link{minimumElementNumber}}.

}
\section{Slots}{
  \describe{

    \item{\code{missingValue}:}{Object of class \code{"numeric"} containing the
        missing value.}

    \item{\code{minimumElementNumber}:}{Object of class \code{"integer"} containing
        the minimum number of samples not having the value specified by
        'missingValue' required in order for the gene to be returned.}

  }
}
\section{Methods}{

  See \code{\link{MissingValueFilter}}

}

\author{Tom Milac \url{tmilac@fhcrc.org}}

\seealso{

  \code{\link{MissingValueFilter}} for object construction, accessors
  \code{\link{missingValue}}
  \code{\link{minimumElementNumber}}

}

\examples{
showClass("MissingValueFilter")
obj <- MissingValueFilter(missingValue=as.numeric(NA), minimumElementNumber=0L)
missingValue(obj)
minimumElementNumber(obj)
}
\keyword{classes}
