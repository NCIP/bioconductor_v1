/**
 * CaDNAcopyResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC2 Apr 28, 2006 (12:42:00 EDT) WSDL2Java emitter.
 */

package org.bioconductor.cagrid.cadnacopy.stubs;

public class CaDNAcopyResponse  implements java.io.Serializable {
    private org.bioconductor.cagrid.cadnacopy.DerivedDNAcopySegment derivedDNAcopySegment;

    public CaDNAcopyResponse() {
    }

    public CaDNAcopyResponse(
           org.bioconductor.cagrid.cadnacopy.DerivedDNAcopySegment derivedDNAcopySegment) {
           this.derivedDNAcopySegment = derivedDNAcopySegment;
    }


    /**
     * Gets the derivedDNAcopySegment value for this CaDNAcopyResponse.
     * 
     * @return derivedDNAcopySegment
     */
    public org.bioconductor.cagrid.cadnacopy.DerivedDNAcopySegment getDerivedDNAcopySegment() {
        return derivedDNAcopySegment;
    }


    /**
     * Sets the derivedDNAcopySegment value for this CaDNAcopyResponse.
     * 
     * @param derivedDNAcopySegment
     */
    public void setDerivedDNAcopySegment(org.bioconductor.cagrid.cadnacopy.DerivedDNAcopySegment derivedDNAcopySegment) {
        this.derivedDNAcopySegment = derivedDNAcopySegment;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CaDNAcopyResponse)) return false;
        CaDNAcopyResponse other = (CaDNAcopyResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.derivedDNAcopySegment==null && other.getDerivedDNAcopySegment()==null) || 
             (this.derivedDNAcopySegment!=null &&
              this.derivedDNAcopySegment.equals(other.getDerivedDNAcopySegment())));
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
        if (getDerivedDNAcopySegment() != null) {
            _hashCode += getDerivedDNAcopySegment().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CaDNAcopyResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://cadnacopy.cagrid.bioconductor.org/CaDNAcopy", ">CaDNAcopyResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("derivedDNAcopySegment");
        elemField.setXmlName(new javax.xml.namespace.QName("http://org.bioconductor.cabig/1.0/org.bioconductor.cagrid.cadnacopy", "DerivedDNAcopySegment"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://org.bioconductor.cabig/1.0/org.bioconductor.cagrid.cadnacopy", "DerivedDNAcopySegment"));
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
