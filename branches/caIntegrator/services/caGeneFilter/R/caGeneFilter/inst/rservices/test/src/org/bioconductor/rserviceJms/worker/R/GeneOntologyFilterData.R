annotation            <- "hgu95av2"
isBiologicalProcess   <- TRUE
isCellularCompartment <- TRUE
isMolecularFunction   <- TRUE

geneOntologyFilterData <- try(GeneOntologyFilter(annotation=annotation,
                                                 isBiologicalProcess=isBiologicalProcess,
                                                 isCellularCompartment=isCellularCompartment,
                                                 isMolecularFunction=isMolecularFunction),
                              silent=TRUE)
if(is(geneOntologyFilterData, "try-error"))
    geneOntologyFilterData <- NULL
