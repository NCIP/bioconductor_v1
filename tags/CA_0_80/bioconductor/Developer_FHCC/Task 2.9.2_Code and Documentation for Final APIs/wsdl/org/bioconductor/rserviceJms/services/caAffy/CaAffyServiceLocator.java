/**
 * CaAffyServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC2 Mar 03, 2006 (12:17:06 EST) WSDL2Java emitter.
 */

package org.bioconductor.rserviceJms.services.caAffy;

public class CaAffyServiceLocator extends org.apache.axis.client.Service implements org.bioconductor.rserviceJms.services.caAffy.CaAffyService {

    public CaAffyServiceLocator() {
    }


    public CaAffyServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public CaAffyServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for caAffy
    private java.lang.String caAffy_address = "http://localhost:8080/axis/services/caAffy";

    public java.lang.String getcaAffyAddress() {
        return caAffy_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String caAffyWSDDServiceName = "caAffy";

    public java.lang.String getcaAffyWSDDServiceName() {
        return caAffyWSDDServiceName;
    }

    public void setcaAffyWSDDServiceName(java.lang.String name) {
        caAffyWSDDServiceName = name;
    }

    public org.bioconductor.rserviceJms.services.caAffy.CaAffy getcaAffy() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(caAffy_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getcaAffy(endpoint);
    }

    public org.bioconductor.rserviceJms.services.caAffy.CaAffy getcaAffy(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.bioconductor.rserviceJms.services.caAffy.CaAffySoapBindingStub _stub = new org.bioconductor.rserviceJms.services.caAffy.CaAffySoapBindingStub(portAddress, this);
            _stub.setPortName(getcaAffyWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setcaAffyEndpointAddress(java.lang.String address) {
        caAffy_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (org.bioconductor.rserviceJms.services.caAffy.CaAffy.class.isAssignableFrom(serviceEndpointInterface)) {
                org.bioconductor.rserviceJms.services.caAffy.CaAffySoapBindingStub _stub = new org.bioconductor.rserviceJms.services.caAffy.CaAffySoapBindingStub(new java.net.URL(caAffy_address), this);
                _stub.setPortName(getcaAffyWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("caAffy".equals(inputPortName)) {
            return getcaAffy();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://www.bioconductor.org/services/caAffy", "caAffyService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://www.bioconductor.org/services/caAffy", "caAffy"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        if ("caAffy".equals(portName)) {
            setcaAffyEndpointAddress(address);
        }
        else { // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
