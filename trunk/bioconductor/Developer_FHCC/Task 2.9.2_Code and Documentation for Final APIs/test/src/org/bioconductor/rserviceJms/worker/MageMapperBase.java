package org.bioconductor.rserviceJms.worker;

import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.ginkgo.labs.reader.TabFileReader;

import gov.nih.nci.mageom.domain.bioassay.BioAssay;
import gov.nih.nci.mageom.domain.bioassay.BioDataCube;
import gov.nih.nci.mageom.domain.bioassay.BioDataValues;
import gov.nih.nci.mageom.domain.bioassay.DerivedBioAssay;
import gov.nih.nci.mageom.domain.bioassay.DerivedBioAssayData;

import org.bioconductor.packages.rservices.RJNumericMatrix;
import org.bioconductor.packages.caAffy.util.MageMapper;
import org.bioconductor.packages.caAffy.util.MageParser;

public class MageMapperBase extends TestCase {
	String filename = getClass().getResource("Data/affybatch-example.data").getFile();
	BioAssay[] bioAssays;
	RJNumericMatrix rjNumericMatrix;
	float[][] fdata;
	edu.columbia.geworkbench.cagrid.MageBioAssayGenerator mageBioAssayGenerator = null;

	int[] expectedDim = new int[] { 10000, 3 };	// 100000 reporters, 2 samples
	Object[] expectedDimnames = new Object[2];

	MageMapper mapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		mageBioAssayGenerator = new edu.columbia.geworkbench.cagrid.MageBioAssayGeneratorImpl();
		mapper = new MageMapper();

		try {
			fdata = TabFileReader.readTabFile(new FileInputStream(filename));
			bioAssays = readBioAssays();
			rjNumericMatrix = readRJNumericMatrix();
		} catch (FileNotFoundException ex) {
			System.err.println("File not found: " + ex.getMessage());
			System.exit(1);
		}

		String[] reporterNames = new String[expectedDim[0]];
		for (int i=0; i< reporterNames.length; ++i)
			reporterNames[i] = String.valueOf(i);
		expectedDimnames[0] = reporterNames;
		expectedDimnames[1] = new String[] {"A", "B", "C"};
		super.setUp();
	}

	private BioAssay[] readBioAssays() throws FileNotFoundException {
		String[] rowNames = new String[fdata.length];
		for (int j = 0; j < rowNames.length; j++) {
			rowNames[j] = String.valueOf(j);
		}
		String[] colNames = new String[fdata[0].length];
		for (int j = 0; j < colNames.length; j++) {
			int idx = j % 26;
			colNames[j] = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".substring(idx, idx+1);
		}
		return mageBioAssayGenerator.float2DToBioAssayArray(fdata, rowNames, colNames);
	}

	private RJNumericMatrix readRJNumericMatrix() throws FileNotFoundException {
		int[] dim = new int[] { fdata.length, fdata[0].length };

		String[] rowNames = new String[dim[0]];
		for (int j = 0; j < dim[0]; j++) {
			rowNames[j] = String.valueOf(j);
		}
		String[] colNames = new String[dim[1]];
		for (int j = 0; j < dim[1]; j++) {
			int idx = j % 26;
			colNames[j] = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".substring(idx, idx+1);
		}
		Object[] dimnames = new Object[] {rowNames, colNames};

		double[] exprs = new double[dim[0] * dim[1]];
		for (int i=0; i < dim[0]; ++i)
			for (int j = 0; j < dim[1]; ++j)
				exprs[j * dim[0] + i] = fdata[i][j];

		return new RJNumericMatrix(exprs, dim, dimnames);
	}
}
