\name{camiRNATwoGroupDifferentialExpression}
\alias{camiRNATwoGroupDifferentialExpression}
\title{
  Two-group differential expresesion work flow for Agilent miRNA arrays.
}
\description{
  Input, normalize, and assess differential representation of probes on
  single-channel Agilent miRNA arrays.  This function uses the
  \pkg{limma} package, with \sQuote{normexp} background correcton adn
  \sQuote{quantile} normalization. Expression values are averaged across
  replilcates use \link{avereps}. Differential representation is
  assessed using \pkg{limma}'s moderated t-statistic, as implemented
  with \sQuote{lmFit} and \sQuote{eBayes}. Results are summarized using
  \pkg{limma}'s \sQuote{topTable} function.
}
\usage{
camiRNATwoGroupDifferentialExpression(targets)
}
\arguments{
  \item{targets}{
    A \code{\linkS4class{Targets}}-class object indicating the file
    location and associated condition of each sample.
  }
}
\value{
  A \code{\linkS4class{MicroRNATopTable}}-class object containing the
  results of the differential representation analysis.
}
\author{
  Martin Morgan \url{mtmorgan@fhcrc.org}
}

\keyword{ manip }
