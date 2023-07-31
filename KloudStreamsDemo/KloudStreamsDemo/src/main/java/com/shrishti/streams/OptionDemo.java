package com.shrishti.streams;

import java.util.Arrays;
import java.util.Optional;

public class OptionDemo {
	public static void main(String[] args) {
		Optional<String> optional = Arrays.asList("Java","Angular","Node","Spring","CSS","React","css","html")
    	.stream()
    	.filter(str-> str.length()>3)
    	.findFirst();
		
		if(optional.isPresent())
			System.out.println(optional.get());
		
		if(optional.isEmpty())
			System.out.println(optional.get());
		
		Arrays.asList("Java","Angular","Node","Spring")
	    .stream()
	    .filter(str->str.length()>30)
	    .findFirst()
	    .ifPresent(System.out::println);		
		  String res = Arrays.asList("Java","Angular","Node","Spring")
				    .stream()
				    .filter(str->str.length()>30)
				    .findFirst()
				    .orElse("No data");
				    System.out.println(res);				    

				    Arrays.asList("Java","Angular","Node","Spring")
				    .stream()
			    .filter(str->str.length()>30)
				    .findFirst()
				    .ifPresentOrElse((str)-> System.out.println(str),
				                      ()-> System.out.println("No data"));
		
	}
}
