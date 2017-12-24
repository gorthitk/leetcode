class Solution {
	public int minCostClimbingStairs(int[] cost) {
		if (cost == null || cost.length == 0)
		{
			return Integer.MAX_VALUE;
		}

		int len = cost.length;
		if (len == 1 || len == 2)
		{
			return len == 1 ? cost[0] : Math.min(cost[1], cost[0]);
		}

		int[] dp = new int[len+1];
		dp[0] = cost[0];
		dp[1] = cost[1];

		for (int i = 2; i <= len; i++)
		{
			dp[i] = Math.min(dp[i-1], dp[i-2]) + (i == len ? 0 : cost[i]);
		}

		return dp[len];
	}
}