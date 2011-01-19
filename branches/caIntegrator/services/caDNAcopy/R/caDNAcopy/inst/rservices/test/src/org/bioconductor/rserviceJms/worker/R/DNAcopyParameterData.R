DNAcopyParameterData <- tryCatch({
    new("DNAcopyParameter", randomNumberSeed=as.integer(123))
}, error=function(err) {
    conditionMessage(err)
}, warning=function(warn) {
    conditionMessage(warn)
})
