/**
 * CaPROcessRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC2 Apr 28, 2006 (12:42:00 EDT) WSDL2Java emitter.
 */

package org.bioconductor.cagrid.caprocess.stubs;

public class CaPROcessRequest  implements java.io.Serializable {
    private org.bioconductor.cagrid.caprocess.stubs.CaPROcessRequestMzAssays mzAssays;
    private org.bioconductor.cagrid.caprocess.stubs.CaPROcessRequestProcessParameter processParameter;

    public CaPROcessRequest() {
    }

    public CaPROcessRequest(
           org.bioconductor.cagrid.caprocess.stubs.CaPROcessRequestMzAssays mzAssays,
           org.bioconductor.cagrid.caprocess.stubs.CaPROcessRequestProcessParameter processParameter) {
           this.mzAssays = mzAssays;
           this.processParameter = processParameter;
    }


    /**
     * Gets the mzAssays value for this CaPROcessRequest.
     * 
     * @return mzAssays
     */
    public org.bioconductor.cagrid.caprocess.stubs.CaPROcessRequestMzAssays getMzAssays() {
        return mzAssays;
    }


    /**
     * Sets the mzAssays value for this CaPROcessRequest.
     * 
     * @param mzAssays
     */
    public void setMzAssays(org.bioconductor.cagrid.caprocess.stubs.CaPROcessRequestMzAssays mzAssays) {
        this.mzAssays = mzAssays;
    }


    /**
     * Gets the processParameter value for this CaPROcessRequest.
     * 
     * @return processParameter
     */
    public org.bioconductor.cagrid.caprocess.stubs.CaPROcessRequestProcessParameter getProcessParameter() {
        return processParameter;
    }


    /**
     * Sets the processParameter value for this CaPROcessRequest.
     * 
     * @param processParameter
     */
    public void setProcessParameter(org.bioconductor.cagrid.caprocess.stubs.CaPROcessRequestProcessParameter processParameter) {
        this.processParameter = processParameter;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CaPROcessRequest)) return false;
        CaPROcessRequest other = (CaPROcessRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.mzAssays==null && other.getMzAssays()==null) || 
             (this.mzAssays!=null &&
              this.mzAssays.equals(other.getMzAssays()))) &&
            ((this.processParameter==null && other.getProcessParameter()==null) || 
             (this.processParameter!=null &&
              this.processParameter.equals(other.getProcessParameter())));
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
        if (getMzAssays() != null) {
            _hashCode += getMzAssays().hashCode();
        }
        if (getProcessParameter() != null) {
            _hashCode += getProcessParameter().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CaPROcessRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://caprocess.cagrid.bioconductor.org/CaPROcess", ">CaPROcessRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mzAssays");
        elemField.setXmlName(new javax.xml.namespace.QName("http://caprocess.cagrid.bioconductor.org/CaPROcess", "mzAssays"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://caprocess.cagrid.bioconductor.org/CaPROcess", ">>CaPROcessRequest>mzAssays"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("processParameter");
        elemField.setXmlName(new javax.xml.namespace.QName("http://caprocess.cagrid.bioconductor.org/CaPROcess", "processParameter"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://caprocess.cagrid.bioconductor.org/CaPROcess", ">>CaPROcessRequest>processParameter"));
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
