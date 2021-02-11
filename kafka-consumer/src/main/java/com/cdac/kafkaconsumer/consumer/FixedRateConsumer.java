package com.cdac.kafkaconsumer.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

//@Service
public class FixedRateConsumer {
	
	private Logger log=LoggerFactory.getLogger(FixedRateConsumer.class);

	@KafkaListener(topics="t_fixedrate")
	public void consumeMessage(String message) {
		log.info("consuming "+message);
		
	}
}
