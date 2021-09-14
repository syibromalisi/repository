//package com.ecomindo.onboarding.poc.controller;
//
//import static org.mockito.Mockito.mock;
//
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.ecomindo.onboarding.poc.model.BooksModel;
//import com.ecomindo.onboarding.poc.services.BooksService;
//
//@SpringBootTest
//public class BooksControllerMockitoTest {
//
//	BooksModel booksModel;
//	BooksService booksService;
//
//	public void setUp() {
//		// Create a object which is to be tested
//		booksModel = new BooksModel("test mockito", "test description2", "test author2");
//
//		// Create the mock object of service
//		booksService = mock(BooksService.class);
//	}
//
//	public boolean insert() {
//
//		// Creates a list of stocks to be added to the portfolio
//		List<Stock> stocks = new ArrayList<Stock>();
//		Stock googleStock = new Stock("1", "Google", 10);
//		Stock microsoftStock = new Stock("2", "Microsoft", 100);
//
//		stocks.add(googleStock);
//		stocks.add(microsoftStock);
//
//		// add stocks to the portfolio
//		portfolio.setStocks(stocks);
//
//		// mock the behavior of stock service to return the value of various stocks
//		when(stockService.getPrice(googleStock)).thenReturn(50.00);
//		when(stockService.getPrice(microsoftStock)).thenReturn(1000.00);
//
//		double marketValue = portfolio.getMarketValue();
//		return marketValue == 100500.0;
//	}
//}
