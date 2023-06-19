
public class Solution
{
    public int removeDuplicates(int[] nums)
    {
        int i = 0;
        int start = 0;
        for (int j = 1; j < nums.length; j++)
        {
            if (nums[j] != nums[i] || (nums[j] == nums[i] && j - start == 1))
            {
                start = nums[j] != nums[i] ? j : start;
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}