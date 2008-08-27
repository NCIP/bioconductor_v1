/**
 * CaExpressoRequestExpressoParameter.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC2 Apr 28, 2006 (12:42:00 EDT) WSDL2Java emitter.
 */

package org.bioconductor.cagrid.caaffy.stubs;

public class CaExpressoRequestExpressoParameter  implements java.io.Serializable {
    private org.bioconductor.cagrid.caaffy.ExpressoParameter expressoParameter;

    public CaExpressoRequestExpressoParameter() {
    }

    public CaExpressoRequestExpressoParameter(
           org.bioconductor.cagrid.caaffy.ExpressoParameter expressoParameter) {
           this.expressoParameter = expressoParameter;
    }


    /**
     * Gets the expressoParameter value for this CaExpressoRequestExpressoParameter.
     * 
     * @return expressoParameter
     */
    public org.bioconductor.cagrid.caaffy.ExpressoParameter getExpressoParameter() {
        return expressoParameter;
    }


    /**
     * Sets the expressoParameter value for this CaExpressoRequestExpressoParameter.
     * 
     * @param expressoParameter
     */
    public void setExpressoParameter(org.bioconductor.cagrid.caaffy.ExpressoParameter expressoParameter) {
        this.expressoParameter = expressoParameter;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CaExpressoRequestExpressoParameter)) return false;
        CaExpressoRequestExpressoParameter other = (CaExpressoRequestExpressoParameter) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.expressoParameter==null && other.getExpressoParameter()==null) || 
             (this.expressoParameter!=null &&
              this.expressoParameter.equals(other.getExpressoParameter())));
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
        if (getExpressoParameter() != null) {
            _hashCode += getExpressoParameter().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CaExpressoRequestExpressoParameter.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://caaffy.cagrid.bioconductor.org/CaAffy", ">>CaExpressoRequest>expressoParameter"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("expressoParameter");
        elemField.setXmlName(new javax.xml.namespace.QName("http://org.bioconductor.cabig/1.0/org.bioconductor.cagrid.caaffy", "ExpressoParameter"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://org.bioconductor.cabig/1.0/org.bioconductor.cagrid.caaffy", "ExpressoParameter"));
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
