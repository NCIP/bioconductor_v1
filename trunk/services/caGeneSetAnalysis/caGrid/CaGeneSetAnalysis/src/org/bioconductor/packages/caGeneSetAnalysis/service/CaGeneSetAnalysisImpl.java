package org.bioconductor.packages.caGeneSetAnalysis.service;

import java.rmi.RemoteException;
import org.bioconductor.packages.caGeneSetAnalysis.context.service.globus.resource.CaGeneSetAnalysisContextResourceHome;
import org.bioconductor.packages.caGeneSetAnalysis.context.service.globus.resource.CaGeneSetAnalysisContextResource;

/** 
 * TODO:I am the service side implementation class.  IMPLEMENT AND DOCUMENT ME
 * 
 * @created by Introduce Toolkit version 1.2
 * 
 */
public class CaGeneSetAnalysisImpl extends CaGeneSetAnalysisImplBase {
	
	private org.bioconductor.rserviceJms.services.caGeneSetAnalysis.caGeneSetAnalysis m_caGeneSetAnalysis = null;
	private java.util.HashMap m_strResrcKeyToObjResrcKeyMap = new java.util.HashMap<String, org.globus.wsrf.ResourceKey>();
	private java.util.HashMap m_strResrcKeyToHomenameMap = new java.util.HashMap<String, String>();
	
	public CaGeneSetAnalysisImpl() throws RemoteException {
		super();
		
		try {
			m_caGeneSetAnalysis = new org.bioconductor.rserviceJms.services.caGeneSetAnalysis.caGeneSetAnalysis();
		}
		catch(Exception ew) {
			throw new RemoteException(ew.getMessage());
		}
	}
	

	 
	 private org.bioconductor.packages.caGeneSetAnalysis.context.stubs.types.CaGeneSetAnalysisContextReference createCaGeneSetAnalysisContextReference() throws RemoteException {
		org.apache.axis.message.addressing.EndpointReferenceType epr = new org.apache.axis.message.addressing.EndpointReferenceType();
		org.bioconductor.packages.caGeneSetAnalysis.context.service.globus.resource.CaGeneSetAnalysisContextResourceHome home = null;
		org.globus.wsrf.ResourceKey resourceKey = null;
		org.apache.axis.MessageContext ctx = org.apache.axis.MessageContext.getCurrentContext();
		String servicePath = ctx.getTargetService();
		String homeName = org.globus.wsrf.Constants.JNDI_SERVICES_BASE_NAME + servicePath + "/" + "caGeneSetAnalysisContextHome";

		try {
			javax.naming.Context initialContext = new javax.naming.InitialContext();
			home = (org.bioconductor.packages.caGeneSetAnalysis.context.service.globus.resource.CaGeneSetAnalysisContextResourceHome) initialContext.lookup(homeName);
			resourceKey = home.createResource();
			
			//  Grab the newly created resource
			org.bioconductor.packages.caGeneSetAnalysis.context.service.globus.resource.CaGeneSetAnalysisContextResource thisResource = (org.bioconductor.packages.caGeneSetAnalysis.context.service.globus.resource.CaGeneSetAnalysisContextResource)home.find(resourceKey);
			
			//  This is where the creator of this resource type can set whatever needs
			//  to be set on the resource so that it can function appropriatly  for instance
			//  if you want the resouce to only have the query string then there is where you would
			//  give it the query string.
			
			
			// sample of setting creator only security.  This will only allow the caller that created
			// this resource to be able to use it.
			//thisResource.setSecurityDescriptor(gov.nih.nci.cagrid.introduce.servicetools.security.SecurityUtils.createCreatorOnlyResourceSecurityDescriptor());
			
			

			String transportURL = (String) ctx.getProperty(org.apache.axis.MessageContext.TRANS_URL);
			transportURL = transportURL.substring(0,transportURL.lastIndexOf('/') +1 );
			transportURL += "CaGeneSetAnalysisContext";
			epr = org.globus.wsrf.utils.AddressingUtils.createEndpointReference(transportURL,resourceKey);
		} catch (Exception e) {
			throw new RemoteException("Error looking up CaGeneSetAnalysisContext home:" + e.getMessage(), e);
		}

		//return the typed EPR
		org.bioconductor.packages.caGeneSetAnalysis.context.stubs.types.CaGeneSetAnalysisContextReference ref = new org.bioconductor.packages.caGeneSetAnalysis.context.stubs.types.CaGeneSetAnalysisContextReference();
		ref.setEndpointReference(epr);

		return ref;
	 }

 

  public org.bioconductor.cagrid.cagenesetanalysis.GeneSetAnalysisResultCollection analyze(org.bioconductor.cagrid.data.TopTable topTable,org.bioconductor.cagrid.cagenesetanalysis.GeneSetAnalysisParameters geneSetAnalysisParameters) throws RemoteException {
	 
	 try {
		 org.bioconductor.packages.caGeneSetAnalysis.GeneSetAnalysisResultCollection geneSetResultColl = null;
		 
		 // mapping topTable type:
		 org.bioconductor.packages.caCommonClasses.TopTable rTopTable = this.mappingToRTopTable(topTable);
		 
		 // mapping the parameter type:
		 org.bioconductor.packages.caGeneSetAnalysis.GeneSetAnalysisParameters rParameters = this.mappingToRGeneSetParameters(geneSetAnalysisParameters); 
		
		 System.out.println("CaGeneSetAnalysis analyze method receive GeneSetParameter type: " + geneSetAnalysisParameters.getClass().getName());
		 if(geneSetAnalysisParameters instanceof org.bioconductor.cagrid.cagenesetanalysis.DiscreteGeneSetAnalysisParameters) {
			 
			// Done with mapping, invoke R to do discrete analyze:
	  	    System.out.println("CaGeneSetAnalysisImpl analyze method calling R for analyzeAsDiscrete...");
	  	    geneSetResultColl = m_caGeneSetAnalysis.analyzeAsDiscrete(rTopTable, (org.bioconductor.packages.caGeneSetAnalysis.DiscreteGeneSetAnalysisParameters)rParameters);
			 
		 }
		 else if(geneSetAnalysisParameters instanceof org.bioconductor.cagrid.cagenesetanalysis.ContinuousGeneSetAnalysisParameters) {
			 
			 System.out.println("CaGeneSetAnalysisImpl analyze method calling R for analyzeAsContinuous...");
			 geneSetResultColl = m_caGeneSetAnalysis.analyzeAsContinuous(rTopTable, (org.bioconductor.packages.caGeneSetAnalysis.ContinuousGeneSetAnalysisParameters)rParameters); 
		 }
		 
		 System.out.println("CaGeneSetAnalysisImpl analyze return result. Convert it into cagrid type....");
		 return this.convertRResultToCagridResult(geneSetResultColl);
	}
	catch(Exception ew) {
		ew.printStackTrace();
		throw new RemoteException(ew.getMessage());
	}
		
  }
  
  
  private org.bioconductor.packages.caCommonClasses.TopTable mappingToRTopTable(org.bioconductor.cagrid.data.TopTable cagridTopTable)
  {
	  org.bioconductor.packages.caCommonClasses.TopTable rTopTable = new org.bioconductor.packages.caCommonClasses.TopTable();
		 
	 org.bioconductor.cagrid.data.TopTableEntry[] topTableEntries = cagridTopTable.getTopTableEntry();
	 int topTableEntryLength = topTableEntries.length;
	 
	 double[] adjustedPValues = new double[topTableEntryLength];
	 double[] logFoldChanges = new double[topTableEntryLength];
	 double[] logOddsScores = new double[topTableEntryLength];
	 double[] pValues = new double[topTableEntryLength];
	 String[] reporterNames = new String[topTableEntryLength];
	 double[] tCoeffients = new double[topTableEntryLength];
	 
	 for(int ttEntry = 0; ttEntry < topTableEntryLength; ttEntry++) {
		 adjustedPValues[ttEntry] = topTableEntries[ttEntry].getAdjustedPValue();
		 logFoldChanges[ttEntry] = topTableEntries[ttEntry].getLogFoldChange();
		 logOddsScores[ttEntry] = topTableEntries[ttEntry].getLogOddsScore();
		 pValues[ttEntry] = topTableEntries[ttEntry].getPValue();
		 reporterNames[ttEntry] = topTableEntries[ttEntry].getReporterName();
		 tCoeffients[ttEntry] = topTableEntries[ttEntry].getTCoefficient();
	 }
	 
	 rTopTable.setAdjustedPValue(adjustedPValues);
	 rTopTable.setLogFoldChange(logFoldChanges);
	 rTopTable.setLogOddsScore(logOddsScores);
	 rTopTable.setPValue(pValues);
	 rTopTable.setReporterName(reporterNames);
	 rTopTable.setTCoefficient(tCoeffients);
	 rTopTable.setContrastSpecification(new String[]{cagridTopTable.getContrastSpecification()});
	 
	 return rTopTable;
	 
  }
  
  private org.bioconductor.packages.caGeneSetAnalysis.GeneSetAnalysisParameters mappingToRGeneSetParameters(
		                                 org.bioconductor.cagrid.cagenesetanalysis.GeneSetAnalysisParameters cagridGeneSetParameters) throws Exception
  {
	// mapping the parameter type:
	 org.bioconductor.packages.caGeneSetAnalysis.GeneSetAnalysisParameters rParameters = null; 
	 System.out.println("CaGeneSetAnalysis analyze method receive GeneSetParameter type: " + cagridGeneSetParameters.getClass().getName());
	 if(cagridGeneSetParameters instanceof org.bioconductor.cagrid.cagenesetanalysis.DiscreteGeneSetAnalysisParameters) {
		 // change cagrid parameter to R parameter type:
		 if(cagridGeneSetParameters instanceof org.bioconductor.cagrid.cagenesetanalysis.GeneOntologyDiscreteGeneSetAnalysisParameters) {				 
			 rParameters = new org.bioconductor.packages.caGeneSetAnalysis.GeneOntologyDiscreteGeneSetAnalysisParameters();
			 ((org.bioconductor.packages.caGeneSetAnalysis.GeneOntologyDiscreteGeneSetAnalysisParameters)rParameters).setOntology(
					 new String[]{((org.bioconductor.cagrid.cagenesetanalysis.GeneOntologyDiscreteGeneSetAnalysisParameters)cagridGeneSetParameters).getOntology()});
		 }
		 else if(cagridGeneSetParameters instanceof org.bioconductor.cagrid.cagenesetanalysis.PfamDiscreteGeneSetAnalysisParameters) {
			 rParameters = new org.bioconductor.packages.caGeneSetAnalysis.PFAMDiscreteGeneSetAnalysisParameters();
		 }
		 else if(cagridGeneSetParameters instanceof org.bioconductor.cagrid.cagenesetanalysis.KEGGDiscreteGeneSetAnalysisParameters) {
			 rParameters = new org.bioconductor.packages.caGeneSetAnalysis.KEGGDiscreteGeneSetAnalysisParameters();
		 }
		 else {
			 throw new RemoteException("CaGeneSetAnalysis::analyzeAsDiscrete() - unknown type of parameter: " + cagridGeneSetParameters.getClass().getName());
		 }
		 
		 rParameters.setAnnotation(new String[]{cagridGeneSetParameters.getAnnotation()});
		 ((org.bioconductor.packages.caGeneSetAnalysis.DiscreteGeneSetAnalysisParameters)rParameters).setDiscretePValue(
				 new double[]{((org.bioconductor.cagrid.cagenesetanalysis.DiscreteGeneSetAnalysisParameters)cagridGeneSetParameters).getDiscretePValue()});
		 ((org.bioconductor.packages.caGeneSetAnalysis.DiscreteGeneSetAnalysisParameters)rParameters).setTestDirection(
				 new String[]{((org.bioconductor.cagrid.cagenesetanalysis.DiscreteGeneSetAnalysisParameters)cagridGeneSetParameters).getTestDirection()});
		 
		// Done with mapping, invoke R to do discrete analyze:
//		 System.out.println("CaGeneSetAnalysisImpl analyze method calling R for analyzeAsDiscrete...");
//			resultGeneSetTable = m_caGeneSetAnalysis.analyzeAsDiscrete(rTopTable, (org.bioconductor.packages.caGeneSetAnalysis.DiscreteParameters)rParameters);
		 
	 }
	 else if(cagridGeneSetParameters instanceof org.bioconductor.cagrid.cagenesetanalysis.ContinuousGeneSetAnalysisParameters) {
		 if(cagridGeneSetParameters instanceof org.bioconductor.cagrid.cagenesetanalysis.GeneOntologyContinuousGeneSetAnalysisParameters) {
			 rParameters = new org.bioconductor.packages.caGeneSetAnalysis.GeneOntologyContinuousGeneSetAnalysisParameters();
			 ((org.bioconductor.packages.caGeneSetAnalysis.GeneOntologyContinuousGeneSetAnalysisParameters)rParameters).setOntology(
					 new String[]{((org.bioconductor.cagrid.cagenesetanalysis.GeneOntologyContinuousGeneSetAnalysisParameters)cagridGeneSetParameters).getOntology()});				 
		 }
		 else if(cagridGeneSetParameters instanceof org.bioconductor.cagrid.cagenesetanalysis.PfamContinuousGeneSetAnalysisParameters) {
			 rParameters = new org.bioconductor.packages.caGeneSetAnalysis.PFAMContinuousGeneSetAnalysisParameters();
		 }
		 else if(cagridGeneSetParameters instanceof org.bioconductor.cagrid.cagenesetanalysis.KEGGContinuousGeneSetAnalysisParameters) {
			 rParameters = new org.bioconductor.packages.caGeneSetAnalysis.KEGGContinuousGeneSetAnalysisParameters();
		 }
		 else {
			 throw new RemoteException("CaGeneSetAnalysis::analyzeAsContinuous() - unknown type of parameter: " + cagridGeneSetParameters.getClass().getName());
		 }
		 
		 rParameters.setAnnotation(new String[]{cagridGeneSetParameters.getAnnotation()});
		 ((org.bioconductor.packages.caGeneSetAnalysis.ContinuousGeneSetAnalysisParameters)rParameters).setMinimumGenesPerGeneSet(
				 new int[]{((org.bioconductor.cagrid.cagenesetanalysis.ContinuousGeneSetAnalysisParameters)cagridGeneSetParameters).getMinimumGenesPerGeneSet()});
		 
//		 System.out.println("CaGeneSetAnalysisImpl analyze method calling R for analyzeAsContinuous...");
//			 resultGeneSetTable = m_caGeneSetAnalysis.analyzeAsContinuous(rTopTable, (org.bioconductor.packages.caGeneSetAnalysis.ContinuousParameters)rParameters); 
	 }
	 
	 return rParameters;
  }
  
  private org.bioconductor.cagrid.cagenesetanalysis.GeneSetAnalysisResultCollection convertRResultToCagridResult(
		  														final org.bioconductor.packages.caGeneSetAnalysis.GeneSetAnalysisResultCollection rGeneSetResultColl) throws Exception 
  {
	  org.bioconductor.cagrid.cagenesetanalysis.GeneSetAnalysisResultCollection cagridGeneSetResultColl;
	   	  
	  if(rGeneSetResultColl instanceof org.bioconductor.packages.caGeneSetAnalysis.DiscreteGeneSetAnalysisResultCollection) {
		  cagridGeneSetResultColl = new org.bioconductor.cagrid.cagenesetanalysis.DiscreteGeneSetAnalysisResultCollection();
		  
		  // mapping DiscreteGeneSetEntry:
		  org.bioconductor.packages.caGeneSetAnalysis.DiscreteGeneSetAnalysisResultCollection castedDiscreteGeneSetResult = 
			                                      ((org.bioconductor.packages.caGeneSetAnalysis.DiscreteGeneSetAnalysisResultCollection)rGeneSetResultColl);		  
		  int resultsLength = castedDiscreteGeneSetResult.getGeneSetId().length;		  
		  org.bioconductor.cagrid.cagenesetanalysis.DiscreteGeneSetAnalysisResult[] discreteGeneSetResults = 
			                                              new org.bioconductor.cagrid.cagenesetanalysis.DiscreteGeneSetAnalysisResult[resultsLength];

		  for(int result = 0; result < resultsLength; result++) {
			  discreteGeneSetResults[result] = new org.bioconductor.cagrid.cagenesetanalysis.DiscreteGeneSetAnalysisResult();
			  discreteGeneSetResults[result].setExpectedCount(castedDiscreteGeneSetResult.getExpectedCount()[result]);
			  discreteGeneSetResults[result].setSelectedCount(castedDiscreteGeneSetResult.getSelectedCount()[result]);
			  discreteGeneSetResults[result].setGeneSetId(castedDiscreteGeneSetResult.getGeneSetId()[result]);
			  discreteGeneSetResults[result].setGeneSetSize(castedDiscreteGeneSetResult.getGeneSetSize()[result]);
			  discreteGeneSetResults[result].setPValue(castedDiscreteGeneSetResult.getPValue()[result]);
			  			  			  			  			  
			  String[] rResultGeneSetMembers = (String[])castedDiscreteGeneSetResult.getGeneSetMembers()[result];			  
			  org.bioconductor.cagrid.cagenesetanalysis.GeneSetMember[] cagridGeneSetMemberArr = 
				                                 new org.bioconductor.cagrid.cagenesetanalysis.GeneSetMember[rResultGeneSetMembers.length];
			  for(int member = 0; member < rResultGeneSetMembers.length; member++) {
				  cagridGeneSetMemberArr[member] = new org.bioconductor.cagrid.cagenesetanalysis.GeneSetMember();				  
				  cagridGeneSetMemberArr[member].setReporterName(rResultGeneSetMembers[member]);				  
			  }
			  
			  discreteGeneSetResults[result].setGeneSetMembers(cagridGeneSetMemberArr);
		  }
		  
		  cagridGeneSetResultColl.setDescription(rGeneSetResultColl.getDescription()[0]);
		  ((org.bioconductor.cagrid.cagenesetanalysis.DiscreteGeneSetAnalysisResultCollection)cagridGeneSetResultColl).setDiscreteGeneSetAnalysisResult(discreteGeneSetResults);
	  }
	  else if(rGeneSetResultColl instanceof org.bioconductor.packages.caGeneSetAnalysis.ContinuousGeneSetAnalysisResultCollection) {
		  cagridGeneSetResultColl = new org.bioconductor.cagrid.cagenesetanalysis.ContinuousGeneSetAnalysisResultCollection();
		  
		  // mapping DiscreteGeneSetEntry:
		  org.bioconductor.packages.caGeneSetAnalysis.ContinuousGeneSetAnalysisResultCollection castedContinuousGeneSetResult = 
			                                            ((org.bioconductor.packages.caGeneSetAnalysis.ContinuousGeneSetAnalysisResultCollection)rGeneSetResultColl); 
		  int entriesLength = castedContinuousGeneSetResult.getGeneSetId().length;
		  org.bioconductor.cagrid.cagenesetanalysis.ContinuousGeneSetAnalysisResult[] continuousGeneSetResults = 
			                                      new org.bioconductor.cagrid.cagenesetanalysis.ContinuousGeneSetAnalysisResult[entriesLength];
		  
		  for(int result = 0; result < entriesLength; result++) {
			  continuousGeneSetResults[result] = new org.bioconductor.cagrid.cagenesetanalysis.ContinuousGeneSetAnalysisResult();
			  continuousGeneSetResults[result].setGeneSetId(castedContinuousGeneSetResult.getGeneSetId()[result]);
			  continuousGeneSetResults[result].setPValue(castedContinuousGeneSetResult.getPValue()[result]);
			  continuousGeneSetResults[result].setGeneSetSize(castedContinuousGeneSetResult.getGeneSetSize()[result]);   
			  continuousGeneSetResults[result].setAdjustedTStatistic(castedContinuousGeneSetResult.getAdjustedTStatistic()[result]);
			  
			  String[] rResultGeneSetMembers = (String[])castedContinuousGeneSetResult.getGeneSetMembers()[result];			  
			  org.bioconductor.cagrid.cagenesetanalysis.GeneSetMember[] cagridGeneSetMemberArr = 
				                                 new org.bioconductor.cagrid.cagenesetanalysis.GeneSetMember[rResultGeneSetMembers.length];
			  for(int member = 0; member < rResultGeneSetMembers.length; member++) {
				  cagridGeneSetMemberArr[member] = new org.bioconductor.cagrid.cagenesetanalysis.GeneSetMember();				  
				  cagridGeneSetMemberArr[member].setReporterName(rResultGeneSetMembers[member]);				  
			  }
			  
			  continuousGeneSetResults[result].setGeneSetMembers(cagridGeneSetMemberArr);
		  }
		  		  
		  cagridGeneSetResultColl.setDescription(rGeneSetResultColl.getDescription()[0]);
		  ((org.bioconductor.cagrid.cagenesetanalysis.ContinuousGeneSetAnalysisResultCollection)cagridGeneSetResultColl).setContinuousGeneSetAnalysisResult(continuousGeneSetResults);
	  }
	  else {
		  throw new Exception("CaGeneSetAnalysisImpl::covertGeneSetTableToGeneSetCollection - unknown type: " + rGeneSetResultColl.getClass().getName());
	  }
	  
	  return cagridGeneSetResultColl;
  }
  
  private CaGeneSetAnalysisContextResource lookupCaGeneSetAnalysisResource(final String strResrcKey) throws Exception
  {
	  try {
		  String caGeneSetAnalysis_homename = (String)m_strResrcKeyToHomenameMap.get(strResrcKey);
		  org.globus.wsrf.ResourceKey resourceKey = (org.globus.wsrf.ResourceKey)m_strResrcKeyToObjResrcKeyMap.get(strResrcKey);
		  
		  //look up:
		  javax.naming.Context initialContext = new javax.naming.InitialContext();
		  CaGeneSetAnalysisContextResourceHome caGeneSetAnalysis_cxtResrcHome = (CaGeneSetAnalysisContextResourceHome)initialContext.lookup(caGeneSetAnalysis_homename);
		  
		  CaGeneSetAnalysisContextResource caGeneSetAnalysisCxtResrc = (CaGeneSetAnalysisContextResource)caGeneSetAnalysis_cxtResrcHome.find(resourceKey);
		  
		  return caGeneSetAnalysisCxtResrc;
	  }
	  catch(org.globus.wsrf.NoSuchResourceException ew) {
		  System.out.println("CaGeneSetAnalysisImpl::lookupCaGeneAnalysisResource failed to find a resource: " + strResrcKey + " It might be expired.");
		  // remove it from the hashmap:
		  m_strResrcKeyToObjResrcKeyMap.remove(strResrcKey);
		  m_strResrcKeyToHomenameMap.remove(strResrcKey);
		  throw new Exception("CaGeneSetAnalysisImpl::lookupCaGeneAnalysisResource: " + ew.getMessage());
	  }
	  catch(Exception ew) {
		  throw ew;
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

  public org.bioconductor.cagrid.statefulservices.SessionIdentifier createCaGeneSetAnalysisSession() throws RemoteException {
	  try {
		  org.apache.axis.MessageContext msgCxt = org.apache.axis.MessageContext.getCurrentContext();
		  String servicePath = msgCxt.getTargetService();
		  String caGeneSetAnalysis_homename = org.globus.wsrf.Constants.JNDI_SERVICES_BASE_NAME + servicePath + "/" + "caGeneSetAnalysisContextHome"; 
		  javax.naming.Context initialContext = new javax.naming.InitialContext();
		  CaGeneSetAnalysisContextResourceHome caGeneSetAnalysis_cxtResrcHome = (CaGeneSetAnalysisContextResourceHome)initialContext.lookup(caGeneSetAnalysis_homename);
		  org.globus.wsrf.ResourceKey resourceKey = caGeneSetAnalysis_cxtResrcHome.createResource();
		  String strResrcKeyValue = resourceKey.getValue().toString();
		  m_strResrcKeyToObjResrcKeyMap.put(strResrcKeyValue, resourceKey);
		  m_strResrcKeyToHomenameMap.put(strResrcKeyValue, caGeneSetAnalysis_homename);
		  
		  // Call HelperService to store this resource:
		  org.bioconductor.packages.helper.common.ResourceStorage resrcStorage = org.bioconductor.packages.helper.common.ResourceStorage.getResourceStorageInstance();
		  System.out.println("CaGeneSetAnalysisImpl calling HelperService to store its resource: " + strResrcKeyValue);
		  resrcStorage.storeResourceInfo(strResrcKeyValue, resourceKey, caGeneSetAnalysis_homename);
		  
		  org.bioconductor.cagrid.statefulservices.SessionIdentifier sessionIdentifier =  new org.bioconductor.cagrid.statefulservices.SessionIdentifier();
		  sessionIdentifier.setIdentifier(strResrcKeyValue);
		  sessionIdentifier.setServiceUrl((String)msgCxt.getProperty(org.apache.axis.MessageContext.TRANS_URL));
		  
		  return sessionIdentifier;
		 
	  }
	  catch(Exception ew) {
		  throw new RemoteException(ew.getMessage());
	  }
  }

  public void invokeAnalyze(org.bioconductor.cagrid.statefulservices.SessionIdentifier sessionIdentifier,org.bioconductor.cagrid.cagenesetanalysis.GeneSetAnalysisParameters geneSetAnalysisParameters) throws RemoteException {
	  String strResrcKey = sessionIdentifier.getIdentifier();
	  
	  try {
		  CaGeneSetAnalysisContextResource caGeneSetAnalysisCxtResrc = this.lookupCaGeneSetAnalysisResource(strResrcKey);
		  
		  if(caGeneSetAnalysisCxtResrc == null) throw new RemoteException("CaGeneSetAnalysisImpl::invokeAnalyze() - lookupCaGeneSetAnalysisResource return null.");
		  
		  org.bioconductor.packages.caGeneSetAnalysis.GeneSetAnalysisResultCollection geneSetResultColl = null;
		  org.bioconductor.cagrid.data.TopTable cagridTopTable = caGeneSetAnalysisCxtResrc.getTopTableObject();
		  org.bioconductor.packages.caCommonClasses.TopTable rTopTable = this.mappingToRTopTable(cagridTopTable);
		  org.bioconductor.packages.caGeneSetAnalysis.GeneSetAnalysisParameters rParameters = this.mappingToRGeneSetParameters(geneSetAnalysisParameters);
		  
		  System.out.println("CaGeneSetAnalysis::invokeAnalyze receive GeneSetParameter type: " + geneSetAnalysisParameters.getClass().getName());
		  if(geneSetAnalysisParameters instanceof org.bioconductor.cagrid.cagenesetanalysis.DiscreteGeneSetAnalysisParameters) {
			System.out.println("CaGeneSetAnalysisImpl analyze method calling R for analyzeAsDiscrete...");
			geneSetResultColl = m_caGeneSetAnalysis.analyzeAsDiscrete(rTopTable, (org.bioconductor.packages.caGeneSetAnalysis.DiscreteGeneSetAnalysisParameters)rParameters);
			
		  }
		  else if(geneSetAnalysisParameters instanceof org.bioconductor.cagrid.cagenesetanalysis.ContinuousGeneSetAnalysisParameters) {
			System.out.println("CaGeneSetAnalysisImpl analyze method calling R for analyzeAsContinuous...");
			geneSetResultColl = m_caGeneSetAnalysis.analyzeAsContinuous(rTopTable, (org.bioconductor.packages.caGeneSetAnalysis.ContinuousGeneSetAnalysisParameters)rParameters);
		  }
		  else {
			  throw new RemoteException("CaGeneSetAnalysis::invokeAnalyze() - unknown parameter type: " + geneSetAnalysisParameters.getClass().getName());
		  }
		  
		  caGeneSetAnalysisCxtResrc.setGeneSetCollection(this.convertRResultToCagridResult(geneSetResultColl));
	  }
	  catch(Exception ew) {
		  throw new RemoteException(ew.getMessage());
	  }
  }

  public org.bioconductor.cagrid.statefulservices.Status getStatus(org.bioconductor.cagrid.statefulservices.SessionIdentifier sessionIdentifier) throws RemoteException {
	  String strResrcKey = sessionIdentifier.getIdentifier();
	  try {
		  CaGeneSetAnalysisContextResource caGeneSetAnalysisCxtResrc = this.lookupCaGeneSetAnalysisResource(strResrcKey);
		  
		  return caGeneSetAnalysisCxtResrc.getStatus();
	  }
	  catch(Exception ew) {
		  throw new RemoteException(ew.getMessage());
	  }
  }

}

