ProbeLevelLinearModelData <- try(new("ProbeLevelLinearModel"), silent=TRUE)
if(is(ProbeLevelLinearModelData, "try-error"))
	ProbeLevelLinearModelData <- NULL
