package dev.cafe.model;

import java.security.SecureRandom;

public class Order {
	private static final SecureRandom RANDOM = new SecureRandom();

	private Drink drink;
	private OrderType type;
	private int number;

	// 랜덤값으로 받기
	public Order(Drink drink, OrderType type) {
		super();
		this.drink = drink;
		this.type = type;
		this.number = generateRandomId(5);
	}

	// 주문번호 생성
	public int generateRandomId(int length) {
		StringBuilder id = new StringBuilder();
		for (int i = 0; i < length; i++) {
			id.append(RANDOM.nextInt(10)); // 0~9 랜덤 숫자 추가
		}
		return Integer.parseInt(id.toString());
	}

	public Drink getDrink() {
		return drink;
	}

	public OrderType getType() {
		return type;
	}

	public int getNumber() {
		return number;
	}

}
