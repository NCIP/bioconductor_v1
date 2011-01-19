\name{accessors}
\alias{numberOfTopReporters}
\alias{sampleAnnotationCollectionTestColumnName}
\alias{testReferenceLevel}

\title{Accessor functions shared across several classes}

\description{
  Functions for accessing contents of class instances.
}

\usage{
numberOfTopReporters(object, ...)
sampleAnnotationCollectionTestColumnName(object, ...)
testReferenceLevel(object, ...)
}

\arguments{

  \item{object}{An object from which an information can be
    extracted. Relevant objects include:

    numberOfTopReporters: \linkS4class{CommonReferenceANOVA},
    \linkS4class{DyeSwapTTest}, \linkS4class{Model},
    \linkS4class{OneChannelModel}, \linkS4class{OneFactorANOVA},
    \linkS4class{PairedTTest}, \linkS4class{TTest},
    \linkS4class{TwoChannelModel}, \linkS4class{TwoFactorANOVA}.

	sampleAnnotationCollectionTestColumnName:
	\linkS4class{CommonReferenceANOVA}, \linkS4class{DyeSwapTTest},
	\linkS4class{OneFactorANOVA}, \linkS4class{PairedTTest},
	\linkS4class{TTest}.

	testReferenceLevel: \linkS4class{CommonReferenceANOVA},
	\linkS4class{DyeSwapTTest}.

  }

  \item{\dots}{Additional arguments, (currently) ignored.}

}

\value{
  
  \item{sampleAnnotationCollectionTestColumnName}{a character vector of
    length one containing a column name in a SampleAnnotationCollection
    on which to test.}

  \item{testReferenceLevel}{a character vector of length one containing
    the test reference level.}

  \item{numberOfTopReporters}{an integer vector of length one containing
    the the number of top reporters to return.}

}

\author{Tom Milac \url{tmilac@fhcrc.org}}

\seealso{\code{\linkS4class{AnnotationFilter}-class}}

\keyword{manip}
