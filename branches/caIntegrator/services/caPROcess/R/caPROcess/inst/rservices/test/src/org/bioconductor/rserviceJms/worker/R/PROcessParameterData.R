PROcessParameterData <- tryCatch({
    new("PROcessParameter")
}, error=function(err) {
    conditionMessage(err)
}, warning=function(warn) {
    conditionMessage(warn)
})
