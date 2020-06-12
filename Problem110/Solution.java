/**
 * @author tgorthi
 * @since Jun 2020
 */
public class Solution
{
    public boolean isBalanced(TreeNode root)
    {
        return getHeight(root) != -1;
    }

    private int getHeight(TreeNode root)
    {
        if (root == null)
        {
            return 0;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return left != -1 && right != -1 && Math.abs(left - right) < 2 ? 1 + Math.max(left, right) : -1;
    }

    public class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x)
        {
            val = x;
        }
    }
}