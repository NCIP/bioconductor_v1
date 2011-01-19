package org.bioconductor.packages.caArrayQualityMetrics.common;

import javax.xml.namespace.QName;


public interface CaArrayQualityMetricsConstants {
	public static final String SERVICE_NS = "http://caArrayQualityMetrics.packages.bioconductor.org/CaArrayQualityMetrics";
	public static final QName RESOURCE_KEY = new QName(SERVICE_NS, "CaArrayQualityMetricsKey");
	public static final QName RESOURCE_PROPERTY_SET = new QName(SERVICE_NS, "CaArrayQualityMetricsResourceProperties");

	//Service level metadata (exposed as resouce properties)
	public static final QName SERVICEMETADATA = new QName("gme://caGrid.caBIG/1.0/gov.nih.nci.cagrid.metadata", "ServiceMetadata");
	
}
