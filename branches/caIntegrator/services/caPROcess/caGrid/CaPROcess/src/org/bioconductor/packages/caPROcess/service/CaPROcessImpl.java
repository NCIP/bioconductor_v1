package org.bioconductor.packages.caPROcess.service;

import java.rmi.RemoteException;

/** 
 * TODO:I am the service side implementation class.  IMPLEMENT AND DOCUMENT ME
 * 
 * @created by Introduce Toolkit version 1.2
 * 
 */
public class CaPROcessImpl extends CaPROcessImplBase {

	
	public CaPROcessImpl() throws RemoteException {
		super();
	}
	
  public org.bioconductor.cagrid.caprocess.PeakLocation getPeakLocation(org.bioconductor.cagrid.caprocess.MzAssays mzAssays,org.bioconductor.cagrid.caprocess.PROcessParameter pROcessParameter) throws RemoteException {
	  org.bioconductor.rserviceJms.services.caPROcess.caPROcess caService = null;
	  System.out.println("Creating a caPROcess service"); // logs/catalina.out
		try {
		    caService = new org.bioconductor.rserviceJms.services.caPROcess.caPROcess();
		} catch (Exception ex) {
		    throw new RemoteException(ex.getMessage());
		}
		
		System.out.println("a caPROcess service is created...");
	  
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
		new org.bioconductor.packages.caPROcess.MzAssays(rwsObject, new org.bioconductor.packages.caPROcess.MzSpectrum());

	    org.bioconductor.packages.caPROcess.PROcessParameter rwsParameter =
		new org.bioconductor.packages.caPROcess.PROcessParameter(new double[] {pROcessParameter.getRenormalizationCutoff()},
									 new double[] {pROcessParameter.getPeakSignalToNoiseCutoff()},
									 new double[] {pROcessParameter.getPeakVarianceDetectionSpan()},
									 new double[] {pROcessParameter.getPeakSmoothingSpan()},
									 new double[] {pROcessParameter.getPeakZeroCutoff()},
									 new double[] {pROcessParameter.getPeakAreaNeighborhood()},
									 new double[] {pROcessParameter.getPeakAreaRetention()});
	    
	    //  invoke service
	    org.bioconductor.packages.caPROcess.PeakLocation rwsPeakLocation = null;
	    try {
			System.out.println("Invoking caPROcess service");
			System.out.println("Length: " +
					   ((org.bioconductor.packages.caPROcess.MzSpectrum) rwsAssays.getRData()[0]).getIntensity().length);
			rwsPeakLocation = caService.caPROcess(rwsAssays, rwsParameter);
			System.out.println("Service invoked");
	    } 
	    catch (RemoteException ex) {
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

