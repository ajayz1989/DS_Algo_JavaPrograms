package com.ajay.problems;

/**
 * @author ajaykumar
 */
public class ReversePolishNotification {

	public static void main(String[] args) {
		String str = "1 3 +";
		System.out.println(getRPN(str.split(" ")));
	}

	private static Integer getRPN(String[] tokens) {
		int first = 0;
		for (int i = 0; i < tokens.length; i++) {
			if (!isNumber(tokens[i])) {
				int oprnd2Val = Integer.parseInt(tokens[i - 1]);
				int oprnd1Pos;
				if (isNumber(tokens[i - 2])) {
					first = oprnd1Pos = i - 2;
				} else {
					while (first > 0 && !isNumber(tokens[first]))
						first--;
					oprnd1Pos = first;
				}

				tokens[i] = Integer.toString(eval(Integer.parseInt(tokens[oprnd1Pos]), oprnd2Val, tokens[i].charAt(0)));
				tokens[i - 1] = tokens[oprnd1Pos] = " ";
			}
		}
		return Integer.valueOf(tokens[tokens.length - 1]);
	}

	private static boolean isNumber(String str) {
		return (str.length() == 1 && Character.isDigit(str.charAt(0)))
			|| (str.length() >= 2 && Character.isDigit(str.charAt(1)));
	}

	private static int eval(int v1, int v2, char op) {
		switch (op) {
			case '+':
				return v1 + v2;
			case '-':
				return v1 - v2;
			case '/':
				return v1 / v2;
			case '*':
				return v1 * v2;
		}
		return 0;
	}
}
