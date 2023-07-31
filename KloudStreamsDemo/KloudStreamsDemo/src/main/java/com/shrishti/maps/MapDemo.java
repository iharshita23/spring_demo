package com.shrishti.maps;


import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class MapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer,String> hashMap = new HashMap<>();
		//Map<Integer,String> hashMap = new TreeMap<>();
		hashMap.put(1,"Java");
		hashMap.put(10,"Spring");
		hashMap.put(8,"Node");
		//hashMap.put(null,"Node");
		hashMap.put(1,"Java");
		hashMap.put(5,"react");
		hashMap.put(100,null);
		System.out.println(hashMap);
		
		System.out.println(hashMap.get(1));
		System.out.println(hashMap.get(20));
		System.out.println(hashMap.containsKey(1));
		
		Set<Integer> keys = hashMap.keySet();
		for(Integer key:keys) {
			System.out.println(key + " "+ hashMap.get(key));
		}System.out.println();
		Set<Entry<Integer,String>> map = hashMap.entrySet();
		for(Entry<Integer,String> entry:map) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}

		
	}

}
