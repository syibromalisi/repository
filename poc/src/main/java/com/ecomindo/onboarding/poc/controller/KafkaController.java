package com.ecomindo.onboarding.poc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecomindo.onboarding.poc.dto.ResponseDTO;
import com.ecomindo.onboarding.poc.kafka.services.KafkaProducer;

@CrossOrigin(methods = {RequestMethod.POST, RequestMethod.GET})
@RestController
public class KafkaController {
	
	@Autowired
	KafkaProducer kafkaProducer;
	
    @RequestMapping(value = "/sendMessage", method=RequestMethod.POST)
    public ResponseDTO sendMessage(@RequestBody String message) {
    	ResponseDTO response = new ResponseDTO();

    	kafkaProducer.sendMessage(message);
    	
    	response.setCode("200");
    	response.setMessage("Send to kafka");
    	return response;
    }
}
