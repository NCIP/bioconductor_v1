package org.bioconductor.packages.caGeneSetAnalysis.service;

import java.rmi.RemoteException;

/** 
 * TODO:I am the service side implementation class.  IMPLEMENT AND DOCUMENT ME
 * 
 * @created by Introduce Toolkit version 1.2
 * 
 */
public class CaGeneSetAnalysisImpl extends CaGeneSetAnalysisImplBase {
	
	private org.bioconductor.rserviceJms.services.caGeneSetAnalysis.caGeneSetAnalysis m_caGeneSetAnalysis = null;
	
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

 

  public org.bioconductor.cagrid.cagenesetanalysis.GeneSetCollection analyze(org.bioconductor.cagrid.data.TopTable topTable,org.bioconductor.cagrid.cagenesetanalysis.GeneSetParameters geneSetParameters) throws RemoteException {
	 
	 try {
		 org.bioconductor.packages.caGeneSetAnalysis.GeneSetTable resultGeneSetTable = null;
		 
		 
		 // mapping topTable type:
		 org.bioconductor.packages.caCommonClasses.TopTable rTopTable = new org.bioconductor.packages.caCommonClasses.TopTable();
		 
		 org.bioconductor.cagrid.data.TopTableEntry[] topTableEntries = topTable.getTopTableEntry();
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
		 rTopTable.setContrastSpecification(new String[]{topTable.getContrastSpecification()});
		 
		 
		 // mapping the parameter type:
		 org.bioconductor.packages.caGeneSetAnalysis.GeneSetParameters rParameters; 
		 System.out.println("CaGeneSetAnalysis analyze method receive GeneSetParameter type: " + geneSetParameters.getClass().getName());
		 if(geneSetParameters instanceof org.bioconductor.cagrid.cagenesetanalysis.DiscreteParameters) {
			 // change cagrid parameter to R parameter type:
			 if(geneSetParameters instanceof org.bioconductor.cagrid.cagenesetanalysis.GeneOntologyDiscreteParameters) {				 
				 rParameters = new org.bioconductor.packages.caGeneSetAnalysis.GeneOntologyDiscreteParameters();
				 ((org.bioconductor.packages.caGeneSetAnalysis.GeneOntologyDiscreteParameters)rParameters).setOntology(
						 new String[]{((org.bioconductor.cagrid.cagenesetanalysis.GeneOntologyDiscreteParameters)geneSetParameters).getOntology()});
			 }
			 else if(geneSetParameters instanceof org.bioconductor.cagrid.cagenesetanalysis.PfamDiscreteParameters) {
				 rParameters = new org.bioconductor.packages.caGeneSetAnalysis.PFAMDiscreteParameters();
			 }
			 else if(geneSetParameters instanceof org.bioconductor.cagrid.cagenesetanalysis.KEGGDiscreteParameters) {
				 rParameters = new org.bioconductor.packages.caGeneSetAnalysis.KEGGDiscreteParameters();
			 }
			 else {
				 throw new RemoteException("CaGeneSetAnalysis::analyzeAsDiscrete() - unknown type of parameter: " + geneSetParameters.getClass().getName());
			 }
			 
			 rParameters.setAnnotation(new String[]{geneSetParameters.getAnnotation()});
			 ((org.bioconductor.packages.caGeneSetAnalysis.DiscreteParameters)rParameters).setCategoryPValue(
					 new double[]{((org.bioconductor.cagrid.cagenesetanalysis.DiscreteParameters)geneSetParameters).getDiscretePValue()});
			 ((org.bioconductor.packages.caGeneSetAnalysis.DiscreteParameters)rParameters).setTestDirection(
					 new String[]{((org.bioconductor.cagrid.cagenesetanalysis.DiscreteParameters)geneSetParameters).getTestDirection()});
			 
			// Done with mapping, invoke R to do discrete analyze:
			 System.out.println("CaGeneSetAnalysisImpl analyze method calling R for analyzeAsDiscrete...");
			resultGeneSetTable = m_caGeneSetAnalysis.analyzeAsDiscrete(rTopTable, (org.bioconductor.packages.caGeneSetAnalysis.DiscreteParameters)rParameters);
			 
		 }
		 else if(geneSetParameters instanceof org.bioconductor.cagrid.cagenesetanalysis.ContinuousParameters) {
			 if(geneSetParameters instanceof org.bioconductor.cagrid.cagenesetanalysis.GeneOntologyContinuousParameters) {
				 rParameters = new org.bioconductor.packages.caGeneSetAnalysis.GeneOntologyContinuousParameters();
				 ((org.bioconductor.packages.caGeneSetAnalysis.GeneOntologyContinuousParameters)rParameters).setOntology(
						 new String[]{((org.bioconductor.cagrid.cagenesetanalysis.GeneOntologyContinuousParameters)geneSetParameters).getOntology()});				 
			 }
			 else if(geneSetParameters instanceof org.bioconductor.cagrid.cagenesetanalysis.PfamContinuousParameters) {
				 rParameters = new org.bioconductor.packages.caGeneSetAnalysis.PFAMContinuousParameters();
			 }
			 else if(geneSetParameters instanceof org.bioconductor.cagrid.cagenesetanalysis.KEGGContinuousParameters) {
				 rParameters = new org.bioconductor.packages.caGeneSetAnalysis.KEGGContinuousParameters();
			 }
			 else {
				 throw new RemoteException("CaGeneSetAnalysis::analyzeAsContinuous() - unknown type of parameter: " + geneSetParameters.getClass().getName());
			 }
			 
			 rParameters.setAnnotation(new String[]{geneSetParameters.getAnnotation()});
			 ((org.bioconductor.packages.caGeneSetAnalysis.ContinuousParameters)rParameters).setMinimumGenesPerGeneSet(
					 new int[]{((org.bioconductor.cagrid.cagenesetanalysis.ContinuousParameters)geneSetParameters).getMinimumGenesPerGeneSet()});
			 
			 System.out.println("CaGeneSetAnalysisImpl analyze method calling R for analyzeAsContinuous...");
			 resultGeneSetTable = m_caGeneSetAnalysis.analyzeAsContinuous(rTopTable, (org.bioconductor.packages.caGeneSetAnalysis.ContinuousParameters)rParameters); 
		 }
		 
		 System.out.println("CaGeneSetAnalysisImpl analyze return result. Convert it into cagrid type....");
		 return this.convertGeneSetTableToGeneSetCollection(resultGeneSetTable);
	}
	catch(Exception ew) {
		ew.printStackTrace();
		throw new RemoteException(ew.getMessage());
	}
		
  }
  
  private org.bioconductor.cagrid.cagenesetanalysis.GeneSetCollection convertGeneSetTableToGeneSetCollection(
		  														final org.bioconductor.packages.caGeneSetAnalysis.GeneSetTable rGeneSetTable) throws Exception 
  {
	  org.bioconductor.cagrid.cagenesetanalysis.GeneSetCollection geneSetColl; 
	  
	  if(rGeneSetTable instanceof org.bioconductor.packages.caGeneSetAnalysis.DiscreteGeneSet) {
		  geneSetColl = new org.bioconductor.cagrid.cagenesetanalysis.DiscreteGeneSet();
		  
		  // mapping DiscreteGeneSetEntry:
		  org.bioconductor.packages.caGeneSetAnalysis.DiscreteGeneSet castedDiscreteGeneSet = ((org.bioconductor.packages.caGeneSetAnalysis.DiscreteGeneSet)rGeneSetTable); 
		  int entriesLength = castedDiscreteGeneSet.getId().length;
		  org.bioconductor.cagrid.cagenesetanalysis.DiscreteGeneSetEntry[] discreteGeneSetEntries = new org.bioconductor.cagrid.cagenesetanalysis.DiscreteGeneSetEntry[entriesLength];
		  
		  for(int entry = 0; entry < entriesLength; entry++) {
			  discreteGeneSetEntries[entry] = new org.bioconductor.cagrid.cagenesetanalysis.DiscreteGeneSetEntry();
			  discreteGeneSetEntries[entry].setExpectedCount(castedDiscreteGeneSet.getExpectedCount()[entry]);
			  discreteGeneSetEntries[entry].setGeneSetId(castedDiscreteGeneSet.getId()[entry]);
			  discreteGeneSetEntries[entry].setGeneSetSize(castedDiscreteGeneSet.getGeneSetSize()[entry]);
			  discreteGeneSetEntries[entry].setPValue(castedDiscreteGeneSet.getPValue()[entry]);
			  discreteGeneSetEntries[entry].setSelectedCount(castedDiscreteGeneSet.getSelectedCount()[entry]);			  
		  }
		  
		  geneSetColl.setDescription(rGeneSetTable.getTableDescription()[0]);
		  ((org.bioconductor.cagrid.cagenesetanalysis.DiscreteGeneSet)geneSetColl).setCategoricalGeneSetEntry(discreteGeneSetEntries);
	  }
	  else if(rGeneSetTable instanceof org.bioconductor.packages.caGeneSetAnalysis.ContinuousGeneSet) {
		  geneSetColl = new org.bioconductor.cagrid.cagenesetanalysis.ContinuousGeneSet();
		  
		  // mapping DiscreteGeneSetEntry:
		  org.bioconductor.packages.caGeneSetAnalysis.ContinuousGeneSet castedContinuousGeneSet = ((org.bioconductor.packages.caGeneSetAnalysis.ContinuousGeneSet)rGeneSetTable); 
		  int entriesLength = castedContinuousGeneSet.getId().length;
		  org.bioconductor.cagrid.cagenesetanalysis.ContinuousGeneSetEntry[] continuousGeneSetEntries = new org.bioconductor.cagrid.cagenesetanalysis.ContinuousGeneSetEntry[entriesLength];
		  
		  for(int entry = 0; entry < entriesLength; entry++) {
			  continuousGeneSetEntries[entry] = new org.bioconductor.cagrid.cagenesetanalysis.ContinuousGeneSetEntry();
			  continuousGeneSetEntries[entry].setGeneSetId(castedContinuousGeneSet.getId()[entry]);
			  continuousGeneSetEntries[entry].setPValue(castedContinuousGeneSet.getPValue()[entry]);
			  continuousGeneSetEntries[entry].setGeneSetSize(castedContinuousGeneSet.getGeneSetSize()[entry]);   
			  continuousGeneSetEntries[entry].setTAdjusted(castedContinuousGeneSet.getTAdjusted()[entry]);  
		  }
		  
		  geneSetColl.setDescription(rGeneSetTable.getTableDescription()[0]);
		  ((org.bioconductor.cagrid.cagenesetanalysis.ContinuousGeneSet)geneSetColl).setContinuousGeneSetEntry(continuousGeneSetEntries);
	  }
	  else {
		  throw new Exception("CaGeneSetAnalysisImpl::covertGeneSetTableToGeneSetCollection - unknown type: " + rGeneSetTable.getClass().getName());
	  }
	  
	  return geneSetColl;
  }

}

