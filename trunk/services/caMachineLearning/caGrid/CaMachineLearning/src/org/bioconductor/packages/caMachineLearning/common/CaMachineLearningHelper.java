package org.bioconductor.packages.caMachineLearning.common;

public class CaMachineLearningHelper {
	
	public static org.bioconductor.cagrid.data.SingleChannelExpressionDataCollection deserializeToSingleChannelExpDataCollection(String pathToROneChannelExpDataFile) throws Exception 
	{
		java.io.InputStream fileInStream = null;
		java.io.ObjectInputStream objInStream = null;
		try {
			java.io.File serializedDataFile = new java.io.File(pathToROneChannelExpDataFile);
			fileInStream = new java.io.FileInputStream(serializedDataFile);
			
			objInStream = new java.io.ObjectInputStream(fileInStream);
			Object deserializedObj = objInStream.readObject();
			// cast deserialized object to R OneChannelExpressionData:
			org.bioconductor.packages.caCommonClasses.OneChannelExpressionData rOneChannelExpData = (org.bioconductor.packages.caCommonClasses.OneChannelExpressionData)deserializedObj;
			
			// now convert this R OneChannelExpressionData into cagrid SingleChannelExpressionDataCollection:
			return convertToSingleChannelExpressionDataCollection(rOneChannelExpData.getChannelOne().getExpressionMatrix()); 
			
		}
		catch(ClassCastException ew) {
			throw new Exception(ew);
		}
		catch(Exception ew) {
			throw ew;
		}
		finally {
			if(fileInStream != null) fileInStream.close();
			if(objInStream != null) objInStream.close();
		}
	}
	
	
	private static org.bioconductor.cagrid.data.SingleChannelExpressionDataCollection 
		                          convertToSingleChannelExpressionDataCollection(final org.bioconductor.packages.rservices.RJNumericMatrix rjNumericMatrix) throws Exception
	{
		try {

				org.bioconductor.cagrid.data.ExpressionData[] expressionDataArr = convertToExpressionDataCollection(rjNumericMatrix);

				org.bioconductor.cagrid.data.SingleChannelExpressionDataCollection returnCollection = 
					                                      new org.bioconductor.cagrid.data.SingleChannelExpressionDataCollection(expressionDataArr);

				returnCollection.setReporterNames((String[])rjNumericMatrix.getDimnames()[0]);

				return returnCollection;
		}
		catch(Exception ew) {
			throw ew;
		}
	}
	
	
	private static org.bioconductor.cagrid.data.ExpressionData[] 
                                    convertToExpressionDataCollection(final org.bioconductor.packages.rservices.RJNumericMatrix rjNumericMatrix) throws Exception
    {
		try {
			// if a RJNumericMatrix is imagined as n by m matrix:
			int sampleColSize = rjNumericMatrix.getDim()[0];	// this is n
			int sampleCols = rjNumericMatrix.getDim()[1];		// this is m
			double[] rjValues = rjNumericMatrix.getValue();	// all values in flatten double array
			String[] sampleNames = (String[])rjNumericMatrix.getDimnames()[1];
			org.bioconductor.cagrid.data.ExpressionData[] expressionDataArr = new org.bioconductor.cagrid.data.ExpressionData[sampleCols];
			
			for(int col = 0; col < sampleCols; col++) {
				double[] colValues = new double[sampleColSize];
				System.arraycopy(rjValues, col * sampleColSize, colValues, 0, sampleColSize);
				gov.nih.nci.caarray.domain.data.DoubleColumn reporterValues = new gov.nih.nci.caarray.domain.data.DoubleColumn(colValues);
				expressionDataArr[col] = new org.bioconductor.cagrid.data.ExpressionData();
				expressionDataArr[col].setReporterValues(reporterValues);
				expressionDataArr[col].setSampleName(sampleNames[col]);
			}
			
			
			return expressionDataArr;
		}
		catch(Exception ew) {
			throw ew;
		}
    }
	
	public static org.bioconductor.cagrid.camachinelearning.SupervisedMachineLearningParameters deserializeToCagridSupervisedMachineLearningParameters(String filePath) {
		java.io.InputStream fis = null;
		java.io.ObjectInputStream ois = null;
		
		try {
			java.io.File file = new java.io.File(filePath);
			fis = new java.io.FileInputStream(file);
			ois = new java.io.ObjectInputStream(fis);
			Object deserObj = ois.readObject();			
			return convertSupervisedRParamToCagridSupervisedParam(deserObj);			
			
		}
		catch(Exception ew) {
			ew.printStackTrace();
			return null;
		}
	}
	
	private static org.bioconductor.cagrid.camachinelearning.SupervisedMachineLearningParameters convertSupervisedRParamToCagridSupervisedParam(Object deserObj) 
	{
		org.bioconductor.packages.caMachineLearning.SupervisedLearningParameters rParam = (org.bioconductor.packages.caMachineLearning.SupervisedLearningParameters)deserObj;
		org.bioconductor.cagrid.camachinelearning.SupervisedMachineLearningSampleAnnotation[] annoArr = new 
				org.bioconductor.cagrid.camachinelearning.SupervisedMachineLearningSampleAnnotation[rParam.getSampleName().length];
		String[] factorValueArr = rParam.getType().asData();
		for(int i = 0; i < annoArr.length; i++) {
			annoArr[i] = new org.bioconductor.cagrid.camachinelearning.SupervisedMachineLearningSampleAnnotation();
			annoArr[i].setIsTrainingSample(rParam.getIsTrainingIndividual()[i]);
			annoArr[i].setSampleName(rParam.getSampleName()[i]);
			annoArr[i].setObservedClassification(new gov.nih.nci.caarray.domain.project.FactorValue(null, null, factorValueArr[i]));
		}
		
		org.bioconductor.cagrid.camachinelearning.SupervisedMachineLearningParameters cagridParam = null;
		
		if (deserObj instanceof org.bioconductor.packages.caMachineLearning.LinearDiscriminantAnalysisParameters) {
			cagridParam = new org.bioconductor.cagrid.camachinelearning.LinearDiscriminantAnalysisMachineLearningParameters();
		}			
		else if (deserObj instanceof org.bioconductor.packages.caMachineLearning.SupportVectorMachinesParameters) {
			cagridParam = new org.bioconductor.cagrid.camachinelearning.SupportVectorMachineMachineLearningParameters();
		}
		else if (deserObj instanceof org.bioconductor.packages.caMachineLearning.KNearestNeighborsParameters) {
			cagridParam = new org.bioconductor.cagrid.camachinelearning.KNearestNeighborMachineLearningParameters();
		}
		else if (deserObj instanceof org.bioconductor.packages.caMachineLearning.QuadraticDiscriminantAnalysisParameters) {
			cagridParam = new org.bioconductor.cagrid.camachinelearning.QuadraticDscriminantAnalysisMachineLearningParameters();
		}
		else if (deserObj instanceof org.bioconductor.packages.caMachineLearning.DiagonalLinearDiscriminantAnalysisParameters) {
			cagridParam = new org.bioconductor.cagrid.camachinelearning.DiagonalLinearDiscriminantAnalysisMachineLearningParameters();
		}
		else if (deserObj instanceof org.bioconductor.packages.caMachineLearning.NaiveBayesParameters) {
			cagridParam = new org.bioconductor.cagrid.camachinelearning.NaiveBayesMachineLearningParameters();
		}
		
		cagridParam.setSupervisedMachineLearningAnnotation(annoArr);
		
		return cagridParam;
	}
}
