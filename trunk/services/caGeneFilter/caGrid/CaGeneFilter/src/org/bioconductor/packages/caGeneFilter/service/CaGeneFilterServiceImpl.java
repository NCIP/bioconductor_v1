package org.bioconductor.packages.caGeneFilter.service;

import java.rmi.RemoteException;

import org.bioconductor.packages.caGeneFilter.context.service.globus.resource.CaGeneFilterServiceContextResourceHome;
import org.bioconductor.packages.caGeneFilter.context.service.globus.resource.CaGeneFilterServiceContextResource;
import org.bioconductor.packages.caGeneFilter.common.CaGeneFilterHelper;


/** 
 * TODO:I am the service side implementation class.  IMPLEMENT AND DOCUMENT ME
 * 
 * @created by Introduce Toolkit version 1.2
 * 
 */
public class CaGeneFilterServiceImpl extends CaGeneFilterServiceImplBase {

	private org.bioconductor.rserviceJms.services.caGeneFilter.caGeneFilter m_caGeneFilter;
	private java.util.HashMap m_resourceKeyMap = new java.util.HashMap<String, org.globus.wsrf.ResourceKey>();
	private java.util.HashMap m_resrcKeyHomeNameMap = new java.util.HashMap<String, String>();
	
	public CaGeneFilterServiceImpl() throws RemoteException {
		super();
		
		try {
			m_caGeneFilter = new org.bioconductor.rserviceJms.services.caGeneFilter.caGeneFilter();
		}
		catch(Exception ew) {
			throw new RemoteException(ew.getMessage());
		}
	}
	

  private CaGeneFilterServiceContextResource lookupCaGeneFilterResource(final String strResrcKey) throws Exception 
  {
	  try {
		  String caGeneFilter_homename = (String)m_resrcKeyHomeNameMap.get(strResrcKey);
		  org.globus.wsrf.ResourceKey resourceKey = (org.globus.wsrf.ResourceKey)m_resourceKeyMap.get(strResrcKey);
		  
		  // look up:
		  javax.naming.Context initialContext = new javax.naming.InitialContext();
		  CaGeneFilterServiceContextResourceHome caGeneFilterCxtResrcHome = (CaGeneFilterServiceContextResourceHome)initialContext.lookup(caGeneFilter_homename);
		  
		  CaGeneFilterServiceContextResource caGeneFilterResrc = (CaGeneFilterServiceContextResource)caGeneFilterCxtResrcHome.find(resourceKey);
		  
		  return caGeneFilterResrc;
	  }
	  catch(org.globus.wsrf.NoSuchResourceException ew) {
		System.out.println("CaGeneFilterServiceImpl::lookupCaGeneFilterResource failed to find a resource");
		// clean the HashMap:
		m_resrcKeyHomeNameMap.remove(strResrcKey);
		m_resourceKeyMap.remove(strResrcKey);
		throw new Exception("CaGeneFilterServiceImpl::lookupCaGeneFilterResource: " + ew.getMessage());
	  }
	  catch(Exception ew) {
		  throw ew;
	  }
  }
  
  
  private org.bioconductor.packages.caGeneFilter.context.stubs.types.CaGeneFilterServiceContextReference createCaGeneFilterContext() throws RemoteException {
		org.apache.axis.message.addressing.EndpointReferenceType epr = new org.apache.axis.message.addressing.EndpointReferenceType();
		org.bioconductor.packages.caGeneFilter.context.service.globus.resource.CaGeneFilterServiceContextResourceHome home = null;
		org.globus.wsrf.ResourceKey resourceKey = null;
		org.apache.axis.MessageContext ctx = org.apache.axis.MessageContext.getCurrentContext();
		String servicePath = ctx.getTargetService();
		String homeName = org.globus.wsrf.Constants.JNDI_SERVICES_BASE_NAME + servicePath + "/" + "caGeneFilterServiceContextHome";

		try {
			javax.naming.Context initialContext = new javax.naming.InitialContext();
			home = (org.bioconductor.packages.caGeneFilter.context.service.globus.resource.CaGeneFilterServiceContextResourceHome) initialContext.lookup(homeName);
			resourceKey = home.createResource();
			
			//  Grab the newly created resource
			org.bioconductor.packages.caGeneFilter.context.service.globus.resource.CaGeneFilterServiceContextResource thisResource = (org.bioconductor.packages.caGeneFilter.context.service.globus.resource.CaGeneFilterServiceContextResource)home.find(resourceKey);
			
			//  This is where the creator of this resource type can set whatever needs
			//  to be set on the resource so that it can function appropriatly  for instance
			//  if you want the resouce to only have the query string then there is where you would
			//  give it the query string.
			
			
			// sample of setting creator only security.  This will only allow the caller that created
			// this resource to be able to use it.
			//thisResource.setSecurityDescriptor(gov.nih.nci.cagrid.introduce.servicetools.security.SecurityUtils.createCreatorOnlyResourceSecurityDescriptor());
			
			

			String transportURL = (String) ctx.getProperty(org.apache.axis.MessageContext.TRANS_URL);
			transportURL = transportURL.substring(0,transportURL.lastIndexOf('/') +1 );
			transportURL += "CaGeneFilterServiceContext";
			epr = org.globus.wsrf.utils.AddressingUtils.createEndpointReference(transportURL,resourceKey);
		} catch (Exception e) {
			throw new RemoteException("Error looking up CaGeneFilterServiceContext home:" + e.getMessage(), e);
		}

		//return the typed EPR
		org.bioconductor.packages.caGeneFilter.context.stubs.types.CaGeneFilterServiceContextReference ref = new org.bioconductor.packages.caGeneFilter.context.stubs.types.CaGeneFilterServiceContextReference();
		ref.setEndpointReference(epr);

		return ref;
  }

  public org.bioconductor.cagrid.data.SingleChannelExpressionDataCollection recode(org.bioconductor.cagrid.data.SingleChannelExpressionDataCollection dataCollection,org.bioconductor.cagrid.cagenefilter.Recode recode) throws RemoteException {  
	  // Mapping Recode type:
	  try {
		  org.bioconductor.packages.caGeneFilter.Recode biocRecode = null;
		  if(recode instanceof org.bioconductor.cagrid.cagenefilter.MinimumThresholdRecode) {
			  biocRecode = new org.bioconductor.packages.caGeneFilter.MinimumThresholdRecode();
			  biocRecode.setRecodeValue(new double[]{recode.getRecodeValue()});
			  ((org.bioconductor.packages.caGeneFilter.MinimumThresholdRecode)biocRecode).setMinimumThreshold(
					  new double[]{((org.bioconductor.cagrid.cagenefilter.MinimumThresholdRecode)recode).getMinimumThreshold()});
		  }
		  else if(recode instanceof org.bioconductor.cagrid.cagenefilter.MaximumThresholdRecode) {
			  biocRecode = new org.bioconductor.packages.caGeneFilter.MaximumThresholdRecode();
			  biocRecode.setRecodeValue(new double[]{recode.getRecodeValue()});
			  ((org.bioconductor.packages.caGeneFilter.MaximumThresholdRecode)biocRecode).setMaximumThreshold(
					  new double[]{((org.bioconductor.cagrid.cagenefilter.MaximumThresholdRecode) recode).getMaximumThreshold()});
		  }
		  else {
			  throw new RemoteException("CaGeneFilterServiceImpl::caGeneRecode() - exception: unknown recode type: " + recode.getClass().getName());
		  }
		  
		  // convert dataCollection to RNumberMatrix:
		  org.bioconductor.cagrid.data.ExpressionData[] expressionDataArr = dataCollection.getExpressionDataCollection();
		 
		  org.bioconductor.packages.rservices.RJNumericMatrix rjNumericMatrix = 
			                                     CaGeneFilterHelper.convertToRJNumericMatrix(expressionDataArr, dataCollection.getReporterNames()); 
		  org.bioconductor.packages.rservices.RJNumericMatrix retRJNumericMatrix = m_caGeneFilter.caGeneRecode(rjNumericMatrix, biocRecode);
		  
		  return CaGeneFilterHelper.convertToSingleChannelExpressionDataCollection(retRJNumericMatrix);
	  }
	  catch(Exception ew) {
		  throw new RemoteException(ew.getMessage());
	  }
  }

  public org.bioconductor.cagrid.data.SingleChannelExpressionDataCollection filter(org.bioconductor.cagrid.data.SingleChannelExpressionDataCollection singleChannelExpressionDataCollection,org.bioconductor.cagrid.cagenefilter.Filter filter) throws RemoteException {
	  // Mapping filter type:
	  try {
		  org.bioconductor.packages.caGeneFilter.Filter biocFilter = null;
		  
		  if(filter instanceof org.bioconductor.cagrid.cagenefilter.KOverAFilter){
			  biocFilter = new org.bioconductor.packages.caGeneFilter.KOverAFilter(new double[]{((org.bioconductor.cagrid.cagenefilter.KOverAFilter) filter).getMinimumValue()}, 
					                                                               new int[]{((org.bioconductor.cagrid.cagenefilter.KOverAFilter) filter).getMinimumElementNumber()});
		  }
		  else if(filter instanceof org.bioconductor.cagrid.cagenefilter.VarianceFilter) {
			  biocFilter = new org.bioconductor.packages.caGeneFilter.VarianceFilter(new double[]{((org.bioconductor.cagrid.cagenefilter.VarianceFilter) filter).getMinimumVariance()});
		  }
		  else if(filter instanceof org.bioconductor.cagrid.cagenefilter.MissingValueFilter) {
			  biocFilter = new org.bioconductor.packages.caGeneFilter.MissingValueFilter(new double[]{((org.bioconductor.cagrid.cagenefilter.MissingValueFilter) filter).getMissingValue()},
					                                                                     new int[]{((org.bioconductor.cagrid.cagenefilter.MissingValueFilter) filter).getMaximumNumberMissingValues()});
		  }
		  else if(filter instanceof org.bioconductor.cagrid.cagenefilter.GeneOntologyFilter){
			  biocFilter = new org.bioconductor.packages.caGeneFilter.GOFilter(new boolean[]{((org.bioconductor.cagrid.cagenefilter.GeneOntologyFilter) filter).isIsBiologicalProcess()},
					                                                           new boolean[]{((org.bioconductor.cagrid.cagenefilter.GeneOntologyFilter) filter).isIsCellularCompartment()},
					                                                           new boolean[]{((org.bioconductor.cagrid.cagenefilter.GeneOntologyFilter) filter).isIsMolecularFunction()},
					                                                           new String[]{((org.bioconductor.cagrid.cagenefilter.GeneOntologyFilter) filter).getAnnotation()});
		  }
		  else if(filter instanceof org.bioconductor.cagrid.cagenefilter.EntrezFilter){
			  biocFilter = new org.bioconductor.packages.caGeneFilter.EntrezFilter(new String[]{((org.bioconductor.cagrid.cagenefilter.EntrezFilter) filter).getAnnotation()});
		  }
		  else {
			  throw new RemoteException("CaGeneFilterServiceImpl::caGeneFilter() - exception: unknown filter type: " + filter.getClass().getName());
		  }
		  
		  // convert to singleChannelExpressionDataCollection to RJNumericMatrix
		  org.bioconductor.cagrid.data.ExpressionData[] expressionDataArr = singleChannelExpressionDataCollection.getExpressionDataCollection();
		  org.bioconductor.packages.rservices.RJNumericMatrix rjNumericMatrix = CaGeneFilterHelper.convertToRJNumericMatrix(expressionDataArr, 
				                                                                                              singleChannelExpressionDataCollection.getReporterNames());
		  org.bioconductor.packages.rservices.RJNumericMatrix retRJNumericMatrix = m_caGeneFilter.caGeneFilter(rjNumericMatrix, biocFilter);
		  
		  return CaGeneFilterHelper.convertToSingleChannelExpressionDataCollection(retRJNumericMatrix);
	  }
	  catch(Exception ew) {
		  throw new RemoteException(ew.getMessage());
	  }  
  }

  public org.bioconductor.cagrid.statefulservices.SessionEndpoint createFileRecodeSession() throws RemoteException {
	  try {
		  org.apache.axis.MessageContext msgCxt = org.apache.axis.MessageContext.getCurrentContext();
		  String servicePath = msgCxt.getTargetService();
		  String caGeneFilter_homename = org.globus.wsrf.Constants.JNDI_SERVICES_BASE_NAME + servicePath + "/" + "caGeneFilterServiceContextHome";
		  javax.naming.Context initialContext = new javax.naming.InitialContext();
		  CaGeneFilterServiceContextResourceHome caGeneFilter_cxtRsrcHome = (CaGeneFilterServiceContextResourceHome)initialContext.lookup(caGeneFilter_homename);
		  org.globus.wsrf.ResourceKey resourceKey = caGeneFilter_cxtRsrcHome.createResource();
		  String strResrcKeyValue = resourceKey.getValue().toString();
		  m_resourceKeyMap.put(strResrcKeyValue, resourceKey);
		  m_resrcKeyHomeNameMap.put(strResrcKeyValue, caGeneFilter_homename);
		  
		  // Call HelperService to store this resource info also:
		  org.bioconductor.packages.helper.common.ResourceStorage resrcStorage = org.bioconductor.packages.helper.common.ResourceStorage.getResourceStorageInstance();
		  System.out.println("CaGeneFilter calling HelperService to store resource: " + strResrcKeyValue);
		  resrcStorage.storeResourceInfo(strResrcKeyValue, resourceKey, caGeneFilter_homename);
		  
		  return new org.bioconductor.cagrid.statefulservices.SessionEndpoint(strResrcKeyValue);
	  }
	  catch(Exception ew) {
		  throw new RemoteException(ew.getMessage());
	  }
  }

  public org.bioconductor.cagrid.data.ManufacturerFileReferences getUploadManufacturerFileReferences(org.bioconductor.cagrid.statefulservices.SessionEndpoint sessionEndpoint,org.bioconductor.cagrid.rservices.FileReferences fileReferences) throws RemoteException {
	  	// mapping cagrid FileReferences to RWebServices FileReferences:
		org.bioconductor.cagrid.rservices.FileReference[] cagridFileRefArr = fileReferences.getFileReferenceCollection();
		int fileRefLength = cagridFileRefArr.length;
		if(fileRefLength == 0) {
			return new org.bioconductor.cagrid.data.ManufacturerFileReferences();
		}
		
		org.bioconductor.packages.rservices.FileReference[] rwsFileReferenceArr = new org.bioconductor.packages.rservices.FileReference[fileRefLength];
		for(int i = 0; i < fileRefLength; i++) {
			// mapping this FileReference to RWebService FileReference:
			rwsFileReferenceArr[i] = new org.bioconductor.packages.rservices.FileReference(cagridFileRefArr[i].getUrl(), cagridFileRefArr[i].getLocalName(), 
					                                                                       cagridFileRefArr[i].getType());
		}
		
		String strResrcKey = sessionEndpoint.getIdentifier();
		  
		try {
			CaGeneFilterServiceContextResource caGeneFilterResrc = this.lookupCaGeneFilterResource(strResrcKey);
			  
			if(caGeneFilterResrc == null) {
				throw new RemoteException("CaGeneFilterImple::lookupContextResource() returning null.");
			}
		 
			org.bioconductor.packages.rservices.FileReferences rwsFileReferences = 
				                        new org.bioconductor.packages.rservices.FileReferences(rwsFileReferenceArr);
			
			return caGeneFilterResrc.setDataFilesInput(rwsFileReferences);
		}
		catch(Exception ew) {
			throw new RemoteException("Exception from getFileUploadTransferReferences: " + ew.getMessage());
		}
  }

  public org.bioconductor.cagrid.data.TwoChannelExpressionDataCollection fileRecode(org.bioconductor.cagrid.statefulservices.SessionEndpoint sessionEndpoint,org.bioconductor.cagrid.cagenefilter.SpotQualityRecode spotQualityRecode) throws RemoteException {
	  String strResrcKey = sessionEndpoint.getIdentifier();
	  
	  try {
		  CaGeneFilterServiceContextResource caGeneFilterResrc = this.lookupCaGeneFilterResource(strResrcKey);
		  
		  if(caGeneFilterResrc == null) {
			  throw new RemoteException("CaGeneFilterImpl::lookupContextResource() returning null");
		  }
		  
		  
		  return caGeneFilterResrc.fileRecode(spotQualityRecode, m_caGeneFilter);
	  }
	  catch(Exception ew) {
		  throw new RemoteException("Exception from evaluate(): " + ew.getMessage());
	  }
  }

  public java.lang.String getRpackageSessionInfo() throws RemoteException {
    try {
		  org.bioconductor.rserviceJms.services.RWebServices.RWebServices caRWS = 
			                               new org.bioconductor.rserviceJms.services.RWebServices.RWebServices();
		  
		  String[] sessionInfos = caRWS.getRSessionInfo(new boolean[]{false});
		  
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

}

