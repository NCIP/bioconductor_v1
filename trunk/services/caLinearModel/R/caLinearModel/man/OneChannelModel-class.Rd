\name{OneChannelModel-class}
\docType{class}
\alias{OneChannelModel-class}

\title{Class "OneChannelModel"}
\description{

  OneChannelModel is the base class for all linear model parameter classes
  applicable to the analysis of one channel microarray experiments.
}
\section{Objects from the Class}{

  Objects can be created by calls to the constructor
  \code{\link{OneChannelModel}}.

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

  See \code{\link{OneChannelModel}}

}

\author{Tom Milac \url{tmilac@fhcrc.org}}

\seealso{

  \code{\link{OneChannelModel}} for object construction, accessors
  \code{\link{numberOfTopReporters}}

}

\examples{
showClass("OneChannelModel")
obj <- OneChannelModel(numberOfTopReporters=-1L)
numberOfTopReporters(obj)
}
\keyword{classes}
