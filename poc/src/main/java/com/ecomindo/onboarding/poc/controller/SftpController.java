package com.ecomindo.onboarding.poc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ecomindo.onboarding.poc.dto.ResponseDTO;
import com.ecomindo.onboarding.poc.services.FileService;

@RestController
@RequestMapping("/sftp")
public class SftpController {

	@Autowired
	FileService fileService;

//	@ApiParam(allowMultiple=true) 
	@RequestMapping(path = "/upload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseDTO upload(@RequestPart(value = "file") MultipartFile file) {
		ResponseDTO response = new ResponseDTO();
		try {
			fileService.upload(file);

			response.setCode("200");
			response.setMessage("Upload Success");

			return response;
		} catch (Exception e) {
			response.setCode("500");
			response.setMessage("Upload Failed");
			return response;
		}
	}

}
