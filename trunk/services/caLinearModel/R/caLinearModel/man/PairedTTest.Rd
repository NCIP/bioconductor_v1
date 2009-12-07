\name{PairedTTest}
\alias{PairedTTest}
\alias{sampleAnnotationCollectionPairingColumnName}

\title{PairedTTest constructor and accessors}

\description{
  Functions for creating and manipulating PairedTTest-class objects.
}

\usage{
PairedTTest(sampleAnnotationCollectionTestColumnName=character(0),
            sampleAnnotationCollectionPairingColumnName=character(0),
            numberOfTopReporters=-1L)
sampleAnnotationCollectionPairingColumnName(object, ...)
}

\arguments{

  \item{sampleAnnotationCollectionTestColumnName}{A character vector of
    length one specifying a column name on which to test in a
    SampleAnnotationCollection.}

  \item{sampleAnnotationCollectionPairingColumnName}{A character
    vector of length one specifying a column name containing pairing
    information in a SampleAnnotationCollection.}

  \item{numberOfTopReporters}{A integer vector of length one specifying the
    number of top reporters to return.}

  \item{object}{An object of class \code{PairedTTest}, from which
    a sampleAnnotationCollectionTestColumnName, 
    sampleAnnotationCollectionPairingColumnName or numberOfTopReporters
    is to be extracted.}

  \item{\dots}{Additional arguments, passed to the class initialization
    method or (currently) ignored by the accessors.}

}

\value{

  \item{PairedTTest}{Object of class
    \code{\linkS4class{PairedTTest}}.}

  \item{sampleAnnotationCollectionPairingColumnName}{a character vector
    of length one containing the pairing column name in a
    SampleAnnotationCollection.}

}

\author{Tom Milac \url{tmilac@fhcrc.org}}

\seealso{\code{\linkS4class{PairedTTest}-class},
  \code{\link{numberOfTopReporters}}.
  \code{\link{sampleAnnotationCollectionTestColumnName}}.}

\examples{
obj <- PairedTTest(sampleAnnotationCollectionTestColumnName=character(0),
                   sampleAnnotationCollectionPairingColumnName=character(0),
                   numberOfTopReporters=-1L)
sampleAnnotationCollectionTestColumnName(obj)
sampleAnnotationCollectionPairingColumnName(obj)
numberOfTopReporters(obj)
}

\keyword{manip}
