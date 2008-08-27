
package org.bioconductor.rserviceJms.worker;
import junit.framework.JUnit4TestAdapter;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.*;
import java.rmi.RemoteException;
import org.bioconductor.packages.rservices.*;

import java.io.*;

public class RWorkerDataTest {
	private static MockService myService;

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
		myService=new MockService(e);
	}

	/**
	 * we put this test here to let RWorkerDataTest work right out of box.
	 */
	@Test
	public void testMockServiceService() {
		assertNotNull(myService);
	}

	/**
	 * data transfer to R MzAssays from Java
	 * org.bioconductor.packages.caPROcess.MzAssays
	 */
// 	@Ignore("please initialize data")
	@Test
	public void TestMzAssaysToR() throws Exception {
		org.bioconductor.packages.caPROcess.MzAssays inputVal = null;
		try {
		    String jDataFile = getClass().getResource("Data/mzAssays.data").getFile();
		    FileInputStream fin  = new FileInputStream(jDataFile);
		    ObjectInputStream oin = new ObjectInputStream(fin);
		    inputVal = (org.bioconductor.packages.caPROcess.MzAssays) oin.readObject();
		} catch (Exception ex) {
		    throw (RemoteException) ex;
		}
		String rScript = getClass().getResource("R/MzAssaysData.R").getFile();
		String rVariable = "MzAssaysData";
		assertTrue(myService.mockJava2R(inputVal, rScript, rVariable));
	}

	/**
	 * data transfer to R MzSpectrum from Java
	 * org.bioconductor.packages.caPROcess.MzSpectrum
	 */
	@Ignore("please initialize data")
	@Test
	public void TestMzSpectrumToR() throws Exception {
		org.bioconductor.packages.caPROcess.MzSpectrum inputVal = null;
		inputVal = new org.bioconductor.packages.caPROcess.MzSpectrum();
		String rScript = getClass().getResource("R/MzSpectrumData.R").getFile();
		String rVariable = "MzSpectrumData";
		assertTrue(myService.mockJava2R(inputVal, rScript, rVariable));
	}

	/**
	 * data transfer from R PeakLocation to Java
	 * org.bioconductor.packages.caPROcess.PeakLocation
	 */
	@Ignore("please initialize data")
	@Test
	public void TestRToPeakLocation() throws Exception {
		org.bioconductor.packages.caPROcess.PeakLocation outputVal = null;
		outputVal = new org.bioconductor.packages.caPROcess.PeakLocation();
		String rScript = getClass().getResource("R/PeakLocationData.R").getFile();
		String rVariable = "PeakLocationData";
		assertEquals(outputVal, myService.mockR2Java(rScript, rVariable));
	}

	/**
	 * data transfer to R PROcessParameter from Java
	 * org.bioconductor.packages.caPROcess.PROcessParameter
	 */
// 	@Ignore("please initialize data")
	@Test
	public void TestPROcessParameterToR() throws Exception {
		org.bioconductor.packages.caPROcess.PROcessParameter inputVal = new
		    org.bioconductor.packages.caPROcess.PROcessParameter(new double[] { 1500. },
									 new double[] {},
									 new double[] {},
									 new double[] {},
									 new double[] {},
									 new double[] {},
									 new double[] {});
		String rScript = getClass().getResource("R/PROcessParameterData.R").getFile();
		String rVariable = "PROcessParameterData";
		assertTrue(myService.mockJava2R(inputVal, rScript, rVariable));
	}
}
