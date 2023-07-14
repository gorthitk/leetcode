class Solution {
    private static final int[][] DIRECTIONS = new int[][] {
            {1, 0}, {0, 1}, {-1, 0}, {0, -1}
    };

    public int getFood(char[][] grid) {
        int n = grid.length, m = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '*') {
                    queue.add(new int[] {i, j});
                    visited[i][j] = true;
                    break;
                }
            }
        }

        int steps = 0;
        while(!queue.isEmpty()) {
            int sz = queue.size();

            while (sz-- > 0) {
                int[] current = queue.poll();
                int i = current[0], j = current[1];

                if (grid[i][j] == '#') {
                    return steps;
                }

                if (grid[i][j] == 'X') {
                    continue;
                }

                for (int[] dir : DIRECTIONS) {
                    int a = dir[0] + i, b = dir[1] + j;

                    if (a >= 0 && b >= 0 && a < n && b < m && !visited[a][b]) {
                        queue.add(new int[] {a, b});
                        visited[a][b] = true;
                    }
                }

            }

            steps++;
        }


        return -1;
    }
}