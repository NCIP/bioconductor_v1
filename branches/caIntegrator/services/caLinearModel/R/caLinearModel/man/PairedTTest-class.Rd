\name{PairedTTest-class}
\docType{class}
\alias{PairedTTest-class}

\title{Class "PairedTTest"}
\description{

  PairedTTest encapsulates the parameters required to execute a paired t-test.
}
\section{Objects from the Class}{

  Objects can be created by calls to the constructor
  \code{\link{PairedTTest}}.

  Elements can be accessed with
  \code{\link{sampleAnnotationCollectionTestColumnName}},
  \code{\link{sampleAnnotationCollectionPairingColumnName}} or
  \code{\link{numberOfTopReporters}}.

}
\section{Slots}{
  \describe{

    \item{\code{sampleAnnotationCollectionTestColumnName}:}{Object of class
        \code{"character"} specifying the column name of the column in a
        SampleAnnotationCollection on which to execute the test.  The data
        in this column must be interpretable as a 2-level factor.}

    \item{\code{sampleAnnotationCollectionPairingColumnName}:}{Object of class
        \code{"character"} specifying the column name of the column in a
        SampleAnnotationCollection which pairs data entries in the
        sampleAnnotationCollectionTestColumnName column.  The data
        in this column must include exactly 2 entries for every level.}

    \item{\code{numberOfTopReporters}:}{Object of class \code{"integer"}
        specifying the number of top (most significant) reporters to return.
        A value of -1 specifies that all reporters should be returned.}

  }
}
\section{Methods}{

  See \code{\link{PairedTTest}}

}

\author{Tom Milac \url{tmilac@fhcrc.org}}

\seealso{

  \code{\link{PairedTTest}} for object construction, accessors
  \code{\link{sampleAnnotationCollectionTestColumnName}}
  \code{\link{sampleAnnotationCollectionPairingColumnName}}
  \code{\link{numberOfTopReporters}}
}

\examples{
showClass("PairedTTest")
obj <- PairedTTest(sampleAnnotationCollectionTestColumnName=character(0),
                   sampleAnnotationCollectionPairingColumnName=character(0),
                   numberOfTopReporters=-1L)
sampleAnnotationCollectionTestColumnName(obj)
sampleAnnotationCollectionPairingColumnName(obj)
numberOfTopReporters(obj)
}
\keyword{classes}
