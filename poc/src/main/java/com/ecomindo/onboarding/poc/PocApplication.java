package com.ecomindo.onboarding.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import co.elastic.apm.attach.ElasticApmAttacher;

@SpringBootApplication
public class PocApplication {

	public static void main(String[] args) {
		ElasticApmAttacher.attach();
		SpringApplication.run(PocApplication.class, args);
	}

}
