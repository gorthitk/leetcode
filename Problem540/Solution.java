
public class Solution
{
    public int singleNonDuplicate(int[] nums)
    {
        int singleElement = 0;
        for (int num : nums)
        {
            singleElement ^= num;
        }
        return singleElement;
    }
}