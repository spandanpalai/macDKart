package com.macd.dto;

public enum Menu {
MACD_NONVEG_BURGER(150),MACD_VEG_BURGER(100),CHCIKEN_BIRIYANI(200),COKE(90);
	private int price;

	private Menu(int price) {
		this.price = price;
	}

	public int getPrice() {
		return price;
	}

}
