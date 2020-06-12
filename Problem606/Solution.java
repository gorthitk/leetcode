/**
 * @author tgorthi
 * @since Jun 2020
 */
public class Solution
{
    public String tree2str(TreeNode t)
    {
        if (t == null)
        {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(t.val);
        if (t.left == null && t.right == null)
        {
            return sb.toString();
        }
        sb.append("(");
        sb.append(tree2str(t.left));
        sb.append(")");
        if (t.right != null)
        {
            sb.append("(");
            sb.append(tree2str(t.right));
            sb.append(")");
        }
        return sb.toString();
    }
}