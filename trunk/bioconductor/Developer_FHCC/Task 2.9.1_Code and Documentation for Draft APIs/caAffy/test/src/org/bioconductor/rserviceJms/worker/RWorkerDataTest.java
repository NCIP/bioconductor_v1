
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
	 * we put this test here to let RWorkerDataTest work right out of box.
	 */
	@Test
	public void testMockServiceService() {
		assertNotNull(binding);
	}

	/**
	 * data transfer from R DerivedBioAssayMatrix to Java
	 * org.bioconductor.packages.caAffy.DerivedBioAssayMatrix
	 */
	@Ignore("please initialize data")
	@Test
	public void TestRToDerivedBioAssayMatrix() throws Exception {
		org.bioconductor.packages.caAffy.DerivedBioAssayMatrix outputVal = null;
		outputVal = new org.bioconductor.packages.caAffy.DerivedBioAssayMatrix();
		String rScript = getClass().getResource("R/DerivedBioAssayMatrixData.R").getFile();
		String rVariable = "DerivedBioAssayMatrixData";
		assertEquals(outputVal, binding.mockR2Java(rScript, rVariable));
	}

	/**
	 * data transfer to R ExpressoParameter from Java
	 * org.bioconductor.packages.caAffy.ExpressoParameter
	 */
	@Ignore("please initialize data")
	@Test
	public void TestExpressoParameterToR() throws Exception {
		org.bioconductor.packages.caAffy.ExpressoParameter inputVal = null;
		inputVal = new org.bioconductor.packages.caAffy.ExpressoParameter();
		String rScript = getClass().getResource("R/ExpressoParameterData.R").getFile();
		String rVariable = "ExpressoParameterData";
		assertTrue(binding.mockJava2R(inputVal, rScript, rVariable));
	}

	/**
	 * data transfer to R MeasuredBioAssayMatrix from Java
	 * org.bioconductor.packages.caAffy.MeasuredBioAssayMatrix
	 */
	@Ignore("please initialize data")
	@Test
	public void TestMeasuredBioAssayMatrixToR() throws Exception {
		org.bioconductor.packages.caAffy.MeasuredBioAssayMatrix inputVal = null;
		inputVal = new org.bioconductor.packages.caAffy.MeasuredBioAssayMatrix();
		String rScript = getClass().getResource("R/MeasuredBioAssayMatrixData.R").getFile();
		String rVariable = "MeasuredBioAssayMatrixData";
		assertTrue(binding.mockJava2R(inputVal, rScript, rVariable));
	}

	/**
	 * data transfer from R MIAME to Java
	 * org.bioconductor.packages.biobase.MIAME
	 */
	@Ignore("please initialize data")
	@Test
	public void TestRToMIAME() throws Exception {
		org.bioconductor.packages.biobase.MIAME outputVal = null;
		outputVal = new org.bioconductor.packages.biobase.MIAME();
		String rScript = getClass().getResource("R/MIAMEData.R").getFile();
		String rVariable = "MIAMEData";
		assertEquals(outputVal, binding.mockR2Java(rScript, rVariable));
	}

	/**
	 * data transfer to R NormalizeMethodParameter from Java
	 * org.bioconductor.packages.caAffy.NormalizeMethodParameter
	 */
	@Ignore("please initialize data")
	@Test
	public void TestNormalizeMethodParameterToR() throws Exception {
		org.bioconductor.packages.caAffy.NormalizeMethodParameter inputVal = null;
		inputVal = new org.bioconductor.packages.caAffy.NormalizeMethodParameter();
		String rScript = getClass().getResource("R/NormalizeMethodParameterData.R").getFile();
		String rVariable = "NormalizeMethodParameterData";
		assertTrue(binding.mockJava2R(inputVal, rScript, rVariable));
	}

	/**
	 * data transfer from R ProbeLevelLinearModel to Java
	 * org.bioconductor.packages.caAffy.ProbeLevelLinearModel
	 */
	@Ignore("please initialize data")
	@Test
	public void TestRToProbeLevelLinearModel() throws Exception {
		org.bioconductor.packages.caAffy.ProbeLevelLinearModel outputVal = null;
		outputVal = new org.bioconductor.packages.caAffy.ProbeLevelLinearModel();
		String rScript = getClass().getResource("R/ProbeLevelLinearModelData.R").getFile();
		String rVariable = "ProbeLevelLinearModelData";
		assertEquals(outputVal, binding.mockR2Java(rScript, rVariable));
	}

	/**
	 * data transfer from R QaReport to Java
	 * org.bioconductor.packages.caAffy.QaReport
	 */
	@Ignore("please initialize data")
	@Test
	public void TestRToQaReport() throws Exception {
		org.bioconductor.packages.caAffy.QaReport outputVal = null;
		outputVal = new org.bioconductor.packages.caAffy.QaReport();
		String rScript = getClass().getResource("R/QaReportData.R").getFile();
		String rVariable = "QaReportData";
		assertEquals(outputVal, binding.mockR2Java(rScript, rVariable));
	}

	/**
	 * data transfer from R QualityControlStatistics to Java
	 * org.bioconductor.packages.caAffy.QualityControlStatistics
	 */
	@Ignore("please initialize data")
	@Test
	public void TestRToQualityControlStatistics() throws Exception {
		org.bioconductor.packages.caAffy.QualityControlStatistics outputVal = null;
		outputVal = new org.bioconductor.packages.caAffy.QualityControlStatistics();
		String rScript = getClass().getResource("R/QualityControlStatisticsData.R").getFile();
		String rVariable = "QualityControlStatisticsData";
		assertEquals(outputVal, binding.mockR2Java(rScript, rVariable));
	}

	/**
	 * data transfer from R Versions to Java
	 * org.bioconductor.packages.biobase.Versions
	 */
	@Ignore("please initialize data")
	@Test
	public void TestRToVersions() throws Exception {
		org.bioconductor.packages.biobase.Versions outputVal = null;
		outputVal = new org.bioconductor.packages.biobase.Versions();
		String rScript = getClass().getResource("R/VersionsData.R").getFile();
		String rVariable = "VersionsData";
		assertEquals(outputVal, binding.mockR2Java(rScript, rVariable));
	}
}
