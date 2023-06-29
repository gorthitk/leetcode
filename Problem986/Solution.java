class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i = 0, j = 0;
        int n = firstList.length, m = secondList.length;
        List<int[]> intersections = new ArrayList<>();

        while (i < n && j < m) {
            int[] a = firstList[i];
            int[] b = secondList[j];

            int st = Math.max(a[0], b[0]);
            int end = Math.min(a[1], b[1]);

            if (st <= end) {
                intersections.add(new int[] {st, end});
            }

            if (a[1] < b[1]) {
                i++;
            } else {
                j++;
            }
        }

        // convert to desired output.
        int k = intersections.size();
        int[][] result = new int[k][2];

        for (int l = 0; l < k; l++) {
            result[l] = intersections.get(l);
        }

        return result;
    }
}