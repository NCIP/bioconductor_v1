\name{caArrayQualityMetrics}
\alias{caArrayQualityMetrics}

\title{RWebServices interface to the arrayQualityMetrics package}

\description{
  Provides access to the arrayQualityMetrics package as an RWebService.
}

\usage{
caArrayQualityMetrics(inputFileReferences)
}

\arguments{
  \item{inputFileReferences}{ An object of class \code{FileReferences} }
}

\details{

  Supported file types include CEL files from Affymetrix expression
  array, Genepix GPR files, and Agilent two-color arrays. All files must
  be of the same type.

}

\value{
  An object of class \code{FileReferences} carrying the URL of a .zip file
  encapsulating output from the arrayQualityMetrics package.
}

\author{Tom Milac <tmilac@fhcrc.org>}

% \seealso{ objects to See Also as \code{\link{help}},  }

\examples{
   library(caServicesTestData)

   getFileReferences <-
       function(type, ext)
   {
       dir <- system.file("extdata", "caArrayQualityMetrics",
                          type, package="caServicesTestData")
       fls <- list.files(dir, ext, full=TRUE)
       FileReferences(paste("file://", fls, sep=""),
                      types=rep(type, length(fls)))
   }

   inputFileReferences <- getFileReferences("CEL", "CEL$")
   outputFileReferences <- caArrayQualityMetrics(inputFileReferences)

   inputFileReferences <- getFileReferences("GPR", "gpr$")
   outputFileReferences <- caArrayQualityMetrics(inputFileReferences)

   inputFileReferences <- getFileReferences("AGILENT", "txt$")
   outputFileReferences <- caArrayQualityMetrics(inputFileReferences)
}

% Add one or more standard keywords, see file 'KEYWORDS' in the
% R documentation directory.
\keyword{ manip }
