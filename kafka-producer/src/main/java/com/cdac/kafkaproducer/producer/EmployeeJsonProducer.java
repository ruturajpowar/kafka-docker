package com.cdac.kafkaproducer.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.cdac.kafkaproducer.entity.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//@Service
public class EmployeeJsonProducer {
	
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	private ObjectMapper objectMapper=new ObjectMapper();
	
	
	public void sendMessage(Employee employee) throws JsonProcessingException {
		var json=objectMapper.writeValueAsString(employee);
		kafkaTemplate.send("t_employee", json);
	}
	

}
