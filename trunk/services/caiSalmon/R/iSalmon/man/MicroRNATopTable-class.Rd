\name{MicroRNATopTable-class}
\Rdversion{1.1}
\docType{class}
\alias{MicroRNATopTable-class}

\title{Class "MicroRNATopTable"}
\description{
  A representation of results from miRNA differential expression.
}
\section{Objects from the Class}{

  Objects can be created by calls of the form
  \code{new("MicroRNATopTable", ...)}. These objects are usually created
  by the function \code{miRNATwoGroupDifferentialExpression}.

}
\section{Slots}{
  \describe{
    \item{\code{ProbeName}:}{Object of class \code{"character"}
      identifying the probe for which the results apply.}
    \item{\code{GeneName}:}{Object of class \code{"character"} The gene
      name corresponding to the probe, as specified in the miRNA input file.}
    \item{\code{LogFoldChange}:}{Object of class \code{"character"} The
      log2-fold change in abundance between conditions.}
    \item{\code{TStatistic}:}{Object of class \code{"character"} The
      t-statistic measuring differential abundance between the two conditions.}
    \item{\code{PValue}:}{Object of class \code{"character"} The P-value
    associated with differential abundance.}
    \item{\code{AdjustedPValue}:}{Object of class \code{"character"} The
      adjusted (for false discovery rate, using Benjamini-Hochberg)
      P-value associated with differential abundance}
    \item{\code{LogOdds}:}{Object of class \code{"character"} The log
      odds (\code{B} from \code{topTable} of the \pkg{limma} package) of
      the fitted data.}
  }
}
\section{Methods}{
  No methods defined with class "MicroRNATopTable" in the signature.
}
\author{
  Martin Morgan \url{mtmorgan@fhcrc.org}
}
\examples{
showClass("MicroRNATopTable")
}
\keyword{classes}
