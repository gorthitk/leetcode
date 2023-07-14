import java.util.HashSet;
import java.util.Set;

class Solution {
    private static final int[][] DIRECTIONS = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int numDistinctIslands(int[][] grid) {
        int n = grid.length, m = grid[0].length;


        Set<String> islands = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder sb = new StringBuilder();
                    find(i, j, grid, sb, i, j);
                    islands.add(sb.toString());
                }
            }
        }

        return islands.size();
    }

    private void find(int i, int j, int[][] grid, StringBuilder sb, int si, int sj) {
        int n = grid.length, m = grid[0].length;
        sb.append(i - si).append(",").append(j - sj).append('#');

        grid[i][j] = 0;

        for (int[] dir : DIRECTIONS) {
            int a = i + dir[0], b = j + dir[1];
            if (a < 0 || a >= n || b < 0 || b >= m) {
                continue;
            }

            if (grid[a][b] == 0) {
                continue;
            }

            find(a, b, grid, sb, si, sj);
        }
    }
}