testCaPROcess <- function() {
    ## side effect: mzDataCollection
    data("mzAssays")
##     load(system.file(file.path("data","mzAssays.rda"), package="caPROcess"))
    res <- caPROcess(mzAssays, new("PROcessParameter"))
    checkTrue(all(slot(res, "spectrumId")==c(rep(1, 12), rep(2, 8))))
    checkTrue(all.equal(slot(res, "relativeIntensity"),
                        c(12.119356, 13.350157, 15.445767, 30.590683, 12.594895, 10.295219, 12.318448,
                          16.112402, 15.541255, 8.606315, 16.535589, 26.856742, 17.065868, 21.256895,
                          46.277682, 18.337425, 12.514718, 9.342795, 22.061111, 28.909793),
                        tolerance=1.e-4))
}
