package com.ecomindo.onboarding.poc.services;

import java.util.concurrent.Future;

import com.ecomindo.onboarding.poc.model.BooksModel;

public interface BooksService {
	public BooksModel insert(String title, String description, String author);

	public Future<BooksModel> insertLongTime(String title, String description, String author);
}
