package com.ecomindo.onboarding.poc.kafka.services;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.ecomindo.onboarding.poc.services.BooksService;

@Component
public class KafkaConsumer {

	@Autowired
	BooksService bookService;

	@KafkaListener(topics = "${spring.custom.kafka.topic}", groupId = "java")
	public void listToTopicOnBoaarding(String message) {
		System.out.println("Received Message in group foo: " + message);

		String formattedDate = new SimpleDateFormat("yyyyMMdd_hh:mm").format(new Date());

		String title = String.format("Test title %s", formattedDate);
		String description = String.format("Test description %s %s", message, formattedDate);
		String author = String.format("Test author %s", formattedDate);

		bookService.insert(title, description, author);

	}

}
