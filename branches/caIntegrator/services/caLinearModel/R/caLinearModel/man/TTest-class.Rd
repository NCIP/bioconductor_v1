\name{TTest-class}
\docType{class}
\alias{TTest-class}

\title{Class "TTest"}
\description{

  TTest encapsulates the parameters required to execute a t-test.
}
\section{Objects from the Class}{

  Objects can be created by calls to the constructor
  \code{\link{TTest}}.

  Elements can be accessed with 
  \code{\link{sampleAnnotationCollectionTestColumnName}} or
  \code{\link{numberOfTopReporters}}.

}
\section{Slots}{
  \describe{

    \item{\code{sampleAnnotationCollectionTestColumnName}:}{Object of class
        \code{"character"} specifying the column name of the column in a
        SampleAnnotationCollection on which to execute the test.  The data
        in this column must be interpretable as a 2-level factor.}

    \item{\code{numberOfTopReporters}:}{Object of class \code{"integer"}
        specifying the number of top (most significant) reporters to return.
        A value of -1 specifies that all reporters should be returned.}

  }
}
\section{Methods}{

  See \code{\link{TTest}}

}

\author{Tom Milac \url{tmilac@fhcrc.org}}

\seealso{

  \code{\link{TTest}} for object construction, accessors  
  \code{\link{sampleAnnotationCollectionTestColumnName}}
  \code{\link{numberOfTopReporters}}

}

\examples{
showClass("TTest")
obj <- TTest(sampleAnnotationCollectionTestColumnName="Test column", numberOfTopReporters=-1L)
sampleAnnotationCollectionTestColumnName(obj)
numberOfTopReporters(obj)
}
\keyword{classes}
