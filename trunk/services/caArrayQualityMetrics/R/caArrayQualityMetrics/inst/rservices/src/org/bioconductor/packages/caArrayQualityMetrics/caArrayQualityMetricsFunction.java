
package org.bioconductor.packages.caArrayQualityMetrics;
import javax.jms.*;
import java.util.*;

public class caArrayQualityMetricsFunction {

	/**
	* Java wrapper for R function caArrayQualityMetrics. 
	*	Provides access to the
	*	arrayQualityMetrics package as an RWebService.
	*
	* @param inputFileReferences	An object of class FileReferences
	* @return	An object of class FileReferences
	*	carrying the URL of a .zip file encapsulating
	*	output from the arrayQualityMetrics package.
	*/
	public org.bioconductor.packages.rservices.RJFileReferences caArrayQualityMetrics(
			 org.bioconductor.packages.rservices.RJFileReferences inputFileReferences,
			 org.bioconductor.packages.rservices.RServicesConnection connection) throws Exception {
		Object ans = connection.call("caArrayQualityMetrics", 
				new Object[]{inputFileReferences},
				"caArrayQualityMetrics", "0.1.1");
		org.bioconductor.packages.rservices.RJFileReferences res = (org.bioconductor.packages.rservices.RJFileReferences)ans;
		return res;
	}
	
	public Object uploadFile(String strUploadFileFrom, String strUploadFileTo,
			org.bioconductor.packages.rservices.RServicesConnection connection) throws Exception
	{
		System.out.println("caArrayQualityMetricsFunction::uploadFile() - get called");
		return connection.call("uploadFile", new Object[]{strUploadFileFrom, strUploadFileTo}, "caArrayQualityMetrics", "0.0.10");
	}
}
