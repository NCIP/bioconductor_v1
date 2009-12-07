\name{caArrayQualityMetrics-package}
\alias{caArrayQualityMetrics-package}

\docType{package}

\title{
RWebServices interface to the arrayQualityMetrics package.
}

\description{
Provides an RWebServices interface to a part of the functionality provided
by the arrayQualityMetrics package.  Affymetrix (.cel), Agilent (.txt) and
Genepix (.gpr) files may be analyzed using the function
\code{caArrayQualityMetrics}.
}

\details{
 The data files to be analyzed are specified using a
 \code{FileReferences} object. The analysis is made by a call to the
 function \code{caArrayQualityMetrics} with the call signature

 outputFileReferences <- caArrayQualityMetrics(inputFileReferences)

 where \code{outputFileReferences} is an instance of \code{FileReferences} and
 holds a reference to the .zip file containing the data returned by package
 arrayQualityMetrics.
}

\author{
Tom Milac <tmilac@fhcrc.org>
}

%\references{
% Literature or other references for background information
%}

\keyword{ package }

\seealso{ 
\code{\link[arrayQualityMetrics:arrayQualityMetrics]{arrayQualityMetrics}}
}

%\examples{
%}
