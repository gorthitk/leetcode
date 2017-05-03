public class Solution {

	public int numberOfArithmeticSlices(int[] A) {
		if (A == null || A.length < 3)
			return 0;
		int n = A.length;
		int[] dp = new int[n];
		dp[0] = 0;
		dp[1] = 0;
		int diff = A[1] - A[0];
		int start = 0;
		for (int i = 2; i < n; i++) {
			int currDiff = A[i] - A[i - 1];
			if (currDiff == diff) {
				dp[i] = dp[i - 1] + 1 + (i - 2 - start);
			} else {
				dp[i] = dp[i - 1];
				start = i - 1;
				diff = currDiff;
			}
		}
		return dp[n - 1];
	}
}