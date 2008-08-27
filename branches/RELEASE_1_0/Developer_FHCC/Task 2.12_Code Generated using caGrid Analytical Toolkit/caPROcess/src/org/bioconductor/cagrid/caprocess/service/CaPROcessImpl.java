package org.bioconductor.cagrid.caprocess.service;

import java.rmi.RemoteException;


/** 
 * Service-side implementation of caPROcess. The single service in
 * this method identifies peaks in SELDI-TOFF mass spec data, as
 * documented in the Bioconductor package PROcess.
 * 
 * @created by Bioconductor
 * 
 */

/* Interface to caPROcess implementation */

import org.bioconductor.rserviceJms.services.caPROcess.caPROcess;
import org.bioconductor.packages.caPROcess.*;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class CaPROcessImpl extends CaPROcessImplBase {

	private org.bioconductor.rserviceJms.services.caPROcess.caPROcess caService = null;

	public CaPROcessImpl() throws RemoteException {
		super();
		// Start the activeMQ service; the service has a lifetime
		// equal to that of this instance.
		System.out.println("Starting caPROcess"); // logs/catalina.out
		try {
		    caService = new org.bioconductor.rserviceJms.services.caPROcess.caPROcess();
		} catch (Exception ex) {
		    throw new RemoteException(ex.getMessage());
		}
		System.out.println("Start caPROcess successful");
	}


        /**
        * Java interface to R function caPROcess.
        *       Provide a web services wrapper to a
        *       workflow inolving baseline removal,
        *       renormalization and peak detection 
	*	in the R package PROcess.
        *
        * @param mzAssays       An object containing data to be analyzed.
        * @param proCessParameter       An object containing parameters 
	*				influencing the workflow.
        * @return       Java representation of PeakLocation-class in R package
        */
	public org.bioconductor.cagrid.caprocess.PeakLocation caPROcess(org.bioconductor.cagrid.caprocess.MzAssays mzAssays,org.bioconductor.cagrid.caprocess.PROcessParameter processParameter) throws RemoteException {
	    // map input types
	    System.out.println("Mapping input types");
	    org.bioconductor.cagrid.caprocess.MzSpectrum[] caSpectrum = mzAssays.getMzSpectrumCollection();
	    Object[] rwsObject = new Object[caSpectrum.length];
	    for (int i=0; i<caSpectrum.length; ++i)
		rwsObject[i] =
		    new org.bioconductor.packages.caPROcess.MzSpectrum(new String[] {caSpectrum[i].getSpectrumName()},
								       caSpectrum[i].getMzRatio(),
								       caSpectrum[i].getIntensity());
	    org.bioconductor.packages.caPROcess.MzAssays rwsAssays =
		new org.bioconductor.packages.caPROcess.MzAssays(rwsObject, new MzSpectrum());

	    org.bioconductor.packages.caPROcess.PROcessParameter rwsParameter =
		new org.bioconductor.packages.caPROcess.PROcessParameter(new double[] {processParameter.getRenormalizationCutoff()},
									 new double[] {processParameter.getPeakSignalToNoiseCutoff()},
									 new double[] {processParameter.getPeakVarianceDetectionSpan()},
									 new double[] {processParameter.getPeakSmoothingSpan()},
									 new double[] {processParameter.getPeakZeroCutoff()},
									 new double[] {processParameter.getPeakAreaNeighborhood()},
									 new double[] {processParameter.getPeakAreaRetention()});
	    
	    //  invoke service
	    org.bioconductor.packages.caPROcess.PeakLocation rwsPeakLocation = null;
	    try {
		System.out.println("Invoking caPROcess service");
		System.out.println("Length: " +
				   ((org.bioconductor.packages.caPROcess.MzSpectrum) rwsAssays.getRData()[0]).getIntensity().length);
		rwsPeakLocation = caService.caPROcess(rwsAssays, rwsParameter);
		System.out.println("Service invoked");
	    } catch (RemoteException ex) {
		System.err.println("ERROR: caPROcess invocation failed");
		System.err.println(ex.getMessage());
		throw(ex);
	    }

	    // map return type
	    org.bioconductor.cagrid.caprocess.PeakLocation caPeakLocation = null;
	    if (null != rwsPeakLocation) {
		caPeakLocation = new
		    org.bioconductor.cagrid.caprocess.PeakLocation(rwsPeakLocation.getPeakNumberInSpectrum(),
								   rwsPeakLocation.getRelativeIntensity(),
								   rwsPeakLocation.getSpectrumId(),
								   rwsPeakLocation.getSpectrumName(),
								   rwsPeakLocation.getSubstanceMassAtIntensity());
	    }
	    
	    return(caPeakLocation);
	}
}

