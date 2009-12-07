
package org.bioconductor.rserviceJms.services.caGeneSetAnalysis;

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
import org.bioconductor.packages.caGeneSetAnalysis.*;

public class caGeneSetAnalysisTest {
	private static caGeneSetAnalysis binding;

	/**
	 * Used for backward compatibility (IDEs, Ant and JUnit 3.x text runner)
	 */
	public static junit.framework.Test suite() {
		 return new JUnit4TestAdapter(caGeneSetAnalysisTest.class);
	}

	/**
	 * Sets up the test fixture; Called before all the tests; Called only once.
	 */
	@BeforeClass
	public static void oneTimeSetUp() throws Exception {
		binding=new caGeneSetAnalysis();
	}

	/**
	 * We put this test here to let caGeneSetAnalysisTest work right out of box.
	 */
	@Test
	public void testcaGeneSetAnalysisService() {
		assertNotNull(binding);
	}

	/**
	 * Tests caGeneSetAnalysis.caGeneSetAnalysis
	 */
	//@Ignore("please initialize function parameters")
	@Test
	public void TestcaGeneSetAnalysis() throws RemoteException {
    }

    /**
     * Tests analyzeAsDiscrete using a GeneOntologyDiscreteGeneSetAnalysisParameters.
     */
    //@Ignore("please initialize function parameters")
    @Test
    public void GeneOntologyAnalyzeAsDiscreteTest() throws RemoteException {

        // Read the GeneOntologyDiscreteGeneSetAnalysisParameters object with which to test.
        InputStream inputStream = null;
        ObjectInput objectInput = null;
        GeneOntologyDiscreteGeneSetAnalysisParameters geneOntologyDiscreteGeneSetAnalysisParameters = null;
        try {
            inputStream = this.getClass().getResourceAsStream("../../worker/Data/GeneOntologyDiscreteGeneSetAnalysisParameters.rda_java.Data");
            objectInput = new ObjectInputStream (new BufferedInputStream( inputStream ));
            geneOntologyDiscreteGeneSetAnalysisParameters = (GeneOntologyDiscreteGeneSetAnalysisParameters)objectInput.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
          try {
            if (objectInput != null) objectInput.close();
          } catch (IOException ioex) {
            ioex.printStackTrace();
          }
        }

        // Retrieve the TopTable with which to run the test.
        TopTable topTable = this.getTopTableForDiscreteGeneSetAnalysis();

        // Execute the test.
        DiscreteGeneSetAnalysisResultCollection discreteGeneSetAnalysisResultCollection =
                binding.analyzeAsDiscrete( topTable,
                                           geneOntologyDiscreteGeneSetAnalysisParameters );
    }

    /**
     * Tests analyzeAsDiscrete using a KEGGDiscreteGeneSetAnalysisParameters.
     */
    //@Ignore("please initialize function parameters")
    @Test
    public void KEGGAnalyzeAsDiscreteTest() throws RemoteException {

        // Read the KEGGDiscreteParameters object with which to test.
        InputStream inputStream = null;
        ObjectInput objectInput = null;
        KEGGDiscreteGeneSetAnalysisParameters keggDiscreteGeneSetAnalysisParameters = null;
        try {
            inputStream = this.getClass().getResourceAsStream("../../worker/Data/KEGGDiscreteGeneSetAnalysisParameters.rda_java.Data");
            objectInput = new ObjectInputStream (new BufferedInputStream( inputStream ));
            keggDiscreteGeneSetAnalysisParameters = (KEGGDiscreteGeneSetAnalysisParameters)objectInput.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
          try {
            if (objectInput != null) objectInput.close();
          } catch (IOException ioex) {
            ioex.printStackTrace();
          }
        }

        // Retrieve the TopTable with which to run the test.
        TopTable topTable = this.getTopTableForDiscreteGeneSetAnalysis();

        // Execute the test.
        DiscreteGeneSetAnalysisResultCollection discreteGeneSetAnalysisResultCollection =
                binding.analyzeAsDiscrete( topTable,
                                           keggDiscreteGeneSetAnalysisParameters );
    }

    /**
     * Tests analyzeAsDiscrete using a PFAMDiscreteGeneSetAnalysisParameters.
     */
    //@Ignore("please initialize function parameters")
    @Test
    public void PFAMAnalyzeAsDiscreteTest() throws RemoteException {

        // Read the PFAMDiscreteGeneSetAnalysisParameters object with which to test.
        InputStream inputStream = null;
        ObjectInput objectInput = null;
        PFAMDiscreteGeneSetAnalysisParameters pfamDiscreteGeneSetAnalysisParameters = null;
        try {
            inputStream = this.getClass().getResourceAsStream("../../worker/Data/PFAMDiscreteGeneSetAnalysisParameters.rda_java.Data");
            objectInput = new ObjectInputStream (new BufferedInputStream( inputStream ));
            pfamDiscreteGeneSetAnalysisParameters = (PFAMDiscreteGeneSetAnalysisParameters)objectInput.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
          try {
            if (objectInput != null) objectInput.close();
          } catch (IOException ioex) {
            ioex.printStackTrace();
          }
        }

        // Retrieve the TopTable with which to run the test.
        TopTable topTable = this.getTopTableForDiscreteGeneSetAnalysis();

        // Execute the test.
        DiscreteGeneSetAnalysisResultCollection discreteGeneSetAnalysisResultCollection =
                binding.analyzeAsDiscrete( topTable,
                                           pfamDiscreteGeneSetAnalysisParameters );
    }

    /**
     * Tests analyzeAsContinous using a GeneOntologyContinuousGeneSetAnalysisParameters.
     */
    //@Ignore("please initialize function parameters")
    @Test
    public void GeneOntologyAnalyzeAsContinuousTest() throws RemoteException {

        // Read the GeneOntologyContinuousGeneSetAnalysisParameters object with which to test.
        InputStream inputStream = null;
        ObjectInput objectInput = null;
        GeneOntologyContinuousGeneSetAnalysisParameters geneOntologyContinuousGeneSetAnalysisParameters = null;
        try {
            inputStream = this.getClass().getResourceAsStream("../../worker/Data/GeneOntologyContinuousGeneSetAnalysisParameters.rda_java.Data");
            objectInput = new ObjectInputStream (new BufferedInputStream( inputStream ));
            geneOntologyContinuousGeneSetAnalysisParameters = (GeneOntologyContinuousGeneSetAnalysisParameters)objectInput.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
          try {
            if (objectInput != null) objectInput.close();
          } catch (IOException ioex) {
            ioex.printStackTrace();
          }
        }

        // Retrieve the TopTable with which to run the test.
        TopTable topTable = this.getTopTableForContinuousGeneSetAnalysis();

        // Execute the test.
        ContinuousGeneSetAnalysisResultCollection continuousGeneSetAnalysisResultCollection =
                binding.analyzeAsContinuous( topTable,
                                             geneOntologyContinuousGeneSetAnalysisParameters );
    }

    /**
     * Tests analyzeAsContinous using a KEGGContinuousGeneSetAnalysisParameters.
     */
    //@Ignore("please initialize function parameters")
    @Test
    public void KEGGAnalyzeAsContinuousTest() throws RemoteException {

        // Read the KEGGContinuousGeneSetAnalysisParameters object with which to test.
        InputStream inputStream = null;
        ObjectInput objectInput = null;
        KEGGContinuousGeneSetAnalysisParameters keggContinuousGeneSetAnalysisParameters = null;
        try {
            inputStream = this.getClass().getResourceAsStream("../../worker/Data/KEGGContinuousGeneSetAnalysisParameters.rda_java.Data");
            objectInput = new ObjectInputStream (new BufferedInputStream( inputStream ));
            keggContinuousGeneSetAnalysisParameters = (KEGGContinuousGeneSetAnalysisParameters)objectInput.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
          try {
            if (objectInput != null) objectInput.close();
          } catch (IOException ioex) {
            ioex.printStackTrace();
          }
        }

        // Retrieve the TopTable with which to run the test.
        TopTable topTable = this.getTopTableForContinuousGeneSetAnalysis();

        // Execute the test.
        ContinuousGeneSetAnalysisResultCollection continuousGeneSetAnalysisResultCollection =
                binding.analyzeAsContinuous( topTable,
                                             keggContinuousGeneSetAnalysisParameters );
    }

    /**
     * Tests analyzeAsContinous using a PFAMContinuousGeneSetAnalysisParameters.
     */
    //@Ignore("please initialize function parameters")
    @Test
    public void PFAMAnalyzeAsContinuousTest() throws RemoteException {

        // Read the PFAMContinuousGeneSetAnalysisParameters object with which to test.
        InputStream inputStream = null;
        ObjectInput objectInput = null;
        PFAMContinuousGeneSetAnalysisParameters pfamContinuousGeneSetAnalysisParameters = null;
        try {
            inputStream = this.getClass().getResourceAsStream("../../worker/Data/PFAMContinuousGeneSetAnalysisParameters.rda_java.Data");
            objectInput = new ObjectInputStream (new BufferedInputStream( inputStream ));
            pfamContinuousGeneSetAnalysisParameters = (PFAMContinuousGeneSetAnalysisParameters)objectInput.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
          try {
            if (objectInput != null) objectInput.close();
          } catch (IOException ioex) {
            ioex.printStackTrace();
          }
        }

        // Retrieve the TopTable with which to run the test.
        TopTable topTable = this.getTopTableForContinuousGeneSetAnalysis();

        // Execute the test.
        ContinuousGeneSetAnalysisResultCollection continuousGeneSetAnalysisResultCollection =
                binding.analyzeAsContinuous( topTable,
                                             pfamContinuousGeneSetAnalysisParameters );
    }

    /**
     * Returns the TopTable to be used to test analyzeAsDiscrete.
     */
    private TopTable getTopTableForDiscreteGeneSetAnalysis() {

        InputStream inputStream = null;
        ObjectInput objectInput = null;

        TopTable topTable = null;
        try {
            inputStream = this.getClass().getResourceAsStream("../../worker/Data/TopTableForDiscreteGeneSetAnalysis.rda_java.Data");
            objectInput = new ObjectInputStream (new BufferedInputStream( inputStream ));
            topTable = (TopTable)objectInput.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
          try {
            if (objectInput != null) objectInput.close();
          } catch (IOException ioex) {
            ioex.printStackTrace();
          }
        }

        return topTable;
    }

    /**
     * Returns the TopTable to be used to test analyzeAsContinuous.
     */
    private TopTable getTopTableForContinuousGeneSetAnalysis() {

        InputStream inputStream = null;
        ObjectInput objectInput = null;

        TopTable topTable = null;
        try {
            inputStream = this.getClass().getResourceAsStream("../../worker/Data/TopTableForContinuousGeneSetAnalysis.rda_java.Data");
            objectInput = new ObjectInputStream (new BufferedInputStream( inputStream ));
            topTable = (TopTable)objectInput.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
          try {
            if (objectInput != null) objectInput.close();
          } catch (IOException ioex) {
            ioex.printStackTrace();
          }
        }

        return topTable;
    }
}
