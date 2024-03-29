import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class MyFirstRoute {
	public static void main(String[] args) throws Exception {
		CamelContext camelContext = new DefaultCamelContext();
		camelContext.addRoutes(new RouteBuilder() {
			@Override
			public void configure() throws Exception {
				from("file:data/inbox?noop=true").to("file:data/outbox");
			}
		});

		// start the route and let it do its work
		camelContext.start();
		Thread.sleep(10000);

		// stop the CamelContext
		camelContext.stop();
	}
}
