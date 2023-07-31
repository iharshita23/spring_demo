package com.kloud.autowiring;

import org.springframework.stereotype.Component;

@Component
public class Square implements Shape{
		public void area(int x, int y) {
			System.out.println("Area is : " + (x*y));
		}
}
