import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Solution {
    private static int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int largestIsland(int[][] grid) {
        int n = grid.length;

        int max = 0;

        int[][] visited = new int[n][n];
        Map<Integer, Integer> areaByGroupIndex = new HashMap<>();
        int groupIdx = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && visited[i][j] == 0) {
                    int area = bfs(grid, visited, i, j, groupIdx);
                    max = Math.max(max, area);
                    areaByGroupIndex.put(groupIdx++, area);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    max = Math.max(max, getArea(i, j, areaByGroupIndex, visited, grid));
                }
            }
        }


        return max;
    }


    private static int getArea(int i, int j, Map<Integer, Integer> groupArea, int[][] visited, int[][] grid) {
        int area = 1;

        Set<Integer> groups = new HashSet<>();
        for (int[] dir : directions) {
            int x = i + dir[0], y = j + dir[1];
            if (isLand(x, y, grid)) {
                groups.add(visited[x][y]);
            }
        }

        for (Integer grp : groups) {
            area += groupArea.getOrDefault(grp, 0);
        }

        return area;
    }

    private static int bfs(int[][] grid, int[][] visited, int i, int j, int group) {

        Queue<int[]> queue = new LinkedList<>();
        int area = 1;
        queue.add(new int[]{i, j});
        visited[i][j] = group;

        while (!queue.isEmpty()) {
            int sz = queue.size();

            while (sz-- > 0) {
                int[] curr = queue.poll();
                for (int[] dir : directions) {
                    int x = curr[0] + dir[0], y = curr[1] + dir[1];

                    if (isLand(x, y, grid) && visited[x][y] == 0) {
                        queue.add(new int[]{x, y});
                        visited[x][y] = group;
                        area++;
                    }
                }
            }
        }


        return area;
    }


    private static boolean isLand(int x, int y, int[][] grid) {
        int n = grid.length;
        return x >= 0 && y >= 0 && x < n && y < n && grid[x][y] == 1;
    }
}