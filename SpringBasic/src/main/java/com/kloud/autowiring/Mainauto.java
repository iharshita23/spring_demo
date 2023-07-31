package com.kloud.autowiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Mainauto {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext("com.kloud.autowiring");
	   ShapeFactory shapeFactory = context.getBean("shapeFactory",ShapeFactory.class);

        //ShapeFactory shapeFactory = new ShapeFactory(shape);
        shapeFactory.printArea(10, 20);
        
        
	}

}
