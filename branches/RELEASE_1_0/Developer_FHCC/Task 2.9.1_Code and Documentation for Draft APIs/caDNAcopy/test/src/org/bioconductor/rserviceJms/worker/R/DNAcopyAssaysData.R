DNAcopyAssaysData <- tryCatch({
    env <- new.env()
    data(list="dnacopyAssays", package="caDNAcopy", envir=env)
    res <- get("dnacopyAssays", env)
    env$dnacopyAssays@logratioValues[is.na(env$dnacopyAssays@logratioValues)] <- 0
    env$dnacopyAssays
}, error=function(err) {
    conditionMessage(err)
}, warning=function(warn) {
    conditionMessage(warn)
})
