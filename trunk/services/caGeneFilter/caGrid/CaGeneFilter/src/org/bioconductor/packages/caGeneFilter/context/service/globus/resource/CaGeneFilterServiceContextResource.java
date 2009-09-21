package org.bioconductor.packages.caGeneFilter.context.service.globus.resource;

import java.rmi.RemoteException;

import org.apache.axis.message.addressing.EndpointReferenceType;
import org.bioconductor.packages.caGeneFilter.common.CaGeneFilterHelper;
import org.bioconductor.packages.rservices.FileReference;
import org.bioconductor.packages.rservices.FileReferences;
import org.bioconductor.packages.rservices.RJNumericMatrix;


import org.cagrid.transfer.context.client.TransferServiceContextClient;
import org.cagrid.transfer.context.service.globus.resource.TransferServiceContextResource;
import org.cagrid.transfer.context.service.helper.DataStagedCallback;
import org.cagrid.transfer.context.service.helper.TransferServiceHelper;
import org.cagrid.transfer.context.stubs.types.TransferServiceContextReference;
import org.cagrid.transfer.descriptor.DataDescriptor;
import org.bioconductor.cagrid.statefulservices.StatusState;

/**
 * The implementation of this CaGeneFilterServiceContextResource type.
 *
 * @created by Introduce Toolkit version 1.2
 *
 */
public class CaGeneFilterServiceContextResource extends CaGeneFilterServiceContextResourceBase implements org.bioconductor.packages.helper.common.HelperServiceContextResourceI{
	private static final int WAITING_TIME_OUT = 60000 * 3; // 3 mins


	private Object m_mutexObj = new Object();
	private boolean m_fileReady = false;
	private java.util.ArrayList<FileReference> m_fromClientFileReferenceList = new java.util.ArrayList<FileReference>();
	private org.bioconductor.cagrid.data.SingleChannelExpressionDataCollection m_largeSingleChannelExpData = null;
//	private org.bioconductor.cagrid.data.SingleChannelExpressionDataCollection m_retSingleChannelExpData = null;
	private org.bioconductor.cagrid.data.AbstractExpressionDataCollection m_returnedExpDataCollection = null;
	private org.bioconductor.cagrid.statefulservices.Status m_status = null;

	public CaGeneFilterServiceContextResource()
	{
		m_status = new org.bioconductor.cagrid.statefulservices.Status();
		m_status.setDescription("Initializing...");
		m_status.setState(StatusState.SESSION_INITIATED);
	}

	private org.bioconductor.cagrid.statefulservices.CaGridFileReferenceCollection setDataFilesInput(final org.bioconductor.packages.rservices.FileReferences fileReferences) throws RemoteException
	{
		// new set, clear the old one:
		m_fromClientFileReferenceList.clear();

		try {
		  // create a data descriptor for upload data.
		  DataDescriptor dd = new DataDescriptor(null, "caArrayQualityMetrics file transfer.");

		  class CaGeneFilterDataStagedCallback implements DataStagedCallback {
			  public EndpointReferenceType transCxtEPR = null;
			  // FileReferences corresponding to this callback when client-uploaded file is downloaded into transfer cache
			  public FileReference fileRef = null;

			  public void dataStaged(TransferServiceContextResource transSrvCxtResr) {

				 synchronized(m_mutexObj) {
					 // let's get some info out of TransferServiceContextResource:
					 m_fileReady = false;

					 try {
						  TransferServiceContextClient transSrvCxtClient = new TransferServiceContextClient(transCxtEPR);
//						  m_clientFilesStoredLocUrlList.add(transSrvCxtClient.getDataTransferDescriptor().getUrl());

						  System.out.println("setDataFilesInput() - downloaded file location: " + transSrvCxtClient.getDataTransferDescriptor().getUrl());

						  // Create a new RWebService FileReference with localname and type that matches with this downloaded file:
						  FileReference newFileRef = new FileReference(transSrvCxtClient.getDataTransferDescriptor().getUrl(),
						                                               fileRef.getLocalName(), fileRef.getType());

						  m_fromClientFileReferenceList.add(newFileRef);

						  m_fileReady = true;
					  }
					catch(Exception ew) {
						ew.printStackTrace();
					}
				 }
			  }

		  }

		  org.bioconductor.cagrid.statefulservices.CaGridFileReference[] cagridFileReferenceArr =
			    new org.bioconductor.cagrid.statefulservices.CaGridFileReference[fileReferences.size()];


		  for(int i = 0; i < cagridFileReferenceArr.length; i++) {
			  CaGeneFilterDataStagedCallback callback = new CaGeneFilterDataStagedCallback();

			  // create the transfer resource that will handle receiving the data and
			  // return the reference to the user
			  org.cagrid.transfer.context.stubs.types.TransferServiceContextReference transCxtRef = TransferServiceHelper.createTransferContext(dd, callback);
			  EndpointReferenceType eprType = transCxtRef.getEndpointReference();
			  callback.transCxtEPR = eprType;

			  FileReference fileRef = fileReferences.getFileReferences().get(i);
			  callback.fileRef = fileRef;

			  cagridFileReferenceArr[i] = new org.bioconductor.cagrid.statefulservices.CaGridFileReference(eprType);
			  cagridFileReferenceArr[i].setEndpointReference(eprType);
			  cagridFileReferenceArr[i].setUrl(fileRef.getUrl());
			  cagridFileReferenceArr[i].setType(fileRef.getType());
			  cagridFileReferenceArr[i].setLocalName(fileRef.getLocalName());
		  }

		  org.bioconductor.cagrid.statefulservices.CaGridFileReferenceCollection cagridFileRefCollection = 
			                                                 new org.bioconductor.cagrid.statefulservices.CaGridFileReferenceCollection();
		  cagridFileRefCollection.setCagridFileReferenceCollection(cagridFileReferenceArr);
		  
		  return cagridFileRefCollection;

	  }
	  catch(Exception ew) {
		  ew.printStackTrace();
		  throw new RemoteException("setDataInput cause exception.  Detail: " + ew.getMessage(), ew);
	  }
	}




	public org.bioconductor.cagrid.data.TwoChannelExpressionDataCollection fileRecode(final org.bioconductor.cagrid.cagenefilter.SpotQualityRecode sqRecode,
			                                                                           final org.bioconductor.rserviceJms.services.caGeneFilter.caGeneFilter caGeneFilter) throws Exception
	{
		try {

			// if the status is in processing, sleep for 3 secs and check on status again:
			int waiting_time = 0;
		  	int sleep_time = 3000;

			while(!m_fileReady) {
				try {
					System.out.println("File is not ready to transfer, please wait for 3 seconds...");
					Thread.currentThread().sleep(sleep_time);
					waiting_time += sleep_time;
		  			if(waiting_time > WAITING_TIME_OUT) {  // tired of waiting, get out
		  				throw new Exception("Timeout exception: waiting too long for uploaded files");
		  			}
				}
				catch(Exception ew) {
					throw ew;
				}
			}

			FileReferences fileReferences = new FileReferences(m_fromClientFileReferenceList);
			org.bioconductor.packages.rservices.RJFileReferences rjFileRef = new org.bioconductor.packages.rservices.RJFileReferences(fileReferences);

			// mapping cagrid SpotQualityRecode to R-caGeneFilter package SpotQualityRecode:
			org.bioconductor.packages.caGeneFilter.SpotQualityRecode biocSpotQRecode =
				           new org.bioconductor.packages.caGeneFilter.SpotQualityRecode(new String[]{sqRecode.getColumnIdentifier()},
				        		                                                        new double[]{sqRecode.getColumnMinimumThresholdValue()},
				        		                                                        new double[]{sqRecode.getRecodeValue()});

			Object[] returnedObjArr = caGeneFilter.caFileGeneRecode(rjFileRef, biocSpotQRecode);

			if(returnedObjArr == null || returnedObjArr.length == 0) {
				// return an empty object
				return new org.bioconductor.cagrid.data.TwoChannelExpressionDataCollection();
			}

			return this.convertToExpressionDataCollection(returnedObjArr);
		}
		catch(Exception ew) {
			throw ew;
		}
	}

	public org.bioconductor.cagrid.data.SingleChannelExpressionDataCollection getSingleChannelExpressionDataCollection() throws Exception
	{

		// if the status is in processing, sleep for 3 secs and check on status again:
		int waiting_time = 0;
	  	int sleep_time = 3000;

		while(m_status.getState().equals(StatusState.OBJECT_TRANSFER_IN_PROCESS)) {
			try {
				System.out.println("Large data object is still in transfering, please wait for 3 seconds...");
				Thread.currentThread().sleep(sleep_time);
				waiting_time += sleep_time;
	  			if(waiting_time > WAITING_TIME_OUT) {  // tired of waiting, get out
	  				throw new Exception("CaGeneFilterServiceContextResource::getSingleChannelExpressionDataCollection() - Timeout exception: waiting too long for the data...");
	  			}
			}
			catch(Exception ew) {
				throw ew;
			}
		}


		return m_largeSingleChannelExpData;
	}

/*
	public void setSingleChannelExpresionDataCollection(final org.bioconductor.cagrid.data.SingleChannelExpressionDataCollection retSingleChannelExpData)
	{
		m_retSingleChannelExpData = retSingleChannelExpData;
	}
*/
	public void setExpresionDataCollection(final org.bioconductor.cagrid.data.AbstractExpressionDataCollection expDataCollection)
	{
		m_returnedExpDataCollection = expDataCollection;
	}
	
	
	private org.bioconductor.cagrid.data.TwoChannelExpressionDataCollection convertToExpressionDataCollection(final Object[] returnedObjArr) throws Exception
	{
		try {
			RJNumericMatrix redDataCollection = (RJNumericMatrix)returnedObjArr[0];
			RJNumericMatrix greenDataCollection = (RJNumericMatrix)returnedObjArr[1];

			return CaGeneFilterHelper.convertToTwoChannelExpressionDataCollection(redDataCollection, greenDataCollection);
		}
		catch(ClassCastException ew) {
			throw ew;
		}
		catch(Exception ew) {
			throw ew;
		}
	}
	
	public org.bioconductor.cagrid.statefulservices.Status getStatus()
	{
		return m_status;
	}

	/**********************************************************************
	 * Implementation section for HelperServiceContextResource interface  *
	 **********************************************************************/
	public String identifyContextSelf()
	{
		return ("I am  CaGeneFilterContextResource...");
	}

	public org.bioconductor.cagrid.statefulservices.CaGridFileReferenceCollection createUploadFileReferences(org.bioconductor.cagrid.rservices.FileReferenceCollection fileRefCollection) throws RemoteException
	{
		// mapping cagrid FileReferences to RWebServices FileReferences:
		org.bioconductor.cagrid.rservices.FileReference[] cagridFileRefArr = fileRefCollection.getFileReferenceCollection();
		int fileRefLength = cagridFileRefArr.length;
		if(fileRefLength == 0) {
			return new org.bioconductor.cagrid.statefulservices.CaGridFileReferenceCollection();
		}
		
		org.bioconductor.packages.rservices.FileReference[] rwsFileReferenceArr = new org.bioconductor.packages.rservices.FileReference[fileRefLength];
		for(int i = 0; i < fileRefLength; i++) {
			// mapping this FileReference to RWebService FileReference:
			rwsFileReferenceArr[i] = new org.bioconductor.packages.rservices.FileReference(cagridFileRefArr[i].getUrl(), cagridFileRefArr[i].getLocalName(), 
					                                                                       cagridFileRefArr[i].getType());
		}
		
		 
		org.bioconductor.packages.rservices.FileReferences rwsFileReferences = 
				                        new org.bioconductor.packages.rservices.FileReferences(rwsFileReferenceArr);
			
		return this.setDataFilesInput(rwsFileReferences);
					
	}
	
	public org.bioconductor.cagrid.rservices.FileReferenceCollection getFileReferenceCollection() throws RemoteException 
	{
		throw new RemoteException("getFileReferenceCollection is not applicable for CaGeneFilter.  Not implemented.");
	}

	public org.bioconductor.cagrid.statefulservices.CaGridObjectReference createUploadObjectReference() throws RemoteException
	{
		try {
			DataDescriptor dd = new DataDescriptor(null, "Object Data from users");

			DataStagedCallback callback = new DataStagedCallback() {
				public void dataStaged(TransferServiceContextResource transSrvCxtResrc) {
					System.out.println("Start getting SingleChannelExpressionDataCollection from user.");
					m_status.setDescription("Getting a large data object sent from user...");
					m_status.setState(StatusState.OBJECT_TRANSFER_IN_PROCESS);
					java.io.File dataFileSentFromUser = new java.io.File(transSrvCxtResrc.getDataStorageDescriptor().getLocation());

					try {
						System.out.println("CaGeneFilerServiceContextResouce::callback - downloading transfered object.");
						java.io.ObjectInputStream objInstream = new java.io.ObjectInputStream(new java.io.FileInputStream(dataFileSentFromUser));
						m_largeSingleChannelExpData = (org.bioconductor.cagrid.data.SingleChannelExpressionDataCollection)objInstream.readObject();

						System.out.println("Done getting SingleChannelExpressionDataCollection from user.");
						m_status.setDescription("Done getting large data object");
						m_status.setState(StatusState.OBJECT_TRANSFER_COMPLETE);
					}
					catch(Exception ew) {
						ew.printStackTrace();
					}
				}
			};

			System.out.println("CaGeneFilerServiceContextResouce::callback - done downloading transfered object.");

			TransferServiceContextReference transSrvCxtRef = TransferServiceHelper.createTransferContext(dd, callback);

			return new org.bioconductor.cagrid.statefulservices.CaGridObjectReference(transSrvCxtRef.getEndpointReference());
		}
		catch(Exception ew) {
			throw new RemoteException(ew.getMessage());
		}
	}


	public org.bioconductor.cagrid.statefulservices.CaGridObjectReference createDownloadObjectReference() throws RemoteException
	{
//		if(m_retSingleChannelExpData == null) throw new RemoteException("Return object SingleChannelExpressionDataCollection is null.");
		if(m_returnedExpDataCollection == null) throw new RemoteException("Returned result of expression data collection is null.");

		java.io.ObjectOutputStream objOutStream = null;
		try {
			DataDescriptor dd = new DataDescriptor(null, "Transfering large result object: SingleChannelExpressionDataCollection");

			java.io.ByteArrayOutputStream baOutStream = new java.io.ByteArrayOutputStream();
			objOutStream = new java.io.ObjectOutputStream(baOutStream);
			objOutStream.writeObject(m_returnedExpDataCollection);

			TransferServiceContextReference transSrvCxtRef = TransferServiceHelper.createTransferContext(baOutStream.toByteArray(), dd);
			return new org.bioconductor.cagrid.statefulservices.CaGridObjectReference(transSrvCxtRef.getEndpointReference());
		}
		catch(Exception ew) {
			throw new RemoteException(ew.getMessage());
		}

	}
	
	/*****************************************************
	 * End of implementation of HelperService interfaces   
	 *****************************************************/

}
