
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
	* @param bioAssays	A object DerivedBioAssays-class in R
	*	package object containing raw expression values.
	* @param cdfName	A character string identifying the name
	*	of the cdf environment from which the BioAssay
	*	expression data are derived from.
	* @return	This returns an object of object
	*	QaReport-class in R package ; only the PDF file
	*	protion of this object is returned in response to
	*	a grid service request.
	*/
	public org.bioconductor.packages.caAffy.QaReport caQAReport(
			 org.bioconductor.packages.caAffy.DerivedBioAssays bioAssays ,
			 String[] cdfName ,
			 org.bioconductor.packages.rservices.RServicesConnection connection) throws Exception {
		Object ans = connection.call("caQAReport", 
				new Object[]{bioAssays, cdfName},
				"caAffy", "0.1.6");
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
	* @param bioAssays	A object DerivedBioAssays-class in R
	*	package object containing raw expression values.
	* @param cdfName	A character string identifying the name
	*	of the cdf environment from which the BioAssay
	*	expression data are derived from.
	* @param expressoParameter	A object ExpressoParameter-class in R
	*	package object containing parameter values
	*	influencing function evaluation.
	* @return	object DerivedBioAssays-class in R
	*	package object representing the transformed
	*	expression values.
	*/
	public org.bioconductor.packages.caAffy.DerivedBioAssays caExpresso(
			 org.bioconductor.packages.caAffy.DerivedBioAssays bioAssays ,
			 String[] cdfName ,
			 org.bioconductor.packages.caAffy.ExpressoParameter expressoParameter ,
			 org.bioconductor.packages.rservices.RServicesConnection connection) throws Exception {
		Object ans = connection.call("caExpresso", 
				new Object[]{bioAssays, cdfName, expressoParameter},
				"caAffy", "0.1.6");
		org.bioconductor.packages.caAffy.DerivedBioAssays res = (org.bioconductor.packages.caAffy.DerivedBioAssays)ans;
		return res;
	}
}
