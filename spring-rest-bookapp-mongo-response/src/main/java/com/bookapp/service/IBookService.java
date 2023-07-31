package com.bookapp.service;

import java.util.List;

import java.util.Optional;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.model.BookDTO;

public interface IBookService {
	
	
	void addBook(BookDTO bookDTO);
	BookDTO updateBook(BookDTO bookDTO);
	void deleteBook(int bookId);
	BookDTO getById(int bookId) throws BookNotFoundException;
	List<BookDTO> getAll();
	List<BookDTO> getByAuthorContains(String author) throws BookNotFoundException;
	List<BookDTO> getByCategory(String category) throws BookNotFoundException;
	List<BookDTO> getByPriceLessThan(double price) throws BookNotFoundException;
	List<BookDTO> getByDatePublished(int year) throws BookNotFoundException;
	List<BookDTO> getByAuthorContainsAndCategory(String author, String category) throws BookNotFoundException;
	List<BookDTO> getByAuthPrice(String author, double price) throws BookNotFoundException;
	List<BookDTO> findByAuth(String author) throws BookNotFoundException;
	List<BookDTO> findByAuthororTitle(String author,String title) throws BookNotFoundException;
	List<BookDTO> findByAuthPrice(String author, double price) throws BookNotFoundException;
	List<BookDTO> findByAuthOrTitle(String author, String title);



}
