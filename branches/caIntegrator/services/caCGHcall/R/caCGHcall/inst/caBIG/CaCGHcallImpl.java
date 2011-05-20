package org.bioconductor.cagrid.cacghcall.service;

import java.rmi.RemoteException;

/** 
 * Service-side implementation of caCGHcall. The single service in
 * this method identifies regions of DNA copy number variation, as
 * documented in the Bioconductor package CGHcall.
 * 
 * @created by BioConductor
 * 
 */


/* Interface to caCGHcall implementation */

import org.bioconductor.rserviceJms.services.caCGHcall.caCGHcall;
import org.bioconductor.packages.caCGHcall.*;

public class CaCGHcallImpl extends CaCGHcallImplBase {

    private org.bioconductor.rserviceJms.services.caCGHcall.caCGHcall caService = null;
	
    public CaCGHcallImpl() throws RemoteException {
	super();
	// Start the activeMQ service; the service has a lifetime
	// equal to that of this instance.
	System.out.println("Starting caCGHcall"); // logs/catalina.out
	try {
	    caService = new org.bioconductor.rserviceJms.services.caCGHcall.caCGHcall();
	} catch (Exception ex) {
	    throw new RemoteException(ex.getMessage());
	}
	System.out.println("Start caCGHcall successful");
    }

       /**
        * Java interface to R function caCGHcall.
        *       Transform an object specifying copy number variation 
	*	through smoothing and segmentation to a object 
	*	identifying chromosomal regions of constant copy
        *       number.
        *
        * @param cghcallAssays	Collection of objects representing 
	*	samples from known chromosomal locations, and their 
	*	expression values.
        * @param cghcallParameter       An object encapsulating
        *       parameters influencing evaluation of caCGHcall.
        * @return	Java representation of the 
	*	DerivedCGHcallSegment-class in R.
        */
	
    public org.bioconductor.cagrid.cacghcall.DerivedCGHcallSegment caCGHcall(org.bioconductor.cagrid.cacghcall.CGHcallAssays dnacopyAssays,org.bioconductor.cagrid.cacghcall.CGHcallParameter dnacopyParameter) throws RemoteException {
	// map input types
	org.bioconductor.packages.caCGHcall.CGHcallParameter rwsParameter = new
	    org.bioconductor.packages.caCGHcall.CGHcallParameter(new int[] {0},
								 new double[] {dnacopyParameter.getChangePointSignificanceLevel()},
								 new int[] {dnacopyParameter.getPermutationReplicates()},
								 new double[] {dnacopyParameter.getEarlyStoppingCriterion()});

	long[] mapLocation = dnacopyAssays.getMapLocation();
	org.bioconductor.cagrid.cacghcall.ExpressionData[]
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
	org.bioconductor.packages.caCGHcall.CGHcallAssays rwsAssays = new
	    org.bioconductor.packages.caCGHcall.CGHcallAssays(rjMatrix,
							      sampleNames,
							      dnacopyAssays.getChromsomeId(),
							      mapLoc);

	// invoke service
	org.bioconductor.packages.caCGHcall.DerivedCGHcallSegment rwsSegment = null;
	try {
	    rwsSegment = caService.caCGHcall(rwsAssays, rwsParameter);
	} catch  (RemoteException ex) {
	    throw(ex);
	}

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
								       rwsSegment.getChromosomeIndex(),
								       endMapPosition,
								       rwsSegment.getMarkersPerSegment(),
								       rwsSegment.getSampleId(),
								       startMapPosition);
	}
	return(caSegment);
    }
}

