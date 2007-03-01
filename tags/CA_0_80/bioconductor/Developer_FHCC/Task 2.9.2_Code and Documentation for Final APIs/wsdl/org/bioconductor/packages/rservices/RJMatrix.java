/**
 * RJMatrix.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC2 Mar 03, 2006 (12:17:06 EST) WSDL2Java emitter.
 */

package org.bioconductor.packages.rservices;

public abstract class RJMatrix  implements java.io.Serializable {
    private org.bioconductor.rserviceJms.services.caAffy.ArrayOf_xsd_int dim;
    private org.bioconductor.rserviceJms.services.caAffy.ArrayOf_xsd_anyType dimnames;

    public RJMatrix() {
    }

    public RJMatrix(
           org.bioconductor.rserviceJms.services.caAffy.ArrayOf_xsd_int dim,
           org.bioconductor.rserviceJms.services.caAffy.ArrayOf_xsd_anyType dimnames) {
           this.dim = dim;
           this.dimnames = dimnames;
    }


    /**
     * Gets the dim value for this RJMatrix.
     * 
     * @return dim
     */
    public org.bioconductor.rserviceJms.services.caAffy.ArrayOf_xsd_int getDim() {
        return dim;
    }


    /**
     * Sets the dim value for this RJMatrix.
     * 
     * @param dim
     */
    public void setDim(org.bioconductor.rserviceJms.services.caAffy.ArrayOf_xsd_int dim) {
        this.dim = dim;
    }


    /**
     * Gets the dimnames value for this RJMatrix.
     * 
     * @return dimnames
     */
    public org.bioconductor.rserviceJms.services.caAffy.ArrayOf_xsd_anyType getDimnames() {
        return dimnames;
    }


    /**
     * Sets the dimnames value for this RJMatrix.
     * 
     * @param dimnames
     */
    public void setDimnames(org.bioconductor.rserviceJms.services.caAffy.ArrayOf_xsd_anyType dimnames) {
        this.dimnames = dimnames;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RJMatrix)) return false;
        RJMatrix other = (RJMatrix) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dim==null && other.getDim()==null) || 
             (this.dim!=null &&
              this.dim.equals(other.getDim()))) &&
            ((this.dimnames==null && other.getDimnames()==null) || 
             (this.dimnames!=null &&
              this.dimnames.equals(other.getDimnames())));
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
        if (getDim() != null) {
            _hashCode += getDim().hashCode();
        }
        if (getDimnames() != null) {
            _hashCode += getDimnames().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RJMatrix.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.bioconductor.org/services/rservices", "RJMatrix"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dim");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.bioconductor.org/services/rservices", "dim"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.bioconductor.org/services/caAffy", "ArrayOf_xsd_int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dimnames");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.bioconductor.org/services/rservices", "dimnames"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.bioconductor.org/services/caAffy", "ArrayOf_xsd_anyType"));
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
