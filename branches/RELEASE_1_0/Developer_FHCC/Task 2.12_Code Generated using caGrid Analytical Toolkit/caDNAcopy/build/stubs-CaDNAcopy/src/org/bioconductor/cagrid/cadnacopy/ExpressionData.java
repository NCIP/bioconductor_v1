/**
 * ExpressionData.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC2 Apr 28, 2006 (12:42:00 EDT) WSDL2Java emitter.
 */

package org.bioconductor.cagrid.cadnacopy;

public class ExpressionData  implements java.io.Serializable {
    private double[] logRatioValues;
    private java.lang.String sampleId;

    public ExpressionData() {
    }

    public ExpressionData(
           double[] logRatioValues,
           java.lang.String sampleId) {
           this.logRatioValues = logRatioValues;
           this.sampleId = sampleId;
    }


    /**
     * Gets the logRatioValues value for this ExpressionData.
     * 
     * @return logRatioValues
     */
    public double[] getLogRatioValues() {
        return logRatioValues;
    }


    /**
     * Sets the logRatioValues value for this ExpressionData.
     * 
     * @param logRatioValues
     */
    public void setLogRatioValues(double[] logRatioValues) {
        this.logRatioValues = logRatioValues;
    }

    public double getLogRatioValues(int i) {
        return this.logRatioValues[i];
    }

    public void setLogRatioValues(int i, double _value) {
        this.logRatioValues[i] = _value;
    }


    /**
     * Gets the sampleId value for this ExpressionData.
     * 
     * @return sampleId
     */
    public java.lang.String getSampleId() {
        return sampleId;
    }


    /**
     * Sets the sampleId value for this ExpressionData.
     * 
     * @param sampleId
     */
    public void setSampleId(java.lang.String sampleId) {
        this.sampleId = sampleId;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ExpressionData)) return false;
        ExpressionData other = (ExpressionData) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.logRatioValues==null && other.getLogRatioValues()==null) || 
             (this.logRatioValues!=null &&
              java.util.Arrays.equals(this.logRatioValues, other.getLogRatioValues()))) &&
            ((this.sampleId==null && other.getSampleId()==null) || 
             (this.sampleId!=null &&
              this.sampleId.equals(other.getSampleId())));
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
        if (getLogRatioValues() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getLogRatioValues());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getLogRatioValues(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getSampleId() != null) {
            _hashCode += getSampleId().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ExpressionData.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://org.bioconductor.cabig/1.0/org.bioconductor.cagrid.cadnacopy", "ExpressionData"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("logRatioValues");
        elemField.setXmlName(new javax.xml.namespace.QName("", "logRatioValues"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sampleId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sampleId"));
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
