package com.camelinaction;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

public class FtpToJMSRoute {
	public static void main(String[] args) throws Exception {
		CamelContext camelContext = new DefaultCamelContext();
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
				"tcp://localhost:61616");

		camelContext.addComponent("jms",
				JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
		camelContext.addRoutes(new RouteBuilder() {
			@Override
			public void configure() throws Exception {
				from("ftp://localhost/inbox?username=az&password=aa").to(
						"jms:queue:camel-outbox");
			}
		});

		camelContext.start();
		Thread.sleep(15000);
		camelContext.stop();
	}
}
