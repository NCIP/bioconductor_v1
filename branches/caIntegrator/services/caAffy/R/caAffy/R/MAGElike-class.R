setClass("BioAssays")

setClass("MeasuredBioAssays",
         representation=representation(
           bioAssays="NumericMatrix"))

setClass("MeasuredBioAssayLocal",
         contains=c("BioAssays"),
         representation=representation(
           bioAssays="character"))

setClass("DerivedBioAssays",
         contains=c("BioAssays"),
         representation=representation(
           bioAssays="NumericMatrix"))

setAs("MeasuredBioAssayLocal", "AffyBatch",
      function(from)
      ReadAffy(filenames=from@bioAssays))

setAs("DerivedBioAssays", "matrix",
      function(from)
      as(slot(from, "bioAssays"), "matrix"))

setAs("DerivedBioAssays", "ExpressionSet",
      function(from)
      new("ExpressionSet", exprs=as(from, "matrix")))

setAs("exprSet", "DerivedBioAssays",
      function(from)
      new("DerivedBioAssays", bioAssays=as(exprs(from), "NumericMatrix")))

setAs("ExpressionSet", "DerivedBioAssays",
      function(from)
      new("DerivedBioAssays", bioAssays=as(exprs(from), "NumericMatrix")))
