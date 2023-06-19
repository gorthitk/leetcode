
public class Solution
{
    public int majorityElement(int[] nums)
    {
        int count = 1;
        int elementIdx = 0;
        for (int i = 1; i < nums.length; i++)
        {
            count = nums[i] == nums[elementIdx] ? count + 1 : count - 1;
            if (count < 0)
            {
                elementIdx = i;
                count = 1;
            }
        }
        return nums[elementIdx];
    }
}