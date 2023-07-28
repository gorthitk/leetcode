import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // Keep the smaller intervals and delete the larger intervals.
        // Why ? : Because we need to only erase minimum number of intervals.
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

        int startLimit = Integer.MIN_VALUE;
        int result = 0;
        for (int i = 0; i < intervals.length; i++) {
            int a = intervals[i][0], b = intervals[i][1];

            if (a >= startLimit) {
                startLimit = b;
            } else {
                result++;
            }
        }

        return result;
    }
}