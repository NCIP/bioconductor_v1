package org.bioconductor.packages.caArrayQualityMetrics.common;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.bioconductor.cagrid.statefulservices.StatusState;
import org.cagrid.transfer.context.client.TransferServiceContextClient;
import org.cagrid.transfer.context.client.helper.TransferClientHelper;
import org.cagrid.transfer.context.stubs.types.TransferServiceContextReference;
import org.cagrid.transfer.descriptor.DataDescriptor;
import org.cagrid.transfer.descriptor.DataTransferDescriptor;
import org.cagrid.transfer.descriptor.Status;

public class CaAQMOperationsHelper {
	
	private static Object m_mutexObj = new Object();
	
	public static boolean uploadFile(final String strUploadFileFrom, final String strUploadFileTo)
	{
		try {
			System.out.println("Uploaded file location from : " + strUploadFileFrom);
			System.out.println("Uploading file  to: " + strUploadFileTo);

			org.cagrid.transfer.descriptor.DataTransferDescriptor dataTransDesc =
											new org.cagrid.transfer.descriptor.DataTransferDescriptor();
			dataTransDesc.setUrl(strUploadFileTo);

			java.io.InputStream inStream = new java.io.FileInputStream(strUploadFileFrom);

			TransferClientHelper.putData(inStream, -1, dataTransDesc);

			System.out.println("Complete uploading file: " + strUploadFileFrom);

			inStream.close();


			return true;
		}
		catch(Exception ew){
			ew.printStackTrace();
			return false;
		}
	}
	
	public static void uploadFiles(final org.bioconductor.cagrid.data.QualityReportFileReferences reportFileRefs) throws Exception
	{
		synchronized(m_mutexObj) {
			try {
				org.bioconductor.cagrid.statefulservices.CaGridFileReference[] fileRefArr = reportFileRefs.getCagridFileReferenceCollection();
				
				for(int i = 0; i < fileRefArr.length; i++) {
					System.out.println("uploading file: " + fileRefArr[i].getLocalName() + " from : " + fileRefArr[i].getUrl());
					
					TransferServiceContextClient transSrvCxtClient = new TransferServiceContextClient(fileRefArr[i].getEndpointReference());
					
					java.io.InputStream inStream = new java.io.FileInputStream(fileRefArr[i].getUrl());
										
					
					TransferClientHelper.putData(inStream, -1, transSrvCxtClient.getDataTransferDescriptor());
					
					// set status to staged, i.e, a service should start the download by invoking dataStaged method in DataStagedCallback
					transSrvCxtClient.setStatus(Status.Staged);
					
					inStream.close();
					
					System.out.println("uploading file: " + fileRefArr[i].getLocalName() + " completed.");
				}
			}
			catch (Exception ew) {
				throw ew;
			}
		}
	}

	/**
	 * Download files using cagrid transfer reference.
	 * @param transSrvCxtRefArr - array of TransferServiceContextReference, each corresponding to one transferring file
	 * @return String[]  - array of urls where files are downloaded. 
	 * @throws Exception
	 */
	public static org.bioconductor.cagrid.rservices.FileReferences dowloadFiles(final org.bioconductor.cagrid.data.QualityReportFileReferences resultFileRefs, 
			                                                                     final String downloadTo) throws Exception
	{
		org.bioconductor.cagrid.statefulservices.CaGridFileReference[] cagridFileRefArr = resultFileRefs.getCagridFileReferenceCollection();
		
		org.bioconductor.cagrid.rservices.FileReference[] downloadedFileRefArr = new org.bioconductor.cagrid.rservices.FileReference[cagridFileRefArr.length];		

		
		for(int i = 0; i < cagridFileRefArr.length; i++) {
			try {
				TransferServiceContextClient transSrvCxtClient = new TransferServiceContextClient(cagridFileRefArr[i].getEndpointReference());

				String outputFileName = cagridFileRefArr[i].getLocalName();
				System.out.println("Download file: " + outputFileName);				

				InputStream inStream = TransferClientHelper.getData(transSrvCxtClient.getDataTransferDescriptor());				

				// write it out:
				java.io.File outputFile = new java.io.File(downloadTo + "/" + outputFileName);
				
				java.io.OutputStream outStream = new java.io.FileOutputStream(outputFile);

				int bufferSize = 1024 * 100;
				byte[] readIn_buffer = new byte[bufferSize];
				System.out.println("Start downloading file....");
				long byteRead = 0;

				while(true) {
					int readData = 0;
					readData = inStream.read(readIn_buffer);

					if(readData == -1) {
						break;
					}

					byteRead += readData;

					outStream.write(readIn_buffer, 0, readData);
				}

				inStream.close();
				outStream.close();

				System.out.println("Total byte read: " + byteRead);
				System.out.println("Downloading file complete. Output file Location: " + outputFile.getAbsolutePath());
				
				downloadedFileRefArr[i] = new org.bioconductor.cagrid.rservices.FileReference();
				downloadedFileRefArr[i].setLocalName(outputFileName);
				downloadedFileRefArr[i].setType(cagridFileRefArr[i].getType());
				downloadedFileRefArr[i].setUrl(outputFile.getAbsolutePath());
								
			}
			catch(Exception ew) {
				throw ew;
			}
					 
		}
		
		org.bioconductor.cagrid.rservices.FileReferences downloadedFileRefs = new org.bioconductor.cagrid.rservices.FileReferences();
		downloadedFileRefs.setFileReferenceCollection(downloadedFileRefArr);
		
		return downloadedFileRefs;


	}


	/**
	 * Unzip the zip file, then open a web browser display the report page.
	 * This function will use index.html as startup display html page.
	 * @param zipFile - path to where zip file is at
	 */
	public static void displayReport(String reportZipFileLoc)
	{
		displayReport(reportZipFileLoc, "index.html");
	}

	/**
	 * Unzip the zip file, then open a web browser display the report page.
	 * This function will use param htmlFilename as a startup display html page.
	 * @param zipFile - path to where zip file is at
	 * @param htmlFilename - startup html page
	 */
	public static void displayReport(String reportZipFileLoc, String reportHtmlName)
	{		

		try {		
			String reportUrl = unzip(reportZipFileLoc, reportHtmlName);
			System.out.println("Opening a web browser displaying the report...");
			displayReportInBrowser(reportUrl);

		}
		catch(Exception ew) {
			System.out.println("Exception when displaying report in browser.  Cause: " + ew.getMessage());
		}
	}

	public static String unzip(String zipFilename, String htmlFilename)
	{
		java.util.Enumeration zipEntriesEnum;
		java.util.zip.ZipFile zipFile;

		String htmlFilePath = null;

		try {

			System.out.println("Zip filename: " + zipFilename);

			// check extension:
			String fileExt = zipFilename.substring(zipFilename.indexOf('.') + 1, zipFilename.length());
			System.out.println("Zip file extension: " + fileExt);
			if(!fileExt.equals("zip")) {
				System.out.println("Wrong file extension: " + fileExt + " not zip file.");
				return null;
			}

			zipFile = new java.util.zip.ZipFile(zipFilename);

			zipEntriesEnum = zipFile.entries();

			while(zipEntriesEnum.hasMoreElements()) {
				java.util.zip.ZipEntry zipEntry = (java.util.zip.ZipEntry)zipEntriesEnum.nextElement();

				if(zipEntry.isDirectory()) {
					System.out.println("Extracting directory: " + zipEntry.getName());
					//  Strange but this will make directories need from the zip:
					(new java.io.File(zipEntry.getName())).mkdirs();
					continue;
				}

				String filename = zipEntry.getName();



				System.out.println("Extracting file: " + filename);
				java.io.InputStream inStream = zipFile.getInputStream(zipEntry);
				java.io.OutputStream outStream = new java.io.BufferedOutputStream(new java.io.FileOutputStream(filename));

				byte[] readIn_buffer = new byte[1024 * 100];
				int totalData = 0;

				while(true) {
					int data = inStream.read(readIn_buffer);
					if(data == -1) {
						break;
					}

					totalData += data;

					outStream.write(readIn_buffer, 0, data);
				}

				System.out.println("Extracted: " + filename + " Total data read: " + totalData);
				outStream.close();
				inStream.close();

				if(filename.endsWith(htmlFilename)) {
					try {
						java.io.File htmlFile = new java.io.File(filename);
						htmlFilePath = htmlFile.getAbsolutePath();
						System.out.println("Display html file path: " + htmlFilePath);
					}
					catch(Exception ew) {
						System.out.println("Exception when creating file path to html.  Cause: " + ew.getMessage());
						htmlFilePath = null;
					}
				}
			}

			zipFile.close();

		}
		catch (java.io.IOException ew) {
			System.out.println("StatefulOperationsFactory::unzip() has exception.  Cause: " + ew.getMessage());
			ew.printStackTrace();
		}
		
		System.out.println("Done unzip the zip file.");
		
		return htmlFilePath;
	}

	private static void displayReportInBrowser(String url) throws Exception{

		String osName = System.getProperty("os.name");

		try {
			if (osName.startsWith("Mac OS")) {
				Class fileMgr = Class.forName("com.apple.eio.FileManager");
				java.lang.reflect.Method openUrlMethod = fileMgr.getDeclaredMethod("openURL", new Class[] {String.class});
				openUrlMethod.invoke(null, new Object[] {url});
			}
			else if (osName.startsWith("Windows")) {
				Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
			}
			// Unix or Linux
			else {
				String[] browsers = {"firefox", "opera", "konqueror", "epiphany", "mozilla", "netscape", "lynx", "galeon" };
				String browser = null;

				for (int i = 0; i < browsers.length; i++) {
					if (Runtime.getRuntime().exec(new String[] {"which", browsers[i]}).waitFor() == 0) {
						browser = browsers[i];
						break;
					}
				}

				if (browser == null) {
					throw new Exception("Could not find web browser");
				}
				else {
					Runtime.getRuntime().exec(new String[] {browser, url});
				}
			}
		}
		catch (Exception e) {
			throw new Exception("CaArrayQualityMetrics::openUrlInBrowser has exception.  Cause: " + e.getMessage());
		}
	}

}
