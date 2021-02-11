package com.cdac.kafkaproducer.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

//@Service
public class FixedRateProducer {

	private Logger log=LoggerFactory.getLogger(FixedRateProducer.class);
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	private int i;
	
	@Scheduled(fixedRate = 1000)
	public void sendMessage() {
		i++;
		log.info("i is {}",i);
		kafkaTemplate.send("t_fixedrate", "fixed rate "+i);
	}
	
}
