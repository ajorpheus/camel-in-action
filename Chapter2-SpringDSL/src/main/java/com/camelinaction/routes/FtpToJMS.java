package com.camelinaction.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class FtpToJMS extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		from("ftp://az:aa@localhost/inbox")
		.to("activemq:camel-outbox");
	}

}
