package com.bookapp.service;

import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.util.BookDetails;

public class BookServiceImpl implements BookService{

	public BookServiceImpl() {
		super();		
	}
    @Override
    public List<Book> getAll() {
        return BookDetails.showBooks();
    }
    @Override
    public List<Book> getByAuthorContains(String author) throws BookNotFoundException {
        List<Book> result = BookDetails.showBooks().stream().filter(book -> book.getAuthor().contains(author)).toList();
        if(result.isEmpty())
            throw new BookNotFoundException("No book found with the given author name");
        return result;
    }
    @Override
    public List<Book> getByCategory(String category) throws BookNotFoundException {
        return BookDetails.showBooks().stream().filter(book -> book.getCategory().contains(category)).toList();
    }
    @Override
    public List<Book> getByPriceLessThan(double price) throws BookNotFoundException {
        return BookDetails.showBooks().stream().filter(book -> book.getPrice() < price).toList();
    }
    @Override
    public List<Book> getByDatePublished(int year) throws BookNotFoundException {
        return BookDetails.showBooks().stream().filter(book -> book.getPublishedDate().getYear() == year).toList();
    }
    @Override
    public List<Book> getByAuthorContainsAndCategory(String author, String category) throws BookNotFoundException {
        return BookDetails.showBooks().stream()
                .filter(book -> book.getAuthor().contains(author) && book.getCategory().contains(category)).toList();
    }
    @Override
    public Optional<Book> getById(int bookId) throws BookNotFoundException {
        return BookDetails.showBooks().stream()
                .filter(book -> book.getBookId() == bookId)
                .findFirst();

    }

}


