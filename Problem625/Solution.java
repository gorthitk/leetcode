import java.util.*;

public class Solution {
	public int smallestFactorization(int a) {
		if (a < 10)
			return a;
		long result = 0;
		List<Integer> res = new ArrayList<>();
		for (int i = 9; i > 1; i--) {
			while (a % i == 0) {
				a = a / i;
				res.add(i);
			}
		}
		if (a != 1) return 0;
		for (int i = res.size() - 1; i >= 0; i--) {
			result = result * 10 + res.get(i);
			if (result > Integer.MAX_VALUE)
				return 0;
		}
		return (int) result;
	}
}