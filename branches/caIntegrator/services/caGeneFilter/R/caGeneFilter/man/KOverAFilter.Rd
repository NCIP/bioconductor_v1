\name{KOverAFilter}
\alias{KOverAFilter}
\alias{minimumValue}

\title{KOverAFilter constructor and accessors}

\description{
  Functions for creating and manipulating KOverAFilter-class objects.
}

\usage{
KOverAFilter(minimumValue=-Inf, minimumElementNumber=0L)
minimumValue(object, ...)
}

\arguments{

  \item{minimumValue}{A numeric vector of length one specifying a
	minimum value.}

  \item{minimumElementNumber}{An integer vector of length one specifying
    the nubmer of samples that must exceed 'minimumValue' in order for
    the filter to accept or pass the gene being tested.}

  \item{object}{An object of class \code{KOverAFilter}, from which a
    minimumValue or minimumElementNumber are to be extracted.}

  \item{\dots}{Additional arguments, passed to the class initialization
    method or (currently) ignored by the accessors.}

}

\value{

  \item{KOverAFilter}{Object of class
    \code{\linkS4class{KOverAFilter}}.}

  \item{minimumValue}{length one numeric vector containing the minimum value.}

}

\author{Tom Milac \url{tmilac@fhcrc.org}}

\seealso{\code{\linkS4class{KOverAFilter}-class},
  \code{\link{minimumElementNumber}}}

\examples{
obj <- KOverAFilter(minimumValue=-50.0, minimumElementNumber=5L)
minimumValue(obj)
minimumElementNumber(obj)
}

\keyword{manip}
