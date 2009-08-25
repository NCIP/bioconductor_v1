package org.bioconductor.packages.helper.common;

import java.rmi.RemoteException;

/** 
 * This class is autogenerated, DO NOT EDIT.
 * 
 * This interface represents the API which is accessable on the grid service from the client. 
 * 
 * @created by Introduce Toolkit version 1.2
 * 
 */
public interface HelperServiceI {

  public org.bioconductor.cagrid.statefulservices.CaGridObjectReference getUploadObjectReference(org.bioconductor.cagrid.statefulservices.SessionEndpoint sessionEndpoint) throws RemoteException ;

  public org.bioconductor.cagrid.statefulservices.CaGridObjectReference getDownloadObjectReference(org.bioconductor.cagrid.statefulservices.SessionEndpoint sessionEndpoint) throws RemoteException ;

  public org.oasis.wsrf.properties.GetMultipleResourcePropertiesResponse getMultipleResourceProperties(org.oasis.wsrf.properties.GetMultipleResourceProperties_Element params) throws RemoteException ;

  public org.oasis.wsrf.properties.GetResourcePropertyResponse getResourceProperty(javax.xml.namespace.QName params) throws RemoteException ;

  public org.oasis.wsrf.properties.QueryResourcePropertiesResponse queryResourceProperties(org.oasis.wsrf.properties.QueryResourceProperties_Element params) throws RemoteException ;

  public java.lang.String testContextLookup(org.bioconductor.cagrid.statefulservices.SessionEndpoint sessionEndpoint) throws RemoteException ;

  public org.bioconductor.cagrid.statefulservices.CaGridFileReferences getUploadFileReferences(org.bioconductor.cagrid.statefulservices.SessionEndpoint sessionEndpoint,org.bioconductor.cagrid.rservices.FileReferences fileReferences) throws RemoteException ;

}
