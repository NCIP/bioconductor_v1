package org.bioconductor.packages.helper.service;

import java.rmi.RemoteException;

import org.bioconductor.cagrid.statefulservices.SessionEndpoint;
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
	
  public java.lang.String testContextLookup(org.bioconductor.cagrid.statefulservices.SessionEndpoint sessionEndpoint) throws RemoteException {
	  
//	  ResourceStorage resrcStorageInstance = ResourceStorage.getResourceStorageInstance();	  
	  try {
//		  HelperServiceContextResourceI cxtResource = resrcStorageInstance.lookupResourceContext(sessionEndpoint);
//		  return cxtResource.identifyContextSelf();
		  HelperServiceContextResourceI cxtResource = this.lookupResourceContext(sessionEndpoint);
		  return cxtResource.identifyContextSelf();
	  }
	  catch(Exception ew) {
		  throw new RemoteException(ew.getMessage());
	  }
	  
  }

  public org.bioconductor.cagrid.statefulservices.CaGridFileReferences getUploadFileReferences(org.bioconductor.cagrid.statefulservices.SessionEndpoint sessionEndpoint,org.bioconductor.cagrid.rservices.FileReferences fileReferences) throws RemoteException {
	  	  
	  try {
		  HelperServiceContextResourceI cxtResource = this.lookupResourceContext(sessionEndpoint);
		  return cxtResource.createUploadFileReferences(fileReferences);
	  }
	  catch(Exception ew) {
		  throw new RemoteException(ew.getMessage());
	  }
  }
  
  
  private HelperServiceContextResourceI lookupResourceContext(final SessionEndpoint sessionEP) throws Exception
  {
	  ResourceStorage resrcStorageInstance = ResourceStorage.getResourceStorageInstance();
	  
	  try {
		  return resrcStorageInstance.lookupResourceContext(sessionEP);
	  }
	  catch(Exception ew) {
		  throw ew;
	  }
  }
  

  public org.bioconductor.cagrid.statefulservices.CaGridObjectReference getUploadObjectReference(org.bioconductor.cagrid.statefulservices.SessionEndpoint sessionEndpoint) throws RemoteException {
	  try {
		  HelperServiceContextResourceI cxtResource = this.lookupResourceContext(sessionEndpoint);
		  return cxtResource.createUploadObjectReference();
	  }
	  catch(Exception ew) {
		  throw new RemoteException(ew.getMessage());
	  }
  }

  
  public org.bioconductor.cagrid.statefulservices.CaGridObjectReference getDownloadObjectReference(org.bioconductor.cagrid.statefulservices.SessionEndpoint sessionEndpoint) throws RemoteException {
	  try {
		  HelperServiceContextResourceI cxtResource = this.lookupResourceContext(sessionEndpoint);
		  
		  return cxtResource.createDownloadObjectReference();
	  }
	  catch(Exception ew) {
		  throw new RemoteException(ew.getMessage());
	  }
  }

}

