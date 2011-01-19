testCaExpresso <- function() {
    data(affybatch.example)
    bioAssays <- exprs(affybatch.example)
    dbads <- new("DerivedBioAssays",
                 bioAssays=new("NumericMatrix", bioAssays))
    res <- caExpresso(dbads, "cdfenv.example", new("ExpressoParameter"))

    checkTrue(class(res)=="DerivedBioAssays")
    checkTrue(all(dim(res@bioAssays)==c(150,3)))
    checkEquals(as.vector(apply(res@bioAssays, 2, sum)),
                c(10637.720, 8629.103, 9668.019), tolerance=0.01)
    checkEquals(rownames(res@bioAssays)[1:4],
                c("A28102_at", "AB000114_at","AB000115_at","AB000220_at"))
}
