package com.yash.assignment.two.abstractdesign.pattern;

public class IndianFood extends Food {

	private String breakFast;
	private String lunch;
	private String dinner;

	public IndianFood(String breakFast, String lunch, String dinner) {
		super();
		this.breakFast = breakFast;
		this.lunch = lunch;
		this.dinner = dinner;
	}

	@Override
	public String getBreakFast() {
		return this.breakFast;
	}

	@Override
	public String getLunch() {
		return this.lunch;
	}

	@Override
	public String getDinner() {
		return this.dinner;
	}

}
