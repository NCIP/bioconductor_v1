/**
 * RJComplex.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC2 Mar 03, 2006 (12:17:06 EST) WSDL2Java emitter.
 */

package org.bioconductor.packages.rservices;

public class RJComplex  implements java.io.Serializable {
    private org.bioconductor.rserviceJms.services.caAffy.ArrayOf_xsd_double imaginary;
    private org.bioconductor.rserviceJms.services.caAffy.ArrayOf_xsd_double real;

    public RJComplex() {
    }

    public RJComplex(
           org.bioconductor.rserviceJms.services.caAffy.ArrayOf_xsd_double imaginary,
           org.bioconductor.rserviceJms.services.caAffy.ArrayOf_xsd_double real) {
           this.imaginary = imaginary;
           this.real = real;
    }


    /**
     * Gets the imaginary value for this RJComplex.
     * 
     * @return imaginary
     */
    public org.bioconductor.rserviceJms.services.caAffy.ArrayOf_xsd_double getImaginary() {
        return imaginary;
    }


    /**
     * Sets the imaginary value for this RJComplex.
     * 
     * @param imaginary
     */
    public void setImaginary(org.bioconductor.rserviceJms.services.caAffy.ArrayOf_xsd_double imaginary) {
        this.imaginary = imaginary;
    }


    /**
     * Gets the real value for this RJComplex.
     * 
     * @return real
     */
    public org.bioconductor.rserviceJms.services.caAffy.ArrayOf_xsd_double getReal() {
        return real;
    }


    /**
     * Sets the real value for this RJComplex.
     * 
     * @param real
     */
    public void setReal(org.bioconductor.rserviceJms.services.caAffy.ArrayOf_xsd_double real) {
        this.real = real;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RJComplex)) return false;
        RJComplex other = (RJComplex) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.imaginary==null && other.getImaginary()==null) || 
             (this.imaginary!=null &&
              this.imaginary.equals(other.getImaginary()))) &&
            ((this.real==null && other.getReal()==null) || 
             (this.real!=null &&
              this.real.equals(other.getReal())));
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
        if (getImaginary() != null) {
            _hashCode += getImaginary().hashCode();
        }
        if (getReal() != null) {
            _hashCode += getReal().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RJComplex.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.bioconductor.org/services/rservices", "RJComplex"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("imaginary");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.bioconductor.org/services/rservices", "imaginary"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.bioconductor.org/services/caAffy", "ArrayOf_xsd_double"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("real");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.bioconductor.org/services/rservices", "real"));
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
