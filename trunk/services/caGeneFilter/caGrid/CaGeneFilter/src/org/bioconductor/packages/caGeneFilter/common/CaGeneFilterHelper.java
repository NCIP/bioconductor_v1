package org.bioconductor.packages.caGeneFilter.common;

import org.bioconductor.cagrid.statefulservices.SessionEndpoint;
import org.cagrid.transfer.context.client.TransferServiceContextClient;
import org.cagrid.transfer.context.client.helper.TransferClientHelper;
import org.cagrid.transfer.descriptor.Status;

public class CaGeneFilterHelper {
		
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
	
	public synchronized static org.bioconductor.cagrid.data.ExpressionData[] 
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
	
	public synchronized static org.bioconductor.cagrid.data.SingleChannelExpressionDataCollection 
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
	
}
