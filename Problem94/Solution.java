/**
 * @author tgorthi
 * @since Jun 2020
 */

import java.util.*;

public class Solution
{
    public List<Integer> inorderTraversal(TreeNode root)
    {
        List<Integer> inorder = new ArrayList<>();
        if (root != null)
        {
            inorder.addAll(inorderTraversal(root.left));
            inorder.add(root.val);
            inorder.addAll(inorderTraversal(root.right));
        }
        return inorder;
    }
}