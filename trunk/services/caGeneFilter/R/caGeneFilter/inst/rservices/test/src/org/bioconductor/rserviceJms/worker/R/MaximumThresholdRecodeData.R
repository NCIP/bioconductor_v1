maximumThreshold <- 10000.0

maximumThresholdRecodeData <- try(MaximumThresholdRecode(maximumThreshold=maximumThreshold), silent=TRUE)
if(is(maximumThresholdRecodeData, "try-error"))
    maximumThresholdRecodeData <- NULL

