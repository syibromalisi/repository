package com.ecomindo.onboarding.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.ecomindo.onboarding.poc.kafka.services.KafkaConsumer;
 
@SpringBootApplication
public class PocApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocApplication.class, args);
		
//		ConfigurableApplicationContext context = SpringApplication.run(PocApplication.class, args);
//
//		KafkaConsumer listener = context.getBean(KafkaConsumer.class);
	}

}
