
public class Solution
{
    public boolean find132pattern(int[] nums)
    {
        int n = nums.length;
        for (int min = Integer.MAX_VALUE, i = 0; i < n; i++)
        {
            min = Math.min(min, nums[i]);
            if (nums[i] == min)
            {
                continue;
            }
            for (int j = i + 1; j < n; j++)
            {
                if (min < nums[j] && nums[j] < nums[i])
                {
                    return true;
                }
            }
        }
        return false;
    }
}