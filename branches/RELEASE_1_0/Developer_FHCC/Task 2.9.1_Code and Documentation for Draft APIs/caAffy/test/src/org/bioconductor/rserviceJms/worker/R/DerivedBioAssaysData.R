data(affybatch.example)
bioAssays <- new("NumericMatrix", exprs(affybatch.example))
rownames(bioAssays) <- 1:nrow(bioAssays) - 1
colnames(bioAssays) <- LETTERS[1:ncol(bioAssays)]

DerivedBioAssaysData <- try(new("DerivedBioAssays", bioAssays=bioAssays),
                            silent=TRUE)
if(is(DerivedBioAssaysData, "try-error"))
	DerivedBioAssaysData <- NULL
