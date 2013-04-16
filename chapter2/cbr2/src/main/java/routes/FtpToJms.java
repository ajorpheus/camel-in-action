package routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;
import processors.QueueLoggingProcessor;

/**
 * Author : az
 * Date: 4/15/13
 * Time: 10:09 PM
 */
@Component
public class FtpToJms extends RouteBuilder {
	@Override
	public void configure() throws Exception {
		from("ftp://localhost/orders?noop=true")
				.choice()
				.when(header("CamelFileName").endsWith(".xml"))
					.to("jms:xmlOrders")
					.process(new QueueLoggingProcessor("xmlOrders"))
				.when(header("CamelFileName").endsWith(".csv"))
					.to("jms:csvOrders")
					.process(new QueueLoggingProcessor("csvOrders"))
				.otherwise()
					.to("jms:badOrders")
					.process(new QueueLoggingProcessor("badOrders"))
					.stop()
				.end();
	}
}
