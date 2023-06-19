
public class Solution
{
    public boolean isSymmetric(TreeNode root)
    {
        return root == null || isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right)
    {
        return left == null || right == null ? left == right : left.val == right.val && isSymmetric(left.left,
                right.right) && isSymmetric(left.right, right.left);
    }
}