package org.bioconductor.packages.caGeneSetAnalysis.client;

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

import org.bioconductor.packages.caGeneSetAnalysis.stubs.CaGeneSetAnalysisPortType;
import org.bioconductor.packages.caGeneSetAnalysis.stubs.service.CaGeneSetAnalysisServiceAddressingLocator;
import org.bioconductor.packages.caGeneSetAnalysis.common.CaGeneSetAnalysisI;
import gov.nih.nci.cagrid.introduce.security.client.ServiceSecurityClient;

import org.bioconductor.packages.caGeneSetAnalysis.common.CaGeneSetAnalysisTestHelper;

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
public class CaGeneSetAnalysisClient extends CaGeneSetAnalysisClientBase implements CaGeneSetAnalysisI {	

	public CaGeneSetAnalysisClient(String url) throws MalformedURIException, RemoteException {
		this(url,null);	
	}

	public CaGeneSetAnalysisClient(String url, GlobusCredential proxy) throws MalformedURIException, RemoteException {
	   	super(url,proxy);
	}
	
	public CaGeneSetAnalysisClient(EndpointReferenceType epr) throws MalformedURIException, RemoteException {
	   	this(epr,null);
	}
	
	public CaGeneSetAnalysisClient(EndpointReferenceType epr, GlobusCredential proxy) throws MalformedURIException, RemoteException {
	   	super(epr,proxy);
	}

	public static void usage(){
		System.out.println(CaGeneSetAnalysisClient.class.getName() + " -url <service url>");
	}
	
	public static void main(String [] args){
	    System.out.println("Running the Grid Service Client");
		try{
		if(!(args.length < 2)){
			if(args[0].equals("-url")){
			  CaGeneSetAnalysisClient client = new CaGeneSetAnalysisClient(args[1]);
			  // place client calls here if you want to use this main as a
			  // test....
//			  System.out.println("R packages Session Info: " + client.getRpackageSessionInfo());
			  
			  String geneSetParamFile = "/home/mtra2/CaGridProj/CaGeneSetAnalysis/Data/GeneOntologyDiscreteGeneSetAnalysisParameters.rda_java.Data";		  
			  org.bioconductor.cagrid.cagenesetanalysis.GeneSetAnalysisParameters cagridGeneSetParams = CaGeneSetAnalysisTestHelper.deserializeToCaGridGeneSetParam(geneSetParamFile);
			  System.out.println("Parameter Type: " + cagridGeneSetParams.getClass().getName());
			  

			  System.out.println("Annotation: " + cagridGeneSetParams.getAnnotation());
			  
			  String topTableFilePath = "/home/mtra2/CaGridProj/CaGeneSetAnalysis/Data/TopTableForDiscreteGeneSetAnalysis.rda_java.Data";			  
			  org.bioconductor.cagrid.data.TopTable cagridTopTable = CaGeneSetAnalysisTestHelper.deserializeToCaGridTopTable(topTableFilePath);
/*
			  int entryLength = cagridTopTable.getTopTableEntry().length;
			  for(int entry = 0; entry < entryLength; entry++) {
				  org.bioconductor.cagrid.data.TopTableEntry ttEntry = cagridTopTable.getTopTableEntry(entry);
				  System.out.println("Reporter Name: " + ttEntry.getReporterName() + " logFoldChange: " + ttEntry.getLogFoldChange() + 
				             " tcoef: " + ttEntry.getTCoefficient() + " pValue: " + ttEntry.getPValue() + 
				             " adjustedPValue: " + ttEntry.getAdjustedPValue() + " logOddScore: " + ttEntry.getLogOddsScore());
		 
				  System.out.println("Done with entry: " + entry);
			  
			  }
*/
//			  org.bioconductor.cagrid.cagenesetanalysis.GeneOntologyDiscreteParameters cagridGeneSetParam = new org.bioconductor.cagrid.cagenesetanalysis.GeneOntologyDiscreteParameters();
//			  cagridGeneSetParam.setAnnotation("hgu95av2");
//			  cagridGeneSetParam.setDiscretePValue(0.05);
//			  cagridGeneSetParam.setOntology("BP");
//			  cagridGeneSetParam.setTestDirection("over");
			  
			  org.bioconductor.cagrid.cagenesetanalysis.GeneSetAnalysisResultCollection geneSetColl = client.analyze(cagridTopTable, cagridGeneSetParams); 
			  if(geneSetColl != null) {
				  System.out.println("Got Result returned...");
				  client.printGeneSetCollectionResult(geneSetColl);
			  }
/*			  
			  org.bioconductor.cagrid.statefulservices.SessionEndpoint sessionEP = client.createCaGeneSetAnalysisSession();
			  org.bioconductor.packages.helper.common.HelperService helperService = new org.bioconductor.packages.helper.common.HelperService();
			  helperService.uploadDataObject(args[1], sessionEP, cagridTopTable);
			  client.invokeAnalyze(sessionEP, cagridGeneSetParams);
			  Object result = helperService.getResultObject(args[1], sessionEP);
			  geneSetColl = (org.bioconductor.cagrid.cagenesetanalysis.GeneSetCollection)result;
			  client.printGeneSetCollectionResult(geneSetColl);
*/			  
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
	
	public void printGeneSetCollectionResult(final org.bioconductor.cagrid.cagenesetanalysis.GeneSetAnalysisResultCollection geneSetColl)
	{
		System.out.println("GeneSetCollection description: " + geneSetColl.getDescription());
		
		if(geneSetColl instanceof org.bioconductor.cagrid.cagenesetanalysis.DiscreteGeneSetAnalysisResultCollection) {
			org.bioconductor.cagrid.cagenesetanalysis.DiscreteGeneSetAnalysisResultCollection discreteGeneSetColl = 
				                                       (org.bioconductor.cagrid.cagenesetanalysis.DiscreteGeneSetAnalysisResultCollection)geneSetColl;
			int resultLength = discreteGeneSetColl.getDiscreteGeneSetAnalysisResult().length;
			for(int result = 0; result < resultLength; result++) {
				org.bioconductor.cagrid.cagenesetanalysis.DiscreteGeneSetAnalysisResult geneSetResult = discreteGeneSetColl.getDiscreteGeneSetAnalysisResult(result); 
				System.out.println("expectedCount: " + geneSetResult.getExpectedCount() + " geneSEtId: " + geneSetResult.getGeneSetId() + 
						           " geneSetSize: " + geneSetResult.getGeneSetSize() + " pValue: " + geneSetResult.getPValue() + " selectedCount: " + geneSetResult.getSelectedCount());
				
				org.bioconductor.cagrid.cagenesetanalysis.GeneSetMember[] geneSetMemberArr = geneSetResult.getGeneSetMembers();
				for(int member = 0; member < geneSetMemberArr.length; member++) {
					System.out.println("Reporter name: " + geneSetMemberArr[member].getReporterName());
				}
				System.out.println("Done with entry: " + result);
			}
		}
		else if(geneSetColl instanceof org.bioconductor.cagrid.cagenesetanalysis.ContinuousGeneSetAnalysisResultCollection) {
			org.bioconductor.cagrid.cagenesetanalysis.ContinuousGeneSetAnalysisResultCollection continuousGeneSetColl = 
				                          (org.bioconductor.cagrid.cagenesetanalysis.ContinuousGeneSetAnalysisResultCollection)geneSetColl;
			int entryLength = continuousGeneSetColl.getContinuousGeneSetAnalysisResult().length;
			for(int result = 0; result < entryLength; result++) {
				org.bioconductor.cagrid.cagenesetanalysis.ContinuousGeneSetAnalysisResult geneSetResult = continuousGeneSetColl.getContinuousGeneSetAnalysisResult(result); 
				System.out.println("geneSetId: " +  geneSetResult.getGeneSetId() + " geneSetSize: " + geneSetResult.getGeneSetSize() + 
						           " pValue: " + geneSetResult.getPValue() + " tAdjusted: " + geneSetResult.getAdjustedTStatistic());
				
				org.bioconductor.cagrid.cagenesetanalysis.GeneSetMember[] geneSetMemberArr = geneSetResult.getGeneSetMembers();
				for(int member = 0; member < geneSetMemberArr.length; member++) {
					System.out.println("Reporter name: " + geneSetMemberArr[member].getReporterName());
				}
				System.out.println("Done with entry: " + result);
			}
		}
		else {
			System.out.println("Unknown type of GeneSetCollection: " + geneSetColl.getClass().getName());
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

  public org.bioconductor.cagrid.cagenesetanalysis.GeneSetAnalysisResultCollection analyze(org.bioconductor.cagrid.data.TopTable topTable,org.bioconductor.cagrid.cagenesetanalysis.GeneSetAnalysisParameters geneSetAnalysisParameters) throws RemoteException {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"analyze");
    org.bioconductor.packages.caGeneSetAnalysis.stubs.AnalyzeRequest params = new org.bioconductor.packages.caGeneSetAnalysis.stubs.AnalyzeRequest();
    org.bioconductor.packages.caGeneSetAnalysis.stubs.AnalyzeRequestTopTable topTableContainer = new org.bioconductor.packages.caGeneSetAnalysis.stubs.AnalyzeRequestTopTable();
    topTableContainer.setTopTable(topTable);
    params.setTopTable(topTableContainer);
    org.bioconductor.packages.caGeneSetAnalysis.stubs.AnalyzeRequestGeneSetAnalysisParameters geneSetAnalysisParametersContainer = new org.bioconductor.packages.caGeneSetAnalysis.stubs.AnalyzeRequestGeneSetAnalysisParameters();
    geneSetAnalysisParametersContainer.setGeneSetAnalysisParameters(geneSetAnalysisParameters);
    params.setGeneSetAnalysisParameters(geneSetAnalysisParametersContainer);
    org.bioconductor.packages.caGeneSetAnalysis.stubs.AnalyzeResponse boxedResult = portType.analyze(params);
    return boxedResult.getGeneSetAnalysisResultCollection();
    }
  }

  public java.lang.String getRpackageSessionInfo() throws RemoteException {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"getRpackageSessionInfo");
    org.bioconductor.packages.caGeneSetAnalysis.stubs.GetRpackageSessionInfoRequest params = new org.bioconductor.packages.caGeneSetAnalysis.stubs.GetRpackageSessionInfoRequest();
    org.bioconductor.packages.caGeneSetAnalysis.stubs.GetRpackageSessionInfoResponse boxedResult = portType.getRpackageSessionInfo(params);
    return boxedResult.getResponse();
    }
  }

  public org.bioconductor.cagrid.statefulservices.SessionIdentifier createCaGeneSetAnalysisSession() throws RemoteException {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"createCaGeneSetAnalysisSession");
    org.bioconductor.packages.caGeneSetAnalysis.stubs.CreateCaGeneSetAnalysisSessionRequest params = new org.bioconductor.packages.caGeneSetAnalysis.stubs.CreateCaGeneSetAnalysisSessionRequest();
    org.bioconductor.packages.caGeneSetAnalysis.stubs.CreateCaGeneSetAnalysisSessionResponse boxedResult = portType.createCaGeneSetAnalysisSession(params);
    return boxedResult.getSessionIdentifier();
    }
  }

  public void invokeAnalyze(org.bioconductor.cagrid.statefulservices.SessionIdentifier sessionIdentifier,org.bioconductor.cagrid.cagenesetanalysis.GeneSetAnalysisParameters geneSetAnalysisParameters) throws RemoteException {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"invokeAnalyze");
    org.bioconductor.packages.caGeneSetAnalysis.stubs.InvokeAnalyzeRequest params = new org.bioconductor.packages.caGeneSetAnalysis.stubs.InvokeAnalyzeRequest();
    org.bioconductor.packages.caGeneSetAnalysis.stubs.InvokeAnalyzeRequestSessionIdentifier sessionIdentifierContainer = new org.bioconductor.packages.caGeneSetAnalysis.stubs.InvokeAnalyzeRequestSessionIdentifier();
    sessionIdentifierContainer.setSessionIdentifier(sessionIdentifier);
    params.setSessionIdentifier(sessionIdentifierContainer);
    org.bioconductor.packages.caGeneSetAnalysis.stubs.InvokeAnalyzeRequestGeneSetAnalysisParameters geneSetAnalysisParametersContainer = new org.bioconductor.packages.caGeneSetAnalysis.stubs.InvokeAnalyzeRequestGeneSetAnalysisParameters();
    geneSetAnalysisParametersContainer.setGeneSetAnalysisParameters(geneSetAnalysisParameters);
    params.setGeneSetAnalysisParameters(geneSetAnalysisParametersContainer);
    org.bioconductor.packages.caGeneSetAnalysis.stubs.InvokeAnalyzeResponse boxedResult = portType.invokeAnalyze(params);
    }
  }

  public org.bioconductor.cagrid.statefulservices.Status getStatus(org.bioconductor.cagrid.statefulservices.SessionIdentifier sessionIdentifier) throws RemoteException {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"getStatus");
    org.bioconductor.packages.caGeneSetAnalysis.stubs.GetStatusRequest params = new org.bioconductor.packages.caGeneSetAnalysis.stubs.GetStatusRequest();
    org.bioconductor.packages.caGeneSetAnalysis.stubs.GetStatusRequestSessionIdentifier sessionIdentifierContainer = new org.bioconductor.packages.caGeneSetAnalysis.stubs.GetStatusRequestSessionIdentifier();
    sessionIdentifierContainer.setSessionIdentifier(sessionIdentifier);
    params.setSessionIdentifier(sessionIdentifierContainer);
    org.bioconductor.packages.caGeneSetAnalysis.stubs.GetStatusResponse boxedResult = portType.getStatus(params);
    return boxedResult.getStatus();
    }
  }

}