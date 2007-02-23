/**
 * NormalizeInvariantSetParameter.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC2 Apr 28, 2006 (12:42:00 EDT) WSDL2Java emitter.
 */

package org.bioconductor.cagrid.caaffy;

public class NormalizeInvariantSetParameter  extends org.bioconductor.cagrid.caaffy.NormalizeMethodParameter  implements java.io.Serializable {
    private org.bioconductor.cagrid.caaffy.valuedomain.BaselineType baselineType;

    public NormalizeInvariantSetParameter() {
    }

    public NormalizeInvariantSetParameter(
           org.bioconductor.cagrid.caaffy.valuedomain.BaselineType baselineType) {
           this.baselineType = baselineType;
    }


    /**
     * Gets the baselineType value for this NormalizeInvariantSetParameter.
     * 
     * @return baselineType
     */
    public org.bioconductor.cagrid.caaffy.valuedomain.BaselineType getBaselineType() {
        return baselineType;
    }


    /**
     * Sets the baselineType value for this NormalizeInvariantSetParameter.
     * 
     * @param baselineType
     */
    public void setBaselineType(org.bioconductor.cagrid.caaffy.valuedomain.BaselineType baselineType) {
        this.baselineType = baselineType;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof NormalizeInvariantSetParameter)) return false;
        NormalizeInvariantSetParameter other = (NormalizeInvariantSetParameter) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.baselineType==null && other.getBaselineType()==null) || 
             (this.baselineType!=null &&
              this.baselineType.equals(other.getBaselineType())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getBaselineType() != null) {
            _hashCode += getBaselineType().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(NormalizeInvariantSetParameter.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://org.bioconductor.cabig/1.0/org.bioconductor.cagrid.caaffy", "NormalizeInvariantSetParameter"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("baselineType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "baselineType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://org.bioconductor.cabig/1.0/org.bioconductor.cagrid.caaffy.valuedomain", "BaselineType"));
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
