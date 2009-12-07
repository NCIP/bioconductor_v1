
package org.bioconductor.rserviceJms.worker;
import junit.framework.JUnit4TestAdapter;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.*;
import java.rmi.RemoteException;
import org.bioconductor.packages.rservices.*;

import org.bioconductor.packages.caCommonClasses.*;
import org.bioconductor.packages.caLinearModel.*;

public class RWorkerDataTest {
	private static MockService binding;

    /** For TTest test. */
    private static String[] tTestSampleAnnotationCollectionTestColumnName = {"handedness"};
    private static int[] tTestNumberOfTopReporters = {10};

    /** For OneFactorANOVA test. */
    private static String[] oneFactorANOVASampleAnnotationCollectionTestColumnName = {"ageCohort"};
    private static int[] oneFactorANOVANumberOfTopReporters = {10};

    /** For PairedTTest test. */
    private static String[] pairedTTestSampleAnnotationCollectionTestColumnName = {"handedness"};
    private static String[] pairedTTestSampleAnnotationCollectionPairingColumnName = {"pairing"};
    private static int[] pairedTTestNumberOfTopReporters = {10};

    /** For TwoFactorANOVA test. */
    private static String[] twoFactorSampleAnnotationCollectionFactorOneColumnName = {"handedness"};
    private static String[] twoFactorSampleAnnotationCollectionFactorTwoColumnName = {"ageCohort"};
    private static int[] twoFactorNumberOfTopReporters = {10};

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
	 * Data transfer to R TTest from Java
	 * org.bioconductor.packages.caLinearModel.TTest
	 */
	//@Ignore("please initialize data")
	@Test
	public void TestTTestToR() throws Exception {
		TTest inputVal = null;
		inputVal = new TTest(
                          tTestSampleAnnotationCollectionTestColumnName,
                          tTestNumberOfTopReporters);
		String rScript = getClass().getResource("R/TTest.R").getFile();
		String rVariable = "tTest";
		assertTrue(binding.mockJava2R(inputVal, rScript, rVariable));
	}

    /**
	 * Data transfer to R OneFactorANOVA from Java
	 * org.bioconductor.packages.caLinearModel.OneFactorANOVA
	 */
	//@Ignore("please initialize data")
	@Test
	public void TestOneFactorANOVAToR() throws Exception {
		OneFactorANOVA inputVal = null;
		inputVal = new OneFactorANOVA(
                          oneFactorANOVASampleAnnotationCollectionTestColumnName,
                          oneFactorANOVANumberOfTopReporters);
		String rScript = getClass().getResource("R/OneFactorANOVA.R").getFile();
		String rVariable = "oneFactorANOVA";
		assertTrue(binding.mockJava2R(inputVal, rScript, rVariable));
	}

    /**
	 * Data transfer to R PairedTTest from Java
	 * org.bioconductor.packages.caLinearModel.PairedTTest
	 */
	//@Ignore("please initialize data")
	@Test
	public void TestPairedTTestToR() throws Exception {
		PairedTTest inputVal = null;
		inputVal = new PairedTTest(
                          pairedTTestSampleAnnotationCollectionTestColumnName,
                          pairedTTestSampleAnnotationCollectionPairingColumnName,
                          pairedTTestNumberOfTopReporters);
		String rScript = getClass().getResource("R/PairedTTest.R").getFile();
		String rVariable = "pairedTTest";
		assertTrue(binding.mockJava2R(inputVal, rScript, rVariable));
	}

    /**
	 * Data transfer to R TwoFactorANOVA from Java
	 * org.bioconductor.packages.caLinearModel.TwoFactorANOVA
	 */
	//@Ignore("please initialize data")
	@Test
	public void TestTwoFactorANOVAToR() throws Exception {
		TwoFactorANOVA inputVal = null;
		inputVal = new TwoFactorANOVA(
                          twoFactorSampleAnnotationCollectionFactorOneColumnName,
                          twoFactorSampleAnnotationCollectionFactorTwoColumnName,
                          twoFactorNumberOfTopReporters);

		String rScript = getClass().getResource("R/TwoFactorANOVA.R").getFile();
		String rVariable = "fac";
		assertTrue(binding.mockJava2R(inputVal, rScript, rVariable));
	}

    /**
	 * Data transfer to R CommonReferenceANOVA from Java
	 * org.bioconductor.packages.caLinearModel.CommonReferenceANOVA
	 */
	//@Ignore("please initialize data")
	@Test
	public void TestCommonReferenceANOVAToR() throws Exception {
		CommonReferenceANOVA input = 
			new CommonReferenceANOVA(new String[] { "ageCohort"},
									 new String[] { "Mix" },
									 new int[] { 10 });
		String rScript = 
			getClass().getResource("R/CommonReferenceANOVA.R").getFile();
		String rVariable = "commonReferenceANOVA";
		assertTrue(binding.mockJava2R(input, rScript, rVariable));
	}
}
