\name{caFileGeneRecode}
\alias{caFileGeneRecode}

\title{RWebServices interface to the genefilter package}

\description{
  Provides access to the genefilter package as an RWebService.
}

\usage{
caFileGeneRecode(fileReferences, recode)
}

\arguments{
  \item{fileReferences}{ An object of class \code{FileReferences} }
  \item{recode}{ An object of class \code{SpotQualityRecode} }
}

\value{
  An object of class \code{NumericMatrix} which includes those
  rows of the input \code{NumericMatrix} that satisfy the recode.
}

\author{Tom Milac <tmilac@fhcrc.org>}

% \seealso{ objects to See Also as \code{\link{help}},  }

\examples{
   library(caServicesTestData)

   # Retrieve data files with which to test.

   datadir   <- file.path( system.file(package="caServicesTestData"),
                           "extdata", "caGeneFilter", "GPR" )
   filenames <- list.files(datadir, pattern="(.gpr)$", ignore.case=TRUE)
   filepaths <- file.path(datadir, filenames)
   filepaths <- paste("file://", filepaths, sep="")

   fileReferences <- FileReferences(filepaths, type=rep("GPR", length(filepaths)))

   # Apply a SpotQualityRecode.

   spotQualityRecode      <- SpotQualityRecode(column="Flags",
                                               columnMinimumThresholdValue=-25.0,
                                               recodeValue=-Inf)
   spotQualityRecodedData <- caFileGeneRecode(fileReferences, spotQualityRecode)
}

% Add one or more standard keywords, see file 'KEYWORDS' in the
% R documentation directory.
\keyword{ manip }
