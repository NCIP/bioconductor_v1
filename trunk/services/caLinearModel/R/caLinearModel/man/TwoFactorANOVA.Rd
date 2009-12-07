\name{TwoFactorANOVA}
\alias{TwoFactorANOVA}
\alias{sampleAnnotationCollectionFactorOneColumnName}
\alias{sampleAnnotationCollectionFactorTwoColumnName}

\title{TwoFactorANOVA constructor and accessors}

\description{
  Functions for creating and manipulating TwoFactorANOVA-class objects.
}

\usage{
TwoFactorANOVA(sampleAnnotationCollectionFactorOneColumnName=character(0),
               sampleAnnotationCollectionFactorTwoColumnName=character(0),
               numberOfTopReporters=-1L)
sampleAnnotationCollectionFactorOneColumnName(object, ...)
sampleAnnotationCollectionFactorTwoColumnName(object, ...)
}

\arguments{

  \item{sampleAnnotationCollectionFactorOneColumnName}{A character vector of
    length one specifying a column name on which to test in a
    SampleAnnotationCollection.}

  \item{sampleAnnotationCollectionFactorTwoColumnName}{A character vector of
    length one specifying a column name on which to test in a
    SampleAnnotationCollection.}

  \item{numberOfTopReporters}{A integer vector of length one specifying the
    number of top reporters to return.}

  \item{object}{An object of class \code{OneFactorANOVA}, from which
    a sampleAnnotationCollectionFactorOneColumnName,
    sampleAnnotationCollectionFactorTwoColumnName or numberOfTopReporters
    is to be extracted.}

  \item{\dots}{Additional arguments, passed to the class initialization
    method or (currently) ignored by the accessors.}

}

\value{

  \item{TwoFactorANOVA}{Object of class
    \code{\linkS4class{TwoFactorANOVA}}.}

  \item{sampleAnnotationCollectionFactorOneColumnName}{a character
    vector of length one containing a test column name in a
    SampleAnnotationCollection.}

  \item{sampleAnnotationCollectionFactorTwpColumnName}{a character
    vector of length one containing a test column name in a
    SampleAnnotationCollection.}

}

\author{Tom Milac \url{tmilac@fhcrc.org}}

\seealso{\code{\linkS4class{TwoFactorANOVA}-class},
  \code{\link{numberOfTopReporters}}.}

\examples{
obj <- TwoFactorANOVA(sampleAnnotationCollectionFactorOneColumnName=character(0),
                      sampleAnnotationCollectionFactorTwoColumnName=character(0),
                      numberOfTopReporters=-1L)
sampleAnnotationCollectionFactorOneColumnName(obj)
sampleAnnotationCollectionFactorTwoColumnName(obj)
numberOfTopReporters(obj)
}

\keyword{manip}
