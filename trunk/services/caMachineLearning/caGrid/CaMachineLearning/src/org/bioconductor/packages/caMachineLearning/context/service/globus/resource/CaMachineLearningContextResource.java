package org.bioconductor.packages.caMachineLearning.context.service.globus.resource;

import java.rmi.RemoteException;

import org.globus.wsrf.InvalidResourceKeyException;
import org.globus.wsrf.NoSuchResourceException;
import org.globus.wsrf.ResourceException;
import org.globus.wsrf.ResourceKey;

import org.cagrid.transfer.context.client.TransferServiceContextClient;
import org.cagrid.transfer.context.service.globus.resource.TransferServiceContextResource;
import org.cagrid.transfer.context.service.helper.DataStagedCallback;
import org.cagrid.transfer.context.service.helper.TransferServiceHelper;
import org.cagrid.transfer.context.stubs.types.TransferServiceContextReference;
import org.cagrid.transfer.descriptor.DataDescriptor;
import org.bioconductor.cagrid.statefulservices.StatusState;


/** 
 * The implementation of this CaMachineLearningContextResource type.
 * 
 * @created by Introduce Toolkit version 1.2
 * 
 */
public class CaMachineLearningContextResource extends CaMachineLearningContextResourceBase 
                                                implements org.bioconductor.packages.helper.common.HelperServiceContextResourceI{
	public static final int WAITING_TIME_OUT = 60000 * 3; // 3 mins
	
	private org.bioconductor.cagrid.statefulservices.Status m_status = null;
	private org.bioconductor.cagrid.data.SingleChannelExpressionDataCollection m_singleChannelExpressionDataCollection = null;
	private org.bioconductor.cagrid.camachinelearning.MachineLearningResultCollection m_returnMachineLearningResultCollection = null;
	
	public CaMachineLearningContextResource() 
	{
		m_status = new org.bioconductor.cagrid.statefulservices.Status();
		m_status.setDescription("Initializing...");
		m_status.setState(StatusState.SESSION_INITIATED); 
	}
	
	
	public org.bioconductor.cagrid.data.SingleChannelExpressionDataCollection getSingleExpressionDataCollectionObject() throws Exception 
	{
		// if the status is in processing of downloading from user, then wait for it:
		int waiting_time = 0;
		int sleep_time = 3000;
		
		while(m_status.getState().equals(StatusState.OBJECT_TRANSFER_IN_PROCESS)) {
			try {
				System.out.println("Large data object TopTable is still in transferting, please wait for 3 secs...");
				Thread.currentThread().sleep(sleep_time);
				waiting_time += sleep_time;
				if(waiting_time > WAITING_TIME_OUT) {
					throw new Exception("CaGeneSetAnalysisContextResource::getTopTableObject() - Timeout: waiting too long for the data...");
				}
			}
			catch(Exception ew) {
				throw ew;
			}
		}
		
		return m_singleChannelExpressionDataCollection;
	}
	
	public void setGeneSetCollection(org.bioconductor.cagrid.camachinelearning.MachineLearningResultCollection machineLearningResultCollection) 
	{
		m_returnMachineLearningResultCollection = machineLearningResultCollection;
	}
	
	public org.bioconductor.cagrid.statefulservices.Status getStatus() 
	{
		return m_status;
	}
	
	public void setStatus(StatusState statusState, String description) 
	{
		m_status.setState(statusState);
		m_status.setDescription(description);
	}
	
	/**
	 *  Implementation session for HelperServiceContextResourceI
	 **/
	
	/**
	 * This method is just for checking if the context resource pointing to the right one.
	 **/
	public String identifyContextSelf() 
	{
		return ("I am CaMachineLearningContextResource...");
	}
	
	/**
	 * This method is creating a reference to upload large object.  For this service, a large object should be SingleChannelExpressionDataCollection 
	 **/
	public org.bioconductor.cagrid.statefulservices.CaGridObjectReference createUploadObjectReference() throws java.rmi.RemoteException
	{
		try {
			DataDescriptor dd = new DataDescriptor(null, "Object Data from users");
			
			DataStagedCallback callback = new DataStagedCallback() {
				public void dataStaged(TransferServiceContextResource transSrvCxtResrc) {
					System.out.println("Start getting SingleChannleExpressionData object from user:");
					m_status.setDescription("Getting a large data object sent from user...");
					m_status.setState(StatusState.OBJECT_TRANSFER_IN_PROCESS);
					java.io.File dataFileSentFromUser = new java.io.File(transSrvCxtResrc.getDataStorageDescriptor().getLocation());
					
					try {
						System.out.println("CaMachineLearningContextResource::callback - downloading transfered object...");
						java.io.ObjectInputStream ois = new java.io.ObjectInputStream(new java.io.FileInputStream(dataFileSentFromUser));
						m_singleChannelExpressionDataCollection = (org.bioconductor.cagrid.data.SingleChannelExpressionDataCollection)ois.readObject();
						
						System.out.println("Done getting SingleChannelExpressionDataCollection object from user");
						m_status.setDescription("Done getting TopTable object.");
						m_status.setState(StatusState.OBJECT_TRANSFER_COMPLETE);
					}
					catch(Exception ew) {
						ew.printStackTrace();
					}
				}
			};
			
			System.out.println("CaMachineLearningContextResource::callback - done downloading SingleChannelExpressionDataCollection transfered object.");
			TransferServiceContextReference transSrvCxtRef = TransferServiceHelper.createTransferContext(dd,callback);
			
			return new org.bioconductor.cagrid.statefulservices.CaGridObjectReference(transSrvCxtRef.getEndpointReference());
		}
		catch(Exception ew) {
			throw new java.rmi.RemoteException(ew.getMessage());
		}
	}
	
	/**
	 * This method is creating a reference to download large object holding from the service
	 **/
	public org.bioconductor.cagrid.statefulservices.CaGridObjectReference createDownloadObjectReference() throws RemoteException 
	{
		if(m_returnMachineLearningResultCollection == null) {
			throw new RemoteException("MachineLearningResultCollection is still null.  Result isn't receieved and set from the service.");
		}
		
		java.io.ObjectOutputStream oos = null;
		try {
			DataDescriptor dd = new DataDescriptor(null, "Transfering large return result object: MachineLearningResultCollection.");
			
			java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
			oos = new java.io.ObjectOutputStream(baos);
			oos.writeObject(m_returnMachineLearningResultCollection);
			
			TransferServiceContextReference transSrvCxtRef = TransferServiceHelper.createTransferContext(baos.toByteArray(), dd);
			return new org.bioconductor.cagrid.statefulservices.CaGridObjectReference(transSrvCxtRef.getEndpointReference());
		}
		catch(Exception ew) {
			throw new RemoteException(ew.getMessage());
		}
	}
	
	/**
	 * This method is to create a reference to upload file(s) to the service.  Not applicable for this service.
	 */
	public org.bioconductor.cagrid.statefulservices.CaGridFileReferences createUploadFileReferences(org.bioconductor.cagrid.rservices.FileReferences fileRefs) throws RemoteException
	{
		throw new RemoteException("createUploadFileReferences not applicable for CaMachineLearning.  Not implemented");
	}
}
