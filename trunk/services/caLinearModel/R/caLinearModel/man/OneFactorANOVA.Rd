\name{OneFactorANOVA}
\alias{OneFactorANOVA}

\title{OneFactorANOVA constructor and accessors}

\description{
  Functions for creating and manipulating OneFactorANOVA-class objects.
}

\usage{
OneFactorANOVA(sampleAnnotationCollectionTestColumnName=character(0),
               numberOfTopReporters=-1L)
}

\arguments{

  \item{sampleAnnotationCollectionTestColumnName}{A character vector of
    length one specifying a column name on which to test in a
    SampleAnnotationCollection.}

  \item{numberOfTopReporters}{A integer vector of length one specifying the
    number of top reporters to return.}

}

\value{

  \item{OneFactorANOVA}{Object of class
    \code{\linkS4class{OneFactorANOVA}}.}

}

\author{Tom Milac \url{tmilac@fhcrc.org}}

\seealso{\code{\linkS4class{OneFactorANOVA}-class},
  \code{\link{numberOfTopReporters}}.
  \code{\link{sampleAnnotationCollectionTestColumnName}}}

\examples{
obj <- OneFactorANOVA(sampleAnnotationCollectionTestColumnName=character(0),
                      numberOfTopReporters=-1L)
sampleAnnotationCollectionTestColumnName(obj)
numberOfTopReporters(obj)
}

\keyword{manip}
