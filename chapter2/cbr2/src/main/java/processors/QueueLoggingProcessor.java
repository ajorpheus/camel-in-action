package processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Author : az
 * Date: 4/15/13
 * Time: 9:57 PM
 */
@Component
public class QueueLoggingProcessor implements Processor {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	private String queueName;

	public QueueLoggingProcessor() {
	}

	public QueueLoggingProcessor(String queueName) {
		this.queueName = queueName;
	}

	@Override
	public void process(Exchange exchange) throws Exception {
		System.out.println("********************************");
		logger.info("Send to queue :" + queueName);
		logger.info(exchange.getIn().getBody().toString());
		System.out.println("********************************");
	}
}
