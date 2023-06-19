class Solution {
    public int[] findBuildings(int[] heights) {
        int max = Integer.MIN_VALUE;

        int n = heights.length;
        boolean[] canSee = new boolean[n];
        int count = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (heights[i] > max) {
                canSee[i] = true;
                count++;
            }

            max = Math.max(max, heights[i]);
        }


        int[] result = new int[count];
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (canSee[i]) {
                result[j++] = i;
            }
        }

        return result;
    }
}