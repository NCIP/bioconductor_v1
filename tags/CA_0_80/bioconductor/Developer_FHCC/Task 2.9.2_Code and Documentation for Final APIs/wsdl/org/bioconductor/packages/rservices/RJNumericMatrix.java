/**
 * RJNumericMatrix.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC2 Mar 03, 2006 (12:17:06 EST) WSDL2Java emitter.
 */

package org.bioconductor.packages.rservices;

public class RJNumericMatrix  extends org.bioconductor.packages.rservices.RJMatrix  implements java.io.Serializable {
    private org.bioconductor.rserviceJms.services.caAffy.ArrayOf_xsd_double value;

    public RJNumericMatrix() {
    }

    public RJNumericMatrix(
           org.bioconductor.rserviceJms.services.caAffy.ArrayOf_xsd_double value) {
           this.value = value;
    }


    /**
     * Gets the value value for this RJNumericMatrix.
     * 
     * @return value
     */
    public org.bioconductor.rserviceJms.services.caAffy.ArrayOf_xsd_double getValue() {
        return value;
    }


    /**
     * Sets the value value for this RJNumericMatrix.
     * 
     * @param value
     */
    public void setValue(org.bioconductor.rserviceJms.services.caAffy.ArrayOf_xsd_double value) {
        this.value = value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RJNumericMatrix)) return false;
        RJNumericMatrix other = (RJNumericMatrix) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.value==null && other.getValue()==null) || 
             (this.value!=null &&
              this.value.equals(other.getValue())));
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
        if (getValue() != null) {
            _hashCode += getValue().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RJNumericMatrix.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.bioconductor.org/services/rservices", "RJNumericMatrix"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("value");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.bioconductor.org/services/rservices", "value"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.bioconductor.org/services/caAffy", "ArrayOf_xsd_double"));
        elemField.setNillable(true);
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