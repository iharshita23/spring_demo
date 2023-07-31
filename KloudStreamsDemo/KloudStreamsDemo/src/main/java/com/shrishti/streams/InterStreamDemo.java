package com.shrishti.streams;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InterStreamDemo {

	public static void main(String[] args) {
		//List<String> courses = Arrays.asList("Java","Angular","Node","Spring","CSS","React");
//		//convert to stream
//		Stream<String> coStream = courses.stream();
//		//filter by length
//		Stream<String> coStream1 = coStream.filter(str->str.length()>4);
//		//using terminal operation collect to convert back to list
//		List<String> courseResult = coStream1.toList();
//		courseResult.forEach((str) -> System.out.println(str));
		
//		courses.stream()
//		.filter(str-> str.length()>4) //to filter
//		.collect(Collectors.toList()); //to convert back to list
//		
//		//map
//		Arrays.asList("Java","Angular","Node","Spring","CSS","React","css","html")
//		.stream()
//		.filter(str-> str.contains("a"))
//		.map(str-> str.toUpperCase())
//		.skip(1)
//		.sorted()
//		.limit(2)
//		.forEach(System.out::println);
		
		Stream.of("apple","orange")
		.forEach(System.out::println);
		Arrays.stream(new int[] {90,25,130,40,45,68})
		.filter(num -> num%2==0)
        .forEach(System.out::println);
		Stream.generate(()-> "hello").limit(2).forEach(System.out::println);	
	}
}
