package com.ecomindo.onboarding.poc.config;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ecomindo.onboarding.poc.job.JobInsertData2Service;

@Configuration
public class Quartz {
	@Bean
	public JobDetail jobAutoInsertDetails() {
		return JobBuilder.newJob(JobInsertData2Service.class).withIdentity("JobAutoInsert", "insert-book-second")
				.storeDurably()
				.build();
	}

	@Bean
	public Trigger jobAutoInsertTrigger(JobDetail jobAutoInsertDetails) {
		return TriggerBuilder.newTrigger().forJob(jobAutoInsertDetails)
				.withIdentity("trigger-from-main", "insert-book-second")
				.startNow()
				.withSchedule(CronScheduleBuilder.cronSchedule("0/20 * * ? * * *")).build();
	}
	
}
