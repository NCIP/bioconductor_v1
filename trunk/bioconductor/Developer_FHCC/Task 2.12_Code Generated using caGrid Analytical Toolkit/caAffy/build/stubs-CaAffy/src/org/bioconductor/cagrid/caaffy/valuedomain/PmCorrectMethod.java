/**
 * PmCorrectMethod.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC2 Apr 28, 2006 (12:42:00 EDT) WSDL2Java emitter.
 */

package org.bioconductor.cagrid.caaffy.valuedomain;

public class PmCorrectMethod  implements java.io.Serializable {
    private java.lang.String mas;
    private java.lang.String pmOnly;
    private java.lang.String subtractMm;

    public PmCorrectMethod() {
    }

    public PmCorrectMethod(
           java.lang.String mas,
           java.lang.String pmOnly,
           java.lang.String subtractMm) {
           this.mas = mas;
           this.pmOnly = pmOnly;
           this.subtractMm = subtractMm;
    }


    /**
     * Gets the mas value for this PmCorrectMethod.
     * 
     * @return mas
     */
    public java.lang.String getMas() {
        return mas;
    }


    /**
     * Sets the mas value for this PmCorrectMethod.
     * 
     * @param mas
     */
    public void setMas(java.lang.String mas) {
        this.mas = mas;
    }


    /**
     * Gets the pmOnly value for this PmCorrectMethod.
     * 
     * @return pmOnly
     */
    public java.lang.String getPmOnly() {
        return pmOnly;
    }


    /**
     * Sets the pmOnly value for this PmCorrectMethod.
     * 
     * @param pmOnly
     */
    public void setPmOnly(java.lang.String pmOnly) {
        this.pmOnly = pmOnly;
    }


    /**
     * Gets the subtractMm value for this PmCorrectMethod.
     * 
     * @return subtractMm
     */
    public java.lang.String getSubtractMm() {
        return subtractMm;
    }


    /**
     * Sets the subtractMm value for this PmCorrectMethod.
     * 
     * @param subtractMm
     */
    public void setSubtractMm(java.lang.String subtractMm) {
        this.subtractMm = subtractMm;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PmCorrectMethod)) return false;
        PmCorrectMethod other = (PmCorrectMethod) obj;
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
            ((this.pmOnly==null && other.getPmOnly()==null) || 
             (this.pmOnly!=null &&
              this.pmOnly.equals(other.getPmOnly()))) &&
            ((this.subtractMm==null && other.getSubtractMm()==null) || 
             (this.subtractMm!=null &&
              this.subtractMm.equals(other.getSubtractMm())));
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
        if (getPmOnly() != null) {
            _hashCode += getPmOnly().hashCode();
        }
        if (getSubtractMm() != null) {
            _hashCode += getSubtractMm().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PmCorrectMethod.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://org.bioconductor.cabig/1.0/org.bioconductor.cagrid.caaffy.valuedomain", "PmCorrectMethod"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pmOnly");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pmOnly"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subtractMm");
        elemField.setXmlName(new javax.xml.namespace.QName("", "subtractMm"));
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
