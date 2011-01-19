package org.bioconductor.rserviceJms.worker;
import junit.framework.JUnit4TestAdapter;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.*;
import java.rmi.RemoteException;
import org.bioconductor.packages.rservices.*;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

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
	 * data transfer from R DerivedDNAcopySegment to Java
	 * org.bioconductor.packages.caDNAcopy.DerivedDNAcopySegment
	 */
// 	@Ignore("please initialize data")
	@Test
	public void TestRToDerivedDNAcopySegment() throws Exception {
		org.bioconductor.packages.caDNAcopy.DerivedDNAcopySegment outputVal = null;
		outputVal = new org.bioconductor.packages.caDNAcopy.DerivedDNAcopySegment();
		String rScript = getClass().getResource("R/DerivedDNAcopySegmentData.R").getFile();
		String rVariable = "DerivedDNAcopySegmentData";
		assertEquals(outputVal, myService.mockR2Java(rScript, rVariable));
	}

	/**
	 * data transfer to R DNAcopyAssays from Java
	 * org.bioconductor.packages.caDNAcopy.DNAcopyAssays
	 */
// 	@Ignore("please initialize data")
	@Test
	public void TestDNAcopyAssaysToR() throws Exception {
		org.bioconductor.packages.caDNAcopy.DNAcopyAssays inputVal = null;

		try {
		    String jDataFile = getClass().getResource("Data/trimmedDNAcopyAssays.data").getFile();
		    FileInputStream fin  = new FileInputStream(jDataFile);
		    ObjectInputStream oin = new ObjectInputStream(fin);
		    inputVal = (org.bioconductor.packages.caDNAcopy.DNAcopyAssays) oin.readObject();
		} catch (Exception ex) {
		    throw (RemoteException) ex;
		}
		String rScript = getClass().getResource("R/DNAcopyAssaysData.R").getFile();
		String rVariable = "DNAcopyAssaysData";
		assertTrue(myService.mockJava2R(inputVal, rScript, rVariable));
	}

	/**
	 * data transfer to R DNAcopyParameter from Java
	 * org.bioconductor.packages.caDNAcopy.DNAcopyParameter
	 */
// 	@Ignore("please initialize data")
	@Test
	public void TestDNAcopyParameterToR() throws Exception {
		org.bioconductor.packages.caDNAcopy.DNAcopyParameter inputVal = null;
		inputVal = new
		    org.bioconductor.packages.caDNAcopy.DNAcopyParameter(new int[] { 123 },
									 new double[] { 0.01 },
									 new int[] { 1000 },
									 new double[] { 0.05 });
		String rScript = getClass().getResource("R/DNAcopyParameterData.R").getFile();
		String rVariable = "DNAcopyParameterData";
		assertTrue(myService.mockJava2R(inputVal, rScript, rVariable));
	}
}
