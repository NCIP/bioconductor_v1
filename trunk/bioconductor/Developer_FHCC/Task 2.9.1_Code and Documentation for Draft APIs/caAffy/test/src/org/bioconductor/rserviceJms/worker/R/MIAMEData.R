MIAMEData <- try(new("MIAME"), silent=TRUE)
if(is(MIAMEData, "try-error"))
	MIAMEData <- NULL
