public class CaArrayQualityMetricsClient
{
	public static final String SERVICE_URL = "http://cabig.bioconductor.org/wsrf/services/cagrid/CaArrayQualityMetrics";

	public static void usage()
	{
		System.out.println("Usage: java -jar CaArrayQualityMetricsClient /path/to/folder extension");
		System.out.println("Example: java -jar CaArrayQualityMetricsClient extdata gpr");
	}

	public static void main(String[] args)
	{
		try{
			String strTestFileDir = "";
			String strFileExtension = "";
			if (args.length != 2 || args[0].equals("") || args[1].equals("")) {
				System.err.println("ERROR: missing argument(s)");
				CaArrayQualityMetricsClient.usage();
				System.exit(1);
			}
			strTestFileDir = args[0];
			strFileExtension = args[1];

			class FileFilterExtension implements java.io.FileFilter {
				private String m_extension = null;

				public FileFilterExtension(String extension) {
					m_extension = extension.toLowerCase();
				}

				public boolean accept(java.io.File file) {
					String filename = file.getName();
					String extension = filename.substring(filename.lastIndexOf(".") + 1).toLowerCase();
					if(extension.equals(m_extension)) {
						return true;
					}

					return false;
				}

			}

			FileFilterExtension fileFilterExtension = new FileFilterExtension(strFileExtension);

			java.io.File files = new java.io.File(strTestFileDir);
			if (false == files.exists()) {
				System.err.println("ERROR: Unknown file directory: " + strTestFileDir);
				CaArrayQualityMetricsClient.usage();
				System.exit(1);
			}

			java.io.File[] extFilteredFiles = files.listFiles(fileFilterExtension);
			if (0L == extFilteredFiles.length) {
				System.err.println("ERROR: No file names with extension '" + strFileExtension + "'");
				CaArrayQualityMetricsClient.usage();
				System.exit(1);
			}

			org.bioconductor.packages.caArrayQualityMetrics.client.CaArrayQualityMetricsClient client =
			                                                                            new org.bioconductor.packages.caArrayQualityMetrics.client.CaArrayQualityMetricsClient(SERVICE_URL);

			// Create a FileReference to contain the files:
			int size = extFilteredFiles.length;
			org.bioconductor.cagrid.rservices.FileReference[] fileRefArr = new org.bioconductor.cagrid.rservices.FileReference[size];

			for(int i = 0; i < size; i++) {
				System.out.println("Adding file: " + extFilteredFiles[i].getAbsolutePath());
				fileRefArr[i] = new org.bioconductor.cagrid.rservices.FileReference();
				String filename = extFilteredFiles[i].getName();
				fileRefArr[i].setLocalName(filename.substring(0, filename.lastIndexOf(".")));
				fileRefArr[i].setType(strFileExtension.toUpperCase());
				fileRefArr[i].setUrl(extFilteredFiles[i].getAbsolutePath());
			}

			System.out.println("Preparing to transfer files...");
			// Wrap FileReference[] in FileReferenceCollection
			org.bioconductor.cagrid.rservices.FileReferenceCollection fileRefCollection = new org.bioconductor.cagrid.rservices.FileReferenceCollection(fileRefArr);

			// Create a session identifier
			org.bioconductor.cagrid.statefulservices.SessionIdentifier sessionIden = client.createQualityReportSession();

			// Create HelperService to transfer the FileReferenceCollection:
			org.bioconductor.packages.helper.common.HelperService helperService = new org.bioconductor.packages.helper.common.HelperService();
			// Use helper to upload the FileReferenceCollection
			System.out.println("Transfering files...");
			helperService.uploadFileReferenceCollection(sessionIden, fileRefCollection);

			// Invoke the service to create a report
			System.out.println("Invoking service...");
			client.runCaArrayQualityMetrics(sessionIden);

			// Retrieve the report with the helper
			System.out.println("Retrieving result...");
			org.bioconductor.cagrid.rservices.FileReferenceCollection qualityResultFileRefs = helperService.getFileReferenceCollection(sessionIden);


			System.out.println("Displaying result...");
			String strDownloadTo = System.getProperty("java.io.tmpdir");  // or specify an absolute download path
			org.bioconductor.cagrid.rservices.FileReferenceCollection reportFileRefs = helperService.dowloadResultFiles(qualityResultFileRefs, strDownloadTo);

			// FileReferenceCollection contains a zip archive created
			// by the service. Calling displayReport unzips and
			// displays the report.
			String reportFileLoc = reportFileRefs.getFileReferenceCollection()[0].getUrl();
			System.out.println("Displaying report: " + reportFileLoc);

			org.bioconductor.packages.caArrayQualityMetrics.common.CaAQMOperationsHelper.displayReport(reportFileLoc, "QMreport.html");

			}
			catch (Exception e) {
				e.printStackTrace();
			}
	}
}