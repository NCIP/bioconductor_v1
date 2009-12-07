\name{VarianceFilter}
\alias{VarianceFilter}
\alias{minimumVariance}

\title{VarianceFilter constructor and accessors}

\description{
  Functions for creating and manipulating VarianceFilter-class objects.
}

\usage{
VarianceFilter(minimumVariance=0.5)
minimumVariance(object, ...)
}

\arguments{

  \item{minimumVariance}{A numeric vector of length one specifying a minimum variance.}

  \item{object}{An object of class \code{VarianceFilter}, from which
    a minimumValue or minimumElementNumber are to be extracted.}

  \item{\dots}{Additional arguments, passed to the class initialization
    method or (currently) ignored by the accessors.}

}

\value{

  \item{VarianceFilter}{Object of class
    \code{\linkS4class{VarianceFilter}}.}

  \item{minimumVariance}{length one numeric vector containing the minimum variance.}

}

\author{Tom Milac \url{tmilac@fhcrc.org}}

\seealso{\code{\linkS4class{VarianceFilter}-class}}

\examples{
obj <- VarianceFilter(minimumVariance=0.5)
minimumVariance(obj)
}

\keyword{manip}
