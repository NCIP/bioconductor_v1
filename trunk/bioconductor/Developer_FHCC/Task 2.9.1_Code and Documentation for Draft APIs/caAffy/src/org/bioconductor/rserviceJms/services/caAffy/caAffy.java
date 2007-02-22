
package org.bioconductor.rserviceJms.services.caAffy;
import org.apache.activemq.ActiveMQConnectionFactory;
import javax.jms.ConnectionFactory;
import javax.jms.Connection;
import org.bioconductor.packages.rservices.RServicesConnection;
import java.util.*;


public class caAffy {
	private ConnectionFactory connectionFactory;
	private String queueName;
	private long timeout;
	private org.bioconductor.packages.caAffy.caAffy mycaAffy;

	public caAffy() throws Exception {
		caAffyProperties prop = new caAffyProperties();
		String jmsUrl = "tcp://" + prop.getProperty("jms.host") + ":"+prop.getProperty("jms.port");
		String timeoutStr = prop.getProperty("jms.timeout", "6000");
		timeout=(new Long(timeoutStr)).longValue();
		connectionFactory = new ActiveMQConnectionFactory(jmsUrl);
		queueName = prop.getProperty("jms.queue", "BIOC");
		mycaAffy= new org.bioconductor.packages.caAffy.caAffy();
	}
	public org.bioconductor.packages.caAffy.QaReport caQAReport(org.bioconductor.packages.caAffy.MeasuredBioAssayMatrix measuredBioAssays) throws java.rmi.RemoteException {
		org.bioconductor.packages.caAffy.QaReport ans=null;
		try {
			Connection jmsConnection = connectionFactory.createConnection();
			RServicesConnection connection = new RServicesConnection( jmsConnection, queueName, timeout );
			 ans= mycaAffy.caQAReport( measuredBioAssays, connection );
		} catch (Exception rex) {
			throw new java.rmi.RemoteException(rex.getMessage());
		}
		return ans;
	}
	public org.bioconductor.packages.caAffy.DerivedBioAssayMatrix caExpresso(org.bioconductor.packages.caAffy.MeasuredBioAssayMatrix measuredBioAssays, org.bioconductor.packages.caAffy.ExpressoParameter expressoParameter) throws java.rmi.RemoteException {
		org.bioconductor.packages.caAffy.DerivedBioAssayMatrix ans=null;
		try {
			Connection jmsConnection = connectionFactory.createConnection();
			RServicesConnection connection = new RServicesConnection( jmsConnection, queueName, timeout );
			 ans= mycaAffy.caExpresso( measuredBioAssays, expressoParameter, connection );
		} catch (Exception rex) {
			throw new java.rmi.RemoteException(rex.getMessage());
		}
		return ans;
	}
}
