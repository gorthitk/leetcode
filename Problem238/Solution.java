/**
 * @author tgorthi
 * @since Jun 2020
 */
public class Solution
{
    public int[] productExceptSelf(int[] nums)
    {
        int[] product = new int[nums.length];
        product[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--)
        {
            product[i] = product[i + 1] * nums[i + 1];
        }
        int left = 1;
        for (int i = 0; i < nums.length; i++)
        {
            product[i] *= left;
            left *= nums[i];
        }
        return product;
    }
}