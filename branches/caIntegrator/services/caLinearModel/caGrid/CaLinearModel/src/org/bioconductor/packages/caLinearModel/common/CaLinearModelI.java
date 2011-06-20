package org.bioconductor.packages.caLinearModel.common;

import java.rmi.RemoteException;

/** 
 * This class is autogenerated, DO NOT EDIT.
 * 
 * This interface represents the API which is accessable on the grid service from the client. 
 * 
 * @created by Introduce Toolkit version 1.2
 * 
 */
public interface CaLinearModelI {

  public org.oasis.wsrf.properties.GetMultipleResourcePropertiesResponse getMultipleResourceProperties(org.oasis.wsrf.properties.GetMultipleResourceProperties_Element params) throws RemoteException ;

  public org.oasis.wsrf.properties.GetResourcePropertyResponse getResourceProperty(javax.xml.namespace.QName params) throws RemoteException ;

  public org.oasis.wsrf.properties.QueryResourcePropertiesResponse queryResourceProperties(org.oasis.wsrf.properties.QueryResourceProperties_Element params) throws RemoteException ;

  public org.bioconductor.cagrid.data.TopTableCollection fit(org.bioconductor.cagrid.data.SingleChannelExpressionDataCollection singleChannelExpressionDataCollection,org.bioconductor.cagrid.calinearmodel.OneChannelModel oneChannelModel) throws RemoteException ;

  public org.bioconductor.cagrid.data.TopTableCollection twoChannelFit(org.bioconductor.cagrid.data.TwoChannelExpressionDataCollection twoChannelExpressionDataCollection,org.bioconductor.cagrid.calinearmodel.TwoChannelModel twoChannelModel) throws RemoteException ;

  public java.lang.String getRpackageSessionInfo() throws RemoteException ;

  public org.bioconductor.cagrid.statefulservices.SessionIdentifier createCaLinearModelSession() throws RemoteException ;

  public void invokeFit(org.bioconductor.cagrid.statefulservices.SessionIdentifier sessionIdentifier,org.bioconductor.cagrid.calinearmodel.OneChannelModel oneChannelModel) throws RemoteException ;

  public void invokeTwoChannelFit(org.bioconductor.cagrid.statefulservices.SessionIdentifier sessionIdentifier,org.bioconductor.cagrid.calinearmodel.TwoChannelModel twoChannelModel) throws RemoteException ;

  public org.bioconductor.cagrid.statefulservices.Status getStatus(org.bioconductor.cagrid.statefulservices.SessionIdentifier sessionIdentifier) throws RemoteException ;

}
