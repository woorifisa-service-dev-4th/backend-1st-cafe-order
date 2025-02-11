package dev.cafe.model;

import java.util.ArrayList;
import java.util.List;

import dev.cafe.model.enums.Drink;
import dev.cafe.model.enums.OrderType;

public class Order {
	private List<Drink> drinkList = new ArrayList();
	private OrderType orderType;
	private int receivedAmount;

	public Order(List<Drink> drinkList, OrderType orderType, int receivedAmount) {
		this.drinkList = drinkList;
		this.orderType = orderType;
		this.receivedAmount = receivedAmount;
	}

	public List<Drink> getDrinkList() {
		return this.drinkList;
	}

	public OrderType getOrderType() {
		return this.orderType;
	}

	public int getReceivedAmount() {
		return this.receivedAmount;
	}
}