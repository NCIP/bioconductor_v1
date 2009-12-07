\name{Recode}
\alias{Recode}

\title{Recode constructor and accessors}

\description{
  Functions for creating and manipulating Recode-class objects.
}

\usage{
Recode(recodeValue=numeric(0))
}

\arguments{

  \item{recodeValue}{A numeric vector of length which contains the value
    to which to recode data points selected for recoding.}

}

\value{

  \item{Recode}{Object of class \code{\linkS4class{Recode}}.}

}

\author{Tom Milac \url{tmilac@fhcrc.org}}

\seealso{\code{\linkS4class{Recode}-class}, \code{\link{recodeValue}}}

\examples{
obj <- Recode(recodeValue=-50.0)
recodeValue(obj)
}

\keyword{manip}
