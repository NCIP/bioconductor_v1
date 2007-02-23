/**
 * ProbeSummaryMethod.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC2 Apr 28, 2006 (12:42:00 EDT) WSDL2Java emitter.
 */

package org.bioconductor.cagrid.caaffy.valuedomain;

public class ProbeSummaryMethod  implements java.io.Serializable {
    private java.lang.String averageDifference;
    private java.lang.String liWong;
    private java.lang.String mas;
    private java.lang.String medianPolish;
    private java.lang.String playerOut;

    public ProbeSummaryMethod() {
    }

    public ProbeSummaryMethod(
           java.lang.String averageDifference,
           java.lang.String liWong,
           java.lang.String mas,
           java.lang.String medianPolish,
           java.lang.String playerOut) {
           this.averageDifference = averageDifference;
           this.liWong = liWong;
           this.mas = mas;
           this.medianPolish = medianPolish;
           this.playerOut = playerOut;
    }


    /**
     * Gets the averageDifference value for this ProbeSummaryMethod.
     * 
     * @return averageDifference
     */
    public java.lang.String getAverageDifference() {
        return averageDifference;
    }


    /**
     * Sets the averageDifference value for this ProbeSummaryMethod.
     * 
     * @param averageDifference
     */
    public void setAverageDifference(java.lang.String averageDifference) {
        this.averageDifference = averageDifference;
    }


    /**
     * Gets the liWong value for this ProbeSummaryMethod.
     * 
     * @return liWong
     */
    public java.lang.String getLiWong() {
        return liWong;
    }


    /**
     * Sets the liWong value for this ProbeSummaryMethod.
     * 
     * @param liWong
     */
    public void setLiWong(java.lang.String liWong) {
        this.liWong = liWong;
    }


    /**
     * Gets the mas value for this ProbeSummaryMethod.
     * 
     * @return mas
     */
    public java.lang.String getMas() {
        return mas;
    }


    /**
     * Sets the mas value for this ProbeSummaryMethod.
     * 
     * @param mas
     */
    public void setMas(java.lang.String mas) {
        this.mas = mas;
    }


    /**
     * Gets the medianPolish value for this ProbeSummaryMethod.
     * 
     * @return medianPolish
     */
    public java.lang.String getMedianPolish() {
        return medianPolish;
    }


    /**
     * Sets the medianPolish value for this ProbeSummaryMethod.
     * 
     * @param medianPolish
     */
    public void setMedianPolish(java.lang.String medianPolish) {
        this.medianPolish = medianPolish;
    }


    /**
     * Gets the playerOut value for this ProbeSummaryMethod.
     * 
     * @return playerOut
     */
    public java.lang.String getPlayerOut() {
        return playerOut;
    }


    /**
     * Sets the playerOut value for this ProbeSummaryMethod.
     * 
     * @param playerOut
     */
    public void setPlayerOut(java.lang.String playerOut) {
        this.playerOut = playerOut;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ProbeSummaryMethod)) return false;
        ProbeSummaryMethod other = (ProbeSummaryMethod) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.averageDifference==null && other.getAverageDifference()==null) || 
             (this.averageDifference!=null &&
              this.averageDifference.equals(other.getAverageDifference()))) &&
            ((this.liWong==null && other.getLiWong()==null) || 
             (this.liWong!=null &&
              this.liWong.equals(other.getLiWong()))) &&
            ((this.mas==null && other.getMas()==null) || 
             (this.mas!=null &&
              this.mas.equals(other.getMas()))) &&
            ((this.medianPolish==null && other.getMedianPolish()==null) || 
             (this.medianPolish!=null &&
              this.medianPolish.equals(other.getMedianPolish()))) &&
            ((this.playerOut==null && other.getPlayerOut()==null) || 
             (this.playerOut!=null &&
              this.playerOut.equals(other.getPlayerOut())));
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
        if (getAverageDifference() != null) {
            _hashCode += getAverageDifference().hashCode();
        }
        if (getLiWong() != null) {
            _hashCode += getLiWong().hashCode();
        }
        if (getMas() != null) {
            _hashCode += getMas().hashCode();
        }
        if (getMedianPolish() != null) {
            _hashCode += getMedianPolish().hashCode();
        }
        if (getPlayerOut() != null) {
            _hashCode += getPlayerOut().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ProbeSummaryMethod.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://org.bioconductor.cabig/1.0/org.bioconductor.cagrid.caaffy.valuedomain", "ProbeSummaryMethod"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("averageDifference");
        elemField.setXmlName(new javax.xml.namespace.QName("", "averageDifference"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("liWong");
        elemField.setXmlName(new javax.xml.namespace.QName("", "liWong"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("medianPolish");
        elemField.setXmlName(new javax.xml.namespace.QName("", "medianPolish"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("playerOut");
        elemField.setXmlName(new javax.xml.namespace.QName("", "playerOut"));
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
