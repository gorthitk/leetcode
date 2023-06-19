
class Solution
{
    public int goodNodes(TreeNode root)
    {
        return _count(root, Integer.MIN_VALUE);
    }

    private int _count(TreeNode root, int maxSoFar)
    {
        if (root == null)
        {
            return 0;
        }
        final int max = Math.max(root.val, maxSoFar);
        return (root.val >= maxSoFar ? 1 : 0) + _count(root.left, max) + _count(root.right, max);
    }
}