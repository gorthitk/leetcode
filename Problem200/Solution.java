class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    flip(i, j, grid);
                }
            }
        }

        return count;
    }

    private void flip(int i, int j, char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        if (i >= n || j >= m || i < 0 || j < 0) {
            return;
        }

        if (grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';

        flip(i + 1, j, grid);
        flip(i - 1, j, grid);
        flip(i, j + 1, grid);
        flip(i, j - 1, grid);
    }
}