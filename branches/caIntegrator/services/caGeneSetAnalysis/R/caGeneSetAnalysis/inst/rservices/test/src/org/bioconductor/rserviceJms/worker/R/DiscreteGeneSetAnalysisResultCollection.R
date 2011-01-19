
selectedCount  <- c(50L, 100L, 150L)
expectedCount  <- c(55L, 105L, 155L)
description    <- "description"
geneSetId      <- c("A", "B", "C")
geneSetSize    <- c(100L, 200L, 300L)
pValue         <- c(0.05, 0.3, 0.001)
geneSetMembers <- list(c("x1", "y1"), c("x2", "y2"), c("x3", "y3"))

discreteGeneSetAnalysisResultCollection <- try( DiscreteGeneSetAnalysisResultCollection(
                            selectedCount=selectedCount,
                            expectedCount=expectedCount,
                            description=description,
                            geneSetId=geneSetId,
                            geneSetSize=geneSetSize,
                            pValue=pValue,
                            geneSetMembers=geneSetMembers
                           ),
                        silent=TRUE )

if(is(discreteGeneSetAnalysisResultCollection, "try-error"))
	discreteGeneSetAnalysisResultCollection <- NULL

