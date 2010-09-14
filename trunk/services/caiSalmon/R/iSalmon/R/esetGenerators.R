## One script for miRNA and one for mRNA.  Both of these make
## ExpressionSet objects using affy and data that is already
## normalized.  The data is in this directory as well This one is
## miRNA and the other is mRNA.  There is no simpleLimma here for
## mRNA, the espression was only needed to run corr() so that the mRNA
## and miRNA can be compared.

SangerMiRNAGenerateESet <-
    function()
{
    ## Files:
    fl <- "http://isalmon.fhcrc.org/labkey/_webdav/home/RestrictedData/SangerData/%40files/Sanger800_miRNA.stl.txt" 
    fl2 <- "http://isalmon.fhcrc.org/labkey/_webdav/home/RestrictedData/SangerData/%40files/Sanger_miR_data1.pn.cn.matlab2.res.txt"
    fl3 <- "http://isalmon.fhcrc.org/labkey/_webdav/home/RestrictedData/SangerData/%40files/mt_tissue.cell.line.mut_wide.info.DN.txt" 

    reader <- basicTextGatherer()
    header <- basicTextGatherer()
    myopts <- curlOptions(writefunction=reader$update,
                          headerfunction=header$update, httpauth=1L, netrc=1,
                          ssl.verifyhost=FALSE, ssl.verifypeer=FALSE,
                          followlocation=TRUE, verbose=TRUE)
    handle <- getCurlHandle()

    ## phenoData
    con = textConnection(getURLContent(fl, .opts=myopts, curl=handle),"")
    header <- scan(con, what=character(), sep="\t", n=13)
    tbl <- read.csv(con, header=FALSE, skip=2, sep="\t")

    names(tbl) <- sub("(.*):.*", "\\1", header)
    idx <- grepl(":", header)
    h0 <- lapply(strsplit(sub(".*:", "", header[idx]), "/"), function(elt) {
        id <- as.integer(sub("-.*$", "", elt))
        names(id) <- sub(".*-", "", elt)
        id
    })
    names(h0) <- names(tbl)[idx]
    for (col in names(h0)) {
        if (col == "CellLineCode") {
        } else {
            nms <- names(h0[[col]])
            ids <- match(tbl[[col]], h0[[col]])
            tbl[[col]] <- factor(nms[ids], levels=nms)
        }
    }
    rownames(tbl) <- tbl[["Scan"]]
    tbl <- tbl[,-match("Scan", names(tbl))]

    ## expression values and p/a
    con = textConnection(getURLContent(fl2, .opts=myopts, curl=handle),"")

    header <- strsplit(readLines(con, 1), "\t")[[1]]
    df <- read.csv(con, header=FALSE, skip=2, sep="\t")
    close(con)

    pd <- df[,1:2]
    pa <- as.matrix(df[,-(1:2)][,c(FALSE, TRUE)])
    pe <- data.frame(df[,-(1:2)][,c(TRUE, FALSE)])

    names(pd) <- header[1:2]
    ## CHANGE: instead of Accession, read Description but "Description" makes
    ## probes collapse so keep Accession for now
    dimnames(pa) <- dimnames(pe) <-
        list(pd$Accession, header[-(1:2)][c(TRUE, FALSE)])

    ## NEW ADDED ##
    pd <- pd
    rownames(pd) <- pd$Accession
    ## featureData <- new("AnnotatedDataFrame", data = pd)
    ## This is very imp since not all samples in tbl have exp data
    tbl = tbl[rownames(tbl) %in% colnames(pe),]
    ## read the file with tissue, mutation data
    con = textConnection(getURLContent(fl3, .opts=myopts, curl=handle),"")
    fb <- read.table(con, header=TRUE)
    close(con)
    ## add a column CellLine to existing data 
    tbl['CellLine'] = substr(tbl$Name,6,length(tbl$Name))
    tbl['Rownames'] <- rownames(tbl)
    ## use only the ones for which tissues have been selected by us (read as
    ## fb)
    tbl = tbl[tbl$CellLine %in% fb$cell.line ,]
    ## merge these two, the new df has 'CellLine' and not "cell.line")
    ntbl <-merge(tbl,fb,by.x = "CellLine",by.y = "cell.line", all.x = TRUE,
                 na.rm = TRUE)
    untbl <- unique(ntbl)
    ## lost row names in merge, add them back
    rownames(untbl) <- untbl$Rownames
    tbl <- untbl
    ## take average over all replicate cell lines,
    ## taking cell line names from tbl, make pe equal to tbl

    ## problem with doing avg, wastes a lot of memory
    cancer.cell.lines <- unique(substr(tbl$Name,6,length(tbl$Name)))
    pe_avg = list()
    tbl_avg = list()
    for (cell.line.name in cancer.cell.lines) {
        idx <- substr(tbl$Name,6,length(tbl$Name)) == cell.line.name
        cell.line.scans <-rownames(tbl)[idx]
        cell.line.data <- subset(pe, select=cell.line.scans)
        tbl_sel <- tbl[rownames(tbl) %in% cell.line.scans,]

        ## get the mean expression for each gene/mir across scans
        cell.line.data.avg <- apply(cell.line.data, 1, mean)

        pe_avg <- c(pe_avg, list(cell.line.data.avg))
                                        #write only one
		tbl_data <- tbl_sel[1,]
        tbl_avg <- rbind(tbl_avg,tbl_data)
		tbl_data <- NULL
		cell.line.data.avg <- NULL
    }
    pe_avg <- as.data.frame(pe_avg)
    tbl_avg <- as.data.frame(tbl_avg)
    colnames(pe_avg) <- cancer.cell.lines
    rownames(tbl_avg) <- cancer.cell.lines
    ## Add cp data here
    pe_avg <- data.matrix(pe_avg)

    ## average over replicate probes or take the maximum variation
    gene.names <- as.vector(unique(pd$Description))

    pe_probes = list()
    for (gene in gene.names) {

        probes <- as.vector(pd$Accession[pd$Description == gene])
        rows <- subset(pe_avg, rownames(pe_avg) %in% probes)
        ## take the one with max expression over the row
        row.avg <- apply(rows, 2, mean)
        pe_probes <- rbind(pe_probes, row.avg)
        ## write only one
    }

    pe_probes <- as.data.frame(pe_probes)
    rownames(pe_probes) <- gene.names
    pe_probes <- data.matrix(pe_probes)
    pd <- list()
    pd$Accession <-gene.names
    pd$Description <-gene.names
    pd <- as.data.frame(pd)
    rownames(pd) <- pd$Description

    featureData <- new("AnnotatedDataFrame", data = pd)

    phenoData <- new("AnnotatedDataFrame",
                     data=tbl_avg[rownames(tbl_avg) %in% colnames(pe_probes),])
    new("ExpressionSet",
        assayData=assayDataNew(exprs=pe_probes),
        phenoData=phenoData, featureData = featureData)
}

#########################################
## Usage (just to get this object back)
## miRNAeset = SangerMiRNAGenerateESet()

SangerMRNAGenerateESet <-
    function()
{

    ##
    ## Create the 'phenoData', i.e., the annotations on the samples
    ## (columns) of the ExpressionSet
    ##

    
    ## read in some data from labkey
    fl <- "http://isalmon.fhcrc.org/labkey/_webdav/home/RestrictedData/SangerData/%40files/Sanger_affy_n798_sample_info_published.csv" 
    fl2 <- "http://isalmon.fhcrc.org/labkey/_webdav/home/RestrictedData/SangerData/%40files/Sanger_Cell_Line_Project_Affymetrix_QCed_Data_n798.gct.txt"
    fl3 <- "http://isalmon.fhcrc.org/labkey/_webdav/home/RestrictedData/SangerData/%40files/mt_tissue.cell.line.mut_wide.info.DN.txt" 

    reader <- basicTextGatherer()
    header <- basicTextGatherer()
    myopts <- curlOptions(writefunction=reader$update,
                          headerfunction=header$update, httpauth=1L, netrc=1,
                          ssl.verifyhost=FALSE, ssl.verifypeer=FALSE,
                          followlocation=TRUE, verbose=TRUE)
    handle <- getCurlHandle()

    ## phenoData
    con = textConnection(getURLContent(fl, .opts=myopts, curl=handle),"")

    ## fl <- file.path(dir$extdata,
    ##                 "Sanger_affy_n798_sample_info_published.csv")
    ## con <- file(fl, "r")
    header <- scan(con, what=character(), sep=",", n=19)
    tbl <- read.csv(con, header=FALSE)
    close(con)

    ## the 'header' includes factor information; create a map 'h0'
    ## containing the levels of each column that is a factor
    names(tbl) <- sub("(.*):.*", "\\1", header)
    tbl <- tbl[,-19]
    idx <- grepl(":", header)
    h0 <- lapply(strsplit(sub(".*:", "", header[idx]), "/"), function(elt) {
        id <- as.integer(sub("-.*$", "", elt))
        names(id) <- sub(".*-", "", elt)
        id
    })
    names(h0) <- names(tbl)[idx]

    ## recode the relevant columns as factors
    for (col in names(h0)) {
        nms <- names(h0[[col]])
        ids <- match(tbl[[col]], h0[[col]])
        tbl[[col]] <- factor(nms[ids], levels=nms)
    }


    ## Move 'Scan' to be the row name; it's a unique identifier
    rownames(tbl) <- tbl[["Scan"]]
    tbl <- tbl[,-match("Scan", names(tbl))]

    ##
    ## Read in the expression data
    ##

    ## first two columns are character, next 798 are numeric, so create
    ## list 'what' containing this information
    what <- replicate(800, numeric(), simplify=FALSE)
    what[1:2] <- list(character(), NULL)
    ## read the headers separately, then skip two lines and read the
    ## matrix
    ## con <- file(list.files(dir$extdata, "Sanger.*gct"), "r")
    con = textConnection(getURLContent(fl2, .opts=myopts, curl=handle),"")
    tmp <- readLines(con, 2);
    nms <- strsplit(readLines(con, 1), "\t")[[1]]
    tb <- scan(con, what=what)
    close(con)

    ## create the expression values from the data (other than the first
    ## two columns); use the first column as the row name and the file
    ## name (without '.CEL') as the sample name
    exprs <- matrix(log2(do.call(c, tb[-(1:2)])), ncol=length(tb)-2,
                    dimnames=list(tb[[1]], sub(".CEL", "", nms[-(1:2)])))

    ##
    ## Now combine phenoData and exprs into an ExpressionSet
    ##

    
    ##Added by kavita garg
    ##add mutational info to the phenodata
    ##tb <-tbl
    ## This is very imp since not all samples in tbl have exp data, they only
    ## match if they are in same order
    tbl = tbl[colnames(exprs),]
    ##read the file with tissue, mutation data
    con = textConnection(getURLContent(fl3, .opts=myopts, curl=handle),"")
    fb <- read.table(con, header=TRUE)
    ##add a column CellLine to existing data
    tbl['Rownames'] <- rownames(tbl)
    ##use only the ones for which tissues have been selected by us (read as fb)
    tbl = tbl[tbl$SampleName %in% fb$cell.line,]
    ##merge these two, the new df has 'CellLine' and not "cell.line")
    ntbl <-merge(tbl,fb,by.x = "SampleName",by.y = "cell.line", all.x = TRUE,
                 na.rm = TRUE)
    untbl <- unique(ntbl)
    ##lost row names in merge, add them back
    rownames(untbl) <- untbl$Rownames
    tbl <- untbl
    
    library(Biobase)

    ## create an 'AnnotatedDataFrame' with the phenotypic data; arrange
    ## for the data rows to be in the same order as the expression matrix
    ## columns
    exprs = exprs[,rownames(tbl)]
    
    ## create an 'AnnotatedDataFrame' with the phenotypic data; arrange
    ## for the data rows to be in the same order as the expression matrix
    ## columns
    phenoData <- new("AnnotatedDataFrame", data=tbl[colnames(exprs),])

    ## use the AnnotatedDataFrame and expression matrix to create the
    ## ExpressionSet
    new("ExpressionSet", exprs=exprs, phenoData=phenoData)
}

#########################################
## Usage (just to get this object back)
## mRNA_eset = SangerMRNAGenerateESet()

  
