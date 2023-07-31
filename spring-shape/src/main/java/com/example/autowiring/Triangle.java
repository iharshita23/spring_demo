package com.example.autowiring;

import org.springframework.stereotype.Component;

@Component
public class Triangle implements Shape {
	public void area(int x, int y) {
		System.out.println("Area is : " + (0.5*x*y));
	}
}
