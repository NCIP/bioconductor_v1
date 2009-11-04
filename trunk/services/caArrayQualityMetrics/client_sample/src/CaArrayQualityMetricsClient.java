public class CaArrayQualityMetricsClient
{
	public static final String SERVICE_URL = "http://cabig.bioconductor.org/wsrf/services/cagrid/CaArrayQualityMetrics";

	public static void main(String[] args)
	{
		try{
			String strTestFileDir = "";
			String strFileExtension = "";

			if(args.length < 2 || args[0].equals("") || args[1].equals("")) {
				System.out.println("Missing filepath and file extension from arguments.  Usage: run from ant command: ant run -Ddir=/path/to/filedir -Dext=fileExtension");

				System.out.println("From command prompt, please enter file path: ");
				java.io.BufferedReader br = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));

				strTestFileDir = br.readLine();
				System.out.println("Please enter file extension: ");
				strFileExtension = br.readLine();

			}
			else if(args.length == 2){
				strTestFileDir = args[0];
				strFileExtension = args[1];
			}
			else {
				System.out.println("Invalid arguments.  Usage: ant run or ant run -Ddir=/path/to/filedir -Dext=fileExtension");
				System.exit(1);
			}

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

			java.io.File[] extFilteredFiles = files.listFiles(fileFilterExtension);

			for(int i = 0; i < extFilteredFiles.length; i++) {
				System.out.println("file: " + extFilteredFiles[i].toString());
				String filename = extFilteredFiles[i].getName();
				System.out.println("File local name: " + filename.substring(0, filename.lastIndexOf(".")));
			}

			org.bioconductor.packages.caArrayQualityMetrics.client.CaArrayQualityMetricsClient client =
			                                                                            new org.bioconductor.packages.caArrayQualityMetrics.client.CaArrayQualityMetricsClient(SERVICE_URL);

			// Create a set of FileReference to contain those files above:
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

			System.out.println("Done adding file. Start calling the service...");
			// a FileReferenceCollection to wrap the array of FileReference:
			org.bioconductor.cagrid.rservices.FileReferenceCollection fileRefCollection = new org.bioconductor.cagrid.rservices.FileReferenceCollection(fileRefArr);

			// create a session identifier for this invocation:
			org.bioconductor.cagrid.statefulservices.SessionIdentifier sessionIden = client.createQualityReportSession();

			// create a service helper to transfer FileReferenceCollection:
			org.bioconductor.packages.helper.common.HelperService helperService = new org.bioconductor.packages.helper.common.HelperService();
			// now, use helper to upload files:
			System.out.println("Transfering files...");
			helperService.uploadFileReferenceCollection(sessionIden, fileRefCollection);
			// calling the service to do report on those files:
			System.out.println("Invoking the service...");
			client.runCaArrayQualityMetrics(sessionIden);

			System.out.println("Result is ready");
			// use helper  to get the result
			org.bioconductor.cagrid.rservices.FileReferenceCollection qualityResultFileRefs = helperService.getFileReferenceCollection(sessionIden);


			System.out.println("Got the report result");
			String strDownloadTo = System.getProperty("java.io.tmpdir");  // or specify a absolute path to where you want it to download to.
			org.bioconductor.cagrid.rservices.FileReferenceCollection reportFileRefs = helperService.dowloadResultFiles(qualityResultFileRefs, strDownloadTo);

			// If everything works correctly, the result FileReferenceCollection will contain a zip file in which
			// report files created by the service exist.  So, calling displayReport in CaAQMOperationHelper will unzip and display the report.
			String reportFileLoc = reportFileRefs.getFileReferenceCollection()[0].getUrl();
			System.out.println("display report of: " + reportFileLoc);

			org.bioconductor.packages.caArrayQualityMetrics.common.CaAQMOperationsHelper.displayReport(reportFileLoc, "QMreport.html");

			}
			catch (Exception e) {
				e.printStackTrace();
			}
	}
}