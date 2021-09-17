package com.ecomindo.onboarding.poc.job;

import com.ecomindo.onboarding.poc.services.BooksService;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JobInsertData2Service implements Job {
	private static final Logger logger = LoggerFactory.getLogger(JobInsertData2Service.class);

	@Autowired
	BooksService bookService;

	@Override
	public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
		try {
			logger.info("Executing Job with key {}", jobExecutionContext.getJobDetail().getKey());
			
			String formattedDate = new SimpleDateFormat("yyyyMMdd_hh:mm").format(new Date());
			
			String title = String.format("Test title %s", formattedDate);
			String description = String.format("Test description %s", formattedDate);
			String author = String.format("Test author %s", formattedDate);

//			bookService.insert(title, description, author);
		} catch (Exception e) {
			logger.error("Failed to send insert.", e);
			throw e;
		}
	}


}
