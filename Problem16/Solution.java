import java.util.*;

public class Solution
{
    public int threeSumClosest(int[] nums, int target)
    {
        Arrays.sort(nums);
        int n = nums.length;
        int result = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < n - 2; i++)
        {
            int j = i + 1, k = n - 1;
            while (j < k)
            {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target)
                    return target;
                if (Math.abs(sum - target) < Math.abs(result - target))
                {
                    result = sum;
                }
                k = sum > target ? k - 1 : k;
                j = sum < target ? j + 1 : j;
            }
        }
        return result;
    }
}