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
			  String geneSetParamFile = "/home/mtra2/CaGridProj/CaGeneSetAnalysis/Data/GeneOntologyContinuousParameters.rda_java.Data";		  
			  org.bioconductor.cagrid.cagenesetanalysis.GeneSetParameters cagridGeneSetParams = CaGeneSetAnalysisTestHelper.deserializeToCaGridGeneSetParam(geneSetParamFile);
			  System.out.println("Parameter Type: " + cagridGeneSetParams.getClass().getName());
			  

			  System.out.println("Annotation: " + cagridGeneSetParams.getAnnotation());
//			  System.out.println("DiscretePValue: " + ((org.bioconductor.cagrid.cagenesetanalysis.PfamContinuousParameters)cagridGeneSetParams).getMinimumGenesPerGeneSet());
//			  System.out.println("testDirection: " + ((org.bioconductor.cagrid.cagenesetanalysis.DiscreteParameters)cagridGeneSetParams).getTestDirection());
//			  System.out.println("Ontology: " + ((org.bioconductor.cagrid.cagenesetanalysis.GeneOntologyDiscreteParameters)cagridGeneSetParams).getOntology());
			  
			  String topTableFilePath = "/home/mtra2/CaGridProj/CaGeneSetAnalysis/Data/TopTableForContinuousAnalysis.rda_java.Data";			  
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
			  
			  org.bioconductor.cagrid.cagenesetanalysis.GeneSetCollection geneSetColl = client.analyze(cagridTopTable, cagridGeneSetParams); 
			  if(geneSetColl != null) {
				  System.out.println("Got Result returned...");
				  client.printGeneSetCollectionResult(geneSetColl);
			  }
			  
			  
			  
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
	
	public void printGeneSetCollectionResult(final org.bioconductor.cagrid.cagenesetanalysis.GeneSetCollection geneSetColl)
	{
		System.out.println("GeneSetCollection description: " + geneSetColl.getDescription());
		
		if(geneSetColl instanceof org.bioconductor.cagrid.cagenesetanalysis.DiscreteGeneSet) {
			org.bioconductor.cagrid.cagenesetanalysis.DiscreteGeneSet geneSet = (org.bioconductor.cagrid.cagenesetanalysis.DiscreteGeneSet)geneSetColl;
			int entryLength = geneSet.getCategoricalGeneSetEntry().length;
			for(int entry = 0; entry < entryLength; entry++) {
				org.bioconductor.cagrid.cagenesetanalysis.DiscreteGeneSetEntry geneSetEntry = geneSet.getCategoricalGeneSetEntry(entry); 
				System.out.println("expectedCount: " + geneSetEntry.getExpectedCount() + " geneSEtId: " + geneSetEntry.getGeneSetId() + 
						           " geneSetSize: " + geneSetEntry.getGeneSetSize() + " pValue: " + geneSetEntry.getPValue() + " selectedCount: " + geneSetEntry.getSelectedCount());
				
				System.out.println("Done with entry: " + entry);
			}
		}
		else if(geneSetColl instanceof org.bioconductor.cagrid.cagenesetanalysis.ContinuousGeneSet) {
			org.bioconductor.cagrid.cagenesetanalysis.ContinuousGeneSet geneSet = (org.bioconductor.cagrid.cagenesetanalysis.ContinuousGeneSet)geneSetColl;
			int entryLength = geneSet.getContinuousGeneSetEntry().length;
			for(int entry = 0; entry < entryLength; entry++) {
				org.bioconductor.cagrid.cagenesetanalysis.ContinuousGeneSetEntry geneSetEntry = geneSet.getContinuousGeneSetEntry(entry); 
				System.out.println("geneSetId: " +  geneSetEntry.getGeneSetId() + " geneSetSize: " + geneSetEntry.getGeneSetSize() + 
						           " pValue: " + geneSetEntry.getPValue() + " tAdjusted: " + geneSetEntry.getTAdjusted());
				
				System.out.println("Done with entry: " + entry);
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

  public org.bioconductor.cagrid.cagenesetanalysis.GeneSetCollection analyze(org.bioconductor.cagrid.data.TopTable topTable,org.bioconductor.cagrid.cagenesetanalysis.GeneSetParameters geneSetParameters) throws RemoteException {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"analyze");
    org.bioconductor.packages.caGeneSetAnalysis.stubs.AnalyzeRequest params = new org.bioconductor.packages.caGeneSetAnalysis.stubs.AnalyzeRequest();
    org.bioconductor.packages.caGeneSetAnalysis.stubs.AnalyzeRequestTopTable topTableContainer = new org.bioconductor.packages.caGeneSetAnalysis.stubs.AnalyzeRequestTopTable();
    topTableContainer.setTopTable(topTable);
    params.setTopTable(topTableContainer);
    org.bioconductor.packages.caGeneSetAnalysis.stubs.AnalyzeRequestGeneSetParameters geneSetParametersContainer = new org.bioconductor.packages.caGeneSetAnalysis.stubs.AnalyzeRequestGeneSetParameters();
    geneSetParametersContainer.setGeneSetParameters(geneSetParameters);
    params.setGeneSetParameters(geneSetParametersContainer);
    org.bioconductor.packages.caGeneSetAnalysis.stubs.AnalyzeResponse boxedResult = portType.analyze(params);
    return boxedResult.getGeneSetCollection();
    }
  }

}
