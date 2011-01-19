\name{dnacopyAssays}
\alias{dnacopyAssays}
\docType{data}
\title{Sample data of class 'DNAcopyAssays'}
\description{
  Encapsulates two samples from the \code{\link[DNAcopy]{coriell}} data.
}
\usage{data(dnacopyAssays)}
\format{
Formal class 'DNAcopyAssays' [package "caDNAcopy"] with 3 slots
  ..@ .Data       :List of 2
  .. ..$ :Formal class 'ExpressionData' [package "caDNAcopy"] with 2 slots
  .. .. .. ..@ sampleId      : chr "Coriell.05296"
  .. .. .. ..@ logratioValues: num [1:2271]       NA  0.00882 -0.00089  0.07587  0.01730 ...
  .. ..$ :Formal class 'ExpressionData' [package ".GlobalEnv"] with 2 slots
  .. .. .. ..@ sampleId      : chr "Coriell.13330"
  .. .. .. ..@ logratioValues: num [1:2271]  0.2075  0.0631  0.1239  0.1543 -0.0439 ...
  ..@ chromosomeId: int [1:2271] 1 1 1 1 1 1 1 1 1 1 ...
  ..@ mapLocation : int [1:2271] 0 468 2241 4504 5440 7000 9046 10000 12618 13000 ...
}
\seealso{\code{\link[DNAcopy]{coriell}}}
\examples{
data(dnacopyAssays)
str(dnacopyAssays)
}
\keyword{datasets}
