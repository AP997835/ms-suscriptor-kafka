package com.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

/**
 * @author
 *
 */
@Service
public class AppConsumer {

	private final Logger log = LoggerFactory.getLogger(AppConsumer.class);

	
	/**
	 * 
	 */
	public AppConsumer() {
	}

	
	@KafkaListener(topics = "${message.topic.name}", groupId = "${message.group-id.name}")
	public void usarDineroElectronico(@Payload String message,
		    @Header(KafkaHeaders.RECEIVED_PARTITION_ID) long partition,
		    @Header(KafkaHeaders.OFFSET) long offset) throws Exception {

		log.info("Mensaje recibido [{}]  partition-{} offset-{}",message,partition,offset);
		log.info("En este punto se le puede dar tratamiento al mensaje");

		
    }

	
}
