urls  <- "file:///path/outfile"
types <- "ZIP"

outputFileReferencesData <- try(FileReferences(urls=urls, types=types), silent=TRUE)
if(is(outputFileReferencesData, "try-error"))
    outputFileReferencesData <- NULL
