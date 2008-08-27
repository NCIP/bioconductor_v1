/**
 * BaselineType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC2 Apr 28, 2006 (12:42:00 EDT) WSDL2Java emitter.
 */

package org.bioconductor.cagrid.caaffy.valuedomain;

public class BaselineType  implements java.io.Serializable {
    private java.lang.String mean;
    private java.lang.String median;
    private java.lang.String psuedoMean;
    private java.lang.String psuedoMedian;

    public BaselineType() {
    }

    public BaselineType(
           java.lang.String mean,
           java.lang.String median,
           java.lang.String psuedoMean,
           java.lang.String psuedoMedian) {
           this.mean = mean;
           this.median = median;
           this.psuedoMean = psuedoMean;
           this.psuedoMedian = psuedoMedian;
    }


    /**
     * Gets the mean value for this BaselineType.
     * 
     * @return mean
     */
    public java.lang.String getMean() {
        return mean;
    }


    /**
     * Sets the mean value for this BaselineType.
     * 
     * @param mean
     */
    public void setMean(java.lang.String mean) {
        this.mean = mean;
    }


    /**
     * Gets the median value for this BaselineType.
     * 
     * @return median
     */
    public java.lang.String getMedian() {
        return median;
    }


    /**
     * Sets the median value for this BaselineType.
     * 
     * @param median
     */
    public void setMedian(java.lang.String median) {
        this.median = median;
    }


    /**
     * Gets the psuedoMean value for this BaselineType.
     * 
     * @return psuedoMean
     */
    public java.lang.String getPsuedoMean() {
        return psuedoMean;
    }


    /**
     * Sets the psuedoMean value for this BaselineType.
     * 
     * @param psuedoMean
     */
    public void setPsuedoMean(java.lang.String psuedoMean) {
        this.psuedoMean = psuedoMean;
    }


    /**
     * Gets the psuedoMedian value for this BaselineType.
     * 
     * @return psuedoMedian
     */
    public java.lang.String getPsuedoMedian() {
        return psuedoMedian;
    }


    /**
     * Sets the psuedoMedian value for this BaselineType.
     * 
     * @param psuedoMedian
     */
    public void setPsuedoMedian(java.lang.String psuedoMedian) {
        this.psuedoMedian = psuedoMedian;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BaselineType)) return false;
        BaselineType other = (BaselineType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.mean==null && other.getMean()==null) || 
             (this.mean!=null &&
              this.mean.equals(other.getMean()))) &&
            ((this.median==null && other.getMedian()==null) || 
             (this.median!=null &&
              this.median.equals(other.getMedian()))) &&
            ((this.psuedoMean==null && other.getPsuedoMean()==null) || 
             (this.psuedoMean!=null &&
              this.psuedoMean.equals(other.getPsuedoMean()))) &&
            ((this.psuedoMedian==null && other.getPsuedoMedian()==null) || 
             (this.psuedoMedian!=null &&
              this.psuedoMedian.equals(other.getPsuedoMedian())));
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
        if (getMean() != null) {
            _hashCode += getMean().hashCode();
        }
        if (getMedian() != null) {
            _hashCode += getMedian().hashCode();
        }
        if (getPsuedoMean() != null) {
            _hashCode += getPsuedoMean().hashCode();
        }
        if (getPsuedoMedian() != null) {
            _hashCode += getPsuedoMedian().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(BaselineType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://org.bioconductor.cabig/1.0/org.bioconductor.cagrid.caaffy.valuedomain", "BaselineType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mean");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mean"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("median");
        elemField.setXmlName(new javax.xml.namespace.QName("", "median"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("psuedoMean");
        elemField.setXmlName(new javax.xml.namespace.QName("", "psuedoMean"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("psuedoMedian");
        elemField.setXmlName(new javax.xml.namespace.QName("", "psuedoMedian"));
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
