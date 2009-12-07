\name{EntrezFilter-class}
\docType{class}
\alias{EntrezFilter-class}

\title{Class "EntrezFilter"}
\description{
  EntrezFilter encapsulates the parameters needed to run a gene filter analysis
  which returns genes annotated with an Entrez identifier.
}
\section{Objects from the Class}{

  Objects can be created by calls to the constructor
  \code{\link{EntrezFilter}}.

  Elements can be accessed with \code{\link{annotation}}.

}
\section{Slots}{
  \describe{

    \item{\code{annotation}:}{Object of class \code{"character"} containing the
        name of an annotation package.}

  }
}
\section{Methods}{

  See \code{\link{EntrezFilter}}

}

\author{Tom Milac \url{tmilac@fhcrc.org}}

\seealso{

  \code{\link{EntrezFilter}} for object construction, accessors
  \code{\link{annotation}}

}

\examples{
showClass("EntrezFilter")
EntrezFilter()
}
\keyword{classes}
