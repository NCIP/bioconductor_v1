package org.bioconductor.packages.caArrayQualityMetrics.service;

import java.rmi.RemoteException;
import org.bioconductor.packages.caArrayQualityMetrics.context.service.globus.resource.CaArrayQualityMetricsContextResourceHome;
import org.bioconductor.packages.caArrayQualityMetrics.context.service.globus.resource.CaArrayQualityMetricsContextResource;

/** 
 * TODO:I am the service side implementation class.  IMPLEMENT AND DOCUMENT ME
 * 
 * @created by Introduce Toolkit version 1.2
 * 
 */
public class CaArrayQualityMetricsImpl extends CaArrayQualityMetricsImplBase {
	
	// map of resource key to ResouceKey object
	private java.util.Map m_resourceKeyMap = new java.util.HashMap<String, org.globus.wsrf.ResourceKey>();
	private java.util.Map m_resrcKeyHomeNameMap = new java.util.HashMap<String, String>();
	
	public CaArrayQualityMetricsImpl() throws RemoteException {
		super();
	}
	

  
  private CaArrayQualityMetricsContextResource lookupCaAQMResource(final String strResrcKey) throws Exception 
  {
	  try {
		  String caAQM_homeName = (String)m_resrcKeyHomeNameMap.get(strResrcKey);		  
		  org.globus.wsrf.ResourceKey resourceKey = (org.globus.wsrf.ResourceKey)m_resourceKeyMap.get(strResrcKey);
		  
		  // look up:
		  javax.naming.Context initialContext = new javax.naming.InitialContext();
		  CaArrayQualityMetricsContextResourceHome caAQM_cxtResrcHome = (CaArrayQualityMetricsContextResourceHome) initialContext.lookup(caAQM_homeName);
		  
		  CaArrayQualityMetricsContextResource caAQMResrc = (CaArrayQualityMetricsContextResource)caAQM_cxtResrcHome.find(resourceKey);
		  
		  return caAQMResrc;
	  }
	  catch(org.globus.wsrf.NoSuchResourceException ew) {
		  m_resrcKeyHomeNameMap.remove(strResrcKey);
		  m_resourceKeyMap.remove(strResrcKey);
		  throw new Exception("NoSuchResourceException from lookupCaAQMResource: " + ew.getMessage());
	  }
	  catch(Exception ew) {		  
		  throw new Exception("Exception from lookupCaAQMResource: " + ew.getMessage(), ew);
	  }
  }

  
  public org.bioconductor.packages.caArrayQualityMetrics.context.stubs.types.CaArrayQualityMetricsContextReference createAQMContextReference() throws RemoteException {
		org.apache.axis.message.addressing.EndpointReferenceType epr = new org.apache.axis.message.addressing.EndpointReferenceType();
		org.bioconductor.packages.caArrayQualityMetrics.context.service.globus.resource.CaArrayQualityMetricsContextResourceHome home = null;
		org.globus.wsrf.ResourceKey resourceKey = null;
		org.apache.axis.MessageContext ctx = org.apache.axis.MessageContext.getCurrentContext();
		String servicePath = ctx.getTargetService();
		String homeName = org.globus.wsrf.Constants.JNDI_SERVICES_BASE_NAME + servicePath + "/" + "caArrayQualityMetricsContextHome";

		try {
			javax.naming.Context initialContext = new javax.naming.InitialContext();
			home = (org.bioconductor.packages.caArrayQualityMetrics.context.service.globus.resource.CaArrayQualityMetricsContextResourceHome) initialContext.lookup(homeName);
			resourceKey = home.createResource();
			
			//  Grab the newly created resource
			org.bioconductor.packages.caArrayQualityMetrics.context.service.globus.resource.CaArrayQualityMetricsContextResource thisResource = (org.bioconductor.packages.caArrayQualityMetrics.context.service.globus.resource.CaArrayQualityMetricsContextResource)home.find(resourceKey);
			
			//  This is where the creator of this resource type can set whatever needs
			//  to be set on the resource so that it can function appropriatly  for instance
			//  if you want the resouce to only have the query string then there is where you would
			//  give it the query string.
			
			
			// sample of setting creator only security.  This will only allow the caller that created
			// this resource to be able to use it.
			//thisResource.setSecurityDescriptor(gov.nih.nci.cagrid.introduce.servicetools.security.SecurityUtils.createCreatorOnlyResourceSecurityDescriptor());
			
			

			String transportURL = (String) ctx.getProperty(org.apache.axis.MessageContext.TRANS_URL);
			transportURL = transportURL.substring(0,transportURL.lastIndexOf('/') +1 );
			transportURL += "CaArrayQualityMetricsContext";
			epr = org.globus.wsrf.utils.AddressingUtils.createEndpointReference(transportURL,resourceKey);
		} catch (Exception e) {
			throw new RemoteException("Error looking up CaArrayQualityMetricsContext home:" + e.getMessage(), e);
		}

		//return the typed EPR
		org.bioconductor.packages.caArrayQualityMetrics.context.stubs.types.CaArrayQualityMetricsContextReference ref = new org.bioconductor.packages.caArrayQualityMetrics.context.stubs.types.CaArrayQualityMetricsContextReference();
		ref.setEndpointReference(epr);

		return ref;
  }

 

  public java.lang.String getRpackageSessionInfo() throws RemoteException {
	  try {
		  org.bioconductor.rserviceJms.services.RWebServices.RWebServices caAQM_RWS = 
			                               new org.bioconductor.rserviceJms.services.RWebServices.RWebServices();
		  
		  String[] sessionInfos = caAQM_RWS.getRSessionInfo(new boolean[]{false});
		  
		  String sessionInfo = "";
		  for(String info : sessionInfos) {			  
			  sessionInfo += info + "\n";
		  }
		  return  sessionInfo;
		  
	  }
	  catch (Exception ex) {
		  throw new RemoteException(ex.getMessage());
	  }
  }

  public org.bioconductor.cagrid.statefulservices.SessionIdentifier createQualityReportSession() throws RemoteException {
    
	try {  
		org.apache.axis.MessageContext currentMsgCxt = org.apache.axis.MessageContext.getCurrentContext();
	    String servicePath = currentMsgCxt.getTargetService();
	    String caAQM_homeName = org.globus.wsrf.Constants.JNDI_SERVICES_BASE_NAME + servicePath + "/" + "caArrayQualityMetricsContextHome";
	    
	    javax.naming.Context initialContext = new javax.naming.InitialContext();
	    CaArrayQualityMetricsContextResourceHome caAQMCxtResrcHome = (CaArrayQualityMetricsContextResourceHome)initialContext.lookup(caAQM_homeName);
	    org.globus.wsrf.ResourceKey resourceKey = caAQMCxtResrcHome.createResource();
	    
	    String strResrcKeyValue = resourceKey.getValue().toString();
	    
	    m_resourceKeyMap.put(strResrcKeyValue, resourceKey);
	    m_resrcKeyHomeNameMap.put(strResrcKeyValue, caAQM_homeName);
	    
	    String transportUrl = (String)currentMsgCxt.getProperty(org.apache.axis.MessageContext.TRANS_URL);
	    org.bioconductor.cagrid.statefulservices.SessionIdentifier sessionIdentifier = new org.bioconductor.cagrid.statefulservices.SessionIdentifier();
	    sessionIdentifier.setIdentifier(strResrcKeyValue);
	    sessionIdentifier.setServiceUrl(transportUrl);
	    
	    // Call HelperService to store this resource info also:
		org.bioconductor.packages.helper.common.ResourceStorage resrcStorage = org.bioconductor.packages.helper.common.ResourceStorage.getResourceStorageInstance();
		System.out.println("CaArrayQualityMetrics calling HelperService to store resource: " + strResrcKeyValue);
		resrcStorage.storeResourceInfo(strResrcKeyValue, resourceKey, caAQM_homeName);
	    
	    return sessionIdentifier;
	}
	catch(Exception ew) {
		throw new RemoteException("Exception in createQualityReportSession: " + ew.getMessage());
	}
    
  }
  
/*
  private org.bioconductor.cagrid.statefulservices.CaGridFileReferences getUploadQualityReportFileReferences(org.bioconductor.cagrid.statefulservices.SessionEndpoint sessionEndpoint,org.bioconductor.cagrid.rservices.FileReferenceCollection fileReferenceCollection) throws RemoteException {
    
	String strResrcKey = sessionEndpoint.getIdentifier();
	  
	try {
		CaArrayQualityMetricsContextResource caAQMResrc = this.lookupCaAQMResource(strResrcKey);
		  
		if(caAQMResrc == null) {
			throw new RemoteException("CaArrayQualityMetricsImpl::lookupContextResource() returning null for CaArrayQualityMetricsResource.");
		}
	 
		
		return caAQMResrc.createUploadFileReferences(fileReferenceCollection);
	}
	catch(Exception ew) {
		throw new RemoteException("Exception from getUploadQualityReportFileReferences: " + ew.getMessage());
	}
  }
*/
  
  public org.bioconductor.cagrid.statefulservices.Status runCaArrayQualityMetrics(org.bioconductor.cagrid.statefulservices.SessionIdentifier sessionIdentifier) throws RemoteException {
   
      String strResrcKey = sessionIdentifier.getIdentifier();
	  
	  try {
		  CaArrayQualityMetricsContextResource caAQMResrc = this.lookupCaAQMResource(strResrcKey);
		  
		  if(caAQMResrc == null) {
			  throw new RemoteException("CaArrayQualityMetricsImpl::lookupContextResource() returning null for CaArrayQualityMetricsResource.");
		  }
		  		  
		  
		  return caAQMResrc.makeReport();
	  }
	  catch(Exception ew) {
		  throw new RemoteException("CaArrayQualityMetricsImpl::runCaArrayQualityMetrics() - exception: " + ew);
	  }
  }

  public org.bioconductor.cagrid.statefulservices.Status getStatus(org.bioconductor.cagrid.statefulservices.SessionIdentifier sessionIdentifier) throws RemoteException {
   
      String strResrcKey = sessionIdentifier.getIdentifier();
	  
	  try {
		  CaArrayQualityMetricsContextResource caAQMResrc = this.lookupCaAQMResource(strResrcKey);
		  
		  if(caAQMResrc == null) {
			  throw new RemoteException("CaArrayQualityMetricsImpl::lookupContextResource() returning null for CaArrayQualityMetricsResource.");
		  }
		  		  
		  return caAQMResrc.getStatus();
	  }
	  catch(Exception ew) {
		  throw new RemoteException("CaArrayQualityMetricsImpl::getStatus() - exception: " + ew);
	  }
  }

  

  

}

