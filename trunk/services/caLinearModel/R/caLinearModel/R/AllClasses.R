
#
# Model: Base class for all models.
#

setClass("Model",
         representation=representation(
            numberOfTopReporters="integer"),
         prototype=prototype(
            numberOfTopReporters=-1L)
        )

numberOfTopReporters <- function(object, ...) {
     slot(object, "numberOfTopReporters")
}

Model <- function(numberOfTopReporters=-1L)
{
    new("Model",
        numberOfTopReporters=numberOfTopReporters
       )
}

#
# OneChannelModel.
#

setClass("OneChannelModel",
         contains="Model"
        )

OneChannelModel <- function(numberOfTopReporters=-1L)
{
    new("OneChannelModel",
        numberOfTopReporters=numberOfTopReporters
       )
}

#
# TwoChannelModel.
#

setClass("TwoChannelModel",
         contains="Model",
         representation=representation(),
         prototype=prototype()
        )

TwoChannelModel <- function(numberOfTopReporters=-1L)
{
    new("TwoChannelModel",
        numberOfTopReporters=numberOfTopReporters
       )
}

#
# TTest.
#

setClass("TTest",
         contains="OneChannelModel",
         representation=representation(
            sampleAnnotationCollectionTestColumnName="character"),
         prototype=prototype(
            sampleAnnotationCollectionTestColumnName=character(0))
        )

sampleAnnotationCollectionTestColumnName <- function(object, ...) {
     slot(object, "sampleAnnotationCollectionTestColumnName")
}

TTest <- function(sampleAnnotationCollectionTestColumnName=character(0),
                  numberOfTopReporters=-1L)
{
    new ("TTest",
         sampleAnnotationCollectionTestColumnName=sampleAnnotationCollectionTestColumnName,
         numberOfTopReporters=numberOfTopReporters)
}

#
# PairedTTest.
#

setClass("PairedTTest",
         contains="OneChannelModel",
         representation=representation(
            sampleAnnotationCollectionTestColumnName="character",
            sampleAnnotationCollectionPairingColumnName="character"),
         prototype=prototype(
            sampleAnnotationCollectionTestColumnName=character(0),
            sampleAnnotationCollectionPairingColumnName=character(0))
        )

sampleAnnotationCollectionPairingColumnName <- function(object, ...) {
     slot(object, "sampleAnnotationCollectionPairingColumnName")
}

PairedTTest <-
    function(sampleAnnotationCollectionTestColumnName=character(0),
             sampleAnnotationCollectionPairingColumnName=character(0),
             numberOfTopReporters=-1L)
{
    new ("PairedTTest",
         sampleAnnotationCollectionTestColumnName=sampleAnnotationCollectionTestColumnName,
         sampleAnnotationCollectionPairingColumnName=sampleAnnotationCollectionPairingColumnName,
         numberOfTopReporters=numberOfTopReporters)
}

#
# OneFactorANOVA.
#

setClass("OneFactorANOVA",
         contains="OneChannelModel",
         representation=representation(
            sampleAnnotationCollectionTestColumnName="character"),
         prototype=prototype(
            sampleAnnotationCollectionTestColumnName=character(0))
        )

OneFactorANOVA <-
    function(sampleAnnotationCollectionTestColumnName=character(0),
             numberOfTopReporters=-1L)
{
    new ("OneFactorANOVA",
         sampleAnnotationCollectionTestColumnName=sampleAnnotationCollectionTestColumnName,
         numberOfTopReporters=numberOfTopReporters)
}

#
# TwoFactorANOVA.
#

setClass("TwoFactorANOVA",
         contains="OneChannelModel",
         representation=representation(
                sampleAnnotationCollectionFactorOneColumnName="character",
                sampleAnnotationCollectionFactorTwoColumnName="character"),
         prototype=prototype(
                sampleAnnotationCollectionFactorOneColumnName=character(0),
                sampleAnnotationCollectionFactorTwoColumnName=character(0))
        )

sampleAnnotationCollectionFactorOneColumnName <-
    function(object, ...)
{
     slot(object, "sampleAnnotationCollectionFactorOneColumnName")
}

sampleAnnotationCollectionFactorTwoColumnName <-
    function(object, ...)
{
     slot(object, "sampleAnnotationCollectionFactorTwoColumnName")
}

TwoFactorANOVA <-
    function(sampleAnnotationCollectionFactorOneColumnName=character(0),
             sampleAnnotationCollectionFactorTwoColumnName=character(0),
             numberOfTopReporters=-1L)
{
    new ("TwoFactorANOVA",
         sampleAnnotationCollectionFactorOneColumnName=sampleAnnotationCollectionFactorOneColumnName,
         sampleAnnotationCollectionFactorTwoColumnName=sampleAnnotationCollectionFactorTwoColumnName,
         numberOfTopReporters=numberOfTopReporters)
}

#
# DyeSwapTTest.
#

setClass("DyeSwapTTest",
         contains="TwoChannelModel",
         representation=representation(
            sampleAnnotationCollectionTestColumnName="character",
            testReferenceLevel="character"),
         prototype=prototype(
            sampleAnnotationCollectionTestColumnName=character(0),
            testReferenceLevel=character(0))
        )

testReferenceLevel <- function(object, ...) {
     slot(object, "testReferenceLevel")
}

DyeSwapTTest <- function( sampleAnnotationCollectionTestColumnName=character(0),
                          testReferenceLevel=character(0),
                          numberOfTopReporters=-1L
                        )
{
    new ( "DyeSwapTTest",
          sampleAnnotationCollectionTestColumnName=sampleAnnotationCollectionTestColumnName,
          testReferenceLevel=testReferenceLevel,
          numberOfTopReporters=numberOfTopReporters)
}

#
# CommonReferenceANOVA. Similar to CommonReferenceTTest except that
# the test column is a 4-level factor or greater, one level of which is
# interpreted as a reference.
#

setClass("CommonReferenceANOVA",
         contains="TwoChannelModel",
         representation=representation(
            sampleAnnotationCollectionTestColumnName="character",
            testReferenceLevel="character"),
         prototype=prototype(
            sampleAnnotationCollectionTestColumnName=character(0),
            testReferenceLevel=character(0))
        )

CommonReferenceANOVA <-
    function( sampleAnnotationCollectionTestColumnName=character(0),
             testReferenceLevel=character(0),
             numberOfTopReporters=-1L )
{
    new ( "CommonReferenceANOVA",
          sampleAnnotationCollectionTestColumnName=sampleAnnotationCollectionTestColumnName,
          testReferenceLevel=testReferenceLevel,
          numberOfTopReporters=numberOfTopReporters )
}
