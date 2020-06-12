/**
 * @author tgorthi
 * @since Jun 2020
 */
public class Solution
{
    public int findUnsortedSubarray(int[] nums)
    {
        int start = Integer.MAX_VALUE;
        int end = -1;
        int max = nums[0];
        for (int i = 1; i < nums.length; i++)
        {
            if (nums[i] < max)
            {
                end = Math.max(end, i);
                int tmp = i - 1;
                int num = nums[i];
                while (tmp >= 0 && num < nums[tmp])
                {
                    tmp--;
                }
                start = Math.min(start, tmp + 1);
            }
            else
            {
                max = nums[i];
            }
        }
        return end == -1 ? 0 : end - start + 1;
    }
}