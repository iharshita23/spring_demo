package com.shrishti.maps;
	import java.util.Arrays;
	import java.util.HashMap;
	import java.util.List;
	import java.util.Map;
		
		public class Maindept {
		    public static void main(String[] args) {
		        Map<Department, List<Student>> deptMap = new HashMap<Department, List<Student>>();		     
		        Department ece = new Department(1,"ECE","Amit");
		        Department cse = new Department(2,"CSE","Harshita");
		        Department mechanical = new Department(3,"Mechanical","Riya");
		        Department civil = new Department(4,"civil","Rajesh");
		        deptMap.put(ece, Arrays.asList(
		                new Student(1,"Amy","gwalior"),
		                new Student(2,"riya","pune"),
		                new Student(3,"muskan","agra")
		                ));
		        deptMap.put(cse, Arrays.asList(
		                new Student(4,"meghna","mumbai"),
		                new Student(5,"raman","bangalore")
		                ));
		        deptMap.put(mechanical, Arrays.asList(
		                new Student(6,"Richard","toronto"),
		                new Student(7,"John","jhansi"),
		                new Student(3,"ben","manali")
		                ));
		        deptMap.put(civil, null);		        
		        for(Department department : deptMap.keySet()) {
		            System.out.println(department);
		            System.out.println("List of students");
		            System.out.println(deptMap.getOrDefault(department, Arrays.asList()));
		        }
		    }
		}
