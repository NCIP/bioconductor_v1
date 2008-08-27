/**
 * MzSpectrum.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC2 Apr 28, 2006 (12:42:00 EDT) WSDL2Java emitter.
 */

package org.bioconductor.cagrid.caprocess;

public class MzSpectrum  implements java.io.Serializable {
    private double[] intensity;
    private double[] mzRatio;
    private java.lang.String spectrumName;

    public MzSpectrum() {
    }

    public MzSpectrum(
           double[] intensity,
           double[] mzRatio,
           java.lang.String spectrumName) {
           this.intensity = intensity;
           this.mzRatio = mzRatio;
           this.spectrumName = spectrumName;
    }


    /**
     * Gets the intensity value for this MzSpectrum.
     * 
     * @return intensity
     */
    public double[] getIntensity() {
        return intensity;
    }


    /**
     * Sets the intensity value for this MzSpectrum.
     * 
     * @param intensity
     */
    public void setIntensity(double[] intensity) {
        this.intensity = intensity;
    }

    public double getIntensity(int i) {
        return this.intensity[i];
    }

    public void setIntensity(int i, double _value) {
        this.intensity[i] = _value;
    }


    /**
     * Gets the mzRatio value for this MzSpectrum.
     * 
     * @return mzRatio
     */
    public double[] getMzRatio() {
        return mzRatio;
    }


    /**
     * Sets the mzRatio value for this MzSpectrum.
     * 
     * @param mzRatio
     */
    public void setMzRatio(double[] mzRatio) {
        this.mzRatio = mzRatio;
    }

    public double getMzRatio(int i) {
        return this.mzRatio[i];
    }

    public void setMzRatio(int i, double _value) {
        this.mzRatio[i] = _value;
    }


    /**
     * Gets the spectrumName value for this MzSpectrum.
     * 
     * @return spectrumName
     */
    public java.lang.String getSpectrumName() {
        return spectrumName;
    }


    /**
     * Sets the spectrumName value for this MzSpectrum.
     * 
     * @param spectrumName
     */
    public void setSpectrumName(java.lang.String spectrumName) {
        this.spectrumName = spectrumName;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MzSpectrum)) return false;
        MzSpectrum other = (MzSpectrum) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.intensity==null && other.getIntensity()==null) || 
             (this.intensity!=null &&
              java.util.Arrays.equals(this.intensity, other.getIntensity()))) &&
            ((this.mzRatio==null && other.getMzRatio()==null) || 
             (this.mzRatio!=null &&
              java.util.Arrays.equals(this.mzRatio, other.getMzRatio()))) &&
            ((this.spectrumName==null && other.getSpectrumName()==null) || 
             (this.spectrumName!=null &&
              this.spectrumName.equals(other.getSpectrumName())));
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
        if (getIntensity() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIntensity());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIntensity(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getMzRatio() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMzRatio());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMzRatio(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getSpectrumName() != null) {
            _hashCode += getSpectrumName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MzSpectrum.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://org.bioconductor.cabig/1.0/org.bioconductor.cagrid.caprocess", "MzSpectrum"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("intensity");
        elemField.setXmlName(new javax.xml.namespace.QName("", "intensity"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mzRatio");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mzRatio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("spectrumName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "spectrumName"));
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
