package org.bioconductor.packages.caGeneSetAnalysis.common;

public class CaGeneSetAnalysisTestHelper {
	public static org.bioconductor.cagrid.data.TopTable convertToCaGridTopTable(org.bioconductor.packages.caCommonClasses.TopTable rTopTable) 
	{
		org.bioconductor.cagrid.data.TopTable cagridTopTable = new org.bioconductor.cagrid.data.TopTable();
		int entriesLength = rTopTable.getReporterName().length;
		
		org.bioconductor.cagrid.data.TopTableEntry[] topTableEntries = new org.bioconductor.cagrid.data.TopTableEntry[entriesLength];
		for(int entry = 0; entry < entriesLength; entry++) {
			topTableEntries[entry] = new org.bioconductor.cagrid.data.TopTableEntry();
			topTableEntries[entry].setAdjustedPValue(rTopTable.getAdjustedPValue()[entry]);
			topTableEntries[entry].setLogFoldChange(rTopTable.getLogFoldChange()[entry]);
			topTableEntries[entry].setLogOddsScore(rTopTable.getLogOddsScore()[entry]);
			topTableEntries[entry].setPValue(rTopTable.getPValue()[entry]);
			topTableEntries[entry].setReporterName(rTopTable.getReporterName()[entry]);
			topTableEntries[entry].setTCoefficient(rTopTable.getTCoefficient()[entry]);
		}
		
		cagridTopTable.setContrastSpecification(rTopTable.getContrastSpecification()[0]);
		cagridTopTable.setTopTableEntry(topTableEntries);
		
		return cagridTopTable;
		
	}
	
	public static org.bioconductor.cagrid.cagenesetanalysis.GeneSetAnalysisParameters convertToCaGridGeneSetParameters(
			                                                          org.bioconductor.packages.caGeneSetAnalysis.GeneSetAnalysisParameters rGeneSetParams)
	{
		org.bioconductor.cagrid.cagenesetanalysis.GeneSetAnalysisParameters cagridGeneSetParams = new org.bioconductor.cagrid.cagenesetanalysis.GeneSetAnalysisParameters();		
		
		if(rGeneSetParams instanceof org.bioconductor.packages.caGeneSetAnalysis.DiscreteGeneSetAnalysisParameters) {			
			if(rGeneSetParams instanceof org.bioconductor.packages.caGeneSetAnalysis.GeneOntologyDiscreteGeneSetAnalysisParameters) {
				cagridGeneSetParams = new org.bioconductor.cagrid.cagenesetanalysis.GeneOntologyDiscreteGeneSetAnalysisParameters();
				((org.bioconductor.cagrid.cagenesetanalysis.GeneOntologyDiscreteGeneSetAnalysisParameters)cagridGeneSetParams).setOntology(
						((org.bioconductor.packages.caGeneSetAnalysis.GeneOntologyDiscreteGeneSetAnalysisParameters) rGeneSetParams).getOntology()[0]);
			}
			else if(rGeneSetParams instanceof org.bioconductor.packages.caGeneSetAnalysis.PFAMDiscreteGeneSetAnalysisParameters) {
				cagridGeneSetParams = new org.bioconductor.cagrid.cagenesetanalysis.PfamDiscreteGeneSetAnalysisParameters();
			}
			else if(rGeneSetParams instanceof org.bioconductor.packages.caGeneSetAnalysis.KEGGDiscreteGeneSetAnalysisParameters) {
				cagridGeneSetParams = new org.bioconductor.cagrid.cagenesetanalysis.KEGGDiscreteGeneSetAnalysisParameters();
			}
			else return null;
			
			cagridGeneSetParams.setAnnotation(rGeneSetParams.getAnnotation()[0]);
			((org.bioconductor.cagrid.cagenesetanalysis.DiscreteGeneSetAnalysisParameters)cagridGeneSetParams).setDiscretePValue(
					((org.bioconductor.packages.caGeneSetAnalysis.DiscreteGeneSetAnalysisParameters) rGeneSetParams).getDiscretePValue()[0]);
			((org.bioconductor.cagrid.cagenesetanalysis.DiscreteGeneSetAnalysisParameters)cagridGeneSetParams).setTestDirection(
					((org.bioconductor.packages.caGeneSetAnalysis.DiscreteGeneSetAnalysisParameters) rGeneSetParams).getTestDirection()[0]);
			
			return cagridGeneSetParams;
		}
		else if(rGeneSetParams instanceof org.bioconductor.packages.caGeneSetAnalysis.ContinuousGeneSetAnalysisParameters) {
			if(rGeneSetParams instanceof org.bioconductor.packages.caGeneSetAnalysis.GeneOntologyContinuousGeneSetAnalysisParameters) {
				cagridGeneSetParams = new org.bioconductor.cagrid.cagenesetanalysis.GeneOntologyContinuousGeneSetAnalysisParameters();
				((org.bioconductor.cagrid.cagenesetanalysis.GeneOntologyContinuousGeneSetAnalysisParameters)cagridGeneSetParams).setOntology(
						((org.bioconductor.packages.caGeneSetAnalysis.GeneOntologyContinuousGeneSetAnalysisParameters) rGeneSetParams).getOntology()[0]);
			}
			else if(rGeneSetParams instanceof org.bioconductor.packages.caGeneSetAnalysis.PFAMContinuousGeneSetAnalysisParameters) {
				cagridGeneSetParams = new org.bioconductor.cagrid.cagenesetanalysis.PfamContinuousGeneSetAnalysisParameters();
			}
			else if(rGeneSetParams instanceof org.bioconductor.packages.caGeneSetAnalysis.KEGGContinuousGeneSetAnalysisParameters) {
				cagridGeneSetParams = new org.bioconductor.cagrid.cagenesetanalysis.KEGGContinuousGeneSetAnalysisParameters();
			}
			else return null;
			
			cagridGeneSetParams.setAnnotation(rGeneSetParams.getAnnotation()[0]);
			((org.bioconductor.cagrid.cagenesetanalysis.ContinuousGeneSetAnalysisParameters)cagridGeneSetParams).setMinimumGenesPerGeneSet(
					((org.bioconductor.packages.caGeneSetAnalysis.ContinuousGeneSetAnalysisParameters) rGeneSetParams).getMinimumGenesPerGeneSet()[0]);
			
			return cagridGeneSetParams;
		}
		else return null;
			
	}
	
	public static org.bioconductor.cagrid.cagenesetanalysis.GeneSetAnalysisParameters deserializeToCaGridGeneSetParam(String filePath) throws Exception {
		org.bioconductor.packages.caGeneSetAnalysis.GeneSetAnalysisParameters rGeneSetParams = deserializeGeneSetParams(filePath);
		return convertToCaGridGeneSetParameters(rGeneSetParams);
	}
	
	public static org.bioconductor.cagrid.data.TopTable deserializeToCaGridTopTable(String filePath) throws Exception {
		org.bioconductor.packages.caCommonClasses.TopTable rTopTable = deserializeTopTable(filePath);
		return convertToCaGridTopTable(rTopTable);
	}
	
	
	private static org.bioconductor.packages.caGeneSetAnalysis.GeneSetAnalysisParameters deserializeGeneSetParams(String filePath) throws java.io.IOException, Exception
	{
		java.io.FileInputStream fis = null;
		java.io.ObjectInputStream ois = null;
		
		try {
			fis = new java.io.FileInputStream(filePath);
			ois = new java.io.ObjectInputStream(fis);
			System.out.println("Deserialize file at: " + filePath + " to an object");
			Object deserObj = ois.readObject();
			System.out.println("Done deserialize data to object.  Its type: " + deserObj.getClass().getName());
			return (org.bioconductor.packages.caGeneSetAnalysis.GeneSetAnalysisParameters) deserObj;
		}
		catch(java.io.IOException ew) {
			throw ew;
		}
		catch(Exception ew) {
			throw ew;
		}
		finally {
			if(fis != null) fis.close();
			if(ois != null) ois.close();
		}
	}
	
	private static org.bioconductor.packages.caCommonClasses.TopTable deserializeTopTable(String filePath) throws java.io.IOException, Exception
	{
		java.io.FileInputStream fis = null;
		java.io.ObjectInputStream ois = null;
		
		try {
			fis = new java.io.FileInputStream(filePath);
			ois = new java.io.ObjectInputStream(fis);
			Object deserObj = ois.readObject();
			return (org.bioconductor.packages.caCommonClasses.TopTable) deserObj;
		}
		catch(java.io.IOException ew) {
			throw ew;
		}
		catch(Exception ew) {
			throw ew;
		}
		finally {
			if(fis != null) fis.close();
			if(ois != null) ois.close();
		}
	}
	
}
