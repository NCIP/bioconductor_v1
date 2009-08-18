package org.bioconductor.packages.helper.service.globus;

import org.bioconductor.packages.helper.service.HelperServiceImpl;

import java.rmi.RemoteException;

/** 
 * DO NOT EDIT:  This class is autogenerated!
 *
 * This class implements each method in the portType of the service.  Each method call represented
 * in the port type will be then mapped into the unwrapped implementation which the user provides
 * in the HelperServiceImpl class.  This class handles the boxing and unboxing of each method call
 * so that it can be correclty mapped in the unboxed interface that the developer has designed and 
 * has implemented.  Authorization callbacks are automatically made for each method based
 * on each methods authorization requirements.
 * 
 * @created by Introduce Toolkit version 1.2
 * 
 */
public class HelperServiceProviderImpl{
	
	HelperServiceImpl impl;
	
	public HelperServiceProviderImpl() throws RemoteException {
		impl = new HelperServiceImpl();
	}
	

    public org.bioconductor.packages.helper.stubs.GetUploadObjectReferenceResponse getUploadObjectReference(org.bioconductor.packages.helper.stubs.GetUploadObjectReferenceRequest params) throws RemoteException {
    org.bioconductor.packages.helper.stubs.GetUploadObjectReferenceResponse boxedResult = new org.bioconductor.packages.helper.stubs.GetUploadObjectReferenceResponse();
    boxedResult.setCaGridObjectReference(impl.getUploadObjectReference(params.getSessionEndpoint().getSessionEndpoint()));
    return boxedResult;
  }

    public org.bioconductor.packages.helper.stubs.GetDownloadObjectReferenceResponse getDownloadObjectReference(org.bioconductor.packages.helper.stubs.GetDownloadObjectReferenceRequest params) throws RemoteException {
    org.bioconductor.packages.helper.stubs.GetDownloadObjectReferenceResponse boxedResult = new org.bioconductor.packages.helper.stubs.GetDownloadObjectReferenceResponse();
    boxedResult.setCaGridObjectReference(impl.getDownloadObjectReference(params.getSessionEndpoint().getSessionEndpoint()));
    return boxedResult;
  }

    public org.bioconductor.packages.helper.stubs.TestContextLookupResponse testContextLookup(org.bioconductor.packages.helper.stubs.TestContextLookupRequest params) throws RemoteException {
    org.bioconductor.packages.helper.stubs.TestContextLookupResponse boxedResult = new org.bioconductor.packages.helper.stubs.TestContextLookupResponse();
    boxedResult.setResponse(impl.testContextLookup(params.getSessionEndpoint().getSessionEndpoint()));
    return boxedResult;
  }

    public org.bioconductor.packages.helper.stubs.GetUploadFileReferencesResponse getUploadFileReferences(org.bioconductor.packages.helper.stubs.GetUploadFileReferencesRequest params) throws RemoteException {
    org.bioconductor.packages.helper.stubs.GetUploadFileReferencesResponse boxedResult = new org.bioconductor.packages.helper.stubs.GetUploadFileReferencesResponse();
    boxedResult.setCaGridFileReferences(impl.getUploadFileReferences(params.getSessionEndpoint().getSessionEndpoint(),params.getFileReferences().getFileReferences()));
    return boxedResult;
  }

}
