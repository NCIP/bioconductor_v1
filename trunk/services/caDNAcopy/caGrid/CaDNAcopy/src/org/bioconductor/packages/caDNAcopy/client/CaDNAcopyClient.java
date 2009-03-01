package org.bioconductor.packages.caDNAcopy.client;

import java.io.InputStream;
import java.rmi.RemoteException;

import javax.xml.namespace.QName;

import org.apache.axis.EngineConfiguration;
import org.apache.axis.client.AxisClient;
import org.apache.axis.client.Stub;
import org.apache.axis.configuration.FileProvider;
import org.apache.axis.message.addressing.EndpointReferenceType;
import org.apache.axis.types.URI.MalformedURIException;

import org.oasis.wsrf.properties.GetResourcePropertyResponse;

import org.globus.gsi.GlobusCredential;

import org.bioconductor.packages.caDNAcopy.stubs.CaDNAcopyPortType;
import org.bioconductor.packages.caDNAcopy.stubs.service.CaDNAcopyServiceAddressingLocator;
import org.bioconductor.packages.caDNAcopy.common.CaDNAcopyI;
import gov.nih.nci.cagrid.introduce.security.client.ServiceSecurityClient;

/**
 * This class is autogenerated, DO NOT EDIT GENERATED GRID SERVICE ACCESS METHODS.
 *
 * This client is generated automatically by Introduce to provide a clean unwrapped API to the
 * service.
 *
 * On construction the class instance will contact the remote service and retrieve it's security
 * metadata description which it will use to configure the Stub specifically for each method call.
 * 
 * @created by Introduce Toolkit version 1.2
 */
public class CaDNAcopyClient extends CaDNAcopyClientBase implements CaDNAcopyI {	

	private static final String SERVICE_URL = "http://cabig.bioconductor.org:8080/wsrf/services/cagrid/CaDNAcopy";
	
	public CaDNAcopyClient() throws MalformedURIException, RemoteException 
	{
		this(SERVICE_URL);
	}
	
	public CaDNAcopyClient(String url) throws MalformedURIException, RemoteException {
		this(url,null);	
	}

	public CaDNAcopyClient(String url, GlobusCredential proxy) throws MalformedURIException, RemoteException {
	   	super(url,proxy);
	}
	
	public CaDNAcopyClient(EndpointReferenceType epr) throws MalformedURIException, RemoteException {
	   	this(epr,null);
	}
	
	public CaDNAcopyClient(EndpointReferenceType epr, GlobusCredential proxy) throws MalformedURIException, RemoteException {
	   	super(epr,proxy);
	}

	public static void usage(){
		System.out.println(CaDNAcopyClient.class.getName() + " -url <service url>");
	}
	
	private void head(org.bioconductor.cagrid.cadnacopy.DerivedDNAcopySegment segment, int from) {
 		int to = from + 5;
 		System.out.println("\n" + segment.getSampleId()[from]);
 		System.out.format("%10s%8s%8s%8s%12s\n", "Chromsome", "Start", "End", "Markers", "Avg. value");
 		for (int i = from; i < to; ++i)
 		    System.out.format("%10s%8d%8d%8d%12.3f\n",
 				      segment.getChromosomeIndex()[i],
 				      segment.getStartMapPosition()[i],
 				      segment.getEndMapPosition()[i],
 				      segment.getMarkersPerSegment()[i],
 				      segment.getAverageSegmentValue()[i]);
 		System.out.println("...");
	}
	
	
	public  org.bioconductor.cagrid.cadnacopy.DerivedDNAcopySegment invokeService(String p_filename) throws java.io.FileNotFoundException, Exception{
		
		if(p_filename == null || p_filename.equals("")) {
			System.out.println("Filename is not defined");
			return null;
		}
		
		System.out.println("invokeService get called");
			
		try {
			
			java.io.FileInputStream fin  = null;
		    java.io.ObjectInputStream oin = null;
		    org.bioconductor.packages.caDNAcopy.DNAcopyAssays myAssays = null;
		    try {
//				    	String jDataFile = client.getClass().getResource("Data/trimmedDNAcopyAssays.data").getFile();
//				    	fin  = new java.io.FileInputStream(jDataFile);
		    	fin = new java.io.FileInputStream(new java.io.File(p_filename));
		    	oin = new java.io.ObjectInputStream(fin);
		    	System.out.println("Deserialize data to an object");
		    	Object myAssaysObj = oin.readObject();
		    	System.out.println("Deserialized object class name: " + myAssaysObj.getClass().getName());
		    	myAssays = (org.bioconductor.packages.caDNAcopy.DNAcopyAssays) myAssaysObj;
		    }
		    catch (java.io.FileNotFoundException ew) 
			{
				throw ew;
			}
		    catch(Exception ew) {
		    	throw ew;
		    }
		    finally {
		    	fin.close();
		    	oin.close();
		    }

		    org.bioconductor.cagrid.cadnacopy.DNAcopyParameter dnacopyParameter =
									new org.bioconductor.cagrid.cadnacopy.DNAcopyParameter();

		    org.bioconductor.cagrid.cadnacopy.DNAcopyAssays dnacopyAssays = convertToCaGridDNAcopyAssays(myAssays);

		    System.out.println("Done converting to DNAcopyAssays.");
		    
		    // invoke method
		    System.out.println("\nInvoking caDNAcopy");

		    org.bioconductor.cagrid.cadnacopy.DerivedDNAcopySegment oDerivedDNAcopySegment = getDerivedDNAcopySegment(dnacopyAssays, dnacopyParameter);
		    
		    System.out.println("Done getting DNDcopyServiceContext.");

	//	    System.out.println("\nTotal number of segments: " + oDerivedDNAcopySegment.getSampleId().length);
	//      head(oDerivedDNAcopySegment, 0);
	//	    head(oDerivedDNAcopySegment, 24);
		    
		    return oDerivedDNAcopySegment;
				    
		} 
		catch(RemoteException ew) 
		{
			ew.printStackTrace();
		}
		
		return null;
			
	}


	private org.bioconductor.cagrid.cadnacopy.DNAcopyAssays convertToCaGridDNAcopyAssays(final org.bioconductor.packages.caDNAcopy.DNAcopyAssays p_bioAssays) {

	    // convert mapLocation from int to long
	    int[] mapLoc = p_bioAssays.getMapLocation();
	    long[] mapLocation = new long[mapLoc.length];

	    for (int i=0; i < mapLoc.length; ++i) {
	    	mapLocation[i] = mapLoc[i];
	    }

    	// convert ExpressionData
    	org.bioconductor.packages.rservices.RJNumericMatrix rjMatrix = p_bioAssays.getLogratioValues();
    	int[] dim = rjMatrix.getDim(); // column-major order
    	double[] dat = rjMatrix.getValue();
    	String[] sampleNames = p_bioAssays.getSampleNames();
    	System.out.println("\nInput: " + dim[0] + " markers x " + dim[1] + " samples");

    	org.bioconductor.cagrid.cadnacopy.ExpressionData[] expr =
    											new org.bioconductor.cagrid.cadnacopy.ExpressionData[2];
    	for (int j=0; j < dim[1]; ++j) {
			double[] e = new double[dim[0]];

			for (int i = 0; i < dim[0]; ++i) {
				e[i] = dat[j*dim[0]+i];
			}

			expr[j] = new org.bioconductor.cagrid.cadnacopy.ExpressionData(e, sampleNames[j]);
    	}

	    // convert data instance
	    org.bioconductor.cagrid.cadnacopy.DNAcopyAssays dnacopyAssays = new
		                              org.bioconductor.cagrid.cadnacopy.DNAcopyAssays(p_bioAssays.getChromosomeId(),
								                                                      expr,
								                                                      mapLocation);

	    return dnacopyAssays;

	}

	public static void main(String [] args){
	    System.out.println("Running the Grid Service Client");
		try{
			if(!(args.length < 2)){
				if(args[0].equals("-url")){
					CaDNAcopyClient client = new CaDNAcopyClient(args[1]);

					java.io.FileInputStream fin  = null;
				    java.io.ObjectInputStream oin = null;
				    org.bioconductor.packages.caDNAcopy.DNAcopyAssays myAssays = null;
				    try {
				    	String jDataFile = client.getClass().getResource("Data/trimmedDNAcopyAssays.data").getFile();
				    	fin  = new java.io.FileInputStream(jDataFile);
				    	oin = new java.io.ObjectInputStream(fin);
				    	System.out.println("Deserialize data to an object");
				    	Object myAssaysObj = oin.readObject();
				    	System.out.println("Deserialized object class name: " + myAssaysObj.getClass().getName());
				    	myAssays = (org.bioconductor.packages.caDNAcopy.DNAcopyAssays) myAssaysObj;
				    }
				    catch(Exception ew) {
				    	System.out.println("Exception at client main: " + ew.getMessage());
				    }
				    finally {
				    	fin.close();
				    	oin.close();
				    }

				    org.bioconductor.cagrid.cadnacopy.DNAcopyParameter dnacopyParameter =
											new org.bioconductor.cagrid.cadnacopy.DNAcopyParameter();

				    org.bioconductor.cagrid.cadnacopy.DNAcopyAssays dnacopyAssays = client.convertToCaGridDNAcopyAssays(myAssays);

				    System.out.println("Done converting to DNAcopyAssays.");
				    
				    // invoke method
				    System.out.println("\nInvoking caDNAcopy");
				    org.bioconductor.cagrid.cadnacopy.DerivedDNAcopySegment res = client.getDerivedDNAcopySegment(dnacopyAssays, dnacopyParameter);
				    
				    System.out.println("Done getting DNDcopyServiceContext.");

				    System.out.println("\nTotal number of segments: " + res.getSampleId().length);
				    client.head(res, 0);
				    client.head(res, 24);

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


  public org.oasis.wsrf.properties.GetMultipleResourcePropertiesResponse getMultipleResourceProperties(org.oasis.wsrf.properties.GetMultipleResourceProperties_Element params) throws RemoteException {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"getMultipleResourceProperties");
    return portType.getMultipleResourceProperties(params);
    }
  }

  public org.oasis.wsrf.properties.GetResourcePropertyResponse getResourceProperty(javax.xml.namespace.QName params) throws RemoteException {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"getResourceProperty");
    return portType.getResourceProperty(params);
    }
  }

  public org.oasis.wsrf.properties.QueryResourcePropertiesResponse queryResourceProperties(org.oasis.wsrf.properties.QueryResourceProperties_Element params) throws RemoteException {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"queryResourceProperties");
    return portType.queryResourceProperties(params);
    }
  }

  public org.bioconductor.cagrid.cadnacopy.DerivedDNAcopySegment getDerivedDNAcopySegment(org.bioconductor.cagrid.cadnacopy.DNAcopyAssays dNAcopyAssays,org.bioconductor.cagrid.cadnacopy.DNAcopyParameter dNAcopyParameter) throws RemoteException {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"getDerivedDNAcopySegment");
    org.bioconductor.packages.caDNAcopy.stubs.GetDerivedDNAcopySegmentRequest params = new org.bioconductor.packages.caDNAcopy.stubs.GetDerivedDNAcopySegmentRequest();
    org.bioconductor.packages.caDNAcopy.stubs.GetDerivedDNAcopySegmentRequestDNAcopyAssays dNAcopyAssaysContainer = new org.bioconductor.packages.caDNAcopy.stubs.GetDerivedDNAcopySegmentRequestDNAcopyAssays();
    dNAcopyAssaysContainer.setDNAcopyAssays(dNAcopyAssays);
    params.setDNAcopyAssays(dNAcopyAssaysContainer);
    org.bioconductor.packages.caDNAcopy.stubs.GetDerivedDNAcopySegmentRequestDNAcopyParameter dNAcopyParameterContainer = new org.bioconductor.packages.caDNAcopy.stubs.GetDerivedDNAcopySegmentRequestDNAcopyParameter();
    dNAcopyParameterContainer.setDNAcopyParameter(dNAcopyParameter);
    params.setDNAcopyParameter(dNAcopyParameterContainer);
    org.bioconductor.packages.caDNAcopy.stubs.GetDerivedDNAcopySegmentResponse boxedResult = portType.getDerivedDNAcopySegment(params);
    return boxedResult.getDerivedDNAcopySegment();
    }
  }

}