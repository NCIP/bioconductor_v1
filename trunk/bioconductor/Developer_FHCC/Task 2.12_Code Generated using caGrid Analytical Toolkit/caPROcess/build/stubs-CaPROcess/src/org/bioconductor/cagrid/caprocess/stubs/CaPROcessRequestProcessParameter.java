/**
 * CaPROcessRequestProcessParameter.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC2 Apr 28, 2006 (12:42:00 EDT) WSDL2Java emitter.
 */

package org.bioconductor.cagrid.caprocess.stubs;

public class CaPROcessRequestProcessParameter  implements java.io.Serializable {
    private org.bioconductor.cagrid.caprocess.PROcessParameter PROcessParameter;

    public CaPROcessRequestProcessParameter() {
    }

    public CaPROcessRequestProcessParameter(
           org.bioconductor.cagrid.caprocess.PROcessParameter PROcessParameter) {
           this.PROcessParameter = PROcessParameter;
    }


    /**
     * Gets the PROcessParameter value for this CaPROcessRequestProcessParameter.
     * 
     * @return PROcessParameter
     */
    public org.bioconductor.cagrid.caprocess.PROcessParameter getPROcessParameter() {
        return PROcessParameter;
    }


    /**
     * Sets the PROcessParameter value for this CaPROcessRequestProcessParameter.
     * 
     * @param PROcessParameter
     */
    public void setPROcessParameter(org.bioconductor.cagrid.caprocess.PROcessParameter PROcessParameter) {
        this.PROcessParameter = PROcessParameter;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CaPROcessRequestProcessParameter)) return false;
        CaPROcessRequestProcessParameter other = (CaPROcessRequestProcessParameter) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.PROcessParameter==null && other.getPROcessParameter()==null) || 
             (this.PROcessParameter!=null &&
              this.PROcessParameter.equals(other.getPROcessParameter())));
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
        if (getPROcessParameter() != null) {
            _hashCode += getPROcessParameter().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CaPROcessRequestProcessParameter.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://caprocess.cagrid.bioconductor.org/CaPROcess", ">>CaPROcessRequest>processParameter"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PROcessParameter");
        elemField.setXmlName(new javax.xml.namespace.QName("http://org.bioconductor.cabig/1.0/org.bioconductor.cagrid.caprocess", "PROcessParameter"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://org.bioconductor.cabig/1.0/org.bioconductor.cagrid.caprocess", "PROcessParameter"));
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
