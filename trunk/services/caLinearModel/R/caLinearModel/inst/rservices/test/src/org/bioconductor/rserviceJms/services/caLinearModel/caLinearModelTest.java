
package org.bioconductor.rserviceJms.services.caLinearModel;

import java.io.BufferedInputStream;
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

import org.omegahat.R.Java.RException;
import org.omegahat.R.Java.ROmegahatInterpreter;

import org.bioconductor.packages.caCommonClasses.*;
import org.bioconductor.packages.caLinearModel.*;

public class caLinearModelTest {
	private static caLinearModel binding;

	/**
	 * Used for backward compatibility (IDEs, Ant and JUnit 3.x text runner)
	 */
	public static junit.framework.Test suite() {
		 return new JUnit4TestAdapter(caLinearModelTest.class);
	}

	/**
	 * Sets up the test fixture; Called before all the tests; Called only once.
	 */
	@BeforeClass
	public static void oneTimeSetUp() throws Exception {
		binding=new caLinearModel();
	}

	/**
	 * we put this test here to let caLinearModelTest work right out of box.
	 */
	@Test
	public void testcaLinearModelService() {
		assertNotNull(binding);
	}

	/**
	 * Tests caLinearModel.caLinearModel
	 */
	//@Ignore("please initialize function parameters")
	@Test
	public void TestCaLinearModel() throws RemoteException {
    }

    /**
     * Executes test using a TTest Model.
     */
    //@Ignore("please initialize function parameters")
    @Test
    public void TTestTest() throws RemoteException {

        // Initialize the TTest model.
        String[] sampleAnnotationCollectionTestColumnName = {"handedness"};
        int[] numberOfTopReporters = {10};

        TTest model = new TTest(sampleAnnotationCollectionTestColumnName, numberOfTopReporters);

        // Initialize the expressionData.
        OneChannelExpressionData oneChannelExpressionData = this.getOneChannelExpressionData();

        // Initialize the sampleAnnotationCollection.
        SampleAnnotationCollection sampleAnnotationCollection =
                this.getOneChannelSampleAnnotationCollection();

        // Execute the test.

        TopTableCollection topTableCollection =
                binding.fit( model,
                             oneChannelExpressionData,
                             sampleAnnotationCollection );
    }

    /**
     * Executes test using a PairedTTest Model.
     */
    //@Ignore("please initialize function parameters")
    @Test
    public void PairedTTestTest() throws RemoteException {

        // Initialize the PairedTTest model.
        String[] sampleAnnotationCollectionTestColumnName = {"handedness"};
        String[] sampleAnnotationCollectionPairingColumnName = {"pairing"};
        int[] numberOfTopReporters = {10};

        PairedTTest model = new PairedTTest(
                          sampleAnnotationCollectionTestColumnName,
                          sampleAnnotationCollectionPairingColumnName,
                          numberOfTopReporters);

        // Initialize the expressionData.
        OneChannelExpressionData oneChannelExpressionData = this.getOneChannelExpressionData();

        // Initialize the sampleAnnotationCollection.
        SampleAnnotationCollection sampleAnnotationCollection =
                this.getOneChannelSampleAnnotationCollection();

        // Execute the test.
        TopTableCollection topTableCollection =
                binding.fit( model,
                             oneChannelExpressionData,
                             sampleAnnotationCollection );
    }

    /**
     * Executes test using a OneFactorANOVA Model.
     */
    //@Ignore("please initialize function parameters")
    @Test
    public void OneFactorANOVATest() throws RemoteException {

        // Initialize the OneFactorANOVA model.
        String[] sampleAnnotationCollectionTestColumnName = {"ageCohort"};
        int[] numberOfTopReporters = {10};

        OneFactorANOVA model = new OneFactorANOVA(
                sampleAnnotationCollectionTestColumnName, numberOfTopReporters);

        // Initialize the expressionData.
        OneChannelExpressionData oneChannelExpressionData = this.getOneChannelExpressionData();

        // Initialize the sampleAnnotationCollection.
        SampleAnnotationCollection sampleAnnotationCollection =
                this.getOneChannelSampleAnnotationCollection();

        // Execute the test.
        TopTableCollection topTableCollection =
                binding.fit( model,
                             oneChannelExpressionData,
                             sampleAnnotationCollection );
    }

    /**
     * Executes test using a TwoFactorANOVA Model.
     */
    //@Ignore("please initialize function parameters")
    @Test
    public void TwoFactorANOVATest() throws RemoteException {

        // Initialize the TwoFactorANOVA model.
        String[] sampleAnnotationCollectionFactorOneColumnName = {"handedness"};
        String[] sampleAnnotationCollectionFactorTwoColumnName = {"ageCohort"};
        int[] numberOfTopReporters = {10};

        TwoFactorANOVA model =
                new TwoFactorANOVA(
                          sampleAnnotationCollectionFactorOneColumnName,
                          sampleAnnotationCollectionFactorTwoColumnName,
                          numberOfTopReporters);

        // Initialize the expressionData.
        OneChannelExpressionData oneChannelExpressionData =
                this.getOneChannelExpressionData();

        // Initialize the sampleAnnotationCollection.
        SampleAnnotationCollection sampleAnnotationCollection =
                this.getOneChannelSampleAnnotationCollection();

        // Execute the test.
        TopTableCollection topTableCollection =
                binding.fit( model,
                             oneChannelExpressionData,
                             sampleAnnotationCollection );
    }

    /**
     * Executes test using a DyeSwapTTest Model.
     */
    //@Ignore("please initialize function parameters")
    @Test
    public void DyeSwapTTestTest() throws RemoteException {

        // Initialize the DyeSwapTTest model.
        String[] sampleAnnotationCollectionTestColumnName = {"handedness"};
        String[] testReferenceLevel                       = {"R"};
        int[] numberOfTopReporters                        = {10};

		// Initialize.
		DyeSwapTTest model =
			new DyeSwapTTest( sampleAnnotationCollectionTestColumnName,
						      testReferenceLevel,
							  numberOfTopReporters );

        TwoChannelExpressionData twoChannelExpressionData =
                                this.getTwoChannelExpressionData();
        SampleAnnotationCollection sampleAnnotationCollection =
                                this.getTwoChannelSampleAnnotationCollection();

        // Execute test.
        TopTableCollection topTableCollection =
			binding.twoChannelFit( model,
                                   twoChannelExpressionData,
								   sampleAnnotationCollection );
    }

    /**
     * Executes test using a CommonReferenceANOVA Model.
     */
    //@Ignore("please initialize function parameters")
    @Test
    public void CommonReferenceANOVATest() throws RemoteException {

        int nContrasts = 6;
        int nReporters = 10;

        // Initialize the CommonReferenceANOVA model.
        String[] sampleAnnotationCollectionTestColumnName = {"ageCohort"};
        String[] testReferenceLevel                       = {"Mix"};
        int[] numberOfTopReporters                        = {nReporters};

		// Initialize.
		CommonReferenceANOVA model =
			new CommonReferenceANOVA( sampleAnnotationCollectionTestColumnName,
									  testReferenceLevel,
									  numberOfTopReporters );

        TwoChannelExpressionData twoChannelExpressionData =
                                this.getTwoChannelExpressionData();
        SampleAnnotationCollection sampleAnnotationCollection =
                                this.getTwoChannelSampleAnnotationCollection();

        // Execute test
        TopTableCollection topTableCollection =
			binding.twoChannelFit( model,
                                   twoChannelExpressionData,
								   sampleAnnotationCollection );

		// Compare.
		Object[] ttCollection = topTableCollection.getTopTableCollection();
		assertEquals(nContrasts, ttCollection.length);
		for (int i = 0; i < nContrasts; ++i) {
			assertEquals( nReporters,
						  ((TopTable) ttCollection[i]).getReporterName().length );
        }
    }
    
    /**
     * Returns the test OneChannelExpressionData.
     */
    private OneChannelExpressionData getOneChannelExpressionData() {

        InputStream inputStream = null;
        ObjectInput objectInput = null;

        OneChannelExpressionData oneChannelExpressionData = null;
        try {
            inputStream = this.getClass().getResourceAsStream("../../worker/Data/OneChannelTest.oneChannelExpressionData.rda_java.Data");
            objectInput = new ObjectInputStream (new BufferedInputStream( inputStream ));
            oneChannelExpressionData = (OneChannelExpressionData)objectInput.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
          try {
            if (objectInput != null) objectInput.close();
          } catch (IOException ioex) {
            ioex.printStackTrace();
          }
        }

        return oneChannelExpressionData;
    }

    /**
     * Returns the test SampleAnnotationCollection for OneChannelModels.
     */
    private SampleAnnotationCollection getOneChannelSampleAnnotationCollection() {

        InputStream inputStream = null;
        ObjectInput objectInput = null;

        // Initialize the sampleAnnotationCollection.
        SampleAnnotationCollection sampleAnnotationCollection = null;
        try {
            inputStream = this.getClass().getResourceAsStream("../../worker/Data/OneChannelTest.sampleAnnotationCollection.rda_java.Data");
            objectInput = new ObjectInputStream (new BufferedInputStream( inputStream ));
            sampleAnnotationCollection = (SampleAnnotationCollection)objectInput.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
          try {
            if (objectInput != null) objectInput.close();
          } catch (IOException ioex) {
            ioex.printStackTrace();
          }
        }

        return sampleAnnotationCollection;
    }

    /**
     * Returns the test TwoChannelExpressionData.
     */
    private TwoChannelExpressionData getTwoChannelExpressionData() {

        InputStream inputStream = null;
        ObjectInput objectInput = null;

        TwoChannelExpressionData twoChannelExpressionData = null;
        try {
            inputStream = this.getClass().getResourceAsStream("../../worker/Data/TwoChannelTest.twoChannelExpressionData.rda_java.Data");
            objectInput = new ObjectInputStream (new BufferedInputStream( inputStream ));
            twoChannelExpressionData = (TwoChannelExpressionData)objectInput.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
          try {
            if (objectInput != null) objectInput.close();
          } catch (IOException ioex) {
            ioex.printStackTrace();
          }
        }

        return twoChannelExpressionData;
    }

    /**
     * Returns the test SampleAnnotationCollection for TwoChannelModels.
     */
    private SampleAnnotationCollection getTwoChannelSampleAnnotationCollection() {

        InputStream inputStream = null;
        ObjectInput objectInput = null;

        // Initialize the sampleAnnotationCollection.
        SampleAnnotationCollection sampleAnnotationCollection = null;
        try {
            inputStream = this.getClass().getResourceAsStream("../../worker/Data/TwoChannelTest.sampleAnnotationCollection.rda_java.Data");
            objectInput = new ObjectInputStream (new BufferedInputStream( inputStream ));
            sampleAnnotationCollection = (SampleAnnotationCollection)objectInput.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
          try {
            if (objectInput != null) objectInput.close();
          } catch (IOException ioex) {
            ioex.printStackTrace();
          }
        }

        return sampleAnnotationCollection;
    }
}
