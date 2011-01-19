\name{accessors}
\alias{annotation}
\alias{description}
\alias{discretePValue}
\alias{geneSetId}
\alias{geneSetMembers}
\alias{geneSetSize}
\alias{minimumGenesPerGeneSet}
\alias{ontology}
\alias{pValue}
\alias{testDirection}

\title{Accessor functions shared across several classes}

\description{
  Functions for accessing contents of class instances.
}

\usage{
annotation(object, ...)
description(object, ...)
discretePValue(object, ...)
geneSetId(object, ...)
geneSetMembers(object, ...)
geneSetSize(object, ...)
minimumGenesPerGeneSet(object, ...)
ontology(object, ...)
pValue(object, ...)
testDirection(object, ...)
}

\arguments{

  \item{object}{An object from an appropriate class, as follows:

	annotation:
	\linkS4class{ContinuousGeneSetAnalysisParameters}
	\linkS4class{DiscreteGeneSetAnalysisParameters}
	\linkS4class{GeneOntologyContinuousGeneSetAnalysisParameters}
	\linkS4class{GeneOntologyDiscreteGeneSetAnalysisParameters}
	\linkS4class{GeneSetAnalysisParameters}
	\linkS4class{KEGGContinuousGeneSetAnalysisParameters}
	\linkS4class{KEGGDiscreteGeneSetAnalysisParameters}
	\linkS4class{PFAMContinuousGeneSetAnalysisParameters}
	\linkS4class{PFAMDiscreteGeneSetAnalysisParameters}

	description:
	\linkS4class{ContinuousGeneSetAnalysisResultCollection}
	\linkS4class{DiscreteGeneSetAnalysisResultCollection}
	\linkS4class{GeneSetAnalysisResultCollection}

	discretePValue:
	\linkS4class{DiscreteGeneSetAnalysisParameters}
	\linkS4class{GeneOntologyDiscreteGeneSetAnalysisParameters}
	\linkS4class{KEGGDiscreteGeneSetAnalysisParameters}
	\linkS4class{PFAMDiscreteGeneSetAnalysisParameters}

	geneSetId:
	\linkS4class{ContinuousGeneSetAnalysisResultCollection}
	\linkS4class{DiscreteGeneSetAnalysisResultCollection}
	\linkS4class{GeneSetAnalysisResultCollection}

	geneSetMembers:
	\linkS4class{ContinuousGeneSetAnalysisResultCollection}
	\linkS4class{DiscreteGeneSetAnalysisResultCollection}
	\linkS4class{GeneSetAnalysisResultCollection}

	geneSetSize:
	\linkS4class{ContinuousGeneSetAnalysisResultCollection}
	\linkS4class{DiscreteGeneSetAnalysisResultCollection}
	\linkS4class{GeneSetAnalysisResultCollection}

	minimumGenesPerGeneSet:
	\linkS4class{ContinuousGeneSetAnalysisParameters}
	\linkS4class{GeneOntologyContinuousGeneSetAnalysisParameters}
	\linkS4class{KEGGContinuousGeneSetAnalysisParameters}
	\linkS4class{PFAMContinuousGeneSetAnalysisParameters}

	ontology:
	\linkS4class{GeneOntologyContinuousGeneSetAnalysisParameters}
	\linkS4class{GeneOntologyDiscreteGeneSetAnalysisParameters}
	\linkS4class{PFAMContinuousGeneSetAnalysisParameters}

	pValue:
	\linkS4class{ContinuousGeneSetAnalysisResultCollection}
	\linkS4class{DiscreteGeneSetAnalysisResultCollection}
	\linkS4class{GeneSetAnalysisResultCollection}

	testDirection:
	\linkS4class{DiscreteGeneSetAnalysisParameters}
	\linkS4class{GeneOntologyDiscreteGeneSetAnalysisParameters}
	\linkS4class{KEGGDiscreteGeneSetAnalysisParameters}
    \linkS4class{PFAMDiscreteGeneSetAnalysisParameters}
	
  }

  \item{\dots}{Additional arguments, (currently) ignored.}

}

\value{

  \item{annotation}{length one character vector containing the
	annotation.}

  \item{description}{character vector of length one containing a
	description of the GeneSetAnalysisResultCollection.}

  \item{discretePValue}{length one numeric vector containing a threshold
	p-value.}

  \item{geneSetId}{character vector containing the ids of the gene sets.}

  \item{geneSetMembers}{list of character vectors each of which contains
	the ids of genes in the corresponding gene set.}

  \item{geneSetSize}{integer vector containing the sizes of the gene sets.}

  \item{minimumGenesPerGeneSet}{length one numeric vector containing the
	required minimum size of a gene set.}

  \item{ontology}{length one character vectors containing the
	annotation, test direction and ontology.}

  \item{pValue}{numeric vector containing the p-values associated with
	the gene sets.}

  \item{testDirection}{length one character vectors containing the
	annotation, test direction and ontology.}

}

\author{Tom Milac \url{tmilac@fhcrc.org}}

\keyword{manip}
