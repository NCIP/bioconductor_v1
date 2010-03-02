
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

	private BioAssay[] readBioAssays(String fileName) throws FileNotFoundException {
		fileName = getClass().getResource(fileName).getFile();
		float[][] fdata = TabFileReader.readTabFile(new FileInputStream(fileName));

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

	private boolean checkValues(RJNumericMatrix expected, RJNumericMatrix result) {
		boolean res = true;
		int[] expectedDim = expected.getDim();
		for (int i=0; i<2; ++i) 
			res = res && (expectedDim[i]==result.getDim()[i]);
		if (res) {
			double[]
				expectedValue = expected.getValue(),
				resultValue = result.getValue();
			for (int j=0; res && j < expectedDim[1]; ++j)
				for (int i=0; res && i < expectedDim[0]; ++i)
					res = res &&
						(expectedValue[j*expectedDim[0] + i] == 
						 resultValue[j*expectedDim[0] + i]);
		}
		return res;
	}

	private boolean checkDimnames(RJNumericMatrix expected, RJNumericMatrix result) {
		boolean res = true;
		Object[]
			expectedDimnames = expected.getDimnames(),
			resultDimnames = result.getDimnames();
		for (int i=0; res && i < expectedDimnames.length; ++i) {
			String[]
				expectedDimname = (String[]) expectedDimnames[i],
				resultDimname = (String[]) resultDimnames[i];
			res = res && (expectedDimname.length == resultDimname.length);
			for (int j=0; res && j<expectedDimname.length; ++j)
				res = res &&
					expectedDimname[j].equals(resultDimname[j]);
		}
		return res;
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
 	@Ignore("please initialize data")
	@Test
	public void TestRToDerivedBioAssays() throws Exception {
	    BioAssay[] bioAssays = readBioAssays("Data/affybatch-example.data");
	    DerivedBioAssay[] dBADs = new DerivedBioAssay[bioAssays.length];
		for (int i=0; i < bioAssays.length; ++i)
			dBADs[i] = (DerivedBioAssay) bioAssays[i];
		DerivedBioAssays outputVal = new DerivedBioAssays(dBADs);
		String rScript = getClass().getResource("R/DerivedBioAssaysData.R").getFile();
		String rVariable = "DerivedBioAssaysData";
		assertEquals(outputVal, binding.mockR2Java(rScript, rVariable));
	}

	/**
	 * 'Dilution' data transfer from R DerivedBioAssays to Java
	 * org.bioconductor.packages.caAffy.DerivedBioAssays
	 */
 	@Ignore
	@Test
	public void TestRToDerivedBioAssays_Dilution() throws Exception {
		BioAssay[] bioAssays = readBioAssays("Data/Dilution.data");
		DerivedBioAssay[] dBADs = new DerivedBioAssay[bioAssays.length];
		for (int i=0; i < bioAssays.length; ++i)
			dBADs[i] = (DerivedBioAssay) bioAssays[i];
		DerivedBioAssays expectedVal = new DerivedBioAssays(dBADs);

		String rScript = getClass().getResource("R/Dilution.R").getFile();
		String rVariable = "derivedBioAssays_Dilution";
		DerivedBioAssays resultVal =
			(DerivedBioAssays) binding.mockR2Java(rScript, rVariable);
		RJNumericMatrix
			expected = expectedVal.rgetBioAssays(),
			result = resultVal.rgetBioAssays();
		assertTrue(checkValues(expected, result));
	}

	/**
	 * data transfer to R DerivedBioAssays from Java
	 * org.bioconductor.packages.caAffy.DerivedBioAssays
	 */
   	@Ignore("please initialize data")
	@Test
	public void TestDerivedBioAssaysToR() throws Exception {
		BioAssay[] bioAssays = readBioAssays("Data/affybatch-example.data");
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
// 	@Ignore("please initialize data")
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
