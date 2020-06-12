/**
 * @author tgorthi
 * @since Jun 2020
 */
public class Solution
{
    public int maxDepth(TreeNode root)
    {
        return root == null ? 0 : 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}