import java.util.LinkedList;
import java.util.Queue;

class Solution {
    private static int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, -1}, {0, 1},};

    public boolean containsCycle(char[][] grid) {
        int n = grid.length, m = grid[0].length;


        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j]) {
                    continue;
                }

                if (hasCycle(i, j, grid, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean hasCycle(int x, int y, char[][] grid, boolean[][] visited) {
        int n = grid.length, m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y, x, y});
        visited[x][y] = true;
        while (!q.isEmpty()) {

            int[] current = q.poll();
            int a = current[0], b = current[1];
            int px = current[2], py = current[3];

            for (int[] dir : directions) {
                int nx = a + dir[0], ny = b + dir[1];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && grid[nx][ny] == grid[a][b]) {
                    if (!visited[nx][ny]) {
                        q.add(new int[]{nx, ny, a, b});
                        visited[nx][ny] = true;
                    } else {
                        if (nx != px || ny != py) { // check parent.
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }
}