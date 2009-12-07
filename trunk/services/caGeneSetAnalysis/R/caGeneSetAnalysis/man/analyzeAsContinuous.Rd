\name{analyzeAsContinuous}
\alias{analyzeAsContinuous}

\title{RWebServices interface to the GSEABase package}

\description{
  Provides access to the GSEABase package as an RWebService.
}

\usage{
analyzeAsContinuous(topTable, parameters)
}

\arguments{
  \item{topTable}{ An object of class \code{TopTable} }
  \item{parameters}{ An object of class \code{GeneOntologyContinuousGeneSetAnalysisParameters},
                        \code{KEGGContinuousGeneSetAnalysisParameters} or \code{PFAMContinuousGeneSetAnalysisParameters} }
}

\value{
  An object of class \code{ContinuousGeneSetAnalysisResultCollection}.
}

\author{Tom Milac <tmilac@fhcrc.org>}

% \seealso{ objects to See Also as \code{\link{help}},  }

\examples{

    # Example taken from 'Bioconductor Case Studies', Hahne et al.

    library("ALL")
    library("genefilter")
    library("DBI")
    library("GSEABase")
    library("caCommonClasses")
    library("hgu95av2.db")

    data("ALL")

    # Select B-cell samples with the "NEG" or "BCR/ABL" molecular types.

    bcell = grep("^B", as.character(ALL$BT))
    moltyp = which( match(as.character(ALL$mol.biol), c("NEG", "BCR/ABL"), nomatch=0) > 0 )
    ALL_bcrneg = ALL[,intersect(bcell, moltyp)]
    ALL_bcrneg$mol.biol = factor(ALL_bcrneg$mol.biol)

    # Select only those reporters that show sufficient variability 
    # across samples.

    ALLfilt_bcrneg = nsFilter(ALL_bcrneg, var.cutoff=0.5)$eset

    # Execute a t-test.
    rtt = rowttests(ALLfilt_bcrneg, "mol.biol")
    rttStat = rtt$statistic

    # Create a TopTable for input to analyzeAsContinuous.

    contrastSpecification = "not relevant here"

    reporterName = as.character(row.names(rtt))
    tCoefficient = as.numeric(rtt$statistic)

    len = length(row.names(rtt))
    logFoldChange  = numeric(len)
    pValue         = numeric(len)
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

    # Define a KEGGContinuousGeneSetAnalysisParameters object.

    parameters = new("KEGGContinuousGeneSetAnalysisParameters",
                     annotation="hgu95av2",
                     minimumGenesPerGeneSet=10L
                    )

    # Execute the test.

    continuousGeneSetAnalysisResultCollection <- analyzeAsContinuous(topTable, parameters)
}

% Add one or more standard keywords, see file 'KEYWORDS' in the
% R documentation directory.
\keyword{ manip }
