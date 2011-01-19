\name{SangerMiRNAGenerateESet}

\alias{SangerMiRNAGenerateESet}
\alias{SangerMRNAGenerateESet}

\title{Expression Set Generator for Sanger Sequencing data}

\description{These helper functions create expression sets used for microRNA
  and mRNA expression data.}

\usage{
SangerMiRNAGenerateESet()
SangerMRNAGenerateESet()
}


\value{An ExpressionSet object generated from Sanger data sources.}

\examples{
\dontrun{
miRNA_eset = SangerMiRNAGenerateESet()
mRNA_eset = SangerMRNAGenerateESet()
}
}

