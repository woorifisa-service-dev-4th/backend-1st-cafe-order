package dev.cafe.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import dev.cafe.model.enums.Drink;
import dev.cafe.model.enums.OrderType;
import dev.cafe.parser.DrinkParser;
import dev.cafe.parser.OrderTypeParser;
import dev.cafe.printer.DrinkPrinter;
import dev.cafe.printer.OrderTypePrinter;
import dev.cafe.service.OrderService;

public class CoffeeOrder {
	private static final BufferedReader br;
	private static List<Drink> drinkList;
	private static final OrderService orderService;

	public static void orderProcess() throws IOException {
		System.out.println("안녕하세요 주문을 시작하겠습니다.");
		System.out.println("주문 유형을 선택하세요");
		System.out.println("매장(1) - 테이크 아웃(2)");
		String input = br.readLine();
		OrderType orderType = OrderTypeParser.parseOrderType(Integer.parseInt(input));
		OrderTypePrinter.printOrderType(orderType);

		do {
			do {
				System.out.println("음료를 선택하세요.");
				System.out.println("아메리카노(1) - 라떼(2)");
				input = br.readLine();
				Drink drinkType = DrinkParser.parseDrink(Integer.parseInt(input));
				DrinkPrinter.printDrink(drinkType);
				drinkList.add(drinkType);
				System.out.println("추가 주문을 하시겠습니까? (Yes/No)");
				input = br.readLine();
			} while (input.equals("Yes"));
		} while (input.equals("Y") || input.equals("yes") || input.equals("y"));

		System.out.println("지불 금액 입력");
		Order order = new Order(drinkList, orderType, Integer.parseInt(br.readLine()));
		orderService.pay(order);
	}

	static {
		br = new BufferedReader(new InputStreamReader(System.in));
		drinkList = new ArrayList();
		orderService = new OrderService();
	}
}