/**
 * RJDataFrame.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC2 Mar 03, 2006 (12:17:06 EST) WSDL2Java emitter.
 */

package org.bioconductor.packages.rservices;

public class RJDataFrame  implements java.io.Serializable {
    private org.bioconductor.rserviceJms.services.caAffy.ArrayOf_xsd_anyType data;
    private org.bioconductor.rserviceJms.services.caAffy.ArrayOf_xsd_string rowNames;

    public RJDataFrame() {
    }

    public RJDataFrame(
           org.bioconductor.rserviceJms.services.caAffy.ArrayOf_xsd_anyType data,
           org.bioconductor.rserviceJms.services.caAffy.ArrayOf_xsd_string rowNames) {
           this.data = data;
           this.rowNames = rowNames;
    }


    /**
     * Gets the data value for this RJDataFrame.
     * 
     * @return data
     */
    public org.bioconductor.rserviceJms.services.caAffy.ArrayOf_xsd_anyType getData() {
        return data;
    }


    /**
     * Sets the data value for this RJDataFrame.
     * 
     * @param data
     */
    public void setData(org.bioconductor.rserviceJms.services.caAffy.ArrayOf_xsd_anyType data) {
        this.data = data;
    }


    /**
     * Gets the rowNames value for this RJDataFrame.
     * 
     * @return rowNames
     */
    public org.bioconductor.rserviceJms.services.caAffy.ArrayOf_xsd_string getRowNames() {
        return rowNames;
    }


    /**
     * Sets the rowNames value for this RJDataFrame.
     * 
     * @param rowNames
     */
    public void setRowNames(org.bioconductor.rserviceJms.services.caAffy.ArrayOf_xsd_string rowNames) {
        this.rowNames = rowNames;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RJDataFrame)) return false;
        RJDataFrame other = (RJDataFrame) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.data==null && other.getData()==null) || 
             (this.data!=null &&
              this.data.equals(other.getData()))) &&
            ((this.rowNames==null && other.getRowNames()==null) || 
             (this.rowNames!=null &&
              this.rowNames.equals(other.getRowNames())));
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
        if (getData() != null) {
            _hashCode += getData().hashCode();
        }
        if (getRowNames() != null) {
            _hashCode += getRowNames().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RJDataFrame.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.bioconductor.org/services/rservices", "RJDataFrame"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("data");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.bioconductor.org/services/rservices", "data"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.bioconductor.org/services/caAffy", "ArrayOf_xsd_anyType"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rowNames");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.bioconductor.org/services/rservices", "rowNames"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.bioconductor.org/services/caAffy", "ArrayOf_xsd_string"));
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
