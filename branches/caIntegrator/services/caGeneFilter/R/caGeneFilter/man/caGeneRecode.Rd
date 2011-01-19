\name{caGeneRecode}
\alias{caGeneRecode}

\title{RWebServices interface to the genefilter package}

\description{
  Provides access to the genefilter package as an RWebService.
}

\usage{
caGeneRecode(dataValues, recode)
}

\arguments{
  \item{dataValues}{ An object of class \code{NumericMatrix} }
  \item{recode}{ An object of class \code{MinimumThresholdRecode} or \code{MaximumThresholdRecode} }
}

\value{
  An object of class \code{NumericMatrix} which includes those
  rows of the input \code{NumericMatrix} that satisfy the recode.
}

\author{Tom Milac <tmilac@fhcrc.org>}

% \seealso{ objects to See Also as \code{\link{help}},  }

\examples{
   library(Biobase)

   # Sample data
   data(sample.ExpressionSet)
   
   # Extract expression values from the ExpressionSet
   # and convert these to a NumericMatrix.
   expressionMatrix <- exprs(sample.ExpressionSet)
   dataValues       <- new("NumericMatrix", expressionMatrix)

   # Apply a MinimumThresholdRecode to the expression values.
   minimumThresholdRecode <- MinimumThresholdRecode(minimumThreshold=-8000.0)
   minimumThresholdedData <- caGeneRecode(dataValues, minimumThresholdRecode)

   # Apply a MaximumThresholdRecode to the expression values.
   maximumThresholdRecode <- MaximumThresholdRecode(maximumThreshold=10000.0)
   maximumThresholdedData <- caGeneRecode(dataValues, maximumThresholdRecode)
}

% Add one or more standard keywords, see file 'KEYWORDS' in the
% R documentation directory.
\keyword{ manip }
