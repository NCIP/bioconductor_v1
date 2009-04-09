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
import org.cagrid.transfer.descriptor.DataDescriptor;


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

	public org.bioconductor.cagrid.data.ManufacturerFileReferences setDataFilesInput(final org.bioconductor.packages.rservices.FileReferences fileReferences) throws RemoteException
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
			  cagridFileReferenceArr[i].setUrl(fileRef.getUrl());
			  cagridFileReferenceArr[i].setType(fileRef.getType());
			  cagridFileReferenceArr[i].setLocalName(fileRef.getLocalName());
		  }

		  org.bioconductor.cagrid.data.ManufacturerFileReferences manFileReferences = new org.bioconductor.cagrid.data.ManufacturerFileReferences();
		  manFileReferences.setCagridFileReferenceCollection(cagridFileReferenceArr);
		  return manFileReferences;

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

	/*
	 * Implementation part for HelperServiceContextResource interface
	 */
	public String identifyContextSelf()
	{
		return ("NNNN: I am  CaGeneFilterContextResource...");
	}

}
