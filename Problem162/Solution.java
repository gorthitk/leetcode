
public class Solution
{
    public int findPeakElement(int[] nums)
    {
        int n = nums.length;
        int idx = nums.length == 1 ? 0 : nums[0] > nums[1] ? 0 : nums[n - 1] > nums[n - 2] ? n - 1 : -1;
        for (int i = 0; idx == -1 && i < n; i++)
        {
            idx = i != 0 && i != n - 1 && nums[i] > nums[i - 1] && nums[i] > nums[i + 1] ? i : idx;
        }
        return idx;
    }
}