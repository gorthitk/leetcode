/**
 * @author tgorthi
 * @since Jun 2020
 */

import java.util.ArrayList;
import java.util.List;

class Solution
{
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved)
    {
        final List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++)
        {
            final int start = intervals[i][0];
            final int end = intervals[i][1];
            if (start >= toBeRemoved[0] && end <= toBeRemoved[1])
            {
                continue;
            }
            if (end <= toBeRemoved[0] || start >= toBeRemoved[1])
            {
                result.add(List.of(start, end));
                continue;
            }
            if (start >= toBeRemoved[0])
            {
                result.add(List.of(toBeRemoved[1], end));
                continue;
            }
            if (end <= toBeRemoved[1])
            {
                result.add(List.of(start, toBeRemoved[0]));
            }
            else
            {
                result.add(List.of(start, toBeRemoved[0]));
                result.add(List.of(toBeRemoved[1], end));
            }
        }
        return result;
    }
}