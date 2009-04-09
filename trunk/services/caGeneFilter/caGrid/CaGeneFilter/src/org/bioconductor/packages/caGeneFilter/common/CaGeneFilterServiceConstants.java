package org.bioconductor.packages.caGeneFilter.common;

import javax.xml.namespace.QName;


public interface CaGeneFilterServiceConstants {
	public static final String SERVICE_NS = "http://caGeneFilter.packages.bioconductor.org/CaGeneFilterService";
	public static final QName RESOURCE_KEY = new QName(SERVICE_NS, "CaGeneFilterServiceKey");
	public static final QName RESOURCE_PROPERTY_SET = new QName(SERVICE_NS, "CaGeneFilterServiceResourceProperties");

	//Service level metadata (exposed as resouce properties)
	public static final QName SERVICEMETADATA = new QName("gme://caGrid.caBIG/1.0/gov.nih.nci.cagrid.metadata", "ServiceMetadata");
	
}
