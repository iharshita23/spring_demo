package com.bookapp.service;

import java.util.List;

import java.util.Optional;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;

public interface IBookService {
	
	
	void addBook(Book book);
	Book updateBook(Book book);
	void deleteBook(int bookId);
	Book getById(int bookId) throws BookNotFoundException;
	List<Book> getAll();
	List<Book> getByAuthorContains(String author) throws BookNotFoundException;
	List<Book> getByCategory(String category) throws BookNotFoundException;
	List<Book> getByPriceLessThan(double price) throws BookNotFoundException;
	List<Book> getByDatePublished(int year) throws BookNotFoundException;
	List<Book> getByAuthorContainsAndCategory(String author, String category) throws BookNotFoundException;
	List<Book> getByAuthPrice(String author, double price) throws BookNotFoundException;
	List<Book> findByAuth(String author) throws BookNotFoundException;
	List<Book> findByAuthororTitle(String author,String title) throws BookNotFoundException;



}
