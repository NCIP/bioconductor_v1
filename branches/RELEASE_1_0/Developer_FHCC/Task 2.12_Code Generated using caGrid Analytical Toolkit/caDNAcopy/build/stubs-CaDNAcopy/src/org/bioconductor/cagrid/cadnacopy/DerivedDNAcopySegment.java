/**
 * DerivedDNAcopySegment.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC2 Apr 28, 2006 (12:42:00 EDT) WSDL2Java emitter.
 */

package org.bioconductor.cagrid.cadnacopy;

public class DerivedDNAcopySegment  implements java.io.Serializable {
    private double[] averageSegmentValue;
    private java.lang.String[] chromosomeIndex;
    private long[] endMapPosition;
    private int[] markersPerSegment;
    private java.lang.String[] sampleId;
    private long[] startMapPosition;

    public DerivedDNAcopySegment() {
    }

    public DerivedDNAcopySegment(
           double[] averageSegmentValue,
           java.lang.String[] chromosomeIndex,
           long[] endMapPosition,
           int[] markersPerSegment,
           java.lang.String[] sampleId,
           long[] startMapPosition) {
           this.averageSegmentValue = averageSegmentValue;
           this.chromosomeIndex = chromosomeIndex;
           this.endMapPosition = endMapPosition;
           this.markersPerSegment = markersPerSegment;
           this.sampleId = sampleId;
           this.startMapPosition = startMapPosition;
    }


    /**
     * Gets the averageSegmentValue value for this DerivedDNAcopySegment.
     * 
     * @return averageSegmentValue
     */
    public double[] getAverageSegmentValue() {
        return averageSegmentValue;
    }


    /**
     * Sets the averageSegmentValue value for this DerivedDNAcopySegment.
     * 
     * @param averageSegmentValue
     */
    public void setAverageSegmentValue(double[] averageSegmentValue) {
        this.averageSegmentValue = averageSegmentValue;
    }

    public double getAverageSegmentValue(int i) {
        return this.averageSegmentValue[i];
    }

    public void setAverageSegmentValue(int i, double _value) {
        this.averageSegmentValue[i] = _value;
    }


    /**
     * Gets the chromosomeIndex value for this DerivedDNAcopySegment.
     * 
     * @return chromosomeIndex
     */
    public java.lang.String[] getChromosomeIndex() {
        return chromosomeIndex;
    }


    /**
     * Sets the chromosomeIndex value for this DerivedDNAcopySegment.
     * 
     * @param chromosomeIndex
     */
    public void setChromosomeIndex(java.lang.String[] chromosomeIndex) {
        this.chromosomeIndex = chromosomeIndex;
    }

    public java.lang.String getChromosomeIndex(int i) {
        return this.chromosomeIndex[i];
    }

    public void setChromosomeIndex(int i, java.lang.String _value) {
        this.chromosomeIndex[i] = _value;
    }


    /**
     * Gets the endMapPosition value for this DerivedDNAcopySegment.
     * 
     * @return endMapPosition
     */
    public long[] getEndMapPosition() {
        return endMapPosition;
    }


    /**
     * Sets the endMapPosition value for this DerivedDNAcopySegment.
     * 
     * @param endMapPosition
     */
    public void setEndMapPosition(long[] endMapPosition) {
        this.endMapPosition = endMapPosition;
    }

    public long getEndMapPosition(int i) {
        return this.endMapPosition[i];
    }

    public void setEndMapPosition(int i, long _value) {
        this.endMapPosition[i] = _value;
    }


    /**
     * Gets the markersPerSegment value for this DerivedDNAcopySegment.
     * 
     * @return markersPerSegment
     */
    public int[] getMarkersPerSegment() {
        return markersPerSegment;
    }


    /**
     * Sets the markersPerSegment value for this DerivedDNAcopySegment.
     * 
     * @param markersPerSegment
     */
    public void setMarkersPerSegment(int[] markersPerSegment) {
        this.markersPerSegment = markersPerSegment;
    }

    public int getMarkersPerSegment(int i) {
        return this.markersPerSegment[i];
    }

    public void setMarkersPerSegment(int i, int _value) {
        this.markersPerSegment[i] = _value;
    }


    /**
     * Gets the sampleId value for this DerivedDNAcopySegment.
     * 
     * @return sampleId
     */
    public java.lang.String[] getSampleId() {
        return sampleId;
    }


    /**
     * Sets the sampleId value for this DerivedDNAcopySegment.
     * 
     * @param sampleId
     */
    public void setSampleId(java.lang.String[] sampleId) {
        this.sampleId = sampleId;
    }

    public java.lang.String getSampleId(int i) {
        return this.sampleId[i];
    }

    public void setSampleId(int i, java.lang.String _value) {
        this.sampleId[i] = _value;
    }


    /**
     * Gets the startMapPosition value for this DerivedDNAcopySegment.
     * 
     * @return startMapPosition
     */
    public long[] getStartMapPosition() {
        return startMapPosition;
    }


    /**
     * Sets the startMapPosition value for this DerivedDNAcopySegment.
     * 
     * @param startMapPosition
     */
    public void setStartMapPosition(long[] startMapPosition) {
        this.startMapPosition = startMapPosition;
    }

    public long getStartMapPosition(int i) {
        return this.startMapPosition[i];
    }

    public void setStartMapPosition(int i, long _value) {
        this.startMapPosition[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DerivedDNAcopySegment)) return false;
        DerivedDNAcopySegment other = (DerivedDNAcopySegment) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.averageSegmentValue==null && other.getAverageSegmentValue()==null) || 
             (this.averageSegmentValue!=null &&
              java.util.Arrays.equals(this.averageSegmentValue, other.getAverageSegmentValue()))) &&
            ((this.chromosomeIndex==null && other.getChromosomeIndex()==null) || 
             (this.chromosomeIndex!=null &&
              java.util.Arrays.equals(this.chromosomeIndex, other.getChromosomeIndex()))) &&
            ((this.endMapPosition==null && other.getEndMapPosition()==null) || 
             (this.endMapPosition!=null &&
              java.util.Arrays.equals(this.endMapPosition, other.getEndMapPosition()))) &&
            ((this.markersPerSegment==null && other.getMarkersPerSegment()==null) || 
             (this.markersPerSegment!=null &&
              java.util.Arrays.equals(this.markersPerSegment, other.getMarkersPerSegment()))) &&
            ((this.sampleId==null && other.getSampleId()==null) || 
             (this.sampleId!=null &&
              java.util.Arrays.equals(this.sampleId, other.getSampleId()))) &&
            ((this.startMapPosition==null && other.getStartMapPosition()==null) || 
             (this.startMapPosition!=null &&
              java.util.Arrays.equals(this.startMapPosition, other.getStartMapPosition())));
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
        if (getAverageSegmentValue() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAverageSegmentValue());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAverageSegmentValue(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getChromosomeIndex() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getChromosomeIndex());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getChromosomeIndex(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getEndMapPosition() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getEndMapPosition());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getEndMapPosition(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getMarkersPerSegment() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMarkersPerSegment());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMarkersPerSegment(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getSampleId() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSampleId());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSampleId(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getStartMapPosition() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getStartMapPosition());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getStartMapPosition(), i);
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
        new org.apache.axis.description.TypeDesc(DerivedDNAcopySegment.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://org.bioconductor.cabig/1.0/org.bioconductor.cagrid.cadnacopy", "DerivedDNAcopySegment"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("averageSegmentValue");
        elemField.setXmlName(new javax.xml.namespace.QName("", "averageSegmentValue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("chromosomeIndex");
        elemField.setXmlName(new javax.xml.namespace.QName("", "chromosomeIndex"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("endMapPosition");
        elemField.setXmlName(new javax.xml.namespace.QName("", "endMapPosition"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("markersPerSegment");
        elemField.setXmlName(new javax.xml.namespace.QName("", "markersPerSegment"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sampleId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sampleId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("startMapPosition");
        elemField.setXmlName(new javax.xml.namespace.QName("", "startMapPosition"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
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
