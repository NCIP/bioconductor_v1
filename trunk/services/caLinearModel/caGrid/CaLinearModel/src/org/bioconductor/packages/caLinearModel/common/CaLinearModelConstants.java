package org.bioconductor.packages.caLinearModel.common;

import javax.xml.namespace.QName;


public interface CaLinearModelConstants {
	public static final String SERVICE_NS = "http://caLinearModel.packages.bioconductor.org/CaLinearModel";
	public static final QName RESOURCE_KEY = new QName(SERVICE_NS, "CaLinearModelKey");
	public static final QName RESOURCE_PROPERTY_SET = new QName(SERVICE_NS, "CaLinearModelResourceProperties");

	//Service level metadata (exposed as resouce properties)
	public static final QName SERVICEMETADATA = new QName("gme://caGrid.caBIG/1.0/gov.nih.nci.cagrid.metadata", "ServiceMetadata");
	
}
