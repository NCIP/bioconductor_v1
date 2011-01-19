package org.bioconductor.packages.caMachineLearning.common;

import gov.nih.nci.caarray.domain.data.DoubleColumn;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.bioconductor.cagrid.data.ExpressionData;
import org.bioconductor.cagrid.data.SingleChannelExpressionDataCollection;

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
		org.bioconductor.packages.caMachineLearning.SupervisedMachineLearningParameters rParam = 
			                      (org.bioconductor.packages.caMachineLearning.SupervisedMachineLearningParameters)deserObj;
		org.bioconductor.cagrid.camachinelearning.SupervisedMachineLearningSampleAnnotation[] annoArr = new 
				org.bioconductor.cagrid.camachinelearning.SupervisedMachineLearningSampleAnnotation[rParam.getSampleName().length];
		String[] factorValueArr = rParam.getType().asData();
		for(int i = 0; i < annoArr.length; i++) {
			annoArr[i] = new org.bioconductor.cagrid.camachinelearning.SupervisedMachineLearningSampleAnnotation();
			annoArr[i].setIsTrainingSample(rParam.getIsTrainingSample()[i]);
			annoArr[i].setSampleName(rParam.getSampleName()[i]);
			annoArr[i].setObservedClassification(new gov.nih.nci.caarray.domain.project.FactorValue(null, null, factorValueArr[i]));
		}
		
		org.bioconductor.cagrid.camachinelearning.SupervisedMachineLearningParameters cagridParam = null;
		
		if (deserObj instanceof org.bioconductor.packages.caMachineLearning.LinearDiscriminantAnalysisMachineLearningParameters) {
			cagridParam = new org.bioconductor.cagrid.camachinelearning.LinearDiscriminantAnalysisMachineLearningParameters();
		}			
		else if (deserObj instanceof org.bioconductor.packages.caMachineLearning.SupportVectorMachineMachineLearningParameters) {
			cagridParam = new org.bioconductor.cagrid.camachinelearning.SupportVectorMachineMachineLearningParameters();
		}
		else if (deserObj instanceof org.bioconductor.packages.caMachineLearning.KNearestNeighborsMachineLearningParameters) {
			cagridParam = new org.bioconductor.cagrid.camachinelearning.KNearestNeighborMachineLearningParameters();
		}
/*		
		else if (deserObj instanceof org.bioconductor.packages.caMachineLearning.QuadraticDiscriminantAnalysisMachineLearningParameters) {
			cagridParam = new org.bioconductor.cagrid.camachinelearning.QuadraticDscriminantAnalysisMachineLearningParameters();
		}
*/
		else if (deserObj instanceof org.bioconductor.packages.caMachineLearning.DiagonalLinearDiscriminantAnalysisMachineLearningParameters) {
			cagridParam = new org.bioconductor.cagrid.camachinelearning.DiagonalLinearDiscriminantAnalysisMachineLearningParameters();
		}
		else if (deserObj instanceof org.bioconductor.packages.caMachineLearning.NaiveBayesMachineLearningParameters) {
			cagridParam = new org.bioconductor.cagrid.camachinelearning.NaiveBayesMachineLearningParameters();
		}
		
		cagridParam.setSupervisedMachineLearningAnnotation(annoArr);
		
		return cagridParam;
	}
	
	
	public static org.bioconductor.cagrid.data.SingleChannelExpressionDataCollection readTxt(String filePath) throws java.io.FileNotFoundException, Exception
	{
		java.io.File file = new java.io.File(filePath);		
		FileInputStream fis = new FileInputStream(file);
		return readStream(fis);
	  }

	public static org.bioconductor.cagrid.data.SingleChannelExpressionDataCollection readStream(InputStream fis)throws IOException {

  	 String line = "";

  	 ArrayList<String> probeID = new ArrayList<String>();

	      ArrayList[] ratioLists = null;
	      String[] ratioListNames = null;
	      try {	           
	
	          InputStreamReader inputStreamReader = new InputStreamReader(fis);
	          BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
	          String header = "";
	          header = bufferedReader.readLine();
	          String[] headerCount = header.split("\\t");
	          System.out.println("Number of columns is: " + headerCount.length);
	
	          int numSamples = headerCount.length - 1;
	          System.out.println("Number of samples: " + numSamples);
	          ratioLists = new ArrayList[numSamples];
	          for (int i = 0; i < numSamples; i++){
	        	  ratioLists[i] = new ArrayList();
	          }
	
	          //get sample IDs from header
	          ratioListNames = new String[numSamples];
	          for (int i=0; i < numSamples; i++){
	        	  ratioListNames[i] = headerCount[i+1];
	              System.out.println("Sample names: " + ratioListNames[i]);
	           }
	
	              while((line = bufferedReader.readLine()) != null) {
	
	                  String[] element = line.split("\\t");
	                    String pid = element[0];
	                    probeID.add(pid);
	                           for(int i=0; i < numSamples; i++){
	                      double ratio;
	                      try {
	//	                               ratio = Double.parseDouble (element[i+3]);
	                            ratio = Double.parseDouble (element[i+1]);
	//	                            System.out.println("This is ratio: " + ratio);
	                      } catch (NumberFormatException n) {
	                          ratio = Double.NaN;
	                      }
	                      ratioLists[i].add(ratio);
	                      //System.out.println("Ratio: " + ratio);
	                  }
	              }
	      }
	      catch(FileNotFoundException fN) {
	       fN.printStackTrace();
	      }
	
	          ExpressionData[] eds = new ExpressionData[ratioListNames.length];
	          DoubleColumn[] doubleColumns = new DoubleColumn[ratioListNames.length];
	          System.out.println("This is the length of doubleColumns: " + doubleColumns.length);
	          for(int i=0; i < ratioListNames.length; i++) {
	              ArrayList<Double[]> data = ratioLists[i];
	              Double[] dataAsDouble =  data.toArray(new Double[0]);
	              double[] dataAsd = new double[dataAsDouble.length];
	              for (int j=0; j < dataAsDouble.length;j++){
	                  dataAsd[j] = dataAsDouble[j];
	              }
	
	          doubleColumns[i] = new DoubleColumn(dataAsd);
	          eds[i] = new ExpressionData(doubleColumns[i],ratioListNames[i]);
	
	      }
	
	        String[] probeArray = probeID.toArray(new String[0]);
	        String[] probe = new String[probeArray.length];
	        for (int i=0; i < probeArray.length;i++){
	              probe[i] = probeArray[i];
	          }
	
	          System.out.println("Done creating SingleChannelExpressionDataCollection");
	
	        SingleChannelExpressionDataCollection scdc = new org.bioconductor.cagrid.data.SingleChannelExpressionDataCollection(eds);
	        scdc.setReporterNames(probe);
	
	    return scdc;
	}
}
