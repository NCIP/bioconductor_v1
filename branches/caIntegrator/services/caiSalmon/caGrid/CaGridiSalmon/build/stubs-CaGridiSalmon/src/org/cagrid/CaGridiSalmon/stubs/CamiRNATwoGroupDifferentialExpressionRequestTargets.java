/**
 * CamiRNATwoGroupDifferentialExpressionRequestTargets.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC2 Apr 28, 2006 (12:42:00 EDT) WSDL2Java emitter.
 */

package org.cagrid.CaGridiSalmon.stubs;

public class CamiRNATwoGroupDifferentialExpressionRequestTargets  implements java.io.Serializable {
    private org.bioconductor.cagrid.caisalmon.Targets targets;

    public CamiRNATwoGroupDifferentialExpressionRequestTargets() {
    }

    public CamiRNATwoGroupDifferentialExpressionRequestTargets(
           org.bioconductor.cagrid.caisalmon.Targets targets) {
           this.targets = targets;
    }


    /**
     * Gets the targets value for this CamiRNATwoGroupDifferentialExpressionRequestTargets.
     * 
     * @return targets
     */
    public org.bioconductor.cagrid.caisalmon.Targets getTargets() {
        return targets;
    }


    /**
     * Sets the targets value for this CamiRNATwoGroupDifferentialExpressionRequestTargets.
     * 
     * @param targets
     */
    public void setTargets(org.bioconductor.cagrid.caisalmon.Targets targets) {
        this.targets = targets;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CamiRNATwoGroupDifferentialExpressionRequestTargets)) return false;
        CamiRNATwoGroupDifferentialExpressionRequestTargets other = (CamiRNATwoGroupDifferentialExpressionRequestTargets) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.targets==null && other.getTargets()==null) || 
             (this.targets!=null &&
              this.targets.equals(other.getTargets())));
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
        if (getTargets() != null) {
            _hashCode += getTargets().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CamiRNATwoGroupDifferentialExpressionRequestTargets.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://CaGridiSalmon.cagrid.org/CaGridiSalmon", ">>CamiRNATwoGroupDifferentialExpressionRequest>targets"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("targets");
        elemField.setXmlName(new javax.xml.namespace.QName("http://org.bioconductor.cabig/1.0/org.bioconductor.cagrid.caisalmon", "Targets"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://org.bioconductor.cabig/1.0/org.bioconductor.cagrid.caisalmon", "Targets"));
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
