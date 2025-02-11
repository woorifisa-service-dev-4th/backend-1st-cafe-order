package dev.cafe.model.enums;

public enum Drink {
	아메리카노(2000), 라떼(2500);

	private int price;

	private Drink(int price) {
		this.price = price;
	}

	public int getPrice() {
		return this.price;
	}
}