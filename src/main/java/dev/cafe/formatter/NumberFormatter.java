package dev.cafe.formatter;

public class NumberFormatter {
	public static String formatNumber(int number) {
		return String.format("%,d", number);
	}
}