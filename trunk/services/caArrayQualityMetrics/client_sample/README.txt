CaArrayQualityMetricsClient
---------------------------

The CaArrayQualityMetricsClient illustrates how Bioconductor services
can be invoked. This is a simple Java command-line application,
requiring only that Java be installed; it is meant for illustrative
purposes. To use this client

1. Install Java from http://www.java.com/en/download/manual.jsp

2. Download CaArrayQualityMetricsClient.jar from 

   https://gforge.nci.nih.gov/docman/view.php/175/19873/CaArrayQualityMetricsClient.jar   

3. Place microarray files to be used for quality assessment into a
   single directory. For instance, create a directory 'extdata' and
   place microarray files inside this. The following abbreviates the
   DOS prompt as '>', without the directory path.

   > dir extdata

   11/15/2009  02:28 PM           989,741 HuPr4504.gpr
   11/15/2009  02:28 PM         1,007,405 HuPr4500.gpr
   11/15/2009  02:28 PM         1,006,130 HuPr4492.gpr
   11/15/2009  02:28 PM           988,744 HuPr4488.gpr
   11/15/2009  02:28 PM    <DIR>          .
   11/15/2009  02:28 PM         1,011,165 HuPr4503.gpr
   11/15/2009  02:40 PM    <DIR>          ..
   11/15/2009  02:28 PM         1,002,016 HuPr4487.gpr
                  6 File(s)      6,013,393 bytes

4. Invoke the service, inidicating the location and file name
   extension of the files to be submitted

  > java -jar CaArrayQualityMetricsClient.jar extdata gpr

  The files will be uploaded to the service, a .zip archive containing
  the results of quality assessment will be returned, uncompressed,
  and displayed in your browser.

The CaArrayQualityMetricsClient.jar file contains the source file for
the client, and can be used as a template fro more elaborate client
development.
