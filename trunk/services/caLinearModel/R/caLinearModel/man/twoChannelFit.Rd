\name{twoChannelFit}
\alias{twoChannelFit}

\title{RWebServices interface to the limma package}

\description{
  Provides access to the limma package as an RWebService.
}

\usage{
twoChannelFit(twoChannelModel, twoChannelExpressionData, sampleAnnotationCollection)
}

\arguments{
  \item{twoChannelModel}{ An object of class \code{TwoChannelModel} }
  \item{twoChannelExpressionData}{ An object of class \code{TwoChannelExpressionData} },
  \item{sampleAnnotationCollection}{ An object of class \code{SampleAnnotationCollection} }
}

\value{
  An object of class \code{TopTableCollection}.
}

\author{Tom Milac <tmilac@fhcrc.org>}

% \seealso{ objects to See Also as \code{\link{help}},  }

\examples{

   # Test data for TwoChannelModel fits, derived from GEO assession
   # number GSE10235.

   data(TwoChannelTest.twoChannelExpressionData)
   data(TwoChannelTest.sampleAnnotationCollection)

   twoChannelExpressionData   <- TwoChannelTest.twoChannelExpressionData
   sampleAnnotationCollection <- TwoChannelTest.sampleAnnotationCollection

   # DyeSwapTTest: execute a dye-swap t-test testing differential expression
   # between the 'L' and 'R' levels of the 'handedness' column of the
   # 'sampleAnnotationCollection'.

   twoChannelModel    <- DyeSwapTTest( sampleAnnotationCollectionTestColumnName="handedness",
                                       testReferenceLevel="R",
                                       numberOfTopReporters=10L )
   topTableCollection <- twoChannelFit(twoChannelModel,
                                       twoChannelExpressionData,
                                       sampleAnnotationCollection)

   # CommonReferenceANOVA.

   twoChannelModel <- CommonReferenceANOVA( sampleAnnotationCollectionTestColumnName="ageCohort",
                                            testReferenceLevel="Mix",
                                            numberOfTopReporters=10L     )
   topTableCollection <- twoChannelFit( twoChannelModel,
                                        twoChannelExpressionData,
                                        sampleAnnotationCollection )
}

% Add one or more standard keywords, see file 'KEYWORDS' in the
% R documentation directory.
\keyword{ manip }
