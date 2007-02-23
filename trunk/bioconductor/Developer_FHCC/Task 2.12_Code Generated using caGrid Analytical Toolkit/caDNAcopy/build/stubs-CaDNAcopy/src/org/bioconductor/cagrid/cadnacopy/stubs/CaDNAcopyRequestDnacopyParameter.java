/**
 * CaDNAcopyRequestDnacopyParameter.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC2 Apr 28, 2006 (12:42:00 EDT) WSDL2Java emitter.
 */

package org.bioconductor.cagrid.cadnacopy.stubs;

public class CaDNAcopyRequestDnacopyParameter  implements java.io.Serializable {
    private org.bioconductor.cagrid.cadnacopy.DNAcopyParameter DNAcopyParameter;

    public CaDNAcopyRequestDnacopyParameter() {
    }

    public CaDNAcopyRequestDnacopyParameter(
           org.bioconductor.cagrid.cadnacopy.DNAcopyParameter DNAcopyParameter) {
           this.DNAcopyParameter = DNAcopyParameter;
    }


    /**
     * Gets the DNAcopyParameter value for this CaDNAcopyRequestDnacopyParameter.
     * 
     * @return DNAcopyParameter
     */
    public org.bioconductor.cagrid.cadnacopy.DNAcopyParameter getDNAcopyParameter() {
        return DNAcopyParameter;
    }


    /**
     * Sets the DNAcopyParameter value for this CaDNAcopyRequestDnacopyParameter.
     * 
     * @param DNAcopyParameter
     */
    public void setDNAcopyParameter(org.bioconductor.cagrid.cadnacopy.DNAcopyParameter DNAcopyParameter) {
        this.DNAcopyParameter = DNAcopyParameter;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CaDNAcopyRequestDnacopyParameter)) return false;
        CaDNAcopyRequestDnacopyParameter other = (CaDNAcopyRequestDnacopyParameter) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.DNAcopyParameter==null && other.getDNAcopyParameter()==null) || 
             (this.DNAcopyParameter!=null &&
              this.DNAcopyParameter.equals(other.getDNAcopyParameter())));
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
        if (getDNAcopyParameter() != null) {
            _hashCode += getDNAcopyParameter().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CaDNAcopyRequestDnacopyParameter.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://cadnacopy.cagrid.bioconductor.org/CaDNAcopy", ">>CaDNAcopyRequest>dnacopyParameter"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DNAcopyParameter");
        elemField.setXmlName(new javax.xml.namespace.QName("http://org.bioconductor.cabig/1.0/org.bioconductor.cagrid.cadnacopy", "DNAcopyParameter"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://org.bioconductor.cabig/1.0/org.bioconductor.cagrid.cadnacopy", "DNAcopyParameter"));
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
