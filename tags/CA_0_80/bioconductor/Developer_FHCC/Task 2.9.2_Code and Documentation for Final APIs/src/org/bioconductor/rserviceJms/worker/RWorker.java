package org.bioconductor.rserviceJms.worker;
import javax.jms.*;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.bioconductor.packages.rservices.*;
import java.util.*;

public class RWorker {

	public static void main (String[] args) throws Exception {
		RWorkerProperties prop = new RWorkerProperties();
		RWorkerREnv e = new RWorkerREnv(prop);
		String jmsUrl = "tcp://" + prop.getProperty("jms.host") + ":" + prop.getProperty("jms.port");
		String queueName = prop.getProperty("jms.queue", "BIOC");
		Connection connection = null;
		Object ans = null;
		try{
			ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(jmsUrl);
			connection = connectionFactory.createConnection();
			connection.start();
			Session session = connection.createSession(true, 0);
			Destination destination = session.createQueue(queueName);
			MessageConsumer consumer = session.createConsumer(destination);
			MessageProducer producer = session.createProducer(null);
			while(true) {
				Message message = consumer.receive(1);
				if (message != null) {
					Object[] rInputs = (Object[])(((ObjectMessage)message).getObject());
					String rPkgName = message.getStringProperty("package");
					String rFunctionName = message.getStringProperty("function");
					try {
						ans = e.call(rFunctionName, rInputs);
					} catch (Exception rex) {
						ans = rex;
					}
					Message replyMsg = session.createObjectMessage( new Object[]{ans} );
					producer.send(message.getJMSReplyTo(), replyMsg);
					session.commit();
				}
			}
		} catch (Exception jmsex) {
			throw jmsex;
		} finally {
			if (connection != null)
				connection.close();
		}
	}
}
