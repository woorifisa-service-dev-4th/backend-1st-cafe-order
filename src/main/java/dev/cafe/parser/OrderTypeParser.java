package dev.cafe.parser;

import dev.cafe.model.enums.OrderType;

public class OrderTypeParser {
	public static OrderType parseOrderType(int type) {
		return type == 1 ? OrderType.매장 : OrderType.테이크아웃;
	}
}