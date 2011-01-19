package org.bioconductor.packages.helper.common;

import java.rmi.RemoteException;

import org.bioconductor.cagrid.statefulservices.CaGridFileReferenceCollection;
import org.bioconductor.cagrid.rservices.FileReferenceCollection;
import org.bioconductor.cagrid.statefulservices.CaGridObjectReference;

public interface HelperServiceContextResourceI {
	public String identifyContextSelf();
	public CaGridFileReferenceCollection createUploadFileReferences(FileReferenceCollection fileRefs) throws RemoteException;
	public FileReferenceCollection getFileReferenceCollection() throws RemoteException;
	public CaGridObjectReference createUploadObjectReference() throws RemoteException;
	public CaGridObjectReference createDownloadObjectReference() throws RemoteException;
}
