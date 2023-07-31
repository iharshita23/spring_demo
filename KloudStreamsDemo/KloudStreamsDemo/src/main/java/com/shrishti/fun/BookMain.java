package com.shrishti.fun;

import java.awt.print.Book;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookMain {

	public static void main(String[] args) {
		// create a ArrayList of list<book>
		List<Book> books = Array.asList(
				new Book("Java","Harshita",76),
				new Book("Java","Harshita",76),
				new Book("Java","Harshita",76),
				new Book("Java","Harshita",76),
				new Book("Java","Harshita",76)
				);
	
//        list.add(a);
//        list.add(b);
//        list.add(c);
//        list.add(d);
//        list.add(e);  
     // iterate the booklist using forEach and print the book
//        for(Book i: list) {
//            System.out.println(i);
//        }
        // iterate the booklist using forEach
     // add to a temporary list booksByAuthor

     // iterate the temp list and print
//        for(Book i: newlist) {
//            System.out.println(i);
//        }
		System.out.println("Before Sorting");
		for(Book book : books) {
			System.out.println(books);
		}
		Collections.sort(books);
		System.out.println("After sorting");
		for(Book book: books) {
			System.out.println(books);
		}
        
}
}
