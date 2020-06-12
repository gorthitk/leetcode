public class Solution
{
    public List<Interval> merge(List<Interval> intervals)
    {
        if (intervals == null || intervals.size() == 0)
            return intervals;
        intervals.sort((a, b) -> a.start != b.start ? a.start - b.start : a.end - b.end);
        List<Interval> result = new ArrayList<>();
        Interval prev = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++)
        {
            Interval current = intervals.get(i);
            if (current.start > prev.end)
            {
                result.add(prev);
                prev = current;
            }
            else
            {
                prev.end = Math.max(current.end, prev.end);
            }
        }
        result.add(prev);
        return result;
    }
}