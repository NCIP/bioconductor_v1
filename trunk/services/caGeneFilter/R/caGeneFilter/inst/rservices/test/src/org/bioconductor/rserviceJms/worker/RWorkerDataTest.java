
package org.bioconductor.rserviceJms.worker;
import junit.framework.JUnit4TestAdapter;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.*;
import java.rmi.RemoteException;
import org.bioconductor.packages.rservices.*;


public class RWorkerDataTest {
	private static MockService binding;

        /** For all the AnnotationFilter tests. */
        private static String[] annotation = {"hgu95av2"};

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
	 * Data transfer to R KOverAFilter from Java
	 * org.bioconductor.packages.caGeneFilter.KOverAFilter
	 */
	//@Ignore("please initialize data")
	@Test
	public void TestKOverAFilterToR() throws Exception {

                double[] minimumValue         = {200.0d};
                int[]    minimumElementNumber = {5};

		org.bioconductor.packages.caGeneFilter.KOverAFilter inputVal = null;
		inputVal = new org.bioconductor.packages.caGeneFilter.KOverAFilter(minimumValue, minimumElementNumber);
		String rScript = getClass().getResource("R/KOverAFilterData.R").getFile();
		String rVariable = "kOverAFilterData";
		assertTrue(binding.mockJava2R(inputVal, rScript, rVariable));
	}

        /**
	 * Data transfer to R VarianceFilter from Java
	 * org.bioconductor.packages.caGeneFilter.VarianceFilter
	 */
	//@Ignore("please initialize data")
	@Test
	public void TestVarianceFilterToR() throws Exception {

                double[] minimumVariance = {0.4d};

		org.bioconductor.packages.caGeneFilter.VarianceFilter inputVal = null;
		inputVal = new org.bioconductor.packages.caGeneFilter.VarianceFilter(minimumVariance);
		String rScript = getClass().getResource("R/VarianceFilterData.R").getFile();
		String rVariable = "varianceFilterData";
		assertTrue(binding.mockJava2R(inputVal, rScript, rVariable));
	}

        /**
	 * Data transfer to R GeneOntologyFilter from Java
	 * org.bioconductor.packages.caGeneFilter.GeneOntologyFilter
	 */
	//@Ignore("please initialize data")
	@Test
	public void TestGeneOntologyFilterToR() throws Exception {

                boolean[] isBiologicalProcess   = {true};
                boolean[] isCellularCompartment = {true};
                boolean[] isMolecularFunction   = {true};

		org.bioconductor.packages.caGeneFilter.GeneOntologyFilter inputVal = null;
		inputVal = new org.bioconductor.packages.caGeneFilter.GeneOntologyFilter(
                        isBiologicalProcess, isCellularCompartment, isMolecularFunction, annotation);
		String rScript = getClass().getResource("R/GeneOntologyFilterData.R").getFile();
		String rVariable = "geneOntologyFilterData";
		assertTrue(binding.mockJava2R(inputVal, rScript, rVariable));
	}

        /**
	 * Data transfer to R EntrezFilter from Java
	 * org.bioconductor.packages.caGeneFilter.EntrezFilter
	 */
	//@Ignore("please initialize data")
	@Test
	public void TestEntrezFilterToR() throws Exception {
		org.bioconductor.packages.caGeneFilter.EntrezFilter inputVal = null;
		inputVal = new org.bioconductor.packages.caGeneFilter.EntrezFilter(annotation);
		String rScript = getClass().getResource("R/EntrezFilterData.R").getFile();
		String rVariable = "entrezFilterData";
		assertTrue(binding.mockJava2R(inputVal, rScript, rVariable));
	}

        /**
	 * Data transfer to R MissingValueFilter from Java
	 * org.bioconductor.packages.caGeneFilter.MissingValueFilter
	 */
	//@Ignore("please initialize data")
	@Test
	public void TestMissingValueFilterToR() throws Exception {

                double[] missingValue = {Double.NEGATIVE_INFINITY};
                int[] minimumElementNumber = {26};

		org.bioconductor.packages.caGeneFilter.MissingValueFilter inputVal = null;
		inputVal = new org.bioconductor.packages.caGeneFilter.MissingValueFilter(missingValue, minimumElementNumber);
		String rScript = getClass().getResource("R/MissingValueFilterData.R").getFile();
		String rVariable = "missingValueFilterData";
		assertTrue(binding.mockJava2R(inputVal, rScript, rVariable));
	}

        /**
	 * Data transfer to R MinimumThresholdRecode from Java
	 * org.bioconductor.packages.caGeneFilter.MinimumThresholdRecode
	 */
	//@Ignore("please initialize data")
	@Test
	public void TestMinimumThresholdRecodeToR() throws Exception {

                double[] minimumThreshold = {-8000.0d};
                double[] minimumThresholdRecodeValue = {-8000.0d};

		org.bioconductor.packages.caGeneFilter.MinimumThresholdRecode inputVal = null;
		inputVal = new org.bioconductor.packages.caGeneFilter.MinimumThresholdRecode(minimumThreshold, minimumThresholdRecodeValue);
		String rScript = getClass().getResource("R/MinimumThresholdRecodeData.R").getFile();
		String rVariable = "minimumThresholdRecodeData";
		assertTrue(binding.mockJava2R(inputVal, rScript, rVariable));
	}

        /**
	 * Data transfer to R MaximumThresholdRecode from Java
	 * org.bioconductor.packages.caGeneFilter.MaximumThresholdRecode
	 */
	//@Ignore("please initialize data")
	@Test
	public void TestMaximumThresholdRecodeToR() throws Exception {

                double[] maximumThreshold = {10000.0d};
                double[] maximumThresholdRecodeValue = {10000.0d};

		org.bioconductor.packages.caGeneFilter.MaximumThresholdRecode inputVal = null;
		inputVal = new org.bioconductor.packages.caGeneFilter.MaximumThresholdRecode(maximumThreshold, maximumThresholdRecodeValue);
		String rScript = getClass().getResource("R/MaximumThresholdRecodeData.R").getFile();
		String rVariable = "maximumThresholdRecodeData";
		assertTrue(binding.mockJava2R(inputVal, rScript, rVariable));
	}

    /**
	 * Data transfer to R SpotQualityRecode from Java
	 * org.bioconductor.packages.caGeneFilter.MaximumThresholdRecode
	 */
	//@Ignore("please initialize data")
	@Test
	public void TestSpotQualityRecodeToR() throws Exception {

                String[] columnIdentifier = {"Flags"};
                double[] columnMinimumThresholdValue = {-25.0};
                double[] recodeValue = {Double.NEGATIVE_INFINITY};

		org.bioconductor.packages.caGeneFilter.SpotQualityRecode inputVal = null;
		inputVal = new org.bioconductor.packages.caGeneFilter.SpotQualityRecode(columnIdentifier,
                            columnMinimumThresholdValue, recodeValue);
		String rScript = getClass().getResource("R/SpotQualityRecodeData.R").getFile();
		String rVariable = "spotQualityRecodeData";
		assertTrue(binding.mockJava2R(inputVal, rScript, rVariable));
	}
}
