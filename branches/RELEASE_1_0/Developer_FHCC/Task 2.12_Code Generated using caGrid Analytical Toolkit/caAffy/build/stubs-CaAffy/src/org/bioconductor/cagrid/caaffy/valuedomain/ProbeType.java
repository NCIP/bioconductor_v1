/**
 * ProbeType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC2 Apr 28, 2006 (12:42:00 EDT) WSDL2Java emitter.
 */

package org.bioconductor.cagrid.caaffy.valuedomain;

public class ProbeType  implements java.io.Serializable {
    private java.lang.String mmOnly;
    private java.lang.String pmOnly;
    private java.lang.String separate;
    private java.lang.String together;

    public ProbeType() {
    }

    public ProbeType(
           java.lang.String mmOnly,
           java.lang.String pmOnly,
           java.lang.String separate,
           java.lang.String together) {
           this.mmOnly = mmOnly;
           this.pmOnly = pmOnly;
           this.separate = separate;
           this.together = together;
    }


    /**
     * Gets the mmOnly value for this ProbeType.
     * 
     * @return mmOnly
     */
    public java.lang.String getMmOnly() {
        return mmOnly;
    }


    /**
     * Sets the mmOnly value for this ProbeType.
     * 
     * @param mmOnly
     */
    public void setMmOnly(java.lang.String mmOnly) {
        this.mmOnly = mmOnly;
    }


    /**
     * Gets the pmOnly value for this ProbeType.
     * 
     * @return pmOnly
     */
    public java.lang.String getPmOnly() {
        return pmOnly;
    }


    /**
     * Sets the pmOnly value for this ProbeType.
     * 
     * @param pmOnly
     */
    public void setPmOnly(java.lang.String pmOnly) {
        this.pmOnly = pmOnly;
    }


    /**
     * Gets the separate value for this ProbeType.
     * 
     * @return separate
     */
    public java.lang.String getSeparate() {
        return separate;
    }


    /**
     * Sets the separate value for this ProbeType.
     * 
     * @param separate
     */
    public void setSeparate(java.lang.String separate) {
        this.separate = separate;
    }


    /**
     * Gets the together value for this ProbeType.
     * 
     * @return together
     */
    public java.lang.String getTogether() {
        return together;
    }


    /**
     * Sets the together value for this ProbeType.
     * 
     * @param together
     */
    public void setTogether(java.lang.String together) {
        this.together = together;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ProbeType)) return false;
        ProbeType other = (ProbeType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.mmOnly==null && other.getMmOnly()==null) || 
             (this.mmOnly!=null &&
              this.mmOnly.equals(other.getMmOnly()))) &&
            ((this.pmOnly==null && other.getPmOnly()==null) || 
             (this.pmOnly!=null &&
              this.pmOnly.equals(other.getPmOnly()))) &&
            ((this.separate==null && other.getSeparate()==null) || 
             (this.separate!=null &&
              this.separate.equals(other.getSeparate()))) &&
            ((this.together==null && other.getTogether()==null) || 
             (this.together!=null &&
              this.together.equals(other.getTogether())));
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
        if (getMmOnly() != null) {
            _hashCode += getMmOnly().hashCode();
        }
        if (getPmOnly() != null) {
            _hashCode += getPmOnly().hashCode();
        }
        if (getSeparate() != null) {
            _hashCode += getSeparate().hashCode();
        }
        if (getTogether() != null) {
            _hashCode += getTogether().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ProbeType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://org.bioconductor.cabig/1.0/org.bioconductor.cagrid.caaffy.valuedomain", "ProbeType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mmOnly");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mmOnly"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pmOnly");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pmOnly"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("separate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "separate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("together");
        elemField.setXmlName(new javax.xml.namespace.QName("", "together"));
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
