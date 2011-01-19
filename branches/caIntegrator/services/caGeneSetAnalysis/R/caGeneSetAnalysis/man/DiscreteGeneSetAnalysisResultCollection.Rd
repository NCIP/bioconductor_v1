\name{DiscreteGeneSetAnalysisResultCollection}
\alias{DiscreteGeneSetAnalysisResultCollection}
\alias{selectedCount}
\alias{expectedCount}

\title{DiscreteGeneSetAnalysisResultCollection constructor and accessors}

\description{
  Functions for creating and manipulating DiscreteGeneSetAnalysisResultCollection-class objects.
}

\usage{
DiscreteGeneSetAnalysisResultCollection(
            description=character(0), geneSetId=character(0),
            geneSetSize=integer(0),   pValue=numeric(0),
            geneSetMembers=list(0),
            selectedCount=integer(0), expectedCount=integer(0) )
selectedCount(object, ...)
expectedCount(object, ...)
}

\arguments{

  \item{description}{A character vector of length one containing a description
                     of the the DiscreteGeneSetAnalysisResultCollection.}

  \item{geneSetId}{A character vector containing the ids of the gene sets.}

  \item{geneSetSize}{An integer vector containing the number of genes in each gene set.}

  \item{pValue}{A numeric vector containing the p-values associated with each gene set.}

  \item{geneSetMembers}{A list of character vectors.  Each character vector contains the
            gene ids of the genes in the corresponding gene set.}

  \item{selectedCount}{An integer vector containing the number of genes that
            are annotated at each category term.}

  \item{expectedCount}{An integer vector containing the expected number of
            genes to be found at each category term.}

  \item{object}{An object of class \code{DiscreteGeneSetAnalysisResultCollection}, from which
    a description, geneSetId, geneSetSize, pValue or geneSetMembers are to be extracted.}

  \item{\dots}{Additional arguments, passed to the class initialization
    method or (currently) ignored by the accessors.}

}

\value{

  \item{DiscreteGeneSetAnalysisResultCollection}{Object of class
    \code{\linkS4class{DiscreteGeneSetAnalysisResultCollection}}.}

  \item{description}{character vector of length one containing a
	description of the DiscreteGeneSetAnalysisResultCollection.}

  \item{selectedCount, expectedCount}{integer vectors containing the
    sizes of the gene sets, the selected counts, and the expected
    counts.}

}

\author{Tom Milac \url{tmilac@fhcrc.org}}

\seealso{\code{\linkS4class{DiscreteGeneSetAnalysisResultCollection}-class},
  \code{\link{description}}, \code{\link{geneSetId}},
  \code{\link{geneSetSize}}, \code{\link{geneSetMembers}},
  \code{\link{pValue}}.}

\examples{

obj <- DiscreteGeneSetAnalysisResultCollection(
         description=character(0),  geneSetId=c("A", "B", "C"),
         geneSetSize=c(2L, 3L, 1L), pValue=c(0.03, 0.09, 0.12),
         geneSetMembers=list(c("a1", "a2"), c("b1", "b2", "b3"), c("c1")),
         selectedCount=c(1L, 2L, 1L), expectedCount=c(2L, 2L, 1L) )
description(obj)
geneSetId(obj)
geneSetSize(obj)
pValue(obj)
geneSetMembers(obj)
}

\keyword{manip}
