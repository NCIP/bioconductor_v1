package org.bioconductor.packages.caDNAcopy.common;

import javax.xml.namespace.QName;


public interface CaDNAcopyConstants {
	public static final String SERVICE_NS = "http://caDNAcopy.packages.bioconductor.org/CaDNAcopy";
	public static final QName RESOURCE_KEY = new QName(SERVICE_NS, "CaDNAcopyKey");
	public static final QName RESOURCE_PROPERTY_SET = new QName(SERVICE_NS, "CaDNAcopyResourceProperties");

	//Service level metadata (exposed as resouce properties)
	public static final QName SERVICEMETADATA = new QName("gme://caGrid.caBIG/1.0/gov.nih.nci.cagrid.metadata", "ServiceMetadata");
	
}
