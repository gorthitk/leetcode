import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;

        // Insert into list.
        List<int[]> list = insertIntoList(intervals, newInterval);

        int[] previous = list.get(0);
        List<int[]> result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            int[] current = list.get(i);
            if (isOverlap(current, previous)) {
                previous = mergeIntervals(current, previous);
            } else {
                result.add(previous);
                previous = current;
            }
        }

        result.add(previous);

        return covertIntoArray(result);
    }

    private int[][] covertIntoArray(List<int[]> result) {
        int[][] ans = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }

    private int[] mergeIntervals(int[] current, int[] previous) {
        return new int[]{Math.min(previous[0], current[0]), Math.max(previous[1], current[1])};
    }

    private List<int[]> insertIntoList(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> list = new ArrayList<>();
        for (int[] interval : intervals) {
            list.add(interval);
        }

        boolean inserted = false;
        for (int i = 0; i <= n && !inserted; i++) {
            if (i == n || newInterval[0] < list.get(i)[0]) {
                list.add(i, newInterval);
                inserted = true;
            }
        }

        return list;
    }

    private boolean isOverlap(int[] current, int[] previous) {
        return previous[1] >= current[0];
    }
}