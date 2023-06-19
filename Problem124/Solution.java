
public class Solution
{
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root)
    {
        getMaxPath(root);
        return maxSum;
    }

    private int getMaxPath(TreeNode root)
    {
        if (root == null)
        {
            return 0;
        }
        int left = getMaxPath(root.left);
        int right = getMaxPath(root.right);
        int maxPathSum = Math.max(root.val, root.val + Math.max(left, right));
        maxSum = Math.max(maxSum, Math.max(maxPathSum, root.val + left + right));
        return maxPathSum;
    }
}