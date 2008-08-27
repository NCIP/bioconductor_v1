/**
 * CaDNAcopyRequestDnacopyAssays.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC2 Apr 28, 2006 (12:42:00 EDT) WSDL2Java emitter.
 */

package org.bioconductor.cagrid.cadnacopy.stubs;

public class CaDNAcopyRequestDnacopyAssays  implements java.io.Serializable {
    private org.bioconductor.cagrid.cadnacopy.DNAcopyAssays DNAcopyAssays;

    public CaDNAcopyRequestDnacopyAssays() {
    }

    public CaDNAcopyRequestDnacopyAssays(
           org.bioconductor.cagrid.cadnacopy.DNAcopyAssays DNAcopyAssays) {
           this.DNAcopyAssays = DNAcopyAssays;
    }


    /**
     * Gets the DNAcopyAssays value for this CaDNAcopyRequestDnacopyAssays.
     * 
     * @return DNAcopyAssays
     */
    public org.bioconductor.cagrid.cadnacopy.DNAcopyAssays getDNAcopyAssays() {
        return DNAcopyAssays;
    }


    /**
     * Sets the DNAcopyAssays value for this CaDNAcopyRequestDnacopyAssays.
     * 
     * @param DNAcopyAssays
     */
    public void setDNAcopyAssays(org.bioconductor.cagrid.cadnacopy.DNAcopyAssays DNAcopyAssays) {
        this.DNAcopyAssays = DNAcopyAssays;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CaDNAcopyRequestDnacopyAssays)) return false;
        CaDNAcopyRequestDnacopyAssays other = (CaDNAcopyRequestDnacopyAssays) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.DNAcopyAssays==null && other.getDNAcopyAssays()==null) || 
             (this.DNAcopyAssays!=null &&
              this.DNAcopyAssays.equals(other.getDNAcopyAssays())));
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
        if (getDNAcopyAssays() != null) {
            _hashCode += getDNAcopyAssays().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CaDNAcopyRequestDnacopyAssays.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://cadnacopy.cagrid.bioconductor.org/CaDNAcopy", ">>CaDNAcopyRequest>dnacopyAssays"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DNAcopyAssays");
        elemField.setXmlName(new javax.xml.namespace.QName("http://org.bioconductor.cabig/1.0/org.bioconductor.cagrid.cadnacopy", "DNAcopyAssays"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://org.bioconductor.cabig/1.0/org.bioconductor.cagrid.cadnacopy", "DNAcopyAssays"));
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
