package org.bioconductor.packages.caLinearModel.common;

import org.bioconductor.packages.caCommonClasses.TwoChannelExpressionData;

public class CaLinearModelHelper {
	
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
	
	public static org.bioconductor.cagrid.data.TwoChannelExpressionDataCollection deserializeToTwoChannelExpDataCollection(String pathToRTwoChannelExpDataFile) throws Exception 
	{
		java.io.InputStream fileInStream = null;
		java.io.ObjectInputStream objInStream = null;
		try {
			fileInStream = new java.io.FileInputStream(new java.io.File(pathToRTwoChannelExpDataFile));
			objInStream = new java.io.ObjectInputStream(fileInStream);
			
			Object deserializedObj = objInStream.readObject();
			// cast deserialized object to R TwoChannelExpressData:
			org.bioconductor.packages.caCommonClasses.TwoChannelExpressionData twoChannelExpData = (org.bioconductor.packages.caCommonClasses.TwoChannelExpressionData)deserializedObj;
			
			// now convert this R TwoChannelExpressionData to cagrid TwoChannelExpressionDataColletion:
			org.bioconductor.cagrid.data.ExpressionData[] firstChannelExpData = convertToExpressionDataCollection(twoChannelExpData.getChannelOne().getExpressionMatrix());
			org.bioconductor.cagrid.data.ExpressionData[] secondChannelExpData = convertToExpressionDataCollection(twoChannelExpData.getChannelTwo().getExpressionMatrix());
			
			org.bioconductor.cagrid.data.TwoChannelExpressionDataCollection twoChanExpDataColl = new org.bioconductor.cagrid.data.TwoChannelExpressionDataCollection();
			twoChanExpDataColl.setRedExpressionDataCollection(firstChannelExpData);
			twoChanExpDataColl.setGreenExpressionDataCollection(secondChannelExpData);
			
			return twoChanExpDataColl;
			
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
	
	
	
	public static org.bioconductor.cagrid.calinearmodel.TTest deserializeToTTest(final String pathToRSampleAnnoCollFile) throws Exception
	{
		try {
			org.bioconductor.packages.caCommonClasses.SampleAnnotationCollection rSampleAnnoColl = deserializeToSampleAnnotationCollection(pathToRSampleAnnoCollFile);
			// convert this SampleAnnotationCollection into TTest:
			
			org.bioconductor.packages.rservices.RJDataFrame rJDataFrame = rSampleAnnoColl.getSampleAnnotationCollection();
			String[] sampleIdens = (String[])(rJDataFrame.getData()[0]);
			// for TTest, third element of RJDataFrame data array will be factorValue:
			String[] factorValueData = (String[])(rJDataFrame.getData()[2]);			
									
			org.bioconductor.cagrid.calinearmodel.TTestAnnotation[] tTestAnnoArr = new org.bioconductor.cagrid.calinearmodel.TTestAnnotation[factorValueData.length];
			for(int i = 0; i < factorValueData.length; i++) {
				tTestAnnoArr[i] = new org.bioconductor.cagrid.calinearmodel.TTestAnnotation();				
				tTestAnnoArr[i].setSampleIdentifier(sampleIdens[i]);				
				gov.nih.nci.caarray.domain.project.FactorValue oFactorValue = new gov.nih.nci.caarray.domain.project.FactorValue(null, null, (String)factorValueData[i]);
				tTestAnnoArr[i].setFactorLevel(oFactorValue);
			}
			
			return new org.bioconductor.cagrid.calinearmodel.TTest(tTestAnnoArr); 

		}
		catch(Exception ew) {
			throw ew;
		}
	}
	
	public static org.bioconductor.cagrid.calinearmodel.PairedTTest deserializeToPairedTTest(final String pathToRSampleAnnoCollFile) throws Exception
	{
		try {
			org.bioconductor.packages.caCommonClasses.SampleAnnotationCollection rSampleAnnoColl = deserializeToSampleAnnotationCollection(pathToRSampleAnnoCollFile);
			// convert this SampleAnnotationCollection into PairedTTest:
			
			org.bioconductor.packages.rservices.RJDataFrame rJDataFrame = rSampleAnnoColl.getSampleAnnotationCollection();
			String[] sampleIdens = (String[])(rJDataFrame.getData()[0]);
			// for PairedTTest, third element of RJDataFrame data array (handedness) will be factorValue, fourth element (pairing) will be pairedIdentifier
			String[] factorValueData = (String[])(rJDataFrame.getData()[2]);
			int[] pairedIdentifierArr = (int[])(rJDataFrame.getData()[3]);
			
			org.bioconductor.cagrid.calinearmodel.PairedTTestAnnotation[] pairedTTestAnnoArr = new org.bioconductor.cagrid.calinearmodel.PairedTTestAnnotation[factorValueData.length];
			for(int i = 0; i < factorValueData.length; i++) {
				pairedTTestAnnoArr[i] = new org.bioconductor.cagrid.calinearmodel.PairedTTestAnnotation();				
				pairedTTestAnnoArr[i].setSampleIdentifier(sampleIdens[i]);
				
				gov.nih.nci.caarray.domain.project.FactorValue oFactorValue = new gov.nih.nci.caarray.domain.project.FactorValue(null, null, (String)factorValueData[i]);
				pairedTTestAnnoArr[i].setFactorLevel(oFactorValue);			
				pairedTTestAnnoArr[i].setPairIdentifier(String.valueOf(pairedIdentifierArr[i]));
			}
			
			return new org.bioconductor.cagrid.calinearmodel.PairedTTest(pairedTTestAnnoArr); 

		}
		catch(Exception ew) {
			throw ew;
		}
	}
	
	public static org.bioconductor.cagrid.calinearmodel.OneFactorANOVA deserializeToOneFactorANOVA(final String pathToRSampleAnnoCollFile) throws Exception
	{
		try {
			org.bioconductor.packages.caCommonClasses.SampleAnnotationCollection rSampleAnnoColl = deserializeToSampleAnnotationCollection(pathToRSampleAnnoCollFile);
			// convert this SampleAnnotationCollection into PairedTTest:
			
			org.bioconductor.packages.rservices.RJDataFrame rJDataFrame = rSampleAnnoColl.getSampleAnnotationCollection();
			String[] sampleIdens = (String[])(rJDataFrame.getData()[0]);
			// for OneFactorANOVA, fifth element of RJDataFrame data array (ageCohort) will be factorValue:
			String[] factorValueData = (String[])(rJDataFrame.getData()[4]);			
						
			org.bioconductor.cagrid.calinearmodel.OneFactorANOVAAnnotation[] oneWayAnnoArr = new org.bioconductor.cagrid.calinearmodel.OneFactorANOVAAnnotation[factorValueData.length];
			for(int i = 0; i < factorValueData.length; i++) {
				oneWayAnnoArr[i] = new org.bioconductor.cagrid.calinearmodel.OneFactorANOVAAnnotation();				
				oneWayAnnoArr[i].setSampleIdentifier(sampleIdens[i]);
				
				gov.nih.nci.caarray.domain.project.FactorValue oFactorValue = new gov.nih.nci.caarray.domain.project.FactorValue(null, null, (String)factorValueData[i]);
				oneWayAnnoArr[i].setFactorLevel(oFactorValue);							
			}
			
			return new org.bioconductor.cagrid.calinearmodel.OneFactorANOVA(oneWayAnnoArr); 

		}
		catch(Exception ew) {
			throw ew;
		}
	}

	public static org.bioconductor.cagrid.calinearmodel.TwoFactorANOVA deserializeToTwoFactorANOVA(final String pathToRSampleAnnoCollFile) throws Exception
	{
		try {
			org.bioconductor.packages.caCommonClasses.SampleAnnotationCollection rSampleAnnoColl = deserializeToSampleAnnotationCollection(pathToRSampleAnnoCollFile);
			// convert this SampleAnnotationCollection into PairedTTest:
			
			org.bioconductor.packages.rservices.RJDataFrame rJDataFrame = rSampleAnnoColl.getSampleAnnotationCollection();
			String[] sampleIdens = (String[])(rJDataFrame.getData()[0]);
			
			// for TwoFactorANOVA, third element of RJDataFrame data array (handedness) will be factorOneValue, and fifth element (ageCohort) will be factorTwoValue:
			String[] factorOneValueData = (String[])(rJDataFrame.getData()[2]);
			String[] factorTwoValueData = (String[])(rJDataFrame.getData()[4]);
						
			org.bioconductor.cagrid.calinearmodel.TwoFactorANOVAAnnotation[] twoWayAnnoArr = new org.bioconductor.cagrid.calinearmodel.TwoFactorANOVAAnnotation[factorOneValueData.length];
			for(int i = 0; i < factorOneValueData.length; i++) {
				twoWayAnnoArr[i] = new org.bioconductor.cagrid.calinearmodel.TwoFactorANOVAAnnotation();				
				twoWayAnnoArr[i].setSampleIdentifier(sampleIdens[i]);
				
				gov.nih.nci.caarray.domain.project.FactorValue oFactorOneValue = new gov.nih.nci.caarray.domain.project.FactorValue(null, null, (String)factorOneValueData[i]);
				gov.nih.nci.caarray.domain.project.FactorValue oFactorTwoValue = new gov.nih.nci.caarray.domain.project.FactorValue(null, null, (String)factorTwoValueData[i]);
				twoWayAnnoArr[i].setFactorOneLevel(oFactorOneValue);
				twoWayAnnoArr[i].setFactorTwoLevel(oFactorTwoValue);
			}
			
			return new org.bioconductor.cagrid.calinearmodel.TwoFactorANOVA(twoWayAnnoArr); 

		}
		catch(Exception ew) {
			throw ew;
		}
	}
	
	public static org.bioconductor.cagrid.calinearmodel.DyeSwapTTest deserializeToDySwapTTest(final String pathToRSampleAnnoCollFile) throws Exception
	{
		try {
			org.bioconductor.packages.caCommonClasses.SampleAnnotationCollection rSampleAnnoColl = deserializeToSampleAnnotationCollection(pathToRSampleAnnoCollFile);
			// convert this SampleAnnotationCollection into PairedTTest:
			
			org.bioconductor.packages.rservices.RJDataFrame rJDataFrame = rSampleAnnoColl.getSampleAnnotationCollection();
			String[] sampleIdens = (String[])(rJDataFrame.getData()[0]);
			String[] channelIdens = (String[])(rJDataFrame.getData()[1]);
			
			// for DyeSwapTTest, third element of RJDataFrame data array (handedness) will be factorValue
			String[] factorValueData = (String[])(rJDataFrame.getData()[2]);
						
			org.bioconductor.cagrid.calinearmodel.DyeSwapTTestAnnotation[] dyeSwapTTestAnnoArr = new org.bioconductor.cagrid.calinearmodel.DyeSwapTTestAnnotation[factorValueData.length];
			for(int i = 0; i < factorValueData.length; i++) {
				dyeSwapTTestAnnoArr[i] = new org.bioconductor.cagrid.calinearmodel.DyeSwapTTestAnnotation();				
				dyeSwapTTestAnnoArr[i].setSampleIdentifier(sampleIdens[i]);
				dyeSwapTTestAnnoArr[i].setChannelIdentifier(channelIdens[i]);
				
				gov.nih.nci.caarray.domain.project.FactorValue oFactorValue = new gov.nih.nci.caarray.domain.project.FactorValue(null, null, (String)factorValueData[i]);				
				dyeSwapTTestAnnoArr[i].setFactorLevel(oFactorValue);				
			}
			
			org.bioconductor.cagrid.calinearmodel.DyeSwapTTest dyeSwapTTest = new org.bioconductor.cagrid.calinearmodel.DyeSwapTTest();
			dyeSwapTTest.setDyeSwapTTestAnnotation(dyeSwapTTestAnnoArr);
			
			return dyeSwapTTest;
		}
		catch(Exception ew) {
			throw ew;
		}
	}

	
	public static org.bioconductor.cagrid.calinearmodel.CommonReferenceANOVA deserializeToCommonReferenceANOVA(final String pathToRSampleAnnoCollFile) throws Exception
	{
		try {
			org.bioconductor.packages.caCommonClasses.SampleAnnotationCollection rSampleAnnoColl = deserializeToSampleAnnotationCollection(pathToRSampleAnnoCollFile);
			// convert this SampleAnnotationCollection into PairedTTest:
			
			org.bioconductor.packages.rservices.RJDataFrame rJDataFrame = rSampleAnnoColl.getSampleAnnotationCollection();
			String[] sampleIdens = (String[])(rJDataFrame.getData()[0]);
			String[] channelIdens = (String[])(rJDataFrame.getData()[1]);
			
			// for CommonReferenceANOVA, fourth element of RJDataFrame data array (phenotype) will be factorValue
			String[] factorValueData = (String[])(rJDataFrame.getData()[3]);
						
			org.bioconductor.cagrid.calinearmodel.CommonReferenceANOVAAnnotation[] commonRefANOVAAnnoArr = new org.bioconductor.cagrid.calinearmodel.CommonReferenceANOVAAnnotation[factorValueData.length];
			for(int i = 0; i < factorValueData.length; i++) {
				commonRefANOVAAnnoArr[i] = new org.bioconductor.cagrid.calinearmodel.CommonReferenceANOVAAnnotation();				
				commonRefANOVAAnnoArr[i].setSampleIdentifier(sampleIdens[i]);
				commonRefANOVAAnnoArr[i].setChannelIdentifier(channelIdens[i]);
				
				gov.nih.nci.caarray.domain.project.FactorValue oFactorValue = new gov.nih.nci.caarray.domain.project.FactorValue(null, null, (String)factorValueData[i]);				
				commonRefANOVAAnnoArr[i].setFactorLevel(oFactorValue);				
			}
			
			org.bioconductor.cagrid.calinearmodel.CommonReferenceANOVA commonRefANOVA = new org.bioconductor.cagrid.calinearmodel.CommonReferenceANOVA();
			commonRefANOVA.setCommonReferenceANOVAAnnotation(commonRefANOVAAnnoArr);
			
			return commonRefANOVA;
		}
		catch(Exception ew) {
			throw ew;
		}
	}
	
	
	private static org.bioconductor.packages.caCommonClasses.SampleAnnotationCollection deserializeToSampleAnnotationCollection(final String pathToRSampleAnnoCollFile) throws Exception
	{
		java.io.InputStream fileInStream = null;
		java.io.ObjectInputStream objInStream = null;
		try {
			fileInStream = new java.io.FileInputStream(new java.io.File(pathToRSampleAnnoCollFile));
			objInStream = new java.io.ObjectInputStream(fileInStream);
			Object deserializedObj = objInStream.readObject();
			
			// cast deserialized object to R SampleAnnotationCollection:
			org.bioconductor.packages.caCommonClasses.SampleAnnotationCollection rSampleAnnoColl = (org.bioconductor.packages.caCommonClasses.SampleAnnotationCollection)deserializedObj;
			
			return rSampleAnnoColl;
			
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
}

