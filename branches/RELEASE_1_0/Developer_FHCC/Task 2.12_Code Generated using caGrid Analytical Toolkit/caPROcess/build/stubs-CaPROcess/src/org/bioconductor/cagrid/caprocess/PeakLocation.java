/**
 * PeakLocation.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC2 Apr 28, 2006 (12:42:00 EDT) WSDL2Java emitter.
 */

package org.bioconductor.cagrid.caprocess;

public class PeakLocation  implements java.io.Serializable {
    private int[] peakNumberInSpectrum;
    private double[] relativeIntensity;
    private int[] spectrumId;
    private java.lang.String[] spectrumName;
    private double[] substanceMassAtIntensity;

    public PeakLocation() {
    }

    public PeakLocation(
           int[] peakNumberInSpectrum,
           double[] relativeIntensity,
           int[] spectrumId,
           java.lang.String[] spectrumName,
           double[] substanceMassAtIntensity) {
           this.peakNumberInSpectrum = peakNumberInSpectrum;
           this.relativeIntensity = relativeIntensity;
           this.spectrumId = spectrumId;
           this.spectrumName = spectrumName;
           this.substanceMassAtIntensity = substanceMassAtIntensity;
    }


    /**
     * Gets the peakNumberInSpectrum value for this PeakLocation.
     * 
     * @return peakNumberInSpectrum
     */
    public int[] getPeakNumberInSpectrum() {
        return peakNumberInSpectrum;
    }


    /**
     * Sets the peakNumberInSpectrum value for this PeakLocation.
     * 
     * @param peakNumberInSpectrum
     */
    public void setPeakNumberInSpectrum(int[] peakNumberInSpectrum) {
        this.peakNumberInSpectrum = peakNumberInSpectrum;
    }

    public int getPeakNumberInSpectrum(int i) {
        return this.peakNumberInSpectrum[i];
    }

    public void setPeakNumberInSpectrum(int i, int _value) {
        this.peakNumberInSpectrum[i] = _value;
    }


    /**
     * Gets the relativeIntensity value for this PeakLocation.
     * 
     * @return relativeIntensity
     */
    public double[] getRelativeIntensity() {
        return relativeIntensity;
    }


    /**
     * Sets the relativeIntensity value for this PeakLocation.
     * 
     * @param relativeIntensity
     */
    public void setRelativeIntensity(double[] relativeIntensity) {
        this.relativeIntensity = relativeIntensity;
    }

    public double getRelativeIntensity(int i) {
        return this.relativeIntensity[i];
    }

    public void setRelativeIntensity(int i, double _value) {
        this.relativeIntensity[i] = _value;
    }


    /**
     * Gets the spectrumId value for this PeakLocation.
     * 
     * @return spectrumId
     */
    public int[] getSpectrumId() {
        return spectrumId;
    }


    /**
     * Sets the spectrumId value for this PeakLocation.
     * 
     * @param spectrumId
     */
    public void setSpectrumId(int[] spectrumId) {
        this.spectrumId = spectrumId;
    }

    public int getSpectrumId(int i) {
        return this.spectrumId[i];
    }

    public void setSpectrumId(int i, int _value) {
        this.spectrumId[i] = _value;
    }


    /**
     * Gets the spectrumName value for this PeakLocation.
     * 
     * @return spectrumName
     */
    public java.lang.String[] getSpectrumName() {
        return spectrumName;
    }


    /**
     * Sets the spectrumName value for this PeakLocation.
     * 
     * @param spectrumName
     */
    public void setSpectrumName(java.lang.String[] spectrumName) {
        this.spectrumName = spectrumName;
    }

    public java.lang.String getSpectrumName(int i) {
        return this.spectrumName[i];
    }

    public void setSpectrumName(int i, java.lang.String _value) {
        this.spectrumName[i] = _value;
    }


    /**
     * Gets the substanceMassAtIntensity value for this PeakLocation.
     * 
     * @return substanceMassAtIntensity
     */
    public double[] getSubstanceMassAtIntensity() {
        return substanceMassAtIntensity;
    }


    /**
     * Sets the substanceMassAtIntensity value for this PeakLocation.
     * 
     * @param substanceMassAtIntensity
     */
    public void setSubstanceMassAtIntensity(double[] substanceMassAtIntensity) {
        this.substanceMassAtIntensity = substanceMassAtIntensity;
    }

    public double getSubstanceMassAtIntensity(int i) {
        return this.substanceMassAtIntensity[i];
    }

    public void setSubstanceMassAtIntensity(int i, double _value) {
        this.substanceMassAtIntensity[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PeakLocation)) return false;
        PeakLocation other = (PeakLocation) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.peakNumberInSpectrum==null && other.getPeakNumberInSpectrum()==null) || 
             (this.peakNumberInSpectrum!=null &&
              java.util.Arrays.equals(this.peakNumberInSpectrum, other.getPeakNumberInSpectrum()))) &&
            ((this.relativeIntensity==null && other.getRelativeIntensity()==null) || 
             (this.relativeIntensity!=null &&
              java.util.Arrays.equals(this.relativeIntensity, other.getRelativeIntensity()))) &&
            ((this.spectrumId==null && other.getSpectrumId()==null) || 
             (this.spectrumId!=null &&
              java.util.Arrays.equals(this.spectrumId, other.getSpectrumId()))) &&
            ((this.spectrumName==null && other.getSpectrumName()==null) || 
             (this.spectrumName!=null &&
              java.util.Arrays.equals(this.spectrumName, other.getSpectrumName()))) &&
            ((this.substanceMassAtIntensity==null && other.getSubstanceMassAtIntensity()==null) || 
             (this.substanceMassAtIntensity!=null &&
              java.util.Arrays.equals(this.substanceMassAtIntensity, other.getSubstanceMassAtIntensity())));
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
        if (getPeakNumberInSpectrum() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPeakNumberInSpectrum());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPeakNumberInSpectrum(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getRelativeIntensity() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getRelativeIntensity());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getRelativeIntensity(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getSpectrumId() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSpectrumId());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSpectrumId(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getSpectrumName() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSpectrumName());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSpectrumName(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getSubstanceMassAtIntensity() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSubstanceMassAtIntensity());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSubstanceMassAtIntensity(), i);
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
        new org.apache.axis.description.TypeDesc(PeakLocation.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://org.bioconductor.cabig/1.0/org.bioconductor.cagrid.caprocess", "PeakLocation"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("peakNumberInSpectrum");
        elemField.setXmlName(new javax.xml.namespace.QName("", "peakNumberInSpectrum"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("relativeIntensity");
        elemField.setXmlName(new javax.xml.namespace.QName("", "relativeIntensity"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("spectrumId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "spectrumId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("spectrumName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "spectrumName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("substanceMassAtIntensity");
        elemField.setXmlName(new javax.xml.namespace.QName("", "substanceMassAtIntensity"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
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
