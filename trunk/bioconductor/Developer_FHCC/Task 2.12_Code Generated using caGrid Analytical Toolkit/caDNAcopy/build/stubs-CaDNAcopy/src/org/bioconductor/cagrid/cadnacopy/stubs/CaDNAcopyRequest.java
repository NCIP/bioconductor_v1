/**
 * CaDNAcopyRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC2 Apr 28, 2006 (12:42:00 EDT) WSDL2Java emitter.
 */

package org.bioconductor.cagrid.cadnacopy.stubs;

public class CaDNAcopyRequest  implements java.io.Serializable {
    private org.bioconductor.cagrid.cadnacopy.stubs.CaDNAcopyRequestDnacopyAssays dnacopyAssays;
    private org.bioconductor.cagrid.cadnacopy.stubs.CaDNAcopyRequestDnacopyParameter dnacopyParameter;

    public CaDNAcopyRequest() {
    }

    public CaDNAcopyRequest(
           org.bioconductor.cagrid.cadnacopy.stubs.CaDNAcopyRequestDnacopyAssays dnacopyAssays,
           org.bioconductor.cagrid.cadnacopy.stubs.CaDNAcopyRequestDnacopyParameter dnacopyParameter) {
           this.dnacopyAssays = dnacopyAssays;
           this.dnacopyParameter = dnacopyParameter;
    }


    /**
     * Gets the dnacopyAssays value for this CaDNAcopyRequest.
     * 
     * @return dnacopyAssays
     */
    public org.bioconductor.cagrid.cadnacopy.stubs.CaDNAcopyRequestDnacopyAssays getDnacopyAssays() {
        return dnacopyAssays;
    }


    /**
     * Sets the dnacopyAssays value for this CaDNAcopyRequest.
     * 
     * @param dnacopyAssays
     */
    public void setDnacopyAssays(org.bioconductor.cagrid.cadnacopy.stubs.CaDNAcopyRequestDnacopyAssays dnacopyAssays) {
        this.dnacopyAssays = dnacopyAssays;
    }


    /**
     * Gets the dnacopyParameter value for this CaDNAcopyRequest.
     * 
     * @return dnacopyParameter
     */
    public org.bioconductor.cagrid.cadnacopy.stubs.CaDNAcopyRequestDnacopyParameter getDnacopyParameter() {
        return dnacopyParameter;
    }


    /**
     * Sets the dnacopyParameter value for this CaDNAcopyRequest.
     * 
     * @param dnacopyParameter
     */
    public void setDnacopyParameter(org.bioconductor.cagrid.cadnacopy.stubs.CaDNAcopyRequestDnacopyParameter dnacopyParameter) {
        this.dnacopyParameter = dnacopyParameter;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CaDNAcopyRequest)) return false;
        CaDNAcopyRequest other = (CaDNAcopyRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dnacopyAssays==null && other.getDnacopyAssays()==null) || 
             (this.dnacopyAssays!=null &&
              this.dnacopyAssays.equals(other.getDnacopyAssays()))) &&
            ((this.dnacopyParameter==null && other.getDnacopyParameter()==null) || 
             (this.dnacopyParameter!=null &&
              this.dnacopyParameter.equals(other.getDnacopyParameter())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getDnacopyAssays() != null) {
            _hashCode += getDnacopyAssays().hashCode();
        }
        if (getDnacopyParameter() != null) {
            _hashCode += getDnacopyParameter().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CaDNAcopyRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://cadnacopy.cagrid.bioconductor.org/CaDNAcopy", ">CaDNAcopyRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dnacopyAssays");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cadnacopy.cagrid.bioconductor.org/CaDNAcopy", "dnacopyAssays"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://cadnacopy.cagrid.bioconductor.org/CaDNAcopy", ">>CaDNAcopyRequest>dnacopyAssays"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dnacopyParameter");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cadnacopy.cagrid.bioconductor.org/CaDNAcopy", "dnacopyParameter"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://cadnacopy.cagrid.bioconductor.org/CaDNAcopy", ">>CaDNAcopyRequest>dnacopyParameter"));
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
