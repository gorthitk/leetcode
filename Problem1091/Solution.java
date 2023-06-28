import java.util.*;

class Solution {
    private static final int[][] directions = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1,
            0}, {1, 1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        if (grid[0][0] == 1 || grid[n - 1][m - 1] == 1) {
            return -1;
        }

        // Set up the BFS.
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1}); // Put distance on the queue
        boolean[][] visited = new boolean[grid.length][grid[0].length]; // Used as visited set.
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] cell = queue.remove();
            int row = cell[0], col = cell[1], distance = cell[2];

            if (row == n - 1 && col == m - 1) {
                return distance;
            }

            for (int[] dir : directions) {
                int neighbourRow = row + dir[0], neighbourCol = col + dir[1];

                if (isValid(grid, neighbourRow, neighbourCol) && !visited[neighbourRow][neighbourCol]) {
                    visited[neighbourRow][neighbourCol] = true;
                    queue.add(new int[]{neighbourRow, neighbourCol, distance + 1});
                }
            }
        }

        return -1;
    }


    private static boolean isValid(int[][] grid, int i, int j) {
        int n = grid.length, m = grid[0].length;
        return i >= 0 && i < n && j >= 0 && j < m && grid[i][j] == 0;
    }
}