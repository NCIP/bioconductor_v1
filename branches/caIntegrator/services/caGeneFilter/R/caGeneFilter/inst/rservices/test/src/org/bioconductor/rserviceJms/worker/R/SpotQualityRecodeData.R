columnIdentifier            <- "Flags"
columnMinimumThresholdValue <- -25.0
recodeValue                 <- -Inf

spotQualityRecodeData <- try(SpotQualityRecode(columnIdentifier=columnIdentifier,
                           columnMinimumThresholdValue=columnMinimumThresholdValue,
                           recodeValue=recodeValue), silent=TRUE)
if(is(spotQualityRecodeData, "try-error"))
    spotQualityRecodeData <- NULL

