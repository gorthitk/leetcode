/**
 * @author tgorthi
 * @since Jun 2020
 */

import Solution.TreeNode;

public class Solution
{
    private int postOrderIdx;

    public TreeNode buildTree(int[] inorder, int[] postorder)
    {
        postOrderIdx = postorder.length - 1;
        return getRoot(inorder, postorder, 0, inorder.length - 1);
    }

    private TreeNode getRoot(int[] inorder, int[] postorder, int start, int end)
    {
        if (start > end)
        {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postOrderIdx--]);
        int rootIdx = 0;
        while (inorder[rootIdx] != root.val)
        {
            rootIdx++;
        }
        root.right = getRoot(inorder, postorder, rootIdx + 1, end);
        root.left = getRoot(inorder, postorder, start, rootIdx - 1);
        return root;
    }
}