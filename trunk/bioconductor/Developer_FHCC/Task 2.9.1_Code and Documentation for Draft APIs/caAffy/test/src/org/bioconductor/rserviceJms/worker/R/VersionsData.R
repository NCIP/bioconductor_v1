VersionsData <- try(new("Versions"), silent=TRUE)
if(is(VersionsData, "try-error"))
	VersionsData <- NULL
