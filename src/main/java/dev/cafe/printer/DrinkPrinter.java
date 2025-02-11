package dev.cafe.printer;

import dev.cafe.model.enums.Drink;

public class DrinkPrinter {
	public static void printDrink(Drink drink) {
		System.out.println(String.format("%s를 선택하셨습니다.", drink));
	}
}