package com.ash.bhatinda.routes;

import com.ash.bhatinda.processors.LoggingProcessor;
import org.apache.camel.builder.RouteBuilder;

/**
 * Author : az
 * Date: 4/14/13
 * Time: 5:34 PM
 */
public class FtpToJms extends RouteBuilder {
	@Override
	public void configure() throws Exception {
		from("ftp://localhost/orders?noop=true")
				.process(new LoggingProcessor())
				.to("jms:queue:incomingOrders");
	}
}
