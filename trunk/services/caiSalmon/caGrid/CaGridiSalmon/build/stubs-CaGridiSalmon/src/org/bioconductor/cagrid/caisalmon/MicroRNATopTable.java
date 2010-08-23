/**
 * MicroRNATopTable.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC2 Apr 28, 2006 (12:42:00 EDT) WSDL2Java emitter.
 */

package org.bioconductor.cagrid.caisalmon;

public class MicroRNATopTable  implements java.io.Serializable {
    private double[] adjustedPValue;
    private java.lang.String[] geneName;
    private double[] logFoldChange;
    private double[] logOdds;
    private java.lang.String[] probeName;
    private double[] PValue;
    private double[] TStatistic;

    public MicroRNATopTable() {
    }

    public MicroRNATopTable(
           double[] PValue,
           double[] TStatistic,
           double[] adjustedPValue,
           java.lang.String[] geneName,
           double[] logFoldChange,
           double[] logOdds,
           java.lang.String[] probeName) {
           this.adjustedPValue = adjustedPValue;
           this.geneName = geneName;
           this.logFoldChange = logFoldChange;
           this.logOdds = logOdds;
           this.probeName = probeName;
           this.PValue = PValue;
           this.TStatistic = TStatistic;
    }


    /**
     * Gets the adjustedPValue value for this MicroRNATopTable.
     * 
     * @return adjustedPValue
     */
    public double[] getAdjustedPValue() {
        return adjustedPValue;
    }


    /**
     * Sets the adjustedPValue value for this MicroRNATopTable.
     * 
     * @param adjustedPValue
     */
    public void setAdjustedPValue(double[] adjustedPValue) {
        this.adjustedPValue = adjustedPValue;
    }

    public double getAdjustedPValue(int i) {
        return this.adjustedPValue[i];
    }

    public void setAdjustedPValue(int i, double _value) {
        this.adjustedPValue[i] = _value;
    }


    /**
     * Gets the geneName value for this MicroRNATopTable.
     * 
     * @return geneName
     */
    public java.lang.String[] getGeneName() {
        return geneName;
    }


    /**
     * Sets the geneName value for this MicroRNATopTable.
     * 
     * @param geneName
     */
    public void setGeneName(java.lang.String[] geneName) {
        this.geneName = geneName;
    }

    public java.lang.String getGeneName(int i) {
        return this.geneName[i];
    }

    public void setGeneName(int i, java.lang.String _value) {
        this.geneName[i] = _value;
    }


    /**
     * Gets the logFoldChange value for this MicroRNATopTable.
     * 
     * @return logFoldChange
     */
    public double[] getLogFoldChange() {
        return logFoldChange;
    }


    /**
     * Sets the logFoldChange value for this MicroRNATopTable.
     * 
     * @param logFoldChange
     */
    public void setLogFoldChange(double[] logFoldChange) {
        this.logFoldChange = logFoldChange;
    }

    public double getLogFoldChange(int i) {
        return this.logFoldChange[i];
    }

    public void setLogFoldChange(int i, double _value) {
        this.logFoldChange[i] = _value;
    }


    /**
     * Gets the logOdds value for this MicroRNATopTable.
     * 
     * @return logOdds
     */
    public double[] getLogOdds() {
        return logOdds;
    }


    /**
     * Sets the logOdds value for this MicroRNATopTable.
     * 
     * @param logOdds
     */
    public void setLogOdds(double[] logOdds) {
        this.logOdds = logOdds;
    }

    public double getLogOdds(int i) {
        return this.logOdds[i];
    }

    public void setLogOdds(int i, double _value) {
        this.logOdds[i] = _value;
    }


    /**
     * Gets the probeName value for this MicroRNATopTable.
     * 
     * @return probeName
     */
    public java.lang.String[] getProbeName() {
        return probeName;
    }


    /**
     * Sets the probeName value for this MicroRNATopTable.
     * 
     * @param probeName
     */
    public void setProbeName(java.lang.String[] probeName) {
        this.probeName = probeName;
    }

    public java.lang.String getProbeName(int i) {
        return this.probeName[i];
    }

    public void setProbeName(int i, java.lang.String _value) {
        this.probeName[i] = _value;
    }


    /**
     * Gets the PValue value for this MicroRNATopTable.
     * 
     * @return PValue
     */
    public double[] getPValue() {
        return PValue;
    }


    /**
     * Sets the PValue value for this MicroRNATopTable.
     * 
     * @param PValue
     */
    public void setPValue(double[] PValue) {
        this.PValue = PValue;
    }

    public double getPValue(int i) {
        return this.PValue[i];
    }

    public void setPValue(int i, double _value) {
        this.PValue[i] = _value;
    }


    /**
     * Gets the TStatistic value for this MicroRNATopTable.
     * 
     * @return TStatistic
     */
    public double[] getTStatistic() {
        return TStatistic;
    }


    /**
     * Sets the TStatistic value for this MicroRNATopTable.
     * 
     * @param TStatistic
     */
    public void setTStatistic(double[] TStatistic) {
        this.TStatistic = TStatistic;
    }

    public double getTStatistic(int i) {
        return this.TStatistic[i];
    }

    public void setTStatistic(int i, double _value) {
        this.TStatistic[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MicroRNATopTable)) return false;
        MicroRNATopTable other = (MicroRNATopTable) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.adjustedPValue==null && other.getAdjustedPValue()==null) || 
             (this.adjustedPValue!=null &&
              java.util.Arrays.equals(this.adjustedPValue, other.getAdjustedPValue()))) &&
            ((this.geneName==null && other.getGeneName()==null) || 
             (this.geneName!=null &&
              java.util.Arrays.equals(this.geneName, other.getGeneName()))) &&
            ((this.logFoldChange==null && other.getLogFoldChange()==null) || 
             (this.logFoldChange!=null &&
              java.util.Arrays.equals(this.logFoldChange, other.getLogFoldChange()))) &&
            ((this.logOdds==null && other.getLogOdds()==null) || 
             (this.logOdds!=null &&
              java.util.Arrays.equals(this.logOdds, other.getLogOdds()))) &&
            ((this.probeName==null && other.getProbeName()==null) || 
             (this.probeName!=null &&
              java.util.Arrays.equals(this.probeName, other.getProbeName()))) &&
            ((this.PValue==null && other.getPValue()==null) || 
             (this.PValue!=null &&
              java.util.Arrays.equals(this.PValue, other.getPValue()))) &&
            ((this.TStatistic==null && other.getTStatistic()==null) || 
             (this.TStatistic!=null &&
              java.util.Arrays.equals(this.TStatistic, other.getTStatistic())));
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
        if (getAdjustedPValue() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAdjustedPValue());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAdjustedPValue(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getGeneName() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getGeneName());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getGeneName(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getLogFoldChange() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getLogFoldChange());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getLogFoldChange(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getLogOdds() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getLogOdds());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getLogOdds(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getProbeName() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getProbeName());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getProbeName(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPValue() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPValue());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPValue(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getTStatistic() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTStatistic());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTStatistic(), i);
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
        new org.apache.axis.description.TypeDesc(MicroRNATopTable.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://org.bioconductor.cabig/1.0/org.bioconductor.cagrid.caisalmon", "MicroRNATopTable"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("adjustedPValue");
        elemField.setXmlName(new javax.xml.namespace.QName("", "AdjustedPValue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("geneName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "GeneName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("logFoldChange");
        elemField.setXmlName(new javax.xml.namespace.QName("", "LogFoldChange"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("logOdds");
        elemField.setXmlName(new javax.xml.namespace.QName("", "LogOdds"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("probeName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ProbeName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PValue");
        elemField.setXmlName(new javax.xml.namespace.QName("", "PValue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("TStatistic");
        elemField.setXmlName(new javax.xml.namespace.QName("", "TStatistic"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
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
