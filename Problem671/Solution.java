
class Solution
{
    public int findSecondMinimumValue(TreeNode root)
    {
        if (root == null || root.left == null || root.right == null)
        {
            return -1;
        }
        int left = root.left.val, right = root.right.val;
        if (root.left.val == root.val)
        {
            left = findSecondMinimumValue(root.left);
        }
        if (root.right.val == root.val)
        {
            right = findSecondMinimumValue(root.right);
        }
        if (left != -1 && right != -1)
        {
            return Math.min(left, right);
        }
        return left == -1 ? right : left;
    }
}