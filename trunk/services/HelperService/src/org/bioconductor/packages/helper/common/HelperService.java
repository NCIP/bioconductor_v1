package org.bioconductor.packages.helper.common;

import java.io.InputStream;

import org.bioconductor.cagrid.rservices.FileReferences;
import org.bioconductor.cagrid.statefulservices.CaGridFileReferences;
import org.bioconductor.cagrid.statefulservices.SessionEndpoint;
import org.bioconductor.cagrid.statefulservices.StatusState;
import org.bioconductor.packages.helper.client.HelperServiceClient;
import org.cagrid.transfer.context.client.TransferServiceContextClient;
import org.cagrid.transfer.context.client.helper.TransferClientHelper;
import org.cagrid.transfer.context.stubs.types.TransferServiceContextReference;
import org.cagrid.transfer.descriptor.DataDescriptor;
import org.cagrid.transfer.descriptor.DataTransferDescriptor;



public class HelperService {
	private static final String HELPER_SERVICE_EP = "HelperService";
	private static final String CAGRID_SERVICE_POSTFIX = "wsrf/services/cagrid/";
	
	/*
	 * Codes work with to HelperService
	 */
	public String testLookupContext(String wsUrl, SessionEndpoint sessionEP) throws Exception
	{		
		try {
			String helperSrvUrl = this.createHelperServiceURL(wsUrl);
			HelperServiceClient helperServiceClient = new HelperServiceClient(helperSrvUrl);
			
			return helperServiceClient.testContextLookup(sessionEP);
		}
		catch(Exception ew) {
			throw ew;
		}
	}
	
	public org.bioconductor.cagrid.statefulservices.Status uploadFiles(String wsUrl, SessionEndpoint sessionEP, FileReferences fileRefs) throws Exception
	{
		
		org.bioconductor.cagrid.statefulservices.Status status = new org.bioconductor.cagrid.statefulservices.Status();
		try {
			String helperSrvUrl = this.createHelperServiceURL(wsUrl);
			HelperServiceClient helperServiceClient = new HelperServiceClient(helperSrvUrl);
			
			// invoke the service:
			CaGridFileReferences cagridFileRefs = helperServiceClient.getUploadFileReferences(sessionEP, fileRefs);
			this.uploadCagridFileReferences(cagridFileRefs);
			
			status.setDescription("Uploading files completed");
			status.setState(StatusState.FILE_UPLOAD_COMPLETE);
			
		}
		catch(Exception ew) {			
			status.setDescription(ew.getMessage());
			status.setState(StatusState.ERROR);
			throw ew;
		}
		
		return status;
	}
	
	public org.bioconductor.cagrid.statefulservices.Status uploadDataObject(String wsUrl, SessionEndpoint sessionEP, Object object) throws Exception
	{
		org.bioconductor.cagrid.statefulservices.Status status = new org.bioconductor.cagrid.statefulservices.Status();
		try {
			status.setDescription("Sending object to: " + wsUrl);
			status.setState(StatusState.OBJECT_TRANSFER_IN_PROCESS);
			String helperSrvUrl = this.createHelperServiceURL(wsUrl);
			HelperServiceClient helperServiceClient = new HelperServiceClient(helperSrvUrl);
			
			org.bioconductor.cagrid.statefulservices.CaGridObjectReference uploadObjRef = helperServiceClient.getUploadObjectReference(sessionEP);
			this.uploadObject(uploadObjRef, object);
			status.setDescription("Done sending object to: " + wsUrl);
			status.setState(StatusState.OBJECT_TRANSFER_COMPLETE);
		}
		catch(Exception ew) {
			status.setDescription(ew.getMessage());
			status.setState(StatusState.ERROR);
			throw ew;
		}
		
		return status;
	}
	
	private void uploadObject(final org.bioconductor.cagrid.statefulservices.CaGridObjectReference caObjRef, final Object object) throws Exception 
	{
		java.io.InputStream inStream = null;
		java.io.ObjectOutputStream objOutStream = null;
		try {
			java.io.ByteArrayOutputStream baOutstream = new java.io.ByteArrayOutputStream();
			objOutStream = new java.io.ObjectOutputStream(baOutstream);
			objOutStream.writeObject(object);
			inStream = new java.io.ByteArrayInputStream(baOutstream.toByteArray());
			
			TransferServiceContextClient transSrvCxtClient = new TransferServiceContextClient(caObjRef.getEndpointReference());
			TransferClientHelper.putData(inStream, baOutstream.size(), transSrvCxtClient.getDataTransferDescriptor());
			transSrvCxtClient.setStatus(org.cagrid.transfer.descriptor.Status.Staged);
			System.out.println("Complete the call to upload large object...");
		}
		catch(Exception ew) {
			throw ew;
		}
		finally {
			if(inStream != null) inStream.close();
			if(objOutStream != null) objOutStream.close();
		}
	}
	
	
	public Object getResultObject(String wsUrl, SessionEndpoint sessionEP) throws Exception 
	{
		try {
			String helperSrvUrl = this.createHelperServiceURL(wsUrl);
			HelperServiceClient helperServiceClient = new HelperServiceClient(helperSrvUrl);
			
			org.bioconductor.cagrid.statefulservices.CaGridObjectReference caObjRef = helperServiceClient.getDownloadObjectReference(sessionEP);
			return this.downloadObject(caObjRef);
		}
		catch(Exception ew) {
			throw ew;
		}
	}
	
	private Object downloadObject(final org.bioconductor.cagrid.statefulservices.CaGridObjectReference caObjRef) throws Exception 
	{
		java.io.InputStream inStream = null;
		java.io.ObjectInputStream objInStream = null;
		try {
			TransferServiceContextClient transSrvCxtClient = new TransferServiceContextClient(caObjRef.getEndpointReference());
			inStream = TransferClientHelper.getData(transSrvCxtClient.getDataTransferDescriptor());
			
			objInStream = new java.io.ObjectInputStream(inStream);
			Object transferedObj = objInStream.readObject();
			
			return transferedObj;
		}
		catch(Exception ew) {
			throw ew;
		}
		finally {
			if(inStream != null) inStream.close();
			if(objInStream != null) objInStream.close();
		}
	}
	
	
	
	private String createHelperServiceURL(final String wsUrl) 
	{
		// This wsUrl should be the same as HelperService except the service name, which HelperService
		// Construct a url endpoint for HelperService:
		String subUrl = wsUrl.substring(0, wsUrl.lastIndexOf(CAGRID_SERVICE_POSTFIX));
		String helperSrvUrl = subUrl + CAGRID_SERVICE_POSTFIX + HELPER_SERVICE_EP;
//		System.out.println("HelperService url: " + helperSrvUrl);
		
		return helperSrvUrl;
		
	}
	
	private synchronized void uploadCagridFileReferences(final org.bioconductor.cagrid.statefulservices.CaGridFileReferences cagridFileRefs) throws Exception
	{	
		try {
			org.bioconductor.cagrid.statefulservices.CaGridFileReference[] cagridFileRefArr = cagridFileRefs.getCagridFileReferenceCollection();
			for(int i = 0; i < cagridFileRefArr.length; i++) {
				
				System.out.println("Uploading file: " + cagridFileRefArr[i].getLocalName());
				
				TransferServiceContextClient transSrvCxtClient = new TransferServiceContextClient(cagridFileRefArr[i].getEndpointReference());
				
				System.out.println("Creating input stream for: " + cagridFileRefArr[i].getUrl());
				java.io.InputStream inStream = new java.io.FileInputStream(cagridFileRefArr[i].getUrl());
				
				org.cagrid.transfer.descriptor.DataTransferDescriptor desc = transSrvCxtClient.getDataTransferDescriptor();
				
				TransferClientHelper.putData(inStream, -1, transSrvCxtClient.getDataTransferDescriptor());
				
				// set status to staged, i.e, a service should start the download by invoking dataStaged method in DataStagedCallback
				transSrvCxtClient.setStatus(org.cagrid.transfer.descriptor.Status.Staged);
				
				inStream.close();
				
				System.out.println("uploading file: " + cagridFileRefArr[i].getLocalName() + " completed.");
			}
		}
		catch (Exception ew) {
			throw ew;
		}
	
	}
	
	
	public org.bioconductor.cagrid.statefulservices.Status dowloadFiles(final org.bioconductor.cagrid.rservices.FileReferences cagridFileRefs) throws Exception
	{
		org.bioconductor.cagrid.rservices.FileReference[] cagridFileRefArr = cagridFileRefs.getFileReferenceCollection();
		org.bioconductor.cagrid.statefulservices.Status downloadStatus = new org.bioconductor.cagrid.statefulservices.Status();

		for(org.bioconductor.cagrid.rservices.FileReference fileRef : cagridFileRefArr) {
			try {
				
				String outputFileName = fileRef.getLocalName();
//				outputFileNameArr[index++] = outputFileName;

				System.out.println("Download filename: " + outputFileName);

				java.io.InputStream inStream = TransferClientHelper.getData(new DataTransferDescriptor(new DataDescriptor(), fileRef.getUrl()));

				// write it out:
				java.io.File outputFile = new java.io.File(outputFileName);
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
			}
			catch(Exception ew) {
				throw ew;
			}
		}

		downloadStatus.setState(StatusState.FILE_DOWNLOAD_COMPLETE);
		
		return downloadStatus;
	}
	
	public org.bioconductor.cagrid.rservices.FileReferences dowloadResultFiles(final org.bioconductor.cagrid.rservices.FileReferences fileRefs) throws Exception
	{
		return this.dowloadResultFiles(fileRefs, "");  // download to current directory
	}
            
	public org.bioconductor.cagrid.rservices.FileReferences dowloadResultFiles(final org.bioconductor.cagrid.rservices.FileReferences fileRefs, 
                                                                                  final String downloadTo) throws Exception
	{
		org.bioconductor.cagrid.rservices.FileReference[] fileRefArr = fileRefs.getFileReferenceCollection();
		
		org.bioconductor.cagrid.rservices.FileReference[] downloadedFileRefArr = new org.bioconductor.cagrid.rservices.FileReference[fileRefArr.length];		
		
		
		for(int i = 0; i < fileRefArr.length; i++) {
			try {
								
				String outputFileName = fileRefArr[i].getLocalName();
				System.out.println("Download file: " + outputFileName);				
				
				InputStream inStream = TransferClientHelper.getData(new DataTransferDescriptor(new DataDescriptor(), fileRefArr[i].getUrl()));				
				
				// write it out:
				java.io.File outputFile = downloadTo.equals("") ? new java.io.File(outputFileName) : new java.io.File(downloadTo + "/" + outputFileName);
								
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
				downloadedFileRefArr[i].setType(fileRefArr[i].getType());
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

}
