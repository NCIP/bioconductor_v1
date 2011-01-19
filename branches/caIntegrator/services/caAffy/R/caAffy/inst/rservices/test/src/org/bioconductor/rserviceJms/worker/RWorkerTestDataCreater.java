
package org.bioconductor.rserviceJms.worker;
import org.bioconductor.packages.rservices.TestDataCreater;


public class RWorkerTestDataCreater {
	public static void main(String[] args) throws Exception {
		RWorkerProperties prop = new RWorkerProperties();
		RWorkerREnv e = new RWorkerREnv(prop);
		TestDataCreater tdc = new TestDataCreater(e);
		String action = args[0];
		String rdataDir = args[1];
		if (action.equals("load")) {
			tdc.loadRDataToJavaData(rdataDir);
		} else if (action.equals("data")) {
			String rdataSet = args[2];
			tdc.dataRDataToJavaData(rdataSet, rdataDir);
		} else {
			System.out.println("Invalid action "+action+", action should be either 'data' or 'load'.");
		}
	}
}
