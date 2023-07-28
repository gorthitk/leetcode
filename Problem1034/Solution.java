class Solution {
    private static final int[][] directions = new int[][] {
            {1,0}, {0, 1}, {-1, 0}, {0 , -1}
    };

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int n = grid.length, m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        dfs(grid, row, col, color, visited);

        return grid;
    }

    private void dfs(int[][] grid, int i, int j, int color, boolean[][] visited) {
        int n = grid.length, m = grid[0].length;
        visited[i][j] = true;
        boolean isEdge = false;
        for (int[] dir : directions) {
            int ni = i + dir[0], nj = j + dir[1];

            if (isEdge(ni, nj, n, m)) {
                isEdge = true;
                continue;
            }

            if (visited[ni][nj]) {
                continue;
            }

            if (grid[i][j] != grid[ni][nj]) {
                isEdge = true;
                continue;
            }

            dfs(grid, ni, nj, color, visited);
        }

        if (isEdge) {
            grid[i][j] = color;
        }
    }

    private boolean isEdge(int i, int j, int n, int m) {
        return i < 0 || j < 0 || i == n || j == m;
    }
}
