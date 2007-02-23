/**
 * PROcessParameter.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC2 Apr 28, 2006 (12:42:00 EDT) WSDL2Java emitter.
 */

package org.bioconductor.cagrid.caprocess;

public class PROcessParameter  implements java.io.Serializable {
    private double peakAreaNeighborhood;
    private double peakAreaRetention;
    private double peakSignalToNoiseCutoff;
    private double peakSmoothingSpan;
    private double peakVarianceDetectionSpan;
    private double peakZeroCutoff;
    private double renormalizationCutoff;

    public PROcessParameter() {
    }

    public PROcessParameter(
           double peakAreaNeighborhood,
           double peakAreaRetention,
           double peakSignalToNoiseCutoff,
           double peakSmoothingSpan,
           double peakVarianceDetectionSpan,
           double peakZeroCutoff,
           double renormalizationCutoff) {
           this.peakAreaNeighborhood = peakAreaNeighborhood;
           this.peakAreaRetention = peakAreaRetention;
           this.peakSignalToNoiseCutoff = peakSignalToNoiseCutoff;
           this.peakSmoothingSpan = peakSmoothingSpan;
           this.peakVarianceDetectionSpan = peakVarianceDetectionSpan;
           this.peakZeroCutoff = peakZeroCutoff;
           this.renormalizationCutoff = renormalizationCutoff;
    }


    /**
     * Gets the peakAreaNeighborhood value for this PROcessParameter.
     * 
     * @return peakAreaNeighborhood
     */
    public double getPeakAreaNeighborhood() {
        return peakAreaNeighborhood;
    }


    /**
     * Sets the peakAreaNeighborhood value for this PROcessParameter.
     * 
     * @param peakAreaNeighborhood
     */
    public void setPeakAreaNeighborhood(double peakAreaNeighborhood) {
        this.peakAreaNeighborhood = peakAreaNeighborhood;
    }


    /**
     * Gets the peakAreaRetention value for this PROcessParameter.
     * 
     * @return peakAreaRetention
     */
    public double getPeakAreaRetention() {
        return peakAreaRetention;
    }


    /**
     * Sets the peakAreaRetention value for this PROcessParameter.
     * 
     * @param peakAreaRetention
     */
    public void setPeakAreaRetention(double peakAreaRetention) {
        this.peakAreaRetention = peakAreaRetention;
    }


    /**
     * Gets the peakSignalToNoiseCutoff value for this PROcessParameter.
     * 
     * @return peakSignalToNoiseCutoff
     */
    public double getPeakSignalToNoiseCutoff() {
        return peakSignalToNoiseCutoff;
    }


    /**
     * Sets the peakSignalToNoiseCutoff value for this PROcessParameter.
     * 
     * @param peakSignalToNoiseCutoff
     */
    public void setPeakSignalToNoiseCutoff(double peakSignalToNoiseCutoff) {
        this.peakSignalToNoiseCutoff = peakSignalToNoiseCutoff;
    }


    /**
     * Gets the peakSmoothingSpan value for this PROcessParameter.
     * 
     * @return peakSmoothingSpan
     */
    public double getPeakSmoothingSpan() {
        return peakSmoothingSpan;
    }


    /**
     * Sets the peakSmoothingSpan value for this PROcessParameter.
     * 
     * @param peakSmoothingSpan
     */
    public void setPeakSmoothingSpan(double peakSmoothingSpan) {
        this.peakSmoothingSpan = peakSmoothingSpan;
    }


    /**
     * Gets the peakVarianceDetectionSpan value for this PROcessParameter.
     * 
     * @return peakVarianceDetectionSpan
     */
    public double getPeakVarianceDetectionSpan() {
        return peakVarianceDetectionSpan;
    }


    /**
     * Sets the peakVarianceDetectionSpan value for this PROcessParameter.
     * 
     * @param peakVarianceDetectionSpan
     */
    public void setPeakVarianceDetectionSpan(double peakVarianceDetectionSpan) {
        this.peakVarianceDetectionSpan = peakVarianceDetectionSpan;
    }


    /**
     * Gets the peakZeroCutoff value for this PROcessParameter.
     * 
     * @return peakZeroCutoff
     */
    public double getPeakZeroCutoff() {
        return peakZeroCutoff;
    }


    /**
     * Sets the peakZeroCutoff value for this PROcessParameter.
     * 
     * @param peakZeroCutoff
     */
    public void setPeakZeroCutoff(double peakZeroCutoff) {
        this.peakZeroCutoff = peakZeroCutoff;
    }


    /**
     * Gets the renormalizationCutoff value for this PROcessParameter.
     * 
     * @return renormalizationCutoff
     */
    public double getRenormalizationCutoff() {
        return renormalizationCutoff;
    }


    /**
     * Sets the renormalizationCutoff value for this PROcessParameter.
     * 
     * @param renormalizationCutoff
     */
    public void setRenormalizationCutoff(double renormalizationCutoff) {
        this.renormalizationCutoff = renormalizationCutoff;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PROcessParameter)) return false;
        PROcessParameter other = (PROcessParameter) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.peakAreaNeighborhood == other.getPeakAreaNeighborhood() &&
            this.peakAreaRetention == other.getPeakAreaRetention() &&
            this.peakSignalToNoiseCutoff == other.getPeakSignalToNoiseCutoff() &&
            this.peakSmoothingSpan == other.getPeakSmoothingSpan() &&
            this.peakVarianceDetectionSpan == other.getPeakVarianceDetectionSpan() &&
            this.peakZeroCutoff == other.getPeakZeroCutoff() &&
            this.renormalizationCutoff == other.getRenormalizationCutoff();
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
        _hashCode += new Double(getPeakAreaNeighborhood()).hashCode();
        _hashCode += new Double(getPeakAreaRetention()).hashCode();
        _hashCode += new Double(getPeakSignalToNoiseCutoff()).hashCode();
        _hashCode += new Double(getPeakSmoothingSpan()).hashCode();
        _hashCode += new Double(getPeakVarianceDetectionSpan()).hashCode();
        _hashCode += new Double(getPeakZeroCutoff()).hashCode();
        _hashCode += new Double(getRenormalizationCutoff()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PROcessParameter.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://org.bioconductor.cabig/1.0/org.bioconductor.cagrid.caprocess", "PROcessParameter"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("peakAreaNeighborhood");
        elemField.setXmlName(new javax.xml.namespace.QName("", "peakAreaNeighborhood"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("peakAreaRetention");
        elemField.setXmlName(new javax.xml.namespace.QName("", "peakAreaRetention"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("peakSignalToNoiseCutoff");
        elemField.setXmlName(new javax.xml.namespace.QName("", "peakSignalToNoiseCutoff"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("peakSmoothingSpan");
        elemField.setXmlName(new javax.xml.namespace.QName("", "peakSmoothingSpan"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("peakVarianceDetectionSpan");
        elemField.setXmlName(new javax.xml.namespace.QName("", "peakVarianceDetectionSpan"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("peakZeroCutoff");
        elemField.setXmlName(new javax.xml.namespace.QName("", "peakZeroCutoff"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("renormalizationCutoff");
        elemField.setXmlName(new javax.xml.namespace.QName("", "renormalizationCutoff"));
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
