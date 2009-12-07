
package org.bioconductor.rserviceJms.services.caGeneFilter;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FilenameFilter;
import junit.framework.JUnit4TestAdapter;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.rmi.RemoteException;

import java.util.ArrayList;
import java.util.Properties;
import org.omegahat.R.Java.RException;
import org.omegahat.R.Java.ROmegahatInterpreter;

public class caGeneFilterTest {
	private static caGeneFilter binding;

	/**
	 * Used for backward compatibility (IDEs, Ant and JUnit 3.x text runner)
	 */
	public static junit.framework.Test suite() {
		 return new JUnit4TestAdapter(caGeneFilterTest.class);
	}

	/**
	 * Sets up the test fixture; Called before all the tests; Called only once.
	 */
	@BeforeClass
	public static void oneTimeSetUp() throws Exception {
		binding=new caGeneFilter();
	}

	/**
	 * We put this test here to let caGeneFilterTest work right out of box.
	 */
	@Test
	public void testcaGeneFilterService() {
		assertNotNull(binding);
	}

	/**
	 * Tests caGeneFilter.caGeneFilter
	 */
	//@Ignore("please initialize function parameters")
	@Test
	public void TestCaGeneFilter() throws RemoteException {
    }

    /**
     * Executes test using a KOverAFilter.
     */
    //@Ignore("please initialize function parameters")
    @Test
    public void KOverAFilterTest() throws RemoteException {

        // Read serialized data for testing.
        InputStream inputStream = null;
        ObjectInput objectInput = null;
        org.bioconductor.packages.rservices.RJNumericMatrix dataValues = null;
        try {
            inputStream = this.getClass().getResourceAsStream("../../worker/Data/numericMatrixSample.rda_java.Data.1237477611898");
            objectInput = new ObjectInputStream (new BufferedInputStream( inputStream ));
            dataValues = (org.bioconductor.packages.rservices.RJNumericMatrix)objectInput.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
          try {
            if (objectInput != null) objectInput.close();
          } catch (IOException ioex) {
            ioex.printStackTrace();
          }
        }

        // Initialize the filter.
        double[] minimumValue = {200.0d};
        int[] minimumElementNumber = {5};

	org.bioconductor.packages.caGeneFilter.KOverAFilter filter =
                new org.bioconductor.packages.caGeneFilter.KOverAFilter(minimumValue, minimumElementNumber);

        // Execute the test.
        org.bioconductor.packages.rservices.RJNumericMatrix filteredDataValues =
                binding.caGeneFilter( dataValues,
                                      filter      );

        // Check that the dimensions of the filtered RJNumericMatrix
        // are what they should be.
        int[] dims = filteredDataValues.getDim();
        assertTrue( dims[0] == 159 && dims[1] == 26 );
    }

    /**
     * Executes test using a VarianceFilter.
     */
    //@Ignore("please initialize function parameters")
    @Test
    public void VarianceFilterTest() throws RemoteException {

        // Read serialized data for testing.
        InputStream inputStream = null;
        ObjectInput objectInput = null;
        org.bioconductor.packages.rservices.RJNumericMatrix dataValues = null;
        try {
            inputStream = this.getClass().getResourceAsStream("../../worker/Data/numericMatrixSample.rda_java.Data.1237477611898");
            objectInput = new ObjectInputStream (new BufferedInputStream( inputStream ));
            dataValues = (org.bioconductor.packages.rservices.RJNumericMatrix)objectInput.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
          try {
            if (objectInput != null) objectInput.close();
          } catch (IOException ioex) {
              ioex.printStackTrace();
          }
        }

        // Initialize the filter.
        double[] minimumVariance = {100.0d};

        org.bioconductor.packages.caGeneFilter.VarianceFilter filter =
                new org.bioconductor.packages.caGeneFilter.VarianceFilter(minimumVariance);

        // Execute the test.
        org.bioconductor.packages.rservices.RJNumericMatrix filteredDataValues =
                binding.caGeneFilter( dataValues,
                                      filter      );

        // Check that the dimensions of the filtered RJNumericMatrix
        // are what they should be.
        int[] dims = filteredDataValues.getDim();
        assertTrue( dims[0] == 462 && dims[1] == 26 );
    }

    /**
     * Executes test using a GeneOntologyFilter.
     */
    //@Ignore("please initialize function parameters")
    @Test
    public void GeneOntologyFilterTest() throws RemoteException {

        // Read serialized data for testing.
        InputStream inputStream = null;
        ObjectInput objectInput = null;
        org.bioconductor.packages.rservices.RJNumericMatrix dataValues = null;
        try {
            inputStream = this.getClass().getResourceAsStream("../../worker/Data/numericMatrixSample.rda_java.Data.1237477611898");
            objectInput = new ObjectInputStream (new BufferedInputStream( inputStream ));
            dataValues = (org.bioconductor.packages.rservices.RJNumericMatrix)objectInput.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
          try {
            if (objectInput != null) objectInput.close();
          } catch (IOException ioex) {
              ioex.printStackTrace();
          }
        }

        // Initialize the filter.
        String[] annotation = {"hgu95av2"};
        boolean[] isBiologicalProcess   = {true};
        boolean[] isCellularCompartment = {true};
        boolean[] isMolecularFunction   = {true};

	org.bioconductor.packages.caGeneFilter.GeneOntologyFilter filter =
                new org.bioconductor.packages.caGeneFilter.GeneOntologyFilter(
                            isBiologicalProcess, isCellularCompartment, isMolecularFunction, annotation);

        // Execute the test.
        org.bioconductor.packages.rservices.RJNumericMatrix filteredDataValues =
                binding.caGeneFilter( dataValues,
                                      filter      );

        // Check that the dimensions of the filtered RJNumericMatrix
        // are what they should be.
        // NOTE: if run, the following fails on nearly every update of the annotation.
        //int[] dims = filteredDataValues.getDim();
        //assertTrue( dims[0] == 281 && dims[1] == 26 );
    }

    /**
     * Executes test using an EntrezFilter.
     */
    //@Ignore("please initialize function parameters")
    @Test
    public void EntrezFilterTest() throws RemoteException {

        // Read serialized data for testing.
        InputStream inputStream = null;
        ObjectInput objectInput = null;
        org.bioconductor.packages.rservices.RJNumericMatrix dataValues = null;
        try {
            inputStream = this.getClass().getResourceAsStream("../../worker/Data/numericMatrixSample.rda_java.Data.1237477611898");
            objectInput = new ObjectInputStream (new BufferedInputStream( inputStream ));
            dataValues = (org.bioconductor.packages.rservices.RJNumericMatrix)objectInput.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
          try {
            if (objectInput != null) objectInput.close();
          } catch (IOException ioex) {
              ioex.printStackTrace();
          }
        }

        // Initialize the filter.
        String[] annotation = {"hgu95av2"};

        org.bioconductor.packages.caGeneFilter.EntrezFilter filter =
                new org.bioconductor.packages.caGeneFilter.EntrezFilter(annotation);

        // Execute the test.
        org.bioconductor.packages.rservices.RJNumericMatrix filteredDataValues =
                binding.caGeneFilter( dataValues,
                                      filter      );

        // Check that the dimensions of the filtered RJNumericMatrix
        // are what they should be.
        // NOTE: if run, the following test fails on nearly every update of the annotation.
        //int[] dims = filteredDataValues.getDim();
        //assertTrue( dims[0] == 372 && dims[1] == 26 );
    }

    /**
     * Executes test using a MissingValueFilter.
     */
    //@Ignore("please initialize function parameters")
    @Test
    public void MissingValueFilterTest() throws RemoteException {

        // Read serialized data for testing.
        InputStream inputStream = null;
        ObjectInput objectInput = null;
        org.bioconductor.packages.rservices.RJNumericMatrix dataValues = null;
        try {
            inputStream = this.getClass().getResourceAsStream("../../worker/Data/numericMatrixSample.rda_java.Data.1237477611898");
            objectInput = new ObjectInputStream (new BufferedInputStream( inputStream ));
            dataValues = (org.bioconductor.packages.rservices.RJNumericMatrix)objectInput.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
          try {
            if (objectInput != null) objectInput.close();
          } catch (IOException ioex) {
              ioex.printStackTrace();
          }
        }

        // Introduce a missing value, coded as -Infinity, to dataValues.
        int[] dim = dataValues.getDim();
        double[] values = dataValues.getValue();
        values[ (dim[0]*dim[1])-1 ] = Double.NEGATIVE_INFINITY;

        // Initialize the filter.
        double missingValue[] = {Double.NEGATIVE_INFINITY};
        int[] minimumElementNumber = {26};

	org.bioconductor.packages.caGeneFilter.MissingValueFilter filter =
                new org.bioconductor.packages.caGeneFilter.MissingValueFilter(missingValue, minimumElementNumber);

        // Execute the test.
        org.bioconductor.packages.rservices.RJNumericMatrix filteredDataValues =
                binding.caGeneFilter( dataValues,
                                      filter      );

        // Check that the dimensions of the filtered RJNumericMatrix
        // are what they should be.
        int[] dims = filteredDataValues.getDim();
        assertTrue( dims[0] == 499 && dims[1] == 26 );
    }

    /**
     * Executes test using a MinimumThresholdRecode.
     */
    //@Ignore("please initialize function parameters")
    @Test
    public void MinimumThresholdRecodeTest() throws RemoteException {

        // Read serialized data for testing.
        InputStream inputStream = null;
        ObjectInput objectInput = null;
        org.bioconductor.packages.rservices.RJNumericMatrix dataValues = null;
        try {
            inputStream = this.getClass().getResourceAsStream("../../worker/Data/numericMatrixSample.rda_java.Data.1237477611898");
            objectInput = new ObjectInputStream (new BufferedInputStream( inputStream ));
            dataValues = (org.bioconductor.packages.rservices.RJNumericMatrix)objectInput.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
          try {
            if (objectInput != null) objectInput.close();
          } catch (IOException ioex) {
              ioex.printStackTrace();
          }
        }

        // Initialize the recode.
        double[] minimumThreshold            = {-8000.0d};
        double[] minimumThresholdRecodeValue = {-8000.0d};

	org.bioconductor.packages.caGeneFilter.MinimumThresholdRecode recode =
            new org.bioconductor.packages.caGeneFilter.MinimumThresholdRecode(minimumThreshold, minimumThresholdRecodeValue);

        // Execute the test.
        org.bioconductor.packages.rservices.RJNumericMatrix recodedDataValues =
                binding.caGeneRecode( dataValues,
                                      recode      );
    }

    /**
     * Executes test using a MaximumThresholdRecode.
     */
    //@Ignore("please initialize function parameters")
    @Test
    public void MaximumThresholdRecodeTest() throws RemoteException {

        // Read serialized data for testing.
        InputStream inputStream = null;
        ObjectInput objectInput = null;
        org.bioconductor.packages.rservices.RJNumericMatrix dataValues = null;
        try {
            inputStream = this.getClass().getResourceAsStream("../../worker/Data/numericMatrixSample.rda_java.Data.1237477611898");
            objectInput = new ObjectInputStream (new BufferedInputStream( inputStream ));
            dataValues = (org.bioconductor.packages.rservices.RJNumericMatrix)objectInput.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
          try {
            if (objectInput != null) objectInput.close();
          } catch (IOException ioex) {
              ioex.printStackTrace();
          }
        }

        // Initialize the recode.
        double[] maximumThreshold            = {10000.0d};
        double[] maximumThresholdRecodeValue = {10000.0d};

	org.bioconductor.packages.caGeneFilter.MaximumThresholdRecode recode =
            new org.bioconductor.packages.caGeneFilter.MaximumThresholdRecode(maximumThreshold, maximumThresholdRecodeValue);

        // Execute the test.
        org.bioconductor.packages.rservices.RJNumericMatrix recodedDataValues =
                binding.caGeneRecode( dataValues,
                                      recode      );
    }

    /**
     * Executes test using a SpotQualityRecode and GPR files.
     */
    @Test
    public void SpotQualityRecodeTest() throws RemoteException {

        // Initialize parameters to be supplied to an instance
        // of RJFileReferences.
        String[] types      = {};
        String[] urls       = {};
        String[] localNames = {};

        // Initialize SpotQualityRecode parameters.
        String[] columnIdentifier = {"Flags"};
        double[] columnMinimumThresholdValue = {-25.0d};
        double[] recodeValue = {Double.NEGATIVE_INFINITY};

        try {
            // Construct the path of the directory holding the GPR data files.
            Properties prop = new Properties();
            InputStream inputStream =
                    this.getClass().getResourceAsStream("Data/caGeneFilterTest.properties");
            prop.load(inputStream);
            String caServicesTestData_dir = prop.getProperty("caServicesTestData_dir");

            String relpath = "/extdata/caGeneFilter/GPR";
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
            System.err.println("Exception initializing file names in caGeneFilterTest.SpotQualityRecodeTest");
        }

        org.bioconductor.packages.rservices.RJFileReferences caGeneFilter_fileReferences = null;
        try {
            caGeneFilter_fileReferences =
                    new org.bioconductor.packages.rservices.RJFileReferences(urls, localNames, types);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

	// Initialize parameters.
	org.bioconductor.packages.caGeneFilter.SpotQualityRecode recode =
              new org.bioconductor.packages.caGeneFilter.SpotQualityRecode(columnIdentifier,
                     columnMinimumThresholdValue, recodeValue);

        // Execute the test.
        java.lang.Object[] caGeneFilter_rList =
                binding.caFileGeneRecode( caGeneFilter_fileReferences,
                                          recode );
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

}
