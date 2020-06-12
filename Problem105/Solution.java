/**
 * @author tgorthi
 * @since Jun 2020
 */
public class Solution
{
    private int currPreorderIdx;

    public TreeNode buildTree(int[] preorder, int[] inorder)
    {
        currPreorderIdx = 0;
        return getNode(preorder, inorder, 0, inorder.length - 1);
    }

    private TreeNode getNode(int[] preorder, int[] inorder, int start, int end)
    {
        if (start > end)
        {
            return null;
        }
        TreeNode root = new TreeNode(preorder[currPreorderIdx++]);
        int rootIdx = 0;
        while (inorder[rootIdx] != root.val)
        {
            rootIdx++;
        }
        root.left = getNode(preorder, inorder, start, rootIdx - 1);
        root.right = getNode(preorder, inorder, rootIdx + 1, end);
        return root;
    }
}