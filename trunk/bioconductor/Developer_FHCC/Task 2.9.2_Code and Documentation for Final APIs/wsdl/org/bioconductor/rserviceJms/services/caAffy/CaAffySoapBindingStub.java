/**
 * CaAffySoapBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC2 Mar 03, 2006 (12:17:06 EST) WSDL2Java emitter.
 */

package org.bioconductor.rserviceJms.services.caAffy;

public class CaAffySoapBindingStub extends org.apache.axis.client.Stub implements org.bioconductor.rserviceJms.services.caAffy.CaAffy {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[2];
        _initOperationDesc1();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("caQAReport");
        oper.addParameter(new javax.xml.namespace.QName("http://www.bioconductor.org/services/caAffy", "in0"), new javax.xml.namespace.QName("http://caAffy.packages.bioconductor.org", "DerivedBioAssays"), org.bioconductor.packages.caAffy.DerivedBioAssays.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("http://www.bioconductor.org/services/caAffy", "in1"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String[].class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://caAffy.packages.bioconductor.org", "QaReport"));
        oper.setReturnClass(org.bioconductor.packages.caAffy.QaReport.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.bioconductor.org/services/caAffy", "caQAReportReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("caExpresso");
        oper.addParameter(new javax.xml.namespace.QName("http://www.bioconductor.org/services/caAffy", "in0"), new javax.xml.namespace.QName("http://caAffy.packages.bioconductor.org", "DerivedBioAssays"), org.bioconductor.packages.caAffy.DerivedBioAssays.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("http://www.bioconductor.org/services/caAffy", "in1"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String[].class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("http://www.bioconductor.org/services/caAffy", "in2"), new javax.xml.namespace.QName("http://caAffy.packages.bioconductor.org", "ExpressoParameter"), org.bioconductor.packages.caAffy.ExpressoParameter.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://caAffy.packages.bioconductor.org", "DerivedBioAssays"));
        oper.setReturnClass(org.bioconductor.packages.caAffy.DerivedBioAssays.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.bioconductor.org/services/caAffy", "caExpressoReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[1] = oper;

    }

    public CaAffySoapBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public CaAffySoapBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public CaAffySoapBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://www.bioconductor.org/services/caAffy", "ArrayOf_xsd_string");
            cachedSerQNames.add(qName);
            cls = org.bioconductor.rserviceJms.services.caAffy.ArrayOf_xsd_string.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.bioconductor.org/services/rservices", "RJMatrix");
            cachedSerQNames.add(qName);
            cls = org.bioconductor.packages.rservices.RJMatrix.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://bioassay.domain.mageom.nci.nih.gov", "BioAssayData");
            cachedSerQNames.add(qName);
            cls = gov.nih.nci.mageom.domain.bioassay.BioAssayData.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("gme://caArray.caBIG/1.1/gov.nih.nci.mageom.domain.BioAssay", "BioDataValues");
            cachedSerQNames.add(qName);
            cls = BioDataValues.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.bioconductor.org/services/rservices", "RJCharMatrix");
            cachedSerQNames.add(qName);
            cls = org.bioconductor.packages.rservices.RJCharMatrix.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://bioassay.domain.mageom.nci.nih.gov", "Extendable");
            cachedSerQNames.add(qName);
            cls = gov.nih.nci.mageom.domain.bioassay.Extendable.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.bioconductor.org/services/rservices", "RJRawArray");
            cachedSerQNames.add(qName);
            cls = org.bioconductor.packages.rservices.RJRawArray.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://bioassay.domain.mageom.nci.nih.gov", "Identifiable");
            cachedSerQNames.add(qName);
            cls = gov.nih.nci.mageom.domain.bioassay.Identifiable.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.bioconductor.org/services/rservices", "RJNumericMatrix");
            cachedSerQNames.add(qName);
            cls = org.bioconductor.packages.rservices.RJNumericMatrix.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.bioconductor.org/services/rservices", "RJArray");
            cachedSerQNames.add(qName);
            cls = org.bioconductor.packages.rservices.RJArray.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("gme://caArray.caBIG/1.1/gov.nih.nci.mageom.domain.BioAssay", "DesignElementDimension");
            cachedSerQNames.add(qName);
            cls = DesignElementDimension.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("gme://caArray.caBIG/1.1/gov.nih.nci.mageom.domain.BioAssay", "QuantitationTypeDimension");
            cachedSerQNames.add(qName);
            cls = QuantitationTypeDimension.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://caAffy.packages.bioconductor.org", "ExpressoParameter");
            cachedSerQNames.add(qName);
            cls = org.bioconductor.packages.caAffy.ExpressoParameter.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://caAffy.packages.bioconductor.org", "DerivedBioAssays");
            cachedSerQNames.add(qName);
            cls = org.bioconductor.packages.caAffy.DerivedBioAssays.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("gme://caArray.caBIG/1.1/gov.nih.nci.mageom.domain.BioAssay", "BioAssay");
            cachedSerQNames.add(qName);
            cls = BioAssay.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.bioconductor.org/services/rservices", "RJComplexArray");
            cachedSerQNames.add(qName);
            cls = org.bioconductor.packages.rservices.RJComplexArray.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.bioconductor.org/services/caAffy", "ArrayOf_xsd_anyType");
            cachedSerQNames.add(qName);
            cls = org.bioconductor.rserviceJms.services.caAffy.ArrayOf_xsd_anyType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.bioconductor.org/services/rservices", "RJLogicalArray");
            cachedSerQNames.add(qName);
            cls = org.bioconductor.packages.rservices.RJLogicalArray.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.bioconductor.org/services/rservices", "RJNumericArray");
            cachedSerQNames.add(qName);
            cls = org.bioconductor.packages.rservices.RJNumericArray.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("gme://caArray.caBIG/1.1/gov.nih.nci.mageom.domain.BioAssay", "QuantitationType");
            cachedSerQNames.add(qName);
            cls = QuantitationType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("gme://caArray.caBIG/1.1/gov.nih.nci.mageom.domain.BioAssay", "DerivedBioAssayData");
            cachedSerQNames.add(qName);
            cls = DerivedBioAssayData.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.bioconductor.org/services/rservices", "RJIntegerArray");
            cachedSerQNames.add(qName);
            cls = org.bioconductor.packages.rservices.RJIntegerArray.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.bioconductor.org/services/caAffy", "ArrayOf_xsd_double");
            cachedSerQNames.add(qName);
            cls = org.bioconductor.rserviceJms.services.caAffy.ArrayOf_xsd_double.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.bioconductor.org/services/rservices", "RJFactor");
            cachedSerQNames.add(qName);
            cls = org.bioconductor.packages.rservices.RJFactor.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.bioconductor.org/services/rservices", "RJRawMatrix");
            cachedSerQNames.add(qName);
            cls = org.bioconductor.packages.rservices.RJRawMatrix.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://bioassay.domain.mageom.nci.nih.gov", "BioAssay");
            cachedSerQNames.add(qName);
            cls = gov.nih.nci.mageom.domain.bioassay.BioAssay.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://caAffy.packages.bioconductor.org", "QaReport");
            cachedSerQNames.add(qName);
            cls = org.bioconductor.packages.caAffy.QaReport.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.bioconductor.org/services/caAffy", "ArrayOf_xsd_int");
            cachedSerQNames.add(qName);
            cls = org.bioconductor.rserviceJms.services.caAffy.ArrayOf_xsd_int.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.bioconductor.org/services/rservices", "RJIntegerMatrix");
            cachedSerQNames.add(qName);
            cls = org.bioconductor.packages.rservices.RJIntegerMatrix.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://caAffy.packages.bioconductor.org", "NormalizeMethodParameter");
            cachedSerQNames.add(qName);
            cls = org.bioconductor.packages.caAffy.NormalizeMethodParameter.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.bioconductor.org/services/rservices", "RJComplex");
            cachedSerQNames.add(qName);
            cls = org.bioconductor.packages.rservices.RJComplex.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.bioconductor.org/services/caAffy", "ArrayOf_tns4_DerivedBioAssay");
            cachedSerQNames.add(qName);
            cls = org.bioconductor.rserviceJms.services.caAffy.ArrayOf_tns4_DerivedBioAssay.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("gme://caArray.caBIG/1.1/gov.nih.nci.mageom.domain.BioAssay", "BioAssayDimension");
            cachedSerQNames.add(qName);
            cls = BioAssayDimension.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.bioconductor.org/services/rservices", "RJDataFrame");
            cachedSerQNames.add(qName);
            cls = org.bioconductor.packages.rservices.RJDataFrame.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.bioconductor.org/services/rservices", "RJCharArray");
            cachedSerQNames.add(qName);
            cls = org.bioconductor.packages.rservices.RJCharArray.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://bioassay.domain.mageom.nci.nih.gov", "Describable");
            cachedSerQNames.add(qName);
            cls = gov.nih.nci.mageom.domain.bioassay.Describable.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.bioconductor.org/services/caAffy", "ArrayOf_xsd_boolean");
            cachedSerQNames.add(qName);
            cls = org.bioconductor.rserviceJms.services.caAffy.ArrayOf_xsd_boolean.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.bioconductor.org/services/rservices", "RJComplexMatrix");
            cachedSerQNames.add(qName);
            cls = org.bioconductor.packages.rservices.RJComplexMatrix.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://bioassay.domain.mageom.nci.nih.gov", "DerivedBioAssay");
            cachedSerQNames.add(qName);
            cls = gov.nih.nci.mageom.domain.bioassay.DerivedBioAssay.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.bioconductor.org/services/rservices", "RJLogicalMatrix");
            cachedSerQNames.add(qName);
            cls = org.bioconductor.packages.rservices.RJLogicalMatrix.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call =
                    (org.apache.axis.client.Call) super.service.createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public org.bioconductor.packages.caAffy.QaReport caQAReport(org.bioconductor.packages.caAffy.DerivedBioAssays in0, java.lang.String[] in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.bioconductor.org/services/caAffy", "caQAReport"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.bioconductor.packages.caAffy.QaReport) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.bioconductor.packages.caAffy.QaReport) org.apache.axis.utils.JavaUtils.convert(_resp, org.bioconductor.packages.caAffy.QaReport.class);
            }
        }
    }

    public org.bioconductor.packages.caAffy.DerivedBioAssays caExpresso(org.bioconductor.packages.caAffy.DerivedBioAssays in0, java.lang.String[] in1, org.bioconductor.packages.caAffy.ExpressoParameter in2) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.bioconductor.org/services/caAffy", "caExpresso"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1, in2});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.bioconductor.packages.caAffy.DerivedBioAssays) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.bioconductor.packages.caAffy.DerivedBioAssays) org.apache.axis.utils.JavaUtils.convert(_resp, org.bioconductor.packages.caAffy.DerivedBioAssays.class);
            }
        }
    }

}
