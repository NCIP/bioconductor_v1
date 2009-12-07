\name{SpotQualityRecode-class}
\docType{class}
\alias{SpotQualityRecode-class}

\title{Class "SpotQualityRecode"}
\description{
  SpotQualityRecode encapsulates the parameters needed to run a gene
  recode analysis which recodes data values to the 'recodeValue' for
  which the corresponding value in the 'columnIndentifier' column is
  less than columnMinimumThresholdValue.
}
\section{Objects from the Class}{

  Objects can be created by calls to the constructor
  \code{\link{SpotQualityRecode}}.

  Elements can be accessed with \code{\link{recodeValue}}, \code{\link{columnIdentifier}}
  and \code{\link{columnMinimumThresholdValue}}.

}
\section{Slots}{
  \describe{

    \item{\code{recodeValue}:}{Object of class \code{"numeric"} containing the
        recode value.}

    \item{\code{columnIdentifier}:}{Object of class \code{"character"} containing
        the identifier of the column the data of which determine the recode.}

    \item{\code{columnMinimumThresholdValue}:}{Object of class \code{"numeric"} containing
        the minimum threshold value.}

  }
}
\section{Methods}{

  See \code{\link{SpotQualityRecode}}

}

\author{Tom Milac \url{tmilac@fhcrc.org}}

\seealso{

  \code{\link{SpotQualityRecode}} for object construction, accessors
  \code{\link{recodeValue}}
  \code{\link{columnIdentifier}}
  \code{\link{columnMinimumThresholdValue}}

}

\examples{
showClass("SpotQualityRecode")
obj <- SpotQualityRecode(columnIdentifier=character(0), columnMinimumThresholdValue=-Inf, recodeValue=-Inf)
columnIdentifier(obj)
columnMinimumThresholdValue(obj)
recodeValue(obj)
}
\keyword{classes}
