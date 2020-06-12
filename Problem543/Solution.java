/**
 * @author tgorthi
 * @since Jun 2020
 */

import Solution.TreeNode;

public class Solution
{
    public int diameterOfBinaryTree(TreeNode root)
    {
        if (root == null)
        {
            return 0;
        }
        return Math.max(Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right)),
                height(root.left) + height(root.right));
    }

    private int height(TreeNode node)
    {
        return node != null ? 1 + Math.max(height(node.right), height(node.left)) : 0;
    }
}