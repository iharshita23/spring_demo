package com.shrishti.fun;

import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunDemo1 {

	public static void main(String[] args) {
		Supplier<String> supplier = ()->"Hello";
		System.out.println(supplier.get());
		
		Supplier<String> booksupplier = ()->new Book("Hello","Kathy",900);
		System.out.println(booksupplier.get());
		
		Predicate<String> pred = (str)-> {
			if(str.length()>5) 
			   return true;
		    else return false;
		};	
		
		System.out.println(pred.test("great"));
		
		Predicate<String> predicate = (str)-> str.length()>5;
		System.out.println(predicate.test("greatday"));
		
		Predicate<Book> bookPredicate = (book)->book.getAuthor().equalsIgnoreCase("Kathy");
        System.out.println(bookPredicate.test(new Book("java","kathy",900)));
	}

}
