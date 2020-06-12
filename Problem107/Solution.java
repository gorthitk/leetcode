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
    public List<List<Integer>> levelOrderBottom(TreeNode root)
    {
        List<List<Integer>> levels = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty())
        {
            List<Integer> level = new ArrayList<Integer>();
            int size = queue.size();
            for (int i = 0; i < size; i++)
            {
                TreeNode tmp = queue.poll();
                if (tmp != null)
                {
                    level.add(tmp.val);
                    if (tmp.left != null)
                        queue.add(tmp.left);
                    if (tmp.right != null)
                        queue.add(tmp.right);
                }
            }
            if (!level.isEmpty())
                levels.add(level);
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int numberOfLevels = levels.size();
        while (numberOfLevels > 0)
        {
            result.add(levels.get(numberOfLevels - 1));
            numberOfLevels--;
        }
        return result;
    }
}