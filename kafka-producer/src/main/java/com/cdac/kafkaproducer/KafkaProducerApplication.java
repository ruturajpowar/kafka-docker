package com.cdac.kafkaproducer;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.cdac.kafkaproducer.entity.Employee;
import com.cdac.kafkaproducer.producer.EmployeeJsonProducer;
import com.cdac.kafkaproducer.producer.FixedRateProducer;
import com.cdac.kafkaproducer.producer.HelloKafkaProducer;
import com.cdac.kafkaproducer.producer.KafkaKeyProducer;

@SpringBootApplication
@EnableScheduling
public class KafkaProducerApplication implements CommandLineRunner{
	
//	@Autowired
//	EmployeeJsonProducer employeeJsonProducer;
	
	public static void main(String[] args) {
		SpringApplication.run(KafkaProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		for(int i=0;i<5;i++) {
//			var employee=new Employee("emp-"+i, "emp-name-"+i, LocalDate.now());
//			employeeJsonProducer.sendMessage(employee);
//		}
	}

}
