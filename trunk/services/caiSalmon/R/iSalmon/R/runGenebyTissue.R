TopTableSingleTissueSingleMutgene <-function(miEset,input.tissue,mut.gene, outDir="."){
  QVAL_CUTOFF = 0.2

  ## make a MUT_WILD and an ERROR subdir
  if(!file.exists('./MUT_WILD')){dir.create(paste(outDir,"/MUT_WILD",sep=""))}
  if(!file.exists('./ERROR')){dir.create(paste(outDir,"/ERROR",sep=""))}
  ## mutation status of untesteds:
  tissue_output_file <-  paste(outDir,"/MUT_WILD/",mut.gene,".txt",sep = "")  
  ## all genes that were affected:
  combine.output.file = paste(outDir,"/all_genes_",input.tissue,sep = "")     
  ## toptable outputs for genes that are testable:
  outfile = paste(outDir,"/",mut.gene,"_toptable.txt",sep = "")               
  ## output errors (reasons) for genes that were not testable:
  nooutfile = paste(outDir,"/ERROR/",mut.gene,"_toptable.txt",sep = "")       
  
  ## Write the header onto all_file
  all_file <- file(combine.output.file,"w")
  Lines <- paste("Gene Tissue mir logFC adjP.Val ",
                 "AveExpr MutSamples WildSamples", sep="")
  writeLines(Lines,con = all_file)

  miR_list <- c("hsa")
  miR_list_grep <- paste(miR_list,collapse = "|")
  miEsetHsTisSp <- miEset[c(grep(miR_list_grep,
                                 as.vector(fData(miEset)$Description))),
                          !is.na(as.vector(miEset$Category))
                          & miEset$Category == "Sanger"
                          & !is.na(as.vector(miEset$tissue.name))
                          & miEset$tissue.name == input.tissue
                          & !is.na(as.vector(miEset[[mut.gene]]))
                          & (miEset[[mut.gene]] == "wt"
                             | miEset[[mut.gene]] == "aa.mut")]

  fData(miEsetHsTisSp)$mir = paste(fData(miEsetHsTisSp)$Description,
                        "_",fData(miEsetHsTisSp)$Accession, sep = "")
  miEsetHsTisSp$mut.gene <- miEsetHsTisSp[[mut.gene]]
  fmean <- apply(exprs(miEsetHsTisSp),1,mean)
  fData(miEsetHsTisSp)$mean = fmean
  max <-apply(exprs(miEsetHsTisSp),1,max)
  fData(miEsetHsTisSp)$max = max
  ## Atleast expressed in one cell line
  miEsetHsTisSp_filter <- miEsetHsTisSp[fData(miEsetHsTisSp)$max >= 5
                                        & fData(miEsetHsTisSp)$mean >= 4.5,]
  psel.tissue <- pData(miEsetHsTisSp_filter)
  final_cell_lines <- length(rownames(psel.tissue))

  f <- factor(miEsetHsTisSp_filter$mut.gene,
              unique(sort(miEsetHsTisSp_filter[[mut.gene]])))
  ## design[,2] is wt
  if( length(rownames(psel.tissue)) > 7 && length(levels(f)) > 1 ){ 
    design <- model.matrix(~0+f)
    dw <- subset(design,design[,2] == 1)
    dm <- subset(design,design[,2] == 0)
    ## Atleast 4 mut and 4 wild type samples
    if( length(rownames(dw)) > 3 && length(rownames(dm)) > 3 ){
      wild <-colnames(design)[2]
      mut <-colnames(design)[1]
      matString<-c(paste(mut,"-",wild,sep=""),paste(wild,"-",mut, sep=""))
      contrast.matrix <- makeContrasts(contrasts = matString, levels=design)
      f1 <- lmFit(miEsetHsTisSp_filter,design)
      f1 <- contrasts.fit(f1, contrast.matrix)
      f2 <- eBayes(f1)
      ## p.value is cutoff for adj p-value
      n <- length(as.vector(featureData(miEsetHsTisSp_filter)$Accession))
      output <- topTable(f2, adjust = "fdr", number = n) 
      down_in_mut <- subset(output,faa.mut.fwt < 0 & adj.P.Val < QVAL_CUTOFF
                            & abs(faa.mut.fwt) > 1)
      up_in_mut <- subset(output,faa.mut.fwt > 0 & adj.P.Val < QVAL_CUTOFF
                          & abs(faa.mut.fwt) > 1 )
      n_down <-length(down_in_mut$Accession)
      n_up <-length(up_in_mut$Accession)
      write.table(output,outfile, quote=F, sep="\t",row.names=F)
      if( n_up > 0 ){
        ULines <- paste(mut.gene,
                        input.tissue,
                        up_in_mut$mir,
                        up_in_mut$faa.mut.fwt,
                        up_in_mut$adj.P.Val,
                        up_in_mut$AveExpr,
                        length(rownames(dm)),
                        length(rownames(dw)),
                        sep = " ")
        writeLines(ULines,con = all_file)
      }
      if( n_down > 0 ) {
        DLines <- paste(mut.gene,input.tissue,
                        down_in_mut$mir,
                        down_in_mut$faa.mut.fwt,
                        down_in_mut$adj.P.Val,
                        down_in_mut$AveExpr,
                        length(rownames(dm)),
                        length(rownames(dw)),
                        sep = " ")
        writeLines(DLines,con = all_file)
      }
    } else {
      write("contrasts can be applied only to factors with 2 or more levels",
            nooutfile)
    }
    
  } else {
    write("contrasts can be applied only to factors with 2 or more levels",
          nooutfile)
  }
  ## tissue info
  tissue.name <- as.vector(psel.tissue$tissue.name)
  cellline.name <- psel.tissue$CellLine
  sample <- as.vector(psel.tissue$Scan)
  mut <- as.vector(psel.tissue$mut.gene)
  
  tissue.info <- cbind(as.vector(tissue.name),
                       as.vector(cellline.name),
                       as.vector(sample),
                       as.vector(mut))
  tissue.info.s = tissue.info[order(tissue.info[,3],decreasing = TRUE),]
  write.table(tissue.info.s,tissue_output_file)
  close(all_file)
  return (miEsetHsTisSp_filter)
}




## # Examples of usage:
## # 1st we need an eset object
## miEset <- SangerMiRNAGenerateESet()
## # This example will produce a result
## input.tissue = "stomach_non_small_cell_cancer"
## mut.gene = "pik3ca"
## TopTableSingleTissueSingleMutgene(miEset,input.tissue,mut.gene)


## ## This one won't
## input.tissue = "stomach_non_small_cell_cancer"
## mut.gene = "apc"
## TopTableSingleTissueSingleMutgene(miEset,input.tissue,mut.gene)

## known requirements:
## library(limma)
## library(affy)
## library(genefilter)
## require(iSalmon)
