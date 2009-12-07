
package org.bioconductor.rserviceJms.worker;

import junit.framework.JUnit4TestAdapter;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.*;
import java.rmi.RemoteException;
import org.bioconductor.packages.rservices.*;

import org.bioconductor.packages.caCommonClasses.*;
import org.bioconductor.packages.caMachineLearning.*;

public class RWorkerDataTest {
	private static MockService binding;

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
	 * We put this test here to let RWorkerDataTest work right out of box.
	 */
	@Test
	public void testMockServiceService() {
		assertNotNull(binding);
	}

	/**
	 * Data transfer to R KNearestNeighborsMachineLearningParameters from Java
	 * org.bioconductor.packages.caMachineLearning.KNearestNeighborsMachineLearningParameters.
	 */
	//@Ignore("please initialize data")
	@Test
	public void TestKNearestNeighborsMachineLearningParametersToR() throws Exception {

                int[] numberOfNeighbors = {1};
                int[] minimumVote       = {0};

                String[] sampleName            = {"Jim", "Kyle", "George", "Amy", "Kathy"};
                boolean[] isTrainingIndividual = {true, false, true, false, false};

                String[] levels = {"a", "b", "c"};
                int[]    code   = {0, 0, 1, 2, 2};  // represents ("a", "a", "b", "c", "c")

                RJFactor type = new RJFactor();
                type.setLevels(levels);
                type.setCode(code);

		KNearestNeighborsMachineLearningParameters inputVal =
                        new KNearestNeighborsMachineLearningParameters(
                                  numberOfNeighbors,
                                  minimumVote,
                                  sampleName,
                                  isTrainingIndividual,
                                  type );

		String rScript = getClass().getResource("R/KNearestNeighborsMachineLearningParameters.R").getFile();
		String rVariable = "kNearestNeighborsMachineLearningParameters";
		assertTrue(binding.mockJava2R(inputVal, rScript, rVariable));
	}

        /**
	 * Data transfer to R SupportVectorMachinesMachineLearningParameters from Java
	 * org.bioconductor.packages.caMachineLearning.SupportVectorMachineMachineLearningParameters.
	 */
	//@Ignore("please initialize data")
	@Test
	public void TestSupportVectorMachineMachineLearningParametersToR() throws Exception {

                String[] sampleName            = {"Jim", "Kyle", "George", "Amy", "Kathy"};
                boolean[] isTrainingIndividual = {true, false, true, false, false};

                String[] levels = {"a", "b", "c"};
                int[]    code   = {0, 0, 1, 2, 2};  // represents ("a", "a", "b", "c", "c")

                RJFactor type = new RJFactor();
                type.setLevels(levels);
                type.setCode(code);

		SupportVectorMachineMachineLearningParameters inputVal =
                        new SupportVectorMachineMachineLearningParameters(
                                  sampleName,
                                  isTrainingIndividual,
                                  type );

		String rScript = getClass().getResource("R/SupportVectorMachineMachineLearningParameters.R").getFile();
		String rVariable = "supportVectorMachineMachineLearningParameters";
		assertTrue(binding.mockJava2R(inputVal, rScript, rVariable));
	}

        /**
	 * Data transfer to R LinearDiscriminantAnalysisMachineLearningParameters from Java
	 * org.bioconductor.packages.caMachineLearning.LinearDiscriminantAnalysisMachineLearningParameters.
	 */
	//@Ignore("please initialize data")
	@Test
	public void TestLinearDiscriminantAnalysisMachineLearningParametersToR() throws Exception {

                String[] sampleName            = {"Jim", "Kyle", "George", "Amy", "Kathy"};
                boolean[] isTrainingIndividual = {true, false, true, false, false};

                String[] levels = {"a", "b", "c"};
                int[]    code   = {0, 0, 1, 2, 2};  // represents ("a", "a", "b", "c", "c")

                RJFactor type = new RJFactor();
                type.setLevels(levels);
                type.setCode(code);

		LinearDiscriminantAnalysisMachineLearningParameters inputVal =
                        new LinearDiscriminantAnalysisMachineLearningParameters(
                                  sampleName,
                                  isTrainingIndividual,
                                  type );

		String rScript = getClass().getResource("R/LinearDiscriminantAnalysisMachineLearningParameters.R").getFile();
		String rVariable = "linearDiscriminantAnalysisMachineLearningParameters";
		assertTrue(binding.mockJava2R(inputVal, rScript, rVariable));
	}

        /**
	 * Data transfer to R DiagonalLinearDiscriminantAnalysisMachineLearningParameters from Java
	 * org.bioconductor.packages.caMachineLearning.DiagonalLinearDiscriminantAnalysisMachineLearningParameters.
	 */
	//@Ignore("please initialize data")
	@Test
	public void TestDiagonalLinearDiscriminantAnalysisMachineLearningParametersToR() throws Exception {

                String[] sampleName            = {"Jim", "Kyle", "George", "Amy", "Kathy"};
                boolean[] isTrainingIndividual = {true, false, true, false, false};

                String[] levels = {"a", "b", "c"};
                int[]    code   = {0, 0, 1, 2, 2};  // represents ("a", "a", "b", "c", "c")

                RJFactor type = new RJFactor();
                type.setLevels(levels);
                type.setCode(code);

		DiagonalLinearDiscriminantAnalysisMachineLearningParameters inputVal =
                        new DiagonalLinearDiscriminantAnalysisMachineLearningParameters(
                                  sampleName,
                                  isTrainingIndividual,
                                  type );

		String rScript = getClass().getResource("R/DiagonalLinearDiscriminantAnalysisMachineLearningParameters.R").getFile();
		String rVariable = "diagonalLinearDiscriminantAnalysisMachineLearningParameters";
		assertTrue(binding.mockJava2R(inputVal, rScript, rVariable));
	}

        /**
	 * Data transfer to R QuadraticDiscriminantAnalysisMachineLearningParameters from Java
	 * org.bioconductor.packages.caMachineLearning.QuadraticDiscriminantAnalysisMachineLearningParameters.
	 */
	//@Ignore("please initialize data")
	//@Test
	//public void TestQuadraticDiscriminantAnalysisMachineLearningParametersToR() throws Exception {

        //        String[] sampleName            = {"Jim", "Kyle", "George", "Amy", "Kathy"};
        //        boolean[] isTrainingIndividual = {true, false, true, false, false};

        //        String[] levels = {"a", "b", "c"};
        //        int[]    code   = {0, 0, 1, 2, 2};  // represents ("a", "a", "b", "c", "c")

        //        RJFactor type = new RJFactor();
        //        type.setLevels(levels);
        //        type.setCode(code);

	//	QuadraticDiscriminantAnalysisMachineLearningParameters inputVal =
        //                new QuadraticDiscriminantAnalysisMachineLearningParameters(
        //                          sampleName,
        //                          isTrainingIndividual,
        //                          type );

	//	String rScript = getClass().getResource("R/QuadraticDiscriminantAnalysisMachineLearningParameters.R").getFile();
	//	String rVariable = "quadraticDiscriminantAnalysisMachineLearningParameters";
	//	assertTrue(binding.mockJava2R(inputVal, rScript, rVariable));
	//}

        /**
	 * Data transfer to R NaiveBayesMachineLearningParameters from Java
	 * org.bioconductor.packages.caMachineLearning.NaiveBayesMachineLearningParameters.
	 */
	//@Ignore("please initialize data")
	@Test
	public void TestNaiveBayesMachineLearningParametersToR() throws Exception {

                String[] sampleName            = {"Jim", "Kyle", "George", "Amy", "Kathy"};
                boolean[] isTrainingIndividual = {true, false, true, false, false};

                String[] levels = {"a", "b", "c"};
                int[]    code   = {0, 0, 1, 2, 2};  // represents ("a", "a", "b", "c", "c")

                RJFactor type = new RJFactor();
                type.setLevels(levels);
                type.setCode(code);

		NaiveBayesMachineLearningParameters inputVal =
                        new NaiveBayesMachineLearningParameters(
                                  sampleName,
                                  isTrainingIndividual,
                                  type );

		String rScript = getClass().getResource("R/NaiveBayesMachineLearningParameters.R").getFile();
		String rVariable = "naiveBayesMachineLearningParameters";
		assertTrue(binding.mockJava2R(inputVal, rScript, rVariable));
	}

        /**
	 * Data transfer to R HierarchicalClusteringMachineLearningParameters from Java
	 * org.bioconductor.packages.caMachineLearning.HierarchicalClusteringMachineLearningParameters.
	 */
	//@Ignore("please initialize data")
	@Test
	public void TestHierarchicalClusteringMachineLearningParametersToR() throws Exception {

                String[] clusteringMethod = {"Complete"};
                String[] distanceMetric   = {"Euclidean"};
                int[]    numberOfClusters = {2};

		HierarchicalClusteringMachineLearningParameters inputVal =
                        new HierarchicalClusteringMachineLearningParameters(
                                 clusteringMethod,
                                 distanceMetric,
                                 numberOfClusters );

		String rScript = getClass().getResource("R/HierarchicalClusteringMachineLearningParameters.R").getFile();
		String rVariable = "hierarchicalClusteringMachineLearningParameters";
		assertTrue(binding.mockJava2R(inputVal, rScript, rVariable));
	}

        /**
	 * Data transfer to R KMeansMachineLearningParameters from Java
	 * org.bioconductor.packages.caMachineLearning.KMeansMachineLearningParameters.
	 */
	//@Ignore("please initialize data")
	@Test
	public void TestKMeansMachineLearningParametersToR() throws Exception {

                int[] numberOfClusters = {1};
                String[] algorithm     = {"Hartigan-Wong"};

		KMeansMachineLearningParameters inputVal =
                        new KMeansMachineLearningParameters(
                                 algorithm,
                                 numberOfClusters );

		String rScript = getClass().getResource("R/KMeansMachineLearningParameters.R").getFile();
		String rVariable = "kMeansMachineLearningParameters";
		assertTrue(binding.mockJava2R(inputVal, rScript, rVariable));
	}

        /**
	 * Data transfer to R SupervisedMachineLearningResult from Java
	 * org.bioconductor.packages.caMachineLearning.SupervisedMachineLearningResult.
	 */
	//@Ignore("please initialize data")
	@Test
	public void TestSupervisedMachineLearningResultToR() throws Exception {

                String[] sampleName = {"Jim", "Kyle", "George", "Amy", "Kathy"};
                boolean[] isTrainingSample = {true, false, true, false, false};

                String[] observedLevel = {"A", "B"};
                int[] observedCode     = {1, 2, 1, 1, 2};

                RJFactor observedClassification = new RJFactor();
                observedClassification.setLevels(observedLevel);
                observedClassification.setCode(observedCode);
  
                String[] predictedLevel = {"A", "B"};
                int[] predictedCode     = {2, 1, 1, 1, 2};

                RJFactor predictedClassification = new RJFactor();
                predictedClassification.setLevels(predictedLevel);
                predictedClassification.setCode(predictedCode);

                SupervisedMachineLearningParameters parameters = new SupervisedMachineLearningParameters();
           
		SupervisedMachineLearningResult inputVal =
                        new SupervisedMachineLearningResult(
                             isTrainingSample,
                             observedClassification,
                             predictedClassification,
                             parameters,
                             sampleName );

		String rScript = getClass().getResource("R/SupervisedMachineLearningResult.R").getFile();
		String rVariable = "supervisedMachineLearningResult";
		assertTrue(binding.mockJava2R(inputVal, rScript, rVariable));
	}

        /**
	 * Data transfer to R UnsupervisedMachineLearningResult from Java
	 * org.bioconductor.packages.caMachineLearning.UnsupervisedMachineLearningResult.
	 */
	//@Ignore("please initialize data")
	@Test
	public void TestUnsupervisedMachineLearningResultToR() throws Exception {

                String[] sampleName        = {"Jim", "Kyle", "George"};
                int[] predictedPartition   = {1, 2, 3};
                int[] neighboringPartition = {2, 1, 3};
                double[] silhouetteWidth   = {0.1, 0.3, 0.5};
                int[] numberOfClusters     = {2};
                UnsupervisedMachineLearningParameters parameters = new UnsupervisedMachineLearningParameters(
                                                                        numberOfClusters );

		UnsupervisedMachineLearningResult inputVal =
                        new UnsupervisedMachineLearningResult(
                              predictedPartition,
                              neighboringPartition,
                              silhouetteWidth,
                              parameters,
                              sampleName );

		String rScript = getClass().getResource("R/UnsupervisedMachineLearningResult.R").getFile();
		String rVariable = "unsupervisedMachineLearningResult";
		assertTrue(binding.mockJava2R(inputVal, rScript, rVariable));
	}
}
