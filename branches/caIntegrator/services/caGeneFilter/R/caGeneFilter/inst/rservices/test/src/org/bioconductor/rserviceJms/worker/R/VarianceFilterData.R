minimumVariance <- 0.4

varianceFilterData <- try(VarianceFilter(minimumVariance=minimumVariance), silent=TRUE)
if(is(varianceFilterData, "try-error"))
    varianceFilterData <- NULL

