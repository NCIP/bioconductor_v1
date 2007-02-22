
package org.bioconductor.packages.caAffy;
import javax.jms.*;
import java.util.*;

public class caAffy {

	/**
	* Java wrapper for R function caQAReport. 
	*	This encapsulates the function
	*	affyQAReport for exposure as a web or caGrid
	*	service.
	*
	* @param measuredBioAssays	An object of class object
	*	MeasuredBioAssays-class in R package ; this could
	*	be a list of '.cel' files, a NumericMatrix or
	*	(not yet implemented) an XML-encoded collection
	*	of MAGE MeasuredBioAssayData
	* @return	This returns an object of object
	*	QaReport-class in R package ; only the PDF file
	*	protion of this object is returned in response to
	*	a grid service request.
	*/
	public org.bioconductor.packages.caAffy.QaReport caQAReport(
			 org.bioconductor.packages.caAffy.MeasuredBioAssayMatrix measuredBioAssays ,
			 org.bioconductor.packages.rservices.RServicesConnection connection) throws Exception {
		Object ans = connection.call("caQAReport", 
				new Object[]{measuredBioAssays},
				"caAffy", "0.1.4");
		org.bioconductor.packages.caAffy.QaReport res = (org.bioconductor.packages.caAffy.QaReport)ans;
		return res;
	}


	/**
	* Java wrapper for R function caExpresso. 
	*	Transform a MAGE BioAssay collection
	*	representing `raw' probe values to a
	*	DerivedBioAssay collection through background
	*	correction, normalization, PM corrections, and
	*	probe summarization. Each step is optional, as
	*	described below.
	*	
	*	        The function is designed for use in a web
	*	services environment, requires the SJava and
	*	RWebServices packages, and will usually be
	*	invoked from within Java.
	*
	* @param measuredBioAssays	A object MeasuredBioAssays-class in R
	*	package object containing raw expression values.
	* @param expressoParameter	A object ExpressoParameter-class in R
	*	package object containing parameter values
	*	influencing function evaluation.
	* @return	object DerivedBioAssayMatrix-class in R
	*	package object representing the transformed
	*	expression values.
	*/
	public org.bioconductor.packages.caAffy.DerivedBioAssayMatrix caExpresso(
			 org.bioconductor.packages.caAffy.MeasuredBioAssayMatrix measuredBioAssays ,
			 org.bioconductor.packages.caAffy.ExpressoParameter expressoParameter ,
			 org.bioconductor.packages.rservices.RServicesConnection connection) throws Exception {
		Object ans = connection.call("caExpresso", 
				new Object[]{measuredBioAssays, expressoParameter},
				"caAffy", "0.1.4");
		org.bioconductor.packages.caAffy.DerivedBioAssayMatrix res = (org.bioconductor.packages.caAffy.DerivedBioAssayMatrix)ans;
		return res;
	}
}
