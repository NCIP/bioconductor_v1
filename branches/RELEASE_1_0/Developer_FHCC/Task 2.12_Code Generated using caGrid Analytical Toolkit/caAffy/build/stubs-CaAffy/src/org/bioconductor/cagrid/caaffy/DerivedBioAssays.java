/**
 * DerivedBioAssays.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC2 Apr 28, 2006 (12:42:00 EDT) WSDL2Java emitter.
 */

package org.bioconductor.cagrid.caaffy;

public class DerivedBioAssays  implements java.io.Serializable {
    private gov.nih.nci.mageom.domain.bioassaydata.DerivedBioAssayData[] derivedBioAssayData;

    public DerivedBioAssays() {
    }

    public DerivedBioAssays(
           gov.nih.nci.mageom.domain.bioassaydata.DerivedBioAssayData[] derivedBioAssayData) {
           this.derivedBioAssayData = derivedBioAssayData;
    }


    /**
     * Gets the derivedBioAssayData value for this DerivedBioAssays.
     * 
     * @return derivedBioAssayData
     */
    public gov.nih.nci.mageom.domain.bioassaydata.DerivedBioAssayData[] getDerivedBioAssayData() {
        return derivedBioAssayData;
    }


    /**
     * Sets the derivedBioAssayData value for this DerivedBioAssays.
     * 
     * @param derivedBioAssayData
     */
    public void setDerivedBioAssayData(gov.nih.nci.mageom.domain.bioassaydata.DerivedBioAssayData[] derivedBioAssayData) {
        this.derivedBioAssayData = derivedBioAssayData;
    }

    public gov.nih.nci.mageom.domain.bioassaydata.DerivedBioAssayData getDerivedBioAssayData(int i) {
        return this.derivedBioAssayData[i];
    }

    public void setDerivedBioAssayData(int i, gov.nih.nci.mageom.domain.bioassaydata.DerivedBioAssayData _value) {
        this.derivedBioAssayData[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DerivedBioAssays)) return false;
        DerivedBioAssays other = (DerivedBioAssays) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.derivedBioAssayData==null && other.getDerivedBioAssayData()==null) || 
             (this.derivedBioAssayData!=null &&
              java.util.Arrays.equals(this.derivedBioAssayData, other.getDerivedBioAssayData())));
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
        if (getDerivedBioAssayData() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDerivedBioAssayData());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDerivedBioAssayData(), i);
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
        new org.apache.axis.description.TypeDesc(DerivedBioAssays.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://org.bioconductor.cabig/1.0/org.bioconductor.cagrid.caaffy", "DerivedBioAssays"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("derivedBioAssayData");
        elemField.setXmlName(new javax.xml.namespace.QName("", "derivedBioAssayData"));
        elemField.setXmlType(new javax.xml.namespace.QName("gme://caArray.caBIG/1.1/gov.nih.nci.mageom.domain.BioAssayData", "DerivedBioAssayData"));
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
