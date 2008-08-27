
package org.bioconductor.rserviceJms.services.caDNAcopy;
import org.apache.activemq.ActiveMQConnectionFactory;
import javax.jms.ConnectionFactory;
import javax.jms.Connection;
import org.bioconductor.packages.rservices.RServicesConnection;
import java.util.*;


public class caDNAcopy {
	private ConnectionFactory connectionFactory;
	private String queueName;
	private long timeout;
	private org.bioconductor.packages.caDNAcopy.caDNAcopy mycaDNAcopy;

	public caDNAcopy() throws Exception {
		caDNAcopyProperties prop = new caDNAcopyProperties();
		String jmsUrl = "tcp://" + prop.getProperty("jms.host") + ":"+prop.getProperty("jms.port");
		String timeoutStr = prop.getProperty("jms.timeout", "6000");
		timeout=(new Long(timeoutStr)).longValue();
		connectionFactory = new ActiveMQConnectionFactory(jmsUrl);
		queueName = prop.getProperty("jms.queue", "BIOC");
		mycaDNAcopy= new org.bioconductor.packages.caDNAcopy.caDNAcopy();
	}
	public org.bioconductor.packages.caDNAcopy.DerivedDNAcopySegment caDNAcopy(org.bioconductor.packages.caDNAcopy.DNAcopyAssays dnacopyAssays, org.bioconductor.packages.caDNAcopy.DNAcopyParameter dnacopyParameter) throws java.rmi.RemoteException {
		org.bioconductor.packages.caDNAcopy.DerivedDNAcopySegment ans=null;
		try {
			Connection jmsConnection = connectionFactory.createConnection();
			RServicesConnection connection = new RServicesConnection( jmsConnection, queueName, timeout );
			 ans= mycaDNAcopy.caDNAcopy( dnacopyAssays, dnacopyParameter, connection );
		} catch (Exception rex) {
			throw new java.rmi.RemoteException(rex.getMessage());
		}
		return ans;
	}
}
