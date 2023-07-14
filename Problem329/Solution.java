class Solution {
    private static final int[][] DIRECTIONS = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int ans = 0;

    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        Integer[][] memo = new Integer[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (memo[i][j] == null) {
                    dfs(i, j, matrix, memo);
                }
            }
        }

        return ans;
    }


    private int dfs(int i, int j, int[][] matrix, Integer[][] memo) {
        int n = matrix.length, m = matrix[0].length;

        if (memo[i][j] != null) {
            return memo[i][j];
        }


        int max = 1;
        for (int[] dir : DIRECTIONS) {
            int a = i + dir[0], b = j + dir[1];
            if (a < 0 || a >= n || b < 0 || b >= m) {
                continue;
            }

            if (matrix[i][j] >= matrix[a][b]) {
                continue;
            }

            max = Math.max(max, 1 + dfs(a, b, matrix, memo));
        }


        memo[i][j] = max;
        ans = Math.max(max, ans);
        return max;
    }
}