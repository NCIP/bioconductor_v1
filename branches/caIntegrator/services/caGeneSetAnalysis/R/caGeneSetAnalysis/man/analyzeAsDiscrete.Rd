\name{analyzeAsDiscrete}
\alias{analyzeAsDiscrete}

\title{RWebServices interface to the Category package}

\description{
  Provides access to the Category package as an RWebService.
}

\usage{
analyzeAsDiscrete(topTable, parameters)
}

\arguments{
  \item{topTable}{ An object of class \code{TopTable} }
  \item{parameters}{ An object of class \code{GeneOntologyDiscreteGeneSetAnalysisParameters},
                        \code{KEGGDiscreteGeneSetAnalysisParameters} or \code{PFAMDiscreteGeneSetAnalysisParameters} }
}

\value{
  An object of class \code{DiscreteGeneSetAnalysisResultCollection}.
}

\author{Tom Milac <tmilac@fhcrc.org>}

% \seealso{ objects to See Also as \code{\link{help}},  }

\examples{

    # Example taken from 'Bioconductor Case Studies', Hahne et al.

    library("ALL")
    library("annotate")
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

    # Select only those reporters that show sufficient variability across 
    # samples.  Also, require that the probes have an EntrezGene ID and an
    # annotation in the GO BP ontology.  Finally, filter out probes beginning
    # with the string "AFFX".

    ALLfilt_bcrneg = nsFilter(ALL_bcrneg, require.entrez=TRUE,
                              require.GOBP=TRUE, remove.dupEntrez=TRUE,
                              var.func=IQR, var.cutoff=0.5,
                              feature.exclude="^AFFX")$eset

    # Execute a t-test.

    rtt = rowttests(ALLfilt_bcrneg, "mol.biol", tstatOnly=FALSE)

    # Create a TopTable for input to analyzeAsDiscrete.

    contrastSpecification = "not relevant here"

    reporterName = as.character(row.names(rtt))   # affy probe id
    pValue       = rtt$p.value
    
    len = length(row.names(rtt))    # these TopTable data not needed for this analysis
    tCoefficient   = numeric(len)
    logFoldChange  = numeric(len)
    adjustedPValue = numeric(len)
    logOddsScore   = numeric(len)

    topTable = new("TopTable",
                   contrastSpecification=contrastSpecification,
                   reporterName=reporterName,
                   logFoldChange=logFoldChange,
                   tCoefficient=tCoefficient,
                   pValue=pValue,
                   adjustedPValue=adjustedPValue,
                   logOddsScore=logOddsScore)

    # Define a KEGGDiscreteGeneSetAnalysisParameters object.

    parameters = new("KEGGDiscreteGeneSetAnalysisParameters",
                      annotation="hgu95av2",
                      discretePValue=0.05,
                      testDirection="over-represented"
                    )

    # Execute the test.

    discreteGeneSetAnalysisResultCollection <- analyzeAsDiscrete(topTable, parameters)
}

% Add one or more standard keywords, see file 'KEYWORDS' in the
% R documentation directory.
\keyword{ manip }
