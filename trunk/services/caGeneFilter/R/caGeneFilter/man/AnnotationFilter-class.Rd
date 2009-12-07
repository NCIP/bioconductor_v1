\name{AnnotationFilter-class}
\docType{class}
\alias{AnnotationFilter-class}

\title{Class "AnnotationFilter"}
\description{
  AnnotationFilter is the base class for all classes which encapsulate
  the parameters needed to run a gene filter analysis which requires
  an annotation.
}
\section{Objects from the Class}{

  Objects can be created by calls to the constructor
  \code{\link{AnnotationFilter}}.

  Elements can be accessed with \code{\link{annotation}}.

}
\section{Slots}{
  \describe{

    \item{\code{annotation}:}{Object of class \code{"character"} containing the
        name of an annotation package.}

  }
}
\section{Methods}{

  See \code{\link{AnnotationFilter}}

}

\author{Tom Milac \url{tmilac@fhcrc.org}}

\seealso{

  \code{\link{AnnotationFilter}} for object construction, accessors
  \code{\link{annotation}}

}

\examples{
showClass("AnnotationFilter")
AnnotationFilter()
}
\keyword{classes}
