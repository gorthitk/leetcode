/**
 * @author tgorthi
 * @since Jun 2020
 */
public class Solution
{
    public int wiggleMaxLength(int[] nums)
    {
        if (nums.length == 0)
        {
            return 0;
        }
        int up = 1;
        int down = 1;
        for (int i = 1; i < nums.length; i++)
        {
            up = nums[i] > nums[i - 1] ? down + 1 : up;
            down = nums[i] < nums[i - 1] ? up + 1 : down;
        }
        return Math.max(up, down);
    }
}