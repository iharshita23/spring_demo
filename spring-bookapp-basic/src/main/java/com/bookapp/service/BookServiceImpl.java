package com.bookapp.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.util.BookDetails;
@Service
public class BookServiceImpl implements IBookService {

	private BookDetails bookDetails;
	@Autowired
	public void setBookDetails(BookDetails bookdetails) {
		this.bookDetails = bookDetails;
	}
	@Override
	public List<Book> getAll() {
		return BookDetails.showBooks();
	}

	@Override
	public List<Book> getByAuthorContains(String author) throws BookNotFoundException {
		List<Book> booksByAuthor = BookDetails.showBooks().stream().filter(book -> book.getAuthor().contains(author))
				.sorted((o1,o2)->o1.getTitle().compareTo(o2.getTitle())).toList();
		if (booksByAuthor.isEmpty())
			throw new BookNotFoundException("No book found with the given author name");
		return booksByAuthor;

	}

	@Override
	public List<Book> getByCategory(String category) throws BookNotFoundException {
		return bookDetails.showBooks().stream()
				.filter(book -> book.getCategory()
				.contains(category)).
				sorted((o1,o2)->o1.getTitle().compareTo(o2.getTitle())).
				toList();
	}

	@Override
	public List<Book> getByPriceLessThan(double price) throws BookNotFoundException {
		return bookDetails.showBooks()
				.stream()
				.filter(book -> book.getPrice() < price)
				.sorted((o1,o2)->o1.getTitle().compareTo(o2.getTitle()))
				.toList();
	}

	@Override
	public List<Book> getByAuthorContainsAndCategory(String author, String category) throws BookNotFoundException {
		return bookDetails.showBooks().stream()
				.filter(book -> book.getAuthor().contains(author) && book.getCategory().equals(category)).toList();
	}

	@Override
	public Book getById(int bookId) throws BookNotFoundException {
		return bookDetails.showBooks()
				.stream()
				.filter(book -> book.getBookId() == bookId)
				.findFirst()
				.orElseThrow(() -> new BookNotFoundException("Book doesn't exists"));
	}

	@Override
	public List<Book> getByDatePublished(int year) throws BookNotFoundException {
		return null;
	}

}
