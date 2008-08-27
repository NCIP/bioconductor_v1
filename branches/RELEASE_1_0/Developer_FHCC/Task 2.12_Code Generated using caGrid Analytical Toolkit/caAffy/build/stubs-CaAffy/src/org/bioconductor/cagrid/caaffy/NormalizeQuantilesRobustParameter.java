/**
 * NormalizeQuantilesRobustParameter.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC2 Apr 28, 2006 (12:42:00 EDT) WSDL2Java emitter.
 */

package org.bioconductor.cagrid.caaffy;

public class NormalizeQuantilesRobustParameter  extends org.bioconductor.cagrid.caaffy.NormalizeMethodParameter  implements java.io.Serializable {
    private org.bioconductor.cagrid.caaffy.valuedomain.RemoveExtreme removeExtreme;

    public NormalizeQuantilesRobustParameter() {
    }

    public NormalizeQuantilesRobustParameter(
           org.bioconductor.cagrid.caaffy.valuedomain.RemoveExtreme removeExtreme) {
           this.removeExtreme = removeExtreme;
    }


    /**
     * Gets the removeExtreme value for this NormalizeQuantilesRobustParameter.
     * 
     * @return removeExtreme
     */
    public org.bioconductor.cagrid.caaffy.valuedomain.RemoveExtreme getRemoveExtreme() {
        return removeExtreme;
    }


    /**
     * Sets the removeExtreme value for this NormalizeQuantilesRobustParameter.
     * 
     * @param removeExtreme
     */
    public void setRemoveExtreme(org.bioconductor.cagrid.caaffy.valuedomain.RemoveExtreme removeExtreme) {
        this.removeExtreme = removeExtreme;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof NormalizeQuantilesRobustParameter)) return false;
        NormalizeQuantilesRobustParameter other = (NormalizeQuantilesRobustParameter) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.removeExtreme==null && other.getRemoveExtreme()==null) || 
             (this.removeExtreme!=null &&
              this.removeExtreme.equals(other.getRemoveExtreme())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getRemoveExtreme() != null) {
            _hashCode += getRemoveExtreme().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(NormalizeQuantilesRobustParameter.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://org.bioconductor.cabig/1.0/org.bioconductor.cagrid.caaffy", "NormalizeQuantilesRobustParameter"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("removeExtreme");
        elemField.setXmlName(new javax.xml.namespace.QName("", "removeExtreme"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://org.bioconductor.cabig/1.0/org.bioconductor.cagrid.caaffy.valuedomain", "RemoveExtreme"));
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
