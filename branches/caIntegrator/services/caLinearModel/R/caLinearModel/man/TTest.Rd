\name{TTest}
\alias{TTest}

\title{TTest constructor and accessors}

\description{
  Functions for creating and manipulating TTest-class objects.
}

\usage{
TTest(sampleAnnotationCollectionTestColumnName=character(0),
      numberOfTopReporters=-1L)
}

\arguments{

  \item{sampleAnnotationCollectionTestColumnName}{A character vector of
    length one specifying the column name of the column in a
    SampleAnnotationCollection on which to perform the test.}

  \item{numberOfTopReporters}{A integer vector of length one specifying the
    number of top reporters to return.}

}

\value{

  \item{TTest}{Object of class \code{\linkS4class{TTest}}.}

}

\author{Tom Milac \url{tmilac@fhcrc.org}}

\seealso{\code{\linkS4class{TTest}-class},
  \code{\link{numberOfTopReporters}}.
  \code{\link{sampleAnnotationCollectionTestColumnName}}.}

\examples{
obj <- TTest(sampleAnnotationCollectionTestColumnName=character(0),
             numberOfTopReporters=-1L)
sampleAnnotationCollectionTestColumnName(obj)
numberOfTopReporters(obj)
}

\keyword{manip}
