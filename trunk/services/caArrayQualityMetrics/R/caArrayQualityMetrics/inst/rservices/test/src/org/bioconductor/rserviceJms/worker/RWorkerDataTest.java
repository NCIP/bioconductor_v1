
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

    private static final String[] DEFAULT_INPUT_TYPES = { "CEL", "CEL", "CEL" };
    private static final String[] DEFAULT_INPUT_URLS = { "file:///path/infile1", "file:///path/infile2", "file:///path/infile3" };
    private static final String[] DEFAULT_INPUT_LOCALNAMES = { "infile1", "infile2", "infile3" };

    private static final String[] DEFAULT_OUTPUT_TYPES = { "ZIP" };
    private static final String[] DEFAULT_OUTPUT_URLS = { "file:///path/outfile" };
    private static final String[] DEFAULT_OUTPUT_LOCALNAMES = { "outfile" };

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
	 * Data transfer to R RJFileReferences from Java
	 * org.bioconductor.packages.rservices.RJFileReferences
	 */
	//@Ignore("please initialize data")
	@Test
	public void TestRJFileReferencesToR() throws Exception {

        String[] types = DEFAULT_INPUT_TYPES;
        String[] urls  = DEFAULT_INPUT_URLS;
        String[] localNames = DEFAULT_INPUT_LOCALNAMES;

        org.bioconductor.packages.rservices.RJFileReferences inputVal = null;
		inputVal = new org.bioconductor.packages.rservices.RJFileReferences(urls, localNames, types);
		String rScript = getClass().getResource("R/InputFileReferencesData.R").getFile();
		String rVariable = "inputFileReferencesData";
		assertTrue(binding.mockJava2R(inputVal, rScript, rVariable));
	}

	/**
	 * Data transfer from R FileReferences to Java
	 * org.bioconductor.packages.rservices.RJFileReferences
	 */
	//Ignore("please initialize data")
	@Test
	public void TestRToRJFileReferences() throws Exception {
		
        String[] types = DEFAULT_OUTPUT_TYPES;
        String[] urls  = DEFAULT_OUTPUT_URLS;
        String[] localNames = DEFAULT_OUTPUT_LOCALNAMES;

        org.bioconductor.packages.rservices.RJFileReferences outputVal = null;
		outputVal = new org.bioconductor.packages.rservices.RJFileReferences(urls, localNames, types);
		String rScript = getClass().getResource("R/OutputFileReferencesData.R").getFile();
		String rVariable = "outputFileReferencesData";
		assertEquals(outputVal, binding.mockR2Java(rScript, rVariable));
	}
}
