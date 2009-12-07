\name{DiscreteGeneSetAnalysisResultCollection-class}
\docType{class}
\alias{DiscreteGeneSetAnalysisResultCollection-class}

\title{Class "DiscreteGeneSetAnalysisResultCollection"}
\description{
  DiscreteGeneSetAnalysisResultCollection returns the results of 'discrete'
  gene set enrichment analyses, i.e., analyses using methods supplied by the
  'Category' package.
}
\section{Objects from the Class}{

  Objects can be created by calls to the constructor
  \code{\link{DiscreteGeneSetAnalysisResultCollection}}.

  Elements can be accessed with \code{\link{description}}, \code{\link{geneSetId}},
  \code{\link{geneSetSize}}, \code{\link{pValue}}, \code{\link{geneSetMembers}},
  \code{\link{selectedCount}}, and \code{\link{expectedCount}}.

}
\section{Slots}{
  \describe{

    \item{\code{description}:}{Object of class \code{"character"} containing a
        description of the the DiscreteGeneSetAnalysisResultCollection.}

    \item{\code{geneSetId}:}{Object of class \code{"character"} containing the
        gene set IDs.}

    \item{\code{geneSetSize}:}{Object of class \code{"integer"} containing
        the sizes of the gene sets.}

    \item{\code{pValue}:}{Object of class \code{"numeric"} containing the
        p-value computed for each gene set.}

    \item{\code{geneSetMembers}:}{Object of class \code{"list"} each element of
        which is an object of class \code{"character"} which contains the gene IDs
        associated with the corresponding gene set.}

    \item{\code{selectedCount}:}{Object of class \code{"integer"} containing the
          number of genes that are annotated at each category term.}

    \item{\code{expectedCount}:}{Object of class \code{"integer"} containing the
          expected number of genes to be found at each category term.}

  }
}
\section{Methods}{

  See \code{\link{DiscreteGeneSetAnalysisResultCollection}}

}

\author{Tom Milac \url{tmilac@fhcrc.org}}

\seealso{

  \code{\link{DiscreteGeneSetAnalysisResultCollection}} for object construction, accessors
  \code{\link{description}}, \code{\link{geneSetId}}, \code{\link{geneSetSize}},
          \code{\link{pValue}}, \code{\link{ontology}}, \code{\link{expectedCount}},
          and \code{\link{selectedCount}}

}

\examples{
showClass("DiscreteGeneSetAnalysisResultCollection")
DiscreteGeneSetAnalysisResultCollection()
}
\keyword{classes}
