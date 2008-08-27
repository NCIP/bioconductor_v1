
package org.bioconductor.rserviceJms.worker;
import java.util.*;
import org.bioconductor.packages.rservices.RServicesEnv;

public class RWorkerREnv extends RServicesEnv {

	public RWorkerREnv(Properties prop) throws Exception {
		super();
		e.voidEval("regAddonCvt2()");
		
		e.voidEval("library('caDNAcopy')");
		importCvt("caDNAcopy");
		e.voidEval("checkPkgVersion('caDNAcopy', '0.3.0')");

	}
}
