urls  <- c("file:///path/infile1", "file:///path/infile2", "file:///path/infile3")
types <- rep("CEL", length(urls))

inputFileReferencesData <- try(FileReferences(urls=urls, types=types), silent=TRUE)
if(is(inputFileReferencesData, "try-error"))
    inputFileReferencesData <- NULL

