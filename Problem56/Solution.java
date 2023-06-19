import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            int idxCompare = a[0] == b[0] ? 1 : 0;
            return Integer.compare(a[idxCompare], b[idxCompare]);
        });


        int n = intervals.length;
        List<int[]> merged = new ArrayList<>();
        int[] current = intervals[0];

        for (int i = 1; i <= n; i++) {
            if (i == n) {
                merged.add(current);
                break;
            }

            // Otherwise.
            if (isOverlap(current, intervals[i])) {
                current = merge(current, intervals[i]);
            } else {
                merged.add(current);
                current = intervals[i];
            }
        }

        int[][] result = new int[merged.size()][2];

        for (int i = 0; i < merged.size(); i++) {
            result[i] = merged.get(i);
        }


        return result;
    }

    private static int[] merge(int[] a, int [] b) {
        return  new int[] {
                a[0],
                Math.max(a[1], b[1])
        };
    }

    private static boolean isOverlap(int[] a, int[] b) {
        return a[1] >= b[0];
    }
}