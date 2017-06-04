import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<Integer> diffWaysToCompute(String input) {

		return getWays(input, 0, input.length() - 1);
	}

	private List<Integer> getWays(String input, int start, int end) {

		List<Integer> result = new ArrayList<>();
		for (int i = start; i <= end; i++) {
			if (input.charAt(i) == '*' || input.charAt(i) == '+' || input.charAt(i) == '-') {
				char operator = input.charAt(i);
				List<Integer> left = getWays(input, start, i - 1);
				List<Integer> right = getWays(input, i + 1, end);
				for (Integer l : left) {
					for (Integer r : right) {
						result.add(operationResult(l, r, operator));
					}
				}
			}
		}
		if (result.isEmpty()) {
			result.add(Integer.parseInt(input.substring(start, end + 1)));
		}
		return result;
	}

	private Integer operationResult(Integer l, Integer r, char operator) {
		if (operator == '+')
			return l + r;
		else if (operator == '-')
			return l - r;
		return l * r;
	}
}