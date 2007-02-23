/**
 * BackgroundCorrectMethod.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC2 Apr 28, 2006 (12:42:00 EDT) WSDL2Java emitter.
 */

package org.bioconductor.cagrid.caaffy.valuedomain;

public class BackgroundCorrectMethod  implements java.io.Serializable {
    private java.lang.String mas;
    private java.lang.String none;
    private java.lang.String rma;
    private java.lang.String rma2;

    public BackgroundCorrectMethod() {
    }

    public BackgroundCorrectMethod(
           java.lang.String mas,
           java.lang.String none,
           java.lang.String rma,
           java.lang.String rma2) {
           this.mas = mas;
           this.none = none;
           this.rma = rma;
           this.rma2 = rma2;
    }


    /**
     * Gets the mas value for this BackgroundCorrectMethod.
     * 
     * @return mas
     */
    public java.lang.String getMas() {
        return mas;
    }


    /**
     * Sets the mas value for this BackgroundCorrectMethod.
     * 
     * @param mas
     */
    public void setMas(java.lang.String mas) {
        this.mas = mas;
    }


    /**
     * Gets the none value for this BackgroundCorrectMethod.
     * 
     * @return none
     */
    public java.lang.String getNone() {
        return none;
    }


    /**
     * Sets the none value for this BackgroundCorrectMethod.
     * 
     * @param none
     */
    public void setNone(java.lang.String none) {
        this.none = none;
    }


    /**
     * Gets the rma value for this BackgroundCorrectMethod.
     * 
     * @return rma
     */
    public java.lang.String getRma() {
        return rma;
    }


    /**
     * Sets the rma value for this BackgroundCorrectMethod.
     * 
     * @param rma
     */
    public void setRma(java.lang.String rma) {
        this.rma = rma;
    }


    /**
     * Gets the rma2 value for this BackgroundCorrectMethod.
     * 
     * @return rma2
     */
    public java.lang.String getRma2() {
        return rma2;
    }


    /**
     * Sets the rma2 value for this BackgroundCorrectMethod.
     * 
     * @param rma2
     */
    public void setRma2(java.lang.String rma2) {
        this.rma2 = rma2;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BackgroundCorrectMethod)) return false;
        BackgroundCorrectMethod other = (BackgroundCorrectMethod) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.mas==null && other.getMas()==null) || 
             (this.mas!=null &&
              this.mas.equals(other.getMas()))) &&
            ((this.none==null && other.getNone()==null) || 
             (this.none!=null &&
              this.none.equals(other.getNone()))) &&
            ((this.rma==null && other.getRma()==null) || 
             (this.rma!=null &&
              this.rma.equals(other.getRma()))) &&
            ((this.rma2==null && other.getRma2()==null) || 
             (this.rma2!=null &&
              this.rma2.equals(other.getRma2())));
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
        if (getMas() != null) {
            _hashCode += getMas().hashCode();
        }
        if (getNone() != null) {
            _hashCode += getNone().hashCode();
        }
        if (getRma() != null) {
            _hashCode += getRma().hashCode();
        }
        if (getRma2() != null) {
            _hashCode += getRma2().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(BackgroundCorrectMethod.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://org.bioconductor.cabig/1.0/org.bioconductor.cagrid.caaffy.valuedomain", "BackgroundCorrectMethod"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("none");
        elemField.setXmlName(new javax.xml.namespace.QName("", "none"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rma");
        elemField.setXmlName(new javax.xml.namespace.QName("", "rma"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rma2");
        elemField.setXmlName(new javax.xml.namespace.QName("", "rma2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
