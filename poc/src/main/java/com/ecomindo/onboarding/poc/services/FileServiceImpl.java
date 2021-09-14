package com.ecomindo.onboarding.poc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ecomindo.onboarding.poc.config.Config;
import com.ecomindo.onboarding.poc.util.SftpUtil;

@Service
public class FileServiceImpl implements FileService {

	@Autowired
	Config config;

	@Override
	public void upload(MultipartFile file) throws Exception {
		try {
			SftpUtil sftp = new SftpUtil(config.getSftpHost(), config.getSftpPort(), config.getSftpUsername(),
					config.getSftpPassword(), config.getSftpFolder());

			String filename = file.getOriginalFilename();
			String fileType = file.getContentType();
			byte[] fileContent = file.getBytes();

			String sftpPath = config.getSftpFolder().concat("/").concat(filename);
			sftp.sftpPutFromStream(file.getInputStream(), sftpPath);

		} catch (Exception e) {
			throw e;
		}
	}
}
