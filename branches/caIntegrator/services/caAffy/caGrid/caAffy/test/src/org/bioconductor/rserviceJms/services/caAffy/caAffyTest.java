
package org.bioconductor.rserviceJms.services.caAffy;
import junit.framework.JUnit4TestAdapter;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.*;
import java.rmi.RemoteException;


public class caAffyTest {
	private static caAffy binding;

	/**
	 * Used for backward compatibility (IDEs, Ant and JUnit 3.x text runner)
	 */
	public static junit.framework.Test suite() {
		 return new JUnit4TestAdapter(caAffyTest.class);
	}

	/**
	 * Sets up the test fixture; Called before all the tests; Called only once.
	 */
	@BeforeClass
	public static void oneTimeSetUp() throws Exception {
		binding=new caAffy();
	}

	/**
	 * we put this test here to let caAffyTest work right out of box.
	 */
	@Test
	public void testcaAffyService() {
		assertNotNull(binding);
	}

	/**
	 * Tests caAffy.caQAReport
	 */
	@Ignore("please initialize function parameters")
	@Test
	public void TestCaQAReport() throws RemoteException {
		// initialize measuredBioAssays here.
		org.bioconductor.packages.caAffy.MeasuredBioAssayMatrix caQAReport_measuredBioAssays = null;
		// caQAReport_measuredBioAssays = new org.bioconductor.packages.caAffy.MeasuredBioAssayMatrix();

		// initialize expected result here.
		org.bioconductor.packages.caAffy.QaReport caQAReport_ans = null;
		// caQAReport_ans = new org.bioconductor.packages.caAffy.QaReport();

		assertEquals(caQAReport_ans, binding.caQAReport(caQAReport_measuredBioAssays));
	}

	/**
	 * Tests caAffy.caExpresso
	 */
	@Ignore("please initialize function parameters")
	@Test
	public void TestCaExpresso() throws RemoteException {
		// initialize measuredBioAssays here.
		org.bioconductor.packages.caAffy.MeasuredBioAssayMatrix caExpresso_measuredBioAssays = null;
		// caExpresso_measuredBioAssays = new org.bioconductor.packages.caAffy.MeasuredBioAssayMatrix();

		// initialize expressoParameter here.
		org.bioconductor.packages.caAffy.ExpressoParameter caExpresso_expressoParameter = null;
		// caExpresso_expressoParameter = new org.bioconductor.packages.caAffy.ExpressoParameter();

		// initialize expected result here.
		org.bioconductor.packages.caAffy.DerivedBioAssayMatrix caExpresso_ans = null;
		// caExpresso_ans = new org.bioconductor.packages.caAffy.DerivedBioAssayMatrix();

		assertEquals(caExpresso_ans, binding.caExpresso(caExpresso_measuredBioAssays, caExpresso_expressoParameter));
	}
}
