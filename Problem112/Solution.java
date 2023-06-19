

import Solution.TreeNode;

public class Solution
{
    public boolean hasPathSum(TreeNode root, int sum)
    {
        if (root == null || (root.left == null && root.right == null && sum - root.val != 0))
        {
            return false;
        }
        return (root.left == null && root.right == null && sum - root.val == 0) || hasPathSum(root.left,
                sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}