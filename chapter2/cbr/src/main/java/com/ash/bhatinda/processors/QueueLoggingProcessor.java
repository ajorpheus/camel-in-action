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
@Component
public class QueueLoggingProcessor implements Processor {
	Logger logger = LoggerFactory.getLogger(QueueLoggingProcessor.class);
	private String message;

	public QueueLoggingProcessor(){

	}

	public QueueLoggingProcessor(String message) {
		this.message = message;
	}

	@Override
	public void process(Exchange exchange) throws Exception {
		logger.info("**********************");
		if(message != null) logger.info(" Sent to : " + message);
		logger.info("**********************");
	}
}
