/**
 * @author tgorthi
 * @since Jun 2020
 */

import java.util.*;

public class Solution
{
    private int maxCount;
    private int count;
    private int curr;

    public int[] findMode(TreeNode root)
    {
        List<Integer> result = new ArrayList<>();
        maxCount = 0;
        count = 0;
        curr = Integer.MAX_VALUE;
        inOrder(result, root);
        int n = result.size();
        int[] res = new int[n];
        for (int i = 0; i < n; i++)
        {
            res[i] = result.get(i);
        }
        return res;
    }

    private void inOrder(List<Integer> result, TreeNode root)
    {
        if (root == null)
        {
            return;
        }
        inOrder(result, root.left);
        count = root.val == curr ? count + 1 : 1;
        curr = root.val;
        if (count > maxCount)
        {
            result.clear();
        }
        maxCount = count >= maxCount ? count : maxCount;
        if (count >= maxCount)
        {
            result.add(curr);
        }
        inOrder(result, root.right);
    }
}