
public class Solution
{
    public TreeNode addOneRow(TreeNode root, int v, int d)
    {
        if (d == 1)
        {
            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
        }
        else if (d == 2)
        {
            TreeNode left = root.left;
            TreeNode right = root.right;
            root.left = new TreeNode(v);
            root.right = new TreeNode(v);
            root.left.left = left;
            root.right.right = right;
        }
        else
        {
            root.left = root.left != null ? addOneRow(root.left, v, d - 1) : null;
            root.right = root.right != null ? addOneRow(root.right, v, d - 1) : null;
        }
        return root;
    }
}