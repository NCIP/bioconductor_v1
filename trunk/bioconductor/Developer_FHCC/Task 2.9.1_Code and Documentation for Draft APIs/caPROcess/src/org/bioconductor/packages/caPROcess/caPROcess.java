
package org.bioconductor.packages.caPROcess;
import javax.jms.*;
import java.util.*;

public class caPROcess {

	/**
	* Java wrapper for R function caPROcess. 
	*
	* @param mzAssays	
	* @param proCessParameter	
	* @return	result
	*/
	public org.bioconductor.packages.caPROcess.PeakLocation caPROcess(
			 org.bioconductor.packages.caPROcess.MzAssays mzAssays ,
			 org.bioconductor.packages.caPROcess.PROcessParameter proCessParameter ,
			 org.bioconductor.packages.rservices.RServicesConnection connection) throws Exception {
		Object ans = connection.call("caPROcess", 
				new Object[]{mzAssays, proCessParameter},
				"caPROcess", "0.3.1");
		org.bioconductor.packages.caPROcess.PeakLocation res = (org.bioconductor.packages.caPROcess.PeakLocation)ans;
		return res;
	}
}
