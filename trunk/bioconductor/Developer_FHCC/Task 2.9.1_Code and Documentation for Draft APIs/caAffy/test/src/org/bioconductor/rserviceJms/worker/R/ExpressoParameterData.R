ExpressoParameterData <- try(new("ExpressoParameter"), silent=TRUE)
if(is(ExpressoParameterData, "try-error"))
	ExpressoParameterData <- NULL
