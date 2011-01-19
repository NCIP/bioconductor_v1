\name{accessors}
\alias{annotation}
\alias{minimumElementNumber}
\alias{recodeValue}

\title{Accessor functions shared across several classes}

\description{
  Functions for accessing contents of class instances.
}

\usage{
annotation(object, ...)
minimumElementNumber(object, ...)
recodeValue(object, ...)
}

\arguments{

  \item{object}{An object from which an annotation
    (\linkS4class{AnnotationFilter}, \linkS4class{EntrezFilter},
    \linkS4class{GeneOntologyFilter}), minimumElementNumber
    (\linkS4class{KOverAFilter}, \linkS4class{MissingValueFilter}), or
    recodeValue (\linkS4class{MaximumThresholdRecode},
    \linkS4class{MinimumThresholdRecode}, \linkS4class{Recode},
    \linkS4class{SpotQualityRecode}) are to be extracted.}

  \item{\dots}{Additional arguments, (currently) ignored.}

}

\value{

  \item{annotation}{length one character vector containing the
	annotation.}

  \item{minimumElementNumber}{length one integer vector containing the
	minimum element number.}

  \item{recodeValue}{length one numeric vector containing the recode
	value.}

}

\author{Tom Milac \url{tmilac@fhcrc.org}}

\seealso{\code{\linkS4class{AnnotationFilter}-class}}

\examples{
obj <- AnnotationFilter(annotation="hgu95av2")
annotation(obj)
}

\keyword{manip}
