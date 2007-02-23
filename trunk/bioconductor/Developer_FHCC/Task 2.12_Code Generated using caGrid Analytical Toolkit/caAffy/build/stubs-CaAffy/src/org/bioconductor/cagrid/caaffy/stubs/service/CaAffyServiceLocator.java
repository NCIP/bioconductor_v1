/**
 * CaAffyServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC2 Apr 28, 2006 (12:42:00 EDT) WSDL2Java emitter.
 */

package org.bioconductor.cagrid.caaffy.stubs.service;

public class CaAffyServiceLocator extends org.apache.axis.client.Service implements org.bioconductor.cagrid.caaffy.stubs.service.CaAffyService {

    public CaAffyServiceLocator() {
    }


    public CaAffyServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public CaAffyServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for CaAffyPortTypePort
    private java.lang.String CaAffyPortTypePort_address = "http://localhost:8080/wsrf/services/";

    public java.lang.String getCaAffyPortTypePortAddress() {
        return CaAffyPortTypePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String CaAffyPortTypePortWSDDServiceName = "CaAffyPortTypePort";

    public java.lang.String getCaAffyPortTypePortWSDDServiceName() {
        return CaAffyPortTypePortWSDDServiceName;
    }

    public void setCaAffyPortTypePortWSDDServiceName(java.lang.String name) {
        CaAffyPortTypePortWSDDServiceName = name;
    }

    public org.bioconductor.cagrid.caaffy.stubs.CaAffyPortType getCaAffyPortTypePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(CaAffyPortTypePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getCaAffyPortTypePort(endpoint);
    }

    public org.bioconductor.cagrid.caaffy.stubs.CaAffyPortType getCaAffyPortTypePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.bioconductor.cagrid.caaffy.stubs.bindings.CaAffyPortTypeSOAPBindingStub _stub = new org.bioconductor.cagrid.caaffy.stubs.bindings.CaAffyPortTypeSOAPBindingStub(portAddress, this);
            _stub.setPortName(getCaAffyPortTypePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setCaAffyPortTypePortEndpointAddress(java.lang.String address) {
        CaAffyPortTypePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (org.bioconductor.cagrid.caaffy.stubs.CaAffyPortType.class.isAssignableFrom(serviceEndpointInterface)) {
                org.bioconductor.cagrid.caaffy.stubs.bindings.CaAffyPortTypeSOAPBindingStub _stub = new org.bioconductor.cagrid.caaffy.stubs.bindings.CaAffyPortTypeSOAPBindingStub(new java.net.URL(CaAffyPortTypePort_address), this);
                _stub.setPortName(getCaAffyPortTypePortWSDDServiceName());
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
        if ("CaAffyPortTypePort".equals(inputPortName)) {
            return getCaAffyPortTypePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://caaffy.cagrid.bioconductor.org/CaAffy/service", "CaAffyService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://caaffy.cagrid.bioconductor.org/CaAffy/service", "CaAffyPortTypePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        if ("CaAffyPortTypePort".equals(portName)) {
            setCaAffyPortTypePortEndpointAddress(address);
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
