/**
 * ExpressoParameter.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC2 Apr 28, 2006 (12:42:00 EDT) WSDL2Java emitter.
 */

package org.bioconductor.cagrid.caaffy;

public class ExpressoParameter  implements java.io.Serializable {
    private org.bioconductor.cagrid.caaffy.valuedomain.BackgroundCorrectMethod backgroundCorrectMethod;
    private org.bioconductor.cagrid.caaffy.valuedomain.PmCorrectMethod pmCorrectMethod;
    private org.bioconductor.cagrid.caaffy.valuedomain.ProbeSummaryMethod probeSummaryMethod;
    private org.bioconductor.cagrid.caaffy.NormalizeMethodParameter normalizeMethodParameter;

    public ExpressoParameter() {
    }

    public ExpressoParameter(
           org.bioconductor.cagrid.caaffy.valuedomain.BackgroundCorrectMethod backgroundCorrectMethod,
           org.bioconductor.cagrid.caaffy.NormalizeMethodParameter normalizeMethodParameter,
           org.bioconductor.cagrid.caaffy.valuedomain.PmCorrectMethod pmCorrectMethod,
           org.bioconductor.cagrid.caaffy.valuedomain.ProbeSummaryMethod probeSummaryMethod) {
           this.backgroundCorrectMethod = backgroundCorrectMethod;
           this.pmCorrectMethod = pmCorrectMethod;
           this.probeSummaryMethod = probeSummaryMethod;
           this.normalizeMethodParameter = normalizeMethodParameter;
    }


    /**
     * Gets the backgroundCorrectMethod value for this ExpressoParameter.
     * 
     * @return backgroundCorrectMethod
     */
    public org.bioconductor.cagrid.caaffy.valuedomain.BackgroundCorrectMethod getBackgroundCorrectMethod() {
        return backgroundCorrectMethod;
    }


    /**
     * Sets the backgroundCorrectMethod value for this ExpressoParameter.
     * 
     * @param backgroundCorrectMethod
     */
    public void setBackgroundCorrectMethod(org.bioconductor.cagrid.caaffy.valuedomain.BackgroundCorrectMethod backgroundCorrectMethod) {
        this.backgroundCorrectMethod = backgroundCorrectMethod;
    }


    /**
     * Gets the pmCorrectMethod value for this ExpressoParameter.
     * 
     * @return pmCorrectMethod
     */
    public org.bioconductor.cagrid.caaffy.valuedomain.PmCorrectMethod getPmCorrectMethod() {
        return pmCorrectMethod;
    }


    /**
     * Sets the pmCorrectMethod value for this ExpressoParameter.
     * 
     * @param pmCorrectMethod
     */
    public void setPmCorrectMethod(org.bioconductor.cagrid.caaffy.valuedomain.PmCorrectMethod pmCorrectMethod) {
        this.pmCorrectMethod = pmCorrectMethod;
    }


    /**
     * Gets the probeSummaryMethod value for this ExpressoParameter.
     * 
     * @return probeSummaryMethod
     */
    public org.bioconductor.cagrid.caaffy.valuedomain.ProbeSummaryMethod getProbeSummaryMethod() {
        return probeSummaryMethod;
    }


    /**
     * Sets the probeSummaryMethod value for this ExpressoParameter.
     * 
     * @param probeSummaryMethod
     */
    public void setProbeSummaryMethod(org.bioconductor.cagrid.caaffy.valuedomain.ProbeSummaryMethod probeSummaryMethod) {
        this.probeSummaryMethod = probeSummaryMethod;
    }


    /**
     * Gets the normalizeMethodParameter value for this ExpressoParameter.
     * 
     * @return normalizeMethodParameter
     */
    public org.bioconductor.cagrid.caaffy.NormalizeMethodParameter getNormalizeMethodParameter() {
        return normalizeMethodParameter;
    }


    /**
     * Sets the normalizeMethodParameter value for this ExpressoParameter.
     * 
     * @param normalizeMethodParameter
     */
    public void setNormalizeMethodParameter(org.bioconductor.cagrid.caaffy.NormalizeMethodParameter normalizeMethodParameter) {
        this.normalizeMethodParameter = normalizeMethodParameter;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ExpressoParameter)) return false;
        ExpressoParameter other = (ExpressoParameter) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.backgroundCorrectMethod==null && other.getBackgroundCorrectMethod()==null) || 
             (this.backgroundCorrectMethod!=null &&
              this.backgroundCorrectMethod.equals(other.getBackgroundCorrectMethod()))) &&
            ((this.pmCorrectMethod==null && other.getPmCorrectMethod()==null) || 
             (this.pmCorrectMethod!=null &&
              this.pmCorrectMethod.equals(other.getPmCorrectMethod()))) &&
            ((this.probeSummaryMethod==null && other.getProbeSummaryMethod()==null) || 
             (this.probeSummaryMethod!=null &&
              this.probeSummaryMethod.equals(other.getProbeSummaryMethod()))) &&
            ((this.normalizeMethodParameter==null && other.getNormalizeMethodParameter()==null) || 
             (this.normalizeMethodParameter!=null &&
              this.normalizeMethodParameter.equals(other.getNormalizeMethodParameter())));
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
        if (getBackgroundCorrectMethod() != null) {
            _hashCode += getBackgroundCorrectMethod().hashCode();
        }
        if (getPmCorrectMethod() != null) {
            _hashCode += getPmCorrectMethod().hashCode();
        }
        if (getProbeSummaryMethod() != null) {
            _hashCode += getProbeSummaryMethod().hashCode();
        }
        if (getNormalizeMethodParameter() != null) {
            _hashCode += getNormalizeMethodParameter().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ExpressoParameter.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://org.bioconductor.cabig/1.0/org.bioconductor.cagrid.caaffy", "ExpressoParameter"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("backgroundCorrectMethod");
        elemField.setXmlName(new javax.xml.namespace.QName("", "backgroundCorrectMethod"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://org.bioconductor.cabig/1.0/org.bioconductor.cagrid.caaffy.valuedomain", "BackgroundCorrectMethod"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pmCorrectMethod");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pmCorrectMethod"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://org.bioconductor.cabig/1.0/org.bioconductor.cagrid.caaffy.valuedomain", "PmCorrectMethod"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("probeSummaryMethod");
        elemField.setXmlName(new javax.xml.namespace.QName("", "probeSummaryMethod"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://org.bioconductor.cabig/1.0/org.bioconductor.cagrid.caaffy.valuedomain", "ProbeSummaryMethod"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("normalizeMethodParameter");
        elemField.setXmlName(new javax.xml.namespace.QName("", "normalizeMethodParameter"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://org.bioconductor.cabig/1.0/org.bioconductor.cagrid.caaffy", "NormalizeMethodParameter"));
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
