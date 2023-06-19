
class Solution
{
    public int dominantIndex(int[] nums)
    {
        int max = 0, secondMax = 0, maxIdx = 0;
        for (int i = 0; i < nums.length; i++)
        {
            int currNum = nums[i];
            if (currNum > max)
            {
                secondMax = max;
                max = currNum;
                maxIdx = i;
            }
            else if (currNum > secondMax)
            {
                secondMax = currNum;
            }
        }
        return max >= 2 * secondMax ? maxIdx : -1;
    }
}