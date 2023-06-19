

import java.util.ArrayList;
import java.util.List;

public class Solution
{
    public List<String> binaryTreePaths(TreeNode root)
    {
        List<String> list = new ArrayList<String>();
        getPaths(root, list);
        return list;
    }

    private void getPaths(TreeNode root, List<String> list)
    {
        if (root == null)
        {
            return;
        }
        if (root.left == null && root.right == null)
        {
            list.add("" + root.val);
            return;
        }
        List<String> left = new ArrayList<String>();
        List<String> right = new ArrayList<String>();
        getPaths(root.left, left);
        getPaths(root.right, right);
        for (String path : left)
        {
            list.add(root.val + "->" + path);
        }
        for (String path : right)
        {
            list.add(root.val + "->" + path);
        }
    }

    public static class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x)
        {
            val = x;
        }
    }
}