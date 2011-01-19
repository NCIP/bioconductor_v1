QaReportData <- try(new("QaReport", pdfFile=raw(1000)), silent=TRUE)
if(is(QaReportData, "try-error"))
	QaReportData <- NULL
