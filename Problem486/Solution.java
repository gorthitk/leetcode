public class Solution
{
    public boolean PredictTheWinner(int[] nums)
    {
        return getSum(nums, 0, nums.length - 1) >= 0;
    }

    private int getSum(int[] nums, int start, int end)
    {
        return start == end ? nums[start]
                : Math.max(nums[end] - getSum(nums, start, end - 1), nums[start] - getSum(nums, start + 1, end));
    }
}