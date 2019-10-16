package com.yash.assignment.two.abstractdesign.pattern;

public class FactoryDesignPatternTest {

	public static void main(String args[]) {
		
		FoodFactory foodFactory = new FoodFactory();
		
		Food food = foodFactory.getFood(new IndianFoodFactory("Poha and Jalebi", "Dal Rice", "Palak Paneer and Roti"));
		
		System.out.println(food);
	
	}

}
