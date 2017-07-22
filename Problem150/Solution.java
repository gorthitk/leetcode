import java.util.*;

public class Solution {
	public int evalRPN(String[] tokens) {
		List<String> operators = Arrays.asList("+", "-", "*", "/");

		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < tokens.length; i++) {
			stack.push(operators.contains(tokens[i]) ? value(stack, tokens[i]) : Integer.parseInt(tokens[i]));
		}
		return stack.pop();
	}

	private int value(Stack<Integer> stack, String operator) {
		int y = stack.pop(), x = stack.pop();
		switch (operator) {
		case "+":
			return x + y;
		case "-":
			return x - y;
		case "*":
			return x * y;
		default:
			return x / y;
		}
	}
}