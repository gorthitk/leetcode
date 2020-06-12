/**
 * @author tgorthi
 * @since Jun 2020
 */
public class Solution
{
    public boolean isValidBST(TreeNode root)
    {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode p, Long min, Long max)
    {
        if (p == null)
        {
            return true;
        }
        if (p.val <= min || p.val >= max)
        {
            return false;
        }
        return isValidBST(p.left, min, new Long(p.val)) && isValidBST(p.right, new Long(p.val), max);
    }
}