package com.yash.assignment.two;

import static org.junit.Assert.*;

import org.junit.Test;

import com.yash.assignment.two.abstractdesign.pattern.Food;
import com.yash.assignment.two.abstractdesign.pattern.FoodFactory;
import com.yash.assignment.two.abstractdesign.pattern.IndianFoodFactory;

public class FactoryDesignPatternTest {

	@Test
	public void shouldReturnIndianFoodClass() {

		FoodFactory foodFactory = new FoodFactory();
		
		foodFactory.getFood(new IndianFoodFactory("Poha and Jalebi", "Dal Rice", "Palak Paneer and Roti"));

//		foodFactory.
	
	
	}

}
