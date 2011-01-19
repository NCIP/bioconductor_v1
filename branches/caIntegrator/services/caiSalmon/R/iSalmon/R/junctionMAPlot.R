junctionMAPlot <-
    function(x, data, pval, pthresh, ...,
             ppch=46, pcex=2,
             xlab="Log2 Average Count",
             ylab="log2 fold change (Case - Control)")
{
    xyplot(x, data, pval=pval, pthresh=pthresh, xlab=xlab, ylab=ylab,
           panel=function(x, y, ..., pval, pthresh,
                          subscripts, nrpoints=0) {
               panel.smoothScatter(x, y, ..., nrpoints=nrpoints)
               i <- which(pval[subscripts] < pthresh)
               lpoints(x[i], y[i], col="red", pch=ppch, cex=pcex)
               i <- sample(seq_along(x), min(5000, length(x)))
               panel.abline(h=0, lty=3, col="black")
               panel.loess(x[i], y[i], ..., col="red")
           }, ...)
}
