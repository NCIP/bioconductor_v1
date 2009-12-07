#
# S4 class Filter; base class for all filters.
#

setClass("Filter",
         representation=representation(),
         prototype=prototype()
        )

Filter <- function()
{
    new ("Filter")
}

#
# S4 class AnnotationFilter; class from which all
# annotation filters are derived.
#

setClass("AnnotationFilter",
         contains="Filter",
         representation=representation(
            annotation="character"),
         prototype=prototype(
            annotation=character(0))
        )

AnnotationFilter <- function(annotation=character(0))
{
    new ("AnnotationFilter", annotation=annotation)
}

annotation <- function(object, ...) {
    slot(object, "annotation")
}

#
# S4 class Recode: base class for all recodes.
#

setClass("Recode",
         representation=representation(recodeValue="numeric"),
         prototype=prototype(recodeValue=-Inf)
        )

Recode <- function(recodeValue=numeric(0))
{
    new ("Recode", recodeValue=recodeValue)
}

recodeValue <- function(object, ...) {
    slot(object, "recodeValue")
}

#
# KOverAFilter
#

setClass("KOverAFilter",
         contains="Filter",
         representation=representation(
            minimumValue="numeric", minimumElementNumber="integer"),
         prototype=prototype(
            minimumValue=-Inf, minimumElementNumber=0L)
         )

KOverAFilter <- function(minimumValue=-Inf, minimumElementNumber=0L)
{
    new ("KOverAFilter", minimumValue=minimumValue,
         minimumElementNumber=minimumElementNumber)
}

minimumValue <- function(object, ...) {
    slot(object, "minimumValue")
}

minimumElementNumber <- function(object, ...) {
    slot(object, "minimumElementNumber")
}

#
# VarianceFilter 
#

setClass("VarianceFilter",
         contains="Filter",
         representation=representation(
            minimumVariance="numeric"),
         prototype=prototype(minimumVariance=0.5)
        )

VarianceFilter <- function(minimumVariance=0.5)
{
    new ("VarianceFilter", minimumVariance=minimumVariance)
}

minimumVariance <- function(object, ...) {
    slot(object, "minimumVariance")
}

#
# GeneOntologyFilter
#

setClass("GeneOntologyFilter",
         contains="AnnotationFilter",
         representation=representation(
            isBiologicalProcess="logical",
            isCellularCompartment="logical",
            isMolecularFunction="logical"),
         prototype=prototype(
            isBiologicalProcess=FALSE,
            isCellularCompartment=FALSE,
            isMolecularFunction=FALSE)
        )

GeneOntologyFilter <-
    function(annotation=character(0), 
             isBiologicalProcess=FALSE,
             isCellularCompartment=FALSE,
             isMolecularFunction=FALSE)
{
    new ("GeneOntologyFilter",
         annotation=annotation,
         isBiologicalProcess=isBiologicalProcess,
         isCellularCompartment=isCellularCompartment,
         isMolecularFunction=isMolecularFunction)
}

isBiologicalProcess <- function(object, ...) {
    slot(object, "isBiologicalProcess")
}

isCellularCompartment <- function(object, ...) {
    slot(object, "isCellularCompartment")
}

isMolecularFunction <- function(object, ...) {
    slot(object, "isMolecularFunction")
}

#
# EntrezFilter
#

setClass("EntrezFilter",
         contains="AnnotationFilter"
        )

EntrezFilter <- function(annotation=character(0))
{
    new ("EntrezFilter", annotation=annotation)
}

#
# MissingValueFilter
#

setClass("MissingValueFilter",
         contains="Filter",
         representation=representation(
            missingValue="numeric",
            minimumElementNumber="integer"),
         prototype=prototype(
            missingValue=as.numeric(NA),
            minimumElementNumber=0L)
        )

MissingValueFilter <- function(missingValue=as.numeric(NA),
                               minimumElementNumber=0L)
{
    new ("MissingValueFilter",
         missingValue=missingValue,
         minimumElementNumber=minimumElementNumber)
}

missingValue <- function(object, ...) {
    slot(object, "missingValue")
}

#
# MinimumThresholdRecode
#

setClass("MinimumThresholdRecode",
         contains="Recode",
         representation=representation(
            minimumThreshold="numeric"),
         prototype=prototype(
            minimumThreshold=-Inf)
        )

MinimumThresholdRecode <-
    function(minimumThreshold=-Inf, recodeValue=minimumThreshold)
{
    new ("MinimumThresholdRecode", 
         minimumThreshold=minimumThreshold,
         recodeValue=recodeValue)
}

minimumThreshold <- function(object, ...) {
    slot(object, "minimumThreshold")
}

#
# MaximumThresholdRecode
#

setClass("MaximumThresholdRecode",
         contains="Recode",
         representation=representation(
            maximumThreshold="numeric"),
         prototype=prototype(
            maximumThreshold=Inf)
        )

MaximumThresholdRecode <-
    function(maximumThreshold=Inf, recodeValue=maximumThreshold)
{
    new ("MaximumThresholdRecode", 
         maximumThreshold=maximumThreshold,
         recodeValue=recodeValue)
}

maximumThreshold <- function(object, ...) {
    slot(object, "maximumThreshold")
}

#
# SpotQualityRecode
#

setClass("SpotQualityRecode",
         contains="Recode",
         representation=representation(
            columnIdentifier="character",
            columnMinimumThresholdValue="numeric"),
         prototype=prototype(
            columnIdentifier=character(0),
            columnMinimumThresholdValue=-Inf)
        )

SpotQualityRecode <- function(columnIdentifier=character(0),
                              columnMinimumThresholdValue=-Inf,
                              recodeValue=-Inf)
{
    new("SpotQualityRecode", 
             columnIdentifier=columnIdentifier,
             columnMinimumThresholdValue=columnMinimumThresholdValue,
             recodeValue=recodeValue)
}

columnIdentifier <- function(object, ...) {
    slot(object, "columnIdentifier")
}

columnMinimumThresholdValue <- function(object, ...) {
    slot(object, "columnMinimumThresholdValue")
}
