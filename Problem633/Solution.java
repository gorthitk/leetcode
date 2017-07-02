public class Solution {
	public boolean judgeSquareSum(int c) {
		if (c == 0)
			return true;
		for (int i = 0; i < Math.sqrt(c); i++) {
			int j = c - i * i;
			if (j % Math.sqrt(j) == 0) {
				return true;
			}
		}
		return false;
	}
}