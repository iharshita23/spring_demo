package com.kloud.constr;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class StudentMain {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext("com.kloud.constr");
		Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
		
		Student student = (Student)context.getBean("student");
		System.out.println(student);
	}

}
