package com.ash.bhatinda.routes;

import com.ash.bhatinda.processors.LoggingProcessor;
import com.ash.bhatinda.processors.QueueLoggingProcessor;
import org.apache.camel.builder.RouteBuilder;

/**
 * Author : az
 * Date: 4/14/13
 * Time: 6:18 PM
 */
//@Component
public class CbrRoute extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		from("ftp://localhost/orders?noop=true")
		.process(new LoggingProcessor())
		.choice()
				.when(
						header("CamelFileName").endsWith(".xml")
				).to("jms:xmlOrders").process(new QueueLoggingProcessor("Xml Orders"))
				.when(
						header("CamelFileName").endsWith(".csv")
				).to("jms:csvOrders").process(new QueueLoggingProcessor("csvOrders"))
				.otherwise().to("jms:badOrders").process(new QueueLoggingProcessor("Bad Orders"))
		.end();
	}
}
