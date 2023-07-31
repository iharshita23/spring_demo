package com.shrishti.maps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MapsDemo {
 public static void main(String[] args) {
	
	Map<String, List<String>> states = new HashMap<>();

	        states.put("Karnataka", Arrays.asList("Mangalore", "Bangalore", "Hassan"));
	        states.put("Madhya Pradesh", Arrays.asList("Bhopal", "Indore", "Jabalpur"));
	        states.put("UP", Arrays.asList("Kanpur", "Lucknow","bareilly"));
	        for (Map.Entry<String, List<String>> mapEntry : states.entrySet()) {
	            System.out.print(mapEntry.getKey() + ": ");
	            for (String city: mapEntry.getValue()) {
	                System.out.print(city + ", ");
	            }	         
	            System.out.println();
	        }
    }
}
