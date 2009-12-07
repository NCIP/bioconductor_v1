minimumValue         <- 200.0
minimumElementNumber <- 5L

kOverAFilterData <- try( KOverAFilter(minimumValue=minimumValue,
                                      minimumElementNumber=minimumElementNumber),
                         silent=TRUE
                       )
if(is(kOverAFilterData, "try-error"))
	kOverAFilterData <- NULL
