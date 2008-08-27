package org.bioconductor.rserviceJms.worker;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import gov.nih.nci.mageom.domain.bioassay.BioAssay;
import gov.nih.nci.mageom.domain.bioassay.BioDataCube;
import gov.nih.nci.mageom.domain.bioassay.BioDataValues;
import gov.nih.nci.mageom.domain.bioassay.DerivedBioAssay;
import gov.nih.nci.mageom.domain.bioassay.DerivedBioAssayData;

import org.bioconductor.packages.rservices.RJNumericMatrix;

/**
 * 
 * @author mtmorgan
 * @version $Id: MageBioAssayGeneratorImplTest.java,v 1.1 2007/02/22 22:03:18
 *			keshav Exp $
 */
public class MageMapperTest extends MageMapperBase {
	
	/**
	 * Tests extracting dimensions from an array of BioAssays
	 *
	 * @throws FileNotFoundException
	 *
	 */
	public void testGetDim() throws Exception {
		int[] dim = mapper.getDim(bioAssays);
		assertEquals(expectedDim[0], dim[0]);
		assertEquals(expectedDim[1], dim[1]);
	}

	/**
	 * Tests extracting reporter and sample names from BioAssays
	 *
	 */
	public void testGetDimnames () throws Exception {
		Object[] dimnames = mapper.getDimnames(bioAssays);
		for (int i=0; i<2; ++i) {
			assertEquals(((String[]) expectedDimnames[i]).length, ((String[]) dimnames[i]).length);
			for (int j = 0; j < ((String[]) expectedDimnames[i]).length; ++j)
				assertEquals(((String[]) expectedDimnames[i])[j], ((String[]) dimnames[i])[j]);
		}
	}

	/**
	 * Tests creation of ExpressionMatrix from BioAssay[]
	 *
	 */
	public void testGetExpressionMatrix() throws Exception {
		double[] exprs = mapper.getExpressionMatrix(bioAssays);
		assertEquals(exprs.length, expectedDim[0] * expectedDim[1]);

		for (int i=0; i < fdata.length; ++i)
			for (int j=0; j < fdata[0].length; ++j)
				assertEquals(fdata[i][j], (float) exprs[j * fdata.length + i]);
	}

	/**
	 * Test creation of RJNumericMatrix from BioAssay[]
	 *
	 */
	public void testToRJNumericMatrix() throws Exception {
		RJNumericMatrix rjNumericMatrix= mapper.toRJNumericMatrix(bioAssays);

		int[] dim = rjNumericMatrix.getDim();
		assertEquals(2, dim.length);
		for (int i=0; i< 2; ++i)
			assertEquals(expectedDim[i], dim[i]);

		double[] exprs = rjNumericMatrix.getValue();
		for (int i=0; i < fdata.length; ++i)
			for (int j=0; j < fdata[0].length; ++j)
				assertEquals(fdata[i][j], (float) exprs[j * fdata.length + i]);

		Object[] dimnames = rjNumericMatrix.getDimnames();
		for (int i=0; i<2; ++i) {
			assertEquals(((String[]) expectedDimnames[i]).length, ((String[]) dimnames[i]).length);
			for (int j = 0; j < ((String[]) expectedDimnames[i]).length; ++j)
				assertEquals(((String[]) expectedDimnames[i])[j], ((String[]) dimnames[i])[j]);
		}
	}

	/**
	 * Test creation of BioAssay[] from RJNumericMatrix
	 *
	 */
	public void testToBioAssay() throws Exception {
		BioAssay[] bioAssays = mapper.toBioAssay(rjNumericMatrix);

		double[] exprs = rjNumericMatrix.getValue();
		double[] baExpressionMatrix = mapper.getExpressionMatrix(bioAssays);
		assertEquals(exprs.length, baExpressionMatrix.length);
		assertEquals(exprs.length, expectedDim[0] * expectedDim[1]);
		for (int i=0; i < exprs.length; ++i)
			assertEquals(exprs[i], baExpressionMatrix[i]);

		int[] baDim = mapper.getDim(bioAssays);
		assertEquals(rjNumericMatrix.getDim()[0], baDim[0]);
		assertEquals(rjNumericMatrix.getDim()[1], baDim[1]);

		Object[] baDimnames = mapper.getDimnames(bioAssays);
		for (int i=0; i<2; ++i) {
			assertEquals(((String[]) expectedDimnames[i]).length, ((String[]) baDimnames[i]).length);
			for (int j = 0; j < ((String[]) expectedDimnames[i]).length; ++j)
				assertEquals(((String[]) expectedDimnames[i])[j], ((String[]) baDimnames[i])[j]);
		}
	}
}
