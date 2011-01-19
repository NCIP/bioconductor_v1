sampleAnnotationCollectionFactorOneColumnName <- "handedness"
sampleAnnotationCollectionFactorTwoColumnName <- "ageCohort"
numberOfTopReporters                          <- 10L

fac <- try( TwoFactorANOVA(
                sampleAnnotationCollectionFactorOneColumnName=sampleAnnotationCollectionFactorOneColumnName,
                sampleAnnotationCollectionFactorTwoColumnName=sampleAnnotationCollectionFactorTwoColumnName,
                numberOfTopReporters=numberOfTopReporters),
            silent=TRUE )

if(is(fac, "try-error"))
	fac <- NULL
