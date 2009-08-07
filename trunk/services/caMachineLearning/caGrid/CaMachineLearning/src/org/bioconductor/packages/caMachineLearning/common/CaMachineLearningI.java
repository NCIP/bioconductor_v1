package org.bioconductor.packages.caMachineLearning.common;

import java.rmi.RemoteException;

/** 
 * This class is autogenerated, DO NOT EDIT.
 * 
 * This interface represents the API which is accessable on the grid service from the client. 
 * 
 * @created by Introduce Toolkit version 1.2
 * 
 */
public interface CaMachineLearningI {

  public java.lang.String getRpackageSessionInfo() throws RemoteException ;

  public org.oasis.wsrf.properties.GetMultipleResourcePropertiesResponse getMultipleResourceProperties(org.oasis.wsrf.properties.GetMultipleResourceProperties_Element params) throws RemoteException ;

  public org.oasis.wsrf.properties.GetResourcePropertyResponse getResourceProperty(javax.xml.namespace.QName params) throws RemoteException ;

  public org.oasis.wsrf.properties.QueryResourcePropertiesResponse queryResourceProperties(org.oasis.wsrf.properties.QueryResourceProperties_Element params) throws RemoteException ;

  public org.bioconductor.cagrid.camachinelearning.MachineLearningResultCollection learn(org.bioconductor.cagrid.data.SingleChannelExpressionDataCollection singleChannelExpressionDataCollection,org.bioconductor.cagrid.camachinelearning.MachineLearningParameters cagridMachineLearningParameters) throws RemoteException ;

  public org.bioconductor.cagrid.statefulservices.SessionEndpoint createCaMachineLearningSession() throws RemoteException ;

  public void invokeLearn(org.bioconductor.cagrid.statefulservices.SessionEndpoint sessionEndpoint,org.bioconductor.cagrid.camachinelearning.MachineLearningParameters cagridMachineLearningParameters) throws RemoteException ;

  public org.bioconductor.cagrid.statefulservices.Status getStatus(org.bioconductor.cagrid.statefulservices.SessionEndpoint sessionEndpoint) throws RemoteException ;

}

