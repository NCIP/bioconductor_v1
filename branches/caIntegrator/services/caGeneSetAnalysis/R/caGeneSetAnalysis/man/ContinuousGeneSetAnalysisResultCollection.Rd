\name{ContinuousGeneSetAnalysisResultCollection}
\alias{ContinuousGeneSetAnalysisResultCollection}
\alias{adjustedTStatistic}

\title{ContinuousGeneSetAnalysisResultCollection constructor and accessors}

\description{
  Functions for creating and manipulating ContinuousGeneSetAnalysisResultCollection-class objects.
}

\usage{
ContinuousGeneSetAnalysisResultCollection(
            description=character(0), geneSetId=character(0),
            geneSetSize=integer(0),   pValue=numeric(0),
            geneSetMembers=list(0),   adjustedTStatistic=numeric(0) )
adjustedTStatistic(object, ...)
}

\arguments{

  \item{description}{A character vector of length one containing a description
                     of the the ContinuousGeneSetAnalysisResultCollection.}

  \item{geneSetId}{A character vector containing the ids of the gene sets.}

  \item{geneSetSize}{An integer vector containing the number of genes in each gene set.}

  \item{pValue}{A numeric vector containing the p-value computed for each gene set.}

  \item{geneSetMembers}{A list of character vectors.  Each character vector contains the
            gene ids of the genes in the corresponding gene set.}

  \item{adjustedTStatistic}{A numeric vector containing the t-statistic computed
            for each gene set.}

  \item{object}{An object of class \code{ContinuousGeneSetAnalysisResultCollection}, from which
    a description, geneSetId, geneSetSize, pValue or geneSetMembers are to be extracted.}

  \item{\dots}{Additional arguments, passed to the class initialization
    method or (currently) ignored by the accessors.}

}

\value{

  \item{ContinuousGeneSetAnalysisResultCollection}{Object of class
    \code{\linkS4class{ContinuousGeneSetAnalysisResultCollection}}.}

  \item{adjustedTStatistic}{numeric vector containing the t-statistic
    computed for each gene set.}

}

\author{Tom Milac \url{tmilac@fhcrc.org}}

\seealso{\code{\linkS4class{ContinuousGeneSetAnalysisResultCollection}-class},
  \code{\link{description}}, \code{\link{geneSetId}},
  \code{\link{geneSetSize}}, \code{\link{geneSetMembers}},
  \code{\link{pValue}}.}

\examples{
obj <- ContinuousGeneSetAnalysisResultCollection(
          description=character(0),  geneSetId=c("A", "B", "C"),
          geneSetSize=c(2L, 3L, 1L), pValue=c(0.03, 0.09, 0.12),
          geneSetMembers=list(c("a1", "a2"), c("b1", "b2", "b3"),
                              c("c1")),
          adjustedTStatistic=c(0.3, 0.4, 0.5) )
description(obj)
geneSetId(obj)
geneSetSize(obj)
pValue(obj)
geneSetMembers(obj)
adjustedTStatistic(obj)
}

\keyword{manip}
