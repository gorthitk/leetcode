/**
 * @author tgorthi
 * @since Jun 2020
 */
public class Solution
{
    public TreeNode sortedArrayToBST(int[] nums)
    {
        if (nums == null || nums.length == 0)
        {
            return null;
        }
        return getBST(nums, 0, nums.length - 1);
    }

    private TreeNode getBST(int[] nums, int start, int end)
    {
        if (start > end)
        {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode left = getBST(nums, start, mid - 1);
        TreeNode right = getBST(nums, mid + 1, end);
        TreeNode root = new TreeNode(nums[mid]);
        root.left = left;
        root.right = right;
        return root;
    }
}