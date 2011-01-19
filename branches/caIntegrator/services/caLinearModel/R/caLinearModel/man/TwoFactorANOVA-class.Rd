\name{TwoFactorANOVA-class}
\docType{class}
\alias{TwoFactorANOVA-class}

\title{Class "TwoFactorANOVA"}
\description{

  TwoFactorANOVA encapsulates the parameters required to execute a two-factor
  analysis of variance (ANOVA).
}
\section{Objects from the Class}{

  Objects can be created by calls to the constructor
  \code{\link{TwoFactorANOVA}}.

  Elements can be accessed with
  \code{\link{sampleAnnotationCollectionFactorOneColumnName}},
  \code{\link{sampleAnnotationCollectionFactorTwoColumnName}}
  \code{\link{numberOfTopReporters}}.

}
\section{Slots}{
  \describe{

    \item{\code{sampleAnnotationCollectionFactorOneColumnName}:}{Object of class
        \code{"character"} specifying the column name of the column in a
        SampleAnnotationCollection on which to execute the test.  The data
        in this column must be interpretable as a factor with 2 or more levels.}

    \item{\code{sampleAnnotationCollectionFactorTwoColumnName}:}{Object of class
        \code{"character"} specifying the column name of the column in a
        SampleAnnotationCollection on which to execute the test.  The data
        in this column must be interpretable as a factor with 2 or more levels.}

    \item{\code{numberOfTopReporters}:}{Object of class \code{"integer"}
        specifying the number of top (most significant) reporters to return.
        A value of -1 specifies that all reporters should be returned.}

  }
}
\section{Methods}{

  See \code{\link{TwoFactorANOVA}}

}

\author{Tom Milac \url{tmilac@fhcrc.org}}

\seealso{

  \code{\link{TwoFactorANOVA}} for object construction, accessors
  \code{\link{sampleAnnotationCollectionFactorOneColumnName}}
  \code{\link{sampleAnnotationCollectionFactorTwoColumnName}}
  \code{\link{numberOfTopReporters}}
}

\examples{
showClass("TwoFactorANOVA")
obj <- TwoFactorANOVA(sampleAnnotationCollectionFactorOneColumnName=character(0),
                      sampleAnnotationCollectionFactorTwoColumnName=character(0),
                      numberOfTopReporters=-1L)
sampleAnnotationCollectionFactorOneColumnName(obj)
sampleAnnotationCollectionFactorTwoColumnName(obj)
numberOfTopReporters(obj)
}
\keyword{classes}
