testCaDNAcopyData <- function() {
    data(dnacopyAssays)
    checkTrue(validObject(dnacopyAssays))
    checkTrue(nrow(slot(dnacopyAssays, "logratioValues"))==2271)
    checkTrue(ncol(slot(dnacopyAssays, "logratioValues"))==2)
}

testDNAcopyParameter <- function() {
    obj <- new("DNAcopyParameter")
    checkTrue(slot(obj, "changePointSignificanceLevel")==0.01)
    checkTrue(slot(obj, "permutationReplicates")==1000)
    checkTrue(slot(obj, "earlyStoppingCriterion")==0.05)
}

testCaDNAcopy <- function() {
    set.seed(0)
    data(dnacopyAssays)
    dnacopyParameter <- new("DNAcopyParameter")
    res <- caDNAcopy(dnacopyAssays, dnacopyParameter)
    checkTrue(length(slot(res, "sampleId"))==75)
    checkTrue(all.equal(head(slot(res, "markersPerSegment")), c(132, 64, 86, 143, 9, 13)))
    checkTrue(all.equal(tail(slot(res, "markersPerSegment")), c(8, 7, 13, 7, 9, 54)))
    checkTrue(all.equal(head(slot(res, "startMapPosition")), c(468, 0, 0, 0, 172856, 179200)))
    checkTrue(all.equal(tail(slot(res, "startMapPosition")), c(9092, 14860, 19080, 1100, 20552, 0)))
}
