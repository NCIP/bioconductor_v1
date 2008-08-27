
package org.bioconductor.rserviceJms.services.caPROcess;
import junit.framework.JUnit4TestAdapter;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.*;
import java.rmi.RemoteException;

import java.io.*;

public class caPROcessTest {
	private static caPROcess myService;

	/**
	 * Used for backward compatibility (IDEs, Ant and JUnit 3.x text runner)
	 */
	public static junit.framework.Test suite() {
		 return new JUnit4TestAdapter(caPROcessTest.class);
	}

	/**
	 * Sets up the test fixture; Called before all the tests; Called only once.
	 */
	@BeforeClass
	public static void oneTimeSetUp() throws Exception {
		myService=new caPROcess();
	}

	/**
	 * we put this test here to let caPROcessTest work right out of box.
	 */
	@Test
	public void testcaPROcessService() {
		assertNotNull(myService);
	}

	/**
	 * Tests caPROcess.caPROcess
	 */
// 	@Ignore("please initialize function parameters")
	@Test
	public void TestCaPROcess() throws RemoteException {
		// initialize mzAssays here.
		org.bioconductor.packages.caPROcess.MzAssays caPROcess_mzAssays = null;
		try {
		    String jDataFile = getClass().getResource("../../worker/Data/mzAssays.data").getFile();
		    FileInputStream fin  = new FileInputStream(jDataFile);
		    ObjectInputStream oin = new ObjectInputStream(fin);
		    caPROcess_mzAssays = (org.bioconductor.packages.caPROcess.MzAssays) oin.readObject();
		} catch (Exception ex) {
		    throw (RemoteException) ex;
		}

		// initialize proCessParameter here.
		org.bioconductor.packages.caPROcess.PROcessParameter caPROcess_proCessParameter = new
		    org.bioconductor.packages.caPROcess.PROcessParameter(new double[] { 1500. },
									 new double[] {},
									 new double[] {},
									 new double[] {},
									 new double[] {},
									 new double[] {},
									 new double[] {});
		// initialize expected result here.
		org.bioconductor.packages.caPROcess.PeakLocation ans =
		    myService.caPROcess(caPROcess_mzAssays, caPROcess_proCessParameter);

		assertEquals(20, ans.getSpectrumName().length);
		assertEquals(20, ans.getPeakNumberInSpectrum().length);
		assertEquals(3066.80, ans.getSubstanceMassAtIntensity()[4]);
	}
}
