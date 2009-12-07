annotation <- "hgu95av2"

entrezFilterData <- try(EntrezFilter(annotation=annotation), silent=TRUE)
if(is(entrezFilterData, "try-error"))
    entrezFilterData <- NULL

