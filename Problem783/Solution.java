
class Solution
{
    public int minDiffInBST(TreeNode root)
    {
        return _calculateMin(root, null, null);
    }

    private int _calculateMin(TreeNode root, Integer lower, Integer upper)
    {
        if (root == null)
        {
            return 0;
        }
        int minimumDifference = Integer.MAX_VALUE;
        if (lower != null)
        {
            minimumDifference = Math.min(root.val - lower, minimumDifference);
        }
        if (upper != null)
        {
            minimumDifference = Math.min(upper - root.val, minimumDifference);
        }
        if (root.left != null)
        {
            minimumDifference = Math.min(minimumDifference, _calculateMin(root.left, lower, root.val));
        }
        if (root.right != null)
        {
            minimumDifference = Math.min(minimumDifference, _calculateMin(root.right, root.val, upper));
        }
        return minimumDifference == Integer.MAX_VALUE ? 0 : minimumDifference;
    }
}