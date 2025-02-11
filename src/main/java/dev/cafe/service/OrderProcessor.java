package dev.cafe.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dev.cafe.model.Drink;
import dev.cafe.model.Order;
import dev.cafe.model.OrderType;

public class OrderProcessor {

	private Scanner scanner = new Scanner(System.in);
	private List<Order> orders = new ArrayList<>();
	private int totalAmount = 0;

	// 주문 방식 선택
	public int selectType() {
		System.out.println("매장(1) - 테이크아웃(2)");
		int choice = scanner.nextInt();
		OrderType type;

		if (choice == 1) {
			type = OrderType.FOR_HERE;
			System.out.println("매장을 선택하셨습니다");
		} else {
			type = OrderType.TO_GO;
			System.out.println("테이크아웃을 선택하셨습니다");
		}

		while (true) {
			Drink drink = selectDrink();
			orders.add(new Order(drink, type));

			System.out.println("추가 주문을 하시겠습니까? (Yes:1/No:2)");
			int more = scanner.nextInt();
			if (more == 2) {
				calculateTotal(type);
				payOrder();
				printOrder();
				return 2;
			}
		}

	}

	// 음료 선택
	public Drink selectDrink() {
		System.out.println("아메리카노(1) - 라떼(2)");
		int choice = scanner.nextInt();

		if (choice == 1) {
			System.out.println("아메리카노를 선택하셨습니다");
			return Drink.AMERICANO;
		} else {
			System.out.println("라떼를 선택하셨습니다");
			return Drink.LATTE;
		}

	}

	// 총액 계산
	private void calculateTotal(OrderType type) {
		for (Order order : orders) {
			if (order.getDrink() == Drink.AMERICANO) {
				totalAmount += 2000;
			} else {
				totalAmount += 2500;
			}
		}

		if (type == OrderType.TO_GO) {
			totalAmount -= (500 * orders.size());
		}
	}
	
	// 결제 금액 선택
	
	public void payOrder() {
		System.out.println("총 주문 금액: " + totalAmount + "원");
		System.out.println("지불할 금액을 입력하세요: ");
		int payment = scanner.nextInt();
		System.out.println(payment + "원 지불하셨습니다");
		
		// 거스름돈 
		int change = payment-totalAmount;
		System.out.println("거스름돈은 " + change+ "원 입니다");
	}

	// 주문 결과 출력
	public void printOrder() {
		System.out.print("3초 후 주문하신 ");
		for (int i = 0; i < orders.size(); i++) {
			System.out.print(orders.get(i).getDrink().getName());
			if (i < orders.size() - 1) {
				System.out.print(", ");
			}
		}
		System.out.println(" 나옵니다!");
	}

}
