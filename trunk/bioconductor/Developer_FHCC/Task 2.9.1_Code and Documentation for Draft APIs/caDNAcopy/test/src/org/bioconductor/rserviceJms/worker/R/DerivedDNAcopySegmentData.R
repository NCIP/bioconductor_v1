DerivedDNAcopySegmentData <- try(new("DerivedDNAcopySegment"), silent=TRUE)
if(is(DerivedDNAcopySegmentData, "try-error"))
	DerivedDNAcopySegmentData <- NULL
