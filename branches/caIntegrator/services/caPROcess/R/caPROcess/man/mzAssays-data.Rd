\name{mzAssays}
\alias{mzAssays}
\docType{data}
\title{Example MzAssays-class data}
\description{
  An example of the \code{\link{MzAssays-class}}, derived from
  the sample files in the "PROcess" package.
}
\usage{data(mzAssays)}
\format{
  The format is:
Formal class 'MzAssays' [package "caPROcess"] with 1 slots
  ..@ .Data:List of 2
  .. ..$ :Formal class 'MzSpectrum' [package "caPROcess"] with 3 slots
  .. .. .. ..@ spectrumName: chr "122402imac40-s-c-192combined-i11"
  .. .. .. ..@ mzRatio     : num [1:13482] -3.73 -3.73 -3.72 -3.72 -3.72 ...
  .. .. .. ..@ intensity   : num [1:13482] 3.91 3.88 3.83 3.83 3.82 ...
  .. ..$ :Formal class 'MzSpectrum' [package "caPROcess"] with 3 slots
  .. .. .. ..@ spectrumName: chr "122402imac40-s-c-192combined-i12"
  .. .. .. ..@ mzRatio     : num [1:13482] -3.73 -3.73 -3.72 -3.72 -3.72 ...
  .. .. .. ..@ intensity   : num [1:13482] 5.29 5.22 5.17 5.18 5.17 ...
}
\source{
  See the "PROcess" package.
}
\examples{
data(mzAssays)
str(mzAssays)
}
\keyword{datasets}
