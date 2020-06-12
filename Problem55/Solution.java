/**
 * @author tgorthi
 * @since Jun 2020
 */
public class Solution
{
    public boolean canJump(int[] nums)
    {
        int max = 0;
        for (int i = 0; i < nums.length && i <= max; i++)
        {
            max = Math.max(max, i + nums[i]);
        }
        return max >= nums.length - 1;
    }
}