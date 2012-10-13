package com.camelinaction;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class CamelHelloWorld 
{
    public static void main( String[] args ) throws Exception
    {
        CamelContext camelContext = new DefaultCamelContext();
        
        camelContext.addRoutes(new RouteBuilder() {
			@Override
			public void configure() throws Exception {
				from("file:/Users/az/camel-test/inbox?noop=true")
				.to("file:/Users/az/camel-test/outbox");
			}
		});
        
        camelContext.start();
        Thread.sleep(10000);
        camelContext.stop();
    }
}
