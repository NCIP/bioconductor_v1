package org.bioconductor.packages.caAffy.util;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class MageParser extends edu.columbia.geworkbench.cagrid.MageParser {

    private static final String NAN = "NaN";

    public MageParser() {
	super();
    }

    public double[] getCubeFromString(String str) throws Exception {
	MGEDCubeHandler handler = new MGEDCubeHandler();
	return getCubeFromString(str,
				 handler.getLineDelimiterPattern(),
				 handler.getValueDelimiterPattern());
    }

    public double[] getCubeFromString(String str,
				      String lineDelimPatt,
				      String valueDelimPatt) throws Exception {
	int dim1 = 1;
	int dim2 = 0;
	int dim3 = 0;
	int tempDim2 = 0;
	int tempDim3 = 0;
	// List lines = Arrays.asList(str.split(lineDelimPatt));
	List lines = Arrays.asList(str.split(lineDelimPatt));
	for (Iterator linesIt = lines.iterator(); linesIt.hasNext();) {
	    String line = (String) linesIt.next();
	    if (line.length() == 0) {
		dim1++;
		tempDim2 = 0;
	    } else {
		tempDim2++;
		if (tempDim2 > dim2) {
		    dim2 = tempDim2;
		}
		tempDim3 = line.split(valueDelimPatt).length;
		if (tempDim3 > dim3) {
		    dim3 = tempDim3;
		}
	    }
	}

	return getCubeFromString(dim1, dim2, dim3,
				 str, lineDelimPatt, valueDelimPatt);
    }

    public double[] getCubeFromString(int dim1, int dim2, int dim3,
				      String str, String lineDelimPatt, String valueDelimPatt)
	throws Exception {

	if (dim1 > 1 && dim2 > 1 && dim3 > 1)
	    throw new Exception("BioAssayData must have only two non-zero dimensions");

	int ndim1 = dim1,
	    ndim2 = (dim2 == 0 ? 1 : dim2),
	    ndim3 = (dim3 == 0 ? 1 : dim3);
	double[] cube = new double[ndim1 * ndim2 * ndim3];

	List lines = Arrays.asList(str.split(lineDelimPatt));
	Iterator linesIt = lines.iterator();

	for (int i = 0; i < dim1; i++) {
	    for (int j = 0; j < dim2; j++) {
		String line = (String) linesIt.next();

		// To make up for the added empty line between the first
		// dimension in the write method.
		if (line.length() < 1) {
		    line = (String) linesIt.next();
		}

		String[] tmp = line.split(valueDelimPatt);
		for (int k = 0; k < tmp.length; k++) {
		    if (tmp[k].trim().equalsIgnoreCase(NAN)) {
			cube[i * (ndim2 * ndim3) + j * ndim3 + k] = Double.NaN;
		    } else {
			cube[i * (ndim2 * ndim3) + j * ndim3 + k] = new Double(tmp[k]);
		    }
		}

		if (tmp.length != dim3)
		    if (tmp.length == ndim2 * ndim3)
			j = dim2; // dims 2 and 3 on the same line; force next array
		    else
			throw new ArrayIndexOutOfBoundsException(tmp.length);
	    }
	}
	return cube;
    }
}
