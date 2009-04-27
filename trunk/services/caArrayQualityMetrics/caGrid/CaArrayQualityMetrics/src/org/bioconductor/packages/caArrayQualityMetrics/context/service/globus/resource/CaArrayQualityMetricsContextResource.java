package org.bioconductor.packages.caArrayQualityMetrics.context.service.globus.resource;

import java.rmi.RemoteException;


import org.bioconductor.cagrid.statefulservices.StatusState;
import org.bioconductor.packages.rservices.FileReference;
import org.bioconductor.packages.rservices.FileReferences;
import org.bioconductor.packages.rservices.RJFileReferences;

import org.cagrid.transfer.context.client.TransferServiceContextClient;
import org.cagrid.transfer.context.service.globus.resource.TransferServiceContextResource;
import org.cagrid.transfer.context.service.helper.DataStagedCallback;
import org.cagrid.transfer.context.service.helper.TransferServiceHelper;
import org.cagrid.transfer.context.stubs.types.TransferServiceContextReference;

import org.apache.axis.message.addressing.EndpointReferenceType;
import org.cagrid.transfer.descriptor.DataDescriptor;
import org.globus.wsrf.InvalidResourceKeyException;
import org.globus.wsrf.NoSuchResourceException;
import org.globus.wsrf.ResourceException;
import org.globus.wsrf.ResourceKey;


/** 
 * The implementation of this CaArrayQualityMetricsContextResource type.
 * 
 * @created by Introduce Toolkit version 1.2
 * 
 */
public class CaArrayQualityMetricsContextResource extends CaArrayQualityMetricsContextResourceBase 
                                                    implements org.bioconductor.packages.helper.common.HelperServiceContextResourceI {
		
	private static final int WAITING_TIME_OUT = 60000 * 3; // 3 mins
	
	private org.bioconductor.cagrid.statefulservices.Status m_srvCxtStatus = new org.bioconductor.cagrid.statefulservices.Status();
	
	private boolean m_fileReady = false;
	
	private Object m_mutexObj = new Object();
	
	private java.util.ArrayList<FileReference> m_fileRefsFromClientList = new java.util.ArrayList<FileReference>();
	private java.util.List<org.bioconductor.cagrid.statefulservices.CaGridFileReference> m_fileRefsFromWorkerList = 
		                              new java.util.ArrayList<org.bioconductor.cagrid.statefulservices.CaGridFileReference>();
	
	private org.bioconductor.packages.caArrayQualityMetrics.CaArrayQualityMetricsParameters m_caAQM_Parameter = null;
	private RJFileReferences m_returnedRJFileRef = null;
	private org.bioconductor.rserviceJms.services.caArrayQualityMetrics.caArrayQualityMetrics m_caAQM_RService = null;
	
	private int m_totalTransferingFiles = -1;
	private int m_totalTransferingFilesFromWorker = -1;
	
	public CaArrayQualityMetricsContextResource() throws RemoteException
	{
		 // setting status:
		m_srvCxtStatus.setState(StatusState.SESSION_INITIATED);
		
		 System.out.println("CaArrayQualityMetricsContextResource: Creating caArrayQualityMetrics instance");
		 try {
			 m_caAQM_RService = new org.bioconductor.rserviceJms.services.caArrayQualityMetrics.caArrayQualityMetrics();
		 }
		 catch (Exception ex) {
			 throw new RemoteException(ex.getMessage());
		 }
		 System.out.println("CaArrayQualityMetricsContextResource: caArrayQualityMetrics is created");
	}
	
	
	/*********************************************************************************************************
	 * Implementation part of interfaces defined in HelperServiceContextResourceI
	 *********************************************************************************************************/
	
	public String identifyContextSelf()
	{
		return ("I am CaArrayQualityMetricsContextResource...");
	}

	
	public org.bioconductor.cagrid.statefulservices.CaGridFileReferences createUploadFileReferences(org.bioconductor.cagrid.rservices.FileReferences fileRefs) throws RemoteException
	{
		
		// new set, clear the old one:
		m_fileRefsFromClientList.clear();
		m_fileRefsFromWorkerList.clear();		
		m_fileReady = false;

		
		 // mapping cagrid FileReferences to RWebServices FileReferences:
		org.bioconductor.cagrid.rservices.FileReference[] fileRefArr = fileRefs.getFileReferenceCollection();
		int fileRefLength = fileRefArr.length;
		if(fileRefLength == 0) {
			return new org.bioconductor.cagrid.statefulservices.CaGridFileReferences();
		}
		
		m_totalTransferingFiles = fileRefLength;
		
		org.bioconductor.packages.rservices.FileReference[] rwsFileRefArr = new org.bioconductor.packages.rservices.FileReference[fileRefLength];
		for(int i = 0; i < fileRefLength; i++) {
			// mapping this FileReference to RWebService FileReference:
			rwsFileRefArr[i] = new org.bioconductor.packages.rservices.FileReference();
			//use setter to avoid argument-ordered created by Axis emitter not the same
			rwsFileRefArr[i].setLocalName(fileRefArr[i].getLocalName());
			rwsFileRefArr[i].setType(fileRefArr[i].getType());
			rwsFileRefArr[i].setUrl(fileRefArr[i].getUrl());
		}
		
		try {
		  // create a data descriptor for upload data.
		  DataDescriptor dd = new DataDescriptor(null, "caArrayQualityMetrics file transfer.");

		  class CaArrayQualityMetricsDataStagedCallback implements DataStagedCallback {
			  public EndpointReferenceType transCxtEPR = null;
			  // RWebService FileReference corresponding to this callback when client-uploaded file is downloaded into transfer cache
			  public FileReference fileRef = null;

			  public void dataStaged(TransferServiceContextResource transSrvCxtResr) {
 
				 // let's get some info out of TransferServiceContextResource:
				 setContextStatus("Uploading files from client.", StatusState.FILE_TRANSFER_IN_PROCESS);
				 
				 try {
					  TransferServiceContextClient transSrvCxtClient = new TransferServiceContextClient(transCxtEPR);
//						  m_clientFilesStoredLocUrlList.add(transSrvCxtClient.getDataTransferDescriptor().getUrl());

					  System.out.println("createUploadFileReferences() - downloaded file location: " + transSrvCxtClient.getDataTransferDescriptor().getUrl());
					  
					  // Create a new RWebService FileReference with localname and type that matches with this downloaded file:
					  FileReference newFileRef = new FileReference(transSrvCxtClient.getDataTransferDescriptor().getUrl(),
					                                               fileRef.getLocalName(), fileRef.getType());

					  m_fileRefsFromClientList.add(newFileRef);
					  
					  if(m_fileRefsFromClientList.size() == m_totalTransferingFiles) {
						  m_fileReady = true;
						  setContextStatus("Uploading files from client is completed.", StatusState.FILE_TRANSFER_COMPLETE);						  
					  }
				  }
				catch(Exception ew) {
					setContextStatus(ew.getMessage(), StatusState.ERROR);					
				}
			  }

		  }

		  org.bioconductor.cagrid.statefulservices.CaGridFileReference[] cagridFileRefArr = 
			    new org.bioconductor.cagrid.statefulservices.CaGridFileReference[rwsFileRefArr.length];
		  
		  for(int i = 0; i < cagridFileRefArr.length; i++) {
			  CaArrayQualityMetricsDataStagedCallback callback = new CaArrayQualityMetricsDataStagedCallback();

			  // create the transfer resource that will handle receiving the data and
			  // return the reference to the user
			  org.cagrid.transfer.context.stubs.types.TransferServiceContextReference transCxtRef = TransferServiceHelper.createTransferContext(dd, callback);
			  
			  EndpointReferenceType eprType = transCxtRef.getEndpointReference();
			  callback.transCxtEPR = eprType;
			  
			  FileReference fileRef = rwsFileRefArr[i];			  
			  callback.fileRef = fileRef;
			  
			  cagridFileRefArr[i] = new org.bioconductor.cagrid.statefulservices.CaGridFileReference();
			  cagridFileRefArr[i].setEndpointReference(eprType);
			  cagridFileRefArr[i].setLocalName(fileRef.getLocalName());
			  cagridFileRefArr[i].setType(fileRef.getType());
			  cagridFileRefArr[i].setUrl(fileRef.getUrl());
		  }

		  org.bioconductor.cagrid.data.QualityReportFileReferences reportFileRefs = new org.bioconductor.cagrid.data.QualityReportFileReferences();
		  reportFileRefs.setCagridFileReferenceCollection(cagridFileRefArr);
		  
		  return reportFileRefs;

	  }
	  catch(Exception ew) {
		  this.setContextStatus(ew.getMessage(), StatusState.ERROR);
		  ew.printStackTrace();
		  throw new RemoteException("CaArrayQualityMetricsContextResource::createUploadFilesTransfer cause exception.  Detail: " + ew);
		  
	  }
	}
	
	/*****************************************************************
	 * End of implemenation part of HelperService interface
	 *****************************************************************/
	
	
	
	public org.bioconductor.cagrid.statefulservices.Status makeReport(final org.bioconductor.packages.caArrayQualityMetrics.CaArrayQualityMetricsParameters caAQM_Parameters) throws Exception
	{
		this.setContextStatus("Calling R packages to compute data and make a report.", StatusState.OPERATION_IN_PROGRESS);
		
		try {	
			m_caAQM_Parameter = caAQM_Parameters;

			this.invoke();
			
			return m_srvCxtStatus;
		}		
		catch(Exception ew) {
			this.setContextStatus(ew.getMessage(), StatusState.ERROR);			
			throw ew;
		}
	}
	
	private void invoke() throws Exception
	{
		// if the status is in processing, sleep for 3 secs and check on status again:
		int waiting_time = 0;
	  	int sleep_time = 3000;

		while(!m_fileReady) {
			try {
				System.out.println("CaArrayQualityMetricsContextResource::invoke() - File is not ready to transfer, please wait for 3 seconds...");
				Thread.currentThread().sleep(sleep_time);
				waiting_time += sleep_time;
	  			if(waiting_time > WAITING_TIME_OUT) {  // tired of waiting, get out
	  				this.setContextStatus("Timeout exception: waiting too long for uploaded files.", StatusState.ERROR);	  				
	  				throw new Exception("Timeout exception: waiting too long for upload files");
	  			}
			}
			catch(Exception ew) {
				this.setContextStatus(ew.getMessage(), StatusState.ERROR);				
				throw ew;
			}
		}

		this.computeCaArrayQualityMetrics();	
		

	}

	
	private void computeCaArrayQualityMetrics() throws Exception 
	{
	  try {
		  if(m_fileRefsFromClientList.size() == 0) {
			  this.setContextStatus("No data files found to compute.", StatusState.IDLE);			  
			  return;
		  }
	
		  if(m_caAQM_Parameter == null) {
			  this.setContextStatus("Null CaArrayQualityMetricsParameters.", StatusState.ERROR);			  
			  throw new RemoteException("Null CaArrayQualityMetricsParameteres");
		  }
	
		  this.callRServiceCaArrayQualityMetrics();
	
		  this.requestWorkerUploadFile();
	  }
	  catch(Exception ew ) {
		  throw ew;
	  }
	}
	
	
	private void callRServiceCaArrayQualityMetrics() throws Exception
	{
	   // Try to use Callable instead of Runnable since Runnable can't throw exception.
	   // We need to capture potential exception thrown from RWebservices to propagating it to a client
	   try {	 	  
		  m_returnedRJFileRef = null;

 		  java.util.concurrent.Callable<RJFileReferences> oCallable = new java.util.concurrent.Callable<RJFileReferences>() {
 			  public RJFileReferences call() throws Exception{
 				  try {

 					 // create input parameters:
 					System.out.println("CaArrayQualityMetricsContextResource::callRServiceCaArrayQualityMetrics() - file location set size: " + m_fileRefsFromClientList.size());

					// From RWebService FileReferences:
					FileReferences fileReferences = new FileReferences(m_fileRefsFromClientList);
					RJFileReferences rJFileReferences = new RJFileReferences(fileReferences);

					// expecting RJFileReferences returned; else, something not right
					Object returnedObj = m_caAQM_RService.caArrayQualityMetrics(rJFileReferences, m_caAQM_Parameter);
					if(!(returnedObj instanceof RJFileReferences)) {
						setContextStatus("Un-matched object type returned from RWorker.  Expected: RJFileReference.  Received: " + returnedObj.getClass().getName(), StatusState.ERROR);						
						throw new Exception("Expected: RJFileReference.  Receieved: " + returnedObj.getClass().getName());
					}
					
					RJFileReferences oReturnedFileRef = (RJFileReferences)returnedObj;

 					System.out.println("CaArrayQualityMetricsContextResource::callRServiceCaArrayQualityMetrics() - Got returned value of RJFileReferences from caArrayQualityMetrics package.");

 					String[] returnedUrlArr = oReturnedFileRef.getUrls();

 					for(String returnedUrl : returnedUrlArr) {
 						System.out.println("CaArrayQualityMetricsContextResource::callRServiceCaArrayQualityMetrics() - Returned file location: " + returnedUrl);
 					}
 					
 					return oReturnedFileRef;

 				  }
 				  catch(Exception ew) {
 					  setContextStatus(ew.getMessage(), StatusState.ERROR);
 					  throw ew;
 				  }
 			  }
 		  };

 		  java.util.concurrent.ExecutorService oExecSrv = java.util.concurrent.Executors.newSingleThreadExecutor();
 		  java.util.concurrent.Future<RJFileReferences> oFutureTask = oExecSrv.submit(oCallable);


 		  m_returnedRJFileRef = oFutureTask.get(); 		  
	  }

 	  catch(Exception ew) {
 		  this.setContextStatus(ew.getMessage(), StatusState.ERROR);
 		  throw ew;
 	  }
	}

	private void requestWorkerUploadFile() throws RemoteException
	{

		// check status on m_returnedFileRef: if this object got response from worker to indicate
		// if the file is ready to be uploaded from worker:

		// if the status is in processing, sleep for 3 secs and check on status again:
		int waiting_time = 0;
		int sleep_time = 3000;

		while(m_returnedRJFileRef == null) {
			try {
				System.out.println("CaArrayQualityMetricsContextResource: Not yet got response from worker, please wait for 3 seconds...");
				Thread.currentThread().sleep(sleep_time);
				waiting_time += sleep_time;
				if(waiting_time > WAITING_TIME_OUT) {  // tired of waiting, get out
					this.setContextStatus("Waiting too long for a worker response. Worker doesn't hand off anything.", StatusState.ERROR);					
					throw new RemoteException("Timeout exception: waiting too long for a worker's response.  Worker doesn't hand off anything");
		  		}
			}
			catch(Exception ew) {
				this.setContextStatus(ew.getMessage(), StatusState.ERROR);				
				throw new RemoteException(ew.getMessage());
			}
		 }
		
		 System.out.println("CaArrayQualityMetricsContextResource::requestWorkerUploadFile() - Start calling worker to upload the file");

		 // start over, clear the old list
		 m_fileRefsFromWorkerList.clear();
		 String[] fileUrlArr = m_returnedRJFileRef.getUrls();
		 m_totalTransferingFilesFromWorker = fileUrlArr.length;
		 
		 this.setContextStatus("Worker is transfering report the service.", StatusState.FILE_TRANSFER_IN_PROCESS);		 

		 for(int i = 0; i < fileUrlArr.length; i++) {
			 try {
				TransferServiceContextReference transSrvCxtRef = this.createWorkerUploadTransferCxtRef(m_returnedRJFileRef.getLocalNames()[i], m_returnedRJFileRef.getTypes()[i]);
				TransferServiceContextClient transSrvCxtClient = new TransferServiceContextClient(transSrvCxtRef.getEndpointReference());
				String strUploadFileTo = transSrvCxtClient.getDataTransferDescriptor().getUrl();
				Object oSuccess = m_caAQM_RService.uploadFile(fileUrlArr[i], strUploadFileTo);

				Boolean obSuccess = (Boolean)oSuccess;
				if(obSuccess.booleanValue()) {
	//				m_workerUploadFileLoc = transSrvCxtClient.getDataTransferDescriptor().getUrl();
					System.out.println("requestWorkerUploadFile() - Uploading file from caArrayQualityMetrics worker succeed");
					transSrvCxtClient.setStatus(org.cagrid.transfer.descriptor.Status.Staged);
				}
				else {
					this.setContextStatus("Uploading file from worker failed.", StatusState.ERROR);					
					System.out.println("CaArrayQualityMetricsContextResource::requestWorkerUploadFile() - Uploading file from caArrayQualityMetrics worker failed");
					throw new RemoteException("Uploading file from worker failed");
				}
			 }			 
			 catch(Exception ew) {
				 this.setContextStatus("Exceptin in requesting worker to upload file: " + ew.getMessage(), StatusState.ERROR);				 
				 System.out.println("requestWorkerUploadFile() - Exception in uploadWorker");
				 throw new RemoteException("Exception in requesting worker to upload file: " + ew.getMessage());
			 }
		 }
	}
	
	
	private org.cagrid.transfer.context.stubs.types.TransferServiceContextReference createWorkerUploadTransferCxtRef(String strLocalName, String fileType) throws Exception
	{
		try {
			// create a data descriptor for upload data.
			DataDescriptor dd = new DataDescriptor(null, "caArrayQualityMetrics file transfered from a worker.");
			
			class WorkerUploadDataStagedCallback implements DataStagedCallback {
				public EndpointReferenceType transCxtEPR = null;
				public String fileLocalName = null;
				public String fileType = null;
				
				public void dataStaged(TransferServiceContextResource transSrvCxtResrc) {
					try {
                        TransferServiceContextClient transSrvCxtClient = new TransferServiceContextClient(transCxtEPR);
			
                        System.out.println("CaFlowQContextResource::createUploadTransferCxtRef - file is uploaded to location: " + transSrvCxtClient.getDataTransferDescriptor().getUrl());
                        
						org.bioconductor.cagrid.statefulservices.CaGridFileReference cagridFileRef = new org.bioconductor.cagrid.statefulservices.CaGridFileReference();
						cagridFileRef.setLocalName(fileLocalName);
						cagridFileRef.setType(fileType);
						cagridFileRef.setUrl(transSrvCxtClient.getDataTransferDescriptor().getUrl());
						m_fileRefsFromWorkerList.add(cagridFileRef);
						
						if(m_fileRefsFromWorkerList.size() == m_totalTransferingFilesFromWorker) {
							setContextStatus("Transfering files from worker complete.", StatusState.RESULT_AVAILABLE);							
						}
					}
					catch(Exception ew) {
						setContextStatus(ew.getMessage(), StatusState.ERROR);						
						ew.printStackTrace();
					}

				}
			};
			
			WorkerUploadDataStagedCallback callback = new WorkerUploadDataStagedCallback();
			callback.fileLocalName = strLocalName;
			callback.fileType = fileType;
			org.cagrid.transfer.context.stubs.types.TransferServiceContextReference transCxtRef = TransferServiceHelper.createTransferContext(dd, callback);
			callback.transCxtEPR = transCxtRef.getEndpointReference();
			
			return transCxtRef; 
		}
		catch(Exception ew) {
			this.setContextStatus(ew.getMessage(), StatusState.ERROR);
			throw ew;
		}
	}

	
	public org.bioconductor.cagrid.data.QualityReportFileReferences getReportResult() throws RemoteException
	{

		// if the file location is not ready yet, i.e, worker hasn't finished uploading file, sleep for 3 secs and check on status again:
		int waiting_time = 0;
	  	int sleep_time = 3000;

		while(!(m_srvCxtStatus.getState().equals(StatusState.RESULT_AVAILABLE))) {
			try {
				System.out.println("CaArrayQualityMetricsContextResource: report is not ready, please wait for 3 seconds...");
				Thread.currentThread().sleep(sleep_time);
				waiting_time += sleep_time;
	  			if(waiting_time > WAITING_TIME_OUT) {  // tired of waiting, get out
	  				this.setContextStatus("Waiting too long for a report.", StatusState.ERROR);					
	  				throw new RemoteException("Waiting too long for a report");
	  			}
			}
			catch(Exception ew) {
				throw new RemoteException(ew.getMessage(), ew);
			}
		}
		
		org.bioconductor.cagrid.statefulservices.CaGridFileReference[] cagridFileRefArr = new 
										org.bioconductor.cagrid.statefulservices.CaGridFileReference[m_fileRefsFromWorkerList.size()];
		System.out.println("CaArrayQualityMetricsContextResource::getReportResult() is called");
		for(int i = 0; i < m_fileRefsFromWorkerList.size(); i++) {
			cagridFileRefArr[i] = m_fileRefsFromWorkerList.get(i);
			System.out.println("Localname: " + cagridFileRefArr[i].getLocalName() + " Url: " + cagridFileRefArr[i].getUrl());
		}
		org.bioconductor.cagrid.data.QualityReportFileReferences reportFileRef = new org.bioconductor.cagrid.data.QualityReportFileReferences();
		reportFileRef.setCagridFileReferenceCollection(cagridFileRefArr);
		
		return reportFileRef;
	}
	
	
	public void setContextStatus(String description, StatusState state) {
		m_srvCxtStatus.setDescription(description);
		m_srvCxtStatus.setState(state);
	}
	
	public org.bioconductor.cagrid.statefulservices.Status getStatus() 
	{
		return m_srvCxtStatus;
	}
			
}
