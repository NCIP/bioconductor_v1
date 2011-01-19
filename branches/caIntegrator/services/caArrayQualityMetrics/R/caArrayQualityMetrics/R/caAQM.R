#
# Uses arrayQualityMetrics to process CEL (Affymetrix), GPR (Genepix)
# and Agilent data files referenced by 'inputFileReference'.  Returns
# the path to the .zip file encapsulating the output of arrayQualityMetrics.
#

caArrayQualityMetrics <- function(inputFileReferences)
{

    filenames <- basename(urls(inputFileReferences))
    if (length(filenames) == 1)
        stop("more than one file required")

    ## Branch on the file type.
    type <- unique(types(inputFileReferences))
    if (length(type) != 1L)
        stop("all files must be the same 'type'")

    ## Copy the input files to a temporary directory naming each
    ## according to its local name.

    toDir <- tempfile()
    dir.create(toDir, recursive=TRUE)

    toUrls <- file.path(toDir, localNames(inputFileReferences))
    localFileReferences <-
        retrieve(from=inputFileReferences, to=FileReferences(toUrls))

    on.exit({
      file.remove(toUrls)
      file.remove(toDir)
    })

    fun <-
        switch(toupper(type),
               CEL=.caArrayQualityMetricsCEL,
               GPR=.caArrayQualityMetricsGPR,
               AGILENT=.caArrayQualityMetricsAGILENT,
               stop("'", type, "' is an unknown type"))

    zipFile <- .createZip(fun(localFileReferences))
    FileReferences(urls=zipFile, localNames=basename(zipFile),
                   types="ZIP")
}

typeInfo(caArrayQualityMetrics) <-
  SimultaneousTypeSpecification(
    TypedSignature(inputFileReferences = "FileReferences"),
    returnType = "FileReferences")

#
# Process Affymetrix (.CEL) data files.
#

.caArrayQualityMetricsCEL <- function(localFileReferences)
{
    affybatch <- ReadAffy(filenames=urls(localFileReferences))
    outdir <- tempfile()
    arrayQualityMetrics(affybatch, outdir=outdir, do.logtransform=TRUE)
    outdir
}

#
# Process Genepix (.GPR) data files.
#

.caArrayQualityMetricsGPR <- function(localFileReferences)
{
    ## setup
    targets <- data.frame(FileName = urls(localFileReferences))
    names <- removeExt(basename(urls(localFileReferences)))
    outdir <- tempfile()

    ## read and process
    RG <- read.maimages(targets, source="genepix", names=names)
    RG <- backgroundCorrect(RG, method="normexp", offset=50)
    arrayQualityMetrics(RG, outdir=outdir, do.logtransform=TRUE)
    outdir
}

#
# Process Agilent (.txt) data files.
#

.caArrayQualityMetricsAGILENT <- function(localFileReferences)
{

    ## setup
    targets <- data.frame(FileName = urls(localFileReferences))
    names <- removeExt(basename(urls(localFileReferences)))
    outdir <- tempfile()

    ## read and process
    RG <- read.maimages(targets, source="agilent", names=names)
    RG <- backgroundCorrect(RG, method="normexp", offset=50)
    arrayQualityMetrics(RG, outdir=outdir, do.logtransform=TRUE)
    outdir
}

#
# Utility methods
#

# Zips the contents of directory 'outdir' to a file
# in tempdir().  Returns the file name of the zip file.

.createZip <- function(outdir)
{
    zipfile = paste(tempfile(), ".zip", sep="")
    system(paste("zip -r", zipfile, outdir))
    zipfile
}
