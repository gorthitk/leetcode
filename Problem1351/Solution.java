class Solution {
    public int countNegatives(int[][] grid) {
        int count = 0;

        for (int[] arr : grid) {
            count += binaryCount(arr, 0, arr.length - 1);
        }

        return count;
    }

    private int binaryCount(int[] arr, int i, int j) {
        while (i <= j) {
            int mid = (i + j) / 2;

            if (arr[mid] < 0) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }

        return arr.length - i;
    }
}