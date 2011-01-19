\name{CommonReferenceANOVA}
\alias{CommonReferenceANOVA}

\title{CommonReferenceANOVA constructor and accessors}

\description{
  Functions for creating and manipulating CommonReferenceANOVA-class objects.
}

\usage{
CommonReferenceANOVA(sampleAnnotationCollectionTestColumnName=
                       character(0),
                     testReferenceLevel=character(0),
                     numberOfTopReporters=-1L)
}

\arguments{

  \item{sampleAnnotationCollectionTestColumnName}{A character vector of
    length one specifying a column name in a SampleAnnotationCollection
    on which to test.}

  \item{testReferenceLevel}{A character vector of length one specifying
    the test reference level which must be one of the levels of the data,
    interpreted as a factor, in the sampleAnnotationCollectionTestColumnName column.}

  \item{numberOfTopReporters}{An integer vector of length one specifying the
    number of top reporters to return.}

}

\value{

  \item{CommonReferenceANOVA}{Object of class
    \code{\linkS4class{CommonReferenceANOVA}}.}

}

\author{Tom Milac \url{tmilac@fhcrc.org}}

\seealso{\code{\linkS4class{CommonReferenceANOVA}-class},
  \code{\link{numberOfTopReporters}}.
  \code{\link{sampleAnnotationCollectionTestColumnName}},
  \code{\link{testReferenceLevel}}}

\examples{
obj <- CommonReferenceANOVA(sampleAnnotationCollectionTestColumnName=
                              character(0),
                            testReferenceLevel=character(0),
                            numberOfTopReporters=-1L)
sampleAnnotationCollectionTestColumnName(obj)
testReferenceLevel(obj)
numberOfTopReporters(obj)
}

\keyword{manip}
