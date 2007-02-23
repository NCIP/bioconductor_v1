/**
 * MzAssays.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC2 Apr 28, 2006 (12:42:00 EDT) WSDL2Java emitter.
 */

package org.bioconductor.cagrid.caprocess;

public class MzAssays  implements java.io.Serializable {
    private org.bioconductor.cagrid.caprocess.MzSpectrum[] mzSpectrumCollection;

    public MzAssays() {
    }

    public MzAssays(
           org.bioconductor.cagrid.caprocess.MzSpectrum[] mzSpectrumCollection) {
           this.mzSpectrumCollection = mzSpectrumCollection;
    }


    /**
     * Gets the mzSpectrumCollection value for this MzAssays.
     * 
     * @return mzSpectrumCollection
     */
    public org.bioconductor.cagrid.caprocess.MzSpectrum[] getMzSpectrumCollection() {
        return mzSpectrumCollection;
    }


    /**
     * Sets the mzSpectrumCollection value for this MzAssays.
     * 
     * @param mzSpectrumCollection
     */
    public void setMzSpectrumCollection(org.bioconductor.cagrid.caprocess.MzSpectrum[] mzSpectrumCollection) {
        this.mzSpectrumCollection = mzSpectrumCollection;
    }

    public org.bioconductor.cagrid.caprocess.MzSpectrum getMzSpectrumCollection(int i) {
        return this.mzSpectrumCollection[i];
    }

    public void setMzSpectrumCollection(int i, org.bioconductor.cagrid.caprocess.MzSpectrum _value) {
        this.mzSpectrumCollection[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MzAssays)) return false;
        MzAssays other = (MzAssays) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.mzSpectrumCollection==null && other.getMzSpectrumCollection()==null) || 
             (this.mzSpectrumCollection!=null &&
              java.util.Arrays.equals(this.mzSpectrumCollection, other.getMzSpectrumCollection())));
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
        if (getMzSpectrumCollection() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMzSpectrumCollection());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMzSpectrumCollection(), i);
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
        new org.apache.axis.description.TypeDesc(MzAssays.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://org.bioconductor.cabig/1.0/org.bioconductor.cagrid.caprocess", "MzAssays"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mzSpectrumCollection");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mzSpectrumCollection"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://org.bioconductor.cabig/1.0/org.bioconductor.cagrid.caprocess", "MzSpectrum"));
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
