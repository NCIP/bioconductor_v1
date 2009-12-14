package org.bioconductor.rserviceJms.worker;
import javax.jms.*;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.bioconductor.packages.rservices.*;
import java.util.*;
import org.bioconductor.packages.rservices.RJFileReferences;
import org.bioconductor.packages.rservices.FileReferences;

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
				Message message = null;
				message = consumer.receive(1);
				if (message != null) {
					// Avoid a worker crash when unwanted object types
					// are sent to the jms queue. The exception will
					// be "Failed to build body from bytes".  That's
					// because getObject() will try to deserialize
					// object in message.  And there's no type
					// matching the object in message.
					Object[] rInputs = null;
					try {
						rInputs = (Object[])(((ObjectMessage)message).getObject());
					}
					catch(Exception ew) {
						ans = ew;
						sendAnswerToJMS(ans, session, producer, message, true);
						continue;
					}

					String rPkgName = message.getStringProperty("package");
					String rFunctionName = message.getStringProperty("function");

					// this is an argument agreement among webservices, R-packages and this worker
					// it looks ambiguous with 2 string arguments but for now, it's internal among those above
					if(rInputs.length == 2 && rInputs[0] instanceof String &&
					   rInputs[1] instanceof String) {
						boolean isError = false;
						try {
							String strUploadFileFrom = (String)rInputs[0];
							String strUploadFileTo = (String)rInputs[1];
							boolean isGood = uploadFile(strUploadFileFrom, strUploadFileTo);
							ans = new Boolean(isGood);

						}
						catch(Exception ew) {
							ans = new Boolean(false);
							isError = true;
						}

						sendAnswerToJMS(ans, session, producer, message, isError);
					}
					else {
						boolean isError = false;
						try {
							ans = e.call(rFunctionName, rInputs);
						} catch (Exception rex) {
							isError = true;
							ans = new Exception(rex.getMessage());
						}

						sendAnswerToJMS(ans, session, producer, message, isError);
					}
				}
			}
		} catch (Exception ew) {
			ew.printStackTrace();
			throw ew;
		}
		finally {

			if (connection != null)
				connection.close();

		}

	}

	private static void sendAnswerToJMS(final Object ans, final Session session, final MessageProducer producer, final Message receivedMsg) throws Exception
	{
		sendAnswerToJMS(ans, session, producer, receivedMsg, false);
	}

	// response back to JMS:
	private static void sendAnswerToJMS(final Object ans, final Session session, final MessageProducer producer, final Message receivedMsg, final boolean bError) throws Exception
	{
		try {
			Message replyMsg = session.createObjectMessage( new Object[]{ans} );
			replyMsg.setBooleanProperty("error", bError);
			producer.send(receivedMsg.getJMSReplyTo(), replyMsg);
			session.commit();
		}
		catch (Exception rex) {
			throw new Exception("sendAnswerToJMS causes exception: " + rex.getMessage());
		}
	}

	public static boolean uploadFile(final String uploadFileFrom, final String uploadFileTo)
	{
		try {
			org.cagrid.transfer.descriptor.DataTransferDescriptor dataTransDesc =
											new org.cagrid.transfer.descriptor.DataTransferDescriptor();
			dataTransDesc.setUrl(uploadFileTo);
			java.io.InputStream inStream = new java.io.FileInputStream(uploadFileFrom);
			org.cagrid.transfer.context.client.helper.TransferClientHelper.putData(inStream, -1, dataTransDesc);
			inStream.close();
			return true;
		}
		catch(Exception ew){
			ew.printStackTrace();
			return false;
		}
	}


}
