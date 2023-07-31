package com.example.autowiring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ShapeFactory{
	@Autowired
//	@Qualifier("rectangle") //autowiring the name
    private Shape square;
	private Shape shape;
	public ShapeFactory(Shape shape) {
		super();
		this.shape = shape;
	}
	//@Autowired
	//bean name and instance variable name are same
	//autowiring by name

	void printArea(int x, int y) {
		
		System.out.println("Printing area");
		square.area(x, y);
	}

}
