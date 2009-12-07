\name{MaximumThresholdRecode}
\alias{MaximumThresholdRecode}
\alias{maximumThreshold}

\title{MaximumThresholdRecode constructor and accessors}

\description{
  Functions for creating and manipulating MaximumThresholdRecode-class objects.
}

\usage{
MaximumThresholdRecode(maximumThreshold=Inf, recodeValue=maximumThreshold)
maximumThreshold(object, ...)
}

\arguments{

  \item{recodeValue}{A numeric vector of length one specifying a recode value.}

  \item{maximumThreshold}{An numeric vector of length one specifying the
    maximum threshold value.}

  \item{object}{An object of class \code{MaximumThresholdRecode}, from
    which a recodeValue or maximumThreshold are to be extracted.}

  \item{\dots}{Additional arguments, passed to the class initialization
    method or (currently) ignored by the accessors.}

}

\value{

  \item{MaximumThresholdRecode}{Object of class
    \code{\linkS4class{MaximumThresholdRecode}}.}

  \item{maximumThreshold}{length one numeric vector containing the
	maximum threshold.}

}

\author{Tom Milac \url{tmilac@fhcrc.org}}

\seealso{\code{\linkS4class{MaximumThresholdRecode}-class},
  \code{\link{recodeValue}}}

\examples{
obj <- MaximumThresholdRecode(maximumThreshold=Inf, recodeValue=Inf)
recodeValue(obj)
maximumThreshold(obj)
}

\keyword{manip}
