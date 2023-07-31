package com.shrishti.fun;

import java.awt.print.Book;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class FunDemo {
	
		public static void main(String[] args) {
			//implementin consumer
			Consumer<String> consumer = str -> System.out.println(str.toUpperCase());
			consumer.accept("Harshita");
			//calling method
			Consumer<Integer> conIn = num-> System.out.println(Math.pow(num, 2));
			conIn.accept((int) 10.0);
			Consumer<Book> conbook = book-> System.out.println(book.getTitle());
			conBook.accept(new Book("java","kathy",900));
			
			BiConsumer<String,Integer> biCon = (str, num) -> {
				if(str.length()>num)
					System.out.println("WElcome "+str.toUpperCase());
				System.out.println("Username is short "+str.toLowerCase());
			};
			biCon.accept("Harshita", 5);
			BiConsumer<List<Book>,String> bookCon = (books,author) -> {
				List<Book> booksbyauthor = new ArrayList<>();
				for(Book book : books) {
					if(book.getAuthor().equals(author))
					booksbyauthor.add(book);	
				}
				booksbyauthor.forEach(conbook);
			};
			bookCon.accept(Arrays.asList(
			new Book("Java","Harshita",76),
			new Book("Angular","Roby",667),
			new Book("React","Harsh",887),
			new Book("css","Arpit",76),
			new Book("html","Harshi",900)
		)};
}
