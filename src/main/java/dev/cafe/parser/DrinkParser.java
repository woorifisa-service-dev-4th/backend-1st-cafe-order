package dev.cafe.parser;

import dev.cafe.model.enums.Drink;

public class DrinkParser {
	public static Drink parseDrink(int type) {
		return type == 1 ? Drink.아메리카노 : Drink.라떼;
	}
}