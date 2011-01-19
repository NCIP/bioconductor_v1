\name{AnnotationFilter}
\alias{AnnotationFilter}

\title{AnnotationFilter constructor and accessors}

\description{
  Functions for creating and manipulating AnnotationFilter-class objects.
}

\usage{
AnnotationFilter( annotation=character(0) )
}

\arguments{

  \item{annotation}{A character vector of length one specifying an
	annotation package.}

}

\value{

  \item{AnnotationFilter}{Object of class
    \code{\linkS4class{AnnotationFilter}}.}

}

\author{Tom Milac \url{tmilac@fhcrc.org}}

\seealso{\code{\linkS4class{AnnotationFilter}-class},
  \code{\link{annotation}}}

\examples{
obj <- AnnotationFilter(annotation="hgu95av2")
annotation(obj)
}

\keyword{manip}
