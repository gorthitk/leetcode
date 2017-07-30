public class Solution {
	public int maxA(int n) {
		int[] dp = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			dp[i] = Math.max(dp[i], i);
			for (int j = i - 3; j >= 0; j--) {
				if (j + 3 <= i) {
					dp[i] = Math.max(dp[i], (i - j - 1) * dp[j]);
				}
			}
		}
		return dp[n];
	}
}