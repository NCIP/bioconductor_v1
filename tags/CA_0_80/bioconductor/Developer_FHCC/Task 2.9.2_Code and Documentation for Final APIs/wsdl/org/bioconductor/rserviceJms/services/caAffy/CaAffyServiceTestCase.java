/**
 * CaAffyServiceTestCase.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC2 Mar 03, 2006 (12:17:06 EST) WSDL2Java emitter.
 */

package org.bioconductor.rserviceJms.services.caAffy;

public class CaAffyServiceTestCase extends junit.framework.TestCase {
    public CaAffyServiceTestCase(java.lang.String name) {
        super(name);
    }

    public void testcaAffyWSDL() throws Exception {
        javax.xml.rpc.ServiceFactory serviceFactory = javax.xml.rpc.ServiceFactory.newInstance();
        java.net.URL url = new java.net.URL(new org.bioconductor.rserviceJms.services.caAffy.CaAffyServiceLocator().getcaAffyAddress() + "?WSDL");
        javax.xml.rpc.Service service = serviceFactory.createService(url, new org.bioconductor.rserviceJms.services.caAffy.CaAffyServiceLocator().getServiceName());
        assertTrue(service != null);
    }

    public void test1caAffyCaQAReport() throws Exception {
        org.bioconductor.rserviceJms.services.caAffy.CaAffySoapBindingStub binding;
        try {
            binding = (org.bioconductor.rserviceJms.services.caAffy.CaAffySoapBindingStub)
                          new org.bioconductor.rserviceJms.services.caAffy.CaAffyServiceLocator().getcaAffy();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        org.bioconductor.packages.caAffy.QaReport value = null;
        value = binding.caQAReport(new org.bioconductor.packages.caAffy.DerivedBioAssays(), new java.lang.String[0]);
        // TBD - validate results
    }

    public void test2caAffyCaExpresso() throws Exception {
        org.bioconductor.rserviceJms.services.caAffy.CaAffySoapBindingStub binding;
        try {
            binding = (org.bioconductor.rserviceJms.services.caAffy.CaAffySoapBindingStub)
                          new org.bioconductor.rserviceJms.services.caAffy.CaAffyServiceLocator().getcaAffy();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        org.bioconductor.packages.caAffy.DerivedBioAssays value = null;
        value = binding.caExpresso(new org.bioconductor.packages.caAffy.DerivedBioAssays(), new java.lang.String[0], new org.bioconductor.packages.caAffy.ExpressoParameter());
        // TBD - validate results
    }

}
