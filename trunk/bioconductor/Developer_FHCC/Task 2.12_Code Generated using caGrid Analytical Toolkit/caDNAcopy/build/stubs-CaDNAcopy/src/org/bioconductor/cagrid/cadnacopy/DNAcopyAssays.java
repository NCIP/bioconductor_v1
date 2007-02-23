/**
 * DNAcopyAssays.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC2 Apr 28, 2006 (12:42:00 EDT) WSDL2Java emitter.
 */

package org.bioconductor.cagrid.cadnacopy;

public class DNAcopyAssays  implements java.io.Serializable {
    private int[] chromsomeId;
    private long[] mapLocation;
    private org.bioconductor.cagrid.cadnacopy.ExpressionData[] expressionDataCollection;

    public DNAcopyAssays() {
    }

    public DNAcopyAssays(
           int[] chromsomeId,
           org.bioconductor.cagrid.cadnacopy.ExpressionData[] expressionDataCollection,
           long[] mapLocation) {
           this.chromsomeId = chromsomeId;
           this.mapLocation = mapLocation;
           this.expressionDataCollection = expressionDataCollection;
    }


    /**
     * Gets the chromsomeId value for this DNAcopyAssays.
     * 
     * @return chromsomeId
     */
    public int[] getChromsomeId() {
        return chromsomeId;
    }


    /**
     * Sets the chromsomeId value for this DNAcopyAssays.
     * 
     * @param chromsomeId
     */
    public void setChromsomeId(int[] chromsomeId) {
        this.chromsomeId = chromsomeId;
    }

    public int getChromsomeId(int i) {
        return this.chromsomeId[i];
    }

    public void setChromsomeId(int i, int _value) {
        this.chromsomeId[i] = _value;
    }


    /**
     * Gets the mapLocation value for this DNAcopyAssays.
     * 
     * @return mapLocation
     */
    public long[] getMapLocation() {
        return mapLocation;
    }


    /**
     * Sets the mapLocation value for this DNAcopyAssays.
     * 
     * @param mapLocation
     */
    public void setMapLocation(long[] mapLocation) {
        this.mapLocation = mapLocation;
    }

    public long getMapLocation(int i) {
        return this.mapLocation[i];
    }

    public void setMapLocation(int i, long _value) {
        this.mapLocation[i] = _value;
    }


    /**
     * Gets the expressionDataCollection value for this DNAcopyAssays.
     * 
     * @return expressionDataCollection
     */
    public org.bioconductor.cagrid.cadnacopy.ExpressionData[] getExpressionDataCollection() {
        return expressionDataCollection;
    }


    /**
     * Sets the expressionDataCollection value for this DNAcopyAssays.
     * 
     * @param expressionDataCollection
     */
    public void setExpressionDataCollection(org.bioconductor.cagrid.cadnacopy.ExpressionData[] expressionDataCollection) {
        this.expressionDataCollection = expressionDataCollection;
    }

    public org.bioconductor.cagrid.cadnacopy.ExpressionData getExpressionDataCollection(int i) {
        return this.expressionDataCollection[i];
    }

    public void setExpressionDataCollection(int i, org.bioconductor.cagrid.cadnacopy.ExpressionData _value) {
        this.expressionDataCollection[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DNAcopyAssays)) return false;
        DNAcopyAssays other = (DNAcopyAssays) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.chromsomeId==null && other.getChromsomeId()==null) || 
             (this.chromsomeId!=null &&
              java.util.Arrays.equals(this.chromsomeId, other.getChromsomeId()))) &&
            ((this.mapLocation==null && other.getMapLocation()==null) || 
             (this.mapLocation!=null &&
              java.util.Arrays.equals(this.mapLocation, other.getMapLocation()))) &&
            ((this.expressionDataCollection==null && other.getExpressionDataCollection()==null) || 
             (this.expressionDataCollection!=null &&
              java.util.Arrays.equals(this.expressionDataCollection, other.getExpressionDataCollection())));
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
        if (getChromsomeId() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getChromsomeId());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getChromsomeId(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getMapLocation() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMapLocation());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMapLocation(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getExpressionDataCollection() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getExpressionDataCollection());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getExpressionDataCollection(), i);
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
        new org.apache.axis.description.TypeDesc(DNAcopyAssays.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://org.bioconductor.cabig/1.0/org.bioconductor.cagrid.cadnacopy", "DNAcopyAssays"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("chromsomeId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "chromsomeId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mapLocation");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mapLocation"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("expressionDataCollection");
        elemField.setXmlName(new javax.xml.namespace.QName("", "expressionDataCollection"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://org.bioconductor.cabig/1.0/org.bioconductor.cagrid.cadnacopy", "ExpressionData"));
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
