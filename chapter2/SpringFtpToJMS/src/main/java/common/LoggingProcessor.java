package common;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * User: az
 * Date: 4/14/13
 * Time: 7:59 AM
 */
@Component
public class LoggingProcessor implements Processor {

	Logger logger = LoggerFactory.getLogger(LoggingProcessor.class);

	@Override
	public void process(Exchange exchange) throws Exception {
		final Object body = exchange.getIn().getBody();
		logger.info("Message being passed around : " + body);
	}
}
