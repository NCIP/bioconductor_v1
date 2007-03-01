
package org.bioconductor.rserviceJms.worker;
import junit.framework.JUnit4TestAdapter;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.*;
import java.rmi.RemoteException;
import org.bioconductor.packages.rservices.*;

import gov.nih.nci.mageom.domain.bioassay.BioAssay;
import gov.nih.nci.mageom.domain.bioassay.BioDataCube;
import gov.nih.nci.mageom.domain.bioassay.BioDataValues;
import gov.nih.nci.mageom.domain.bioassay.DerivedBioAssay;
import gov.nih.nci.mageom.domain.bioassay.DerivedBioAssayData;

import org.bioconductor.packages.caAffy.*;
import org.bioconductor.packages.caAffy.util.MageMapper;
import org.ginkgo.labs.reader.TabFileReader;

import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class RWorkerDataTest {

	private static MockService binding = null;
	private static MageMapper mapper = new MageMapper();
	private String filename = getClass().getResource("Data/affybatch-example.data").getFile();
	static edu.columbia.geworkbench.cagrid.MageBioAssayGenerator mageBioAssayGenerator = null;

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
		mageBioAssayGenerator = new edu.columbia.geworkbench.cagrid.MageBioAssayGeneratorImpl();
	}

	private BioAssay[] readBioAssays() throws FileNotFoundException {
		float[][] fdata = TabFileReader.readTabFile(new FileInputStream(filename));

		String[] rowNames = new String[fdata.length];
		for (int j = 0; j < rowNames.length; j++) {
			rowNames[j] = String.valueOf(j);
		}

		String[] colNames = new String[fdata[0].length];
		for (int j = 0; j < colNames.length; j++) {
			int idx = j % 26;
			colNames[j] = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".substring(idx, idx+1);
		}
		return mageBioAssayGenerator.float2DToBioAssayArray(fdata, rowNames, colNames);
	}

	/**
	 * we put this test here to let RWorkerDataTest work right out of box.
	 */
	@Test
	public void testMockServiceService() throws Exception {
		assertNotNull(binding);
	}

	/**
	 * data transfer from R DerivedBioAssays to Java
	 * org.bioconductor.packages.caAffy.DerivedBioAssays
	 */
// 	@Ignore("please initialize data")
	@Test
	public void TestRToDerivedBioAssays() throws Exception {
		BioAssay[] bioAssays = readBioAssays();
		DerivedBioAssay[] dBADs = new DerivedBioAssay[bioAssays.length];
		for (int i=0; i < bioAssays.length; ++i)
			dBADs[i] = (DerivedBioAssay) bioAssays[i];
		DerivedBioAssays outputVal = new DerivedBioAssays(dBADs);
		String rScript = getClass().getResource("R/DerivedBioAssaysData.R").getFile();
		String rVariable = "DerivedBioAssaysData";
		assertEquals(outputVal, binding.mockR2Java(rScript, rVariable));
	}

	/**
	 * data transfer to R DerivedBioAssays from Java
	 * org.bioconductor.packages.caAffy.DerivedBioAssays
	 */
//   	@Ignore("please initialize data")
	@Test
	public void TestDerivedBioAssaysToR() throws Exception {
		BioAssay[] bioAssays = readBioAssays();
		DerivedBioAssay[] dBADs = new DerivedBioAssay[bioAssays.length];
		for (int i=0; i < bioAssays.length; ++i)
			dBADs[i] = (DerivedBioAssay) bioAssays[i];
		DerivedBioAssays inputVal = new DerivedBioAssays(dBADs);
		String rScript = getClass().getResource("R/DerivedBioAssaysData.R").getFile();
		String rVariable = "DerivedBioAssaysData";
		assertTrue(binding.mockJava2R(inputVal, rScript, rVariable));
	}

	/**
	 * data transfer to R ExpressoParameter from Java
	 * org.bioconductor.packages.caAffy.ExpressoParameter
	 */
// 	@Ignore("please initialize data")
	@Test
	public void TestExpressoParameterToR() throws Exception {
		org.bioconductor.packages.caAffy.ExpressoParameter inputVal = null;
		inputVal = new org.bioconductor.packages.caAffy.ExpressoParameter();
		String rScript = getClass().getResource("R/ExpressoParameterData.R").getFile();
		String rVariable = "ExpressoParameterData";
		assertTrue(binding.mockJava2R(inputVal, rScript, rVariable));
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
}
