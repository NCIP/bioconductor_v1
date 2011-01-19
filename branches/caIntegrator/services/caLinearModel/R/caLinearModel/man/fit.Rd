\name{fit}
\alias{fit}

\title{RWebServices interface to the limma package}

\description{
  Provides access to the limma package as an RWebService.
}

\usage{
fit(oneChannelModel, oneChannelExpressionData, sampleAnnotationCollection)
}

\arguments{
  \item{oneChannelModel}{ An object of class \code{OneChannelModel} }
  \item{oneChannelExpressionData}{ An object of class \code{OneChannelExpressionData} }
  \item{sampleAnnotationCollection}{ An object of class \code{SampleAnnotationCollection} }
}

\value{
  An object of class \code{TopTableCollection}.
}

\author{Tom Milac <tmilac@fhcrc.org>}

% \seealso{ objects to See Also as \code{\link{help}},  }

\examples{

   # Test data derived from the Bioconductor ALL data set.

   data(OneChannelTest.oneChannelExpressionData)
   data(OneChannelTest.sampleAnnotationCollection)

   oneChannelExpressionData   <- OneChannelTest.oneChannelExpressionData
   sampleAnnotationCollection <- OneChannelTest.sampleAnnotationCollection

   # Execute a t-test testing differential expression between the 'L' and
   # 'R' levels of the 'handedness' column of the 'sampleAnnotationCollection'.

   oneChannelModel    <- TTest(sampleAnnotationCollectionTestColumnName="handedness",
                               numberOfTopReporters=10L)
   topTableCollection <- fit(oneChannelModel, oneChannelExpressionData, sampleAnnotationCollection)

   # Execute a paired t-test testing differential expression between the 'L'
   # and 'R' levels of the 'handedness' column of 'sampleAnnotationCollection' paired
   # according to the data in the 'pairing' column.

   oneChannelModel    <- PairedTTest(sampleAnnotationCollectionTestColumnName="handedness",
                                     sampleAnnotationCollectionPairingColumnName="pairing",
                                     numberOfTopReporters=10L)
   topTableCollection <- fit(oneChannelModel, oneChannelExpressionData, sampleAnnotationCollection)

   # Execute a one-way ANOVA test testing differential expression across the
   # levels of the 'ageCohort' column of 'sampleAnnotationCollection'.

   oneChannelModel    <- OneFactorANOVA(sampleAnnotationCollectionTestColumnName="ageCohort",
                                     numberOfTopReporters=10L)
   topTableCollection <- fit(oneChannelModel, oneChannelExpressionData, sampleAnnotationCollection)

   # Execute an analysis based on a 2-way factorial design with 'handedness'
   # as the first factor and 'ageCohort' as the second.

   oneChannelModel    <- TwoFactorANOVA(sampleAnnotationCollectionFactorOneColumnName="handedness",
                                   sampleAnnotationCollectionFactorTwoColumnName="ageCohort",
                                   numberOfTopReporters=10L)
   topTableCollection <- fit(oneChannelModel, oneChannelExpressionData, sampleAnnotationCollection)

}

% Add one or more standard keywords, see file 'KEYWORDS' in the
% R documentation directory.
\keyword{ manip }
