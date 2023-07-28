class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;

        int l = 0, r = n * m - 1;

        while (l <= r) {
            int midIdx = (r + l) / 2;
            int mid = matrix[midIdx / n][midIdx % n];

            if (mid == target) {
                return true;
            }

            if (target < mid) {
                r = midIdx - 1;
            } else {
                l = midIdx + 1;
            }
        }


        return false;
    }
}