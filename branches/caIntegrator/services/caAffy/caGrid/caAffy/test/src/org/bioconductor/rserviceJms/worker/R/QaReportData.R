QaReportData <- try(new("QaReport"), silent=TRUE)
if(is(QaReportData, "try-error"))
	QaReportData <- NULL
