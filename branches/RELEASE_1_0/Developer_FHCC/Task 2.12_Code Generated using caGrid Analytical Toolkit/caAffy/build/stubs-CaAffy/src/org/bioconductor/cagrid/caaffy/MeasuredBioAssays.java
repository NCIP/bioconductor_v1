/**
 * MeasuredBioAssays.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC2 Apr 28, 2006 (12:42:00 EDT) WSDL2Java emitter.
 */

package org.bioconductor.cagrid.caaffy;

public class MeasuredBioAssays  implements java.io.Serializable {
    private gov.nih.nci.mageom.domain.bioassaydata.MeasuredBioAssayData[] measuredBioAssayDataCollection;

    public MeasuredBioAssays() {
    }

    public MeasuredBioAssays(
           gov.nih.nci.mageom.domain.bioassaydata.MeasuredBioAssayData[] measuredBioAssayDataCollection) {
           this.measuredBioAssayDataCollection = measuredBioAssayDataCollection;
    }


    /**
     * Gets the measuredBioAssayDataCollection value for this MeasuredBioAssays.
     * 
     * @return measuredBioAssayDataCollection
     */
    public gov.nih.nci.mageom.domain.bioassaydata.MeasuredBioAssayData[] getMeasuredBioAssayDataCollection() {
        return measuredBioAssayDataCollection;
    }


    /**
     * Sets the measuredBioAssayDataCollection value for this MeasuredBioAssays.
     * 
     * @param measuredBioAssayDataCollection
     */
    public void setMeasuredBioAssayDataCollection(gov.nih.nci.mageom.domain.bioassaydata.MeasuredBioAssayData[] measuredBioAssayDataCollection) {
        this.measuredBioAssayDataCollection = measuredBioAssayDataCollection;
    }

    public gov.nih.nci.mageom.domain.bioassaydata.MeasuredBioAssayData getMeasuredBioAssayDataCollection(int i) {
        return this.measuredBioAssayDataCollection[i];
    }

    public void setMeasuredBioAssayDataCollection(int i, gov.nih.nci.mageom.domain.bioassaydata.MeasuredBioAssayData _value) {
        this.measuredBioAssayDataCollection[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MeasuredBioAssays)) return false;
        MeasuredBioAssays other = (MeasuredBioAssays) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.measuredBioAssayDataCollection==null && other.getMeasuredBioAssayDataCollection()==null) || 
             (this.measuredBioAssayDataCollection!=null &&
              java.util.Arrays.equals(this.measuredBioAssayDataCollection, other.getMeasuredBioAssayDataCollection())));
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
        if (getMeasuredBioAssayDataCollection() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMeasuredBioAssayDataCollection());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMeasuredBioAssayDataCollection(), i);
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
        new org.apache.axis.description.TypeDesc(MeasuredBioAssays.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://org.bioconductor.cabig/1.0/org.bioconductor.cagrid.caaffy", "MeasuredBioAssays"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("measuredBioAssayDataCollection");
        elemField.setXmlName(new javax.xml.namespace.QName("", "measuredBioAssayDataCollection"));
        elemField.setXmlType(new javax.xml.namespace.QName("gme://caArray.caBIG/1.1/gov.nih.nci.mageom.domain.BioAssayData", "MeasuredBioAssayData"));
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
