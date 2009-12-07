\name{MinimumThresholdRecode-class}
\docType{class}
\alias{MinimumThresholdRecode-class}

\title{Class "MinimumThresholdRecode"}
\description{
  MinimumThresholdRecode encapsulates the parameters needed to run a gene
  recode analysis which returns data values less than the 'minimumThreshold'
  recoded to equal the 'recodeValue'.
}
\section{Objects from the Class}{

  Objects can be created by calls to the constructor
  \code{\link{MinimumThresholdRecode}}.

  Elements can be accessed with \code{\link{recodeValue}} and \code{\link{minimumThreshold}}.

}
\section{Slots}{
  \describe{

    \item{\code{recodeValue}:}{Object of class \code{"numeric"} containing the
        recode value.}

    \item{\code{minimumThreshold}:}{Object of class \code{"numeric"} containing
        the minimum threshold.}

  }
}
\section{Methods}{

  See \code{\link{MinimumThresholdRecode}}

}

\author{Tom Milac \url{tmilac@fhcrc.org}}

\seealso{

  \code{\link{MinimumThresholdRecode}} for object construction, accessors
  \code{\link{recodeValue}}
  \code{\link{minimumThreshold}}

}

\examples{
showClass("MinimumThresholdRecode")
obj <- MinimumThresholdRecode(minimumThreshold=-Inf, recodeValue=-Inf)
recodeValue(obj)
minimumThreshold(obj)
}
\keyword{classes}
