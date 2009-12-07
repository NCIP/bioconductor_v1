\name{EntrezFilter}
\alias{EntrezFilter}

\title{EntrezFilter constructor and accessors}

\description{
  Functions for creating and manipulating EntrezFilter-class objects.
}

\usage{
EntrezFilter( annotation=character(0) )
}

\arguments{

  \item{annotation}{A character vector of length one specifying an
	annotation package.}

}

\value{

  \item{EntrezFilter}{Object of class
    \code{\linkS4class{EntrezFilter}}.}

}

\author{Tom Milac \url{tmilac@fhcrc.org}}

\seealso{\code{\linkS4class{EntrezFilter}-class},
  \code{\link{annotation}}}

\examples{
obj <- EntrezFilter(annotation="hgu95av2")
annotation(obj)
}

\keyword{manip}
