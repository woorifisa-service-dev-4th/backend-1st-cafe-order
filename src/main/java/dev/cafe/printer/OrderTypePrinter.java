package dev.cafe.printer;

import dev.cafe.model.enums.OrderType;

public class OrderTypePrinter {
	public static void printOrderType(OrderType orderType) {
		System.out.println(String.format("%s를 선택하셨습니다.", orderType));
	}
}