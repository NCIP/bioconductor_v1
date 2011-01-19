gc()
data(affybatch.example)
bioAssays <- new("NumericMatrix", exprs(affybatch.example))
rownames(bioAssays) <- 1:nrow(bioAssays) - 1
colnames(bioAssays) <- LETTERS[1:ncol(bioAssays)]

DerivedBioAssaysData <-
    tryCatch(new("DerivedBioAssays", bioAssays=bioAssays),
             error=function(err) NULL)
print(str(DerivedBioAssays))
