package dev.cafe.service;

import java.text.NumberFormat;

public class UnitCutting {

	private int price = 10000000;

	public static String unitcutting( int price ) {

		NumberFormat nf = NumberFormat.getInstance();

		String result = nf.format(price);

		return result;

	}

}
