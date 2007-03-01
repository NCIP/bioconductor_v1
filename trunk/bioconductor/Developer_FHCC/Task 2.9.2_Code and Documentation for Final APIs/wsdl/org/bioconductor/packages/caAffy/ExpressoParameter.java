/**
 * ExpressoParameter.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC2 Mar 03, 2006 (12:17:06 EST) WSDL2Java emitter.
 */

package org.bioconductor.packages.caAffy;

public class ExpressoParameter  implements java.io.Serializable {
    private org.bioconductor.rserviceJms.services.caAffy.ArrayOf_xsd_string backgroundCorrectMethod;
    private org.bioconductor.packages.caAffy.NormalizeMethodParameter normalizeMethodParameter;
    private org.bioconductor.rserviceJms.services.caAffy.ArrayOf_xsd_string pmCorrectMethod;
    private org.bioconductor.rserviceJms.services.caAffy.ArrayOf_xsd_string probeSummaryMethod;

    public ExpressoParameter() {
    }

    public ExpressoParameter(
           org.bioconductor.rserviceJms.services.caAffy.ArrayOf_xsd_string backgroundCorrectMethod,
           org.bioconductor.packages.caAffy.NormalizeMethodParameter normalizeMethodParameter,
           org.bioconductor.rserviceJms.services.caAffy.ArrayOf_xsd_string pmCorrectMethod,
           org.bioconductor.rserviceJms.services.caAffy.ArrayOf_xsd_string probeSummaryMethod) {
           this.backgroundCorrectMethod = backgroundCorrectMethod;
           this.normalizeMethodParameter = normalizeMethodParameter;
           this.pmCorrectMethod = pmCorrectMethod;
           this.probeSummaryMethod = probeSummaryMethod;
    }


    /**
     * Gets the backgroundCorrectMethod value for this ExpressoParameter.
     * 
     * @return backgroundCorrectMethod
     */
    public org.bioconductor.rserviceJms.services.caAffy.ArrayOf_xsd_string getBackgroundCorrectMethod() {
        return backgroundCorrectMethod;
    }


    /**
     * Sets the backgroundCorrectMethod value for this ExpressoParameter.
     * 
     * @param backgroundCorrectMethod
     */
    public void setBackgroundCorrectMethod(org.bioconductor.rserviceJms.services.caAffy.ArrayOf_xsd_string backgroundCorrectMethod) {
        this.backgroundCorrectMethod = backgroundCorrectMethod;
    }


    /**
     * Gets the normalizeMethodParameter value for this ExpressoParameter.
     * 
     * @return normalizeMethodParameter
     */
    public org.bioconductor.packages.caAffy.NormalizeMethodParameter getNormalizeMethodParameter() {
        return normalizeMethodParameter;
    }


    /**
     * Sets the normalizeMethodParameter value for this ExpressoParameter.
     * 
     * @param normalizeMethodParameter
     */
    public void setNormalizeMethodParameter(org.bioconductor.packages.caAffy.NormalizeMethodParameter normalizeMethodParameter) {
        this.normalizeMethodParameter = normalizeMethodParameter;
    }


    /**
     * Gets the pmCorrectMethod value for this ExpressoParameter.
     * 
     * @return pmCorrectMethod
     */
    public org.bioconductor.rserviceJms.services.caAffy.ArrayOf_xsd_string getPmCorrectMethod() {
        return pmCorrectMethod;
    }


    /**
     * Sets the pmCorrectMethod value for this ExpressoParameter.
     * 
     * @param pmCorrectMethod
     */
    public void setPmCorrectMethod(org.bioconductor.rserviceJms.services.caAffy.ArrayOf_xsd_string pmCorrectMethod) {
        this.pmCorrectMethod = pmCorrectMethod;
    }


    /**
     * Gets the probeSummaryMethod value for this ExpressoParameter.
     * 
     * @return probeSummaryMethod
     */
    public org.bioconductor.rserviceJms.services.caAffy.ArrayOf_xsd_string getProbeSummaryMethod() {
        return probeSummaryMethod;
    }


    /**
     * Sets the probeSummaryMethod value for this ExpressoParameter.
     * 
     * @param probeSummaryMethod
     */
    public void setProbeSummaryMethod(org.bioconductor.rserviceJms.services.caAffy.ArrayOf_xsd_string probeSummaryMethod) {
        this.probeSummaryMethod = probeSummaryMethod;
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
            ((this.normalizeMethodParameter==null && other.getNormalizeMethodParameter()==null) || 
             (this.normalizeMethodParameter!=null &&
              this.normalizeMethodParameter.equals(other.getNormalizeMethodParameter()))) &&
            ((this.pmCorrectMethod==null && other.getPmCorrectMethod()==null) || 
             (this.pmCorrectMethod!=null &&
              this.pmCorrectMethod.equals(other.getPmCorrectMethod()))) &&
            ((this.probeSummaryMethod==null && other.getProbeSummaryMethod()==null) || 
             (this.probeSummaryMethod!=null &&
              this.probeSummaryMethod.equals(other.getProbeSummaryMethod())));
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
        if (getNormalizeMethodParameter() != null) {
            _hashCode += getNormalizeMethodParameter().hashCode();
        }
        if (getPmCorrectMethod() != null) {
            _hashCode += getPmCorrectMethod().hashCode();
        }
        if (getProbeSummaryMethod() != null) {
            _hashCode += getProbeSummaryMethod().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ExpressoParameter.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://caAffy.packages.bioconductor.org", "ExpressoParameter"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("backgroundCorrectMethod");
        elemField.setXmlName(new javax.xml.namespace.QName("http://caAffy.packages.bioconductor.org", "backgroundCorrectMethod"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.bioconductor.org/services/caAffy", "ArrayOf_xsd_string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("normalizeMethodParameter");
        elemField.setXmlName(new javax.xml.namespace.QName("http://caAffy.packages.bioconductor.org", "normalizeMethodParameter"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://caAffy.packages.bioconductor.org", "NormalizeMethodParameter"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pmCorrectMethod");
        elemField.setXmlName(new javax.xml.namespace.QName("http://caAffy.packages.bioconductor.org", "pmCorrectMethod"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.bioconductor.org/services/caAffy", "ArrayOf_xsd_string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("probeSummaryMethod");
        elemField.setXmlName(new javax.xml.namespace.QName("http://caAffy.packages.bioconductor.org", "probeSummaryMethod"));
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
