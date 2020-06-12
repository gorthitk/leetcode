/**
 * @author tgorthi
 * @since Jun 2020
 */

import java.util.Arrays;

public class Solution
{
    public int minSteps(int n)
    {
        if (n <= 1)
        {
            return 0;
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = dp[1] = 0;
        for (int i = 1; i <= n; i++)
        {
            dp[i] = Math.min(dp[i], i);
            for (int j = 1; j * i <= n; j++)
            {
                dp[i * j] = Math.min(dp[i * j], dp[i] + j);
            }
        }
        return dp[n];
    }
}