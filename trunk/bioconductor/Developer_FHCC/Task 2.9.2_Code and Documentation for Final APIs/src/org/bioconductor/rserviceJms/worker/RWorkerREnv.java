
package org.bioconductor.rserviceJms.worker;
import java.util.*;
import org.bioconductor.packages.rservices.RServicesEnv;

public class RWorkerREnv extends RServicesEnv {

	public RWorkerREnv(Properties prop) throws Exception {
		super();
		e.voidEval("regAddonCvt2()");
		
		e.voidEval("library('caAffy')");
		importCvt("caAffy");
		e.voidEval("checkPkgVersion('caAffy', '0.1.6')");

	}
}
