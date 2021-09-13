package com.ecomindo.onboarding.poc.services;

import com.ecomindo.onboarding.poc.model.BooksModel;

public interface BooksService {
	public BooksModel insert(String title, String description, String author);
}
