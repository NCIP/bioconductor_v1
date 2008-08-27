package org.bioconductor.rserviceJms.worker;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.ginkgo.labs.reader.TabFileReader;

import gov.nih.nci.mageom.domain.bioassay.BioAssay;
import gov.nih.nci.mageom.domain.bioassay.BioDataCube;
import gov.nih.nci.mageom.domain.bioassay.BioDataValues;
import gov.nih.nci.mageom.domain.bioassay.DerivedBioAssay;
import gov.nih.nci.mageom.domain.bioassay.DerivedBioAssayData;

import org.bioconductor.packages.caAffy.util.MageMapper;
import org.bioconductor.packages.caAffy.util.MageParser;

/**
 * 
 * @author mtmorgan
 * @version $Id: MageBioAssayGeneratorImplTest.java,v 1.1 2007/02/22 22:03:18
 *          keshav Exp $
 */
public class MageParserTest extends TestCase {
    private Log log = LogFactory.getLog(this.getClass());
    String filename = getClass().getResource("Data/affybatch-example.data").getFile();
    InputStream is = null;
    edu.columbia.geworkbench.cagrid.MageBioAssayGenerator generator = null;

    /*
     * (non-Javadoc)
     * 
     * @see junit.framework.TestCase#setUp()
     */
    @Override
    protected void setUp() throws Exception {
	generator = new edu.columbia.geworkbench.cagrid.MageBioAssayGeneratorImpl();
	is = new FileInputStream(filename);
	super.setUp();
    }

    /**
     * Tests converting a float 2D array to an array of BioAssays.
     *
     * @throws FileNotFoundException
     *
     */
    public void testGetCubeFromString() throws FileNotFoundException, Exception {
	
	log.debug("\nRunning test getCubeFromString ...");
	
	float[][] fdata = TabFileReader.readTabFile(is);
	
	String[] rowNames = new String[fdata.length];
	for (int j = 0; j < rowNames.length; j++) {
	    rowNames[j] = String.valueOf(j);
	}
	
	String[] colNames = new String[fdata[0].length];
	for (int j = 0; j < colNames.length; j++) {
	    colNames[j] = String.valueOf(j);
	}

	BioAssay[] bioAssays =
	    generator.float2DToBioAssayArray(fdata, rowNames, colNames);

	// sanity check
	assertNotNull(bioAssays);
	assertEquals(bioAssays.length, fdata[0].length);
	
	// transpose ddata, for easy testing
	float[][] tdata = new float[fdata[0].length][fdata.length];
	for (int i = 0; i < fdata.length; ++i)
	    for (int j=0; j < fdata[0].length; ++j)
		tdata[j][i] = fdata[i][j];

	MageParser parser = new MageParser();
	for (int j = 0; j < bioAssays.length; ++j) {
	    DerivedBioAssayData dBAD = ((DerivedBioAssay) bioAssays[j]).getDerivedBioAssayData()[0];
	    BioDataCube cube = (BioDataCube) dBAD.getBioDataValues();
	    double[] dcube = parser.getCubeFromString(cube.getCube());
	    assertEquals(tdata[j].length, dcube.length);
	    for (int i=0; i<dcube.length; ++i)
		assertEquals(tdata[j][i], (float) dcube[i]);
	}
    }
}

