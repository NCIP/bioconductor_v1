/**
 * DNAcopyParameter.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC2 Apr 28, 2006 (12:42:00 EDT) WSDL2Java emitter.
 */

package org.bioconductor.cagrid.cadnacopy;

public class DNAcopyParameter  implements java.io.Serializable {
    private double changePointSignificanceLevel;
    private double earlyStoppingCriterion;
    private int permutationReplicates;
    private int randomNumberSeed;

    public DNAcopyParameter() {
    }

    public DNAcopyParameter(
           double changePointSignificanceLevel,
           double earlyStoppingCriterion,
           int permutationReplicates,
           int randomNumberSeed) {
           this.changePointSignificanceLevel = changePointSignificanceLevel;
           this.earlyStoppingCriterion = earlyStoppingCriterion;
           this.permutationReplicates = permutationReplicates;
           this.randomNumberSeed = randomNumberSeed;
    }


    /**
     * Gets the changePointSignificanceLevel value for this DNAcopyParameter.
     * 
     * @return changePointSignificanceLevel
     */
    public double getChangePointSignificanceLevel() {
        return changePointSignificanceLevel;
    }


    /**
     * Sets the changePointSignificanceLevel value for this DNAcopyParameter.
     * 
     * @param changePointSignificanceLevel
     */
    public void setChangePointSignificanceLevel(double changePointSignificanceLevel) {
        this.changePointSignificanceLevel = changePointSignificanceLevel;
    }


    /**
     * Gets the earlyStoppingCriterion value for this DNAcopyParameter.
     * 
     * @return earlyStoppingCriterion
     */
    public double getEarlyStoppingCriterion() {
        return earlyStoppingCriterion;
    }


    /**
     * Sets the earlyStoppingCriterion value for this DNAcopyParameter.
     * 
     * @param earlyStoppingCriterion
     */
    public void setEarlyStoppingCriterion(double earlyStoppingCriterion) {
        this.earlyStoppingCriterion = earlyStoppingCriterion;
    }


    /**
     * Gets the permutationReplicates value for this DNAcopyParameter.
     * 
     * @return permutationReplicates
     */
    public int getPermutationReplicates() {
        return permutationReplicates;
    }


    /**
     * Sets the permutationReplicates value for this DNAcopyParameter.
     * 
     * @param permutationReplicates
     */
    public void setPermutationReplicates(int permutationReplicates) {
        this.permutationReplicates = permutationReplicates;
    }


    /**
     * Gets the randomNumberSeed value for this DNAcopyParameter.
     * 
     * @return randomNumberSeed
     */
    public int getRandomNumberSeed() {
        return randomNumberSeed;
    }


    /**
     * Sets the randomNumberSeed value for this DNAcopyParameter.
     * 
     * @param randomNumberSeed
     */
    public void setRandomNumberSeed(int randomNumberSeed) {
        this.randomNumberSeed = randomNumberSeed;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DNAcopyParameter)) return false;
        DNAcopyParameter other = (DNAcopyParameter) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.changePointSignificanceLevel == other.getChangePointSignificanceLevel() &&
            this.earlyStoppingCriterion == other.getEarlyStoppingCriterion() &&
            this.permutationReplicates == other.getPermutationReplicates() &&
            this.randomNumberSeed == other.getRandomNumberSeed();
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
        _hashCode += new Double(getChangePointSignificanceLevel()).hashCode();
        _hashCode += new Double(getEarlyStoppingCriterion()).hashCode();
        _hashCode += getPermutationReplicates();
        _hashCode += getRandomNumberSeed();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DNAcopyParameter.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://org.bioconductor.cabig/1.0/org.bioconductor.cagrid.cadnacopy", "DNAcopyParameter"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("changePointSignificanceLevel");
        elemField.setXmlName(new javax.xml.namespace.QName("", "changePointSignificanceLevel"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("earlyStoppingCriterion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "earlyStoppingCriterion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("permutationReplicates");
        elemField.setXmlName(new javax.xml.namespace.QName("", "permutationReplicates"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("randomNumberSeed");
        elemField.setXmlName(new javax.xml.namespace.QName("", "randomNumberSeed"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
