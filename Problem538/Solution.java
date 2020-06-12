/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Solution
{
    public TreeNode convertBST(TreeNode root)
    {
        getAddVal(root);
        return root;
    }

    private int getAddVal(TreeNode root)
    {
        if (root == null)
        {
            return 0;
        }
        int left = 0;
        int right = 0;

        if (root.right != null)
        {
            right = getAddVal(root.right);
        }
        if (root.left != null)
        {
            left = getAddVal(root.left);
        }
        int addVal = left + right + root.val;
        addtoNodes(root.left, right + root.val);
        root.val = root.val + right;
        return addVal;
    }

    private void addtoNodes(TreeNode node, int right)
    {
        if (node == null)
        {
            return;
        }
        node.val = node.val + right;
        addtoNodes(node.left, right);
        addtoNodes(node.right, right);
    }

}