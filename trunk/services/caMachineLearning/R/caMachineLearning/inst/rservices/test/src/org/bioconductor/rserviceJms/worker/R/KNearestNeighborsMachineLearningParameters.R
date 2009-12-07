
numberOfNeighbors <- 1L
minimumVote       <- 0L
sampleName        <- c("Jim", "Kyle", "George", "Amy", "Kathy")
isTrainingSample  <- c(TRUE, FALSE, TRUE, FALSE, FALSE)
type              <- as.factor( c("a", "a", "b", "c", "c") )

kNearestNeighborsMachineLearningParameters <- try( KNearestNeighborsMachineLearningParameters(
                                                   numberOfNeighbors=numberOfNeighbors,
                                                   minimumVote=minimumVote,
                                                   sampleName=sampleName,
                                                   isTrainingSample=isTrainingSample,
                                                   type=type ),
                                              silent=TRUE )

if(is(kNearestNeighborsMachineLearningParameters, "try-error"))
	kNearestNeighborsMachineLearningParameters <- NULL
