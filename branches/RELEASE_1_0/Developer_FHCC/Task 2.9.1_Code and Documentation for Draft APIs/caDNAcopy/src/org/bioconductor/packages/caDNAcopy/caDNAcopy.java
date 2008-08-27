
package org.bioconductor.packages.caDNAcopy;
import javax.jms.*;
import java.util.*;

public class caDNAcopy {

	/**
	* Java wrapper for R function caDNAcopy. 
	*	Transform an object of object
	*	DNAcopyAssays-class in R package specifying copy
	*	number variation through smoothing and
	*	segmentation to a object
	*	DerivedDNAcopySegment-class in R package
	*	identifying chromosomal regions of constant copy
	*	number.
	*
	* @param dnacopyAssays	Collection of object ExpressionData-class
	*	in R package objects representing samples from
	*	known chromosomal locations, and their expression
	*	values.
	* @param dnacopyParameter	An object of object
	*	DNAcopyParameter-class in R package encapsulating
	*	parameters influencing evaluation of caDNAcopy.}
	* @return	object DerivedDNAcopySegment-class in R
	*	package
	*/
	public org.bioconductor.packages.caDNAcopy.DerivedDNAcopySegment caDNAcopy(
			 org.bioconductor.packages.caDNAcopy.DNAcopyAssays dnacopyAssays ,
			 org.bioconductor.packages.caDNAcopy.DNAcopyParameter dnacopyParameter ,
			 org.bioconductor.packages.rservices.RServicesConnection connection) throws Exception {
		Object ans = connection.call("caDNAcopy", 
				new Object[]{dnacopyAssays, dnacopyParameter},
				"caDNAcopy", "0.3.0");
		org.bioconductor.packages.caDNAcopy.DerivedDNAcopySegment res = (org.bioconductor.packages.caDNAcopy.DerivedDNAcopySegment)ans;
		return res;
	}
}
