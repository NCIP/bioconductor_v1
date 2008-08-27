/**
 * NormalizeMethodParameter.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC2 Apr 28, 2006 (12:42:00 EDT) WSDL2Java emitter.
 */

package org.bioconductor.cagrid.caaffy;

public class NormalizeMethodParameter  implements java.io.Serializable {
    private org.bioconductor.cagrid.caaffy.valuedomain.NormalizeMethod method;
    private org.bioconductor.cagrid.caaffy.valuedomain.ProbeType probeType;

    public NormalizeMethodParameter() {
    }

    public NormalizeMethodParameter(
           org.bioconductor.cagrid.caaffy.valuedomain.NormalizeMethod method,
           org.bioconductor.cagrid.caaffy.valuedomain.ProbeType probeType) {
           this.method = method;
           this.probeType = probeType;
    }


    /**
     * Gets the method value for this NormalizeMethodParameter.
     * 
     * @return method
     */
    public org.bioconductor.cagrid.caaffy.valuedomain.NormalizeMethod getMethod() {
        return method;
    }


    /**
     * Sets the method value for this NormalizeMethodParameter.
     * 
     * @param method
     */
    public void setMethod(org.bioconductor.cagrid.caaffy.valuedomain.NormalizeMethod method) {
        this.method = method;
    }


    /**
     * Gets the probeType value for this NormalizeMethodParameter.
     * 
     * @return probeType
     */
    public org.bioconductor.cagrid.caaffy.valuedomain.ProbeType getProbeType() {
        return probeType;
    }


    /**
     * Sets the probeType value for this NormalizeMethodParameter.
     * 
     * @param probeType
     */
    public void setProbeType(org.bioconductor.cagrid.caaffy.valuedomain.ProbeType probeType) {
        this.probeType = probeType;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof NormalizeMethodParameter)) return false;
        NormalizeMethodParameter other = (NormalizeMethodParameter) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.method==null && other.getMethod()==null) || 
             (this.method!=null &&
              this.method.equals(other.getMethod()))) &&
            ((this.probeType==null && other.getProbeType()==null) || 
             (this.probeType!=null &&
              this.probeType.equals(other.getProbeType())));
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
        if (getMethod() != null) {
            _hashCode += getMethod().hashCode();
        }
        if (getProbeType() != null) {
            _hashCode += getProbeType().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(NormalizeMethodParameter.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://org.bioconductor.cabig/1.0/org.bioconductor.cagrid.caaffy", "NormalizeMethodParameter"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("method");
        elemField.setXmlName(new javax.xml.namespace.QName("", "method"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://org.bioconductor.cabig/1.0/org.bioconductor.cagrid.caaffy.valuedomain", "NormalizeMethod"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("probeType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "probeType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://org.bioconductor.cabig/1.0/org.bioconductor.cagrid.caaffy.valuedomain", "ProbeType"));
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
