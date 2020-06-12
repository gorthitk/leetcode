/**
 * @author tgorthi
 * @since Jun 2020
 */

import java.util.ArrayList;
import java.util.List;

public class Solution
{
    public int minimumTotal(List<List<Integer>> triangle)
    {
        int n = triangle.size();
        List<List<Integer>> dp = new ArrayList<>();
        dp.add(triangle.get(n - 1));
        int k = 0;
        for (int i = n - 2; i >= 0; i--)
        {
            List<Integer> list = triangle.get(i);
            List<Integer> localMax = new ArrayList<>();
            for (int j = 0; j < list.size(); j++)
            {
                int min = Math.min(dp.get(k).get(j), dp.get(k).get(j + 1));
                localMax.add(min + list.get(j));
            }
            dp.add(localMax);
            k++;
        }
        return dp.get(n - 1).get(0);
    }
}