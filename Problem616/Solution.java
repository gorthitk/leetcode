import java.util.*;

public class Solution
{
    public String addBoldTag(String s, String[] dict)
    {
        StringBuilder res = new StringBuilder();
        List<int[]> intervals = new ArrayList<int[]>();
        for (String dic : dict)
        {
            int idx = s.indexOf(dic);
            if (idx == -1)
                continue;
            while (idx != -1)
            {
                intervals.add(new int[] { idx, idx + dic.length() });
                idx = s.indexOf(dic, idx + 1);
            }

        }
        List<int[]> mergedIntervals = merge(intervals);
        int start = 0;
        for (int[] interval : mergedIntervals)
        {
            res.append(s.substring(start, interval[0]));
            res.append("<b>");
            res.append(s.substring(interval[0], interval[1]));
            res.append("</b>");
            start = interval[1];
        }
        res.append(s.substring(start, s.length()));
        return res.toString();
    }

    private List<int[]> merge(List<int[]> intervals)
    {
        if (intervals.isEmpty() || intervals.size() < 2)
        {
            return intervals;
        }
        Collections.sort(intervals, new Comparator<int[]>()
        {

            @Override
            public int compare(int[] o1, int[] o2)
            {
                return o1[0] - o2[0];
            }
        });
        List<int[]> mergedIntervals = new ArrayList<>();
        int[] prev = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++)
        {
            int[] current = intervals.get(i);
            if (current[0] <= prev[1])
            {
                prev[1] = Math.max(prev[1], current[1]);
            }
            else
            {
                mergedIntervals.add(prev);
                prev = current;
            }
        }
        mergedIntervals.add(prev);
        return mergedIntervals;
    }

}