
package org.bioconductor.rserviceJms.services.caArrayQualityMetrics;

import junit.framework.JUnit4TestAdapter;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.*;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Properties;

public class caArrayQualityMetricsTest {
    
    private static caArrayQualityMetrics binding;

    /**
     * Used for backward compatibility (IDEs, Ant and JUnit 3.x text runner)
     */
    public static junit.framework.Test suite() {
        return new JUnit4TestAdapter(caArrayQualityMetricsTest.class);
    }

    /**
     * Sets up the test fixture; Called before all the tests; Called only once.
     */
    @BeforeClass
    public static void oneTimeSetUp() throws Exception {
        binding=new caArrayQualityMetrics();
    }

    /**
     * We put this test here to let caArrayQualityMetricsTest work right out of box.
     */
    @Test
    public void testcaArrayQualityMetricsService() {
        assertNotNull(binding);
    }

    /**
     * Tests caArrayQualityMetrics.caArrayQualityMetrics
     */
    //@Ignore("please initialize function parameters")
    @Test
    public void TestCaArrayQualityMetrics() throws RemoteException {
    }

    /**
     * Executes test with CEL data files.
     */
    @Test
    public void CELTest() throws RemoteException {

        // Initialize parameters to be supplied to an instance
        // of RJFileReferences.
        String[] types      = {};
        String[] urls       = {};
        String[] localNames = {};

        try {
            // Construct the path of the directory holding the CEL data files.
            Properties prop = new Properties();
            InputStream inputStream =
                    this.getClass().getResourceAsStream("Data/caArrayQualityMetricsTest.properties");
            prop.load(inputStream);
            String caServicesTestData_dir = prop.getProperty("caServicesTestData_dir");

            String relpath = "/extdata/caArrayQualityMetrics/CEL";
            String dirpath = caServicesTestData_dir + relpath;
            File dir = new File(dirpath);

            // The CEL file names
            localNames = dir.list(new CELFileFilter());

            // Build the urls to the CEL files.
            ArrayList<String> paths      = new ArrayList<String>();
            ArrayList<String> types_list = new ArrayList<String>();
            for(String fn: localNames) {
                paths.add( new String("file://" + dir.getPath() + File.separator + fn) );
                types_list.add("CEL");
            }
            urls  = paths.toArray(urls);
            types = types_list.toArray(types);
        } catch (Exception ex) {
            System.err.println("Exception initializing file names in caArrayQualityMetricsTest.CELTest");
        }

        org.bioconductor.packages.rservices.RJFileReferences caArrayQualityMetrics_inputRJFileReferences = null;
        try {
            caArrayQualityMetrics_inputRJFileReferences =
                    new org.bioconductor.packages.rservices.RJFileReferences(urls, localNames, types);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // Execute the test.
        org.bioconductor.packages.rservices.RJFileReferences caArrayQualityMetrics_outputRJFileReferences =
                binding.caArrayQualityMetrics( caArrayQualityMetrics_inputRJFileReferences );
    }

    /**
     * Executes test with GPR data files.
     */
    @Test
    public void GPRTest() throws RemoteException {

        // Initialize parameters to be supplied to an instance
        // of RJFileReferences.
        String[] types      = {};
        String[] urls       = {};
        String[] localNames = {};

        try {
            // Construct the path of the directory holding the GPR data files.
            Properties prop = new Properties();
            InputStream inputStream =
                    this.getClass().getResourceAsStream("Data/caArrayQualityMetricsTest.properties");
            prop.load(inputStream);
            String caServicesTestData_dir = prop.getProperty("caServicesTestData_dir");

            String relpath = "/extdata/caArrayQualityMetrics/GPR";
            String dirpath = caServicesTestData_dir + relpath;
            File dir = new File(dirpath);

            // The GPR file names
            localNames = dir.list(new GPRFileFilter());

            // Build the unqualified paths to the GPR files.
            ArrayList<String> paths      = new ArrayList<String>();
            ArrayList<String> types_list = new ArrayList<String>();
            for(String fn: localNames) {
                paths.add( new String("file://" + dir.getPath() + File.separator + fn) );
                types_list.add("GPR");
            }
            urls  = paths.toArray(urls);
            types = types_list.toArray(types);
        } catch (Exception ex) {
            System.err.println("Exception initializing file names in caArrayQualityMetricsTest.GPRTest");
        }

        org.bioconductor.packages.rservices.RJFileReferences caArrayQualityMetrics_inputRJFileReferences = null;
        try {
            caArrayQualityMetrics_inputRJFileReferences =
                    new org.bioconductor.packages.rservices.RJFileReferences(urls, localNames, types);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // Execute the test.
        org.bioconductor.packages.rservices.RJFileReferences caArrayQualityMetrics_outputRJFileReferences =
                binding.caArrayQualityMetrics( caArrayQualityMetrics_inputRJFileReferences );
    }

    /**
     * Executes test with Agilent data files.
     */
    @Test
    public void AGILENTTest() throws RemoteException {

        // Initialize parameters to be supplied to an instance
        // of RJFileReferences.
        String[] types      = {};
        String[] urls       = {};
        String[] localNames = {};

        try {
            // Construct the path of the directory holding the CEL data files.
            Properties prop = new Properties();
            InputStream inputStream =
                    this.getClass().getResourceAsStream("Data/caArrayQualityMetricsTest.properties");
            prop.load(inputStream);
            String caServicesTestData_dir = prop.getProperty("caServicesTestData_dir");

            String relpath = "/extdata/caArrayQualityMetrics/AGILENT";
            String dirpath = caServicesTestData_dir + relpath;
            File dir = new File(dirpath);

            // The AGILENT file names
            localNames = dir.list(new AGILENTFileFilter());

            // Build the unqualified paths to the AGILENT files.
            ArrayList<String> paths      = new ArrayList<String>();
            ArrayList<String> types_list = new ArrayList<String>();
            for(String fn: localNames) {
                paths.add( new String("file://" + dir.getPath() + File.separator + fn) );
                types_list.add("AGILENT");
            }
            urls  = paths.toArray(urls);
            types = types_list.toArray(types);
        } catch (Exception ex) {
            System.err.println("Exception initializing file names in caArrayQualityMetricsTest.AGILENTTest");
        }

        org.bioconductor.packages.rservices.RJFileReferences caArrayQualityMetrics_inputRJFileReferences = null;
        try {
            caArrayQualityMetrics_inputRJFileReferences =
                    new org.bioconductor.packages.rservices.RJFileReferences(urls, localNames, types);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // Execute the test.
        org.bioconductor.packages.rservices.RJFileReferences caArrayQualityMetrics_outputRJFileReferences =
                binding.caArrayQualityMetrics( caArrayQualityMetrics_inputRJFileReferences );
    }

    /**
     * A FilenameFilter for files with ".cel" or ".CEL" extension.
     */
    private class CELFileFilter implements FilenameFilter {
        public boolean accept(File file, String filename) {
            boolean res = filename.endsWith(".cel") || filename.endsWith(".CEL");
            return res;
        }
    }

    /**
     * A FilenameFilter for files with ".gpr" or ".GPR" extension.
     */
    private class GPRFileFilter implements FilenameFilter {
        public boolean accept(File file, String filename) {
            boolean res = filename.endsWith(".gpr") || filename.endsWith(".GPR");
            return res;
        }
    }

    /**
     * A FilenameFilter for files with ".txt" extension.
     */
    private class AGILENTFileFilter implements FilenameFilter {
        public boolean accept(File file, String filename) {
            boolean res = filename.endsWith(".txt");
            return res;
        }
    }
}
