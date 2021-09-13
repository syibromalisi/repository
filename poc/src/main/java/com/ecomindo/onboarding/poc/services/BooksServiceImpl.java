package com.ecomindo.onboarding.poc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomindo.onboarding.poc.dao.BooksDao;
import com.ecomindo.onboarding.poc.model.BooksModel;

@Service
public class BooksServiceImpl implements BooksService {

	@Autowired
	BooksDao booksDao;

	@Override
	public BooksModel insert(String title, String description, String author) {
		try {
			BooksModel books = booksDao.save(new BooksModel(title, description, author));
			return books;
		} catch (Exception e) {
			throw e;
		}
	}

}
