\name{UnsupervisedMachineLearningResult-class}
\docType{class}
\alias{UnsupervisedMachineLearningResult-class}

\title{Class "UnsupervisedMachineLearningResult"}
\description{
  UnsupervisedMachineLearningResult encapsulates the data returned
  from an unsupervised machine learning analysis.
}
\section{Objects from the Class}{

  Objects can be created by calls to the constructor
  \code{\link{UnsupervisedMachineLearningResult}}.

  Elements can be accessed with \code{\link{sampleName}},
  \code{\link{predictedPartition}}, \code{\link{neighboringPartition}},
  \code{\link{silhouetteWidth}} and \code{\link{parameters}}.

}
\section{Slots}{
  \describe{

    \item{\code{sampleName}:}{Object of class \code{"character"} containing the
        sample names.}

    \item{\code{predictedPartition}:}{Object of class \code{"integer"} containing
        the cluster to which the corresponding sample belongs.}

    \item{\code{neighboringPartition}:}{Object of class \code{"integer"} containing
        the neighbor cluster of the cluster to which the corresponding sample belongs.}

    \item{\code{silhouetteWidth}:}{Object of class \code{"numeric"} containing
        the average dissimilarity between the corresponding sample and all other points
        of the cluster to which the corresponding sample belongs.}

    \item{\code{parameters}:}{Object of class \code{"UnsupervisedMachineLearningParameters"}
        containing the SupervisedMachineLearningParameters class which directed the
        analysis.}

  }
}
\section{Methods}{

  See \code{\link{UnsupervisedMachineLearningResult}}

}

\author{Tom Milac \url{tmilac@fhcrc.org}}

\seealso{

  \code{\link{UnsupervisedMachineLearningResult}} for object construction, accessors
  \code{\link{sampleName}}
  \code{\link{predictedPartition}}
  \code{\link{neighboringPartition}}
  \code{\link{silhouetteWidth}}
  \code{\link{parameters}}

}

\examples{
showClass("UnsupervisedMachineLearningResult")
obj <- UnsupervisedMachineLearningResult(
            sampleName=character(0), predictedPartition=integer(0),
            neighboringPartition=integer(0), silhouetteWidth=numeric(0),
            parameters=new("UnsupervisedMachineLearningParameters"))
sampleName(obj)
predictedPartition(obj)
neighboringPartition(obj)
silhouetteWidth(obj)
parameters(obj)
}
\keyword{classes}
