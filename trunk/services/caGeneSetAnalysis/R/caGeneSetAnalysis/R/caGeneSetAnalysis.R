#
# GeneOntologyDiscreteGeneSetAnalysisParameters
#

setMethod(.analyzeAsDiscrete,
    signature(topTable   = "TopTable",
              parameters = "GeneOntologyDiscreteGeneSetAnalysisParameters"),
    function(topTable, parameters)
    {
        # Unpack data.

        annotation     <- annotation(parameters)
        discretePValue <- discretePValue(parameters)
        testDirection  <- testDirection(parameters)
        ontology       <- ontology(parameters)

        # Check.

        if ( !(ontology == "BP" || ontology == "CC" || ontology == "MF") )
                stop("The 'ontology' must be one of 'BP', 'CC' or 'MF'.")

        if ( !(testDirection == "over-represented"  ||
               testDirection == "under-represented"    ) )
            stop("The 'testDirection' must be one of 'over-represented' or 'under-represented'.")

        if (testDirection == "over-represented")  direction <- "over"
        if (testDirection == "under-represented") direction <- "under"

        # Check for and load the required annotation package if necessary.

        .requireAnnotation(annotation)

        # The universe is all of the reporter names in the TopTable.
        # The selected reporter names are those for which the pValue
        # reported in the TopTable is less than the threshold discretePValue
        # input with the DiscreteParameters.

        universe = reporterName(topTable)
        selected = reporterName(topTable)[ pValue(topTable) <= discretePValue ]

        # The universe and selected reporter ids are Affy ids.  Map these
        # to ENTREZ ids.

        map <- getAnnMap("ENTREZID", annotation)

        universeENTREZIds <- unlist( mget(universe, map, ifnotfound=NA), use.names=FALSE )
        universeENTREZIds <- unique( universeENTREZIds[!is.na(universeENTREZIds)] )

        selectedMap <- mget(selected, map, ifnotfound=NA)

        selectedENTREZIds <- unlist( selectedMap, use.names=FALSE )
        selectedENTREZIds <- unique( selectedENTREZIds[!is.na(selectedENTREZIds)] )

        # Prepare parameters object for analysis.

        params = new("GOHyperGParams",
                     geneIds=selectedENTREZIds,
                     universeGeneIds=universeENTREZIds,
                     annotation=annotation,
                     ontology=ontology,
                     pvalueCutoff=1.0,            # return all results
                     conditional=FALSE,
                     testDirection=direction
                    )

        # Execute the test.

        res <- hyperGTest(params)   # returns instance of HyperGResult-class in the Category package

        # Map ENTREZ IDs back to reporter names.

        rselectedMap   <- revmap(selectedMap)
        geneSetMembers <- lapply(geneIdsByCategory(res), function(i, x) unique(unlist(x[i], use.names=FALSE)), x=rselectedMap)

        # Construct DiscreteGeneSet to return.

        discreteGeneSetAnalysisResultCollection <- DiscreteGeneSetAnalysisResultCollection(
                                selectedCount=as.integer( geneCounts(res) ),
                                expectedCount=as.integer( expectedCounts(res) ),
                                description="GeneOntologyDiscrete",
                                geneSetId=names( pvalues(res) ),
                                geneSetSize=as.integer(lapply(geneSetMembers, length)),
                                pValue=pvalues(res),
                                geneSetMembers=geneSetMembers
                           )

        # Return.

        discreteGeneSetAnalysisResultCollection
    }
)

#
# KEGGDiscreteGeneSetAnalysisParameters
#

setMethod(.analyzeAsDiscrete,
    signature(topTable   = "TopTable",
              parameters = "KEGGDiscreteGeneSetAnalysisParameters"),
    function(topTable, parameters)
    {
        # Unpack data.

        annotation     <- annotation(parameters)
        discretePValue <- discretePValue(parameters)
        testDirection  <- testDirection(parameters)

        # Check.

        if ( !(testDirection == "over-represented"  ||
               testDirection == "under-represented" ||
               testDirection == "over-or-under-represented" ) )
            stop("The 'testDirection' must be one of 'over-represented' or 'under-represented'.")

        if (testDirection == "over-represented")  direction <- "over"
        if (testDirection == "under-represented") direction <- "under"

        # Check for and load the required annotation package if necessary.

        .requireAnnotation(annotation)

        # The universe is all of the reporter names in the TopTable.
        # The selected reporter names are those for which the pValue
        # reported in the TopTable is less than the threshold discretePValue
        # input with the DiscreteParameters.

        universe = reporterName(topTable)
        selected = reporterName(topTable)[ pValue(topTable) <= discretePValue ]

        # The universe and selected reporter ids are Affy ids.  Map these
        # to ENTREZ ids.

        map <- getAnnMap("ENTREZID", annotation)

        universeENTREZIds <- unlist( mget(universe, map, ifnotfound=NA), use.names=FALSE )
        universeENTREZIds <- unique( universeENTREZIds[!is.na(universeENTREZIds)] )

        selectedMap <- mget(selected, map, ifnotfound=NA)

        selectedENTREZIds <- unlist( selectedMap, use.names=FALSE )
        selectedENTREZIds <- unique( selectedENTREZIds[!is.na(selectedENTREZIds)] )

        # Prepare parameters object for analysis.

        params = new("KEGGHyperGParams",
                     geneIds=selectedENTREZIds,
                     universeGeneIds=universeENTREZIds,
                     annotation=annotation,
                     pvalueCutoff=1.0,              # return all results
                     testDirection=direction
                    )

        # Execute the test.

        res <- hyperGTest(params)   # returns instance of HyperGResult-class in the Category package

        # Map ENTREZ IDs back to reporter names.

        rselectedMap   <- revmap(selectedMap)
        geneSetMembers <- lapply(geneIdsByCategory(res), function(i, x) unique(unlist(x[i], use.names=FALSE)), x=rselectedMap)

        # Construct DiscreteGeneSet to return.

        discreteGeneSetAnalysisResultCollection <- DiscreteGeneSetAnalysisResultCollection(
                               selectedCount=as.integer( geneCounts(res) ),
                               expectedCount=as.integer( expectedCounts(res) ),
                               description="KEGGDiscrete",
                               geneSetId=names( pvalues(res) ),
                               geneSetSize=as.integer(lapply(geneSetMembers, length)),
                               pValue=pvalues(res),
                               geneSetMembers=geneSetMembers
                           )

        # Return.

        discreteGeneSetAnalysisResultCollection
    }
)

#
# PFAMDiscreteGeneSetAnalysisParameters
#

setMethod(.analyzeAsDiscrete,
    signature(topTable   = "TopTable",
              parameters = "PFAMDiscreteGeneSetAnalysisParameters"),
    function(topTable, parameters)
    {
        # Unpack data.

        annotation     <- annotation(parameters)
        discretePValue <- discretePValue(parameters)
        testDirection  <- testDirection(parameters)

        # Check.

        if ( !(testDirection == "over-represented"  ||
               testDirection == "under-represented" ||
               testDirection == "over-or-under-represented" ) )
            stop("The 'testDirection' must be one of 'over-represented' or 'under-represented'.")

        if (testDirection == "over-represented")  direction <- "over"
        if (testDirection == "under-represented") direction <- "under"

        # Check for and load the required annotation package if necessary.

        .requireAnnotation(annotation)

        # The universe is all of the reporter names in the TopTable.
        # The selected reporter names are those for which the pValue
        # reported in the TopTable is less than the threshold discretePValue
        # input with the DiscreteParameters.

        universe = reporterName(topTable)
        selected = reporterName(topTable)[ pValue(topTable) <= discretePValue ]

        # The universe and selected reporter ids are Affy ids.  Map these
        # to ENTREZ ids.

        map <- getAnnMap("ENTREZID", annotation)

        universeENTREZIds <- unlist( mget(universe, map, ifnotfound=NA), use.names=FALSE )
        universeENTREZIds <- unique( universeENTREZIds[!is.na(universeENTREZIds)] )

        selectedMap <- mget(selected, map, ifnotfound=NA)

        selectedENTREZIds <- unlist( selectedMap, use.names=FALSE )
        selectedENTREZIds <- unique( selectedENTREZIds[!is.na(selectedENTREZIds)] )

        # Prepare parameters object for analysis.

        params = new("PFAMHyperGParams",
                     geneIds=selectedENTREZIds,
                     universeGeneIds=universeENTREZIds,
                     annotation=annotation,
                     pvalueCutoff=1.0,            # return all results
                     testDirection=direction
                    )

        # Execute the test.

        res <- hyperGTest(params)   # returns instance of HyperGResult-class in the Category package


        # Map ENTREZ IDs back to reporter names.

        rselectedMap   <- revmap(selectedMap)
        geneSetMembers <- lapply(geneIdsByCategory(res), function(i, x) unique(unlist(x[i], use.names=FALSE)), x=rselectedMap)

        # Construct DiscreteGeneSet to return.

        discreteGeneSetAnalysisResultCollection <- DiscreteGeneSetAnalysisResultCollection(
                               selectedCount=as.integer( geneCounts(res) ),
                               expectedCount=as.integer( expectedCounts(res) ),
                               description="PFAMDiscrete",
                               geneSetId=names( pvalues(res) ),
                               geneSetSize=as.integer(lapply(geneSetMembers, length)),
                               pValue=pvalues(res),
                               geneSetMembers=geneSetMembers
                           )

        # Return.

        discreteGeneSetAnalysisResultCollection
    }
)

#
# GeneOntologyContinuousGeneSetAnalysisParameters
#

setMethod(.analyzeAsContinuous,
    signature(topTable   = "TopTable",
              parameters = "GeneOntologyContinuousGeneSetAnalysisParameters"),
    function(topTable, parameters)
    {
        # Unpack data.

        annotation             <- annotation(parameters)
        minimumGenesPerGeneSet <- minimumGenesPerGeneSet(parameters)
        ontology               <- ontology(parameters)

        reporterName <- reporterName(topTable)
        tCoefficient <- tCoefficient(topTable)

        # Check for and load the required annotation package if necessary.

        .requireAnnotation(annotation)

        # Map reporterNames to GO sets via annotation.

        map <- getAnnMap(map="GO", chip=annotation, load=TRUE)
        tbl <- toTable( map[reporterName] )
        lst <- with(tbl[tbl[["Ontology"]] == ontology,],
                    split(probe_id, go_id))
        lst <- lst[ sapply(lst, is.character) ]      # filter out NAs
        lst <- lapply(lst, unique)  # remove duplicate probe ids
        lst <- lst[ sapply(lst, length) >= minimumGenesPerGeneSet ]
        gsc <- GeneSetCollection(mapply(function(geneId, id) {
                    GeneSet(geneId, geneIdType=AnnotationIdentifier(annotation),
                        collectionType=GOCollection(id, ontology=ontology),
                        setName=id)
               }, lst, names(lst)))

        if (length(gsc) == 0)
            stop("No GeneSets were found with greater than 'minimumGenesPerGeneSet' genes.")

        # Build the incidence matrix.  Select only those tCoefficients for
        # genes that remain as column names of the incidence matrix.

        Am <- incidence(gsc)
        tCoefficient <- tCoefficient[ match( reporterName, colnames(Am), nomatch=0 ) ]

        # Execute the test.  For a GeneSet of size n, sum(tstat)/sqrt(n)
        # is approximately normally distributed with mean 0 and variance 1.

        tA    <- as.vector(Am %*% tCoefficient)
        tAadj <- tA/sqrt(rowSums(Am))
        names(tA) <- names(tAadj) <- rownames(Am)

        pValue <- pnorm( abs(tAadj), lower.tail=FALSE )

        geneSetMembers        <- lapply(gsc, geneIds)
        names(geneSetMembers) <- names(gsc)

        continuousGeneSetAnalysisResultCollection <- ContinuousGeneSetAnalysisResultCollection(
                                  adjustedTStatistic=tAadj,
                                  description="GeneOntologyContinuous",
                                  geneSetId=names(tAadj),
                                  geneSetSize=as.integer( rowSums(Am) ),
                                  pValue=pValue,
                                  geneSetMembers=geneSetMembers
                             )

        # Return.

        continuousGeneSetAnalysisResultCollection
    }
)

#
# KEGGContinuousGeneSetAnalysisParameters
#

setMethod(.analyzeAsContinuous,
    signature(topTable   = "TopTable",
              parameters = "KEGGContinuousGeneSetAnalysisParameters"),
    function(topTable, parameters)
    {
        # Unpack data.

        annotation             <- annotation(parameters)
        minimumGenesPerGeneSet <- minimumGenesPerGeneSet(parameters)

        reporterName <- reporterName(topTable)
        tCoefficient <- tCoefficient(topTable)

        # Check for and load the required annotation package if necessary.

        .requireAnnotation(annotation)

        # Map reporterNames to KEGG sets via annotation.

        map <- getAnnMap(map="PATH", chip=annotation, load=TRUE)

        lst <- reverseSplit(as.list( map[reporterName] ))
        lst <- lst[ sapply(lst, is.character) ] # filter out NAs
        lst <- lapply(lst, unique)      # remove duplicate probe ids
        lst <- lst[ sapply( lst, length ) >= minimumGenesPerGeneSet ]
        gsc <- GeneSetCollection(mapply(function(geneId, id) {
                    GeneSet(geneId, geneIdType=AnnotationIdentifier(annotation),
                        collectionType=KEGGCollection(id),
                        setName=id)
               }, lst, names(lst)))

        # Filter out GeneSets with fewer than minimumGenesPerGeneSet genes.

        if (length(gsc) == 0) 
            stop("No GeneSets were found with greater than 'minimumGenesPerGeneSet' genes.")

        # Build the incidence matrix.  Select only those tCoefficients for
        # genes that remain as column names of the incidence matrix.

        Am <- incidence(gsc)
        tCoefficient <- tCoefficient[ match( reporterName, colnames(Am), nomatch=0 ) ]


        # Execute the test.  For a GeneSet of size n, sum(tstat)/sqrt(n)
        # is approximately normally distributed with mean 0 and variance 1.

        tA    <- as.vector(Am %*% tCoefficient)
        tAadj <- tA/sqrt(rowSums(Am))
        names(tA) <- names(tAadj) <- rownames(Am)

        pValue <- pnorm( abs(tAadj), lower.tail=FALSE )

        geneSetMembers        <- lapply(gsc, geneIds)
        names(geneSetMembers) <- names(gsc)

        continuousGeneSetAnalysisResultCollection <- ContinuousGeneSetAnalysisResultCollection(
                                  adjustedTStatistic=tAadj,
                                  description="KEGGContinuous",
                                  geneSetId=names(tAadj),
                                  geneSetSize=as.integer( rowSums(Am) ),
                                  pValue=pValue,
                                  geneSetMembers=geneSetMembers
                             )

        # Return.

        continuousGeneSetAnalysisResultCollection
    }
)

#
# PFAMContinuousGeneSetAnalysisParameters
#

setMethod(.analyzeAsContinuous,
    signature(topTable   = "TopTable",
              parameters = "PFAMContinuousGeneSetAnalysisParameters"),
    function(topTable, parameters)
    {
        # Unpack data.

        annotation             <- annotation(parameters)
        minimumGenesPerGeneSet <- minimumGenesPerGeneSet(parameters)

        reporterName <- reporterName(topTable)
        tCoefficient <- tCoefficient(topTable)

        # Check for and load the required annotation package if necessary.

        .requireAnnotation(annotation)

        # Map reporterNames to PFAM sets via annotation.

        map <- getAnnMap(map="PFAM", annotation)[reporterName]

        lst <- reverseSplit(eapply(map, as.vector))
        lst <- lst[ sapply(lst, is.character) ]      # filter out NAs
        lst <- lapply(lst, unique)      # remove duplicate probe ids
        lst <- lst[ sapply( lst, length ) >= minimumGenesPerGeneSet ]
        gsc <- GeneSetCollection(mapply(function(geneId, id) {
                    GeneSet(geneId, geneIdType=AnnotationIdentifier(annotation),
                        collectionType=PfamCollection(id),
                        setName=id)
               }, lst, names(lst)))

        if (length(gsc) == 0)
            stop("No GeneSets were found with greater than 'minimumGenesPerGeneSet' genes.")

        # Build the incidence matrix.  Select only those tCoefficients for
        # genes that remain as column names of the incidence matrix.

        Am <- incidence(gsc)
        tCoefficient <- tCoefficient[ match( reporterName, colnames(Am), nomatch=0 ) ]

        # Execute the test.  For a GeneSet of size n, sum(tstat)/sqrt(n)
        # is approximately normally distributed with mean 0 and variance 1.

        tA    <- as.vector(Am %*% tCoefficient)
        tAadj <- tA/sqrt(rowSums(Am))
        names(tA) <- names(tAadj) <- rownames(Am)

        pValue <- pnorm( abs(tAadj), lower.tail=FALSE )

        geneSetMembers        <- lapply(gsc, geneIds)
        names(geneSetMembers) <- names(gsc)

        continuousGeneSetAnalysisResultCollection <- ContinuousGeneSetAnalysisResultCollection(
                                 adjustedTStatistic=tAadj,
                                 description="PFAMContinuous",
                                 geneSetId=names(tAadj),
                                 geneSetSize=as.integer( rowSums(Am) ),
                                 pValue=pValue,
                                 geneSetMembers=geneSetMembers
                             )

        # Return.

        continuousGeneSetAnalysisResultCollection
    }
)

#
# analyzeAsDiscrete.
#

analyzeAsDiscrete <- function(topTable, parameters) {
    .analyzeAsDiscrete(topTable, parameters)
}

typeInfo(analyzeAsDiscrete) <-
  SimultaneousTypeSpecification(
    TypedSignature(topTable   = "TopTable",
                   parameters = "DiscreteGeneSetAnalysisParameters"),
    returnType = "DiscreteGeneSetAnalysisResultCollection")

#
# analyzeAsContinuous.
#

analyzeAsContinuous <- function(topTable, parameters) {
    .analyzeAsContinuous(topTable, parameters)
}

typeInfo(analyzeAsContinuous) <-
  SimultaneousTypeSpecification(
    TypedSignature(topTable   = "TopTable",
                   parameters = "ContinuousGeneSetAnalysisParameters"),
    returnType = "ContinuousGeneSetAnalysisResultCollection")

#
# Check for and load the specified annotation package if necessary.
#
.requireAnnotation <- function(annotation) {
    if (require(annotate::annPkgName(annotation), character.only=TRUE) != TRUE) {
        tryCatch({
            source('http://bioconductor.org/biocLite.R')
            biocLite(annotate::annPkgName(annotation))
            if (require(annotate::annPkgName(annotation), character.only=TRUE) != TRUE)
               stop("unknown annotation:", annotation)
        }, error=function(err) {
            stop("could not access annotation:", annotation,
                 "\n  reason:", conditionMessage(err))
        })
    }
}