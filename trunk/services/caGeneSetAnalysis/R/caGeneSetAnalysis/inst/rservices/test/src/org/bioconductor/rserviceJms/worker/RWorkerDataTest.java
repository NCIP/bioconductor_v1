
package org.bioconductor.rserviceJms.worker;

import junit.framework.JUnit4TestAdapter;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.*;
import java.rmi.RemoteException;
import org.bioconductor.packages.rservices.*;

import org.bioconductor.packages.caCommonClasses.*;
import org.bioconductor.packages.caGeneSetAnalysis.*;

public class RWorkerDataTest {
	private static MockService binding;

	/**
	 * Used for backward compatibility (IDEs, Ant and JUnit 3.x text runner)
	 */
	public static junit.framework.Test suite() {
		 return new JUnit4TestAdapter(RWorkerDataTest.class);
	}

	/**
	 * Sets up the test fixture; Called before all the tests; Called only once.
	 */
	@BeforeClass
	public static void oneTimeSetUp() throws Exception {
		RWorkerProperties prop = new RWorkerProperties();
		RWorkerREnv e = new RWorkerREnv(prop);
		binding=new MockService(e);
	}

	/**
	 * We put this test here to let RWorkerDataTest work right out of box.
	 */
	@Test
	public void testMockServiceService() {
		assertNotNull(binding);
	}

	/**
	 * Data transfer to R GeneOntologyDiscreteGeneSetAnalysisParameters from Java
	 * org.bioconductor.packages.caGeneSetAnalysis.GeneOntologyDiscreteGeneSetAnalysisParameters.
	 */
	//@Ignore("please initialize data")
	@Test
	public void TestGeneOntologyDiscreteGeneSetAnalysisParametersToR() throws Exception {

        String[] ontology       = {"BP"};
        double[] discretePValue = {0.05};
        String[] testDirection  = {"over-represented"};
        String[] annotation     = {"hgu95av2"};

		GeneOntologyDiscreteGeneSetAnalysisParameters inputVal =
                        new GeneOntologyDiscreteGeneSetAnalysisParameters(
                                                ontology,
                                                discretePValue,
                                                testDirection,
                                                annotation );
		String rScript = getClass().getResource("R/GeneOntologyDiscreteGeneSetAnalysisParameters.R").getFile();
		String rVariable = "geneOntologyDiscreteGeneSetAnalysisParameters";
		assertTrue(binding.mockJava2R(inputVal, rScript, rVariable));
	}

        /**
	 * Data transfer to R GeneOntologyContinuousGeneSetAnalysisParameters from Java
	 * org.bioconductor.packages.caGeneSetAnalysis.GeneOntologyContinuousGeneSetAnalysisParameters.
	 */
	//@Ignore("please initialize data")
	@Test
	public void TestGeneOntologyContinuousGeneSetAnalysisParametersToR() throws Exception {

        String[] ontology            = {"BP"};
        int[] minimumGenesPerGeneSet = {10};
        String[] annotation          = {"hgu95av2"};

		GeneOntologyContinuousGeneSetAnalysisParameters inputVal = new GeneOntologyContinuousGeneSetAnalysisParameters(
                                                                             ontology,
                                                                             minimumGenesPerGeneSet,
                                                                             annotation );
		String rScript = getClass().getResource("R/GeneOntologyContinuousGeneSetAnalysisParameters.R").getFile();
		String rVariable = "geneOntologyContinuousGeneSetAnalysisParameters";
		assertTrue(binding.mockJava2R(inputVal, rScript, rVariable));
	}

        /**
	 * Data transfer to R KEGGDiscreteGeneSetAnalysisParameters from Java
	 * org.bioconductor.packages.caGeneSetAnalysis.KEGGDiscreteGeneSetAnalysisParameters.
	 */
	//@Ignore("please initialize data")
	@Test
	public void TestKEGGDiscreteGeneSetAnalysisParametersToR() throws Exception {
        
        double[] discretePValue = {0.05};
        String[] testDirection  = {"over-represented"};
        String[] annotation     = {"hgu95av2"};
           
		KEGGDiscreteGeneSetAnalysisParameters inputVal = new KEGGDiscreteGeneSetAnalysisParameters(
                                                                   discretePValue,
                                                                   testDirection,
                                                                   annotation );
		String rScript = getClass().getResource("R/KEGGDiscreteGeneSetAnalysisParameters.R").getFile();
		String rVariable = "keggDiscreteGeneSetAnalysisParameters";
		assertTrue(binding.mockJava2R(inputVal, rScript, rVariable));
	}

        /**
	 * Data transfer to R KEGGContinuousGeneSetAnalysisParameters from Java
	 * org.bioconductor.packages.caGeneSetAnalysis.KEGGContinuousGeneSetAnalysisParameters.
	 */
	//@Ignore("please initialize data")
	@Test
	public void TestKEGGContinuousGeneSetAnalysisParametersToR() throws Exception {

        int[] minimumGenesPerGeneSet = {10};
        String[] annotation          = {"hgu95av2"};

		KEGGContinuousGeneSetAnalysisParameters inputVal = new KEGGContinuousGeneSetAnalysisParameters(
                                                                      minimumGenesPerGeneSet,
                                                                      annotation );
		String rScript = getClass().getResource("R/KEGGContinuousGeneSetAnalysisParameters.R").getFile();
		String rVariable = "keggContinuousGeneSetAnalysisParameters";
		assertTrue(binding.mockJava2R(inputVal, rScript, rVariable));
	}

        /**
	 * Data transfer to R PFAMDiscreteGeneSetAnalysisParameters from Java
	 * org.bioconductor.packages.caGeneSetAnalysis.PFAMDiscreteGeneSetAnalysisParameters.
	 */
	//@Ignore("please initialize data")
	@Test
	public void TestPFAMDiscreteGeneSetAnalysisParametersToR() throws Exception {
   
        double[] discretePValue = {0.05};
        String[] testDirection  = {"over-represented"};
        String[] annotation     = {"hgu95av2"};

		PFAMDiscreteGeneSetAnalysisParameters inputVal = new PFAMDiscreteGeneSetAnalysisParameters(
                                                                    discretePValue,
                                                                    testDirection,
                                                                    annotation );
		String rScript = getClass().getResource("R/PFAMDiscreteGeneSetAnalysisParameters.R").getFile();
		String rVariable = "pfamDiscreteGeneSetAnalysisParameters";
		assertTrue(binding.mockJava2R(inputVal, rScript, rVariable));
	}

        /**
	 * Data transfer to R PFAMContinuousGeneSetAnalysisParameters from Java
	 * org.bioconductor.packages.caGeneSetAnalysis.PFAMContinuousGeneSetAnalysisParameters.
	 */
	//@Ignore("please initialize data")
	@Test
	public void TestPFAMContinuousGeneSetAnalysisParametersToR() throws Exception {

        int[] minimumGenesPerGeneSet = {10};
        String[] annotation          = {"hgu95av2"};
        
		PFAMContinuousGeneSetAnalysisParameters inputVal = new PFAMContinuousGeneSetAnalysisParameters(
                                                                     minimumGenesPerGeneSet,
                                                                     annotation );
		String rScript = getClass().getResource("R/PFAMContinuousGeneSetAnalysisParameters.R").getFile();
		String rVariable = "pfamContinuousGeneSetAnalysisParameters";
		assertTrue(binding.mockJava2R(inputVal, rScript, rVariable));
	}

	/**
	 * Data transfer to R DiscreteGeneSetAnalysisResultCollection from Java
	 * org.bioconductor.packages.caGeneSetAnalysis.DiscreteGeneSetAnalysisResultCollection.
	 */
	//@Ignore("please initialize data")
	@Test
	public void TestDiscreteGeneSetAnalysisResultCollectionToR() throws Exception {

        
            int[] selectedCount   = { 50, 100, 150 };
            int[] expectedCount   = { 55, 105, 155 };
            String[] description  = { "description" };
            String[] geneSetId    = { "A", "B", "C" };
            int[] geneSetSize     = { 100, 200, 300 };
            double[] pValue       = { 0.05, 0.3, 0.001 };

            String[] gs1            = { "x1", "y1" };
            String[] gs2            = { "x2", "y2" };
            String[] gs3            = { "x3", "y3" };
            Object[] geneSetMembers = { gs1, gs2, gs3 };
        
            DiscreteGeneSetAnalysisResultCollection inputVal = new DiscreteGeneSetAnalysisResultCollection(
                                            selectedCount,
                                            expectedCount,
                                            description,
                                            geneSetId,
                                            geneSetSize,
                                            pValue,
                                            geneSetMembers
                                            );
            String rScript = getClass().getResource("R/DiscreteGeneSetAnalysisResultCollection.R").getFile();
            String rVariable = "discreteGeneSetAnalysisResultCollection";
            assertTrue(binding.mockJava2R(inputVal, rScript, rVariable));
	}
    
    /**
	 * Data transfer to R ContinuousGeneSetAnalysisResultCollection from Java
	 * org.bioconductor.packages.caGeneSetAnalysis.ContinuousGeneSetAnalysisResultCollection.
	 */
	//@Ignore("please initialize data")
	@Test
	public void TestContinuousGeneSetAnalysisResultCollectionToR() throws Exception {

            double[] adjustedTStatistic = {0.01, 0.35, 0.41};
            String[] description        = { "description" };
            String[] geneSetId          = { "A", "B", "C" };
            int[] geneSetSize           = { 100, 200, 300 };
            double[] pValue             = { 0.05, 0.3, 0.001 };

            String[] gs1            = { "x1", "y1" };
            String[] gs2            = { "x2", "y2" };
            String[] gs3            = { "x3", "y3" };
            Object[] geneSetMembers = { gs1, gs2, gs3 };

            ContinuousGeneSetAnalysisResultCollection inputVal = new ContinuousGeneSetAnalysisResultCollection(
                                                adjustedTStatistic,
                                                description,
                                                geneSetId,
                                                geneSetSize,
                                                pValue,
                                                geneSetMembers );
            String rScript = getClass().getResource("R/ContinuousGeneSetAnalysisResultCollection.R").getFile();
            String rVariable = "continuousGeneSetAnalysisResultCollection";
            assertTrue(binding.mockJava2R(inputVal, rScript, rVariable));
	}
}
