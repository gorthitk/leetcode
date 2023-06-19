

import java.util.*;

public class Solution
{
    public List<Double> averageOfLevels(TreeNode root)
    {
        List<Double> avergaes = new ArrayList<Double>();
        if (root != null)
        {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty())
            {
                int count = 0;
                double sum = 0;
                Queue<TreeNode> nextLevel = new LinkedList<>();
                while (!queue.isEmpty())
                {
                    TreeNode node = queue.poll();
                    count++;
                    sum += node.val;
                    if (node.left != null)
                    {
                        nextLevel.add(node.left);
                    }
                    if (node.right != null)
                    {
                        nextLevel.add(node.right);
                    }
                }
                avergaes.add(sum / count);
                queue = nextLevel;
            }
        }
        return avergaes;
    }
}