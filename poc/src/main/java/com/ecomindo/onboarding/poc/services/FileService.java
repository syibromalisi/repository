package com.ecomindo.onboarding.poc.services;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
	public void upload(MultipartFile file) throws Exception;
}
