/**
 * CaGridiSalmonServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC2 Apr 28, 2006 (12:42:00 EDT) WSDL2Java emitter.
 */

package org.cagrid.CaGridiSalmon.stubs.service;

public class CaGridiSalmonServiceLocator extends org.apache.axis.client.Service implements org.cagrid.CaGridiSalmon.stubs.service.CaGridiSalmonService {

    public CaGridiSalmonServiceLocator() {
    }


    public CaGridiSalmonServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public CaGridiSalmonServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for CaGridiSalmonPortTypePort
    private java.lang.String CaGridiSalmonPortTypePort_address = "http://localhost:8080/wsrf/services/";

    public java.lang.String getCaGridiSalmonPortTypePortAddress() {
        return CaGridiSalmonPortTypePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String CaGridiSalmonPortTypePortWSDDServiceName = "CaGridiSalmonPortTypePort";

    public java.lang.String getCaGridiSalmonPortTypePortWSDDServiceName() {
        return CaGridiSalmonPortTypePortWSDDServiceName;
    }

    public void setCaGridiSalmonPortTypePortWSDDServiceName(java.lang.String name) {
        CaGridiSalmonPortTypePortWSDDServiceName = name;
    }

    public org.cagrid.CaGridiSalmon.stubs.CaGridiSalmonPortType getCaGridiSalmonPortTypePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(CaGridiSalmonPortTypePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getCaGridiSalmonPortTypePort(endpoint);
    }

    public org.cagrid.CaGridiSalmon.stubs.CaGridiSalmonPortType getCaGridiSalmonPortTypePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.cagrid.CaGridiSalmon.stubs.bindings.CaGridiSalmonPortTypeSOAPBindingStub _stub = new org.cagrid.CaGridiSalmon.stubs.bindings.CaGridiSalmonPortTypeSOAPBindingStub(portAddress, this);
            _stub.setPortName(getCaGridiSalmonPortTypePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setCaGridiSalmonPortTypePortEndpointAddress(java.lang.String address) {
        CaGridiSalmonPortTypePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (org.cagrid.CaGridiSalmon.stubs.CaGridiSalmonPortType.class.isAssignableFrom(serviceEndpointInterface)) {
                org.cagrid.CaGridiSalmon.stubs.bindings.CaGridiSalmonPortTypeSOAPBindingStub _stub = new org.cagrid.CaGridiSalmon.stubs.bindings.CaGridiSalmonPortTypeSOAPBindingStub(new java.net.URL(CaGridiSalmonPortTypePort_address), this);
                _stub.setPortName(getCaGridiSalmonPortTypePortWSDDServiceName());
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
        if ("CaGridiSalmonPortTypePort".equals(inputPortName)) {
            return getCaGridiSalmonPortTypePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://CaGridiSalmon.cagrid.org/CaGridiSalmon/service", "CaGridiSalmonService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://CaGridiSalmon.cagrid.org/CaGridiSalmon/service", "CaGridiSalmonPortTypePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        if ("CaGridiSalmonPortTypePort".equals(portName)) {
            setCaGridiSalmonPortTypePortEndpointAddress(address);
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
