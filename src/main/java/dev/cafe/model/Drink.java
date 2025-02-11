package dev.cafe.model;

public enum Drink {

	LATTE(2500, "라떼"), AMERICANO(2000, "아이스 아메리카노");

	private int price;
	private String name;

	Drink(int price, String name) {
		this.price = price;
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
