package com.bookapp;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bookapp.model.Book;
import com.bookapp.service.IBookService;


@SpringBootApplication
public class SpringBookappMongoApplication implements CommandLineRunner{
	
	@Autowired
	private IBookService iBookService;
	public static void main(String[] args) {
		SpringApplication.run(SpringBookappMongoApplication.class, args);
	}	

	public SpringBookappMongoApplication(IBookService iBookService) {
		super();
		this.iBookService = iBookService;
	}
	
	@Override
	public void run(String...args) throws Exception{
//		Book book = new Book("Panchatantra","SN Tiwari","Dfo",3,130.00);
//		iBookService.addBook(book);
//		
//		book = new Book("Shiavji","KK nagar","fiction",4,1346.00);
//        iBookService.addBook(book);

        iBookService.getAll().forEach(System.out::println);
        iBookService.getByAuthorContains("S").forEach(System.out::println);
        iBookService.getByCategory("fiction").forEach(System.out::println);
        iBookService.getByAuthPrice("SN Tiwari",130.0).forEach(System.out::println);
        iBookService.findByAuth("SN Tiwari").forEach(System.out::println);
        iBookService.findByAuthororTitle("SN Tiwari","Manorama").forEach(System.out::println);
		
	}

}
