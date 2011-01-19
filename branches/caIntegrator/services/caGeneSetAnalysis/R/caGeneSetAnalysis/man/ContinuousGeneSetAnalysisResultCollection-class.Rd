\name{ContinuousGeneSetAnalysisResultCollection-class}
\docType{class}
\alias{ContinuousGeneSetAnalysisResultCollection-class}

\title{Class "ContinuousGeneSetAnalysisResultCollection"}
\description{
  ContinuousGeneSetAnalysisResultCollection returns the results of 'continuous'
  gene set enrichment analyses, i.e., analyses using methods supplied by the
  'GSEABase' package.
}
\section{Objects from the Class}{

  Objects can be created by calls to the constructor
  \code{\link{ContinuousGeneSetAnalysisResultCollection}}.

  Elements can be accessed with \code{\link{description}}, \code{\link{geneSetId}},
  \code{\link{geneSetSize}}, \code{\link{pValue}}, \code{\link{geneSetMembers}},
  and \code{\link{adjustedTStatistic}}.

}
\section{Slots}{
  \describe{

    \item{\code{description}:}{Object of class \code{"character"} containing a
        description of the the ContinuousGeneSetAnalysisResultCollection.}

    \item{\code{geneSetId}:}{Object of class \code{"character"} containing the
        gene set IDs.}

    \item{\code{geneSetSize}:}{Object of class \code{"integer"} containing
        the sizes of the gene sets.}

    \item{\code{pValue}:}{Object of class \code{"numeric"} containing the
        p-value computed for each gene set.}

    \item{\code{geneSetMembers}:}{Object of class \code{"list"} each element of
        which is an object of class \code{"character"} which contains the gene IDs
        associated with the corresponding gene set.}

    \item{\code{adjustedTStatistic}:}{Object of class \code{"numeric"} containing the
          adjusted t-statistic computed for each gene set.}

  }
}
\section{Methods}{

  See \code{\link{ContinuousGeneSetAnalysisResultCollection}}

}

\author{Tom Milac \url{tmilac@fhcrc.org}}

\seealso{

  \code{\link{ContinuousGeneSetAnalysisResultCollection}} for object construction, accessors
  \code{\link{description}}, \code{\link{geneSetId}}, \code{\link{geneSetSize}},
          \code{\link{pValue}}, \code{\link{ontology}}, and \code{\link{adjustedTStatistic}}

}

\examples{
showClass("ContinuousGeneSetAnalysisResultCollection")
ContinuousGeneSetAnalysisResultCollection()
}
\keyword{classes}
