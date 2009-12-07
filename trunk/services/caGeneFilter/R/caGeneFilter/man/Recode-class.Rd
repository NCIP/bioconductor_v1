\name{Recode-class}
\docType{class}
\alias{Recode-class}

\title{Class "Recode"}
\description{
  Recode is the base class for all classes which encapsulate
  the parameters needed to run a gene recode analysis.
}
\section{Objects from the Class}{

  Objects can be created by calls to the constructor
  \code{\link{Recode}}.

  Elements can be accessed with \code{\link{recodeValue}}.

}
\section{Slots}{
  \describe{

    \item{\code{recodeValue}:}{Object of class \code{"numeric"} containing the
        value to which to recode data points selected for recoding.}

  }
}
\section{Methods}{

  See \code{\link{Recode}}

}

\author{Tom Milac \url{tmilac@fhcrc.org}}

\seealso{

  \code{\link{Recode}} for object construction, accessors
  \code{\link{recodeValue}}

}

\examples{
showClass("Recode")
Recode(recodeValue=-50.0)
}
\keyword{classes}
