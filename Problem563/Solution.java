public class Solution
{
    public int findTilt(TreeNode root)
    {
        if (root == null || (root.left == null && root.right == null))
        {
            return 0;
        }
        return getTilt(root)[0];
    }

    private int[] getTilt(TreeNode root)
    {
        if (root == null)
        {
            return new int[] { 0, 0 };
        }

        int[] left = getTilt(root.left);
        int[] right = getTilt(root.right);
        return new int[] { left[0] + right[0] + Math.abs(left[1] - right[1]), left[1] + right[1] + root.val };
    }

    public class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x)
        {
            val = x;
        }
    }
}