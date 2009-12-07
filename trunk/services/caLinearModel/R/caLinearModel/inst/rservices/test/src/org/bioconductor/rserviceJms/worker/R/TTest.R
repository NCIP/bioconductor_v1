sampleAnnotationCollectionTestColumnName <- "handedness"
numberOfTopReporters                     <- 10L

tTest <- try( TTest(
                sampleAnnotationCollectionTestColumnName=sampleAnnotationCollectionTestColumnName,
                numberOfTopReporters=numberOfTopReporters),
              silent=TRUE )

if(is(tTest, "try-error"))
	tTest <- NULL
