\name{VarianceFilter-class}
\docType{class}
\alias{VarianceFilter-class}

\title{Class "VarianceFilter"}
\description{
  VarianceFilter encapsulates the parameters needed to run a gene filter analysis
  which returns genes for which the variance across samples is less than
  'minimumVariance'.
}
\section{Objects from the Class}{

  Objects can be created by calls to the constructor
  \code{\link{VarianceFilter}}.

  Elements can be accessed with \code{\link{minimumVariance}}.

}
\section{Slots}{
  \describe{

    \item{\code{minimumVariance}:}{Object of class \code{"numeric"} containing the
        minimum variance.}

  }
}
\section{Methods}{

  See \code{\link{VarianceFilter}}

}

\author{Tom Milac \url{tmilac@fhcrc.org}}

\seealso{

  \code{\link{VarianceFilter}} for object construction, accessors
  \code{\link{minimumVariance}}

}

\examples{
showClass("VarianceFilter")
obj <- VarianceFilter(minimumVariance=0.5)
minimumVariance(obj)
}
\keyword{classes}
