package com.bookapp.model;

import java.time.LocalDate;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

//annotate the class with @Document to create a collection 
@Document //the collection name is book
//@Document(collection = "newbook")

public class Book {
	private String title;
	private String author;
	private String category;
	@Id //to specify that it is the primary key
	private Integer bookId;
	@Field(name="cost")
	private double price;

	public Book() {
		super();
	}

	public Book(String title, String author, String category, Integer bookId, double price) {
		super();
		this.title = title;
		this.author = author;
		this.category = category;
		this.bookId = bookId;
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", bookId=" + bookId + ", price=" + price + ", category="
				+ category ;
	}

}