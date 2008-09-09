package org.bioconductor.cagrid.caprocess.client;

import java.io.InputStream;
import java.rmi.RemoteException;

import javax.xml.namespace.QName;

import org.apache.axis.EngineConfiguration;
import org.apache.axis.client.AxisClient;
import org.apache.axis.client.Stub;
import org.apache.axis.configuration.FileProvider;
import org.apache.axis.message.addressing.EndpointReferenceType;
import org.apache.axis.types.URI.MalformedURIException;
import org.apache.axis.utils.ClassUtils;

import org.oasis.wsrf.properties.GetResourcePropertyResponse;

import org.globus.gsi.GlobusCredential;

import org.bioconductor.cagrid.caprocess.stubs.CaPROcessPortType;
import org.bioconductor.cagrid.caprocess.stubs.service.CaPROcessServiceAddressingLocator;
import org.bioconductor.cagrid.caprocess.common.CaPROcessI;
import gov.nih.nci.cagrid.introduce.security.client.ServiceSecurityClient;

/**
 * This class is autogenerated, DO NOT EDIT GENERATED GRID SERVICE METHODS.
 *
 * This client is generated automatically by Introduce to provide a clean unwrapped API to the
 * service.
 *
 * On construction the class instance will contact the remote service and retrieve it's security
 * metadata description which it will use to configure the Stub specifically for each method call.
 * 
 * @created by Introduce Toolkit version 1.0
 */

/**
 * Simple integration test client using a mock data set
 *
 **/
 
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class CaPROcessClient extends ServiceSecurityClient implements CaPROcessI {	
	protected CaPROcessPortType portType;
	private Object portTypeMutex;

	public CaPROcessClient(String url) throws MalformedURIException, RemoteException {
		this(url,null);	
	}

	public CaPROcessClient(String url, GlobusCredential proxy) throws MalformedURIException, RemoteException {
	   	super(url,proxy);
	   	initialize();
	}
	
	public CaPROcessClient(EndpointReferenceType epr) throws MalformedURIException, RemoteException {
	   	this(epr,null);
	}
	
	public CaPROcessClient(EndpointReferenceType epr, GlobusCredential proxy) throws MalformedURIException, RemoteException {
	   	super(epr,proxy);
		initialize();
	}
	
	private void initialize() throws RemoteException {
	    this.portTypeMutex = new Object();
		this.portType = createPortType();
	}

	private CaPROcessPortType createPortType() throws RemoteException {

		CaPROcessServiceAddressingLocator locator = new CaPROcessServiceAddressingLocator();
		// attempt to load our context sensitive wsdd file
		InputStream resourceAsStream = ClassUtils.getResourceAsStream(getClass(), "client-config.wsdd");
		if (resourceAsStream != null) {
			// we found it, so tell axis to configure an engine to use it
			EngineConfiguration engineConfig = new FileProvider(resourceAsStream);
			// set the engine of the locator
			locator.setEngine(new AxisClient(engineConfig));
		}
		CaPROcessPortType port = null;
		try {
			port = locator.getCaPROcessPortTypePort(getEndpointReference());
		} catch (Exception e) {
			throw new RemoteException("Unable to locate portType:" + e.getMessage(), e);
		}

		return port;
	}
	
	public GetResourcePropertyResponse getResourceProperty(QName resourcePropertyQName) throws RemoteException {
		return portType.getResourceProperty(resourcePropertyQName);
	}

	public static void usage(){
		System.out.println(CaPROcessClient.class.getName() + " -url <service url>");
	}
	
    private static void head(org.bioconductor.cagrid.caprocess.PeakLocation peaks,
			     int from) {
	int to = from + 5;
	System.out.println(peaks.getSpectrumName()[from]);
	System.out.println("Id\tM/Z\tIntensity");
	for (int i = from; i < to; ++i) {
	    System.out.format("%d\t%.2f\t%.2f\n",
			      peaks.getPeakNumberInSpectrum()[i],
			      peaks.getSubstanceMassAtIntensity()[i],
			      peaks.getRelativeIntensity()[i]);
	}
	System.out.println("...\n");
    }

	public static void main(String [] args){
	    System.out.println("\nRunning caPROcess grid service client");
		try{
		if(!(args.length < 2)){
			if(args[0].equals("-url")){
			  CaPROcessClient client = new CaPROcessClient(args[1]);

			  // Populate data and parameter objects
			  ObjectInputStream oin = null;
			  org.bioconductor.cagrid.caprocess.MzAssays caAssays = null;
			  try {
			      String jDataFile = client.getClass().getResource("Data/mzAssays.data").getFile();
			      FileInputStream fin = new FileInputStream(jDataFile);
			      oin = new ObjectInputStream(fin);

			      org.bioconductor.packages.caPROcess.MzAssays
				  rwsAssays = (org.bioconductor.packages.caPROcess.MzAssays) oin.readObject();

			      Object[] rwsObject = rwsAssays.getRData();
			      org.bioconductor.cagrid.caprocess.MzSpectrum[] caSpectrum = 
				  new org.bioconductor.cagrid.caprocess.MzSpectrum[rwsObject.length];
			      for (int i=0; i < rwsObject.length; ++i) {
				  org.bioconductor.packages.caPROcess.MzSpectrum rwsSpectrum =
				      (org.bioconductor.packages.caPROcess.MzSpectrum) rwsObject[i];
				  caSpectrum[i] = new
				      org.bioconductor.cagrid.caprocess.MzSpectrum(rwsSpectrum.getIntensity(),
										   rwsSpectrum.getMzRatio(),
										   rwsSpectrum.getSpectrumName()[0]);
			      }
			      caAssays = new org.bioconductor.cagrid.caprocess.MzAssays(caSpectrum);
			      
			      if (caSpectrum.length>0) {
				  System.out.print("\nInput: " +
						   caSpectrum.length + " spectra x " +
						   caSpectrum[0].getIntensity().length +
						   " intensities\n\n");
			      }
			  } catch (Exception e) {
			      System.err.println("ERROR: could not read sample data");
			      e.printStackTrace();
			      System.exit(1);
			  }
			  org.bioconductor.cagrid.caprocess.PROcessParameter caParameters =
			      new org.bioconductor.cagrid.caprocess.PROcessParameter();
			  caParameters.setRenormalizationCutoff(1500.);

			  // invoke service
			  System.out.println("Invoking caPROcess");
			  org.bioconductor.cagrid.caprocess.PeakLocation caPeakLocation = null;
			  try {
			      caPeakLocation = client.caPROcess(caAssays, caParameters);
			  } catch (Exception e) {
			      System.err.println("ERROR: could not invoke service");
			      e.printStackTrace();
			      System.exit(1);
			  }

			  // summarize results
			  System.out.println("\n" +
					     "Total number of peaks: " +
					     caPeakLocation.getSpectrumId().length +
					     "\n");
			  head(caPeakLocation, 0);
			  head(caPeakLocation, 12);
			} else {
			    usage();
			    System.exit(1);
			}
		} else {
			usage();
			System.exit(1);
		}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public org.bioconductor.cagrid.caprocess.PeakLocation caPROcess(org.bioconductor.cagrid.caprocess.MzAssays mzAssays,org.bioconductor.cagrid.caprocess.PROcessParameter processParameter) throws RemoteException {
      synchronized(portTypeMutex){
        configureStubSecurity((Stub)portType,"caPROcess");
        org.bioconductor.cagrid.caprocess.stubs.CaPROcessRequest params = new org.bioconductor.cagrid.caprocess.stubs.CaPROcessRequest();
        org.bioconductor.cagrid.caprocess.stubs.CaPROcessRequestMzAssays mzAssaysContainer = new org.bioconductor.cagrid.caprocess.stubs.CaPROcessRequestMzAssays();
        mzAssaysContainer.setMzAssays(mzAssays);
        params.setMzAssays(mzAssaysContainer);
        org.bioconductor.cagrid.caprocess.stubs.CaPROcessRequestProcessParameter processParameterContainer = new org.bioconductor.cagrid.caprocess.stubs.CaPROcessRequestProcessParameter();
        processParameterContainer.setPROcessParameter(processParameter);
        params.setProcessParameter(processParameterContainer);
        org.bioconductor.cagrid.caprocess.stubs.CaPROcessResponse boxedResult = portType.caPROcess(params);
        return boxedResult.getPeakLocation();
      }
    }
	public gov.nih.nci.cagrid.metadata.security.ServiceSecurityMetadata getServiceSecurityMetadata() throws RemoteException {
      synchronized(portTypeMutex){
        configureStubSecurity((Stub)portType,"getServiceSecurityMetadata");
        gov.nih.nci.cagrid.introduce.security.stubs.GetServiceSecurityMetadataRequest params = new gov.nih.nci.cagrid.introduce.security.stubs.GetServiceSecurityMetadataRequest();
        gov.nih.nci.cagrid.introduce.security.stubs.GetServiceSecurityMetadataResponse boxedResult = portType.getServiceSecurityMetadata(params);
        return boxedResult.getServiceSecurityMetadata();
      }
    }

}