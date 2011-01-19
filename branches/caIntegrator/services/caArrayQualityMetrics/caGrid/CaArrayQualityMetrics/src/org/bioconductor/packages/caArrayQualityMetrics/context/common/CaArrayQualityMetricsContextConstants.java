package org.bioconductor.packages.caArrayQualityMetrics.context.common;

import javax.xml.namespace.QName;


public interface CaArrayQualityMetricsContextConstants {
	public static final String SERVICE_NS = "http://caArrayQualityMetrics.packages.bioconductor.org/CaArrayQualityMetrics/Context";
	public static final QName RESOURCE_KEY = new QName(SERVICE_NS, "CaArrayQualityMetricsContextKey");
	public static final QName RESOURCE_PROPERTY_SET = new QName(SERVICE_NS, "CaArrayQualityMetricsContextResourceProperties");

	//Service level metadata (exposed as resouce properties)
	public static final QName CURRENTTIME = new QName("http://docs.oasis-open.org/wsrf/2004/06/wsrf-WS-ResourceLifetime-1.2-draft-01.xsd", "CurrentTime");
	public static final QName TERMINATIONTIME = new QName("http://docs.oasis-open.org/wsrf/2004/06/wsrf-WS-ResourceLifetime-1.2-draft-01.xsd", "TerminationTime");
	
}
