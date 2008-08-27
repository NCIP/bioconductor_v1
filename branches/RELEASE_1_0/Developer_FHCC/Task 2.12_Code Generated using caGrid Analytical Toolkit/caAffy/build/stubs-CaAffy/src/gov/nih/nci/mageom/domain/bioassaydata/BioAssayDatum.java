/**
 * BioAssayDatum.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC2 Apr 28, 2006 (12:42:00 EDT) WSDL2Java emitter.
 */

package gov.nih.nci.mageom.domain.bioassaydata;


/**
 * A single cell of the quantitation, bioAssay, designElement matrix.
 */
public class BioAssayDatum  extends gov.nih.nci.mageom.domain.Extendable  implements java.io.Serializable {
    /** The datum value. */
    private java.lang.String value;
    private gov.nih.nci.mageom.domain.quantitationtype.QuantitationType quantitationType;
    private gov.nih.nci.mageom.domain.designelement.DesignElement designElement;
    private gov.nih.nci.mageom.domain.bioassay.BioAssay bioAssay;

    public BioAssayDatum() {
    }

    public BioAssayDatum(
           gov.nih.nci.mageom.domain.bioassay.BioAssay bioAssay,
           gov.nih.nci.mageom.domain.designelement.DesignElement designElement,
           gov.nih.nci.mageom.domain.quantitationtype.QuantitationType quantitationType,
           java.lang.String value) {
           this.value = value;
           this.quantitationType = quantitationType;
           this.designElement = designElement;
           this.bioAssay = bioAssay;
    }


    /**
     * Gets the value value for this BioAssayDatum.
     * 
     * @return value The datum value.
     */
    public java.lang.String getValue() {
        return value;
    }


    /**
     * Sets the value value for this BioAssayDatum.
     * 
     * @param value The datum value.
     */
    public void setValue(java.lang.String value) {
        this.value = value;
    }


    /**
     * Gets the quantitationType value for this BioAssayDatum.
     * 
     * @return quantitationType
     */
    public gov.nih.nci.mageom.domain.quantitationtype.QuantitationType getQuantitationType() {
        return quantitationType;
    }


    /**
     * Sets the quantitationType value for this BioAssayDatum.
     * 
     * @param quantitationType
     */
    public void setQuantitationType(gov.nih.nci.mageom.domain.quantitationtype.QuantitationType quantitationType) {
        this.quantitationType = quantitationType;
    }


    /**
     * Gets the designElement value for this BioAssayDatum.
     * 
     * @return designElement
     */
    public gov.nih.nci.mageom.domain.designelement.DesignElement getDesignElement() {
        return designElement;
    }


    /**
     * Sets the designElement value for this BioAssayDatum.
     * 
     * @param designElement
     */
    public void setDesignElement(gov.nih.nci.mageom.domain.designelement.DesignElement designElement) {
        this.designElement = designElement;
    }


    /**
     * Gets the bioAssay value for this BioAssayDatum.
     * 
     * @return bioAssay
     */
    public gov.nih.nci.mageom.domain.bioassay.BioAssay getBioAssay() {
        return bioAssay;
    }


    /**
     * Sets the bioAssay value for this BioAssayDatum.
     * 
     * @param bioAssay
     */
    public void setBioAssay(gov.nih.nci.mageom.domain.bioassay.BioAssay bioAssay) {
        this.bioAssay = bioAssay;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BioAssayDatum)) return false;
        BioAssayDatum other = (BioAssayDatum) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.value==null && other.getValue()==null) || 
             (this.value!=null &&
              this.value.equals(other.getValue()))) &&
            ((this.quantitationType==null && other.getQuantitationType()==null) || 
             (this.quantitationType!=null &&
              this.quantitationType.equals(other.getQuantitationType()))) &&
            ((this.designElement==null && other.getDesignElement()==null) || 
             (this.designElement!=null &&
              this.designElement.equals(other.getDesignElement()))) &&
            ((this.bioAssay==null && other.getBioAssay()==null) || 
             (this.bioAssay!=null &&
              this.bioAssay.equals(other.getBioAssay())));
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
        if (getValue() != null) {
            _hashCode += getValue().hashCode();
        }
        if (getQuantitationType() != null) {
            _hashCode += getQuantitationType().hashCode();
        }
        if (getDesignElement() != null) {
            _hashCode += getDesignElement().hashCode();
        }
        if (getBioAssay() != null) {
            _hashCode += getBioAssay().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(BioAssayDatum.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("gme://caArray.caBIG/1.1/gov.nih.nci.mageom.domain.BioAssayData", "BioAssayDatum"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("value");
        elemField.setXmlName(new javax.xml.namespace.QName("", "value"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("quantitationType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "quantitationType"));
        elemField.setXmlType(new javax.xml.namespace.QName("gme://caArray.caBIG/1.1/gov.nih.nci.mageom.domain.QuantitationType", "QuantitationType"));
        elemField.setMinOccurs(0);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("designElement");
        elemField.setXmlName(new javax.xml.namespace.QName("", "designElement"));
        elemField.setXmlType(new javax.xml.namespace.QName("gme://caArray.caBIG/1.1/gov.nih.nci.mageom.domain.DesignElement", "DesignElement"));
        elemField.setMinOccurs(0);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bioAssay");
        elemField.setXmlName(new javax.xml.namespace.QName("", "bioAssay"));
        elemField.setXmlType(new javax.xml.namespace.QName("gme://caArray.caBIG/1.1/gov.nih.nci.mageom.domain.BioAssay", "BioAssay"));
        elemField.setMinOccurs(0);
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
