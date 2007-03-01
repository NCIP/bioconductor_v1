package org.bioconductor.packages.caAffy.util;

import gov.nih.nci.mageom.domain.bioassay.BioAssay;
import gov.nih.nci.mageom.domain.bioassay.BioDataCube;
import gov.nih.nci.mageom.domain.bioassay.MeasuredBioAssay;
import gov.nih.nci.mageom.domain.bioassay.DerivedBioAssay;
import gov.nih.nci.mageom.domain.bioassay.DerivedBioAssayData;
import gov.nih.nci.mageom.domain.bioassay.QuantitationTypeDimension;
import gov.nih.nci.mageom.domain.bioassay.Reporter;
import gov.nih.nci.mageom.domain.bioassay.ReporterDimension;

import edu.columbia.geworkbench.cagrid.MageBioAssayGeneratorImpl;
import org.bioconductor.packages.rservices.RJNumericMatrix;

/**
 * 
 * @author mtmorgan
 * @version $Id: MageMapper.java,v 1.1.1.1 2007-03-01 04:49:38 mtmorgan Exp $
 */
public class MageMapper {
  
    public void MageMapper() {}

    /*
     * Represent RJNumericMatrix as BioAssay[]. Use row names as
     * Reporter names, and column names as BioAssay names.
     *
     */
    public BioAssay[] toBioAssay(RJNumericMatrix rjNumericMatrix) {
	double[] exprs = rjNumericMatrix.getValue();
	Object[] dimnames = rjNumericMatrix.getDimnames();
	int[] dim = rjNumericMatrix.getDim();

	double[][] ddata = new double[dim[0]][dim[1]];
	for (int i=0; i < dim[0]; ++i)
	    for (int j=0; j<dim[1]; ++j)
		ddata[i][j] = exprs[j*dim[0] + i];

	edu.columbia.geworkbench.cagrid.MageBioAssayGeneratorImpl
	    generator = new edu.columbia.geworkbench.cagrid.MageBioAssayGeneratorImpl();
	return generator.double2DToBioAssayArray(ddata,
						 (String[]) dimnames[0],
						 (String[]) dimnames[1]);
    }

    /*
     * Get dimensions (reporters x samples) of BioAssay[]
     *
     */
    public int[] getDim(BioAssay[] bioAssays) {
	DerivedBioAssayData dbad =
	    ((DerivedBioAssay) bioAssays[0]).getDerivedBioAssayData()[0];
	Reporter[] reporters = 
	    ((ReporterDimension) dbad.getDesignElementDimension()).getReporters();
	return new int[] {reporters.length, bioAssays.length};
    }

    /*
     * Compose a vector of double values representing a column-major
     * ordering of the expression values implied by BioAssay[]
     *
     */
    public double[] getExpressionMatrix(BioAssay[] bioAssays) throws Exception {
	int[] dim = getDim(bioAssays); // reporters x samples
	MageParser parser = new MageParser();
	// data
	double[] data = new double[dim[0] * dim[1]];
	for (int j=0; j < dim[1]; ++j) { // each BioAssay
	    DerivedBioAssayData dBAD = ((DerivedBioAssay) bioAssays[j]).getDerivedBioAssayData()[0];
	    BioDataCube cube = (BioDataCube) dBAD.getBioDataValues();
	    double[] sample = parser.getCubeFromString(cube.getCube());
	    if (sample.length != dim[0])
		throw new Exception("BioAssay[] members must have identical number of reporters");
	    for (int i=0; i < dim[0]; ++i)
		data[j*dim[0] + i] = sample[i];
	}
	return data;
    }

    /*
     * Construct reporter and bioAssay names as an Object[] containing
     * two String[]; check for consistency of reporter names across
     * assays.
     *
     */
    public Object[] getDimnames(BioAssay[] bioAssays) throws Exception {
	if (bioAssays.length==0)
	    return new Object[2];
	int[] dim = getDim(bioAssays);

	// BioAssay names
	String[] bioAssayNames = new String[bioAssays.length];
	for (int i = 0; i < bioAssays.length; ++i)
	    bioAssayNames[i] = bioAssays[i].getName();

	// Cannonical reporter names
	DerivedBioAssayData[] dBADs =
	    ((DerivedBioAssay) bioAssays[0]).getDerivedBioAssayData();
	if (dBADs.length != 1)
	    throw new Exception("BioAssays must have only 1 DerivedBioAssayData");
	Reporter[] reporters =
	    ((ReporterDimension) dBADs[0].getDesignElementDimension()).getReporters();
	if (reporters.length > 0 && reporters.length != dim[0])
	    throw new Exception("ReporterDimension length must be 0 or equal to number of reporters");
	String[] reporterNames = new String[reporters.length];
	for (int i = 0; i < reporters.length; ++i) {
	    reporterNames[i] = reporters[i].getName();
	}

	// others consistent?
	for (int j = 1; j < dim[1]; ++j) {
	    dBADs = ((DerivedBioAssay) bioAssays[j]).getDerivedBioAssayData();
	    if (dBADs.length != 1)
		throw new Exception("BioAssays must have only 1 DerivedBioAssayData");
	    Reporter[] reporters_p =
		((ReporterDimension) dBADs[0].getDesignElementDimension()).getReporters();
	    if (reporters_p.length != reporters.length)
		throw new Exception("ReporterDimension length must be equal for all DerivedBioAssayData");
	    for (int i = 0; i < reporters.length; ++i)
		if (reporterNames[i] != reporters_p[i].getName())
		    throw new Exception("Reporter names must be identically ordered betweedn DerivedBioAssayData");
	}
	return new Object[] {reporterNames, bioAssayNames};
    }

    /*
     * Represent BioAssay[] as RJNumericMatrix, with reporter names as
     * row names and BioAssay names as column names.
     *
     */
    public RJNumericMatrix toRJNumericMatrix(BioAssay[] bioAssays) throws Exception {
	return new RJNumericMatrix(getExpressionMatrix(bioAssays),
				   getDim(bioAssays),
				   getDimnames(bioAssays));
    }
}
