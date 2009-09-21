package org.bioconductor.packages.caGeneSetAnalysis.context.service.globus.resource;

import org.globus.wsrf.InvalidResourceKeyException;
import org.globus.wsrf.NoSuchResourceException;
import org.globus.wsrf.ResourceException;
import org.globus.wsrf.ResourceKey;

import java.rmi.RemoteException;

import org.cagrid.transfer.context.client.TransferServiceContextClient;
import org.cagrid.transfer.context.service.globus.resource.TransferServiceContextResource;
import org.cagrid.transfer.context.service.helper.DataStagedCallback;
import org.cagrid.transfer.context.service.helper.TransferServiceHelper;
import org.cagrid.transfer.context.stubs.types.TransferServiceContextReference;
import org.cagrid.transfer.descriptor.DataDescriptor;
import org.bioconductor.cagrid.statefulservices.StatusState;


/** 
 * The implementation of this CaGeneSetAnalysisContextResource type.
 * 
 * @created by Introduce Toolkit version 1.2
 * 
 */
public class CaGeneSetAnalysisContextResource extends CaGeneSetAnalysisContextResourceBase implements org.bioconductor.packages.helper.common.HelperServiceContextResourceI {
	public static final int WAITING_TIME_OUT = 60000 * 3; // 3 mins
	
	private org.bioconductor.cagrid.statefulservices.Status m_status = null;
	private org.bioconductor.cagrid.data.TopTable m_topTable = null;
	private org.bioconductor.cagrid.cagenesetanalysis.GeneSetAnalysisResultCollection m_retGeneSetCollection = null;
	
	public CaGeneSetAnalysisContextResource() {
		m_status = new org.bioconductor.cagrid.statefulservices.Status();
		m_status.setDescription("Initializing...");
		m_status.setState(StatusState.SESSION_INITIATED);
		
	}
	
	
	public org.bioconductor.cagrid.data.TopTable getTopTableObject() throws Exception 
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
		
		return m_topTable;
	}
	
	public void setGeneSetCollection(org.bioconductor.cagrid.cagenesetanalysis.GeneSetAnalysisResultCollection geneSetColl) 
	{
		m_retGeneSetCollection = geneSetColl;
	}
	
	/* 
	 * Implementation session for HelperServiceContextResourceI
	 */
	
	/*
	 * This method is just for checking if the context resource pointing to the right one.
	 */
	public String identifyContextSelf() 
	{
		return ("I am CaGeneSetAnalysisContextResource...");
	}
	 
	/*
	 * Purpose: this method is creating a reference to upload large object.  This should be TopTable object type
	 */
	public org.bioconductor.cagrid.statefulservices.CaGridObjectReference createUploadObjectReference() throws java.rmi.RemoteException
	{
		try {
			DataDescriptor dd = new DataDescriptor(null, "Object Data from users");
			
			DataStagedCallback callback = new DataStagedCallback() {
				public void dataStaged(TransferServiceContextResource transSrvCxtResrc) {
					System.out.println("Start getting TopTable object from user:");
					m_status.setDescription("Getting a large data object sent from user...");
					m_status.setState(StatusState.OBJECT_TRANSFER_IN_PROCESS);
					java.io.File dataFileSentFromUser = new java.io.File(transSrvCxtResrc.getDataStorageDescriptor().getLocation());
					
					try {
						System.out.println("CaGeneSetAnalysis::callback - downloading transfered object...");
						java.io.ObjectInputStream ois = new java.io.ObjectInputStream(new java.io.FileInputStream(dataFileSentFromUser));
						m_topTable = (org.bioconductor.cagrid.data.TopTable)ois.readObject();
						
						System.out.println("Done getting TopTable object from user");
						m_status.setDescription("Done getting TopTable object.");
						m_status.setState(StatusState.OBJECT_TRANSFER_COMPLETE);
					}
					catch(Exception ew) {
						ew.printStackTrace();
					}
				}
			};
			
			System.out.println("CaGeneSetAnalysisContextResource::callback - done downloading TopTable transfered object.");
			TransferServiceContextReference transSrvCxtRef = TransferServiceHelper.createTransferContext(dd,callback);
			
			return new org.bioconductor.cagrid.statefulservices.CaGridObjectReference(transSrvCxtRef.getEndpointReference());
		}
		catch(Exception ew) {
			throw new java.rmi.RemoteException(ew.getMessage());
		}
	}
	
	/*
	 * Purpose: this method is creating a reference to download large object
	 */
	public org.bioconductor.cagrid.statefulservices.CaGridObjectReference createDownloadObjectReference() throws RemoteException 
	{
		if(m_retGeneSetCollection == null) throw new RemoteException("Returned GeneSetCollection object hasn't been set a result.  It's null.");
		
		java.io.ObjectOutputStream oos = null;
		try {
			DataDescriptor dd = new DataDescriptor(null, "Transfering large return result object: GeneSetCollection");
			
			java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
			oos = new java.io.ObjectOutputStream(baos);
			oos.writeObject(m_retGeneSetCollection);
			
			TransferServiceContextReference transSrvCxtRef = TransferServiceHelper.createTransferContext(baos.toByteArray(), dd);
			return new org.bioconductor.cagrid.statefulservices.CaGridObjectReference(transSrvCxtRef.getEndpointReference());
		}
		catch(Exception ew) {
			throw new RemoteException(ew.getMessage());
		}
	}
	
	
	public org.bioconductor.cagrid.statefulservices.CaGridFileReferenceCollection createUploadFileReferences(org.bioconductor.cagrid.rservices.FileReferenceCollection fileRefCollection) throws RemoteException
	{
		throw new RemoteException("createUploadFileReferences not applicable for CaGenSetAnalysis.  Not implemented");
	}
	
	public org.bioconductor.cagrid.rservices.FileReferenceCollection getFileReferenceCollection() throws RemoteException 
	{
		throw new RemoteException("getFileReferenceCollection not applicable for CaGeneSetAnalysis");
	}
	
	public org.bioconductor.cagrid.statefulservices.Status getStatus() 
	{
		return m_status;
	}
}
