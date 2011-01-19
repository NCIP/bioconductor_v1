sampleAnnotationCollectionTestColumnName    <- "handedness"
sampleAnnotationCollectionPairingColumnName <- "pairing"
numberOfTopReporters                        <- 10L

pairedTTest <- try( PairedTTest(
                        sampleAnnotationCollectionTestColumnName=sampleAnnotationCollectionTestColumnName,
                        sampleAnnotationCollectionPairingColumnName=sampleAnnotationCollectionPairingColumnName,
                        numberOfTopReporters=numberOfTopReporters),
                    silent=TRUE )

if(is(pairedTTest, "try-error"))
	pairedTTest <- NULL
