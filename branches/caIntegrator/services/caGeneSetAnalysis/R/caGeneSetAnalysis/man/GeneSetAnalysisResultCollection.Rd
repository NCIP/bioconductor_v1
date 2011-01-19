\name{GeneSetAnalysisResultCollection}
\alias{GeneSetAnalysisResultCollection}

\title{GeneSetAnalysisResultCollection constructor and accessors}

\description{
  Functions for creating and manipulating GeneSetAnalysisResultCollection-class objects.
}

\usage{
GeneSetAnalysisResultCollection( description=character(0), geneSetId=character(0),
                                 geneSetSize=integer(0),   pValue=numeric(0),
                                 geneSetMembers=list(0) )
}

\arguments{

  \item{description}{A character vector of length one containing a
    description of the the GeneSetAnalysisResultCollection.}

  \item{geneSetId}{A character vector containing the ids of the gene
	sets.}

  \item{geneSetSize}{An integer vector containing the number of genes in
	each gene set.}

  \item{pValue}{A numeric vector containing the p-values associated with
	each gene set.}

  \item{geneSetMembers}{A list of character vectors.  Each character
    vector contains the gene ids of the genes in the corresponding gene
    set.}

}

\value{

  \item{GeneSetAnalysisResultCollection}{Object of class
    \code{\linkS4class{GeneSetAnalysisResultCollection}}.}
}

\author{Tom Milac \url{tmilac@fhcrc.org}}

\seealso{\code{\linkS4class{GeneSetAnalysisResultCollection}-class},
  \code{\link{description}}, \code{\link{geneSetId}},
  \code{\link{geneSetSize}}, \code{\link{geneSetMembers}}.}

\examples{
obj <- GeneSetAnalysisResultCollection(
                          description=character(0),  geneSetId=c("A", "B", "C"),
                          geneSetSize=c(2L, 3L, 1L), pValue=c(0.03, 0.09, 0.12),
                          geneSetMembers=list(c("a1", "a2"), c("b1", "b2", "b3"), c("c1")) )
description(obj)
geneSetId(obj)
geneSetSize(obj)
pValue(obj)
geneSetMembers(obj)
}

\keyword{manip}
