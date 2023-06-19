
class Solution
{
    public int minStartValue(int[] nums)
    {
        int result = 1;
        int val = 1;
        for (int num : nums)
        {
            val += num;
            if (val <= 0)
            {
                final int toAdd = Math.abs(val) + 1;
                result += toAdd;
                val += toAdd;
            }
        }
        return result;
    }
}