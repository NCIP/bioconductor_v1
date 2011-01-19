package org.bioconductor.packages.caGeneSetAnalysis.common;

import javax.xml.namespace.QName;


public interface CaGeneSetAnalysisConstants {
	public static final String SERVICE_NS = "http://caGeneSetAnalysis.packages.bioconductor.org/CaGeneSetAnalysis";
	public static final QName RESOURCE_KEY = new QName(SERVICE_NS, "CaGeneSetAnalysisKey");
	public static final QName RESOURCE_PROPERTY_SET = new QName(SERVICE_NS, "CaGeneSetAnalysisResourceProperties");

	//Service level metadata (exposed as resouce properties)
	public static final QName SERVICEMETADATA = new QName("gme://caGrid.caBIG/1.0/gov.nih.nci.cagrid.metadata", "ServiceMetadata");
	
}
