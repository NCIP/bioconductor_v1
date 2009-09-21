package org.bioconductor.packages.caArrayQualityMetrics.service.globus;

import org.bioconductor.packages.caArrayQualityMetrics.service.CaArrayQualityMetricsImpl;

import java.rmi.RemoteException;

/** 
 * DO NOT EDIT:  This class is autogenerated!
 *
 * This class implements each method in the portType of the service.  Each method call represented
 * in the port type will be then mapped into the unwrapped implementation which the user provides
 * in the CaArrayQualityMetricsImpl class.  This class handles the boxing and unboxing of each method call
 * so that it can be correclty mapped in the unboxed interface that the developer has designed and 
 * has implemented.  Authorization callbacks are automatically made for each method based
 * on each methods authorization requirements.
 * 
 * @created by Introduce Toolkit version 1.2
 * 
 */
public class CaArrayQualityMetricsProviderImpl{
	
	CaArrayQualityMetricsImpl impl;
	
	public CaArrayQualityMetricsProviderImpl() throws RemoteException {
		impl = new CaArrayQualityMetricsImpl();
	}
	

    public org.bioconductor.packages.caArrayQualityMetrics.stubs.RunCaArrayQualityMetricsResponse runCaArrayQualityMetrics(org.bioconductor.packages.caArrayQualityMetrics.stubs.RunCaArrayQualityMetricsRequest params) throws RemoteException {
    org.bioconductor.packages.caArrayQualityMetrics.stubs.RunCaArrayQualityMetricsResponse boxedResult = new org.bioconductor.packages.caArrayQualityMetrics.stubs.RunCaArrayQualityMetricsResponse();
    boxedResult.setStatus(impl.runCaArrayQualityMetrics(params.getSessionIdentifier().getSessionIdentifier()));
    return boxedResult;
  }

    public org.bioconductor.packages.caArrayQualityMetrics.stubs.GetRpackageSessionInfoResponse getRpackageSessionInfo(org.bioconductor.packages.caArrayQualityMetrics.stubs.GetRpackageSessionInfoRequest params) throws RemoteException {
    org.bioconductor.packages.caArrayQualityMetrics.stubs.GetRpackageSessionInfoResponse boxedResult = new org.bioconductor.packages.caArrayQualityMetrics.stubs.GetRpackageSessionInfoResponse();
    boxedResult.setResponse(impl.getRpackageSessionInfo());
    return boxedResult;
  }

    public org.bioconductor.packages.caArrayQualityMetrics.stubs.GetStatusResponse getStatus(org.bioconductor.packages.caArrayQualityMetrics.stubs.GetStatusRequest params) throws RemoteException {
    org.bioconductor.packages.caArrayQualityMetrics.stubs.GetStatusResponse boxedResult = new org.bioconductor.packages.caArrayQualityMetrics.stubs.GetStatusResponse();
    boxedResult.setStatus(impl.getStatus(params.getSessionIdentifier().getSessionIdentifier()));
    return boxedResult;
  }

    public org.bioconductor.packages.caArrayQualityMetrics.stubs.CreateQualityReportSessionResponse createQualityReportSession(org.bioconductor.packages.caArrayQualityMetrics.stubs.CreateQualityReportSessionRequest params) throws RemoteException {
    org.bioconductor.packages.caArrayQualityMetrics.stubs.CreateQualityReportSessionResponse boxedResult = new org.bioconductor.packages.caArrayQualityMetrics.stubs.CreateQualityReportSessionResponse();
    boxedResult.setSessionIdentifier(impl.createQualityReportSession());
    return boxedResult;
  }

}
