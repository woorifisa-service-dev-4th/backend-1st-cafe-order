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
	    int totalAmount = calculateTotal(order.getDrinkList(), order.getOrderType());
	    int receivedAmount = order.getReceivedAmount();
	    int change = receivedAmount - totalAmount;

	    System.out.println("\n+------------------------+");
	    System.out.println("|      📜 영수증        |");



	    System.out.println("+------------------------+");
	    System.out.printf("| 🛒 총 주문 금액  %7s원 |\n", NumberFormatter.formatNumber(totalAmount));
	    System.out.printf("| 💳 지불 금액    %7s원 |\n", NumberFormatter.formatNumber(receivedAmount));
	    System.out.println("+------------------------+");

	    if (receivedAmount < totalAmount) {
	       System.out.println("| ❌ 지불한 금액이 부족합니다. |");
	       System.out.println("| ⛔ 결제 실패! 추가 지불 필요 |");
	    } else {
	       System.out.printf("| 💰 거스름돈     %7s원 |\n", NumberFormatter.formatNumber(change));
	       System.out.println("| ✅ 결제가 완료되었습니다. |");
	    }

	    System.out.println("+------------------------+");
	    System.out.println("|  ☕ 감사합니다! 좋은 하루  |");
	    System.out.println("+------------------------+\n");
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