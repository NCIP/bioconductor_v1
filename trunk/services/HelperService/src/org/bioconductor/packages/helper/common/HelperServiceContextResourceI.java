package org.bioconductor.packages.helper.common;

import java.rmi.RemoteException;

import org.bioconductor.cagrid.statefulservices.CaGridFileReferences;
import org.bioconductor.cagrid.rservices.FileReferences;
import org.bioconductor.cagrid.statefulservices.CaGridObjectReference;

public interface HelperServiceContextResourceI {
	public String identifyContextSelf();
	public CaGridFileReferences createUploadFileReferences(FileReferences fileRefs) throws RemoteException;
	public CaGridObjectReference createUploadObjectReference() throws RemoteException;
	public CaGridObjectReference createDownloadObjectReference() throws RemoteException;
}
