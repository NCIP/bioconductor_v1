
package org.bioconductor.rserviceJms.services.caAffy;
import junit.framework.JUnit4TestAdapter;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.*;
import java.rmi.RemoteException;

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


public class caAffyTest {
	private static caAffy binding;

	private static MageMapper mapper = new MageMapper();
	private String filename = getClass().getResource("../../worker/Data/affybatch-example.data").getFile();
	static edu.columbia.geworkbench.cagrid.MageBioAssayGenerator mageBioAssayGenerator = null;

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
		// initialize bioAssays here.
		org.bioconductor.packages.caAffy.DerivedBioAssays caQAReport_bioAssays = null;
		// caQAReport_bioAssays = new org.bioconductor.packages.caAffy.DerivedBioAssays();

		// initialize cdfName here.
		String[] caQAReport_cdfName = null;
		// caQAReport_cdfName = new String[] {};

		// initialize expected result here.
		org.bioconductor.packages.caAffy.QaReport caQAReport_ans = null;
		// caQAReport_ans = new org.bioconductor.packages.caAffy.QaReport();

		assertEquals(caQAReport_ans, binding.caQAReport(caQAReport_bioAssays, caQAReport_cdfName));
	}

	/**
	 * Tests caAffy.caExpresso
	 */
  	@Ignore("please initialize function parameters")
	@Test
	public void TestCaExpresso() throws RemoteException, Exception {
		BioAssay[] bioAssays = null;
		try {
			bioAssays = readBioAssays();
		} catch (FileNotFoundException ex) {
			throw new Exception(ex.getMessage());
		}
		DerivedBioAssay[] dBADs = new DerivedBioAssay[bioAssays.length];
		for (int i=0; i < bioAssays.length; ++i)
			dBADs[i] = (DerivedBioAssay) bioAssays[i];
		DerivedBioAssays derivedBioAssays = new DerivedBioAssays(dBADs);
		// initialize bioAssays here.
// 		org.bioconductor.packages.caAffy.DerivedBioAssays caExpresso_bioAssays = null;
		// caExpresso_bioAssays = new org.bioconductor.packages.caAffy.DerivedBioAssays();

		// initialize cdfName here.
		String[] caExpresso_cdfName = new String[] {"cdfenv.example"};
		// caExpresso_cdfName = new String[] {};

		// initialize expressoParameter here.
		ExpressoParameter caExpresso_expressoParameter = new ExpressoParameter();
		// caExpresso_expressoParameter = new org.bioconductor.packages.caAffy.ExpressoParameter();

		System.err.println("invoking method");
		// initialize expected result here.
		org.bioconductor.packages.caAffy.DerivedBioAssays caExpresso_ans = null;
		DerivedBioAssays ans = binding.caExpresso(derivedBioAssays,
												  caExpresso_cdfName,
												  caExpresso_expressoParameter);
		System.err.println("method invoked");
		int[] dim = mapper.getDim(ans.getBioAssays());
		assertEquals(150, dim[0]);
		assertEquals(3, dim[1]);

		Object[] dimnames = mapper.getDimnames(ans.getBioAssays());
		assertEquals(((String[]) dimnames[0])[3], "AB000220_at");
		assertEquals(((String[]) dimnames[1])[2], "C");

		double[] exprs = mapper.getExpressionMatrix(ans.getBioAssays());
		int[] expectedSums = new int[]{10637, 8629, 9668};
		for (int j=0; j < dim[1]; ++j) {
			double sums = 0.;
			for (int i=0; i <dim[0]; ++i)
				sums += exprs[j * dim[0] + i];
			assertEquals(expectedSums[j], (int) sums);
		}
	}
}
