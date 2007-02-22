QualityControlStatisticsData <- try(new("QualityControlStatistics"), silent=TRUE)
if(is(QualityControlStatisticsData, "try-error"))
	QualityControlStatisticsData <- NULL
