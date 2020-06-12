/**
 * @author tgorthi
 * @since Jun 2020
 */

import java.util.*;

public class Solution
{
    public List<List<Integer>> zigzagLevelOrder(TreeNode root)
    {
        List<List<Integer>> result = new ArrayList<>();
        zigzagLevelOrder(result, root, 0);
        for (int i = 1; i < result.size(); i = i + 2)
        {
            Collections.reverse(result.get(i));
        }
        return result;
    }

    private void zigzagLevelOrder(List<List<Integer>> result, TreeNode root, int height)
    {
        if (root == null)
        {
            return;
        }
        if (height == result.size())
        {
            result.add(new LinkedList<Integer>());
        }
        result.get(height).add(root.val);
        zigzagLevelOrder(result, root.left, height + 1);
        zigzagLevelOrder(result, root.right, height + 1);
    }
}