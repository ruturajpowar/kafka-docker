package com.cdac.kafkaproducer.config;

import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
public class KafkaConfig {

	@Autowired
	private KafkaProperties kafkaProperties;

	@Bean
	public ProducerFactory<String, String> producerFactory() {

		Map<String, Object> configs = kafkaProperties.buildProducerProperties();
		configs.put(ProducerConfig.METADATA_MAX_AGE_CONFIG, "180000");
		return new DefaultKafkaProducerFactory<>(configs);

	}
	
	@Bean
	public KafkaTemplate<String, String> kafkaTemplate(){
		
		return new KafkaTemplate<>(producerFactory());
	}

}
