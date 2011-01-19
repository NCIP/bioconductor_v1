/**
 * Targets.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC2 Apr 28, 2006 (12:42:00 EDT) WSDL2Java emitter.
 */

package org.bioconductor.cagrid.caisalmon;

public class Targets  implements java.io.Serializable {
    private java.lang.String[] condition;
    private java.lang.String[] fileName;

    public Targets() {
    }

    public Targets(
           java.lang.String[] condition,
           java.lang.String[] fileName) {
           this.condition = condition;
           this.fileName = fileName;
    }


    /**
     * Gets the condition value for this Targets.
     * 
     * @return condition
     */
    public java.lang.String[] getCondition() {
        return condition;
    }


    /**
     * Sets the condition value for this Targets.
     * 
     * @param condition
     */
    public void setCondition(java.lang.String[] condition) {
        this.condition = condition;
    }

    public java.lang.String getCondition(int i) {
        return this.condition[i];
    }

    public void setCondition(int i, java.lang.String _value) {
        this.condition[i] = _value;
    }


    /**
     * Gets the fileName value for this Targets.
     * 
     * @return fileName
     */
    public java.lang.String[] getFileName() {
        return fileName;
    }


    /**
     * Sets the fileName value for this Targets.
     * 
     * @param fileName
     */
    public void setFileName(java.lang.String[] fileName) {
        this.fileName = fileName;
    }

    public java.lang.String getFileName(int i) {
        return this.fileName[i];
    }

    public void setFileName(int i, java.lang.String _value) {
        this.fileName[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Targets)) return false;
        Targets other = (Targets) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.condition==null && other.getCondition()==null) || 
             (this.condition!=null &&
              java.util.Arrays.equals(this.condition, other.getCondition()))) &&
            ((this.fileName==null && other.getFileName()==null) || 
             (this.fileName!=null &&
              java.util.Arrays.equals(this.fileName, other.getFileName())));
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
        if (getCondition() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCondition());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCondition(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getFileName() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getFileName());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getFileName(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Targets.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://org.bioconductor.cabig/1.0/org.bioconductor.cagrid.caisalmon", "Targets"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("condition");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Condition"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fileName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "FileName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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
