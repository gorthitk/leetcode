/**
 * @author tgorthi
 * @since Jun 2020
 */

import java.util.*;

public class Solution
{
    public List<Integer> largestValues(TreeNode root)
    {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null)
        {
            queue.add(root);
        }
        while (!queue.isEmpty())
        {
            Queue<TreeNode> nxtQueue = new LinkedList<>();
            int maxVal = Integer.MIN_VALUE;
            while (!queue.isEmpty())
            {
                TreeNode node = queue.poll();
                maxVal = Math.max(maxVal, node.val);
                if (node.left != null)
                {
                    nxtQueue.add(node.left);
                }
                if (node.right != null)
                {
                    nxtQueue.add(node.right);
                }
            }
            result.add(maxVal);
            queue = nxtQueue;
        }
        return result;
    }
}