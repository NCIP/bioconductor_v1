DerivedBioAssayMatrixData <- try(new("DerivedBioAssayMatrix"), silent=TRUE)
if(is(DerivedBioAssayMatrixData, "try-error"))
	DerivedBioAssayMatrixData <- NULL
