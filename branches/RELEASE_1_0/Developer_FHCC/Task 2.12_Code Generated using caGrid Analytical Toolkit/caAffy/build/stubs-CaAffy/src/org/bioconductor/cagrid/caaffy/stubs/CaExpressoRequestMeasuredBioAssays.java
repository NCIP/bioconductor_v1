/**
 * CaExpressoRequestMeasuredBioAssays.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC2 Apr 28, 2006 (12:42:00 EDT) WSDL2Java emitter.
 */

package org.bioconductor.cagrid.caaffy.stubs;

public class CaExpressoRequestMeasuredBioAssays  implements java.io.Serializable {
    private org.bioconductor.cagrid.caaffy.MeasuredBioAssays measuredBioAssays;

    public CaExpressoRequestMeasuredBioAssays() {
    }

    public CaExpressoRequestMeasuredBioAssays(
           org.bioconductor.cagrid.caaffy.MeasuredBioAssays measuredBioAssays) {
           this.measuredBioAssays = measuredBioAssays;
    }


    /**
     * Gets the measuredBioAssays value for this CaExpressoRequestMeasuredBioAssays.
     * 
     * @return measuredBioAssays
     */
    public org.bioconductor.cagrid.caaffy.MeasuredBioAssays getMeasuredBioAssays() {
        return measuredBioAssays;
    }


    /**
     * Sets the measuredBioAssays value for this CaExpressoRequestMeasuredBioAssays.
     * 
     * @param measuredBioAssays
     */
    public void setMeasuredBioAssays(org.bioconductor.cagrid.caaffy.MeasuredBioAssays measuredBioAssays) {
        this.measuredBioAssays = measuredBioAssays;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CaExpressoRequestMeasuredBioAssays)) return false;
        CaExpressoRequestMeasuredBioAssays other = (CaExpressoRequestMeasuredBioAssays) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.measuredBioAssays==null && other.getMeasuredBioAssays()==null) || 
             (this.measuredBioAssays!=null &&
              this.measuredBioAssays.equals(other.getMeasuredBioAssays())));
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
        if (getMeasuredBioAssays() != null) {
            _hashCode += getMeasuredBioAssays().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CaExpressoRequestMeasuredBioAssays.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://caaffy.cagrid.bioconductor.org/CaAffy", ">>CaExpressoRequest>measuredBioAssays"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("measuredBioAssays");
        elemField.setXmlName(new javax.xml.namespace.QName("http://org.bioconductor.cabig/1.0/org.bioconductor.cagrid.caaffy", "MeasuredBioAssays"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://org.bioconductor.cabig/1.0/org.bioconductor.cagrid.caaffy", "MeasuredBioAssays"));
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
