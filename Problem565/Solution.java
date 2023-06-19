

import java.util.Arrays;

public class Solution
{
    private Integer maxLen;

    public int arrayNesting(int[] nums)
    {
        maxLen = Integer.MIN_VALUE;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 0; i < nums.length; i++)
        {
            if (dp[i] == Integer.MAX_VALUE)
            {
                if (populateCyclicLens(nums, i, dp))
                {
                    break;
                }
            }
        }
        return maxLen;
    }

    private boolean populateCyclicLens(int[] nums, int i, int[] dp)
    {
        int idx = i;
        int count = 0;
        boolean[] visited = new boolean[nums.length];
        while (!visited[idx])
        {
            visited[idx] = true;
            idx = nums[idx];
            count++;
        }
        boolean filled = true;
        for (int j = 0; j < nums.length; j++)
        {
            if (visited[j])
            {
                dp[j] = Math.min(count, dp[j]);
            }
            filled = dp[j] == Integer.MAX_VALUE ? false : filled;
            maxLen = dp[j] == Integer.MAX_VALUE ? maxLen : Math.max(maxLen, dp[j]);
        }
        return filled;
    }
}