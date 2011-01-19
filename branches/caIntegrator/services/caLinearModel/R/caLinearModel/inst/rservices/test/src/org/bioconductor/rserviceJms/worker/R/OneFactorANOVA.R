sampleAnnotationCollectionTestColumnName <- "ageCohort"
numberOfTopReporters                     <- 10L

oneFactorANOVA <- try( OneFactorANOVA(
                            sampleAnnotationCollectionTestColumnName=sampleAnnotationCollectionTestColumnName,
                            numberOfTopReporters=numberOfTopReporters),
                       silent=TRUE )

if(is(oneFactorANOVA, "try-error"))
	oneFactorANOVA <- NULL
