/**
 * CaAffy.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC2 Mar 03, 2006 (12:17:06 EST) WSDL2Java emitter.
 */

package org.bioconductor.rserviceJms.services.caAffy;

public interface CaAffy extends java.rmi.Remote {
    public org.bioconductor.packages.caAffy.QaReport caQAReport(org.bioconductor.packages.caAffy.DerivedBioAssays in0, java.lang.String[] in1) throws java.rmi.RemoteException;
    public org.bioconductor.packages.caAffy.DerivedBioAssays caExpresso(org.bioconductor.packages.caAffy.DerivedBioAssays in0, java.lang.String[] in1, org.bioconductor.packages.caAffy.ExpressoParameter in2) throws java.rmi.RemoteException;
}
