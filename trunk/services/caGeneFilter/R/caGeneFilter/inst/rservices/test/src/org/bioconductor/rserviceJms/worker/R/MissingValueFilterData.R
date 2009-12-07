missingValue         <- -Inf
minimumElementNumber <- 26L

missingValueFilterData <- try(MissingValueFilter(missingValue=missingValue,
                                minimumElementNumber=minimumElementNumber), silent=TRUE)
if(is(missingValueFilterData, "try-error"))
    missingValueFilterData <- NULL

