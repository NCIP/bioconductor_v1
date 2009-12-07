\name{MaximumThresholdRecode-class}
\docType{class}
\alias{MaximumThresholdRecode-class}

\title{Class "MaximumThresholdRecode"}
\description{
  MaximumThresholdRecode encapsulates the parameters needed to run a gene
  recode analysis which returns data values greater than the 'maximumThreshold'
  recoded to equal the 'recodeValue'.
}
\section{Objects from the Class}{

  Objects can be created by calls to the constructor
  \code{\link{MaximumThresholdRecode}}.

  Elements can be accessed with \code{\link{recodeValue}} and \code{\link{maximumThreshold}}.

}
\section{Slots}{
  \describe{

    \item{\code{recodeValue}:}{Object of class \code{"numeric"} containing the
        recode value.}

    \item{\code{maximumThreshold}:}{Object of class \code{"numeric"} containing
        the maximum threshold.}

  }
}
\section{Methods}{

  See \code{\link{MaximumThresholdRecode}}

}

\author{Tom Milac \url{tmilac@fhcrc.org}}

\seealso{

  \code{\link{MaximumThresholdRecode}} for object construction, accessors
  \code{\link{recodeValue}}
  \code{\link{maximumThreshold}}

}

\examples{
showClass("MaximumThresholdRecode")
obj <- MaximumThresholdRecode(maximumThreshold=Inf, recodeValue=Inf)
recodeValue(obj)
maximumThreshold(obj)
}
\keyword{classes}
