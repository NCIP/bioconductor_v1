/**
 * CaPROcessServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC2 Apr 28, 2006 (12:42:00 EDT) WSDL2Java emitter.
 */

package org.bioconductor.cagrid.caprocess.stubs.service;

public class CaPROcessServiceLocator extends org.apache.axis.client.Service implements org.bioconductor.cagrid.caprocess.stubs.service.CaPROcessService {

    public CaPROcessServiceLocator() {
    }


    public CaPROcessServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public CaPROcessServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for CaPROcessPortTypePort
    private java.lang.String CaPROcessPortTypePort_address = "http://localhost:8080/wsrf/services/";

    public java.lang.String getCaPROcessPortTypePortAddress() {
        return CaPROcessPortTypePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String CaPROcessPortTypePortWSDDServiceName = "CaPROcessPortTypePort";

    public java.lang.String getCaPROcessPortTypePortWSDDServiceName() {
        return CaPROcessPortTypePortWSDDServiceName;
    }

    public void setCaPROcessPortTypePortWSDDServiceName(java.lang.String name) {
        CaPROcessPortTypePortWSDDServiceName = name;
    }

    public org.bioconductor.cagrid.caprocess.stubs.CaPROcessPortType getCaPROcessPortTypePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(CaPROcessPortTypePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getCaPROcessPortTypePort(endpoint);
    }

    public org.bioconductor.cagrid.caprocess.stubs.CaPROcessPortType getCaPROcessPortTypePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.bioconductor.cagrid.caprocess.stubs.bindings.CaPROcessPortTypeSOAPBindingStub _stub = new org.bioconductor.cagrid.caprocess.stubs.bindings.CaPROcessPortTypeSOAPBindingStub(portAddress, this);
            _stub.setPortName(getCaPROcessPortTypePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setCaPROcessPortTypePortEndpointAddress(java.lang.String address) {
        CaPROcessPortTypePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (org.bioconductor.cagrid.caprocess.stubs.CaPROcessPortType.class.isAssignableFrom(serviceEndpointInterface)) {
                org.bioconductor.cagrid.caprocess.stubs.bindings.CaPROcessPortTypeSOAPBindingStub _stub = new org.bioconductor.cagrid.caprocess.stubs.bindings.CaPROcessPortTypeSOAPBindingStub(new java.net.URL(CaPROcessPortTypePort_address), this);
                _stub.setPortName(getCaPROcessPortTypePortWSDDServiceName());
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
        if ("CaPROcessPortTypePort".equals(inputPortName)) {
            return getCaPROcessPortTypePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://caprocess.cagrid.bioconductor.org/CaPROcess/service", "CaPROcessService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://caprocess.cagrid.bioconductor.org/CaPROcess/service", "CaPROcessPortTypePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        if ("CaPROcessPortTypePort".equals(portName)) {
            setCaPROcessPortTypePortEndpointAddress(address);
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
