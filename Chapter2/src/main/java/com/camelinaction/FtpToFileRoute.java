package com.camelinaction;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class FtpToFileRoute 
{
    public static void main( String[] args ) throws Exception
    {
        CamelContext camelContext = new DefaultCamelContext();
        
        camelContext.addRoutes(new RouteBuilder() {
			@Override
			public void configure() throws Exception {
				from("ftp://localhost/inbox?username=az&password=aa")
				.to("file:/Users/az/camel-test/outbox");
			}
		});
        
        camelContext.start();
        Thread.sleep(5000);
        camelContext.stop();
    }
}
