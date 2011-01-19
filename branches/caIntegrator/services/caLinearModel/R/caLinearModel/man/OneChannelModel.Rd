\name{OneChannelModel}
\alias{OneChannelModel}

\title{OneChannelModel constructor and accessors}

\description{
  Functions for creating and manipulating OneChannelModel-class objects.
}

\usage{
OneChannelModel(numberOfTopReporters=-1L)
}

\arguments{

  \item{numberOfTopReporters}{A integer vector of length one specifying the
    number of top reporters to return.}

}

\value{

  \item{OneChannelModel}{Object of class
    \code{\linkS4class{OneChannelModel}}.}

}

\author{Tom Milac \url{tmilac@fhcrc.org}}

\seealso{\code{\linkS4class{OneChannelModel}-class},
  \code{\link{numberOfTopReporters}}.}

\examples{
obj <- OneChannelModel(numberOfTopReporters=-1L)
numberOfTopReporters(obj)
}

\keyword{manip}
