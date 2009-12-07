#
# TTest.
#

setMethod(.fit,
    signature(oneChannelModel="TTest",
              oneChannelExpressionData="OneChannelExpressionData",
              sampleAnnotationCollection="SampleAnnotationCollection"),
    function(oneChannelModel, oneChannelExpressionData, sampleAnnotationCollection)
    {
        # Unpack data.

        pData                                    <- sampleAnnotationCollection(sampleAnnotationCollection)
        eData                                    <- expressionMatrix( channelOne(oneChannelExpressionData) )
        sampleAnnotationCollectionTestColumnName <- sampleAnnotationCollectionTestColumnName(oneChannelModel)
        numberOfTopReporters                     <- numberOfTopReporters(oneChannelModel)

        # Check that the data in column 'sampleAnnotationCollectionTestColumnName' of
        # 'pData' can be interpreted as factor with two levels.

        tryCatch({
           levels <- levels(as.factor(pData[,sampleAnnotationCollectionTestColumnName]))
           if (length(levels) != 2)
                stop("The data in 'sampleAnnotationCollectionTestColumnName(model)' of 'sampleAnnotationCollection' must be interpretable as a 2-level factor")
        }, error=function(err) {
            stop("Error encountered in .fit, TTest, OneChannelExpressionData, SampleAnnotationCollection; error message:",
                conditionMessage(err))
        })

        # A t-test is simply an ANOVA with 2 levels.

        oneFactorANOVA <- OneFactorANOVA( sampleAnnotationCollectionTestColumnName=sampleAnnotationCollectionTestColumnName,
                                          numberOfTopReporters=numberOfTopReporters )

        ttCollection <- .fit(oneFactorANOVA, oneChannelExpressionData, sampleAnnotationCollection)

        # Edit the 'modelSpecification' of the TopTableCollection returned above to be 'TTest'.

        ttCollection@modelSpecification <- "TTest"

        # Return.

        ttCollection
    }
)

#
# PairedTTest.
#

setMethod(.fit,
    signature(oneChannelModel="PairedTTest",
              oneChannelExpressionData="OneChannelExpressionData",
              sampleAnnotationCollection="SampleAnnotationCollection"),
    function(oneChannelModel, oneChannelExpressionData, sampleAnnotationCollection)
    {
        # Unpack data.
 
        pData                                       <- sampleAnnotationCollection(sampleAnnotationCollection)
        eData                                       <- expressionMatrix( channelOne(oneChannelExpressionData) )
        sampleAnnotationCollectionTestColumnName    <- sampleAnnotationCollectionTestColumnName(oneChannelModel)
        sampleAnnotationCollectionPairingColumnName <- sampleAnnotationCollectionPairingColumnName(oneChannelModel)
        numberOfTopReporters                        <- numberOfTopReporters(oneChannelModel)

        # Check that the data in column 'sampleAnnotationCollectionTestColumnName' 
        # of 'pData' can be interpreted as a 2-level factor.

        tryCatch({
           testLevels <- levels(as.factor(pData[,sampleAnnotationCollectionTestColumnName]))
           if (length(testLevels) != 2)
                stop("The data in 'sampleAnnotationCollectionTestColumnName(model)' of 'sampleAnnotationCollection' must be interpretable as a 2-level factor")
        }, error=function(err) {
            stop("Error encountered in .fit, PairedTTest, OneChannelExpressionData, SampleAnnotationCollection; error message:",
                conditionMessage(err))
        })

        # Check that column 'sampleAnnotationPairingColumnName' of 'pData'
        # includes exactly 2 entries for every level.

        tryCatch({
            tbl <- as.data.frame( table(pData[,sampleAnnotationCollectionPairingColumnName]) )
            if (!all(tbl$Freq == 2))
                stop("The data in 'sampleAnnotationCollectionPairingColumnName(model)' of 'sampleAnnotationCollection' must include exactly 2 entries for every level")
        }, error=function(err) {
            stop("Error encountered in .fit, PairedTTest, OneChannelExpressionData, SampleAnnotationCollection; error message:",
                conditionMessage(err))
        })

        # Define the design matrix.

        testFactor    <- factor( pData[,sampleAnnotationCollectionTestColumnName] )
        pairingFactor <- factor( pData[,sampleAnnotationCollectionPairingColumnName] )
        design        <- model.matrix(~0+testFactor+pairingFactor)

        # Relabel the first two columns of the design matrix to have the
        # names of the two test factor levels.

        colnames         <- colnames(design)
        colnames[1]      <- levels(testFactor)[1]
        colnames[2]      <- levels(testFactor)[2]
        colnames(design) <- colnames

        # The contrast of interest is the difference between the two 
        # test factor levels.

        contrast        <- paste(colnames(design)[1], colnames(design)[2], sep="-")
        contrast.matrix <- makeContrasts(contrasts=contrast, levels=design)

        # Apply the model.

        fit <- eBayes( lmFit( eData, design ) )

        # Compute the contrast of interest.

        fit2 <- contrasts.fit(fit, contrasts=contrast.matrix)
        fit2 <- eBayes(fit2)

        # topTable.

        if (numberOfTopReporters < 0) {
            topTable <- topTable(fit2, coef=contrast, number=nrow(fit2$genes))
        } else {
            topTable <- topTable(fit2, coef=contrast, number=numberOfTopReporters)
        }

        # Return.  Label the TopTable using the contrast determined above.

        TopTableCollection( "PairedTTest",
                            list(TopTable(contrast, topTable))
                          )
    }
)

#
# OneFactorANOVA.
#

setMethod(.fit,
    signature(oneChannelModel="OneFactorANOVA",
              oneChannelExpressionData="OneChannelExpressionData",
              sampleAnnotationCollection="SampleAnnotationCollection"),
    function(oneChannelModel, oneChannelExpressionData, sampleAnnotationCollection)
    {
        # Unpack data.

        pData                                    <- sampleAnnotationCollection(sampleAnnotationCollection)
        eData                                    <- expressionMatrix( channelOne(oneChannelExpressionData) )
        sampleAnnotationCollectionTestColumnName <- sampleAnnotationCollectionTestColumnName(oneChannelModel)
        numberOfTopReporters                     <- numberOfTopReporters(oneChannelModel)

        # Check that the sampleAnnotationCollectionTestColumnName in 'pData' can be
        # interpreted as factor with two or more levels.

        tryCatch({
            testLevels <- levels(as.factor(pData[,sampleAnnotationCollectionTestColumnName]))
            if (length(testLevels) < 2)
                stop("The data in 'sampleAnnotationCollectionTestColumnName(model)' of 'sampleAnnotationCollection' must be interpretable as a factor with 2 or more levels.")
        }, error=function(err) {
            stop("Error encountered in .fit, OneFactorANOVA, OneChannelExpressionData, SampleAnnotationCollection; error message:",
                conditionMessage(err))
        })

        # Define the design matrix.

        testFactor       <- factor(pData[,sampleAnnotationCollectionTestColumnName])
        design           <- model.matrix(~0+testFactor)
        colnames(design) <- levels(testFactor)

        # Fit.

        fit <- lmFit(eData, design)

        # Find all pair-wise contrasts that are to be computed.

        combinations    <- t(combn(levels(testFactor), 2))
        contrasts       <- paste(combinations[,1], combinations[,2], sep="-")
        contrast.matrix <- makeContrasts(contrasts=contrasts, levels=levels(testFactor))

        # Compute all pair-wise contrasts.

        fit2 <- contrasts.fit(fit, contrast.matrix)
        fit2 <- eBayes(fit2)

        # Generate topTables for all pair-wise contrasts.

        listOfTopTables <- list()
        for (coef in colnames(contrast.matrix)) {
            if (numberOfTopReporters < 0) {
                topTable <- topTable(fit2, coef=coef, adjust="BH", number=nrow(fit2$genes))
            } else {
                topTable <- topTable(fit2, coef=coef, adjust="BH", number=numberOfTopReporters)
            }
            tt <- TopTable(coef, topTable)
            listOfTopTables <- c(listOfTopTables, tt)
        }

        # Return.

        TopTableCollection( "OneFactorANOVA",
                            listOfTopTables
                          )
    }
)

#
# TwoFactorANOVA.
#

setMethod(.fit,
    signature(oneChannelModel="TwoFactorANOVA",
              oneChannelExpressionData="OneChannelExpressionData",
              sampleAnnotationCollection="SampleAnnotationCollection"),
    function(oneChannelModel, oneChannelExpressionData, sampleAnnotationCollection)
    {
        # Unpack data.

        pData                                         <- sampleAnnotationCollection(sampleAnnotationCollection)
        eData                                         <- expressionMatrix( channelOne(oneChannelExpressionData) )
        sampleAnnotationCollectionFactorOneColumnName <- sampleAnnotationCollectionFactorOneColumnName(oneChannelModel)
        sampleAnnotationCollectionFactorTwoColumnName <- sampleAnnotationCollectionFactorTwoColumnName(oneChannelModel)
        numberOfTopReporters                          <- numberOfTopReporters(oneChannelModel)

        # Check that the sampleAnnotationCollectionFactorOneColumnName and
        # sampleAnnotationCollectionFactorTwoColumnName in 'pData' can be
        # interpreted as factors with two or more levels.

        tryCatch({
            factorOneLevels = levels(as.factor(pData[,sampleAnnotationCollectionFactorOneColumnName]))
            factorTwoLevels = levels(as.factor(pData[,sampleAnnotationCollectionFactorTwoColumnName]))
            if (length(factorOneLevels) < 2)
                stop("The data in 'sampleAnnotationCollectionFactorOneColumnName(model)' of 'sampleAnnotationCollection' must be interpretable as a factor with 2 or more levels.")
            if (length(factorTwoLevels) < 2)
                stop("The data in 'sampleAnnotationCollectionFactorTwoColumnName(model)' of 'sampleAnnotationCollection' must be interpretable as a factor with 2 or more levels.")
        }, error=function(err) {
            stop("Error encountered in .fit, TwoFactorANOVA, OneChannelExpressionData, SampleAnnotationCollection; error message:",
                conditionMessage(err))
        })

        # Define the design matrix.  The combinedFactor is all possible
        # combinations of the two input factors.

        combinedFactor   <- factor( paste(pData[,sampleAnnotationCollectionFactorOneColumnName],
                                          pData[,sampleAnnotationCollectionFactorTwoColumnName], sep="-")
                                  )
        design           <- model.matrix(~0+combinedFactor)
        colnames(design) <- levels(combinedFactor)

        # Fit.

        fit <- eBayes( lmFit( eData, design ) )

        # Generate topTables for all coefficients, i.e., all column
        # names of the design matrix.

        listOfTopTables <- list()
        for (coef in colnames(design)) {
          if (numberOfTopReporters < 0) {
            topTable <- topTable(fit, coef=coef, adjust="BH", number=nrow(fit$genes))
          } else {
            topTable <- topTable(fit, coef=coef, adjust="BH", number=numberOfTopReporters)
          }
          tt <- TopTable(coef, topTable)
          listOfTopTables <- c(listOfTopTables, tt)
        }

        # Return.

        TopTableCollection( "TwoFactorANOVA",
                            listOfTopTables
                          )
    }
)

#
# DyeSwapTTest.
#

setMethod(.twoChannelFit,
    signature(twoChannelModel="DyeSwapTTest",
              twoChannelExpressionData="TwoChannelExpressionData",
              sampleAnnotationCollection="SampleAnnotationCollection"),
    function(twoChannelModel, twoChannelExpressionData, sampleAnnotationCollection)
    {

        # Consistency checks common to all analyses of TwoChannelModels.

        .twoChannelModelTests(twoChannelModel, twoChannelExpressionData, sampleAnnotationCollection)

        # Unpack data.

        pData                                    <- sampleAnnotationCollection(sampleAnnotationCollection)
        eDataChannelOne                          <- expressionMatrix(channelOne(twoChannelExpressionData))
        eDataChannelTwo                          <- expressionMatrix(channelTwo(twoChannelExpressionData))
        channelOneName                           <- expressionMatrixName(channelOne(twoChannelExpressionData))
        channelTwoName                           <- expressionMatrixName(channelTwo(twoChannelExpressionData))
        sampleAnnotationCollectionTestColumnName <- sampleAnnotationCollectionTestColumnName(twoChannelModel)
        testReferenceLevel                       <- testReferenceLevel(twoChannelModel)
        numberOfTopReporters                     <- numberOfTopReporters(twoChannelModel)

        # Check that the test factor column specified in DyeSwapTTest can be
        # interpreted as a 2-level factor.
		
        tryCatch({
            testFactorLength <- length(levels(as.factor(pData[,sampleAnnotationCollectionTestColumnName])))
            if (testFactorLength != 2)
                stop("The data in 'sampleAnnotationCollectionTestColumnName(model)' of 'sampleAnnotationCollection' must be interpretable as a 2-level factor")
        }, error=function(err) {
            stop("Error encountered in .fit, DyeSwapTTest, TwoChannelExpressionData, SampleAnnotationCollection; error message:",
                conditionMessage(err))
        })

        # Check that one of the levels of the 'sampleAnnotationCollectionTestColumnName'
        # corresponds to 'testReferenceLevel'.  Note that DyeSwapTTest is not a
        # common reference design; the 'testReferenceLevel' is one of the two levels
        # specified in the test factor column.

        tryCatch({
            testFactorLevels <- levels(as.factor(pData[,sampleAnnotationCollectionTestColumnName]))
            if ( !(testReferenceLevel %in% testFactorLevels) )
                stop("The 'testReferenceLevel' must be one of the levels specified in 'sampleAnnotationCollectionTestColumnName'.")
        }, error=function(err) {
            stop("Error encountered in .fit, DyeSwapTTest, TwoChannelExpressionData, SampleAnnotationCollection; error message:",
                conditionMessage(err))
        })

        #
        # Define the design matrix.
        #

        # We employ the ratio channelOne/channelTwo for this test.  For this,
        # choice, the channel reference level is the channelTwoName.

        channelReferenceLevel = channelTwoName

        # Find the name of the 'compare' level, i.e., the level in the
        # test factor column that is not the 'testReferenceLevel'.

        testCompareLevel <- setdiff(testFactorLevels, testReferenceLevel)

        # The DyeEffect column of the design matrix is a column of ones with
        # length equal to the number of distinct arrays in the 'array' column 
        # of sampleAnnotationCollection.

        arrayList <- unique(pData[,"array"])
        DyeEffect <- rep(1, length(arrayList))
      
        # Compute the design matrix column comparing the 'compare' and 'reference'
        # test levels.  Enter a 1 in this column if the 'reference' test level is
        # measured by the dye specified by the channel reference level, and a -1 if
        # the opposite.

        # The name to use for comparison column of the design matrix.

        testCompareLevelVsTestReferenceLevel <- paste(testCompareLevel, "vs", testReferenceLevel, sep="")

        # Find those elements of the sampleAnnotationCollectionTestColumnName measured by
        # the dye specified by the channel reference level. If the channel reference level
        # was used to measure the testReferenceLevel, then 1, otherwise -1.

        channelReferenceElements <- pData[pData$channel == channelReferenceLevel,][,sampleAnnotationCollectionTestColumnName]
        designColumn <- ifelse(channelReferenceElements == testReferenceLevel, 1, -1)

        design           <- cbind( DyeEffect, designColumn )
        colnames(design) <- c("DyeEffect", testCompareLevelVsTestReferenceLevel)

        # Compute the log base 2 ratio. We employ the ratio channelOne/channelTwo

        logRatio <- eDataChannelOne - eDataChannelTwo

        # Fit the model.

        fit <- eBayes( lmFit(logRatio, design) )

        # topTable.

        if (numberOfTopReporters < 0) {
            topTable <- topTable(fit, coef=testCompareLevelVsTestReferenceLevel, number=nrow(fit$genes))
        } else {
            topTable <- topTable(fit, coef=testCompareLevelVsTestReferenceLevel, number=numberOfTopReporters)
        }

        # Return.

        TopTableCollection( "DyeSwapTTest",
                            list(TopTable(testCompareLevelVsTestReferenceLevel, topTable))
                          )
    }
)

#
# CommonReferenceANOVA.
#

setMethod(.twoChannelFit,
    signature(twoChannelModel="CommonReferenceANOVA",
              twoChannelExpressionData="TwoChannelExpressionData",
              sampleAnnotationCollection="SampleAnnotationCollection"),
    function(twoChannelModel, twoChannelExpressionData, sampleAnnotationCollection)
    {

       # Consistency checks common to all analyses of TwoChannelModels.

        .twoChannelModelTests(twoChannelModel, twoChannelExpressionData, sampleAnnotationCollection)

        # Unpack data.

        pData                                    <- sampleAnnotationCollection(sampleAnnotationCollection)
        eDataChannelOne                          <- expressionMatrix(channelOne(twoChannelExpressionData))
        eDataChannelTwo                          <- expressionMatrix( channelTwo(twoChannelExpressionData))
        channelOneName                           <- expressionMatrixName(channelOne(twoChannelExpressionData))
        channelTwoName                           <- expressionMatrixName(channelTwo(twoChannelExpressionData))
        sampleAnnotationCollectionTestColumnName <- sampleAnnotationCollectionTestColumnName(twoChannelModel)
        testReferenceLevel                       <- testReferenceLevel(twoChannelModel)
        numberOfTopReporters                     <- numberOfTopReporters(twoChannelModel)

        # Check that the test factor column specified in CommonReferenceANOVA can be
        # interpreted as a 3- or more- level factor.

        tryCatch({
            testFactorLength <- length(levels(as.factor(pData[,sampleAnnotationCollectionTestColumnName])))
            if (testFactorLength < 3)
                stop("The data in 'sampleAnnotationCollectionTestColumnName(model)' of 'sampleAnnotationCollection' must be interpretable as a factor with 3 or more levels.")
        }, error=function(err) {
            stop("Error encountered in .fit, CommonReferenceANOVA, TwoChannelExpressionData, SampleAnnotationCollection; error message:",
                conditionMessage(err))
        })

        # Check that one of the levels of the 'sampleAnnotationCollectionTestColumnName'
        # corresponds to 'testReferenceLevel'.

        tryCatch({
            testFactorLevels <- levels(as.factor(pData[,sampleAnnotationCollectionTestColumnName]))
            if ( !(testReferenceLevel %in% testFactorLevels) )
                stop("The 'testFactorLevel' must be one of the levels specified in 'sampleAnnotationCollectionTestColumnName'.")
        }, error=function(err) {
            stop("Error encountered in .fit, CommonReferenceANOVA, TwoChannelExpressionData, SampleAnnotationCollection; error message:",
                conditionMessage(err))
        })

        # Find the targets data.frame.  Check that 'testReferenceLevel' is one of
        # the levels tested on all arrays.

        targets <- with(pData,
                        tapply(as.character(pData[[sampleAnnotationCollectionTestColumnName]]),
                               list(array, channel), c))
        if (!all(rowSums(targets == testReferenceLevel) > 0))
            stop("For CommonReferenceANOVA, the 'testReferenceLevel' must be tested in one or the other channel of every array.")

        # Use 'modelMatrix' to construct the model matrix.  'modelMatrix'
        # assumes that the column names of the 'targets' data frame are 'Cy3'
        # and 'Cy5' and that the 'channel reference level' is 'Cy3'.  That is,
        # the log ratio assumed is log2(Cy5/Cy3).  Here, we analyze the ratio
        # log2(Channel 1/Channel 2). Consequently, to use 'modelMatrix',
        # treat Channel 1 as 'Cy5' and Channel 2 as 'Cy3'.

        targets <- data.frame( targets[,c(channelTwoName, channelOneName)] )   # sort the columns so that
                                                                               # Channel 1 appears before
                                                                               # Channel 2.
        colnames(targets)  <- c("Cy3", "Cy5")    # replace channelTwoName and channelOneName by
                                                 # 'Cy3' and 'Cy5', respectively, to accommodate
                                                 # limma's 'modelMatrix' command.

        design <- modelMatrix(targets, ref=testReferenceLevel, verbose=FALSE)

        # Compute the log base 2 ratio.  'modelMatrix' computed the design
        # matrix assuming that 'Cy3', that is, channelTwo, is the channel
        # reference level.

        logRatio <- eDataChannelOne - eDataChannelTwo

        # Fit the model.

        fit <- lmFit(logRatio, design)

        # Make all pair-wise contrasts.

        lvls <- setdiff(unique(as.character(pData[[sampleAnnotationCollectionTestColumnName]])),
                        testReferenceLevel)
        combinations    <- t(combn(lvls, 2))
        contrasts       <- paste(combinations[,1], combinations[,2], sep="-")
        contrast.matrix <- makeContrasts(contrasts=contrasts, levels=lvls)
        contrast.matrix <- contrast.matrix[colnames(fit),,drop=FALSE]  # reorder row names of contrasts to
                                                                       # to correspond to column names of
                                                                       # of coefficients.  See warning in
                                                                       # in 'contrasts.fit'.

        # Apply the model.

        fit2 <- contrasts.fit(fit, contrast.matrix)
        fit2 <- eBayes(fit2)

        # topTable.
        if (numberOfTopReporters < 0) {
            ntop <- nrow(fit2)
        } else {
            ntop <- numberOfTopReporters
        }

        topTables <- 
            lapply(colnames(contrast.matrix), function(coef, ...) {
                tbl <- topTable(fit2, coef, ...)
                TopTable(coef, tbl)
            }, adjust.method="BH", number=ntop)
        TopTableCollection("CommonReferenceANOVA", topTables)
    }
)

#
# Consistency checks for twoChannelModel fits.
#

.twoChannelModelTests <- function(twoChannelModel, twoChannelExpressionData, sampleAnnotationCollection) {

    # Unpack data.

    channelOneName        <- expressionMatrixName(channelOne(twoChannelExpressionData))
    channelTwoName        <- expressionMatrixName(channelTwo(twoChannelExpressionData))
    pData                 <- sampleAnnotationCollection(sampleAnnotationCollection)

    # Check that the channel column of sampleAnnotationCollection (the internal
    # data.frame of SampleAnnotationCollection) can be interpreted as a 2-level factor.

    tryCatch({
        channelFactorLength <- length(levels(as.factor(pData[,"channel"])))
        if (channelFactorLength != 2)
            stop("The data in the 'channel' column of the 'sampleAnnotationCollection' must be
                    interpretable as a 2-level factor")
    }, error=function(err) {
        stop("Error encountered in .twoChannelModelTests, TwoChannelModel, TwoChannelExpressionData,
                SampleAnnotationCollection; error message:",
            conditionMessage(err))
    })

    # Check that the 2 levels in the channel column of the SampleAnnotationCollection
    # correspond to the channel names in the TwoChannelExpressionData.

    expressionDataChannelNames             <- sort( c(channelOneName, channelTwoName) )
    sampleAnnotationCollectionChannelNames <- sort( levels(as.factor(pData[,"channel"])) )
    if ( !all(expressionDataChannelNames == sampleAnnotationCollectionChannelNames) )
        stop("The channel names in the TwoChannelExpressionData are not the same as those specified
                in the 'channel' column of the SampleAnnotationCollection")

    # Check that the NumericMatrices in the two ExpressionMatrices of
    # twoChannelExpressionData have the same dimensions.

    if ( !all( dim(expressionMatrix( channelOne(twoChannelExpressionData) )) ==
               dim(expressionMatrix( channelTwo(twoChannelExpressionData) ))    ) )
        stop("The NumericMatrices 'expressionMatrix(channelOne(twoChannelExpressionData))' and
               'expressionMatrix(channelTwo(twoChannelExpressionData))' must have the same dimensions.")
}

#
# fit
#

fit <- function(oneChannelModel, oneChannelExpressionData, sampleAnnotationCollection) {
    .fit(oneChannelModel, oneChannelExpressionData, sampleAnnotationCollection)
}

typeInfo(fit) <-
  SimultaneousTypeSpecification(
    TypedSignature(oneChannelModel            = "OneChannelModel",
                   oneChannelExpressionData   = "OneChannelExpressionData",
                   sampleAnnotationCollection = "SampleAnnotationCollection"),
    returnType = "TopTableCollection")

#
# twoChannelFit
#

twoChannelFit <- function(twoChannelModel, twoChannelExpressionData, sampleAnnotationCollection) {
    .twoChannelFit(twoChannelModel, twoChannelExpressionData, sampleAnnotationCollection)
}

typeInfo(twoChannelFit) <-
  SimultaneousTypeSpecification(
    TypedSignature(twoChannelModel            = "TwoChannelModel",
                   twoChannelExpressionData   = "TwoChannelExpressionData",
                   sampleAnnotationCollection = "SampleAnnotationCollection"),
    returnType = "TopTableCollection")

