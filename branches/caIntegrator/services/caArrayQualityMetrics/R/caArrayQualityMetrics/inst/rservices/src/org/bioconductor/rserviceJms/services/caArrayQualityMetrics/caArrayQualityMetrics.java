
package org.bioconductor.rserviceJms.services.caArrayQualityMetrics;
import org.apache.activemq.ActiveMQConnectionFactory;
import javax.jms.ConnectionFactory;
import javax.jms.Connection;
import org.bioconductor.packages.rservices.RServicesConnection;
import java.util.*;


public class caArrayQualityMetrics {
	private ConnectionFactory connectionFactory;
	private String queueName;
	private long timeout;
	private org.bioconductor.packages.caArrayQualityMetrics.caArrayQualityMetricsFunction mycaArrayQualityMetrics;

	public caArrayQualityMetrics() throws Exception {
		caArrayQualityMetricsProperties prop = new caArrayQualityMetricsProperties();
		String jmsUrl = "tcp://" + prop.getProperty("jms.host") + ":"+prop.getProperty("jms.port");
		String timeoutStr = prop.getProperty("jms.timeout", "6000");
		timeout=(new Long(timeoutStr)).longValue();
		connectionFactory = new ActiveMQConnectionFactory(jmsUrl);
		queueName = prop.getProperty("jms.queue", "BIOC");
		mycaArrayQualityMetrics= new org.bioconductor.packages.caArrayQualityMetrics.caArrayQualityMetricsFunction();
	}
	public org.bioconductor.packages.rservices.RJFileReferences caArrayQualityMetrics(org.bioconductor.packages.rservices.RJFileReferences inputFileReferences) throws java.rmi.RemoteException {
		org.bioconductor.packages.rservices.RJFileReferences ans=null;
		try {
			Connection jmsConnection = connectionFactory.createConnection();
			RServicesConnection connection = new RServicesConnection( jmsConnection, queueName, timeout );
			 ans= mycaArrayQualityMetrics.caArrayQualityMetrics( inputFileReferences, connection );
		} catch (Exception rex) {
			throw new java.rmi.RemoteException(rex.getMessage());
		}
		return ans;
	}
	
	public Object uploadFile(String strUploadFileTo, String strUploadFileFrom) throws java.rmi.RemoteException
	{
		try {
			Connection jmsConnection = connectionFactory.createConnection();
			RServicesConnection connection = new RServicesConnection( jmsConnection, queueName, timeout );
			return mycaArrayQualityMetrics.uploadFile(strUploadFileTo, strUploadFileFrom, connection );
		} catch (Exception rex) {
			throw new java.rmi.RemoteException(rex.getMessage());
		}
	}
}
