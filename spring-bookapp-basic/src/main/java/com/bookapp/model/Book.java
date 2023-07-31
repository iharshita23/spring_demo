package com.bookapp.model;

import java.time.LocalDate;

public class Book {
	private String title;
	private String author;
	private String category;
	private int bookId;
	private double price;

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

	public void setBookId(int bookId) {
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