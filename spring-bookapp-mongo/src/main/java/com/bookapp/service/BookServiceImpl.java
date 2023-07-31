package com.bookapp.service;

import java.util.List;


import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.repository.IBookRepository;
@Service
public class BookServiceImpl implements IBookService {

	private IBookRepository ibookRepository;
	@Autowired
	public BookServiceImpl(IBookRepository ibookRepository) {
		this.ibookRepository = ibookRepository;
	}

	@Override
	public void addBook(Book book) {
		ibookRepository.insert(book);	
	}
	@Override
	public Book updateBook(Book book) {
		return ibookRepository.save(book);
	}
	@Override
	public void deleteBook(int bookId) {
		ibookRepository.deleteById(bookId);	
	}
	
	@Override
	public List<Book> getAll() {
		return ibookRepository.findAll();		
	}
	
	@Override
	public Book getById(int bookId) throws BookNotFoundException {
		return  ibookRepository
				.findById(bookId).orElseThrow(() ->  new BookNotFoundException("No Book Found for Id: "+ bookId));
                		
	}
	
	@Override
	public List<Book> getByDatePublished(int year) throws BookNotFoundException {
		return null;
	}

	@Override
	public List<Book> getByAuthorContains(String author) throws BookNotFoundException {
		List<Book> books = ibookRepository.findByAuthorContaining(author);
		if(books.isEmpty())
			throw new BookNotFoundException("Author not found");
		return  books;
	}

	@Override
	public List<Book> getByCategory(String category) throws BookNotFoundException {
		List<Book> books = ibookRepository.findByCategory(category);
		if(books.isEmpty())
			throw new BookNotFoundException("Category not found");
		return  books;
	}

	@Override
	public List<Book> getByPriceLessThan(double price) throws BookNotFoundException {
		List<Book> books = ibookRepository.findByPriceLessThan(price);
		if(books.isEmpty())
			throw new BookNotFoundException("Price less than this");
		return  books;
	}

	@Override
	public List<Book> getByAuthPrice(String author, double price) throws BookNotFoundException {
		List<Book> books = ibookRepository.getByAuthPrice(author,price);
		if(books.isEmpty())
			throw new BookNotFoundException("Price less than this");
		return  books;
	}
	
	@Override
	public List<Book> findByAuth(String author) throws BookNotFoundException {
		List<Book> books = ibookRepository.findByAuth(author);
		if(books.isEmpty())
			throw new BookNotFoundException("Author not found");
		return  books;
	}
	
	@Override
	public List<Book> findByAuthororTitle(String author,String title) throws BookNotFoundException {
		List<Book> books = ibookRepository.findByAuthororTitle(author,title);
		if(books.isEmpty())
			throw new BookNotFoundException("Author or title not found");
		return  books;
	}
	
	@Override
	public List<Book> getByAuthorContainsAndCategory(String author, String category) throws BookNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
