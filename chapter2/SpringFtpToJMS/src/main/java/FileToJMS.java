import common.FtpToJMSRoute;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

/**
 * User: az
 * Date: 4/12/13
 * Time: 7:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class FileToJMS {
	public static void main(String[] args) throws Exception {
		CamelContext camelContext = new DefaultCamelContext();

		final ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
		camelContext.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
		camelContext.addRoutes(new FtpToJMSRoute());

		camelContext.start();
		Thread.sleep(10000);
		camelContext.stop();
	}
}
