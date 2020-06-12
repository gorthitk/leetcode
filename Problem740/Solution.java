/**
 * @author tgorthi
 * @since Jun 2020
 */
class Solution
{
    public int deleteAndEarn(int[] nums)
    {
        int[] countsOfEachNumber = new int[10001];
        for (int num : nums)
        {
            countsOfEachNumber[num] += num;
        }
        int[] maxEarnings = new int[10003];
        for (int i = 10000; i >= 0; i--)
        {
            maxEarnings[i] = Math.max(countsOfEachNumber[i] + maxEarnings[i + 2], maxEarnings[i + 1]);
        }
        return maxEarnings[0];
    }
}