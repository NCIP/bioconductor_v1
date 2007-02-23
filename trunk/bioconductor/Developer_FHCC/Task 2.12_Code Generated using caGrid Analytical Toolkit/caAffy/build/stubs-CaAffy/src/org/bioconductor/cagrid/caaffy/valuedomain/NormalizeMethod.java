/**
 * NormalizeMethod.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC2 Apr 28, 2006 (12:42:00 EDT) WSDL2Java emitter.
 */

package org.bioconductor.cagrid.caaffy.valuedomain;

public class NormalizeMethod  implements java.io.Serializable {
    private java.lang.String constant;
    private java.lang.String contrasts;
    private java.lang.String invariantSet;
    private java.lang.String loess;
    private java.lang.String qSpline;
    private java.lang.String quantiles;
    private java.lang.String quantilesRobust;

    public NormalizeMethod() {
    }

    public NormalizeMethod(
           java.lang.String constant,
           java.lang.String contrasts,
           java.lang.String invariantSet,
           java.lang.String loess,
           java.lang.String qSpline,
           java.lang.String quantiles,
           java.lang.String quantilesRobust) {
           this.constant = constant;
           this.contrasts = contrasts;
           this.invariantSet = invariantSet;
           this.loess = loess;
           this.qSpline = qSpline;
           this.quantiles = quantiles;
           this.quantilesRobust = quantilesRobust;
    }


    /**
     * Gets the constant value for this NormalizeMethod.
     * 
     * @return constant
     */
    public java.lang.String getConstant() {
        return constant;
    }


    /**
     * Sets the constant value for this NormalizeMethod.
     * 
     * @param constant
     */
    public void setConstant(java.lang.String constant) {
        this.constant = constant;
    }


    /**
     * Gets the contrasts value for this NormalizeMethod.
     * 
     * @return contrasts
     */
    public java.lang.String getContrasts() {
        return contrasts;
    }


    /**
     * Sets the contrasts value for this NormalizeMethod.
     * 
     * @param contrasts
     */
    public void setContrasts(java.lang.String contrasts) {
        this.contrasts = contrasts;
    }


    /**
     * Gets the invariantSet value for this NormalizeMethod.
     * 
     * @return invariantSet
     */
    public java.lang.String getInvariantSet() {
        return invariantSet;
    }


    /**
     * Sets the invariantSet value for this NormalizeMethod.
     * 
     * @param invariantSet
     */
    public void setInvariantSet(java.lang.String invariantSet) {
        this.invariantSet = invariantSet;
    }


    /**
     * Gets the loess value for this NormalizeMethod.
     * 
     * @return loess
     */
    public java.lang.String getLoess() {
        return loess;
    }


    /**
     * Sets the loess value for this NormalizeMethod.
     * 
     * @param loess
     */
    public void setLoess(java.lang.String loess) {
        this.loess = loess;
    }


    /**
     * Gets the qSpline value for this NormalizeMethod.
     * 
     * @return qSpline
     */
    public java.lang.String getQSpline() {
        return qSpline;
    }


    /**
     * Sets the qSpline value for this NormalizeMethod.
     * 
     * @param qSpline
     */
    public void setQSpline(java.lang.String qSpline) {
        this.qSpline = qSpline;
    }


    /**
     * Gets the quantiles value for this NormalizeMethod.
     * 
     * @return quantiles
     */
    public java.lang.String getQuantiles() {
        return quantiles;
    }


    /**
     * Sets the quantiles value for this NormalizeMethod.
     * 
     * @param quantiles
     */
    public void setQuantiles(java.lang.String quantiles) {
        this.quantiles = quantiles;
    }


    /**
     * Gets the quantilesRobust value for this NormalizeMethod.
     * 
     * @return quantilesRobust
     */
    public java.lang.String getQuantilesRobust() {
        return quantilesRobust;
    }


    /**
     * Sets the quantilesRobust value for this NormalizeMethod.
     * 
     * @param quantilesRobust
     */
    public void setQuantilesRobust(java.lang.String quantilesRobust) {
        this.quantilesRobust = quantilesRobust;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof NormalizeMethod)) return false;
        NormalizeMethod other = (NormalizeMethod) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.constant==null && other.getConstant()==null) || 
             (this.constant!=null &&
              this.constant.equals(other.getConstant()))) &&
            ((this.contrasts==null && other.getContrasts()==null) || 
             (this.contrasts!=null &&
              this.contrasts.equals(other.getContrasts()))) &&
            ((this.invariantSet==null && other.getInvariantSet()==null) || 
             (this.invariantSet!=null &&
              this.invariantSet.equals(other.getInvariantSet()))) &&
            ((this.loess==null && other.getLoess()==null) || 
             (this.loess!=null &&
              this.loess.equals(other.getLoess()))) &&
            ((this.qSpline==null && other.getQSpline()==null) || 
             (this.qSpline!=null &&
              this.qSpline.equals(other.getQSpline()))) &&
            ((this.quantiles==null && other.getQuantiles()==null) || 
             (this.quantiles!=null &&
              this.quantiles.equals(other.getQuantiles()))) &&
            ((this.quantilesRobust==null && other.getQuantilesRobust()==null) || 
             (this.quantilesRobust!=null &&
              this.quantilesRobust.equals(other.getQuantilesRobust())));
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
        if (getConstant() != null) {
            _hashCode += getConstant().hashCode();
        }
        if (getContrasts() != null) {
            _hashCode += getContrasts().hashCode();
        }
        if (getInvariantSet() != null) {
            _hashCode += getInvariantSet().hashCode();
        }
        if (getLoess() != null) {
            _hashCode += getLoess().hashCode();
        }
        if (getQSpline() != null) {
            _hashCode += getQSpline().hashCode();
        }
        if (getQuantiles() != null) {
            _hashCode += getQuantiles().hashCode();
        }
        if (getQuantilesRobust() != null) {
            _hashCode += getQuantilesRobust().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(NormalizeMethod.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://org.bioconductor.cabig/1.0/org.bioconductor.cagrid.caaffy.valuedomain", "NormalizeMethod"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("constant");
        elemField.setXmlName(new javax.xml.namespace.QName("", "constant"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contrasts");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contrasts"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("invariantSet");
        elemField.setXmlName(new javax.xml.namespace.QName("", "invariantSet"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("loess");
        elemField.setXmlName(new javax.xml.namespace.QName("", "loess"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("QSpline");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qSpline"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("quantiles");
        elemField.setXmlName(new javax.xml.namespace.QName("", "quantiles"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("quantilesRobust");
        elemField.setXmlName(new javax.xml.namespace.QName("", "quantilesRobust"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
