\name{MissingValueFilter}
\alias{MissingValueFilter}
\alias{missingValue}

\title{MissingValueFilter constructor and accessors}

\description{
  Functions for creating and manipulating MissingValueFilter-class objects.
}

\usage{
MissingValueFilter(missingValue=as.numeric(NA), minimumElementNumber=0L)
missingValue(object, ...)
}

\arguments{

  \item{missingValue}{A numeric vector of length one specifying a
	missing value.}

  \item{minimumElementNumber}{An integer vector of length one specifying
	the minimum number of samples that must have a value not equal to
	'missingValue'.}

  \item{object}{An object of class \code{MissingValueFilter}, from which
    a missingValue or minimumElementNumber are to be extracted.}

  \item{\dots}{Additional arguments, passed to the class initialization
    method or (currently) ignored by the accessors.}

}

\value{

  \item{MissingValueFilter}{Object of class
    \code{\linkS4class{MissingValueFilter}}.}

  \item{missingValue}{length one numeric vector containing the missing value.}

}

\author{Tom Milac \url{tmilac@fhcrc.org}}

\seealso{\code{\linkS4class{MissingValueFilter}-class},
  \code{\link{minimumElementNumber}}}

\examples{
obj <- MissingValueFilter(missingValue=as.numeric(NA), minimumElementNumber=0L)
missingValue(obj)
minimumElementNumber(obj)
}

\keyword{manip}
