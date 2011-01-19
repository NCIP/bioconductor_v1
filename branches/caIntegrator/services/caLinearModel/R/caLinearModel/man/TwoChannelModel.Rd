\name{TwoChannelModel}
\alias{TwoChannelModel}

\title{TwoChannelModel constructor and accessors}

\description{
  Functions for creating and manipulating TwoChannelModel-class objects.
}

\usage{
TwoChannelModel(numberOfTopReporters=-1L)
}

\arguments{

  \item{numberOfTopReporters}{A integer vector of length one specifying the
    number of top reporters to return.}

}

\value{

  \item{TwoChannelModel}{Object of class
    \code{\linkS4class{TwoChannelModel}}.}

}

\author{Tom Milac \url{tmilac@fhcrc.org}}

\seealso{\code{\linkS4class{TwoChannelModel}-class},
  \code{\link{numberOfTopReporters}}.}

\examples{
obj <- TwoChannelModel(numberOfTopReporters=-1L)
numberOfTopReporters(obj)
}

\keyword{manip}
