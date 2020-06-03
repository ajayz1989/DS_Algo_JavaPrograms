package com.ajay.problems;

import java.util.Stack;

/**
 * @author ajaykumar
 */
public class RPNUsingStack {
	public static void main(String[] args) {
		String str = "5 1 2 + 4 * + 3 -";
		System.out.println(getRPN(str.split(" ")));
	}

	private static int getRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < tokens.length; i++) {
			if (isOperand(tokens[i])) {
				stack.push(evaluate(stack.pop(), stack.pop(), tokens[i].charAt(0)));
			} else {
				stack.push(Integer.parseInt(tokens[i]));
			}
		}
		return stack.pop();
	}

	private static Integer evaluate(Integer val1, Integer val2, char operand) {
		switch (operand) {
			case '+':
				return val1 + val2;
			case '-':
				return val2 - val1;
			case '/':
				return val2 / val1;
			case '*':
				return val1 * val2;
		}
		return 0;
	}

	private static boolean isOperand(String token) {
		char charAt = token.charAt(0);
		return token.length() == 1 && (charAt == '/' || charAt == '*' || charAt == '+' || charAt == '-');
	}
}
