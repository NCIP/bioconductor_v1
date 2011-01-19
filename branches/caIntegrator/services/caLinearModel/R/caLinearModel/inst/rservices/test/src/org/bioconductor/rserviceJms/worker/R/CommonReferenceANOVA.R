sampleAnnotationCollectionTestColumnName <- "ageCohort"
testReferenceLevel                       <- "Mix"
numberOfTopReporters                     <- 10L

commonReferenceANOVA <- try( CommonReferenceANOVA(
                                sampleAnnotationCollectionTestColumnName=sampleAnnotationCollectionTestColumnName,
                                testReferenceLevel=testReferenceLevel,
                                numberOfTopReporters=numberOfTopReporters),
                             silent=TRUE )

if(is(commonReferenceANOVA, "try-error"))
	commonReferenceANOVA <- NULL
