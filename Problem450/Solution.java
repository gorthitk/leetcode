import Solution.TreeNode;

public class Solution
{
    public TreeNode deleteNode(TreeNode root, int key)
    {
        if (root == null)
            return null;
        if (root.val > key)
        {
            root.left = deleteNode(root.left, key);
        }
        else if (root.val < key)
        {
            root.right = deleteNode(root.right, key);
        }
        else
        {
            if (root.left == null && root.right == null)
            {
                return null;
            }
            else if (root.right == null)
            {
                return root.left;
            }
            else if (root.left == null)
            {
                return root.right;
            }
            else
            {
                TreeNode left = root.left;
                while (left.right != null)
                {
                    left = left.right;
                }
                left.right = root.right;
                return root.left;
            }

        }
        return root;
    }
}