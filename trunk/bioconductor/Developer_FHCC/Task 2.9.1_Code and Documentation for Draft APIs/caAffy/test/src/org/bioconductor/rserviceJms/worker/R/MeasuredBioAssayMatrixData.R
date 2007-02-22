MeasuredBioAssayMatrixData <- try(new("MeasuredBioAssayMatrix"), silent=TRUE)
if(is(MeasuredBioAssayMatrixData, "try-error"))
	MeasuredBioAssayMatrixData <- NULL
