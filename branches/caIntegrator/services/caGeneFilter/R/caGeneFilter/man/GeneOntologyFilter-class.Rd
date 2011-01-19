\name{GeneOntologyFilter-class}
\docType{class}
\alias{GeneOntologyFilter-class}

\title{Class "GeneOntologyFilter"}
\description{
  GeneOntologyFilter encapsulates the parameters needed to run a gene filter analysis
  which returns genes annotated at one or more of the ontologies 'cellular compartment',
  'biological process' or 'molecular function'.
}
\section{Objects from the Class}{

  Objects can be created by calls to the constructor
  \code{\link{GeneOntologyFilter}}.

  Elements can be accessed with \code{\link{annotation}}, \code{\link{isBiologicalProcess}},
  \code{\link{isCellularCompartment}} and \code{\link{isMolecularFunction}}.

}
\section{Slots}{
  \describe{

    \item{\code{annotation}:}{Object of class \code{"character"} containing the
        name of an annotation package.}

    \item{\code{isBiologicalProcess}:}{Object of class \code{"logical"} indicating
        whether genes annotated as being associated with a biological process 
        should be returned.}

    \item{\code{isCellularCompartment}:}{Object of class \code{"logical"} indicating
        whether genes annotated as being associated with a cellular compartment
        should be returned.}

    \item{\code{isMolecularFunction}:}{Object of class \code{"logical"} indicating
        whether genes annotated as being associated with a molecular function
        should be returned.}

  }
}
\section{Methods}{

  See \code{\link{GeneOntologyFilter}}

}

\author{Tom Milac \url{tmilac@fhcrc.org}}

\seealso{

  \code{\link{GeneOntologyFilter}} for object construction, accessors
  \code{\link{annotation}}
  \code{\link{isBiologicalProcess}}
  \code{\link{isCellularCompartment}}
  \code{\link{isMolecularFunction}}

}

\examples{
showClass("GeneOntologyFilter")
obj <- GeneOntologyFilter(annotation=character(0), isBiologicalProcess=TRUE, isCellularCompartment=FALSE, isMolecularFunction=TRUE)
annotation(obj)
isBiologicalProcess(obj)
isCellularCompartment(obj)
isMolecularFunction(obj)
}
\keyword{classes}
