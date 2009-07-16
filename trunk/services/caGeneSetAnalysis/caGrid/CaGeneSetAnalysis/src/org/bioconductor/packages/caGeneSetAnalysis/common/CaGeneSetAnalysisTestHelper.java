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
	
	public static org.bioconductor.cagrid.cagenesetanalysis.GeneSetParameters convertToCaGridGeneSetParameters(org.bioconductor.packages.caGeneSetAnalysis.GeneSetParameters rGeneSetParams)
	{
		org.bioconductor.cagrid.cagenesetanalysis.GeneSetParameters cagridGeneSetParams = new org.bioconductor.cagrid.cagenesetanalysis.GeneSetParameters();		
		
		if(rGeneSetParams instanceof org.bioconductor.packages.caGeneSetAnalysis.DiscreteParameters) {			
			if(rGeneSetParams instanceof org.bioconductor.packages.caGeneSetAnalysis.GeneOntologyDiscreteParameters) {
				cagridGeneSetParams = new org.bioconductor.cagrid.cagenesetanalysis.GeneOntologyDiscreteParameters();
				((org.bioconductor.cagrid.cagenesetanalysis.GeneOntologyDiscreteParameters)cagridGeneSetParams).setOntology(
						((org.bioconductor.packages.caGeneSetAnalysis.GeneOntologyDiscreteParameters) rGeneSetParams).getOntology()[0]);
			}
			else if(rGeneSetParams instanceof org.bioconductor.packages.caGeneSetAnalysis.PFAMDiscreteParameters) {
				cagridGeneSetParams = new org.bioconductor.cagrid.cagenesetanalysis.PfamDiscreteParameters();
			}
			else if(rGeneSetParams instanceof org.bioconductor.packages.caGeneSetAnalysis.KEGGDiscreteParameters) {
				cagridGeneSetParams = new org.bioconductor.cagrid.cagenesetanalysis.KEGGDiscreteParameters();
			}
			else return null;
			
			cagridGeneSetParams.setAnnotation(rGeneSetParams.getAnnotation()[0]);
			((org.bioconductor.cagrid.cagenesetanalysis.DiscreteParameters)cagridGeneSetParams).setDiscretePValue(
					((org.bioconductor.packages.caGeneSetAnalysis.DiscreteParameters) rGeneSetParams).getCategoryPValue()[0]);
			((org.bioconductor.cagrid.cagenesetanalysis.DiscreteParameters)cagridGeneSetParams).setTestDirection(
					((org.bioconductor.packages.caGeneSetAnalysis.DiscreteParameters) rGeneSetParams).getTestDirection()[0]);
			
			return cagridGeneSetParams;
		}
		else if(rGeneSetParams instanceof org.bioconductor.packages.caGeneSetAnalysis.ContinuousParameters) {
			if(rGeneSetParams instanceof org.bioconductor.packages.caGeneSetAnalysis.GeneOntologyContinuousParameters) {
				cagridGeneSetParams = new org.bioconductor.cagrid.cagenesetanalysis.GeneOntologyContinuousParameters();
				((org.bioconductor.cagrid.cagenesetanalysis.GeneOntologyContinuousParameters)cagridGeneSetParams).setOntology(
						((org.bioconductor.packages.caGeneSetAnalysis.GeneOntologyContinuousParameters) rGeneSetParams).getOntology()[0]);
			}
			else if(rGeneSetParams instanceof org.bioconductor.packages.caGeneSetAnalysis.PFAMContinuousParameters) {
				cagridGeneSetParams = new org.bioconductor.cagrid.cagenesetanalysis.PfamContinuousParameters();
			}
			else if(rGeneSetParams instanceof org.bioconductor.packages.caGeneSetAnalysis.KEGGContinuousParameters) {
				cagridGeneSetParams = new org.bioconductor.cagrid.cagenesetanalysis.KEGGContinuousParameters();
			}
			else return null;
			
			cagridGeneSetParams.setAnnotation(rGeneSetParams.getAnnotation()[0]);
			((org.bioconductor.cagrid.cagenesetanalysis.ContinuousParameters)cagridGeneSetParams).setMinimumGenesPerGeneSet(
					((org.bioconductor.packages.caGeneSetAnalysis.ContinuousParameters) rGeneSetParams).getMinimumGenesPerGeneSet()[0]);
			
			return cagridGeneSetParams;
		}
		else return null;
			
	}
	
	public static org.bioconductor.cagrid.cagenesetanalysis.GeneSetParameters deserializeToCaGridGeneSetParam(String filePath) throws Exception {
		org.bioconductor.packages.caGeneSetAnalysis.GeneSetParameters rGeneSetParams = deserializeGeneSetParams(filePath);
		return convertToCaGridGeneSetParameters(rGeneSetParams);
	}
	
	public static org.bioconductor.cagrid.data.TopTable deserializeToCaGridTopTable(String filePath) throws Exception {
		org.bioconductor.packages.caCommonClasses.TopTable rTopTable = deserializeTopTable(filePath);
		return convertToCaGridTopTable(rTopTable);
	}
	
	
	private static org.bioconductor.packages.caGeneSetAnalysis.GeneSetParameters deserializeGeneSetParams(String filePath) throws java.io.IOException, Exception
	{
		java.io.FileInputStream fis = null;
		java.io.ObjectInputStream ois = null;
		
		try {
			fis = new java.io.FileInputStream(filePath);
			ois = new java.io.ObjectInputStream(fis);
			System.out.println("Deserialize file at: " + filePath + " to an object");
			Object deserObj = ois.readObject();
			System.out.println("Done deserialize data to object.  Its type: " + deserObj.getClass().getName());
			return (org.bioconductor.packages.caGeneSetAnalysis.GeneSetParameters) deserObj;
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
