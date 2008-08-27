/**
 * CaExpressoResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC2 Apr 28, 2006 (12:42:00 EDT) WSDL2Java emitter.
 */

package org.bioconductor.cagrid.caaffy.stubs;

public class CaExpressoResponse  implements java.io.Serializable {
    private org.bioconductor.cagrid.caaffy.DerivedBioAssays derivedBioAssays;

    public CaExpressoResponse() {
    }

    public CaExpressoResponse(
           org.bioconductor.cagrid.caaffy.DerivedBioAssays derivedBioAssays) {
           this.derivedBioAssays = derivedBioAssays;
    }


    /**
     * Gets the derivedBioAssays value for this CaExpressoResponse.
     * 
     * @return derivedBioAssays
     */
    public org.bioconductor.cagrid.caaffy.DerivedBioAssays getDerivedBioAssays() {
        return derivedBioAssays;
    }


    /**
     * Sets the derivedBioAssays value for this CaExpressoResponse.
     * 
     * @param derivedBioAssays
     */
    public void setDerivedBioAssays(org.bioconductor.cagrid.caaffy.DerivedBioAssays derivedBioAssays) {
        this.derivedBioAssays = derivedBioAssays;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CaExpressoResponse)) return false;
        CaExpressoResponse other = (CaExpressoResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.derivedBioAssays==null && other.getDerivedBioAssays()==null) || 
             (this.derivedBioAssays!=null &&
              this.derivedBioAssays.equals(other.getDerivedBioAssays())));
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
        if (getDerivedBioAssays() != null) {
            _hashCode += getDerivedBioAssays().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CaExpressoResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://caaffy.cagrid.bioconductor.org/CaAffy", ">CaExpressoResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("derivedBioAssays");
        elemField.setXmlName(new javax.xml.namespace.QName("http://org.bioconductor.cabig/1.0/org.bioconductor.cagrid.caaffy", "DerivedBioAssays"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://org.bioconductor.cabig/1.0/org.bioconductor.cagrid.caaffy", "DerivedBioAssays"));
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
