\name{Model}
\alias{Model}

\title{Model constructor and accessors}

\description{
  Functions for creating and manipulating Model-class objects.
}

\usage{
Model(numberOfTopReporters=-1L)
}

\arguments{

  \item{numberOfTopReporters}{A integer vector of length one specifying the
    number of top reporters to return.}

}

\value{

  \item{Model}{Object of class \code{\linkS4class{Model}}.}

}

\author{Tom Milac \url{tmilac@fhcrc.org}}

\seealso{\code{\linkS4class{Model}-class},
  \code{\link{numberOfTopReporters}}.}

\examples{
obj <- Model(numberOfTopReporters=-1L)
numberOfTopReporters(obj)
}

\keyword{manip}
