/**
 * @author tgorthi
 * @since Jun 2020
 */
public class Solution
{
    private int count;

    public int subarraySum(int[] nums, int k)
    {
        count = 0;
        for (int i = 0; i < nums.length; i++)
        {
            dfs(nums, i + 1, nums[i], k);
        }
        return count;
    }

    private void dfs(int[] nums, int idx, int sum, int k)
    {
        if (sum == k)
        {
            count++;
        }
        if (idx == nums.length)
        {
            return;
        }
        dfs(nums, idx + 1, sum + nums[idx], k);
    }
}