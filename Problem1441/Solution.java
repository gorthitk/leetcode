/**
 * @author tgorthi
 * @since Jun 2020
 */

import java.util.ArrayList;
import java.util.List;

class Solution
{
    public List<String> buildArray(int[] target, int n)
    {
        final List<String> result = new ArrayList<>();
        result.add("Push");
        int j = 0;
        for (int i = 1; i <= n; i++)
        {
            if (target[j] != i)
            {
                result.add("Pop");
            }
            else
            {
                j++;
            }
            if (j >= target.length)
            {
                break;
            }
            if (i != n)
            {
                result.add("Push");
            }
        }
        return result;
    }
}