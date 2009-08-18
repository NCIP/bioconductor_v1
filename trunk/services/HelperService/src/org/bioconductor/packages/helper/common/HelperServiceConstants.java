package org.bioconductor.packages.helper.common;

import javax.xml.namespace.QName;


public interface HelperServiceConstants {
	public static final String SERVICE_NS = "http://helper.packages.bioconductor.org/HelperService";
	public static final QName RESOURCE_KEY = new QName(SERVICE_NS, "HelperServiceKey");
	public static final QName RESOURCE_PROPERTY_SET = new QName(SERVICE_NS, "HelperServiceResourceProperties");

	//Service level metadata (exposed as resouce properties)
	public static final QName SERVICEMETADATA = new QName("gme://caGrid.caBIG/1.0/gov.nih.nci.cagrid.metadata", "ServiceMetadata");
	
}
