package org.bioconductor.packages.helper.service;

import java.rmi.RemoteException;

import org.bioconductor.cagrid.statefulservices.SessionIdentifier;
import org.bioconductor.packages.helper.common.ResourceStorage;
import org.bioconductor.packages.helper.common.HelperServiceContextResourceI;
 

/** 
 * TODO:I am the service side implementation class.  IMPLEMENT AND DOCUMENT ME
 * 
 * @created by Introduce Toolkit version 1.2
 * 
 */
public class HelperServiceImpl extends HelperServiceImplBase {

	
	public HelperServiceImpl() throws RemoteException {
		super();
	}
	
  public java.lang.String testContextLookup(org.bioconductor.cagrid.statefulservices.SessionIdentifier sessionIdentifier) throws RemoteException {
	  
//	  ResourceStorage resrcStorageInstance = ResourceStorage.getResourceStorageInstance();	  
	  try {
//		  HelperServiceContextResourceI cxtResource = resrcStorageInstance.lookupResourceContext(sessionEndpoint);
//		  return cxtResource.identifyContextSelf();
		  HelperServiceContextResourceI cxtResource = this.lookupResourceContext(sessionIdentifier);
		  return cxtResource.identifyContextSelf();
	  }
	  catch(Exception ew) {
		  throw new RemoteException(ew.getMessage());
	  }
	  
  }

  public org.bioconductor.cagrid.statefulservices.CaGridFileReferenceCollection getUploadFileReferences(org.bioconductor.cagrid.statefulservices.SessionIdentifier sessionIdentifier,org.bioconductor.cagrid.rservices.FileReferenceCollection fileReferenceCollection) throws RemoteException {
	  	  
	  try {
		  HelperServiceContextResourceI cxtResource = this.lookupResourceContext(sessionIdentifier);
		  return cxtResource.createUploadFileReferences(fileReferenceCollection);
	  }
	  catch(Exception ew) {
		  throw new RemoteException(ew.getMessage());
	  }
  }
  
  
  private HelperServiceContextResourceI lookupResourceContext(final org.bioconductor.cagrid.statefulservices.SessionIdentifier sessionIdentifier) throws Exception
  {
	  ResourceStorage resrcStorageInstance = ResourceStorage.getResourceStorageInstance();
	  
	  try {
		  return resrcStorageInstance.lookupResourceContext(sessionIdentifier);
	  }
	  catch(Exception ew) {
		  throw ew;
	  }
  }
  

  public org.bioconductor.cagrid.statefulservices.CaGridObjectReference getUploadObjectReference(org.bioconductor.cagrid.statefulservices.SessionIdentifier sessionIdentifier) throws RemoteException {
	  try {
		  HelperServiceContextResourceI cxtResource = this.lookupResourceContext(sessionIdentifier);
		  return cxtResource.createUploadObjectReference();
	  }
	  catch(Exception ew) {
		  throw new RemoteException(ew.getMessage());
	  }
  }

  
  public org.bioconductor.cagrid.statefulservices.CaGridObjectReference getDownloadObjectReference(org.bioconductor.cagrid.statefulservices.SessionIdentifier sessionIdentifier) throws RemoteException {
	  try {
		  HelperServiceContextResourceI cxtResource = this.lookupResourceContext(sessionIdentifier);
		  
		  return cxtResource.createDownloadObjectReference();
	  }
	  catch(Exception ew) {
		  throw new RemoteException(ew.getMessage());
	  }
  }

  public org.bioconductor.cagrid.rservices.FileReferenceCollection getFileReferenceCollection(org.bioconductor.cagrid.statefulservices.SessionIdentifier sessionIdentifier) throws RemoteException {
	  try {
		  HelperServiceContextResourceI cxtResource = this.lookupResourceContext(sessionIdentifier);
		  
		  org.bioconductor.cagrid.rservices.FileReferenceCollection fileRefCollection = cxtResource.getFileReferenceCollection();
		  System.out.println("HelperServiceImpl::getFileReferenceCollection - returnted file collection type: " + fileRefCollection.getClass().getName());
		  
		  return fileRefCollection;
	  }
	  catch(Exception ew) {
		  throw new RemoteException(ew.getLocalizedMessage());
	  }
  }

}

