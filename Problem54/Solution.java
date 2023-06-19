class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        List<Integer> result = new ArrayList<>();

        generate(matrix, 0, n - 1, 0, m - 1, result);

        return result;
    }

    private static void generate(int[][] grid, int r1, int r2, int c1, int c2, List<Integer> result) {
        if (r2 < r1 || c2 < c1) {
            return;
        }

        int n = grid.length, m = grid[0].length;

        for (int i = c1; i <= c2; i++) {
            result.add(grid[r1][i]);
        }

        for (int i = r1 + 1; i < r2; i++) {
            result.add(grid[i][c2]);
        }

        // Dont populate if the rows are the same.
        if (r1 != r2) {
            for (int i = c2; i >= c1; i--) {
                result.add(grid[r2][i]);
            }
        }

        // Dont populate if the columns are the same.
        if (c1 != c2) {
            for (int i = r2 - 1; i > r1; i--) {
                result.add(grid[i][c1]);
            }
        }

        generate(grid, r1 + 1, r2 - 1, c1 + 1, c2 - 1, result);
    }
}