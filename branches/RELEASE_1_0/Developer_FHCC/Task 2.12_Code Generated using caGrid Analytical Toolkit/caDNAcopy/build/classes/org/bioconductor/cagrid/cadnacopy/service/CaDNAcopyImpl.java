package org.bioconductor.cagrid.cadnacopy.service;

import java.rmi.RemoteException;

/** 
 * Service-side implementation of caDNACopy. The single service in
 * this method identifies regions of DNA copy number variation, as
 * documented in the Bioconductor package DNACopy.
 * 
 * @created by Introduce Toolkit version 1.0
 * 
 */


/* Interface to caDNAcopy implementation */

import org.bioconductor.rserviceJms.services.caDNAcopy.caDNAcopy;
import org.bioconductor.packages.caDNAcopy.*;

public class CaDNAcopyImpl extends CaDNAcopyImplBase {

    private org.bioconductor.rserviceJms.services.caDNAcopy.caDNAcopy caService = null;
	
    public CaDNAcopyImpl() throws RemoteException {
	super();
	// Start the activeMQ service; the service has a lifetime
	// equal to that of this instance.
	System.out.println("Starting caDNAcopy"); // logs/catalina.out
	try {
	    caService = new org.bioconductor.rserviceJms.services.caDNAcopy.caDNAcopy();
	} catch (Exception ex) {
	    throw new RemoteException(ex.getMessage());
	}
	System.out.println("Start caDNAcopy successful");
    }
	
    public org.bioconductor.cagrid.cadnacopy.DerivedDNAcopySegment caDNAcopy(org.bioconductor.cagrid.cadnacopy.DNAcopyAssays dnacopyAssays,org.bioconductor.cagrid.cadnacopy.DNAcopyParameter dnacopyParameter) throws RemoteException {
	// map input types
	org.bioconductor.packages.caDNAcopy.DNAcopyParameter rwsParameter = new
	    org.bioconductor.packages.caDNAcopy.DNAcopyParameter(new int[] {0},
								 new double[] {dnacopyParameter.getChangePointSignificanceLevel()},
								 new int[] {dnacopyParameter.getPermutationReplicates()},
								 new double[] {dnacopyParameter.getEarlyStoppingCriterion()});

	long[] mapLocation = dnacopyAssays.getMapLocation();
	org.bioconductor.cagrid.cadnacopy.ExpressionData[]
	    expressionData = dnacopyAssays.getExpressionDataCollection();
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
							      dnacopyAssays.getChromsomeId(),
							      mapLoc);

	// invoke service
	org.bioconductor.packages.caDNAcopy.DerivedDNAcopySegment rwsSegment = null;
	try {
	    rwsSegment = caService.caDNAcopy(rwsAssays, rwsParameter);
	} catch  (RemoteException ex) {
	    throw(ex);
	}

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
	return(caSegment);
    }
}

