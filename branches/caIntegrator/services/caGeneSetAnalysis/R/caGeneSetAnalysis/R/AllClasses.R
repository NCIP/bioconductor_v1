#
# GeneSetAnalysisParameters
#

setClass("GeneSetAnalysisParameters",
         representation=representation(
            annotation="character"),
         prototype=prototype(
            annotation=character(0))
        )

annotation <- function(object, ...) {
    slot(object, "annotation")
}

GeneSetAnalysisParameters <- function(annotation=character(0))
{
    new ( "GeneSetAnalysisParameters",
             annotation=annotation )
}

#
# DiscreteGeneSetAnalysisParameters.
#

setClass("DiscreteGeneSetAnalysisParameters",
         contains="GeneSetAnalysisParameters",
         representation=representation(
            discretePValue="numeric",     # reporters with less than this pValue are 'selected'
            testDirection="character"),   # detect "over-represented" or "under-represented" terms
         prototype=prototype(
            discretePValue=0.05,
            testDirection="over-represented")
        )

discretePValue <- function(object, ...) {
    slot(object, "discretePValue")
}

testDirection <- function(object, ...) {
    slot(object, "testDirection")
}

DiscreteGeneSetAnalysisParameters <-
    function(annotation=character(0), discretePValue=0.05,
             testDirection="over-represented")
{
    new ( "DiscreteGeneSetAnalysisParameters",
                annotation=annotation,
                discretePValue=discretePValue,
                testDirection=testDirection )
}

#
# GeneOntologyDiscreteGeneSetAnalysisParameters.
#

setClass("GeneOntologyDiscreteGeneSetAnalysisParameters",
         contains="DiscreteGeneSetAnalysisParameters",
         representation=representation(
            ontology="character"),        # one of "BP", "CC" or "MF"
         prototype=prototype(
            ontology="BP")
        )

ontology <- function(object, ...) {
    slot(object, "ontology")
}

GeneOntologyDiscreteGeneSetAnalysisParameters <-
    function(annotation=character(0), discretePValue=0.05,
             testDirection="over-represented", ontology="BP")
{
    new ( "GeneOntologyDiscreteGeneSetAnalysisParameters",
                annotation=annotation,
                discretePValue=discretePValue,
                testDirection=testDirection,
                ontology=ontology )
}

#
# KEGGDiscreteGeneSetAnalysisParameters.
#

setClass("KEGGDiscreteGeneSetAnalysisParameters",
         contains="DiscreteGeneSetAnalysisParameters",
         representation=representation(),
         prototype=prototype()
        )

KEGGDiscreteGeneSetAnalysisParameters <-
    function(annotation=character(0), discretePValue=0.05,
             testDirection="over-represented")
{
    new ( "KEGGDiscreteGeneSetAnalysisParameters",
                annotation=annotation,
                discretePValue=discretePValue,
                testDirection=testDirection )
}

#
# PFAMDiscreteGeneSetAnalysisParameters.
#

setClass("PFAMDiscreteGeneSetAnalysisParameters",
         contains="DiscreteGeneSetAnalysisParameters",
         representation=representation(),
         prototype=prototype()
        )

PFAMDiscreteGeneSetAnalysisParameters <-
    function(annotation=character(0), discretePValue=0.05,
             testDirection="over-represented")
{
    new ( "PFAMDiscreteGeneSetAnalysisParameters",
                annotation=annotation,
                discretePValue=discretePValue,
                testDirection=testDirection )
}

#
# ContinousGeneSetAnalysisParameters.
#

setClass("ContinuousGeneSetAnalysisParameters",
         contains="GeneSetAnalysisParameters",
         representation=representation(
            minimumGenesPerGeneSet="integer"),
         prototype=prototype(
            minimumGenesPerGeneSet=0L)
        )

minimumGenesPerGeneSet <- function(object, ...) {
    slot(object, "minimumGenesPerGeneSet")
}

ContinuousGeneSetAnalysisParameters <-
    function(annotation=character(0), minimumGenesPerGeneSet=10L)
{
    new ( "ContinuousGeneSetAnalysisParameters",
                annotation=annotation,
                minimumGenesPerGeneSet=minimumGenesPerGeneSet )
}

#
# GeneOntologyContinuousGeneSetAnalysisParameters.
#

setClass("GeneOntologyContinuousGeneSetAnalysisParameters",
         contains="ContinuousGeneSetAnalysisParameters",
         representation=representation(
            ontology="character"),
         prototype=prototype(
            ontology="BP")
        )

GeneOntologyContinuousGeneSetAnalysisParameters <-
    function(annotation=character(0), minimumGenesPerGeneSet=10L,
             ontology="BP")
{
    new ( "GeneOntologyContinuousGeneSetAnalysisParameters",
                annotation=annotation,
                minimumGenesPerGeneSet=minimumGenesPerGeneSet,
                ontology=ontology )
}

#
# KEGGContinuousGeneSetAnalysisParameters.
#

setClass("KEGGContinuousGeneSetAnalysisParameters",
         contains="ContinuousGeneSetAnalysisParameters",
         representation=representation(),
         prototype=prototype()
        )

KEGGContinuousGeneSetAnalysisParameters <-
    function(annotation=character(0), minimumGenesPerGeneSet=10L)
{
    new ( "KEGGContinuousGeneSetAnalysisParameters",
                annotation=annotation,
                minimumGenesPerGeneSet=minimumGenesPerGeneSet )
}

#
# PFAMContinousGeneSetAnalysisParameters.
#

setClass("PFAMContinuousGeneSetAnalysisParameters",
         contains="ContinuousGeneSetAnalysisParameters",
         representation=representation(),
         prototype=prototype()
        )

PFAMContinuousGeneSetAnalysisParameters <-
    function(annotation=character(0), minimumGenesPerGeneSet=10L)
{
    new ( "PFAMContinuousGeneSetAnalysisParameters",
                annotation=annotation,
                minimumGenesPerGeneSet=minimumGenesPerGeneSet )
}

#
# GeneSetAnalysisResultCollection.
#

setClass("GeneSetAnalysisResultCollection",
         representation=representation(
            description="character",
            geneSetId="character",           # IDs of the GeneSets enriched
            geneSetSize="integer",           # number of genes annotated in the GeneSet
            pValue="numeric",                # statistical significance of result
            geneSetMembers="list"),          # each element of list is a vector of
                                             # gene IDs belonging to the corresponding
                                             # GeneSet
         prototype=prototype(
            description=character(0),
            geneSetId=character(0),
            geneSetSize=integer(0),
            pValue=numeric(0),
            geneSetMembers=list(0))
        )

GeneSetAnalysisResultCollection <-
    function(description=character(0),
             geneSetId=character(0),
             geneSetSize=integer(0),
             pValue=numeric(0),
             geneSetMembers=list(0))
{
    new ( "GeneSetAnalysisResultCollection",
            description=description,
            geneSetId=geneSetId,
            geneSetSize=geneSetSize,
            pValue=pValue,
            geneSetMembers=geneSetMembers )
}

description <- function(object, ...) {
    slot(object, "description")
}

geneSetId <- function(object, ...) {
    slot(object, "geneSetId")
}

geneSetSize <- function(object, ...) {
    slot(object, "geneSetSize")
}

pValue <- function(object, ...) {
    slot(object, "pValue")
}

geneSetMembers <- function(object, ...) {
    slot(object, "geneSetMembers")
}

#
# DiscreteGeneSetAnalysisResultCollection.
#

setClass("DiscreteGeneSetAnalysisResultCollection",
         contains="GeneSetAnalysisResultCollection",
         representation=representation(
            selectedCount="integer",    # number of selected genes in the GeneSet
            expectedCount="integer"),   # expected number of genes in the GeneSet
         prototype=prototype(
            selectedCount=integer(0),
            expectedCount=integer(0))
        )

selectedCount <- function(object, ...) {
    slot(object, "selectedCount")
}

expectedCount <- function(object, ...) {
    slot(object, "expectedCount")
}

DiscreteGeneSetAnalysisResultCollection <-
    function(
             description=character(0),
             geneSetId=character(0),
             geneSetSize=integer(0),
             pValue=numeric(0),
             geneSetMembers=list(0),
             selectedCount=integer(0),
             expectedCount=integer(0) )
{
    new ( "DiscreteGeneSetAnalysisResultCollection",
            description=description,
            geneSetId=geneSetId,
            geneSetSize=geneSetSize,
            pValue=pValue,
            geneSetMembers=geneSetMembers,
            selectedCount=selectedCount,
            expectedCount=expectedCount )
}

#
# ContinuousGeneSetAnalysisResultCollection.
#

setClass("ContinuousGeneSetAnalysisResultCollection",
         contains="GeneSetAnalysisResultCollection",
         representation=representation(
             adjustedTStatistic="numeric"),
         prototype=prototype(
             adjustedTStatistic=numeric(0))
        )

adjustedTStatistic <- function(object, ...) {
    slot(object, "adjustedTStatistic")
}

ContinuousGeneSetAnalysisResultCollection <-
    function( description=character(0),
              geneSetId=character(0),
              geneSetSize=integer(0),
              pValue=numeric(0),
              geneSetMembers=list(0),
              adjustedTStatistic=numeric(0)
            )
{
    new ( "ContinuousGeneSetAnalysisResultCollection",
            description=description,
            geneSetId=geneSetId,
            geneSetSize=geneSetSize,
            pValue=pValue,
            geneSetMembers=geneSetMembers,
            adjustedTStatistic=adjustedTStatistic
        )
}
