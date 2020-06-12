/**
 * @author tgorthi
 * @since Jun 2020
 */
public class Solution
{
    public int sumOfLeftLeaves(TreeNode root)
    {
        return root == null ? 0 : (root.left != null && root.left.left == null && root.left.right == null ?
                root.left.val : 0) + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
}