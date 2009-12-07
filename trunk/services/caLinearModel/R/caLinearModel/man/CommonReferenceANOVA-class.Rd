\name{CommonReferenceANOVA-class}
\docType{class}
\alias{CommonReferenceANOVA-class}

\title{Class "CommonReferenceANOVA"}
\description{

  CommonReferenceANOVA encapsulates the parameters required to execute a
  common reference ANOVA test.
}
\section{Objects from the Class}{

  Objects can be created by calls to the constructor
  \code{\link{CommonReferenceANOVA}}.

  Elements can be accessed with
  \code{\link{sampleAnnotationCollectionTestColumnName}},
  \code{\link{testReferenceLevel}}
  \code{\link{numberOfTopReporters}}.

}
\section{Slots}{
  \describe{

    \item{\code{sampleAnnotationCollectionTestColumnName}:}{Object of class
        \code{"character"} specifying the column name of the column in a
        SampleAnnotationCollection on which to execute the test.  The data
        in this column must be interpretable as a factor with 3 or more levels.}

    \item{\code{testReferenceLevel}:}{Object of class
        \code{"character"} specifying the reference level for the test.
        The test reference level must correspond to one of the levels of
        the data, interpreted as a factor, in the
        sampleAnnotationCollectionTestColumnName column.}

    \item{\code{numberOfTopReporters}:}{Object of class \code{"integer"}
        specifying the number of top (most significant) reporters to return.
        A value of -1 specifies that all reporters should be returned.}

  }
}
\section{Methods}{

  See \code{\link{CommonReferenceANOVA}}

}

\author{Tom Milac \url{tmilac@fhcrc.org}}

\seealso{

  \code{\link{CommonReferenceANOVA}} for object construction, accessors
  \code{\link{sampleAnnotationCollectionTestColumnName}}
  \code{\link{testReferenceLevel}}
  \code{\link{numberOfTopReporters}}
}

\examples{
showClass("CommonReferenceANOVA")
obj <- CommonReferenceANOVA(sampleAnnotationCollectionTestColumnName=character(0),
                            testReferenceLevel=character(0),
                            numberOfTopReporters=-1L)
sampleAnnotationCollectionTestColumnName(obj)
testReferenceLevel(obj)
numberOfTopReporters(obj)
}
\keyword{classes}
