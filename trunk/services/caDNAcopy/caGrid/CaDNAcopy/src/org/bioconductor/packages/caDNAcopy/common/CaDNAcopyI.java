package org.bioconductor.packages.caDNAcopy.common;

import java.rmi.RemoteException;

/** 
 * This class is autogenerated, DO NOT EDIT.
 * 
 * This interface represents the API which is accessable on the grid service from the client. 
 * 
 * @created by Introduce Toolkit version 1.2
 * 
 */
public interface CaDNAcopyI {

  public org.oasis.wsrf.properties.GetMultipleResourcePropertiesResponse getMultipleResourceProperties(org.oasis.wsrf.properties.GetMultipleResourceProperties_Element params) throws RemoteException ;

  public org.oasis.wsrf.properties.GetResourcePropertyResponse getResourceProperty(javax.xml.namespace.QName params) throws RemoteException ;

  public org.oasis.wsrf.properties.QueryResourcePropertiesResponse queryResourceProperties(org.oasis.wsrf.properties.QueryResourceProperties_Element params) throws RemoteException ;

  /**
   * Method takes DNAcopyAssays and DNAcopyParameter as parameters and returns a DerivedDNAcopySegment using circular binary algorithm.
   *
   * @param dNAcopyAssays
   * @param dNAcopyParameter
   */
  public org.bioconductor.cagrid.cadnacopy.DerivedDNAcopySegment getDerivedDNAcopySegment(org.bioconductor.cagrid.cadnacopy.DNAcopyAssays dNAcopyAssays,org.bioconductor.cagrid.cadnacopy.DNAcopyParameter dNAcopyParameter) throws RemoteException ;

}
