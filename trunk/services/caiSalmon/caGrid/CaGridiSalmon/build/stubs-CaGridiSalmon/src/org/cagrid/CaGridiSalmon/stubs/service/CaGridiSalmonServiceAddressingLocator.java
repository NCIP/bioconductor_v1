/**
 * CaGridiSalmonServiceAddressingLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC2 Apr 28, 2006 (12:42:00 EDT) WSDL2Java emitter.
 */

package org.cagrid.CaGridiSalmon.stubs.service;

public class CaGridiSalmonServiceAddressingLocator extends org.cagrid.CaGridiSalmon.stubs.service.CaGridiSalmonServiceLocator implements org.cagrid.CaGridiSalmon.stubs.service.CaGridiSalmonServiceAddressing {
    public org.cagrid.CaGridiSalmon.stubs.CaGridiSalmonPortType getCaGridiSalmonPortTypePort(org.apache.axis.message.addressing.EndpointReferenceType reference) throws javax.xml.rpc.ServiceException {
	org.apache.axis.message.addressing.AttributedURI address = reference.getAddress();
	if (address == null) {
		throw new javax.xml.rpc.ServiceException("No address in EndpointReference");
	}
	java.net.URL endpoint;
	try {
		endpoint = new java.net.URL(address.toString());
	} catch (java.net.MalformedURLException e) {
		throw new javax.xml.rpc.ServiceException(e);
	}
	org.cagrid.CaGridiSalmon.stubs.CaGridiSalmonPortType _stub = getCaGridiSalmonPortTypePort(endpoint);
	if (_stub != null) {
		org.apache.axis.message.addressing.AddressingHeaders headers =
			new org.apache.axis.message.addressing.AddressingHeaders();
		headers.setTo(address);
		headers.setReferenceProperties(reference.getProperties());
		((javax.xml.rpc.Stub)_stub)._setProperty(org.apache.axis.message.addressing.Constants.ENV_ADDRESSING_SHARED_HEADERS, headers);
	}
	return _stub;
    }


}
