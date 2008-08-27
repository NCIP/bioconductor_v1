MzAssaysData <- tryCatch({
    env <- new.env()
    data(list="mzAssays", package="caPROcess", envir=env)
    get("mzAssays", env)
}, error=function(err) {
    conditionMessage(err)
}, warning=function(warn) {
    conditionMessage(warn)
})
