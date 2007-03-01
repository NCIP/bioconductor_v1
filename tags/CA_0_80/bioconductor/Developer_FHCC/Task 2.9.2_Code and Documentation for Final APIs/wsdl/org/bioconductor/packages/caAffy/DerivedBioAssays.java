/**
 * DerivedBioAssays.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC2 Mar 03, 2006 (12:17:06 EST) WSDL2Java emitter.
 */

package org.bioconductor.packages.caAffy;

public class DerivedBioAssays  implements java.io.Serializable {
    private org.bioconductor.rserviceJms.services.caAffy.ArrayOf_tns4_DerivedBioAssay bioAssays;

    public DerivedBioAssays() {
    }

    public DerivedBioAssays(
           org.bioconductor.rserviceJms.services.caAffy.ArrayOf_tns4_DerivedBioAssay bioAssays) {
           this.bioAssays = bioAssays;
    }


    /**
     * Gets the bioAssays value for this DerivedBioAssays.
     * 
     * @return bioAssays
     */
    public org.bioconductor.rserviceJms.services.caAffy.ArrayOf_tns4_DerivedBioAssay getBioAssays() {
        return bioAssays;
    }


    /**
     * Sets the bioAssays value for this DerivedBioAssays.
     * 
     * @param bioAssays
     */
    public void setBioAssays(org.bioconductor.rserviceJms.services.caAffy.ArrayOf_tns4_DerivedBioAssay bioAssays) {
        this.bioAssays = bioAssays;
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
            ((this.bioAssays==null && other.getBioAssays()==null) || 
             (this.bioAssays!=null &&
              this.bioAssays.equals(other.getBioAssays())));
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
        if (getBioAssays() != null) {
            _hashCode += getBioAssays().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DerivedBioAssays.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://caAffy.packages.bioconductor.org", "DerivedBioAssays"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bioAssays");
        elemField.setXmlName(new javax.xml.namespace.QName("http://caAffy.packages.bioconductor.org", "bioAssays"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.bioconductor.org/services/caAffy", "ArrayOf_tns4_DerivedBioAssay"));
        elemField.setNillable(true);
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
