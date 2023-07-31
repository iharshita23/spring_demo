package com.bookapp.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.service.IBookService;

@RestController
@RequestMapping("/book-api")	
public class BookController {
	private IBookService bookService;
	
	public BookController() {
		super();
		this.bookService = bookService;
	}
	@GetMapping("/books")
	List<Book> getAll(){
		return bookService.getAll();
	}
	
	//http://localhost:8080/book-api/books/author/kathy
	@GetMapping("/books/author/{author}")
	List<Book> getByAuthorContains(@PathVariable("author")String author){
		return bookService.getByAuthorContains(author);
	}
	//http://localhost:8080/book-api/books/category?category=Tech
	@GetMapping("/books/category")
	List<Book> getByCategory(@RequestParam("category")String category){
		return bookService.getByCategory(category);
	}
	//http://localhost:8080/book-api/books/price?price=1000
	@GetMapping("/books/price/{price}")
	List<Book> getByPriceLessThan(@PathVariable("price")double price){
		return bookService.getByPriceLessThan(price);
	}
	//http://localhost:8080/book-api/books/price?price=100
	@GetMapping("/books/year/{year}")
	List<Book> getByDatePublished(@PathVariable("year")int year){
		return bookService.getByDatePublished(year);
	}
	//http://localhost:8080/book-api/bookId?bookId=2 
	@GetMapping("/books/bookId/{bookId}")
	Book getById(@PathVariable("bookId")int bookId) {
		return bookService.getById(bookId);
	}

}
