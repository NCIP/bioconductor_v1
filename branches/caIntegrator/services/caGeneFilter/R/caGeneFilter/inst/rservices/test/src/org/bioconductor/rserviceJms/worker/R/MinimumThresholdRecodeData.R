minimumThreshold <- -8000.0

minimumThresholdRecodeData <- try(MinimumThresholdRecode(minimumThreshold=minimumThreshold), silent=TRUE)
if(is(minimumThresholdRecodeData, "try-error"))
    minimumThresholdRecodeData <- NULL

