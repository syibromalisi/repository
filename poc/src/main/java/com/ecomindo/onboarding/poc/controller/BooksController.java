package com.ecomindo.onboarding.poc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecomindo.onboarding.poc.dao.BooksDao;
import com.ecomindo.onboarding.poc.dto.OptionsDTO;
import com.ecomindo.onboarding.poc.dto.ResponseDTO;
import com.ecomindo.onboarding.poc.model.BooksModel;
import com.ecomindo.onboarding.poc.services.BooksService;

@RestController
@RequestMapping("/books")
public class BooksController {

	@Autowired
	BooksDao booksDao;

	@Autowired
	BooksService booksService;
	
	@GetMapping("/get-books")
	public ResponseEntity<List<BooksModel>> getAllBooks(@RequestParam(required = false) String title) {
		try {
			List<BooksModel> books = new ArrayList<BooksModel>();

			if (title == null)
				booksDao.findAll().forEach(books::add);
			else
				booksDao.findByTitle(title).forEach(books::add);

			if (books.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(books, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-books2")
	public ResponseDTO getAllBooks2(@RequestParam(required = false) String title) {
		ResponseDTO response = new ResponseDTO();
		try {

			List<BooksModel> books = new ArrayList<BooksModel>();

			if (title == null)
				booksDao.findAll().forEach(books::add);
			else
				booksDao.findByTitle(title).forEach(books::add);

			response.setCode("200");
			if (books.isEmpty()) {
				response.setMessage(HttpStatus.NO_CONTENT.toString());
			}

			response.setData(books);
			return response;
		} catch (Exception e) {
			response.setCode("500");
			return response;
		}
	}

	@GetMapping("/get-ddl-books")
	public ResponseDTO getDdlBooks() {
		ResponseDTO response = new ResponseDTO();
		try {

			List<OptionsDTO> opt = booksDao.findDDLTitle();
			response.setCode("200");
			if (opt.isEmpty()) {
				response.setMessage(HttpStatus.NO_CONTENT.toString());
			}

			response.setData(opt);
			return response;
		} catch (Exception e) {
			response.setCode("500");
			return response;
		}
	}

	@PostMapping("/insert")
	public ResponseDTO insert(@RequestBody BooksModel books) {
		ResponseDTO response = new ResponseDTO();
		try {
			BooksModel book = booksService.insert(books.getTitle(), books.getDescription(), books.getAuthor());
			
			response.setCode("200");
			response.setMessage("Insert Success");
			response.setData(book);
			
			return response;
		} catch (Exception e) {
			response.setCode("500");
			response.setMessage("Insert Failed");
			return response;
		}
	}

}
