package dev.cafe.service;

import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;

import dev.cafe.formatter.NumberFormatter;
import dev.cafe.model.Order;
import dev.cafe.model.enums.Drink;
import dev.cafe.model.enums.OrderType;

public class OrderService {
	public void pay(Order order) {
		int totalAmount = this.calculateTotal(order.getDrinkList(), order.getOrderType());
		System.out.println("총 주문 금액: " + NumberFormatter.formatNumber(totalAmount) + "원");
		System.out.println(NumberFormatter.formatNumber(order.getReceivedAmount()) + "원 지불하셨습니다.");
		if (order.getReceivedAmount() < totalAmount) {
			System.out.println("지불한 금액이 부족합니다.\n 결제에 실패했습니다.");
		} else {
			PrintStream var10000 = System.out;
			String var10001 = NumberFormatter.formatNumber(order.getReceivedAmount() - totalAmount);
			var10000.println("거스름돈은 " + var10001 + "원 입니다.");
		}

	}

	public int calculateTotal(List<Drink> drinkList, OrderType orderType) {
		int ret = 0;
		Iterator var4 = drinkList.iterator();

		while (var4.hasNext()) {
			Drink drink = (Drink) var4.next();
			ret += drink.getPrice();
			if (orderType == OrderType.테이크아웃) {
				ret -= 500;
			}
		}

		return ret;
	}
}