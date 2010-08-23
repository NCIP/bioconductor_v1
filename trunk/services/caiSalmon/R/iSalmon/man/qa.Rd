\name{QualityReports}

\alias{miRNAArrayQualityReport}
\alias{shortReadQualityReport}

\title{Quality assessment}

\description{These functions produce an HTML report summarizing quality
  assessment of miRNA or short read samples.}

\usage{
miRNAArrayQualityReport(targets)
shortReadQualityReport(targets)
}

\arguments{

  \item{targets}{A data frame containing a single column \code{FileName}
    a character vector of the URL or other locations of agilent GPR
    files to be used.}

}

\examples{
\dontrun{
filenames = source(system.file("script","files.R",
                               package="iSalmon"))[[1]]
conds = c("A","A","B","B")
targets <- data.frame(Condition=conds,
                      FileName=filenames,
                      stringsAsFactors=FALSE)

miRNAArrayQualityReport(targets)
}
}