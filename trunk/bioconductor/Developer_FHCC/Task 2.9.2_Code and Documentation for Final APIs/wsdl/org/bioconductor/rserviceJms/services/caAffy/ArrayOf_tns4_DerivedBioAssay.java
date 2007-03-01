/**
 * ArrayOf_tns4_DerivedBioAssay.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC2 Mar 03, 2006 (12:17:06 EST) WSDL2Java emitter.
 */

package org.bioconductor.rserviceJms.services.caAffy;

public class ArrayOf_tns4_DerivedBioAssay  implements java.io.Serializable {
    private gov.nih.nci.mageom.domain.bioassay.DerivedBioAssay[] item;

    public ArrayOf_tns4_DerivedBioAssay() {
    }

    public ArrayOf_tns4_DerivedBioAssay(
           gov.nih.nci.mageom.domain.bioassay.DerivedBioAssay[] item) {
           this.item = item;
    }


    /**
     * Gets the item value for this ArrayOf_tns4_DerivedBioAssay.
     * 
     * @return item
     */
    public gov.nih.nci.mageom.domain.bioassay.DerivedBioAssay[] getItem() {
        return item;
    }


    /**
     * Sets the item value for this ArrayOf_tns4_DerivedBioAssay.
     * 
     * @param item
     */
    public void setItem(gov.nih.nci.mageom.domain.bioassay.DerivedBioAssay[] item) {
        this.item = item;
    }

    public gov.nih.nci.mageom.domain.bioassay.DerivedBioAssay getItem(int i) {
        return this.item[i];
    }

    public void setItem(int i, gov.nih.nci.mageom.domain.bioassay.DerivedBioAssay _value) {
        this.item[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ArrayOf_tns4_DerivedBioAssay)) return false;
        ArrayOf_tns4_DerivedBioAssay other = (ArrayOf_tns4_DerivedBioAssay) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.item==null && other.getItem()==null) || 
             (this.item!=null &&
              java.util.Arrays.equals(this.item, other.getItem())));
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
        if (getItem() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getItem());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getItem(), i);
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
        new org.apache.axis.description.TypeDesc(ArrayOf_tns4_DerivedBioAssay.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.bioconductor.org/services/caAffy", "ArrayOf_tns4_DerivedBioAssay"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("item");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.bioconductor.org/services/caAffy", "item"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://bioassay.domain.mageom.nci.nih.gov", "DerivedBioAssay"));
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
