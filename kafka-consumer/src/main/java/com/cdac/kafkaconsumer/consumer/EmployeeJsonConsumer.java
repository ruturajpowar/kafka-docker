package com.cdac.kafkaconsumer.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.cdac.kafkaconsumer.entity.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class EmployeeJsonConsumer {

	private final ObjectMapper objectMapper=new ObjectMapper();
	
	private static final Logger log=LoggerFactory.getLogger(EmployeeJsonConsumer.class);
	
	@KafkaListener(topics = "t_employee")
	public void readEmp(String message) throws JsonMappingException, JsonProcessingException {
		var emp=objectMapper.readValue(message, Employee.class);
		log.info("consuming emp "+emp);
	}
}
