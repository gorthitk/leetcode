/**
 * @author tgorthi
 * @since Jun 2020
 */
public class Solution
{
    public boolean isSubtree(TreeNode s, TreeNode t)
    {
        return isSubtree(s, t, false);
    }

    private boolean isSubtree(TreeNode s, TreeNode t, boolean partialMatch)
    {
        if ((s == null && t != null) || (s != null && t == null))
        {
            return false;
        }
        if (s == null && t == null)
        {
            return true;
        }
        if (t.val == s.val && isSubtree(s.left, t.left, true) && isSubtree(s.right, t.right, true))
        {
            return true;
        }
        if (partialMatch)
        {
            return false;
        }
        return isSubtree(s.left, t, false) || isSubtree(s.right, t, false);
    }
}