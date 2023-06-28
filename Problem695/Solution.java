import java.util.LinkedList;
import java.util.Queue;

class Solution {
    private static final int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length, m = grid[0].length;

        boolean[][] visited = new boolean[n][m];
        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] || grid[i][j] == 0) {
                    continue;
                }

                max = Math.max(max, findArea(i, j, grid, visited));
            }
        }

        return max;
    }

    private int findArea(int i, int j, int[][] grid, boolean[][] visited) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        visited[i][j] = true;
        int area = 1;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            for (int[] dir : directions) {
                int a = curr[0] + dir[0], b = curr[1] + dir[1];
                if (a < 0 || a >= grid.length || b < 0 || b >= grid[0].length) {
                    continue;
                }

                if (grid[a][b] == 1 && !visited[a][b]) {
                    queue.add(new int[]{a, b});
                    area++;
                    visited[a][b] = true;
                }
            }

        }

        return area;
    }
}