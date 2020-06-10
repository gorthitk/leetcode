class Solution
{
    private int count;

    public int sumEvenGrandparent(TreeNode root)
    {
        count = 0;
        _getChildSum(root);

        return count;
    }

    private int _getChildSum(TreeNode root)
    {
        if (root == null)
        {
            return 0;
        }

        final int childSum = (root.left != null ? root.left.val : 0) + (root.right != null ? root.right.val : 0);
        final int grandChildSum = _getChildSum(root.left) + _getChildSum(root.right);

        if (root.val % 2 == 0)
        {
            count += grandChildSum;
        }

        return childSum;
    }
}