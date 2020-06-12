public class Solution
{
    public int searchInsert(int[] nums, int target)
    {
        return getIdx(nums, target, 0, nums.length - 1);
    }

    private int getIdx(int[] nums, int target, int start, int end)
    {
        if (start > end)
            return start;
        if (nums[start] == target)
            return start;
        if (nums[end] == target)
            return end;
        int mid = (start + end) / 2;
        if (nums[mid] == target)
            return mid;
        if (nums[mid] > target)
            return getIdx(nums, target, start, mid - 1);
        return getIdx(nums, target, mid + 1, end);
    }
}