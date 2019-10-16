package com.yash.assignment.two.abstractdesign.pattern;

public class IndianFoodFactory implements FoodAbstractFactory {

	private String breakFast;
	private String lunch;
	private String dinner;

	public IndianFoodFactory(String breakFast, String lunch, String dinner) {
		super();
		this.breakFast = breakFast;
		this.lunch = lunch;
		this.dinner = dinner;
	}
	
	
	@Override
	public Food createFood() {
		return new IndianFood(breakFast, lunch, dinner);
	}

}
