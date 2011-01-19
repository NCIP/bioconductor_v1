\name{TwoChannelModel-class}
\docType{class}
\alias{TwoChannelModel-class}

\title{Class "TwoChannelModel"}
\description{

  TwoChannelModel is the base class for all linear model parameter classes
  applicable to the analysis of two channel microarray experiments.
}
\section{Objects from the Class}{

  Objects can be created by calls to the constructor
  \code{\link{TwoChannelModel}}.

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

  See \code{\link{TwoChannelModel}}

}

\author{Tom Milac \url{tmilac@fhcrc.org}}

\seealso{

  \code{\link{TwoChannelModel}} for object construction, accessors
  \code{\link{numberOfTopReporters}}

}

\examples{
showClass("TwoChannelModel")
obj <- TwoChannelModel(numberOfTopReporters=-1L)
numberOfTopReporters(obj)
}
\keyword{classes}
