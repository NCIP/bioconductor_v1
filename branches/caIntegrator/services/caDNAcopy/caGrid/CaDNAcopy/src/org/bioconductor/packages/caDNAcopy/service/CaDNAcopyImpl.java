package org.bioconductor.packages.caDNAcopy.service;

import java.rmi.RemoteException;
import java.util.*;
import java.text.SimpleDateFormat;


/** 
 * TODO:I am the service side implementation class.  IMPLEMENT AND DOCUMENT ME
 * 
 * @created by Introduce Toolkit version 1.2
 * 
 */
public class CaDNAcopyImpl extends CaDNAcopyImplBase {

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");

	
	public CaDNAcopyImpl() throws RemoteException {
		super();
	}
	
  public org.bioconductor.cagrid.cadnacopy.DerivedDNAcopySegment getDerivedDNAcopySegment(org.bioconductor.cagrid.cadnacopy.DNAcopyAssays dNAcopyAssays,org.bioconductor.cagrid.cadnacopy.DNAcopyParameter dNAcopyParameter) throws RemoteException {
	  	org.bioconductor.rserviceJms.services.caDNAcopy.caDNAcopy myCaService = null;

		// Added by CAP - get sample name for log
		String sampleName = "[unknown]";
		org.bioconductor.cagrid.cadnacopy.ExpressionData[] edc = dNAcopyAssays.getExpressionDataCollection();
		if (edc.length > 0) {
		    sampleName = edc[0].getSampleId();
		}
		System.out.println(formatter.format(new java.util.Date()) + " - Creating caDNAcopy for sample " + sampleName); // logs/catalina.out
		try {			
		    myCaService = new org.bioconductor.rserviceJms.services.caDNAcopy.caDNAcopy();
		}
		catch (Exception ex) {
		    throw new RemoteException(ex.getMessage());
		}
		System.out.println(formatter.format(new java.util.Date()) + " - caDNAcopy created for sample " + sampleName);
		
		org.bioconductor.packages.caDNAcopy.DNAcopyParameter rwsParameter = new
		    org.bioconductor.packages.caDNAcopy.DNAcopyParameter(new int[] {0},
									 new double[] {dNAcopyParameter.getChangePointSignificanceLevel()},
									 new int[] {dNAcopyParameter.getPermutationReplicates()},
									 new double[] {dNAcopyParameter.getEarlyStoppingCriterion()});

		long[] mapLocation = dNAcopyAssays.getMapLocation();
		org.bioconductor.cagrid.cadnacopy.ExpressionData[]
		    expressionData = dNAcopyAssays.getExpressionDataCollection();
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
		org.bioconductor.packages.caDNAcopy.DNAcopyAssays rwsAssays = new
		    org.bioconductor.packages.caDNAcopy.DNAcopyAssays(rjMatrix,
								      sampleNames,
								      dNAcopyAssays.getChromsomeId(),
								      mapLoc);

		// invoke service
		org.bioconductor.packages.caDNAcopy.DerivedDNAcopySegment rwsSegment = null;
		try {
		    rwsSegment = myCaService.caDNAcopy(rwsAssays, rwsParameter);
		} catch  (RemoteException ex) {
		    throw(ex);
		}

		System.out.println(formatter.format(new java.util.Date()) + " - caDNAcopy completed for sample " + sampleName);

		// map output type
		org.bioconductor.cagrid.cadnacopy.DerivedDNAcopySegment caSegment = null;
		if (null != rwsSegment) {
		    int nSegments = rwsSegment.getEndMapPosition().length;
		    long[] endMapPosition = new long[nSegments];
		    long[] startMapPosition = new long[nSegments];
		    for (int i=0;i<nSegments;++i) {
			endMapPosition[i] = (long) rwsSegment.getEndMapPosition()[i];
			startMapPosition[i] = (long) rwsSegment.getStartMapPosition()[i];
		    }
		    caSegment = new
			org.bioconductor.cagrid.cadnacopy.DerivedDNAcopySegment(rwsSegment.getAverageSegmentValue(),
									       rwsSegment.getChromosomeIndex(),
									       endMapPosition,
									       rwsSegment.getMarkersPerSegment(),
									       rwsSegment.getSampleId(),
									       startMapPosition);
		}
		System.out.println(formatter.format(new java.util.Date()) + " - Returning segment for sample " + sampleName);
		return(caSegment);
  }

}

