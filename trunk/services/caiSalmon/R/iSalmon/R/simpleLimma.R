miRNATwoGroupDifferentialExpression <-
    function(targets)
{
    if (!all(c("FileName", "Condition") %in% names(targets)))
        stop("'targets' must contain columns 'FileName', 'Condition'")

    ## basic work flow -- read files, background correct, normalize
    ## within arraygs, fit a simple design, 'empirical Bayes' to make
    ## estimates more robust, output 'topTable' with p.values adjusted
    ## for false discovery.
    rg <- read.maimages(targets, source="agilent",
                        columns=list(G="gMeanSignal", Gb="gBGMedianSignal"),
                        annotation=c("ControlType", "ProbeName", "GeneName"),
                        green.only=TRUE)
    rg1 <- backgroundCorrect(rg, method="normexp")
    ma <- normalizeBetweenArrays(rg1, method="quantile")
    dimnames(ma) <-
        list(rg$genes$ProbeName,
             sub("\\?file.*", "", basename(targets[["FileName"]])))
    ma <- ma[ma$gene$ControlType==0,]
    m.avg <- avereps(ma, ID=ma$gene$ProbeName)
    if (2 != length(unique(targets$Condition)))
        stop("'Condition' must contain exactly two levels")
    f <- factor(targets$Condition, levels=unique(targets$Condition))
    fit <- lmFit(m.avg, model.matrix(~f)) # two-group comparison
    efit <- eBayes(fit)
    genes0 <- with(rg$genes,
                   rg$genes[!duplicated(ProbeName),
                            !names(rg$genes) %in% "ControlType"])
    efit[["genes"]] <-
        genes0[match(efit[["genes"]][["ProbeName"]], genes0[["ProbeName"]]),]
    ## FIXME: group means; experiment summary; names labkey compatible
    topTable(efit, coef=2, adjust = "fdr", number=nrow(efit))
}

## CaGrid representation
camiRNATwoGroupDifferentialExpression <-
    function(targets)
{
    df <- data.frame(FileName=slot(targets, "FileName"),
                     Condition=slot(targets, "Condition"),
                     stringsAsFactors=FALSE)
    res <- miRNATwoGroupDifferentialExpression(df)
    with(res, 
         new("MicroRNATopTable",
             ProbeName=ProbeName,
             GeneName=GeneName,
             LogFoldChange=logFC,
             TStatistic=t,
             PValue=P.Value,
             AdjustedPValue=adj.P.Val,
             LogOdds=B))
}

setClass("Targets",
         representation=representation(
           FileName="character",
           Condition="character"))

setValidity("Targets", function(object) {
    msg <- NULL
    if (length(slot(object, "FileName")) !=
        length(slot(object, "Condition")))
        msg <- c(msg,
                 sprintf("'%s' and '%s' must have same length()",
                         "FileName", "Condition"))
    if (is.null(msg)) TRUE else msg
})

setClass("MicroRNATopTable",
         representation=representation(
           ProbeName="character",
           GeneName="character",
           LogFoldChange="numeric",
           TStatistic="numeric",
           PValue="numeric",
           AdjustedPValue="numeric",
           LogOdds="numeric"))

typeInfo(camiRNATwoGroupDifferentialExpression) <-
    SimultaneousTypeSpecification(
       TypedSignature(targets="Targets"),
       returnType="MicroRNATopTable")










## This one is special because extra filtering was required along with
## different column names.
TCGAmiRNATwoGroupDifferentialExpression <-
    function(targets)
{
  ## TODO: write a test case that calls this little monster and make sure it works.
  ## targets <- readTargets("MUTaa_WILD_rem_mod_target_file")
  ## the targets are the same files that are found in:
  ## http://isalmon.fhcrc.org/labkey/list/home/SharedData/grid.view?listId=54
  
  if (!all(c("FileName", "Condition") %in% names(targets)))
    stop("'targets' must contain columns 'FileName', 'Condition'")
  
  ## this is single channel, R and Rb are not relevent)
  RG <- read.maimages(targets,
                      columns = list(G="gTotalGeneSignal", Gb="gProcessedSignal"),
                      annotation = c("FeatureNum","ControlType","ProbeName","GeneName"),
                      other.columns = list(gIsGeneDetected = "gIsGeneDetected"),
                      green.only=TRUE)
  RG.sel <- RG[!duplicated(RG$genes$GeneName),]
  RG.sel$E <- RG.sel$E + 23
  ma <- normalizeBetweenArrays(RG.sel, method="quantile")
  dimnames(ma) <- list(RG.sel$genes$ProbeName, sub("\\?file.*", "", basename(as.character(targets[["FileName"]]))))
  ma <- ma[ma$gene$ControlType==0,]
  miRs <- c(grep("hsa-miR-",ma$genes$GeneName),grep("hsa-let-",ma$genes$GeneName))
  ma <-ma[miRs, ]
  sum <- apply(ma$other$gIsGeneDetected,1,sum) > 1
  ma <- ma[sum,]
  mean <- apply(ma$E,1,mean) > 4
  ma <- ma[mean,]
  f <- factor(targets$Condition,levels = sort(unique(targets$Condition)))
  design <- model.matrix(~0+f)
  mut <-colnames(design)[1]
  wild <-colnames(design)[2]
  matString<-c(paste(mut,"-",wild,sep=""),paste(wild,"-",mut, sep=""))
  contrast.matrix <- makeContrasts(contrasts = matString, levels=design)
  fit <- lmFit(ma, design) # two-group comparison
  fit <- contrasts.fit(fit, contrast.matrix)
  efit <- eBayes(fit)
  genes0 <- with(RG.sel$genes,
                 RG.sel$genes[,
                              !names(RG.sel$genes) %in% "ControlType"])
  efit[["genes"]] <-
    genes0[match(efit[["genes"]][["ProbeName"]], genes0[["ProbeName"]]),]
  n <- nrow(efit)
  topTable(efit, adjust = "fdr",number = n)
}
