package com.cdac.kafkaproducer.schedular;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.cdac.kafkaproducer.entity.CarLocation;
import com.cdac.kafkaproducer.producer.CarLocationProducer;
import com.fasterxml.jackson.core.JsonProcessingException;

@Service
public class CarLocationSchedular {

	private static final Logger log=LoggerFactory.getLogger(CarLocationSchedular.class);
	
	private CarLocation carOne;
	private CarLocation carTwo;
	private CarLocation carThree;
	
	@Autowired
	CarLocationProducer carLocationProducer;
	
	public CarLocationSchedular() {
		var now=System.currentTimeMillis();
		carOne=new CarLocation("car-one", now, 0);
		carTwo=new CarLocation("car-two",now,110);
		carThree=new CarLocation("car-three", now, 95);
		
	}
	
	@Scheduled(fixedRate = 10000)
	public void sendDummyData()  {
		var now=System.currentTimeMillis();
		carOne.setTimestamp(now);
		carTwo.setTimestamp(now);
		carThree.setTimestamp(now);
		
		carOne.setDistance(carOne.getDistance()+1);
		carTwo.setDistance(carTwo.getDistance()-1);
		carThree.setDistance(carThree.getDistance()+1);
		try {
		carLocationProducer.send(carOne);
		log.info("sent {} ",carOne);
		carLocationProducer.send(carTwo);
		log.info("sent {} ",carTwo);
		carLocationProducer.send(carThree);
		log.info("sent {} ",carThree);
		}catch(JsonProcessingException jsonProcessingException) {
			log.info("jsonProcessingException ");
		}
	}
	
}
