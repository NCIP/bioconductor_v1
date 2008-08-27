/**
 * CaPROcessResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC2 Apr 28, 2006 (12:42:00 EDT) WSDL2Java emitter.
 */

package org.bioconductor.cagrid.caprocess.stubs;

public class CaPROcessResponse  implements java.io.Serializable {
    private org.bioconductor.cagrid.caprocess.PeakLocation peakLocation;

    public CaPROcessResponse() {
    }

    public CaPROcessResponse(
           org.bioconductor.cagrid.caprocess.PeakLocation peakLocation) {
           this.peakLocation = peakLocation;
    }


    /**
     * Gets the peakLocation value for this CaPROcessResponse.
     * 
     * @return peakLocation
     */
    public org.bioconductor.cagrid.caprocess.PeakLocation getPeakLocation() {
        return peakLocation;
    }


    /**
     * Sets the peakLocation value for this CaPROcessResponse.
     * 
     * @param peakLocation
     */
    public void setPeakLocation(org.bioconductor.cagrid.caprocess.PeakLocation peakLocation) {
        this.peakLocation = peakLocation;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CaPROcessResponse)) return false;
        CaPROcessResponse other = (CaPROcessResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.peakLocation==null && other.getPeakLocation()==null) || 
             (this.peakLocation!=null &&
              this.peakLocation.equals(other.getPeakLocation())));
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
        if (getPeakLocation() != null) {
            _hashCode += getPeakLocation().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CaPROcessResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://caprocess.cagrid.bioconductor.org/CaPROcess", ">CaPROcessResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("peakLocation");
        elemField.setXmlName(new javax.xml.namespace.QName("http://org.bioconductor.cabig/1.0/org.bioconductor.cagrid.caprocess", "PeakLocation"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://org.bioconductor.cabig/1.0/org.bioconductor.cagrid.caprocess", "PeakLocation"));
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
