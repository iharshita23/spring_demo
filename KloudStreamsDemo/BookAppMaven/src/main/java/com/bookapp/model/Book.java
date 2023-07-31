package com.bookapp.model;

import java.time.LocalDate;

public class Book {
	private String title;
	private String author;
	private String category;
	private int bookId;
	private double price;
	private LocalDate publishedDate;
	
	public Book() {
		super();
	}

	public Book(String title, String author, String category, int bookId, double price, LocalDate publishedDate) {
		super();
		this.title = title;
		this.author = author;
		this.category = category;
		this.bookId = bookId;
		this.price = price;
		this.publishedDate = publishedDate;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDate getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(LocalDate publishedDate) {
		this.publishedDate = publishedDate;
	}
	
}
