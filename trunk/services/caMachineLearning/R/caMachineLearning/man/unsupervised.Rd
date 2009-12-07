\name{unsupervised}
\alias{unsupervised}

\title{RWebServices interface to the XXX package}

\description{
  Provides access to the XXX package as an RWebService.
}

\usage{
unsupervised(oneChannelExpressionData, parameters)
}

\arguments{
  \item{oneChannelExpressionData}{ An object of class \code{OneChannelExpressionData} }
  \item{parameters}{ An object of class \code{UnsupervisedMachineLearningParameters} }
}

\value{
  An object of class \code{UnsupervisedMachineLearningResult}.
}

\author{Tom Milac <tmilac@fhcrc.org>}

% \seealso{ objects to See Also as \code{\link{help}},  }

\examples{

    # Example taken from 'Bioconductor Case Studies', Hahne et al.

    library("ALL")
    library("genefilter")
    library("caCommonClasses")
    library("hgu95av2.db")

    data("ALL")

    # Select samples B-cell samples with the "NEG" or "BCR/ABL" 
    # molecular types.

    bcell = grep("^B", as.character(ALL$BT))
    moltyp = which( match(as.character(ALL$mol.biol), c("NEG", "BCR/ABL"), nomatch=0) > 0 )
    ALL_bcrneg = ALL[,intersect(bcell, moltyp)]
    ALL_bcrneg$mol.biol = factor(ALL_bcrneg$mol.biol)

    # Select only those reporters that show sufficient variability
    # across samples.

    # FIXME: temporary work-around to remove multi-mapped probes
    library(annotate)
    clean <- mget(featureNames(ALL_bcrneg),
                  getAnnMap("ENTREZID", annotation(ALL_bcrneg)),
                  ifnotfound=NA)
    ALLfilt_bcrneg = nsFilter(ALL_bcrneg[!is.na(clean),],
                              var.cutoff=0.75)$eset

    # Reduce the data set to focus on transcription factors.

    GOTFfun = function(GOID) {
        x = hgu95av2GO2ALLPROBES[[GOID]]
        unique(x[ names(x) != "IEA"])
    }
    GOIDs = c("GO:0003700", "GO:0003702", "GO:0003709", "GO:0016563", "GO:0016564")
    TFs   = unique(unlist(lapply(GOIDs, GOTFfun)))
    inSel = match(TFs, featureNames(ALLfilt_bcrneg), nomatch=0)
    es2   = ALLfilt_bcrneg[inSel,]

    # Prepare data and parameters for the test.

    expressionMatrix         <- ExpressionMatrix( new("NumericMatrix", exprs(es2)) )
    oneChannelExpressionData <- OneChannelExpressionData( expressionMatrix )

    hierarchicalClusteringMachineLearningParameters <-
                HierarchicalClusteringMachineLearningParameters( linkage="ward",
                                                                 distanceMetric="euclidean",
                                                                 numberOfClusters=2L
                                                               )

    kMeansMachineLearningParameters <-
                KMeansMachineLearningParameters( numberOfClusters=10L,
                                                 algorithm="Forgy"
                                               )

    # Execute the test.

    hierarchicalClusteringMachineLearningResult <- unsupervised(oneChannelExpressionData, hierarchicalClusteringMachineLearningParameters)
    kMeansMachineLearningResult                 <- unsupervised(oneChannelExpressionData, kMeansMachineLearningParameters)
}

% Add one or more standard keywords, see file 'KEYWORDS' in the
% R documentation directory.
\keyword{ manip }
