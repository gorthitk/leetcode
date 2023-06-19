
class Solution
{
    public int pivotIndex(int[] nums)
    {
        int sum = 0;
        for (int num : nums)
        {
            sum += num;
        }
        int left = 0;
        for (int i = 0; i < nums.length; i++)
        {
            left = left + (i == 0 ? 0 : nums[i - 1]);
            if (left == sum - left - nums[i])
            {
                return i;
            }
        }
        return -1;
    }
}