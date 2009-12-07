#
# Uses package genefilter to filter a NumericMatrix according to
# a Filter, returning a NumericMatrix.
#

#
# KOverAFilter

setMethod(.caGeneFilter,
    signature(dataValues="NumericMatrix", filter="KOverAFilter"),
    function(dataValues, filter)
    {
        # Assemble the filter function.

        minimumValue         <- minimumValue(filter)
        minimumElementNumber <- minimumElementNumber(filter)
        ffun <- filterfun( kOverA(minimumElementNumber, minimumValue), allNA )

        # Find which rows pass the filter, then pick out those rows.

        which          <- genefilter( dataValues, ffun )
        filteredMatrix <- dataValues[ (1:length(which))[which],,drop=FALSE ]

        new("NumericMatrix", filteredMatrix)
    }
)

#
# VarianceFilter.  Filter out those reporters for which the variance
#    across samples is less than 'minimumVariance'.
#

setMethod(.caGeneFilter,
    signature(dataValues="NumericMatrix", filter="VarianceFilter"),
    function(dataValues, filter)
    {
        minimumVariance <- minimumVariance(filter)

        # The NumericMatrix must have 2 or more sample columns to
        # compute the variance.

        if ( length(colnames(dataValues)) < 3 )
           stop("Cannot calculate the variance for a data object with 2 or fewer columns.")

        # Create an ExpressionSet from the NumericMatrix.  Allow for 
        # duplicate rownames.

        ids <- rownames(dataValues)             # Save rownames
        rownames(dataValues) <- NULL
        eset <- new("ExpressionSet", exprs=dataValues)
        featureData(eset)[["ids"]] <- ids

        filteredEset   <-
            varFilter(eset, var.func=var, var.cutoff=minimumVariance,
                      filterByQuantile=FALSE)
        filteredMatrix <- exprs(filteredEset)

        rownames(filteredMatrix) <- fData(filteredEset)[["ids"]]   # Restore rownames

        new("NumericMatrix", filteredMatrix)
    }
)

#
# GeneOntologyFilter
#

setMethod(".caGeneFilter",
    signature(dataValues="NumericMatrix", filter="GeneOntologyFilter"),
    function(dataValues, filter)
    {
        annotation <- annotation(filter)

        # Check for and load the required annotation package if necessary.

        .requireAnnotation(annotation)

        ids <- rownames(dataValues)
        passingFilter <- TRUE

        if (isBiologicalProcess(filter)) {
            passingFilter <-
                passingFilter & .filterGO(ids, "BP", annotation)
        }

        if (isMolecularFunction(filter)) {
            passingFilter <-
                passingFilter & .filterGO(ids, "MF", annotation)
        }

        if (isCellularCompartment(filter)) {
            passingFilter <-
                passingFilter & .filterGO(ids, "CC", annotation)
        }

        filteredDataValues <- dataValues[passingFilter,,drop=FALSE]

        new("NumericMatrix", filteredDataValues)
    }
)

#
# EntrezFilter
#

setMethod(.caGeneFilter,
    signature(dataValues="NumericMatrix", filter="EntrezFilter"),
    function(dataValues, filter)
    {
        annotation <- annotation(filter)

        # Check for and load the required annotation package if necessary.

        .requireAnnotation(annotation)

        ids <- rownames(dataValues)
        passingFilter <- .requireID(ids, "ENTREZID", annotation)
        filteredDataValues <- dataValues[passingFilter,,drop=FALSE]

        new("NumericMatrix", filteredDataValues)
    }
)

#
# MissingValueFilter
#

setMethod(.caGeneFilter,
    signature(dataValues="NumericMatrix", filter="MissingValueFilter"),
    function(dataValues, filter)
    {
        missingValue         <- missingValue(filter)
        minimumElementNumber <- minimumElementNumber(filter)

        # Check.

        if (minimumElementNumber < 0L || minimumElementNumber > ncol(dataValues))
            stop("The 'minimumElementNumber' must be greater than or equal to 0 and less than or equal to the number of observations in 'dataValues'.")

        # To accommodate use of 'minimumElementNumber' instead of 'maximumNumberMissingValues'
        # in the API.

        maximumNumberMissingValues <- ncol(dataValues) - minimumElementNumber

        # missingValue can be NA or a specific double value.

        if (is.na(missingValue)) {
            numberOfMissingValues =
                apply(dataValues, 1, function(x) sum(is.na(x)))
        } else {
            numberOfMissingValues =
                apply(dataValues, 1, function(x) sum(x == missingValue))
        }

        # Select those rows for which the number of missing values is
        # less than or equal to the specified maximumNumberMissingValues.

        keepRows       <- numberOfMissingValues <= maximumNumberMissingValues;
        filteredMatrix <- dataValues[keepRows,];

        new("NumericMatrix", filteredMatrix)
    }
)

caGeneFilter <- function(dataValues, filter) {
    .caGeneFilter(dataValues, filter) 
}

typeInfo(caGeneFilter) <-
  SimultaneousTypeSpecification(
    TypedSignature(dataValues = "NumericMatrix",
                   filter     = "Filter"),
    returnType = "NumericMatrix")

#
# Uses package genefilter to recode a NumericMatrix according to
# a Recode, returning a NumericMatrix.
#

setMethod(.caGeneRecode,
    signature(dataValues="NumericMatrix",
              recode="MinimumThresholdRecode"),
    function(dataValues, recode)
    {
        minimumThreshold <- minimumThreshold(recode)
        recodeValue      <- recodeValue(recode)

        recodedMatrix <- apply(dataValues, c(1,2), ".applyMinimumThreshold",
                                 minimumThreshold=minimumThreshold,
                                 recodeValue=recodeValue)
        new("NumericMatrix", recodedMatrix)
    }
)

setMethod(.caGeneRecode,
    signature(dataValues="NumericMatrix",
              recode="MaximumThresholdRecode"),
    function(dataValues, recode)
    {
        maximumThreshold <- maximumThreshold(recode)
        recodeValue      <- recodeValue(recode)

        recodedMatrix <- apply(dataValues, c(1,2), ".applyMaximumThreshold",
                                 maximumThreshold=maximumThreshold,
                                 recodeValue=recodeValue)
        new("NumericMatrix", recodedMatrix)
    }
)

caGeneRecode <- function(dataValues, recode) {
    .caGeneRecode(dataValues, recode) 
}

typeInfo(caGeneRecode) <-
  SimultaneousTypeSpecification(
    TypedSignature(dataValues = "NumericMatrix",
                   recode     = "Recode"),
    returnType = "NumericMatrix")

#
# Uses package genefilter to recode a collection of manufacturer
# files according to a Recode, returning a NumericMatrix.
#

setMethod(.caFileGeneRecode,
    signature(fileReferences="FileReferences",
              recode="SpotQualityRecode"),
    function(fileReferences, recode)
    {
        # Copy the data to analyze to a local directory.

        toDir <- tempfile()
        dir.create(toDir, recursive=TRUE)

        toUrls <- file.path(toDir, localNames(fileReferences))
        localFileReferences <-
            retrieve(from=fileReferences, to=FileReferences(toUrls))

        on.exit({
        file.remove(toUrls)
        file.remove(toDir)
        })

        # Retrieve the type of the data files to analyze.

        type <- unique(tolower(types(fileReferences)))
        if (length(type) != 1L)
            stop("fileReferences 'types' must all be identical")

        if (type == "gpr") {
            source <- "genepix.median"
            probeIdColumn <- "ID"
        } else if (type == "agilent") {
            source <- "agilent"
            probeIdColumn <- "ProbeName"
        } else
            stop("FileReferences 'types' (", type, ") is unknown")

        # Retrieve the parameter values.

        columnIdentifier <- columnIdentifier(recode)
        columnMinimumThresholdValue <- columnMinimumThresholdValue(recode)
        recodeValue <- recodeValue(recode)

        # Read the manufacturer files. Specify that 'column' be read as
        # an 'other.column'.

        rgList <- read.maimages( files=urls(localFileReferences),
                                 other.column=columnIdentifier,
                                 source=source )

        # Recode the elements of the R and G matrices as directed by the
        # values in testMatrix and the columnMinimumThresholdValue.

        testMatrix <- rgList$other[[1]]   # Matrix containing data from 'columnIdentifier'.

        RminusRb <- rgList$R - rgList$Rb
        GminusGb <- rgList$G - rgList$Gb

        RminusRb[ testMatrix < columnMinimumThresholdValue ] <- recodeValue
        GminusGb[ testMatrix < columnMinimumThresholdValue ] <- recodeValue

        # Assign dimension names.  Convert missing values to "<NA>".

        dim1names <- rgList$genes[[probeIdColumn]]
        dim1names[ is.na(dim1names) ] <- "<NA>"

        dim2names <- localNames(fileReferences)

        dimnames(RminusRb) <- dimnames(GminusGb) <- list( dim1names, dim2names )

        # Return.

        list(new("NumericMatrix", RminusRb), new("NumericMatrix", GminusGb))
    }
)

caFileGeneRecode <- function(fileReferences, recode) {
    .caFileGeneRecode(fileReferences, recode)
}

typeInfo(caFileGeneRecode) <-
  SimultaneousTypeSpecification(
    TypedSignature(fileReferences = "FileReferences",
                   recode         = "Recode"),
    returnType = "list")

#
# Utility methods
#

.applyMinimumThreshold <- function(x, minimumThreshold, recodeValue) {
    if (x < minimumThreshold) recodeValue else x
}

.applyMaximumThreshold <- function(x, maximumThreshold, recodeValue) {
    if (x > maximumThreshold) recodeValue else x
}

# Check for and load the specified annotation package if necessary.
#
.requireAnnotation <- function(annotation) {
    if (require(annotate::annPkgName(annotation),
                character.only=TRUE) != TRUE) {
        tryCatch({
            source('http://bioconductor.org/biocLite.R')
            biocLite(annotate::annPkgName(annotation))
            if (require(annotate::annPkgName(annotation),
                        character.only=TRUE) != TRUE)
               stop("unknown annotation:", annotation)
        }, error=function(err) {
            stop("could not access annotation:", annotation,
                 "\n  reason:", conditionMessage(err))
        })
    }
}

.getAnnEnv <- function(map, annotation) {
    getAnnMap(map=map, chip=annotation)
}

.requireID <- function(reporterNames, map, annotation) {
    IDs <- mget(reporterNames, envir=.getAnnEnv(map, annotation))
    nms <- names(IDs)[!sapply(IDs, is.na)]
    reporterNames %in% nms
}

.filterGO <- function(reporterNames, ontology, annotation) {
    sapply(mget(reporterNames, .getAnnEnv("GO", annotation)),
           function(x) {
               if (length(x) == 1 && is.na(x))
                   FALSE
               else {
                   onts <- subListExtract(x, "Ontology", simplify = TRUE)
                   ontology %in% onts
               }
           })
}
