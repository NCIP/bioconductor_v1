\name{GeneSetAnalysisResultCollection-class}
\docType{class}
\alias{GeneSetAnalysisResultCollection-class}

\title{Class "GeneSetAnalysisResultCollection"}
\description{
  GeneSetAnalysisResultCollection is the base class for those classes used to
  return the results of a gene set enrichment analysis.
}
\section{Objects from the Class}{

  Objects can be created by calls to the constructor
  \code{\link{GeneSetAnalysisResultCollection}}.

  Elements can be accessed with \code{\link{description}}, \code{\link{geneSetId}},
  \code{\link{geneSetSize}}, \code{\link{pValue}}, and \code{\link{geneSetMembers}}.

}
\section{Slots}{
  \describe{

    \item{\code{description}:}{Object of class \code{"character"} containing a
        description of the the GeneSetAnalysisResultCollection.}

    \item{\code{geneSetId}:}{Object of class \code{"character"} containing the
        gene set IDs.}

    \item{\code{geneSetSize}:}{Object of class \code{"integer"} containing
        the sizes of the gene sets.}

    \item{\code{pValue}:}{Object of class \code{"numeric"} containing the
        p-value associated with each gene set ID.}

    \item{\code{geneSetMembers}:}{Object of class \code{"list"} each element of
        which is an object of class \code{"character"} which contains the gene IDs
        associated with the corresponding gene set.}

  }
}
\section{Methods}{

  See \code{\link{GeneSetAnalysisResultCollection}}

}

\author{Tom Milac \url{tmilac@fhcrc.org}}

\seealso{

  \code{\link{GeneSetAnalysisResultCollection}} for object construction, accessors
  \code{\link{description}}, \code{\link{geneSetId}}, \code{\link{geneSetSize}}.
                             \code{\link{pValue}},    \code{\link{ontology}}

}

\examples{
showClass("GeneSetAnalysisResultCollection")
GeneSetAnalysisResultCollection()
}
\keyword{classes}
