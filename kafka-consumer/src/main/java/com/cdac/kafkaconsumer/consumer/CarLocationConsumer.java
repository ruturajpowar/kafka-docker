package com.cdac.kafkaconsumer.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.cdac.kafkaconsumer.entity.CarLocation;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CarLocationConsumer {

	private static final Logger log=LoggerFactory.getLogger(CarLocationConsumer.class);
	
	private ObjectMapper objectMapper=new ObjectMapper();
	
	@KafkaListener(topics = "t_location",groupId = "cg-all-location")
	public void consumeAll(String message) throws JsonMappingException, JsonProcessingException {
		var carLocation=objectMapper.readValue(message, CarLocation.class);
		
		log.info("listenAll : {}",carLocation);
	}
	
	@KafkaListener(topics = "t_location",groupId = "cg-far-location",containerFactory = "farLocationContainerFactory                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     hcdc@2020"
			+ "")
	public void consumeFar(String message) throws JsonMappingException, JsonProcessingException {
		var carLocation=objectMapper.readValue(message, CarLocation.class);
		log.info("listenFar : {}",carLocation);
		
	}
}
