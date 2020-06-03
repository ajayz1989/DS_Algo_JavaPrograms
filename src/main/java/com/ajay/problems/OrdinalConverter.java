package com.ajay.problems;

/**
 * @author ajaykumar
 * <p>
 * OrdinalConverter should have a function that take a number and return it as a string with the correct ordinal
 * indicator suffix (in English).
 * <p>
 * That is:
 * <p>
 * - numberToOrdinal(1) ==> '1st'
 * - numberToOrdinal(2) ==> '2nd'
 * - numberToOrdinal(3) ==> '3rd'
 * -numberToOrdinal(4) ==> '4th'
 * <p>
 * ... and so on
 */
public class OrdinalConverter {

	public static void main(String[] args) {
		System.out.println(convertNumberToOrdinal(1));
		System.out.println(convertNumberToOrdinal(100));
		System.out.println(convertNumberToOrdinal(22));

	}

	private static String convertNumberToOrdinal(int number) {
		if (number == 0) {
			return Integer.toString(number);
		}

		String ordinalSuffix = determineOrdinalSuffix(number);
		return Integer.toString(number).concat(ordinalSuffix);
	}

	private static String determineOrdinalSuffix(int number) {
		int lastDigit = number % 10;
		int lastTwoDigit = number % 100;
		if (lastTwoDigit >=10 && lastTwoDigit <=13){
			return "th";
		}
		switch (lastDigit) {
			case 1:
				return "st";
			case 2:
				return "nd";
			case 3:
				return "rd";
			default:
				return "th";
		}
	}
}
