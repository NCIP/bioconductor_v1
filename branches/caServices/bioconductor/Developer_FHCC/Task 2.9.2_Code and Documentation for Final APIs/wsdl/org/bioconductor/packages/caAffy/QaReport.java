/**
 * QaReport.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC2 Mar 03, 2006 (12:17:06 EST) WSDL2Java emitter.
 */

package org.bioconductor.packages.caAffy;

public class QaReport  implements java.io.Serializable {
    private byte[] pdfFile;

    public QaReport() {
    }

    public QaReport(
           byte[] pdfFile) {
           this.pdfFile = pdfFile;
    }


    /**
     * Gets the pdfFile value for this QaReport.
     * 
     * @return pdfFile
     */
    public byte[] getPdfFile() {
        return pdfFile;
    }


    /**
     * Sets the pdfFile value for this QaReport.
     * 
     * @param pdfFile
     */
    public void setPdfFile(byte[] pdfFile) {
        this.pdfFile = pdfFile;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof QaReport)) return false;
        QaReport other = (QaReport) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.pdfFile==null && other.getPdfFile()==null) || 
             (this.pdfFile!=null &&
              java.util.Arrays.equals(this.pdfFile, other.getPdfFile())));
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
        if (getPdfFile() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPdfFile());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPdfFile(), i);
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
        new org.apache.axis.description.TypeDesc(QaReport.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://caAffy.packages.bioconductor.org", "QaReport"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pdfFile");
        elemField.setXmlName(new javax.xml.namespace.QName("http://caAffy.packages.bioconductor.org", "pdfFile"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
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
