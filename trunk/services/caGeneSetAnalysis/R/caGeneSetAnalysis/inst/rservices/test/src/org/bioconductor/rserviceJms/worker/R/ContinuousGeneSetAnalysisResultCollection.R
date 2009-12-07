adjustedTStatistic <- c(0.01, 0.35, 0.41)
description        <- "description"
geneSetId          <- c("A", "B", "C")
geneSetSize        <- c(100L, 200L, 300L)
pValue             <- c(0.05, 0.3, 0.001)
geneSetMembers     <- list(c("x1", "y1"), c("x2", "y2"), c("x3", "y3"))

continuousGeneSetAnalysisResultCollection <- try( ContinuousGeneSetAnalysisResultCollection(
                             adjustedTStatistic=adjustedTStatistic,
                             description=description,
                             geneSetId=geneSetId,
                             geneSetSize=geneSetSize,
                             pValue=pValue,
                             geneSetMembers=geneSetMembers
                            ),
                          silent=TRUE )

if(is(continuousGeneSetAnalysisResultCollection, "try-error"))
	continuousGeneSetAnalysisResultCollection <- NULL

