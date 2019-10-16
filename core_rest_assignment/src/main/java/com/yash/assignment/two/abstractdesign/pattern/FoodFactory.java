package com.yash.assignment.two.abstractdesign.pattern;

public class FoodFactory {

	public Food getFood(FoodAbstractFactory factory) {

		return factory.createFood();
	}

}
