/**
 * @author tgorthi
 * @since Jun 2020
 */

import java.util.Arrays;

public class Solution
{
    public int lengthOfLIS(int[] nums)
    {
        if (nums == null || nums.length == 0)
        {
            return 0;
        }
        int maxLen = 1;
        int[] maxLens = new int[nums.length];
        Arrays.fill(maxLens, 1);
        for (int i = nums.length - 1; i >= 0; i--)
        {
            for (int j = i + 1; j < nums.length; j++)
            {
                maxLens[i] = nums[j] > nums[i] ? Math.max(maxLens[j] + 1, maxLens[i]) : maxLens[i];
            }
            maxLen = Math.max(maxLen, maxLens[i]);
        }
        return maxLen;
    }
}