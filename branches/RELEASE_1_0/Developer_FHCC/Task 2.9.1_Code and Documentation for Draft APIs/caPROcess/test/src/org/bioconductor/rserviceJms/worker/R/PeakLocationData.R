PeakLocationData <- try(new("PeakLocation"), silent=TRUE)
if(is(PeakLocationData, "try-error"))
	PeakLocationData <- NULL
