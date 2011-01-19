\name{caGeneFilter}
\alias{caGeneFilter}

\title{RWebServices interface to the genefilter package}

\description{
  Provides access to the genefilter package as an RWebService.
}

\usage{
caGeneFilter(dataValues, filter)
}

\arguments{
  \item{dataValues}{ An object of class \code{NumericMatrix} }
  \item{filter}{ An object of class \code{KOverAFilter}, \code{VarianceFilter},
                 \code{GeneOntologyFilter}, \code{EntrezFilter} or \code{MissingValueFilter} }
}

\value{
  An object of class \code{NumericMatrix} which includes those
  rows of the input \code{NumericMatrix} that satisfy the filter.
}

\author{Tom Milac <tmilac@fhcrc.org>}

% \seealso{ objects to See Also as \code{\link{help}},  }

\examples{
   library(Biobase)
   library(annotate)

   # Sample data.

   data(sample.ExpressionSet)
   
   # Extract expression values from the ExpressionSet
   # and convert these to a NumericMatrix.

   expressionMatrix <- exprs(sample.ExpressionSet)
   dataValues       <- new("NumericMatrix", expressionMatrix)

   # Instantiate a KOverAFilter that requires that 5 samples or
   # more exceed a value of 200.0. Apply the KOverAFilter to the
   # expression values.

   kOverAFilter <- KOverAFilter(minimumValue=200.0, minimumElementNumber=5L)
   kOverAFilteredData <- caGeneFilter(dataValues, kOverAFilter)

   # Apply the VarianceFilter to the expression values.

   varianceFilter       <- VarianceFilter(minimumVariance=100.0)
   varianceFilteredData <- caGeneFilter(dataValues, varianceFilter)

   # Apply the GeneOntologyFilter to the expression values.

   geneOntologyFilter <- GeneOntologyFilter(annotation=annotation(sample.ExpressionSet),
                                            isBiologicalProcess=TRUE,
                                            isCellularCompartment=TRUE,
                                            isMolecularFunction=TRUE)
   geneOntologyFilteredData <- caGeneFilter(dataValues, geneOntologyFilter)

   # Apply the EntrezFilter to the expression values.

   entrezFilter       <- EntrezFilter(annotation=annotation(sample.ExpressionSet))
   entrezFilteredData <- caGeneFilter(dataValues, entrezFilter)

   # Apply the MissingValueFilter to expression values that include
   # missing data, coded here by -Inf.

   dataWithMissingValues         <- dataValues;
   dataWithMissingValues[500,26] <- -Inf;
   missingValueFilter <- MissingValueFilter(missingValue=-Inf,
                                            minimumElementNumber=ncol(dataValues))
   missingValueFilteredData <- caGeneFilter(dataWithMissingValues, missingValueFilter)
}

% Add one or more standard keywords, see file 'KEYWORDS' in the
% R documentation directory.
\keyword{ manip }
