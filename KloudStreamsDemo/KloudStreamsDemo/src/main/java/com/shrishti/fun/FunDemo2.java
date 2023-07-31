package com.shrishti.fun;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunDemo2 {

	public static void main(String[] args) {
		Function<String, Integer> fun = (str)->str.length();
		int result = fun.apply("Hello");
		System.out.println(result);
		
		Function<Book,String> fun1 = book->book.getAuthor();
		System.out.println(fun1.apply(new Book("java","kathy",900)));
		
		BiFunction<String,Integer,String> bifun = (str,num)->{
			if(str.length()>num) return "WElcome "+str.toUpperCase();
			else
				return str.toLowerCase();
		};
		System.out.println(bifun.apply("harshita",4));

	}

}
