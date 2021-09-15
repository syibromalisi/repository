package com.ecomindo.onboarding.poc.dto;

import com.ecomindo.onboarding.poc.model.BooksModel;

public class JobBookRequestDTO {
	private BooksModel data;
	private JobRequestDTO job;
	
	public BooksModel getData() {
		return data;
	}
	public void setData(BooksModel data) {
		this.data = data;
	}
	public JobRequestDTO getJob() {
		return job;
	}
	public void setJob(JobRequestDTO job) {
		this.job = job;
	}

}
