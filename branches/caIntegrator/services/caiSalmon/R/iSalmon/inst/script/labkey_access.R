library(iSalmon)
## not-yet-exported
.labkeySelect <- iSalmon:::.labkeySelect
.labkeySql <- iSalmon:::.labkeySql

## Discovery
labkeyTables()                          # all known tables
labkeyFields()                          # all tables & fields
labkeyFields("Ovarian_Samples")         # fields from table 'Ovarian_Samples'


## simple SELECT
flds <- c("sample_Id", "matched_Norm_Id", "hugo_Symbol",
          "variant_Classification", "variant_Type")
res <- .labkeySelect("Ovarian_SomaticMutations_Level3", flds)
res <- .labkeySelect("Ovarian_SomaticMutations_Level3", flds, verbose=TRUE)

flds <- labkeyFields("Ovarian_SomaticMutations_Level3",
                     qualify=TRUE)[[1]]
res <- .labkeySelect("Ovarian_SomaticMutations_Level3",
                     flds[c(2:4, 12:13)], verbose=TRUE)

## INNER JOIN
mflds <-
    labkeyFields("Ovarian_SomaticMutations_Level3", qualify=TRUE)[[1]]
oflds <-
    labkeyFields("Ovarian_Samples", qualify=TRUE)[[1]]
sql <- sprintf("SELECT %s FROM %s INNER JOIN %s ON (%s = %s)",
               paste(mflds[c(2:4, 12:13)], collapse=", "),
               "Ovarian_SomaticMutations_Level3",
               "Ovarian_Samples",
               mflds[2], oflds[1])
cat("\n", noquote(paste(strwrap(sql, exdent=4), collapse="\n")), "\n")
res <- .labkeySql(sql, verbose=TRUE)

## integrate with R
barcodes <- .labkeySelect("Ovarian_Samples", "BCRSAMPLEBARCODE")
where <- sprintf("WHERE %s IN ('%s')",
                 "Ovarian_CopyNumber_level3.sampleId",
                 paste(head(unique(barcodes))[[1]], collapse="', '"))
flds <- c("seg_mean", "start", "stop", "chromosome", "sampleId")
res <- .labkeySelect("Ovarian_CopyNumber_level3", fields=flds,
                     sqlSuffix=where)
library(latticeExtra)
segplot(seg_mean ~ start + stop | factor(chromosome),
        res[res$sampleId == res$sampleId[1],], lwd=2)

flds <- labkeyFields("miRNATranscriptionFactors")[2:3]
