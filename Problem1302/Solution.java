
class Solution
{
    public int deepestLeavesSum(TreeNode root)
    {
        return _calculate(root, 0)[0];
    }    // sum, level    private int[] _calculate(TreeNode root, int level)    {        if (root == null)        {
//          return new int[] { 0, Integer.MIN_VALUE };        }        if (root.left == null && root.right == null)
//          {            return new int[] { root.val, level };        }        int[] left = _calculate(root.left,
//          level + 1);        int[] right = _calculate(root.right, level + 1);        if (left[1] > right[1])
//          {            return left;        }        else if (right[1] > left[1])        {            return right;
//          }        return new int[] { left[0] + right[0], left[1] };    }}