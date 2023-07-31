package com.bookapp;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.service.IBookService;

@SpringBootApplication
public class SpringBookappBasicApplication implements CommandLineRunner{
    IBookService bookService;

    @Autowired
    public void setBookService(IBookService bookService) {
        this.bookService = bookService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBookappBasicApplication.class, args);

    }

    public void run(String...args) throws BookNotFoundException {
        System.out.println("Print books");
        bookService.getAll().forEach(book -> System.out.println(book));
        
        List<Book> booksByAuthorContains = bookService.getByAuthorContains("Harshita");
		System.out.println("Books by name harshita");
		booksByAuthorContains.forEach(book -> System.out.println(book));
		System.out.println();
		
		List<Book> booksByCategory = bookService.getByCategory("Rich Dad POor Dad");
		System.out.println("Following are the books by category");
		booksByCategory.forEach(book -> System.out.println(book));
		System.out.println();
		
		List<Book> booksWithLessPrice = bookService.getByPriceLessThan(1000);
		System.out.println("Price less than 1000");
		booksWithLessPrice.forEach(book -> System.out.println(book));
		
		Book book = bookService.getById(2);
        System.out.println(book);

    }
}