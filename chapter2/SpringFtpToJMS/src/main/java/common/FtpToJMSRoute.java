package common;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * Author : az
 * Date: 4/14/13
 * Time: 8:14 AM
 */
@Component
public class FtpToJMSRoute extends RouteBuilder {
	@Override
	public void configure() throws Exception {
		from("ftp://localhost/orders?noop=true")
				.process(new LoggingProcessor())
				.to("jms:queue:incomingOrders");
	}
}
