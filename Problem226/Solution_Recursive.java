/**
 * @author tgorthi
 * @since Jun 2020
 */

import Solution.TreeNode;

public class Solution
{
    public TreeNode invertTree(TreeNode root)
    {
        if (root == null)
        {
            return null;
        }
        TreeNode left = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(left);
        return root;
    }
}