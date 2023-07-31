package com.bookapp.main;

import java.util.List;

import com.bookapp.model.Book;
import com.bookapp.service.BookServiceImpl;
import com.bookapp.service.BookService;

public class Client {
	public static void main(String[] args) {
		BookService bookService = new BookServiceImpl();
		
		System.out.println("Getting all books");
		List<Book> getAllBooks = bookService.getAll();
		getAllBooks.forEach(book -> System.out.println(book));
		System.out.println();
		
		List<Book> booksByAuthorContains = bookService.getByAuthorContains("John");
		System.out.println("Books by author which contains name John are as follows");
		booksByAuthorContains.forEach(book -> System.out.println(book));
		System.out.println();
		
		List<Book> booksByCategory = bookService.getByCategory("Java in Action");
		System.out.println("Following are the books by category");
		booksByCategory.forEach(book -> System.out.println(book));
		System.out.println();
		
		List<Book> booksWithLessPrice = bookService.getByPriceLessThan(1000);
		System.out.println("Books by price less than 1000 are as follows");
		booksWithLessPrice.forEach(book -> System.out.println(book));
		
	}
}