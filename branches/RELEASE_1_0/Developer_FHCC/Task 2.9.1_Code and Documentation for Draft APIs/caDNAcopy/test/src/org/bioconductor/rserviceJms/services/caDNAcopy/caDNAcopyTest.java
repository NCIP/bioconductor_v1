
package org.bioconductor.rserviceJms.services.caDNAcopy;
import junit.framework.JUnit4TestAdapter;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.*;
import java.rmi.RemoteException;
import java.io.*;


public class caDNAcopyTest {
	private static caDNAcopy myService;

	/**
	 * Used for backward compatibility (IDEs, Ant and JUnit 3.x text runner)
	 */
	public static junit.framework.Test suite() {
		 return new JUnit4TestAdapter(caDNAcopyTest.class);
	}

	/**
	 * Sets up the test fixture; Called before all the tests; Called only once.
	 */
	@BeforeClass
	public static void oneTimeSetUp() throws Exception {
		myService=new caDNAcopy();
	}

	/**
	 * we put this test here to let caDNAcopyTest work right out of box.
	 */
	@Test
	public void testcaDNAcopyService() {
		assertNotNull(myService);
	}

	/**
	 * Tests caDNAcopy.caDNAcopy
	 */
// 	@Ignore("please initialize function parameters")
	@Test
	public void TestCaDNAcopy() throws RemoteException {
		// initialize dnacopyAssays here.
		org.bioconductor.packages.caDNAcopy.DNAcopyAssays caDNAcopy_dnacopyAssays = null;
		try {
		    String jDataFile = getClass().getResource("../../worker/Data/trimmedDNAcopyAssays.data").getFile();
		    FileInputStream fin  = new FileInputStream(jDataFile);
		    ObjectInputStream oin = new ObjectInputStream(fin);
		    caDNAcopy_dnacopyAssays = (org.bioconductor.packages.caDNAcopy.DNAcopyAssays) oin.readObject();
		} catch (Exception ex) {
		    throw new RemoteException(ex.getMessage());
		}

		// initialize dnacopyParameter here.
		org.bioconductor.packages.caDNAcopy.DNAcopyParameter caDNAcopy_dnacopyParameter =
		    new org.bioconductor.packages.caDNAcopy.DNAcopyParameter(new int[] { 123 },
									     new double[] { 0.01 },
									     new int[] { 1000 },
									     new double[] { 0.05 });
		org.bioconductor.packages.caDNAcopy.DerivedDNAcopySegment ans =
		    myService.caDNAcopy(caDNAcopy_dnacopyAssays, caDNAcopy_dnacopyParameter);
		assertEquals(79, ans.getSampleId().length);
		assertEquals(10, ans.getMarkersPerSegment()[4]);
		assertEquals(0.1576, ans.getAverageSegmentValue()[4]);
		double sumMarkers=0., sumSegs=0.;
		for (int i=0;i<ans.getSampleId().length;++i) {
		    sumSegs += ans.getAverageSegmentValue()[i];
		    sumMarkers += ans.getMarkersPerSegment()[i];
		}
		assertEquals(-0.1604, sumSegs, 0.0001);
		assertEquals(4542, sumMarkers, 1.0);
	}
}
