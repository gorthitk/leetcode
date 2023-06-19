

import java.util.ArrayList;
import java.util.List;

class Solution
{
    public int maxProduct(TreeNode root)
    {
        final List<Integer> counts = new ArrayList<>();
        final long totalSum = _calculate(root, counts);
        long max = 0;
        for (long count : counts)
        {
            max = Math.max(max, count * (totalSum - count));
        }
        return (int) (max % 1000000007);
    }

    private int _calculate(final TreeNode root, final List<Integer> counts)
    {
        if (root == null)
        {
            return 0;
        }
        int sum = root.val + _calculate(root.left, counts) + _calculate(root.right, counts);
        counts.add(sum);
        return sum;
    }
}