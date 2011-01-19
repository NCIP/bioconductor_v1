library("caPROcess")
library("RUnit")

options(warn=1)

allSuite <- defineTestSuite(name="allSuite",
                            dirs=system.file("unitTests", package="caPROcess"),
                            testFileRegexp=".*_test\\.R$",
                            rngKind="default",
                            rngNormalKind="default")

testData <- runTestSuite(allSuite)
printTextProtocol(testData, showDetails=FALSE)

