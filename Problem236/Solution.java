/**
 * @author tgorthi
 * @since Jun 2020
 */
public class Solution
{
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
    {
        if (root == null || p == root || q == root)
        {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return left != null && right != null ? root : left != null ? left : right;
    }
}