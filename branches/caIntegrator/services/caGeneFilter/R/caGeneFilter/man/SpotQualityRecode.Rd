\name{SpotQualityRecode}
\alias{SpotQualityRecode}
\alias{columnIdentifier}
\alias{columnMinimumThresholdValue}

\title{SpotQualityRecode constructor and accessors}

\description{
  Functions for creating and manipulating SpotQualityRecode-class objects.
}

\usage{
SpotQualityRecode(columnIdentifier=character(0),
                  columnMinimumThresholdValue=-Inf,
                  recodeValue=-Inf)
columnIdentifier(object, ...)
columnMinimumThresholdValue(object, ...)
}

\arguments{

  \item{columnIdentifier}{A character vector of length one specifying a
	column identifier.}

  \item{columnMinimumThresholdValue}{An numeric vector of length one
    specifying the minimum threshold to apply to the 'columnIdentifier'
    column.}

  \item{recodeValue}{A numeric vector of length one specifying a recode
	value.}

  \item{object}{An object of class \code{SpotQualityRecode}, from which
    a columnIdentifier, columnMinimumThresholdValue or recodeValue or
    are to be extracted.}

  \item{\dots}{Additional arguments, passed to the class initialization
    method or (currently) ignored by the accessors.}

}

\value{

  \item{SpotQualityRecode}{Object of class
    \code{\linkS4class{SpotQualityRecode}}.}

  \item{columnIdentifier}{length one character vector containing the
    name of the column on which to decide the recode.}

  \item{columnMinimumThresholdValue}{length one numeric vector
	containing the column minimum threshold.}

}

\author{Tom Milac \url{tmilac@fhcrc.org}}

\seealso{\code{\linkS4class{SpotQualityRecode}-class},
  \code{\link{recodeValue}}}

\examples{
obj <- SpotQualityRecode(columnIdentifier=character(0), columnMinimumThresholdValue=-Inf, recodeValue=-Inf)
columnIdentifier(obj)
columnMinimumThresholdValue(obj)
recodeValue(obj)
}

\keyword{manip}
