
package org.bioconductor.rserviceJms.services.caMachineLearning;

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
import org.bioconductor.packages.caMachineLearning.*;

public class caMachineLearningTest {

    private static caMachineLearning binding;

    /**
     * Used for backward compatibility (IDEs, Ant and JUnit 3.x text runner)
     */
    public static junit.framework.Test suite() {
	return new JUnit4TestAdapter(caMachineLearningTest.class);
    }

    /**
     * Sets up the test fixture; Called before all the tests; Called only once.
     */
    @BeforeClass
    public static void oneTimeSetUp() throws Exception {
        binding=new caMachineLearning();
    }

    /**
     * We put this test here to let caMachineLearningTest work right out of box.
     */
    @Test
    public void testcaMachineLearningService() {
        assertNotNull(binding);
    }

	
    /**
     * Tests caMachineLearning.caMachineLearning
     */
     //@Ignore("please initialize function parameters")
    @Test
    public void TestcaMachineLearning() throws RemoteException {
    }

    /**
     * Tests supervised using a KNearestNeighborsMachineLearningParameters.
     */
    //@Ignore("please initialize function parameters")
    @Test
    public void KNearestNeighborsTest() throws RemoteException {
        
        // Initialize the oneChannelExpressionData.
        OneChannelExpressionData oneChannelExpressionData = 
                this.getOneChannelExpressionData();

        // Read the KNearestNeighborsMachineLearningParameters object with which to test.
        InputStream inputStream = null;
        ObjectInput objectInput = null;
        KNearestNeighborsMachineLearningParameters parameters = null;
        try {
            inputStream = this.getClass().getResourceAsStream("../../worker/Data/KNearestNeighborsMachineLearningParameters.rda_java.Data");
            objectInput = new ObjectInputStream (new BufferedInputStream( inputStream ));
            parameters = (KNearestNeighborsMachineLearningParameters)objectInput.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
          try {
            if (objectInput != null) objectInput.close();
          } catch (IOException ioex) {
            ioex.printStackTrace();
          }
        }

        // Execute the test.
        SupervisedMachineLearningResult knnResult = binding.supervised( oneChannelExpressionData,
                                                                        parameters );
    }

    /**
     * Tests supervised using a SupportVectorMachineMachineLearningParameters.
     */
    //@Ignore("please initialize function parameters")
    @Test
    public void SupportVectorMachineTest() throws RemoteException {

        // Initialize the oneChannelExpressionData.
        OneChannelExpressionData oneChannelExpressionData =
                this.getOneChannelExpressionData();

        // Read the SupportVectorMachineMachineLearningParameters object with which to test.
        InputStream inputStream = null;
        ObjectInput objectInput = null;
        SupportVectorMachineMachineLearningParameters parameters = null;
        try {
            inputStream = this.getClass().getResourceAsStream("../../worker/Data/SupportVectorMachineMachineLearningParameters.rda_java.Data");
            objectInput = new ObjectInputStream (new BufferedInputStream( inputStream ));
            parameters = (SupportVectorMachineMachineLearningParameters)objectInput.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
          try {
            if (objectInput != null) objectInput.close();
          } catch (IOException ioex) {
            ioex.printStackTrace();
          }
        }

        // Execute the test.
        SupervisedMachineLearningResult svmResult = binding.supervised( oneChannelExpressionData,
                                                                        parameters );
    }

    /**
     * Tests supervised using a LinearDiscriminantAnalysisMachineLearningParameters.
     */
    //@Ignore("please initialize function parameters")
    @Test
    public void LinearDiscriminantAnalysisTest() throws RemoteException {

        // Initialize the oneChannelExpressionData.
        OneChannelExpressionData oneChannelExpressionData =
                this.getOneChannelExpressionData();

        // Read the LinearDiscriminantAnalysisMachineLearningParameters object with which to test.
        InputStream inputStream = null;
        ObjectInput objectInput = null;
        LinearDiscriminantAnalysisMachineLearningParameters parameters = null;
        try {
            inputStream = this.getClass().getResourceAsStream("../../worker/Data/LinearDiscriminantAnalysisMachineLearningParameters.rda_java.Data");
            objectInput = new ObjectInputStream (new BufferedInputStream( inputStream ));
            parameters = (LinearDiscriminantAnalysisMachineLearningParameters)objectInput.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
          try {
            if (objectInput != null) objectInput.close();
          } catch (IOException ioex) {
            ioex.printStackTrace();
          }
        }

        // Execute the test.
        SupervisedMachineLearningResult ldaResult = binding.supervised( oneChannelExpressionData,
                                                                        parameters );
    }

    /**
     * Tests supervised using a DiagonalLinearDiscriminantAnalysisMachineLearningParameters.
     */
    //@Ignore("please initialize function parameters")
    @Test
    public void DiagonalLinearDiscriminantAnalysisTest() throws RemoteException {

        // Initialize the oneChannelExpressionData.
        OneChannelExpressionData oneChannelExpressionData =
                this.getOneChannelExpressionData();

        // Read the DiagonalLinearDiscriminantAnalysisMachineLearningParameters object with which to test.
        InputStream inputStream = null;
        ObjectInput objectInput = null;
        DiagonalLinearDiscriminantAnalysisMachineLearningParameters parameters = null;
        try {
            inputStream = this.getClass().getResourceAsStream("../../worker/Data/DiagonalLinearDiscriminantAnalysisMachineLearningParameters.rda_java.Data");
            objectInput = new ObjectInputStream (new BufferedInputStream( inputStream ));
            parameters = (DiagonalLinearDiscriminantAnalysisMachineLearningParameters)objectInput.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
          try {
            if (objectInput != null) objectInput.close();
          } catch (IOException ioex) {
            ioex.printStackTrace();
          }
        }

        // Execute the test.
        SupervisedMachineLearningResult dldaResult = binding.supervised( oneChannelExpressionData,
                                                                         parameters );
    }

    /**
     * Tests supervised using a QuadraticDiscriminantAnalysisMachineLearningParameters.
     */
    //@Ignore("please initialize function parameters")
    //@Test
    //public void QuadraticDiscriminantAnalysisTest() throws RemoteException {

        // Initialize the oneChannelExpressionData.
    //    OneChannelExpressionData oneChannelExpressionData =
    //            this.getOneChannelExpressionData();

        // Read the QuadraticDiscriminantAnalysisMachineLearningParameters object with which to test.
    //    InputStream inputStream = null;
    //    ObjectInput objectInput = null;
    //    QuadraticDiscriminantAnalysisMachineLearningParameters parameters = null;
    //    try {
    //        inputStream = this.getClass().getResourceAsStream("../../worker/Data/QuadraticDiscriminantAnalysisMachineLearningParameters.rda_java.Data");
    //        objectInput = new ObjectInputStream (new BufferedInputStream( inputStream ));
    //        parameters = (QuadraticDiscriminantAnalysisMachineLearningParameters)objectInput.readObject();
    //    } catch (Exception ex) {
    //        ex.printStackTrace();
    //    } finally {
    //      try {
    //        if (objectInput != null) objectInput.close();
    //      } catch (IOException ioex) {
    //        ioex.printStackTrace();
    //      }
    //    }

        // Execute the test.
    //    SupervisedMachineLearningResult qdaResult = binding.supervised( oneChannelExpressionData,
    //                                                                    parameters );
    //}

    /**
     * Tests supervised using a NaiveBayesMachineLearningParameters.
     */
    //@Ignore("please initialize function parameters")
    @Test
    public void NaiveBayesTest() throws RemoteException {

        // Initialize the oneChannelExpressionData.
        OneChannelExpressionData oneChannelExpressionData =
                this.getOneChannelExpressionData();

        // Read the NaiveBayesMachineLearningParameters object with which to test.
        InputStream inputStream = null;
        ObjectInput objectInput = null;
        NaiveBayesMachineLearningParameters parameters = null;
        try {
            inputStream = this.getClass().getResourceAsStream("../../worker/Data/NaiveBayesMachineLearningParameters.rda_java.Data");
            objectInput = new ObjectInputStream (new BufferedInputStream( inputStream ));
            parameters = (NaiveBayesMachineLearningParameters)objectInput.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
          try {
            if (objectInput != null) objectInput.close();
          } catch (IOException ioex) {
            ioex.printStackTrace();
          }
        }

        // Execute the test.
        SupervisedMachineLearningResult naiveBayesResult = binding.supervised( oneChannelExpressionData,
                                                                               parameters );
    }

    /**
     * Tests the unsupervised function using a HierarchicalClusteringMachineLearningParameters.
     */
    //@Ignore("please initialize function parameters")
    @Test
    public void HierarchicalClusteringTest() throws RemoteException {

        // Initialize the oneChannelExpressionData.
        OneChannelExpressionData oneChannelExpressionData =
                this.getOneChannelExpressionData();

        // Read the HierarchicalClusteringMachineLearningParameters object with which to test.
        InputStream inputStream = null;
        ObjectInput objectInput = null;
        HierarchicalClusteringMachineLearningParameters parameters = null;
        try {
            inputStream = this.getClass().getResourceAsStream("../../worker/Data/HierarchicalClusteringMachineLearningParameters.rda_java.Data");
            objectInput = new ObjectInputStream (new BufferedInputStream( inputStream ));
            parameters = (HierarchicalClusteringMachineLearningParameters)objectInput.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
          try {
            if (objectInput != null) objectInput.close();
          } catch (IOException ioex) {
            ioex.printStackTrace();
          }
        }

        // Execute the test.
        UnsupervisedMachineLearningResult unsupervisedLearningResult =
                binding.unsupervised( oneChannelExpressionData,
                                      parameters );
    }

    /**
     * Tests the unsupervised function using a KMeansMachineLearningParameters.
     */
    //@Ignore("please initialize function parameters")
    @Test
    public void KMeansTest() throws RemoteException {

        // Initialize the oneChannelExpressionData.
        OneChannelExpressionData oneChannelExpressionData =
                this.getOneChannelExpressionData();

        // Read the KMeansMachineLearningParameters object with which to test.
        InputStream inputStream = null;
        ObjectInput objectInput = null;
        KMeansMachineLearningParameters parameters = null;
        try {
            inputStream = this.getClass().getResourceAsStream("../../worker/Data/KMeansMachineLearningParameters.rda_java.Data");
            objectInput = new ObjectInputStream (new BufferedInputStream( inputStream ));
            parameters = (KMeansMachineLearningParameters)objectInput.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
          try {
            if (objectInput != null) objectInput.close();
          } catch (IOException ioex) {
            ioex.printStackTrace();
          }
        }

        // Execute the test.
        UnsupervisedMachineLearningResult unsupervisedLearningResult =
                binding.unsupervised( oneChannelExpressionData,
                                      parameters );
    }

    /**
     * Returns the OneChannelExpressionData to be used for testing.
     */
    private OneChannelExpressionData getOneChannelExpressionData() {

        InputStream inputStream = null;
        ObjectInput objectInput = null;

        OneChannelExpressionData oneChannelExpressionData = null;
        try {
            inputStream = this.getClass().getResourceAsStream("../../worker/Data/OneChannelExpressionData.rda_java.Data");
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
}
