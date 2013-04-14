package com.ash.bhatinda.processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Author : az
 * Date: 4/14/13
 * Time: 5:30 PM
 */
@Component(value = "loggingProcessor")
public class LoggingProcessor implements Processor {
	Logger logger = LoggerFactory.getLogger(LoggingProcessor.class);

	@Override
	public void process(Exchange exchange) throws Exception {
		logger.info("**********************");
		logger.info(exchange.getIn().getBody().toString());
		logger.info("**********************");
	}
}
