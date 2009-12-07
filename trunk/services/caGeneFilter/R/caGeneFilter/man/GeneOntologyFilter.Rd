\name{GeneOntologyFilter}
\alias{GeneOntologyFilter}
\alias{isBiologicalProcess}
\alias{isCellularCompartment}
\alias{isMolecularFunction}

\title{GeneOntologyFilter constructor and accessors}

\description{
  Functions for creating and manipulating GeneOntologyFilter-class objects.
}

\usage{
GeneOntologyFilter(annotation=character(0), isBiologicalProcess=FALSE, isCellularCompartment=FALSE, isMolecularFunction=FALSE)
isBiologicalProcess(object, ...)
isCellularCompartment(object, ...)
isMolecularFunction(object, ...)
}

\arguments{

  \item{annotation}{A character vector of length one specifying an annotation package.}

  \item{isBiologicalProcess}{A logical vector of length one specifying whether
    genes annotated as being part of a biological process should be returned.}

  \item{isCellularCompartment}{A logical vector of length one specifying whether
    genes annotated as being part of a cellular compartment should be returned.}

  \item{isMolecularFunction}{A logical vector of length one specifying whether
    genes annotated as having a molecular function should be returned.}

  \item{object}{An object of class \code{GeneOntologyFilter}, from which
    isBiologicalProcess, isCellularCompartment or isMolecularFunction are to be extracted.}

  \item{\dots}{Additional arguments, passed to the class initialization
    method or (currently) ignored by the accessors.}

}

\value{

  \item{GeneOntologyFilter}{Object of class
    \code{\linkS4class{GeneOntologyFilter}}.}

  \item{isBiologicalProcess}{length one numeric vector containing the value of isBiologicalProcess.}

  \item{isCellularCompartment}{length one integer vector containing the value of isCellularCompartment.}

  \item{isMolecularFunction}{length one integer vector containing the value of isMolecularFunction.}

}

\author{Tom Milac \url{tmilac@fhcrc.org}}

\seealso{\code{\linkS4class{GeneOntologyFilter}-class},
  \code{\link{annotation}}}

\examples{
obj <- GeneOntologyFilter(annotation="hgu95av2", isBiologicalProcess=TRUE, isCellularCompartment=FALSE, isMolecularFunction=TRUE)
annotation(obj)
isBiologicalProcess(obj)
isCellularCompartment(obj)
isMolecularFunction(obj)
}

\keyword{manip}
