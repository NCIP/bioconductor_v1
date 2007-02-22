MzSpectrumData <- try(new("MzSpectrum"), silent=TRUE)
if(is(MzSpectrumData, "try-error"))
	MzSpectrumData <- NULL
