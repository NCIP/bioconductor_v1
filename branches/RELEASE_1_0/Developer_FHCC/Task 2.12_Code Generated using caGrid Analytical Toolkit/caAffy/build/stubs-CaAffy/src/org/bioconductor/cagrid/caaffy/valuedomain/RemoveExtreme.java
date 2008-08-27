/**
 * RemoveExtreme.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC2 Apr 28, 2006 (12:42:00 EDT) WSDL2Java emitter.
 */

package org.bioconductor.cagrid.caaffy.valuedomain;

public class RemoveExtreme  implements java.io.Serializable {
    private java.lang.String both;
    private java.lang.String mean;
    private java.lang.String variance;

    public RemoveExtreme() {
    }

    public RemoveExtreme(
           java.lang.String both,
           java.lang.String mean,
           java.lang.String variance) {
           this.both = both;
           this.mean = mean;
           this.variance = variance;
    }


    /**
     * Gets the both value for this RemoveExtreme.
     * 
     * @return both
     */
    public java.lang.String getBoth() {
        return both;
    }


    /**
     * Sets the both value for this RemoveExtreme.
     * 
     * @param both
     */
    public void setBoth(java.lang.String both) {
        this.both = both;
    }


    /**
     * Gets the mean value for this RemoveExtreme.
     * 
     * @return mean
     */
    public java.lang.String getMean() {
        return mean;
    }


    /**
     * Sets the mean value for this RemoveExtreme.
     * 
     * @param mean
     */
    public void setMean(java.lang.String mean) {
        this.mean = mean;
    }


    /**
     * Gets the variance value for this RemoveExtreme.
     * 
     * @return variance
     */
    public java.lang.String getVariance() {
        return variance;
    }


    /**
     * Sets the variance value for this RemoveExtreme.
     * 
     * @param variance
     */
    public void setVariance(java.lang.String variance) {
        this.variance = variance;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RemoveExtreme)) return false;
        RemoveExtreme other = (RemoveExtreme) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.both==null && other.getBoth()==null) || 
             (this.both!=null &&
              this.both.equals(other.getBoth()))) &&
            ((this.mean==null && other.getMean()==null) || 
             (this.mean!=null &&
              this.mean.equals(other.getMean()))) &&
            ((this.variance==null && other.getVariance()==null) || 
             (this.variance!=null &&
              this.variance.equals(other.getVariance())));
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
        if (getBoth() != null) {
            _hashCode += getBoth().hashCode();
        }
        if (getMean() != null) {
            _hashCode += getMean().hashCode();
        }
        if (getVariance() != null) {
            _hashCode += getVariance().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RemoveExtreme.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://org.bioconductor.cabig/1.0/org.bioconductor.cagrid.caaffy.valuedomain", "RemoveExtreme"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("both");
        elemField.setXmlName(new javax.xml.namespace.QName("", "both"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mean");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mean"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("variance");
        elemField.setXmlName(new javax.xml.namespace.QName("", "variance"));
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
