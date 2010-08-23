.returnHtmlDirectory <- function(outputDirectory){
  ## for now just save the output in the wd.
  outputDirectory
}

miRNAArrayQualityReport <-
    function(targets)
{
    if (!all(c("FileName") %in% names(targets)))
        stop("'targets' must contain column 'Condition'")
    if(nrow(targets) != length(unique(targets[["FileName"]])))
        warning("some samples selected more than once")
    ## basic work flow -- read files, background correct, normalize
    ## within arraygs, fit a simple design, 'empirical Bayes' to make
    ## estimates more robust, output 'topTable' with p.values adjusted
    ## for false discovery.
    rg <- read.maimages(targets[["FileName"]], source="agilent",
                        columns=list(G="gMeanSignal", Gb="gBGMedianSignal"),
                        annotation=c("ControlType", "ProbeName", "GeneName"),
                        green.only=TRUE)
    ## rg has to be made to an MAList! (EListRaw is not supported)
    maList <- new("MAList", list(targets=rg$targets, genes=rg$genes,
                                 source=rg$source, M=rg$Gb, A=rg$G))
    ## But apparently, this is not enough to get around the problem
    arrayQualityMetrics(maList)
#    outputDirectory <- arrayQualityMetrics(rg, tempfile())
#    .returnHtmlDirectory(outputDirectory)
}

shortReadQualityReport <- function(targets)
{
    if (!all(c("FileName") %in% names(targets)))
        stop("'targets' must contain column 'Condition'")
    if(nrow(targets) != length(unique(targets[["FileName"]])))
        warning("some samples selected more than once")
    outputDirectory <-
        report(qa(targets[["FileName"]], type="fastq"))
    .returnHtmlDirectory(outputDirectory)
}



