.defaultLabkey <-
    structure(c(baseUrl="https://isalmon.fhcrc.org/labkey",
                folderPath="/home/SharedData", schemaName="lists"),
              class="RlabkeyResource")

.knownTables <- local({
    ## labkey 'schemas' are too comprehensive; need just the 'queries'
    ## labkey 'queries' are what 
    ##   schemas <- labkey.getSchemas(baseUrl="https://isalmon.fhcrc.org/labkey",
    ##                                folderPath="/home/SharedData")
    query <- labkey.getQueries(baseUrl=.defaultLabkey[["baseUrl"]],
                               folderPath=.defaultLabkey[["folderPath"]],
                               schemaName=.defaultLabkey[["schemaName"]])
    ## FIXME: remove 'hidden' fields, e.g., RowId
    qlist <- split(query[,2], query[,1])
    l2e(qlist, new.env(parent=emptyenv()))
})

labkeyTables <-
    function(labkey=.defaultLabkey)
{
    stopifnot(is(labkey, "RlabkeyResource"))
    ls(.knownTables)
}

labkeyFields <- 
    function(tables=labkeyTables(), labkey=.defaultLabkey,
             qualify=FALSE)
{
    stopifnot(is.character(tables), length(tables) != 0L)
    stopifnot(is(labkey, "RlabkeyResource"))
    stopifnot(is.logical(qualify), length(qualify) == 1L)
    flds <- mget(tables, .knownTables)
    if (qualify)
        flds <- mapply(paste, names(flds), flds,
                       MoreArgs=list(sep="."), SIMPLIFY=FALSE)
    flds
}

.labkeySql <-
    function(sql, labkey=.defaultLabkey, verbose=FALSE)
{
    stopifnot(is.character(sql), length(sql) == 1L)
    stopifnot(is(labkey, "RlabkeyResource"))
    stopifnot(is.logical(verbose), length(verbose)==1L)
    if (verbose)
        message(noquote(paste(strwrap(c(sql, "\n"), indent=2, exdent=2),
                              collapse="\n")))
    labkey.executeSql(baseUrl=labkey[["baseUrl"]],
                      folderPath=labkey[["folderPath"]],
                      schemaName=labkey[["schemaName"]],
                      sql=sql)
}

.labkeySelect <-
    function(table, fields=labkeyFields(table, labkey)[[1]],
             sqlSuffix=character(0), labkey=.defaultLabkey,
             verbose=FALSE)
{
    stopifnot(is.character(table), length(table) != 0L)
    stopifnot(is.character(fields), length(fields) != 0L)
    stopifnot(is(labkey, "RlabkeyResource"))
    stopifnot(all(fields %in%
                  c(labkeyFields(table, labkey)[[1]],
                    labkeyFields(table, labkey, qualify=TRUE)[[1]])))
    if (missing(sqlSuffix))
        sqlSuffix <- ""
    stopifnot(is.character(sqlSuffix), length(sqlSuffix) == 1L)
    ## maybe qualify field names
    qualifier <- sprintf("^%s\\.", table)
    qfields <- ifelse(grepl(qualifier, fields), fields,
                      paste(table, fields, sep="."))
    sql <- sprintf("SELECT %s FROM %s %s",
                   paste(qfields, collapse=", "),
                   table, sqlSuffix)
    df <- .labkeySql(sql, labkey=labkey, verbose=verbose)
    names(df) <- fields
    df
}
