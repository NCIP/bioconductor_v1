package org.bioconductor.packages.caMachineLearning.service;

import java.rmi.RemoteException;

import org.bioconductor.packages.caMachineLearning.context.service.globus.resource.CaMachineLearningContextResourceHome;
import org.bioconductor.packages.caMachineLearning.context.service.globus.resource.CaMachineLearningContextResource;

/** 
 * TODO:I am the service side implementation class.  IMPLEMENT AND DOCUMENT ME
 * 
 * @created by Introduce Toolkit version 1.2
 * 
 */
public class CaMachineLearningImpl extends CaMachineLearningImplBase {
	
	private org.bioconductor.rserviceJms.services.caMachineLearning.caMachineLearning m_caMachineLearning = null;
	private java.util.HashMap m_strResrcKeyToObjResrcKeyMap = new java.util.HashMap<String, org.globus.wsrf.ResourceKey>();
	private java.util.HashMap m_strResrcKeyToHomenameMap = new java.util.HashMap<String, String>();
	
	public CaMachineLearningImpl() throws RemoteException {
		super();
		
		try{
			m_caMachineLearning = new org.bioconductor.rserviceJms.services.caMachineLearning.caMachineLearning();
		}
		catch(Exception ew) {
			throw new RemoteException(ew.getMessage());
		}
	}
	

  public org.bioconductor.cagrid.camachinelearning.MachineLearningResultCollection learn(org.bioconductor.cagrid.data.SingleChannelExpressionDataCollection singleChannelExpressionDataCollection,org.bioconductor.cagrid.camachinelearning.MachineLearningParameters cagridMachineLearningParameters) throws RemoteException {
		try {						
			org.bioconductor.packages.caCommonClasses.OneChannelExpressionData rOneChannelExpressionData = this.cagridSingleChanExpDataToROneChanExpData(singleChannelExpressionDataCollection);
						
			if(cagridMachineLearningParameters instanceof org.bioconductor.cagrid.camachinelearning.UnsupervisedMachineLearningParameters) {
								
				org.bioconductor.packages.caMachineLearning.UnsupervisedLearningParameters rUnsupervisedLearningParameters = 
					               this.mapCagridUnsupervisedParamToRUnsupervisedParam((
					            		 org.bioconductor.cagrid.camachinelearning.UnsupervisedMachineLearningParameters)cagridMachineLearningParameters);
				
				// calling unsupervised from R:				
				org.bioconductor.packages.caMachineLearning.UnsupervisedLearningOutput rUnsupervisedOutput = m_caMachineLearning.unsupervised(rOneChannelExpressionData, rUnsupervisedLearningParameters);
				
				return convertROutputToCagridResult(rUnsupervisedOutput);
			}
			else if(cagridMachineLearningParameters instanceof org.bioconductor.cagrid.camachinelearning.SupervisedMachineLearningParameters) {
				
				org.bioconductor.packages.caMachineLearning.SupervisedLearningParameters rSupervisedLearningParameters = 
					             this.mapCagridSupervisedParamToRSupervisedParam(
					            		  (org.bioconductor.cagrid.camachinelearning.SupervisedMachineLearningParameters)cagridMachineLearningParameters);
												
				// calling supervised in R:
				org.bioconductor.packages.caMachineLearning.SupervisedLearningOutput rSupervisedOutput = m_caMachineLearning.supervised(rOneChannelExpressionData, rSupervisedLearningParameters);
				return this.convertROutputToCagridResult(rSupervisedOutput);
			}
			else {				
				throw new RemoteException("Unknown type of parameter:" + cagridMachineLearningParameters.getClass().getName());
			}
		}
		catch(Exception ew) {
			ew.printStackTrace();
			throw new RemoteException(ew.getMessage());
		}
	}
	
	private org.bioconductor.packages.caCommonClasses.OneChannelExpressionData cagridSingleChanExpDataToROneChanExpData(org.bioconductor.cagrid.data.SingleChannelExpressionDataCollection singleChanExpData) throws Exception  
	{
		try { 
			org.bioconductor.packages.rservices.RJNumericMatrix rjNumericMatrix = this.convertCaGridExpDataToRJNumericMatrix(singleChanExpData.getExpressionDataCollection(), 
		  			                                                                                                          singleChanExpData.getReporterNames());
		  	org.bioconductor.packages.caCommonClasses.ExpressionMatrix expMatrix = new org.bioconductor.packages.caCommonClasses.ExpressionMatrix(rjNumericMatrix, new String[]{"ChannelOne"});
		  	
		  	return new org.bioconductor.packages.caCommonClasses.OneChannelExpressionData(expMatrix); 
		}
		catch(Exception ew) {
			throw ew;
		}
	  
	}
	
	private org.bioconductor.packages.caMachineLearning.UnsupervisedLearningParameters mapCagridUnsupervisedParamToRUnsupervisedParam(
			                                org.bioconductor.cagrid.camachinelearning.UnsupervisedMachineLearningParameters cagridMachineLearningParameters) throws Exception
	{
		org.bioconductor.packages.caMachineLearning.UnsupervisedLearningParameters rUnsupervisedLearningParameters = null;
		
		if(cagridMachineLearningParameters instanceof org.bioconductor.cagrid.camachinelearning.HierarchicalClusteringMachineLearningParameters) {
			org.bioconductor.cagrid.camachinelearning.HierarchicalClusteringMachineLearningParameters cagridHierarchicalClusterParam = 
				(org.bioconductor.cagrid.camachinelearning.HierarchicalClusteringMachineLearningParameters)cagridMachineLearningParameters;
			rUnsupervisedLearningParameters = new org.bioconductor.packages.caMachineLearning.HierarchicalClusteringParameters();
			((org.bioconductor.packages.caMachineLearning.HierarchicalClusteringParameters)rUnsupervisedLearningParameters).setClusteringMethod(
					                                                     new String[]{cagridHierarchicalClusterParam.getAlgorithm()});
			((org.bioconductor.packages.caMachineLearning.HierarchicalClusteringParameters)rUnsupervisedLearningParameters).setDistanceMetric(
					                                                     new String[]{cagridHierarchicalClusterParam.getDistanceMetric()});
			((org.bioconductor.packages.caMachineLearning.HierarchicalClusteringParameters)rUnsupervisedLearningParameters).setNumberOfClusters(
					                                                     new int[]{cagridHierarchicalClusterParam.getNumberOfClusters()});
		}
		else if(cagridMachineLearningParameters instanceof org.bioconductor.cagrid.camachinelearning.KMeansMachineLearningParameters) {
			org.bioconductor.cagrid.camachinelearning.KMeansMachineLearningParameters cagridKMeansParam = 
				(org.bioconductor.cagrid.camachinelearning.KMeansMachineLearningParameters)cagridMachineLearningParameters;
			rUnsupervisedLearningParameters = new org.bioconductor.packages.caMachineLearning.KMeansParameters();
			((org.bioconductor.packages.caMachineLearning.KMeansParameters)rUnsupervisedLearningParameters).setAlgorithm(new String[]{cagridKMeansParam.getAlgorithm()});
			((org.bioconductor.packages.caMachineLearning.KMeansParameters)rUnsupervisedLearningParameters).setNumberOfClusters(new int[]{cagridKMeansParam.getNumberOfClusters()});
		}
		else {
			throw new RemoteException("Unknown unsupervised machine learning type: " + cagridMachineLearningParameters.getClass().getName());
		}
		
		return rUnsupervisedLearningParameters;
	}
  
	private org.bioconductor.packages.caMachineLearning.SupervisedLearningParameters mapCagridSupervisedParamToRSupervisedParam(
			                               org.bioconductor.cagrid.camachinelearning.SupervisedMachineLearningParameters cagridMachineLearningParameters) throws Exception
    {
		// setup SupervisedLearningParameters attribute fields:
		org.bioconductor.cagrid.camachinelearning.SupervisedMachineLearningSampleAnnotation[] supervisedSampleAnnoArr = 
					((org.bioconductor.cagrid.camachinelearning.SupervisedMachineLearningParameters)cagridMachineLearningParameters).getSupervisedMachineLearningAnnotation();
		int length = supervisedSampleAnnoArr.length;
		String[] rSampleNameArr = new String[length];
		boolean[] rIsTrainingIndividualArr = new boolean[length];
		String[] factorValuesArr = new String[length];
		for(int i = 0; i < length; i++) {
			rSampleNameArr[i] = supervisedSampleAnnoArr[i].getSampleName();
			rIsTrainingIndividualArr[i] = supervisedSampleAnnoArr[i].isIsTrainingSample();
			factorValuesArr[i] = supervisedSampleAnnoArr[i].getObservedClassification().getValue();
		}
		org.bioconductor.packages.rservices.RJFactor rjFactor = this.convertFactorValueToRJFactor(factorValuesArr);
		 
		org.bioconductor.packages.caMachineLearning.SupervisedLearningParameters rSupervisedLearningParameters = null;
		
		if(cagridMachineLearningParameters instanceof org.bioconductor.cagrid.camachinelearning.SupportVectorMachineMachineLearningParameters) {
			rSupervisedLearningParameters = new org.bioconductor.packages.caMachineLearning.SupportVectorMachinesParameters();
		}
		else if(cagridMachineLearningParameters instanceof org.bioconductor.cagrid.camachinelearning.LinearDiscriminantAnalysisMachineLearningParameters) {
			rSupervisedLearningParameters = new org.bioconductor.packages.caMachineLearning.LinearDiscriminantAnalysisParameters();
		}
		else if(cagridMachineLearningParameters instanceof org.bioconductor.cagrid.camachinelearning.KNearestNeighborMachineLearningParameters) {
			org.bioconductor.cagrid.camachinelearning.KNearestNeighborMachineLearningParameters cagridKNearestNeighborParam = 
					(org.bioconductor.cagrid.camachinelearning.KNearestNeighborMachineLearningParameters)cagridMachineLearningParameters;
			rSupervisedLearningParameters = new org.bioconductor.packages.caMachineLearning.KNearestNeighborsParameters();
			((org.bioconductor.packages.caMachineLearning.KNearestNeighborsParameters)rSupervisedLearningParameters).setMinimumVote(new int[]{cagridKNearestNeighborParam.getMinimumVote()});
			((org.bioconductor.packages.caMachineLearning.KNearestNeighborsParameters)rSupervisedLearningParameters).setNumberOfNeighbors(new int[]{cagridKNearestNeighborParam.getNumberOfNeighbors()});					
		}
		else if(cagridMachineLearningParameters instanceof org.bioconductor.cagrid.camachinelearning.QuadraticDscriminantAnalysisMachineLearningParameters) {
			rSupervisedLearningParameters = new org.bioconductor.packages.caMachineLearning.QuadraticDiscriminantAnalysisParameters();
		}
		else if(cagridMachineLearningParameters instanceof org.bioconductor.cagrid.camachinelearning.DiagonalLinearDiscriminantAnalysisMachineLearningParameters) {
			rSupervisedLearningParameters = new org.bioconductor.packages.caMachineLearning.DiagonalLinearDiscriminantAnalysisParameters();
		}
		else if(cagridMachineLearningParameters instanceof org.bioconductor.cagrid.camachinelearning.NaiveBayesMachineLearningParameters) {
			rSupervisedLearningParameters = new org.bioconductor.packages.caMachineLearning.NaiveBayesParameters();
		}
		else {
			throw new RemoteException("Unknown supervised machine learning type: " + cagridMachineLearningParameters.getClass().getName());
		}
		
		((org.bioconductor.packages.caMachineLearning.SupervisedLearningParameters)rSupervisedLearningParameters).setSampleName(rSampleNameArr);
		((org.bioconductor.packages.caMachineLearning.SupervisedLearningParameters)rSupervisedLearningParameters).setIsTrainingIndividual(rIsTrainingIndividualArr);
		((org.bioconductor.packages.caMachineLearning.SupervisedLearningParameters)rSupervisedLearningParameters).setType(rjFactor);
		
		return rSupervisedLearningParameters;
    }
	
	private org.bioconductor.packages.rservices.RJNumericMatrix convertCaGridExpDataToRJNumericMatrix(final org.bioconductor.cagrid.data.ExpressionData[] expressDataArr, 
		                                                                                             final String[] reporterNamesArr) throws Exception
    {
      try {
		int numOfSampleCols  = expressDataArr.length;
		if(numOfSampleCols == 0) return null;  // nothing to do
		
		int sampleColSize = expressDataArr[0].getReporterValues().getValues().length;
		// columns length should be equal, data maybe missing.
		if(sampleColSize == 0) return null;  // nothing to do
		
		org.bioconductor.packages.rservices.RJNumericMatrix rjNumericMatrix = new org.bioconductor.packages.rservices.RJNumericMatrix();
		rjNumericMatrix.setDim(new int[]{sampleColSize, numOfSampleCols});
		
		// data represented in a flatten-array way:
		double[] values = new double[sampleColSize  * numOfSampleCols];
		String[] colSampleNames = new String[numOfSampleCols];
		for(int col = 0; col < numOfSampleCols; col++) {
			double[] dataArr = expressDataArr[col].getReporterValues().getValues();
			System.arraycopy(dataArr, 0, values, col * sampleColSize, sampleColSize);
			colSampleNames[col] = expressDataArr[col].getSampleName();
		}
		
		rjNumericMatrix.setValue(values);
		
		Object[] dimNames = new Object[]{reporterNamesArr, colSampleNames};
		rjNumericMatrix.setDimnames(dimNames);
		
		return rjNumericMatrix;
	  }
	  catch(Exception ew) {
		  throw ew;
	  }
	}
 
	private org.bioconductor.packages.rservices.RJFactor convertFactorValueToRJFactor(String[] factorValuesArr) 
	{
		int length = factorValuesArr.length;
		org.bioconductor.packages.rservices.RJFactor rjFactor = new org.bioconductor.packages.rservices.RJFactor();
		if(length == 0) return rjFactor;
		
		java.util.ArrayList<String> levelsList = new java.util.ArrayList<String>();
		for(int i = 0; i < length; i++) {
			if(!levelsList.contains(factorValuesArr[i])) {
				levelsList.add(factorValuesArr[i]);				
			}
		}
		
		int[] codes = new int[length];
		for(int i = 0; i < length; i++ ) {
			codes[i] = levelsList.indexOf(factorValuesArr[i]);
		}
		
		String[] levels = new String[levelsList.size()];
		for(int i = 0; i < levels.length; i++) {
			levels[i] = levelsList.get(i);
		}
		
		rjFactor.setCode(codes);
		rjFactor.setLevels(levels);
		
		return rjFactor;
	}
	
	private org.bioconductor.cagrid.camachinelearning.MachineLearningResultCollection convertROutputToCagridResult(org.bioconductor.packages.caMachineLearning.LearningOutput rOutput) throws Exception
	{
		if(rOutput instanceof org.bioconductor.packages.caMachineLearning.UnsupervisedLearningOutput) {
			org.bioconductor.packages.caMachineLearning.UnsupervisedLearningOutput rUnsupervisedOutput = (org.bioconductor.packages.caMachineLearning.UnsupervisedLearningOutput)rOutput;
			int length = rUnsupervisedOutput.getNeighbor().length;
			
			org.bioconductor.cagrid.camachinelearning.UnsupervisedMachineLearningResult cagridUnsupervisedResult[] = new 
			                                    org.bioconductor.cagrid.camachinelearning.UnsupervisedMachineLearningResult[length];
			for(int i = 0; i < length; i++) {
				cagridUnsupervisedResult[i] = new org.bioconductor.cagrid.camachinelearning.UnsupervisedMachineLearningResult();
				cagridUnsupervisedResult[i].setNeighboringPartition(String.valueOf(rUnsupervisedOutput.getNeighbor()[i]));
				cagridUnsupervisedResult[i].setPredictedPartition(String.valueOf(rUnsupervisedOutput.getPartition()[i]));
				cagridUnsupervisedResult[i].setSilhouetteWidth(rUnsupervisedOutput.getSilhouetteWidth()[i]);
				cagridUnsupervisedResult[i].setSampleName("");  // empty string for now until Tom add sample name in.
			}
			
			org.bioconductor.cagrid.camachinelearning.UnsupervisedMachineLearningResultCollection cagridUnsupervisedResultCollection = new
			                              org.bioconductor.cagrid.camachinelearning.UnsupervisedMachineLearningResultCollection();
			cagridUnsupervisedResultCollection.setUnsupervisedMachineLearningResult(cagridUnsupervisedResult);
			
			return cagridUnsupervisedResultCollection; 
		}
		else if(rOutput instanceof org.bioconductor.packages.caMachineLearning.SupervisedLearningOutput) {
			org.bioconductor.packages.caMachineLearning.SupervisedLearningOutput rSupervisedOutput = (org.bioconductor.packages.caMachineLearning.SupervisedLearningOutput)rOutput;
						 
			String[] rObservedClassification = rSupervisedOutput.getObservedClassification().asData();
			String[] rPredictedClassification = rSupervisedOutput.getPredictedClassification().asData();
			
			int length = rObservedClassification.length;
			
			org.bioconductor.cagrid.camachinelearning.SupervisedMachineLearningResult[] cagridSupervisedResult = new 
			                                     org.bioconductor.cagrid.camachinelearning.SupervisedMachineLearningResult[length];			
			for(int i = 0; i < length; i++) {
				cagridSupervisedResult[i] = new org.bioconductor.cagrid.camachinelearning.SupervisedMachineLearningResult();
				cagridSupervisedResult[i].setIsTrainingSample(rSupervisedOutput.getIsTrainingIndividual()[i]);
				cagridSupervisedResult[i].setSampleName(rSupervisedOutput.getSampleName()[i]);
				cagridSupervisedResult[i].setObservedClassification(new gov.nih.nci.caarray.domain.project.FactorValue(null, null,rObservedClassification[i]));
				cagridSupervisedResult[i].setPredictedClassification(new gov.nih.nci.caarray.domain.project.FactorValue(null, null, rPredictedClassification[i]));
			}
						
			org.bioconductor.cagrid.camachinelearning.SupervisedMachineLearningResultCollection cagridSupervisedResultCollection = new 
			                                org.bioconductor.cagrid.camachinelearning.SupervisedMachineLearningResultCollection();
			cagridSupervisedResultCollection.setSupervisedMachineLearningResult(cagridSupervisedResult);
			
			return cagridSupervisedResultCollection;
		}
		else throw new Exception("Unknown type of learning output from R: " + rOutput.getClass().getName());
	}
	
	private CaMachineLearningContextResource lookupCaMachineLearningResource(final String strResrcKey) throws Exception 
	{
		try {
			String caMachineLearningHomename = (String)m_strResrcKeyToHomenameMap.get(strResrcKey);
			org.globus.wsrf.ResourceKey resourceKey = (org.globus.wsrf.ResourceKey)m_strResrcKeyToObjResrcKeyMap.get(strResrcKey);
			
			// lookup:
			javax.naming.Context initialContext = new javax.naming.InitialContext();
			CaMachineLearningContextResourceHome caMachineLearningCxtResrcHome = (CaMachineLearningContextResourceHome)initialContext.lookup(caMachineLearningHomename);
			
			CaMachineLearningContextResource caMachineLearningCxtResrc = (CaMachineLearningContextResource)caMachineLearningCxtResrcHome.find(resourceKey);
			
			return caMachineLearningCxtResrc;
		}
		catch(org.globus.wsrf.NoSuchResourceException ew) {
			System.out.println("CaMachineLearningImple::lookupCaMachineLearning failed to find a resource: " + strResrcKey + " It's probably expired.");
			// remove it from the hashmap:
			m_strResrcKeyToObjResrcKeyMap.remove(strResrcKey);
			m_strResrcKeyToHomenameMap.remove(strResrcKey);
			
			throw new Exception("CaMachineLearningImpl::lookupCaMachineLearningResource exception: " + ew.getMessage());
		}
		catch(Exception ew) {
			throw new RemoteException(ew.getMessage());
		}
	}

	private org.bioconductor.packages.caMachineLearning.context.stubs.types.CaMachineLearningContextReference createCaMachineLearningContextReference() throws RemoteException {
		org.apache.axis.message.addressing.EndpointReferenceType epr = new org.apache.axis.message.addressing.EndpointReferenceType();
		org.bioconductor.packages.caMachineLearning.context.service.globus.resource.CaMachineLearningContextResourceHome home = null;
		org.globus.wsrf.ResourceKey resourceKey = null;
		org.apache.axis.MessageContext ctx = org.apache.axis.MessageContext.getCurrentContext();
		String servicePath = ctx.getTargetService();
		String homeName = org.globus.wsrf.Constants.JNDI_SERVICES_BASE_NAME + servicePath + "/" + "caMachineLearningContextHome";

		try {
			javax.naming.Context initialContext = new javax.naming.InitialContext();
			home = (org.bioconductor.packages.caMachineLearning.context.service.globus.resource.CaMachineLearningContextResourceHome) initialContext.lookup(homeName);
			resourceKey = home.createResource();
			
			//  Grab the newly created resource
			org.bioconductor.packages.caMachineLearning.context.service.globus.resource.CaMachineLearningContextResource thisResource = (org.bioconductor.packages.caMachineLearning.context.service.globus.resource.CaMachineLearningContextResource)home.find(resourceKey);
			
			//  This is where the creator of this resource type can set whatever needs
			//  to be set on the resource so that it can function appropriatly  for instance
			//  if you want the resouce to only have the query string then there is where you would
			//  give it the query string.
			
			
			// sample of setting creator only security.  This will only allow the caller that created
			// this resource to be able to use it.
			//thisResource.setSecurityDescriptor(gov.nih.nci.cagrid.introduce.servicetools.security.SecurityUtils.createCreatorOnlyResourceSecurityDescriptor());
			
			

			String transportURL = (String) ctx.getProperty(org.apache.axis.MessageContext.TRANS_URL);
			transportURL = transportURL.substring(0,transportURL.lastIndexOf('/') +1 );
			transportURL += "CaMachineLearningContext";
			epr = org.globus.wsrf.utils.AddressingUtils.createEndpointReference(transportURL,resourceKey);
		} catch (Exception e) {
			throw new RemoteException("Error looking up CaMachineLearningContext home:" + e.getMessage(), e);
		}

		//return the typed EPR
		org.bioconductor.packages.caMachineLearning.context.stubs.types.CaMachineLearningContextReference ref = new org.bioconductor.packages.caMachineLearning.context.stubs.types.CaMachineLearningContextReference();
		ref.setEndpointReference(epr);

		return ref;
  }

  public org.bioconductor.cagrid.statefulservices.SessionEndpoint createCaMachineLearningSession() throws RemoteException {
	  try {
		org.apache.axis.MessageContext msgCxt = org.apache.axis.MessageContext.getCurrentContext();
		String servicePath = msgCxt.getTargetService();
		String caMachineLearning_homename = org.globus.wsrf.Constants.JNDI_SERVICES_BASE_NAME + servicePath + "/" + "caMachineLearningContextHome";
		javax.naming.Context initialContext = new javax.naming.InitialContext();
		CaMachineLearningContextResourceHome caMachineLearningCxtResrcHome = (CaMachineLearningContextResourceHome)initialContext.lookup(caMachineLearning_homename);
		org.globus.wsrf.ResourceKey resourceKey = caMachineLearningCxtResrcHome.createResource();
		String strResrcKeyValue = resourceKey.getValue().toString();
		m_strResrcKeyToObjResrcKeyMap.put(strResrcKeyValue, resourceKey);
		m_strResrcKeyToHomenameMap.put(strResrcKeyValue, caMachineLearning_homename);
		
		// Use HelperService to store this resource also:
		org.bioconductor.packages.helper.common.ResourceStorage resrcStorage = org.bioconductor.packages.helper.common.ResourceStorage.getResourceStorageInstance();
		resrcStorage.storeResourceInfo(strResrcKeyValue, resourceKey, caMachineLearning_homename);
		
		return new org.bioconductor.cagrid.statefulservices.SessionEndpoint(strResrcKeyValue);
	  }
	  catch(Exception ew) {
		  throw new RemoteException(ew.getMessage());
	  }
  }

  public void invokeLearn(org.bioconductor.cagrid.statefulservices.SessionEndpoint sessionEndpoint,org.bioconductor.cagrid.camachinelearning.MachineLearningParameters cagridMachineLearningParameters) throws RemoteException {
	  String strResrcKey = sessionEndpoint.getIdentifier();
	  
	  try {		  
		  CaMachineLearningContextResource caMachineLearningCxtResrc = this.lookupCaMachineLearningResource(strResrcKey);
		  
		  caMachineLearningCxtResrc.setStatus(org.bioconductor.cagrid.statefulservices.StatusState.OPERATION_IN_PROGRESS, "Service calling R for computation");
		  		  
		  org.bioconductor.cagrid.camachinelearning.MachineLearningResultCollection cagridLearningResultCollection = null;
		  
		  // get the SingleChannelExpressionDataCollection large data in this context resource:
		  org.bioconductor.cagrid.data.SingleChannelExpressionDataCollection cagridSingleChannelDataCollection = caMachineLearningCxtResrc.getSingleExpressionDataCollectionObject();
		  // convert cagrid SingleChannelExpressionDataCollection into R-compatible type:
		  org.bioconductor.packages.caCommonClasses.OneChannelExpressionData rOneChannelExpressionData = 
			                                      this.cagridSingleChanExpDataToROneChanExpData(cagridSingleChannelDataCollection);
		  // mapping the parameter to R-compatible type:		  
		  if(cagridMachineLearningParameters instanceof org.bioconductor.cagrid.camachinelearning.UnsupervisedMachineLearningParameters) {
			  org.bioconductor.packages.caMachineLearning.UnsupervisedLearningParameters rUnsupervisedParam = 
				           this.mapCagridUnsupervisedParamToRUnsupervisedParam(
				        		   (org.bioconductor.cagrid.camachinelearning.UnsupervisedMachineLearningParameters)cagridMachineLearningParameters);
			  
			  // calling R:
			  org.bioconductor.packages.caMachineLearning.UnsupervisedLearningOutput rOutput = m_caMachineLearning.unsupervised(rOneChannelExpressionData, rUnsupervisedParam);
			  cagridLearningResultCollection = this.convertROutputToCagridResult(rOutput);
		  }
		  else if(cagridMachineLearningParameters instanceof org.bioconductor.cagrid.camachinelearning.SupervisedMachineLearningParameters) {
			  org.bioconductor.packages.caMachineLearning.SupervisedLearningParameters rSupervisedParam = 
				           this.mapCagridSupervisedParamToRSupervisedParam(
				        		   (org.bioconductor.cagrid.camachinelearning.SupervisedMachineLearningParameters)cagridMachineLearningParameters);
			  
			  // calling R:
			  org.bioconductor.packages.caMachineLearning.SupervisedLearningOutput rOutput = m_caMachineLearning.supervised(rOneChannelExpressionData, rSupervisedParam);
			  cagridLearningResultCollection = this.convertROutputToCagridResult(rOutput);
		  }
		  else {
			  caMachineLearningCxtResrc.setStatus(org.bioconductor.cagrid.statefulservices.StatusState.ERROR, 
					                              "Unknown parameter type: " + cagridMachineLearningParameters.getClass().getName());
			  throw new RemoteException("CaMachineLearningImpl::invokeLearning() - unknown parameter type: " + cagridMachineLearningParameters.getClass().getName());
		  }
		  
		  caMachineLearningCxtResrc.setGeneSetCollection(cagridLearningResultCollection);
		  caMachineLearningCxtResrc.setStatus(org.bioconductor.cagrid.statefulservices.StatusState.RESULT_AVAILABLE, 
				                               "Computing is done. Result is available for downloading.");
	  }
	  catch(Exception ew) {
		  ew.printStackTrace();
		  throw new RemoteException(ew.getMessage());
	  }
  }

  public org.bioconductor.cagrid.statefulservices.Status getStatus(org.bioconductor.cagrid.statefulservices.SessionEndpoint sessionEndpoint) throws RemoteException {
	  String strResrcKey = sessionEndpoint.getIdentifier();
	  
	  try {
		  CaMachineLearningContextResource caMachineLearningCxtResrc = this.lookupCaMachineLearningResource(strResrcKey);
		  
		  return caMachineLearningCxtResrc.getStatus();
	  }
	  catch(Exception ew) {
		  throw new RemoteException(ew.getMessage());
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

