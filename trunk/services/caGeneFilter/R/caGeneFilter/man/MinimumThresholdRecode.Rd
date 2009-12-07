\name{MinimumThresholdRecode}
\alias{MinimumThresholdRecode}
\alias{minimumThreshold}

\title{MinimumThresholdRecode constructor and accessors}

\description{
  Functions for creating and manipulating MinimumThresholdRecode-class objects.
}

\usage{
MinimumThresholdRecode(minimumThreshold=-Inf, recodeValue=minimumThreshold)
minimumThreshold(object, ...)

}

\arguments{

  \item{recodeValue}{A numeric vector of length one specifying a recode value.}

  \item{minimumThreshold}{An numeric vector of length one specifying the
    minimum threshold value.}

  \item{object}{An object of class \code{MinimumThresholdRecode}, from
    which a recodeValue or minimumThreshold are to be extracted.}

  \item{\dots}{Additional arguments, passed to the class initialization
    method or (currently) ignored by the accessors.}

}

\value{

  \item{MinimumThresholdRecode}{Object of class
    \code{\linkS4class{MinimumThresholdRecode}}.}

  \item{minimumThreshold}{length one numeric vector containing the
	minimum threshold.}

}

\author{Tom Milac \url{tmilac@fhcrc.org}}

\seealso{\code{\linkS4class{MinimumThresholdRecode}-class},
  \code{\link{recodeValue}}}

\examples{
obj <- MinimumThresholdRecode(minimumThreshold=-Inf, recodeValue=-Inf)
recodeValue(obj)
minimumThreshold(obj)
}

\keyword{manip}
