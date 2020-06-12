/**
 * @author tgorthi
 * @since Jun 2020
 */

import java.util.List;

public class Solution
{
    public int maxDistance(List<List<Integer>> arrays)
    {
        int currMin = arrays.get(0).get(0);
        int currMax = arrays.get(0).get(arrays.get(0).size() - 1);
        int result = Integer.MIN_VALUE;
        for (int i = 1; i < arrays.size(); i++)
        {
            int min = arrays.get(i).get(0);
            int max = arrays.get(i).get(arrays.get(i).size() - 1);
            result = Math.max(result, Math.abs(currMin - max));
            result = Math.max(result, Math.abs(currMax - min));
            currMax = Math.max(currMax, max);
            currMin = Math.min(currMin, min);
        }
        return result;
    }
}