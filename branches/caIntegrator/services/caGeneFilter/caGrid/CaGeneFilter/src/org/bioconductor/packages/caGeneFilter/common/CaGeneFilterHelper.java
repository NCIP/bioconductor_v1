package org.bioconductor.packages.caGeneFilter.common;

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
import org.bioconductor.cagrid.statefulservices.SessionEndpoint;
import org.cagrid.transfer.context.client.TransferServiceContextClient;
import org.cagrid.transfer.context.client.helper.TransferClientHelper;
import org.cagrid.transfer.descriptor.Status;

public class CaGeneFilterHelper {
		
/*	
	public synchronized static void uploadFiles(final org.bioconductor.cagrid.data.ManufacturerFileReferences manFileReferences) throws Exception
	{	
		try {
			org.bioconductor.cagrid.statefulservices.CaGridFileReference[] cagridFileRefArr = manFileReferences.getCagridFileReferenceCollection();
			for(int i = 0; i < cagridFileRefArr.length; i++) {
				
				System.out.println("Uploading file: " + cagridFileRefArr[i].getLocalName());
				
				TransferServiceContextClient transSrvCxtClient = new TransferServiceContextClient(cagridFileRefArr[i].getEndpointReference());
				
				System.out.println("Creating input stream for: " + cagridFileRefArr[i].getUrl());
				java.io.InputStream inStream = new java.io.FileInputStream(cagridFileRefArr[i].getUrl());
				
				org.cagrid.transfer.descriptor.DataTransferDescriptor desc = transSrvCxtClient.getDataTransferDescriptor();
				
				TransferClientHelper.putData(inStream, -1, transSrvCxtClient.getDataTransferDescriptor());
				
				// set status to staged, i.e, a service should start the download by invoking dataStaged method in DataStagedCallback
				transSrvCxtClient.setStatus(Status.Staged);
				
				inStream.close();
				
				System.out.println("uploading file: " + cagridFileRefArr[i].getLocalName() + " completed.");
			}
		}
		catch (Exception ew) {
			throw ew;
		}
	
	}
*/
	
	public synchronized static org.bioconductor.cagrid.data.ExpressionData[] 
                      convertToExpressionDataCollection(final org.bioconductor.packages.rservices.RJNumericMatrix rjNumericMatrix) throws Exception
    {
		try {
			// if a RJNumericMatrix is imagined as n by m matrix:
			int sampleColSize = rjNumericMatrix.getDim()[0];	// this is n
			int sampleCols = rjNumericMatrix.getDim()[1];		// this is m
			double[] rjValues = rjNumericMatrix.getValue();	// all values in flatten double array
			String[] sampleNames = rjNumericMatrix.getDimnames() == null ? null : (String[])rjNumericMatrix.getDimnames()[1];
			org.bioconductor.cagrid.data.ExpressionData[] expressionDataArr = new org.bioconductor.cagrid.data.ExpressionData[sampleCols];
			
			for(int col = 0; col < sampleCols; col++) {
				double[] colValues = new double[sampleColSize];
				System.arraycopy(rjValues, col * sampleColSize, colValues, 0, sampleColSize);
				gov.nih.nci.caarray.domain.data.DoubleColumn reporterValues = new gov.nih.nci.caarray.domain.data.DoubleColumn(colValues);
				expressionDataArr[col] = new org.bioconductor.cagrid.data.ExpressionData();
				expressionDataArr[col].setReporterValues(reporterValues);
				if(sampleNames == null)  expressionDataArr[col].setSampleName(""); 
                                else expressionDataArr[col].setSampleName(sampleNames[col]);
			}
			
			
			return expressionDataArr;
		}
		catch(Exception ew) {
			throw ew;
		}
	}
	
	public synchronized static org.bioconductor.cagrid.data.SingleChannelExpressionDataCollection 
    		        convertToSingleChannelExpressionDataCollection(final org.bioconductor.packages.rservices.RJNumericMatrix rjNumericMatrix) throws Exception
	{
		try {
						
			org.bioconductor.cagrid.data.ExpressionData[] expressionDataArr = convertToExpressionDataCollection(rjNumericMatrix);
			
			org.bioconductor.cagrid.data.SingleChannelExpressionDataCollection returnCollection = 
									new org.bioconductor.cagrid.data.SingleChannelExpressionDataCollection(expressionDataArr);
			
			if(rjNumericMatrix.getDimnames() == null || rjNumericMatrix.getDimnames()[0] == null) returnCollection.setReporterNames(new String[0]);
			else returnCollection.setReporterNames((String[])rjNumericMatrix.getDimnames()[0]);
			
			return returnCollection;
		}
		catch(Exception ew) {
			throw ew;
		}
	}
	
	public synchronized static org.bioconductor.cagrid.data.TwoChannelExpressionDataCollection 
                    convertToTwoChannelExpressionDataCollection(final org.bioconductor.packages.rservices.RJNumericMatrix redDataRJNumMat,
                    		                                    final org.bioconductor.packages.rservices.RJNumericMatrix greenDataRJNumMat) throws Exception
    {
		try {				
			org.bioconductor.cagrid.data.ExpressionData[] redDataCollection = convertToExpressionDataCollection(redDataRJNumMat);
			org.bioconductor.cagrid.data.ExpressionData[] greenDataCollection = convertToExpressionDataCollection(greenDataRJNumMat);
			
			org.bioconductor.cagrid.data.TwoChannelExpressionDataCollection returnCollection = new org.bioconductor.cagrid.data.TwoChannelExpressionDataCollection();
			returnCollection.setRedExpressionDataCollection(redDataCollection);
			returnCollection.setGreenExpressionDataCollection(greenDataCollection);
			
			// reporter names should be the same with R and G
			returnCollection.setReporterNames((String[])redDataRJNumMat.getDimnames()[0]);
			
			return returnCollection;
		}
		catch(Exception ew) {
			throw ew;
		}
	}
	
	public synchronized static org.bioconductor.packages.rservices.RJNumericMatrix convertToRJNumericMatrix(
			             final org.bioconductor.cagrid.data.ExpressionData[] expressDataArr, final String[] reporterNamesArr) throws Exception
	{
		try {
			int sampleCols  = expressDataArr.length;
			if(sampleCols == 0) {  // nothing to do
				return null;
			}
		
			int sampleColSize = expressDataArr[0].getReporterValues().getValues().length;
			// columns length should be equal, so:
			if(sampleColSize == 0) {  // nothing to do
				return null;
			}
		
			org.bioconductor.packages.rservices.RJNumericMatrix rjNumericMatrix = new org.bioconductor.packages.rservices.RJNumericMatrix();
			rjNumericMatrix.setDim(new int[]{sampleColSize, sampleCols});
		
			double[] values = new double[sampleColSize  * sampleCols];
			String[] sampleNames = new String[sampleCols];
			for(int col = 0; col < sampleCols; col++) {
				double[] dataArr = expressDataArr[col].getReporterValues().getValues();
				System.arraycopy(dataArr, 0, values, col * sampleColSize, sampleColSize);
				sampleNames[col] = expressDataArr[col].getSampleName();
			}
			rjNumericMatrix.setValue(values);
		
			Object[] dimNames = new Object[]{reporterNamesArr, sampleNames};
			rjNumericMatrix.setDimnames(dimNames);
		
			return rjNumericMatrix;
		}
		catch(Exception ew) {
			throw ew;
		}
	}
	
	
	public static org.bioconductor.cagrid.data.SingleChannelExpressionDataCollection readTxt(File p_file) throws java.io.FileNotFoundException, Exception{

	      System.out.println("File is: " + p_file);
	      FileInputStream fis = new FileInputStream(p_file);
	      return readStream(fis);
	  }

    public static org.bioconductor.cagrid.data.SingleChannelExpressionDataCollection readStream(InputStream fis)throws IOException {

    	 String line = "";
  
    	 ArrayList<String> probeID = new ArrayList();

	      ArrayList[] ratioLists = null;
	      String[] ratioListNames = null;
	      try {
	           //File p_file = null;
	           //p_file = new File("/home/ryan/Desktop/2008.09.15.caDNAcopyClientDev/coriell.txt");
	
	          InputStreamReader fr = new InputStreamReader(fis);
	          BufferedReader br = new BufferedReader(fr);
	          String header = "";
	          header = br.readLine();
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
	
	              while((line = br.readLine()) != null) {
	
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
