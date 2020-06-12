/**
 * @author tgorthi
 * @since Jun 2020
 */
public class Solution
{
    public void nextPermutation(int[] nums)
    {
        int n = nums.length;
        int j = n - 1;
        for (; j >= 1; j--)
        {
            if (nums[j] > nums[j - 1])
            {
                break;
            }
        }
        if (j != 0)
        {
            swap(nums, j - 1);
        }
        reverse(nums, j);
    }

    private void reverse(int[] nums, int j)
    {
        int start = j;
        int end = nums.length - 1;
        while (start < end)
        {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }

    private void swap(int[] nums, int j)
    {
        for (int i = nums.length - 1; i > j; i--)
        {
            if (nums[i] > nums[j])
            {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                break;
            }
        }
    }
}