\name{Model-class}
\docType{class}
\alias{Model-class}

\title{Class "Model"}
\description{

  Model is the base class for all linear model parameter classes.
}
\section{Objects from the Class}{

  Objects can be created by calls to the constructor
  \code{\link{Model}}.

  Elements can be accessed with \code{\link{numberOfTopReporters}}.

}
\section{Slots}{
  \describe{

    \item{\code{numberOfTopReporters}:}{Object of class \code{"integer"}
        specifying the number of top (most significant) reporters to return.
        A value of -1 specifies that all reporters should be returned.}

  }
}
\section{Methods}{

  See \code{\link{Model}}

}

\author{Tom Milac \url{tmilac@fhcrc.org}}

\seealso{

  \code{\link{Model}} for object construction, accessors
  \code{\link{numberOfTopReporters}}

}

\examples{
showClass("Model")
obj <- Model(numberOfTopReporters=-1L)
numberOfTopReporters(obj)
}
\keyword{classes}
