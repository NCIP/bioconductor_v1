package org.bioconductor.packages.caCGHcall.service;

import java.rmi.RemoteException;
import java.util.*;
import java.text.SimpleDateFormat;


/** 
 * TODO:I am the service side implementation class.  IMPLEMENT AND DOCUMENT ME
 * 
 * @created by Introduce Toolkit version 1.2
 * 
 */
public class CaCGHcallImpl extends CaCGHcallImplBase {

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");

	
	public CaCGHcallImpl() throws RemoteException {
		super();
	}
	
  public org.bioconductor.cagrid.cacghcall.DerivedCGHcallSegment getDerivedCGHcallSegment(org.bioconductor.cagrid.cacghcall.CGHcallAssays cGHcallAssays,org.bioconductor.cagrid.cacghcall.CGHcallParameter cGHcallParameter) throws RemoteException {
	  	org.bioconductor.rserviceJms.services.caCGHcall.caCGHcall myCaService = null;
		
                // Added by CAP - get sample name for log
                String sampleName = "[unknown]";
                org.bioconductor.cagrid.cacghcall.CGHcallExpressionData[] edc = cGHcallAssays.getExpressionDataCollection();
                if (edc.length > 0) {
                    sampleName = edc[0].getSampleId();
                }
                System.out.println(formatter.format(new java.util.Date()) + " - Creating caCGHcall for sample " + sampleName); // logs/catalina.out

		try {			
		    myCaService = new org.bioconductor.rserviceJms.services.caCGHcall.caCGHcall();
		}
		catch (Exception ex) {
		    throw new RemoteException(ex.getMessage());
		}
                System.out.println(formatter.format(new java.util.Date()) + " - caCGHcall created for sample " + sampleName);
		
		org.bioconductor.packages.caCGHcall.CGHcallParameter rwsParameter = new
		    org.bioconductor.packages.caCGHcall.CGHcallParameter(new int[] {0},
									 new double[] {cGHcallParameter.getChangePointSignificanceLevel()},
									 new int[] {cGHcallParameter.getNumberLevels()},
									 new int[] {cGHcallParameter.getPermutationReplicates()},
									 new double[] {cGHcallParameter.getEarlyStoppingCriterion()});

		long[] mapLocation = cGHcallAssays.getMapLocation();
		org.bioconductor.cagrid.cacghcall.CGHcallExpressionData[]
		    expressionData = cGHcallAssays.getExpressionDataCollection();
		int nFeatures = mapLocation.length;
		int nSamples = expressionData.length;
		int[] mapLoc = new int[nFeatures];
		for (int i=0; i < nFeatures; ++i) mapLoc[i] = (int) mapLocation[i];

		String[] sampleNames = new String[nSamples];
		int[] dim = new int[] { nFeatures, nSamples };
		double[] value = new double[nFeatures * nSamples];
		for (int j=0; j < nSamples; ++j) {
		    sampleNames[j] = expressionData[j].getSampleId();
		    double[] logratioValues = expressionData[j].getLogRatioValues();
		    for (int i=0; i < nFeatures; ++i)
			value[j*nFeatures + i] = logratioValues[i];
		}
		org.bioconductor.packages.rservices.RJNumericMatrix rjMatrix = new
		    org.bioconductor.packages.rservices.RJNumericMatrix(value, dim, null);
		org.bioconductor.packages.caCGHcall.CGHcallAssays rwsAssays = new
		    org.bioconductor.packages.caCGHcall.CGHcallAssays(rjMatrix,
								      sampleNames,
								      cGHcallAssays.getChromsomeId(),
								      mapLoc);

		// invoke service
		org.bioconductor.packages.caCGHcall.DerivedCGHcallSegment rwsSegment = null;
		try {
		    rwsSegment = myCaService.caCGHcall(rwsAssays, rwsParameter);
		} catch  (RemoteException ex) {
		    throw(ex);
		}

                System.out.println(formatter.format(new java.util.Date()) + " - caCGHcall completed for sample " + sampleName);

		// map output type
		org.bioconductor.cagrid.cacghcall.DerivedCGHcallSegment caSegment = null;
		if (null != rwsSegment) {
		    int nSegments = rwsSegment.getEndMapPosition().length;
		    long[] endMapPosition = new long[nSegments];
		    long[] startMapPosition = new long[nSegments];
		    for (int i=0;i<nSegments;++i) {
			endMapPosition[i] = (long) rwsSegment.getEndMapPosition()[i];
			startMapPosition[i] = (long) rwsSegment.getStartMapPosition()[i];
		    }
		    caSegment = new
			org.bioconductor.cagrid.cacghcall.DerivedCGHcallSegment(rwsSegment.getAverageSegmentValue(),
									       rwsSegment.getCalls(),
									       rwsSegment.getChromosomeIndex(),
									       endMapPosition,
									       rwsSegment.getMarkersPerSegment(),
									       rwsSegment.getProbAmp(),
									       rwsSegment.getProbGain(),
									       rwsSegment.getProbLoss(),
									       rwsSegment.getProbNorm(),
									       rwsSegment.getSampleId(),
									       startMapPosition);
		}
                System.out.println(formatter.format(new java.util.Date()) + " - Returning segment for sample " + sampleName);

		return(caSegment);
  }

}

